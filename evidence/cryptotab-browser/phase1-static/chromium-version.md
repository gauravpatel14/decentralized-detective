# Chromium Version Analysis

## Fork point

`strings -a -n 8 <framework_binary> | grep -oE 'Chrome/[0-9.]+'` yields exactly one product version string:

```
Chrome/127.0.6533.100
```

`Info.plist` corroborates: `CFBundleShortVersionString = 127.0.6533.100`.

The `SCMRevision` key pins the exact upstream Chromium commit:

```
191cc1af405dffccb2a183efdcf0a370625f9b92-refs/branch-heads/6533@{#1911}
```

This is upstream Chromium's `refs/branch-heads/6533` (Chrome M127 release branch), commit `191cc1af40...`, position #1911 — i.e. one of the M127 dot-releases. Chrome 127.0.6533.99 / .100 was released by Google in **late August 2024**, which aligns with the **Apple notarization timestamp of 16 Aug 2024**.

## Staleness assessment (today: 2026-05-14)

| Property | Value |
|---|---|
| Bundled Chromium milestone | **M127** |
| Bundle notarization | 16 Aug 2024 |
| Today | 14 May 2026 |
| Approx. age of base | **~21 months old / 6 stable channels behind** (Chrome ships a new major roughly every 4 weeks). At the time of writing, Google's stable channel is on M130-ish from late 2024 going forward; by May 2026 stable is well into the M138+ range. |
| Known severe CVEs against M127 | All of M128, M129, M130, M131, M132 ... CVE bulletins apply — including multiple critical V8 / WebRTC / Skia RCEs that have been patched in upstream Chrome. CVE-2024-7964, CVE-2024-7965, CVE-2024-7971, CVE-2024-7976, CVE-2024-7977, CVE-2024-7978, CVE-2024-7979, CVE-2024-7980, CVE-2024-7981 were patched in **127.0.6533.99/100** — but every CVE patched in **128.x or later has NOT been applied to this binary.** |

**Bottom line:** users running this build are exposed to ~21 months of unpatched browser CVEs. This is the single biggest user-impacting finding of the static analysis. (See `summary.md`.)

## "Ungoogled" or vanilla Chromium?

The binary contains **vanilla Chromium with the Google services intact**:

```
http://update.googleapis.com/service/update2/json
https://update.googleapis.com/service/update2/json
https://tools.google.com/service/update2
https://safebrowsing.google.com/safebrowsing
https://safebrowsing.googleapis.com
https://safebrowsingohttpgateway.googleapis.com
https://fcm.googleapis.com
https://accountcapabilities-pa.googleapis.com
https://accounts.google.com
https://chromium.googlesource.com/chromium/src/...   (in error-message docs)
https://www.google.com/                              (NTP, omnibox suggest, etc.)
https://www.gstatic.com/
https://www.googletagmanager.com/
... and ~150 other googleapis / google.com hosts
```

There are **no "ungoogled-chromium" markers** (no `iridium`, no `ungoogled`, no Marmaduke/Eloston patch signatures, no `BUILD_TIME_MARKER_UNGOOGLED`, no `enable-ungoogled-flag-choices`). CryptoTab is **vanilla Chromium with selective additions** — they did not start from ungoogled-chromium.

What they *did* customize:

- Added the `chrome.cryptobrowser` extension API (the C++ files `chrome_miner.cc`, `cryptobrowser_api.cc`, `cryptobrowser_mining.cc`).
- Pre-installed the `cryptotab/` MV3 extension into `resources.pak` with the `cryptobrowser` permission whitelisted.
- Re-pointed Safe Browsing's v4 endpoint to `safebrowsing.cryptobrowser.today/v4` (in addition to keeping the Google endpoints).
- Replaced the default search engine with `search.cryptobrowser.site`.
- Renamed Keystone tags `KSBrandID`, `KSChannelID` (the keys exist; we did not see hardcoded values for them).
- Re-branded all the user-visible Chromium strings ("CryptoTab Browser" instead of "Chrome").

What they did **not** customize:

- The Omaha / Keystone update protocol URLs (`update.googleapis.com`, `tools.google.com`). These are still pointed at Google. **But there is no `ChromiumUpdater.app` / `ksadmin` binary bundled** (see below). The upstream update strings are dead code.
- The Google account sync URLs.
- The Google Translate / Lens / Search Suggest URLs.
- The FCM / Firebase URLs (CryptoTab actually uses these for its own push notifications via Firebase project `cryptobrowser`, project id `752301524429`).

## Auto-update mechanism

**No Google/Chromium auto-updater is bundled.**

- `install.sh` (Chromium's standard "copy myself to /Applications" helper at `<framework>/Versions/127.0.6533.100/Resources/install.sh`) tries to invoke:
  ```
  ${DEST}/Contents/Frameworks/Chromium Framework.framework/Helpers/ChromiumUpdater.app/Contents/MacOS/ChromiumUpdater --install --system
  ```
  (Note: the path even has the wrong-cased framework name `Chromium Framework` instead of `CryptoTab Browser Framework` — meaning this script was inherited from upstream and not adapted.) **That `ChromiumUpdater.app` is not present in the bundle.**
- `find "<app>" -iname '*Updater*' -o -iname 'ksadmin*'` returns **nothing**.
- There is no Sparkle framework (Mac app auto-update standard).
- The `Info.plist` has `KSChannelID` and `KSBrandID` referenced (Keystone keys) but does not include their values, and the Keystone client (`ksadmin`) isn't bundled.

So how does the browser update? **Almost certainly through the same channel that loads the rest of the app's business logic**: the `loader.js` service worker fetches `/api/v2/platform/pc/app?app_id=browser_desktop&v=<ver>&bid=<bid>` on every startup and `eval()`'s the remote JS response. The response is the operator's choice — it can include an in-extension prompt to download a new `.dmg` from `cryptobrowser.site`, schedule a `chrome.cryptobrowser.restart()`, or do nothing. The user-experience of "the browser updated itself" is therefore likely an **eval()-shipped script that downloads a new bundle and asks the user to relaunch**, not an OS-level Keystone update.

Implications:
1. There is **no cryptographically-checked Google-style differential update path** in this binary. Updates flow over plain HTTPS from `api.cryptobrowser.site` and require the user to trust the operator's TLS endpoint.
2. The operator can **selectively update individual users** (the `bid` parameter is sent on every fetch — likely a browser-instance ID — and the server can return different JS to different users).
3. If the operator wanted to push a malicious behaviour change without re-shipping a notarized binary, they could do so via the `eval()` path or via FCM `notification.data.code` — see `affiliate-mechanics.md`.

## Was the version current when notarized?

Yes. Chrome 127.0.6533.99/100 was released by Google on 2024-08-13. The notarization is 2024-08-16. So CryptoTab tracked upstream within ~3 days at release time.

The lapse since (no update found in the wild for ~21 months as of 2026-05-14) is therefore evidence of **slow / no maintenance**, not of "they were always far behind". This is consistent with a small team that does a major version bump every ~year or two (typical of forks like Brave used to be, or Iridium).

## Cited strings

| String | Tells us |
|---|---|
| `Chrome/127.0.6533.100` | The User-Agent / version pinned to M127 |
| `SCMRevision: 191cc1af405...refs/branch-heads/6533@{#1911}` | Exact upstream commit |
| `http://update.googleapis.com/service/update2/json` | Google Omaha URL still embedded (but no updater bundled) |
| `https://chromium.googlesource.com/chromium/src/+/refs/heads/main/` | Inherited upstream Chromium docs URL — no rebranding here |
| `KSChannelID`, `KSBrandID` | Keystone-key keys exist as strings (but no `ksadmin` to consume them) |
| `org.chromium.ChromiumUpdater.update` | Updater-related string from upstream code path that is dead in this build |
| absence of `ChromiumUpdater.app` anywhere in the .app | No auto-updater shipped |
| absence of "ungoogled" / "iridium" markers | Not derived from a privacy fork |
