# CryptoTab Affiliate / MLM Mechanics — Static Analysis

## TL;DR

**Static analysis alone cannot confirm or refute the reported 10-level deep MLM.** The bundled binary contains *no* affiliate-tier logic, no `level_1` ... `level_10` constants, no commission percentages, no referral-tree traversal code, no `cloud_boost` constants beyond the `BOOST_APP_ID` extension pointer. The affiliate engine almost certainly runs server-side — the bundled JS is a thin wrapper that loads UI from `api.cryptobrowser.site/api/v2/platform/pc/app` at startup and `eval()`s whatever JS the server returns.

The strongest static evidence we have for the *existence* of an affiliate/referral mechanism is indirect:

| Constant in loader.js | Value | What it implies |
|---|---|---|
| `INVITE_CTNFT` | `invite.ctnft.net` | An invitation/referral host, branded "CT NFT" |
| `CRYPTO_TAB_FARM_BASE_URL` | `cryptotab.farm` | Sister cloud-mining product (paid contracts) |
| `BOOST_APP_ID` | `kommlffgagciikldkpkedfjpmpofobch` | The "Cloud Boost" Chrome extension, installed on demand to boost mining speed (sold as a premium feature) |
| `WITHDRAW_PATH` | `withdraw/` | A withdraw page exists on `cryptobrowser.site` |
| `ENV_ACCESS_API_DOMAIN` | `api.ct-access.pro` | A secondary `ct-access.pro` API, likely for the affiliate portal |
| ruleset header injection | `X-CB-Data: ::3.0.12:` | The browser fingerprints itself on every request to `cryptobrowser.site` — extra colon-separated slots suggest more fields can be appended (probably referral ID at runtime) |
| Local-storage key | `current_version_browser` | Persisted state — implies the loader recognises the user across sessions |

## What we expected to find but didn't

A 10-level MLM tree usually leaves *some* binary footprint — common constants from public CryptoTab marketing materials are:

| Marketing term | Searched for | Hits in framework binary | Hits in JS bundles |
|---|---|---|---|
| "L1...L10" | `\bL[1-9]0?\b` | 0 of MLM-context | 0 of MLM-context (only "L1/L2" appears as variable names in minified JS) |
| "referral" / "Referral" | exact | 0 | 0 |
| "affiliate" / "Affiliate" | exact | 0 | only as Chromium PasswordManager `affiliatedDomains` (unrelated) |
| "promo" / "Promo" | exact | 0 in CT context | 0 in CT context |
| "commission" | exact | 0 | 0 |
| "bonus" | exact | 0 | 0 |
| "cloud_boost" / "cloudBoost" / "Cloud Boost" | case-insens. | 0 | 0 (only the `BOOST_APP_ID` constant pointing to the extension) |
| "rank" / "level" tied to user state | semantic | none | 0 (only Sentry log levels) |
| "invite_code" / "invite" | exact | 0 | only as `INVITE_CTNFT` constant + the word "invite" used in a translation key once |
| "withdraw" / "withdrawal" | exact | only Chromium autofill | only the `WITHDRAW_PATH: "withdraw/"` constant |
| Hardcoded BTC address (operator wallet) | regex `^(1|3|bc1)[a-zA-Z0-9]{25,42}$` | none (all matches were unrelated SHA hashes / extension IDs) | none |

This near-total absence of MLM-related strings in the static bundle is itself **strong evidence that the affiliate engine is implemented entirely server-side** — and that the client-side affiliate UI is part of the JS that's downloaded at startup and `eval()`'d (see `mining-protocol.md` and `summary.md`).

## The remote-JS bootstrap is the keystone

In `cryptotab/loader.js` (Manifest V3 service worker, carved out of `resources.pak`):

```javascript
try {
  const r = await fetch(
    "https://api.cryptobrowser.site/api/v2/platform/pc/app?app_id=browser_desktop&v=" + version + "&bid=" + bid,
    params
  );
  if (!r.ok) throw new Error("Network response was not ok.");
  const d = await r.json();
  if (!d.url) throw new Error(d.message || d);
  let res = await fetch(d.url);
  if (!res.ok) throw new Error("Network response was not ok");
  const script = await res.text();
  eval(script), error = false, chrome.runtime.onMessage.removeListener(onMessage);
} catch (e) { ... retry ... }
```

This means the **entire affiliate UI + business logic is loaded on every browser startup from a URL the server controls**. The static binary cannot tell us what the MLM rules are, because they are not in the binary.

The same loader.js also has two more `eval()` paths for FCM-pushed notifications:

```javascript
// notification click handler
const data = await result.json();
if (data.code) return eval(data.code);
// notification action handler
a.code && eval(a.code)
```

So a server-pushed Firebase Cloud Message can ship JS that runs in the extension's service-worker context — i.e. the operator can change behaviour without releasing a new binary.

## What the bundled JS actually does (loader.js architecture)

The carved `loader.js` (113 KB compressed → 371 KB readable) is a webpack bundle whose only "business" logic is:

1. Initialize Firebase Cloud Messaging (`AIzaSyDKvtNvxbPR4dl50GGvcV0odPuh-Lxd5DE` / project `cryptobrowser`).
2. On install / startup, read `current_version_browser` and `current_version_manifest` from the `chrome.cryptobrowser` storage.
3. POST to `https://api.cryptobrowser.site/api/v2/platform/pc/app?app_id=browser_desktop&v=<ver>&bid=<bid>` and fetch JSON `{url: "..."}`.
4. Fetch that URL → `eval()` the response. Retry with exponential backoff up to 10 s / 60 s.
5. Handle FCM `push` events: server can send `{type: "stored", url: ..., event_url: ..., meta: ...}` → fetch event data → display a `Notification`. Notification clicks call back to `event_url` with the user's `user_data` token, and the server's response can include a `code` field which is `eval()`'d.
6. Expose `chrome.cryptobrowser.get/set` to the rest of the extension.
7. Send Sentry telemetry to `snt.cryptobrowser.site/19` at 10% sample rate.

It does **not** implement any miner control, any user account, any referral or affiliate logic, any wallet display, any withdraw flow. Those are *all* in the remote JS that's `eval()`'d.

## What tab.js does (the new-tab page)

`tab.js` (the bundle the new-tab `cryptotab/tab.html` loads) is a React-based UI (348 KB un-minified). It contains:

- React 18 + ReactDOM render bootstrap
- i18n catalog (we extracted English + several other-language translations of `"It seems you don't have an Internet connection / Please connect to the Internet to access CryptoTab mining features and your account."`)
- A WebSocket client pointed at `wss://api.cryptobrowser.site/api/v2/ws`
- Firebase SDK
- The same ENV-constants block as loader.js
- ZERO direct calls to `chrome.cryptobrowser.workStart/workStop/setJob/onHashFounded/onHashRateStats`
- ZERO direct affiliate/MLM constants

The absence of mining API calls in `tab.js` is consistent with: the new-tab page is a placeholder shell; the **real** UI is served by the server-eval'd JS that `loader.js` fetches at startup, which talks to the WebSocket and proxies stratum jobs to the C++ miner via `chrome.cryptobrowser.setJob`.

## Cited strings (the most affiliate-relevant ones we did find)

| String | Source | Notes |
|---|---|---|
| `INVITE_CTNFT: "invite.ctnft.net"` | loader.js / tab.js | Invitation host for the "CT NFT" sister product — referral entry point |
| `BOOST_APP_ID: "kommlffgagciikldkpkedfjpmpofobch"` | loader.js / tab.js | Chrome extension ID for the "Cloud Boost" speed-multiplier (the standard CryptoTab cross-sell) |
| `CRYPTO_TAB_FARM_BASE_URL: "cryptotab.farm"` | loader.js / tab.js | Cloud-mining farm sister product (where paid contracts live) |
| `ENV_ACCESS_API_DOMAIN: "api.ct-access.pro"` | loader.js / tab.js | Secondary access API — could be the affiliate-portal API |
| `WITHDRAW_PATH: "withdraw/"` | loader.js / tab.js | Server-side withdraw page (BTC withdrawal goes through a web flow, not local key handling) |
| `https://api.cryptobrowser.site/api/v2/users/register` | loader.js | Account registration endpoint |
| `https://cryptobrowser.site/login/google-oauth2/?next=none` | framework binary | Google OAuth2 login is the supported sign-in flow (consistent with Firebase Auth for accounts) |
| `cryptobrowser.enableSyncFromPromo` | framework binary | A bespoke extension API method `enableSyncFromPromo()` exists — promo-triggered Chrome Sync — implies promo codes / referral links can trigger account-level state changes |
| `X-CB-Data: ::3.0.12:` header injection | ruleset_1.json | Always-on header stamps requests to `cryptobrowser.site`. The `::3.0.12:` format has empty slots before/after, suggesting fields like `<referral_id>:<extension_ver>:<bid>` will be filled in at runtime by the server-eval'd code. |

## Conclusion on the 10-level claim

**Static analysis can neither confirm nor refute the reported 10-level MLM.** The two facts to take into Phase 2 (network) are:

1. The browser fetches and `eval()`'s remote JS from `api.cryptobrowser.site/api/v2/platform/pc/app` on every startup. The MLM rules, referral-tree traversal, commission calculation, and tier-progression logic all run server-side and/or in that remote JS. To enumerate them statically you would have to capture the response of that fetch at runtime (Phase 2).
2. The operator has a runtime kill-switch / behaviour-change capability over the entire client via FCM-pushed `eval(data.code)`.

A reasonable Phase-2 plan: capture HTTPS traffic during account creation, log in, navigate the affiliate dashboard, and trigger one referral. The MLM payout rules will be encoded in REST responses from `/api/v2/...` or in the JS bundle that's eval'd from `/api/v2/platform/pc/app`.

## Note on the absent operator BTC address

There is **no hardcoded Bitcoin address** anywhere in the bundle. This is consistent with a model where:
- The user has a server-side BTC balance (not a local wallet).
- The user withdraws by giving the server a destination BTC address.
- The operator's hot wallet that funds payouts is server-side and never embedded in the client.

(Operator addresses can be discovered via Phase 3: trace the on-chain origin of the BTC the user actually received.)
