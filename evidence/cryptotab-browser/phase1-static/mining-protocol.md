# CryptoTab Mining Protocol — Static Analysis

## Headline finding

**CryptoTab implements an in-process CPU miner for Monero-family algorithms — primarily RandomX and the CryptoNight family — exposed to JavaScript via a custom `chrome.cryptobrowser.*` extension API. Mining jobs are pushed from the server over a WebSocket (`wss://api.cryptobrowser.site/api/v2/ws`); the miner runs natively inside the browser process. There is no stratum+tcp pool URL embedded in the binary.**

The "BTC mining" branding is therefore a UX/payout layer: the miner submits Monero-family hashes; the server (`api.cryptobrowser.site`) credits the user a BTC-denominated balance which becomes withdrawable through a `/withdraw/` flow (see `affiliate-mechanics.md`). The exchange-rate / payout-rate transformation happens on the operator's server, not on the client.

## Evidence: custom extension API surface

The Chromium fork ships a custom extension permission `cryptobrowser` (added to the `_features.json` in `resources.pak`, resource id 26200):

```json
"cryptobrowser": {
  "dependencies": ["permission:cryptobrowser"],
  "contexts": ["privileged_extension"]
}
```

The full IDL of the API is embedded verbatim in the main framework binary as a JSON blob (extracted by `strings | grep namespace.cryptobrowser`):

```json
{"namespace":"cryptobrowser",
 "events":[
   {"name":"onHashFounded","parameters":[
     {"type":"string","name":"job_id"},
     {"type":"string","name":"hash"},
     {"type":"integer","name":"nonce"}]},
   {"name":"onHashRateStats","parameters":[
     {"type":"integer","name":"hashrate"}]}
 ],
 "functions":[
   {"name":"get",               "parameters":[{"name":"name"}]},
   {"name":"set",               "parameters":[{"name":"name"},{"name":"val"}]},
   {"name":"isKioskModeOn"},
   {"name":"getSearchEnginesList"},
   {"name":"setDefaultSearchEngine", "parameters":[{"name":"num"},{"name":"choice_made_location"}]},
   {"name":"addSearchEngine",        "parameters":[{"name":"title"},{"name":"keyword"},{"name":"url"},{"name":"suggest_url"}]},
   {"name":"updateSearchEngine",     "parameters":[{"name":"num"},{"name":"title"},{"name":"keyword"},{"name":"url"}]},
   {"name":"addTopVisitedSite",      "parameters":[{"name":"url"},{"name":"title"},{"name":"thumb"},{"name":"favicon"}]},
   {"name":"installWebstoreItem",    "parameters":[{"name":"itemid"}]},
   {"name":"push",                   "parameters":[{"name":"itemid"},{"name":"version"},{"name":"name"}]},
   {"name":"workStart",              "parameters":[{"name":"threads_num"},
                                                   {"name":"algorithm"},
                                                   {"name":"assembly"}]},
   {"name":"workStop",               "parameters":[{"name":"pause"}]},
   {"name":"getSystemInfo",          "parameters":[{"name":"algorithm"},{"name":"max_cpu_usage"}]},
   {"name":"setJob",                 "parameters":[{"name":"job_id"},
                                                   {"name":"seed"},
                                                   {"name":"blob"},
                                                   {"name":"target"},
                                                   {"name":"height"},
                                                   {"name":"fb"}]},
   {"name":"enableSyncFromPromo"},
   {"name":"getAdditionalInfo"},
   {"name":"quit"},
   {"name":"restart"},
   {"name":"forceSync"},
   {"name":"setAsDefaultBrowser"},
   {"name":"getProfileStatus"},
   {"name":"setFaviconForUrl"},
   {"name":"showQrCodeForUrl"},
   {"name":"getVersion"}
 ]}
```

### Mining-relevant API methods

| Method | Direction | Meaning |
|---|---|---|
| `cryptobrowser.workStart(threads_num, algorithm, assembly)` | JS → C++ | Spin up `threads_num` CPU mining threads using the named algorithm. `assembly` selects RandomX JIT mode (asm-x86_64 / asm-arm64 / generic). |
| `cryptobrowser.workStop(pause)` | JS → C++ | Stop mining (or pause). |
| `cryptobrowser.setJob(job_id, seed, blob, target, height, fb)` | JS → C++ | Hand the miner a new job. **The five-tuple `(job_id, seed, blob, target, height)` is the exact RandomX stratum-job spec** (seed = key for RandomX dataset, blob = block-header template, target = difficulty target, height = chain height). `fb` is likely "first-byte" / `flags`. |
| `cryptobrowser.onHashFounded(job_id, hash, nonce)` | C++ → JS | Hashes that beat target are emitted as an event with the nonce. |
| `cryptobrowser.onHashRateStats(hashrate)` | C++ → JS | Periodic h/s metric for the UI. |
| `cryptobrowser.getSystemInfo(algorithm, max_cpu_usage)` | JS → C++ | Probe the CPU's capability for the given algorithm + report. |

The architecture is therefore: **the server speaks stratum-like protocol over the WebSocket to the loader.js, which forwards jobs to the C++ miner via `setJob`; the C++ miner returns valid nonces via `onHashFounded`; loader.js relays them back over the WebSocket.** The actual stratum / mining-pool protocol runs server-side; the client only ever talks to `api.cryptobrowser.site`.

This is **server-mediated stratum proxying** — common for browser miners because it (a) lets the operator front-run any pool failover, (b) hides their actual upstream pool, and (c) lets them rebrand the mined coin (Monero) as a BTC payout (the server can swap XMR → BTC internally before crediting).

### C++ source-file paths embedded in the framework binary

```
../../cryptotab/chrome/browser/extensions/api/cryptobrowser/chrome_miner.cc
../../cryptotab/chrome/browser/extensions/api/cryptobrowser/cryptobrowser_api.cc
../../cryptotab/chrome/browser/extensions/api/cryptobrowser/cryptobrowser_mining.cc
```

These are absolute, unstripped path strings from the build that confirm CryptoTab is a Chromium fork with three CryptoTab-authored C++ files. `chrome_miner.cc` is the miner thread, `cryptobrowser_mining.cc` glues the API to the miner, `cryptobrowser_api.cc` implements the non-mining methods (search engine, sync, kiosk).

## Evidence: which algorithms?

The binary contains **the full algorithm list from upstream xmrig** (the standard open-source Monero CPU miner). String dump (`strings | grep -iE 'cryptonight|randomx|argon2'`):

### RandomX variants
- `randomx/0`    (Monero, since fork v8 → present)
- `randomx/arq`  (ArQmA)
- `randomx/graft`
- `randomx/keva`
- `randomx/sfx`  (Safex)
- `randomx/wow`  (Wownero)
- `randomx/test`
- `RandomX-Graft`
- Plus error strings: `cant allocate randomx dataset`, `cant allocated randomx cache` (the [sic] typo confirms this is xmrig's RandomX implementation verbatim — xmrig's source has the same typo at `src/crypto/randomx/dataset.cpp`).

### CryptoNight family (used by Monero's predecessors and several altcoins)
```
cryptonight             cryptonight/0      cryptonight/1      cryptonight/2
cryptonight/r           cryptonight/rto    cryptonight/rwz    cryptonight/fast
cryptonight/half        cryptonight/double cryptonight/ultra  cryptonight/xao
cryptonight/zls         cryptonight/msr    cryptonight/ccx    cryptonight/conceal
cryptonight-monerov7    cryptonight-monerov8                  cryptonight_v7
cryptonight_v8          cryptonight_r
cryptonight-lite        cryptonight-lite/0  cryptonight-lite/1  cryptonight_lite_v7
cryptonight-heavy       cryptonight-heavy/0 cryptonight-heavy/tube  cryptonight-heavy/xhv
cryptonight-pico        cryptonight-pico/trtl cryptonight-pico/tlo
cryptonight-aeonv7      cryptonight-bittube2
cryptonight-talleo      cryptonight_talleo
cryptonight-turtle      cryptonight_turtle
cryptonight-ultralite
cryptonight_alloy       cryptonight_haven
cn/double  cn/ultra  cn/conceal
```

### Argon2 (for password-hashing coins like Chukwa)
```
Argon2id
argon2id
```

### What this looks like
This is a **near-verbatim copy of xmrig's algorithm enumeration** (xmrig is the canonical open-source CPU miner for the CryptoNight/RandomX coin family). The presence of "RandomX-Graft" — a specific xmrig branch maintained for Graft network — is a tell: a CryptoTab-only miner would not bother shipping support for every fork. They almost certainly **statically linked xmrig** (or a hard-fork of it) into the framework.

## Evidence: stratum-style job fields, but no stratum URL

- `setJob(job_id, seed, blob, target, height, fb)` parameter names map 1:1 to fields in a stratum mining notify (RandomX dialect):
  - `job_id` → `params[0]`
  - `blob`   → `params[1]` (block header template, hex)
  - `seed`   → `params[2]` (RandomX seed-hash, hex)
  - `target` → `params[3]` (compact target / difficulty)
  - `height` → `params[4]` (block height for RandomX dataset switching)
- `onHashFounded(job_id, hash, nonce)` maps to a stratum `submit`:
  - `result.hash` = computed PoW hash, `result.nonce` = winning nonce
- Tellingly, **no `stratum+tcp://`, `pool.<anything>:port`, or TLS stratum strings exist anywhere in the bundle.** The server proxy hides the upstream pool.

## Where the WebSocket lives

From `cryptotab/loader.js` (carved from `resources.pak`):

```
REACT_WS_URL: "wss://api.cryptobrowser.site/api/v2/ws"
```

There is a single WebSocket endpoint and there are no other mining-related URLs. This is the channel over which the server pushes mining jobs and the client reports hash submissions.

## Conclusion

| Question | Answer |
|---|---|
| Does it use stratum+tcp? | No — only as an internal job format. Network transport is **HTTPS + WebSocket** to a CryptoTab-controlled server. |
| Does it mine in WebAssembly? | No. Mining is a **native C++ in-process thread** in the browser framework binary (the JIT-friendly entitlements `allow-jit` + `allow-unsigned-executable-memory` + `disable-executable-page-protection` enable the RandomX JIT runtime). |
| What hashing algorithms are supported? | RandomX + the full CryptoNight family + Argon2id — i.e. xmrig's complete catalog. |
| Does it mine BTC directly? | **No.** The PoW algorithms are Monero-family (RandomX = current Monero PoW, CryptoNight = pre-October-2019 Monero PoW). The "BTC" the user receives is **server-credited and presumably converted by the operator** — most likely XMR → BTC via a pool/exchange swap on the operator's side. |
| Is there evidence of cloud-mining contracts? | Yes (indirect). The JS bundle references `CRYPTO_TAB_FARM_BASE_URL: "cryptotab.farm"`, a `BOOST_APP_ID` (`kommlffgagciikldkpkedfjpmpofobch` — the "Cloud Boost" extension), and a `WITHDRAW_PATH: "withdraw/"`. The actual cloud-mining product lives on `cryptotab.farm`, not in the binary. |
| Stealth / silent-miner red flags? | The miner only starts via `workStart` from JS, which only runs inside the bundled CryptoTab extension's new-tab page, which the user must open. There is no auto-start hook from `Info.plist`, no LaunchAgent in the bundle, no XPC service. **However**, the loader.js service worker `eval()`'s arbitrary remote JS at startup (see `summary.md` — the `/api/v2/platform/pc/app` bootstrap), so the operator can change this behaviour at any time without shipping a new binary. |

## Cited strings

| String | File | What it tells us |
|---|---|---|
| `../../cryptotab/chrome/browser/extensions/api/cryptobrowser/chrome_miner.cc` | framework binary | The miner is a CryptoTab-authored C++ Chromium extension internal |
| `cant allocate randomx dataset` (sic) | framework binary | xmrig is statically linked |
| `randomx/0` ... `randomx/wow` | framework binary | Current Monero PoW + 5 altcoin variants supported |
| `cryptonight/r`, `cryptonight-pico/trtl`, ... | framework binary | Pre-2019 Monero PoW + many CryptoNight forks |
| `cryptobrowser.setJob` IDL with `(job_id,seed,blob,target,height,fb)` | framework binary | Confirms stratum-style RandomX job dialect, server-proxied |
| `cryptobrowser.workStart` with `(threads_num, algorithm, assembly)` | framework binary | Caller picks # threads + algorithm + JIT-assembly mode |
| `wss://api.cryptobrowser.site/api/v2/ws` | cryptotab/loader.js | Server-mediated WebSocket transport for stratum jobs |
| `Argon2id` | framework binary | Argon2id support (for Chukwa / a few Argon2 coins) |
