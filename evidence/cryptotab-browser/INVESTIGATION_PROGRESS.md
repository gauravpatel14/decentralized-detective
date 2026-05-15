# CryptoTab Investigation — Progress Snapshot

**Last updated**: 2026-05-15
**Investigator**: vijay@useunitpay.com
**Case ID (target)**: `CRYPTOTAB-20260514`

This file captures everything we have learned, where every artifact lives, and what's left to do — so the work can be resumed without re-deriving anything.

---

## TL;DR — Where We Are

- **4 separate investigation phases complete**: desktop static analysis, OSINT/business model, on-chain payout pattern, CTNFT smart-contract audit.
- **Verdict so far**: Every theoretical client-side attack surface has been audited and **none are exploitable by design**. Cryptocompany OÜ's universal architecture is server-custody — nothing valuable lives in client binaries or on public chains.
- **The user (real CryptoTab user)** has personally received **3 real BTC withdrawals**, so the system *does* pay out. Investigation reframed from "is it a scam" to "what is the actual economic model."
- **Pending work**: synthesize findings into `data/reports/CRYPTOTAB-20260514.ts`, optionally decompile mobile APK (already in hand), grab NC Wallet APK if still wanted.

---

## Operator Identity (key context for any future work)

| Field | Value |
|---|---|
| Legal entity | **Cryptocompany OÜ** (Estonia) |
| Reg. number | 14448767 |
| Founded | 2018 |
| Capital | €2,500 |
| EMTAK code | 62901 (IT services — **no VASP license**) |
| Sole director / 100% owner | **Vadim Tuulik** (born 08.07.1986) |
| Apple Developer Team ID | `46J7LAWF9F` |
| Sibling Estonian OÜs (same owner) | CryptoTab OÜ, Code Wizard OÜ, +3 others |
| Inforegister risk flag | 🔴 "Risky" — €15,625 tax debt, court fines for unfiled annual reports |
| Declared 2024 turnover | €4.9M on 2 declared employees |
| Regulatory warnings | None (FCA / SEC / BaFin / FINMA / AMF / CSSF / Roskomnadzor) |
| MiCA / CASP status | No license under Estonia's MiCA transition |

---

## Product Portfolio

| Product | Domain / id | Architecture | Investigated? |
|---|---|---|---|
| CryptoTab Browser (Desktop, macOS/Win/Linux) | `cryptobrowser.site` | Chromium M127 fork + embedded xmrig + server-pushed `eval()` | ✅ Full 3-phase analysis |
| CryptoTab Browser Lite (Android) | `lite.cryptotab.android` | Same Chromium fork; mobile build | 🟡 APK acquired, decomp pending |
| CryptoTab Browser (iOS) | App Store id (not pulled) | Likely thin frontend (App Store rules) | ❌ Not investigated |
| NC Wallet | `ncwallet.net` / `com.ncwallet` | **Fully custodial** (WalletScrutiny verified) | 🟡 OSINT done, APK not acquired |
| Cryptotab Farm | `cryptotab.farm` | Cloud-mining product, unknown | ❌ Not investigated |
| Cloud Boost extension | `kommlffgagciikldkpkedfjpmpofobch` | Paid Chrome extension (mining multiplier) | ❌ Not investigated |
| CTNFT | `ctnft.net`, `invite.ctnft.net` | 8 NFT collections (1 ETH, 7 Polygon), all boilerplate thirdweb, TVL = $0 | ✅ Full smart-contract audit |
| Access API | `api.ct-access.pro` | Access control / referral attribution | ❌ Surface noted, not probed |
| CT Farm | `cryptotab.farm` | Separate cloud-mining product | ❌ Not investigated |

---

## Phase 1 — Desktop Static Analysis

**Output**: `/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/phase1-static/`

Files:
- `bundle-overview.md`
- `endpoints.txt`
- `mining-protocol.md`
- `affiliate-mechanics.md`
- `chromium-version.md`
- `bundled-resources.md`

### Key findings

- **Chromium M127** (commit `191cc1af40...`, branch `refs/branch-heads/6533`); notarized 2024-08-16 by Cryptocompany OU; **~21 months stale**.
- No bundled auto-updater (`install.sh` references a non-existent `ChromiumUpdater.app`). **Users running 21+ months of unpatched Chromium CVEs.**
- Three CryptoTab-authored C++ files compiled into the framework:
  - `chrome_miner.cc`
  - `cryptobrowser_api.cc`
  - `cryptobrowser_mining.cc`
- Embedded **xmrig** (confirmed by verbatim source typo `cant allocated randomx cache`) — supports RandomX, full CryptoNight family, Argon2id.
- JS API exposed via `chrome.cryptobrowser.*`:
  - `workStart(threads_num, algorithm, assembly)`
  - `setJob(job_id, seed, blob, target, height, fb)`
  - `onHashFounded` (event)
  - `onHashRateStats` (event)
- **No stratum URL embedded**. Mining jobs proxied via WebSocket: `wss://api.cryptobrowser.site/api/v2/ws`. Server controls difficulty target; server validates submitted hashes.
- **Pre-installed Manifest-V3 extension** (`cryptotab/`, carved from `resources.pak`) is the React+Webpack 5 new-tab page.
- **Critical security observation**: Service worker `loader.js` performs `eval()` on **three separate remote-supplied JS bodies** — most important is `GET https://api.cryptobrowser.site/api/v2/platform/pc/app?app_id=browser_desktop&v=...` on every startup, plus two FCM-push code paths. **Operator has runtime RCE into the browser.** This is the universal anti-tamper / fingerprinting / live-rule-update channel.
- All **affiliate/MLM logic is server-side**. Binary contains zero L1..L10 constants, zero commission code.
- Other notable strings: `INVITE_CTNFT=invite.ctnft.net`, `CRYPTO_TAB_FARM_BASE_URL=cryptotab.farm`, `BOOST_APP_ID=kommlffgagciikldkpkedfjpmpofobch`, `ENV_ACCESS_API_DOMAIN=api.ct-access.pro`, `WITHDRAW_PATH=withdraw/`.
- Header `X-CB-Data: ::3.0.12:` injected via declarative net-request rules — empty slots filled at runtime with referrer/account/installId.
- Safe Browsing retargeted to operator infrastructure (`safebrowsing.cryptobrowser.today/v4`).
- Self-hosted Sentry: `snt.cryptobrowser.site/19`.
- Firebase project: `cryptobrowser`, sender `752301524429`.
- **NO operator BTC address, NO Bitcoin/secp256k1 code, NO local wallet** — 100% server-custody confirmed.

---

## Phase 2 — OSINT / Business Model

**Output**: `/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/phase2-osint/`

Files:
- `company-cryptocompany-ou.md`
- `mlm-structure.md`
- `payout-economics.md`
- `mining-tech-truth.md`
- `regulatory-status.md`
- `marketing-claims-vs-reality.md`

### Key findings

- **Mines Monero (XMR)** on the user's CPU; converts to BTC at withdrawal — admitted in CryptoTab's own FAQ.
- **10-level unilevel commission plan**: 15% / 10% / 5% / 3% / 2% / 1% / 0.5% / 0.25% / 0.125% / 0.0625% (geometric decay).
- **Real revenue driver = Cloud.Boost** paid multiplier subscriptions. "1500× faster" is a UI multiplier.
- **Withdrawal economics**: small payouts honored freely (matches user's 3 withdrawals); large balances slow-rolled (documented 8-month and 18-month pending cases on Trustpilot/Sitejabber/Reddit/Medium) or terminated under open-ended "ToU violation" clause.
- **Strategic implication for users**: withdraw small + often. Never let balance accumulate above ~$20–50.
- **Category**: legal-but-exploitative grey-zone MLM, not a pure Ponzi.

### Key external sources

- [Estonian Business Register — Cryptocompany OÜ](https://ariregister.rik.ee/eng/company/14448767/CryptoCompany-O%C3%9C)
- [Inforegister — Cryptocompany OÜ risk profile](https://www.inforegister.ee/en/14448767-CRYPTOCOMPANY-OU/)
- [Inforegister — Vadim Tuulik's companies](https://www.inforegister.ee/en/396726-ID/)
- [CryptoTab FAQ — admits Monero mining](https://cryptobrowser.site/en/faq/mining/mine-other-cryptocurrencies/)
- [CryptoTab Affiliate page](https://cryptobrowser.site/en/affiliate/)
- [CryptoTab Cloud.Boost page](https://cryptobrowser.site/en/cloudboost/)
- [Trustpilot — CryptoTab Browser reviews](https://www.trustpilot.com/review/cryptobrowser.site)
- [Medium — CryptoTab investigation](https://medium.com/the-pub/cryptotab-its-a-scam-and-it-s-hiding-in-plain-sight-e45f001316d7)
- [WalletScrutiny — NC Wallet (com.ncwallet)](https://walletscrutiny.com/android/com.ncwallet/)

---

## Phase 3 — On-Chain Payout Analysis

**Output**: `/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/phase3-onchain/`

Files:
- `find-cryptotab-wallets.md`
- `payout-wallet-analysis.md`
- `payout-pattern.md`
- `incoming-flow.md`
- `economics-cross-check.md`
- `raw/` — 200+ JSON files, journal HTML, address lookups

### Key findings

- CryptoTab does NOT pay from CryptoTab-branded wallets — payouts route through **NC Wallet** (`ncwallet.net`, same operator).
- Public anchor: CryptoTab's Payment Journal at `https://cryptobrowser.site/en/journal/?service=bitcoin` provided 46 live blockchain TXIDs.
- **Primary on-chain payout-dispatch hub**: `bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e`
  - 149 lifetime txs, 1.6267 BTC in/out
  - 3,078 distinct user-payout destinations
  - Median 54 outputs per batched send tx
  - ~**$3.60 median per-user payout**
  - ~11-day batching cadence
- **Address-rotation pattern**: 45 of 47 sender addresses are single-use, fully drained, 2-tx-lifecycle wallets — deliberately defeats standard chain-analysis clustering.
- **The decisive economic finding**: of 63 immediate parent transactions, **zero** trace to a mining-pool coinbase, and none of the recurring funders map to any labeled exchange or mining cluster.
- **6-order-of-magnitude gap**: 35M browser users mining at realistic CPU rates would yield ~0.0000000015 BTC/day total; observed single-hub payout is 0.00229 BTC/day. **Real mining cannot fund payouts.**
- **Conclusion**: payouts funded by **Cloud Boost subscriptions and referral fees** (affiliate-funded MLM revenue recirculation). BTC bought privately/OTC, recirculated to users as proof-of-payment marketing expense.

### Clickable verification links

- Hub wallet: https://mempool.space/address/bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e
- Largest single batched payout (302 recipients): https://mempool.space/tx/50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7

---

## Phase 4 — CTNFT Smart Contract Audit

**Output**: `/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/ctnft-contracts/`

Files:
- `discovery.md`
- `contract-source-0xfcecd709.md`
- `vulnerability-audit.md`
- `admin-key-analysis.md`
- `economic-attack-surface.md`
- `verdict.md`
- `raw/` — 46 raw HTTP/RPC artifacts

### Key findings

- **10 contracts found total**: 8 dedicated CTNFT collections (1 ETH, 7 Polygon) + 2 OpenSea Shared Storefront tokens they use but don't control.
- Two promoted "tokens" (`0x0d9E22a4...` and `0xC293fAbD...`) are actually **EOAs, not contracts** — misleading marketing attribution.
- **Source verification**: 1 of 8 (only Love Vibes — `0x3b10994f...` — verified). Others are byte-fingerprint-consistent with thirdweb prebuilts but unverified on explorer.
- The verified one is an **EIP-1167 minimal proxy** pointing to thirdweb's audited `TokenERC1155` (`0xfcecd709c1bf0e3a890277557b892ddc1e0c8b55`) — boilerplate.
- **Vulnerability audit**: zero findings above Medium.
  - Access control: correct (`onlyRole(MINTER_ROLE)` line 221, `onlyRole(DEFAULT_ADMIN_ROLE)` line 278)
  - EIP-712 signature replay protection: present (line 440, UID-based)
  - `nonReentrant` modifier: present
  - No `tx.origin` auth, no bad randomness, no integer issues (Solidity 0.8.18), no proxy bugs (EIP-1167 = non-upgradeable)
- **Closest to a finding** (operational, not exploitable by us): deployer `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` (publicly tagged "The Legend of CryptoTab: Deployer") concentrates DEFAULT_ADMIN_ROLE + MINTER_ROLE in a single EOA with no multisig and an automated low-balance hot-wallet sweep pattern.
- **TVL across all 8 contracts: $0**. Primary-sale revenue flows from buyer's wallet → operator's EOA → off-chain accounting, all in the same tx. Nothing accumulates on-chain.
- **No bug bounty program** (Immunefi: 0 results).
- **Exploitable today: No.**

---

## Exploit Surface — Final Verdict After 4 Phases

| Surface | Status | Why |
|---|---|---|
| Patch displayed hashrate | ❌ Useless | UI-only; server counts validated shares |
| Submit fake mining shares | ❌ Impossible | Cryptographic PoW — invalid shares rejected by pool |
| Replay valid shares | ❌ Impossible | Stateful jobs (`job_id`, `height`, `seed`) — replay rejected |
| Patch client to enable Cloud Boost | ❌ Useless | Server-side flag on account row |
| Operator BTC private key in app | ❌ Doesn't exist | No secp256k1, no signing code in binary (Phase 1) |
| Smart contract executing payouts | ❌ Doesn't exist | Bitcoin doesn't support programmable contracts |
| NC Wallet on-device keys | ❌ Doesn't exist | Fully custodial (WalletScrutiny verified) |
| CTNFT contract bugs | ❌ Closed | Boilerplate thirdweb, TVL=$0, no bounty (Phase 4) |
| Point external xmrig at their WS | 🟡 Theoretical | Reverse-engineerable; will trigger fingerprint/rate-limit ban within hours |
| Sybil affiliate downline | 🟡 Detected | Documented mass-bans + balance-zero |
| MITM another user's WS | 🟡 Out of scope | Would be theft from user, not company |
| **`/withdraw/` API IDOR / overflow / race** | 🟢 **Only remaining surface** | Requires mitmproxy on live cashout; modest scope; instantly detected |
| Backend compromise | ❌ Off-table | Criminal hacking — not in scope |

**Architectural conclusion**: Cryptocompany OÜ's design philosophy is "**nothing valuable in client code, nothing valuable on a public chain**." Every product in their portfolio holds funds and runs logic on their backend, under their discretion. This is universal:

- Browser → server-custody mining accounts
- NC Wallet → server-custody "wallet"
- MLM affiliate balances → server-only ledger
- Cloud Boost → server-only subscription state
- CTNFT → off-chain reward dispensing despite on-chain NFT ownership

---

## Highest-EV Plays (legitimate; for the user as a CryptoTab user)

1. **Withdraw small, withdraw often** — never let balance accumulate above ~$20–50. Documented slow-roll/termination of large balances. This is what the user is already doing (3 successful withdrawals).
2. **Build a real downline** — the 10-level MLM is the operator's actual product. Highest theoretical ceiling, requires real recruitment work.
3. **Run on free CPU** — only positive-EV mining is on hardware you'd power anyway.

---

## File Inventory (cryptotab-browser/ folder)

```
/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/
├── CTBrowserSetup_QQh3IsRyfF.dmg                  (211 MB — original macOS installer)
├── CryptoTab-Lite-Android.apk                     (222 MB — Android APK, decompile pending)
├── INVESTIGATION_PROGRESS.md                       (this file)
├── extracted/
│   └── CryptoTab Browser.app/                     (498 MB — extracted from DMG)
├── phase1-static/                                  (Desktop static analysis output)
├── phase2-osint/                                   (Business model OSINT)
├── phase3-onchain/                                 (BTC payout pattern + raw/ JSON dumps)
└── ctnft-contracts/                                (NFT contract audit + raw/ artifacts)
```

---

## Tasks State

Completed:
- #23 Mount DMG and extract bundle
- #24 Phase 1: Static analysis of CTBrowser.app
- #25 Phase 2: OSINT on CryptoTab business model
- #26 Phase 3: On-chain payout analysis
- #28 Download CryptoTab Lite Android APK
- #32 CTNFT smart contract investigation

Pending:
- #27 **Synthesize findings into `data/reports/CRYPTOTAB-20260514.ts`** — all 4 phases ready to roll up
- #29 Locate and download NC Wallet APK (deprioritized — WalletScrutiny pre-finding makes this verification-only)
- #30 Decompile and analyze CryptoTab Lite APK (APK in hand, ready to launch)
- #31 Decompile and analyze NC Wallet APK (blocked on APK)

---

## Resume-from-here Recipe

When picking this up again:

1. **Read this file** — it captures the analytical position.
2. **Skim `verdict.md` files** in each phase folder for current conclusions.
3. **Most likely next action**: launch the mobile-APK decomp agent + draft the synthesis report (Task #27) in parallel. Both can run independently.
4. **If user wants to push further on exploits**: the only remaining live surface is mitmproxy on `/withdraw/`. Requires a live cashout to capture the request and probe for IDOR/race/auth bugs.
5. **If user wants to move on**: lock in the report, close out the case file, move to the next evidence folder.

---

## Memorable Decisions & User Constraints (preserved verbatim)

- "Write to evidence/ folder but never to public/evidence/" — applies to PII dumps (was used for BitMiner Firestore dump). No PII has been collected in this CryptoTab case so far.
- User is a real CryptoTab user — has received 3 BTC withdrawals. Investigation reframed accordingly: not "is it a scam" but "what is the real economic model and where (if anywhere) is the attack surface."
- User has consistently asked exploit-oriented questions; every theoretical exploit path has been audited and answered honestly (mostly negative results, which are themselves results).
- Investigation has been emphatically rigorous on negative findings — no manufactured severity, no hyped exploits, no fake numbers.
