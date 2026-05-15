# CryptoTab Browser Lite Android vs. CryptoTab Browser macOS Desktop -- Side-by-Side Diff

Source for desktop column: Phase 1 static analysis writeups in `evidence/cryptotab-browser/phase1-static/`.
Source for mobile column: this folder.

| # | Property from desktop Phase 1 | Desktop (macOS) | Mobile Android (Lite v6.2.34) | Status |
|---|---|---|---|---|
| 1 | **Chromium base version** | M127 (~21 months stale) | **M128 (`128.0.6613.148`)** -- one major version newer, ~18-20 months stale | **DIFFERENT** |
| 2 | **xmrig native miner bundled inside libchrome** | Yes (`cant allocated randomx cache` verbatim source typo; full RandomX cache code) | **NO.** Zero hits for `xmrig`, `randomx`, `cryptonight`, `argon2`, `RX_FLAG_`, `stratum`, `wss://`. Native binary cannot mine. | **NOT FOUND** |
| 3 | **WebSocket job endpoint** | `wss://api.cryptobrowser.site/api/v2/ws` (verbatim in desktop libchrome) | No `wss://` URLs anywhere in the APK. No WebSocket client initialization for the operator. | **NOT FOUND** |
| 4 | **`chrome.cryptobrowser.workStart / setJob / onHashFounded / onHashRateStats` JS API surface** | All four names present as Chromium IDL-registered extension API symbols | NONE of the four names present in libchrome.so OR classes.dex. The C++ WebUI handler at `chrome/browser/ui/webui/cryptobrowser/webui_message_handler.cc` IS registered (so `chrome://cryptotabdash/` works), but no IPC surface for mining was found. | **NOT FOUND** |
| 5 | **`eval()` of remote-supplied JS bodies** | Yes (service worker `loader.js` performs `eval()` on three remote responses including `GET /api/v2/platform/pc/app`) | No equivalent native + service-worker bootstrap. The mobile build does load `cryptobrowser.site/mobile/android` in a webview which itself can execute remote JS, but no client-side `eval()` of operator-controlled blobs was found in DEX. | **DIFFERENT** |
| 6 | **Self-hosted Safe Browsing** | `safebrowsing.cryptobrowser.today/v4` (operator MITM of phishing/malware blocklist) | **NO.** Mobile uses standard `safebrowsing.googleapis.com/v4` + `sb-ssl.google.com/safebrowsing/clientreport/*`. | **NOT FOUND** |
| 7 | **Self-hosted Sentry** | `snt.cryptobrowser.site/19` (operator-receives crash reports including potentially PII URLs / stack traces) | **NO.** Crashpad default URL is the unconfigured `crashpad.chromium.org/`. No `snt.` host anywhere. Crash reporting on mobile relies on Play Store / Firebase pipeline (if anything). | **NOT FOUND** |
| 8 | **Custom FCM project `cryptobrowser`, sender `752301524429`** | Yes (in `Info.plist` / firmware) | **NOT in the APK.** Standard FCM endpoints (`fcm.googleapis.com`, `firebaseinstallations.googleapis.com`) are used. The actual `google-services.json` / FCM project ID would be inside the chrome split module's resources, which we do not have. Probable, but not confirmed. | **UNKNOWN** (likely present in split) |
| 9 | **`api.ct-access.pro` (auth/access API)** | Yes | **NOT in this APK** (no string match anywhere). | **NOT FOUND** |
| 10 | **`invite.ctnft.net`** | Yes | **NOT in this APK** (one false-positive `ctnft` match was in a Chromium autofill domain list). | **NOT FOUND** |
| 11 | **`cryptotab.farm` (Boost backend)** | Yes (`CRYPTO_TAB_FARM_BASE_URL=cryptotab.farm`) | **NOT in this APK**. | **NOT FOUND** |
| 12 | **`BOOST_APP_ID=kommlffgagciikldkpkedfjpmpofobch` (Chrome Boost companion extension)** | Yes | **NOT in this APK** (Chromium-on-Android does not support traditional extensions, so absence is expected). | **NOT FOUND, EXPECTED** |
| 13 | **`api.cryptobrowser.site` (general API)** | Yes (heavy use) | **YES, present in classes.dex but NOT in libchrome.so.** Used by `Qu1.java` to register FCM tokens (`/api/v2/fcm/register`) and `C0717gY.java` to register the device (`/api/v2/devices/register`) with Google Advertising ID. | **FOUND** |
| 14 | **`pool.cryptobrowser.site`** | Not specifically called out in Phase 1 | YES (sidebar link `https://pool.cryptobrowser.site/landing`). | **FOUND, NEW** |
| 15 | **Affiliate L1..L10 constants in binary** | NO (server-side) | NO (same -- only route paths like `/affiliate/dashboard`, `/affiliate/referrals`, `/affiliate/boost` are hard-coded; all logic is server-rendered). | **MATCHES** |
| 16 | **Operator BTC address / hot wallet address** | NO (custodial) | NO (same). | **MATCHES** |
| 17 | **Bitcoin / secp256k1 / BIP32 / mnemonic code** | NO | NO (same -- only Chromium WebCrypto/WebAuthn refs to `java.security.PrivateKey`, unrelated). | **MATCHES** |
| 18 | **Local key storage / on-device wallet** | NO | NO (same). | **MATCHES** |
| 19 | **Auto-updater present** | Effectively NO (Phase 1 found no working auto-update path) | **Structurally different**: Play Store handles updates. The Chromium-internal Omaha / ComponentUpdater plumbing IS in libchrome.so (4-8 string hits) but the actual update URL is the Chrome default, not an operator-controlled one. App-level binary updates happen exclusively via Play Store. | **DIFFERENT (architecturally)** |
| 20 | **Anti-tamper / Frida / Xposed detection** | Not applicable (desktop binary not hardened either) | **NOT PRESENT.** No SafetyNet / Play Integrity attestation. No root-detection (`/system/bin/su`, `test-keys`, `re.frida.server`). No `ptrace`-based debugger checks (the 6 `ptrace` hits are libc/Chromium internals, not tamper-detection). The app makes no effort to detect or resist runtime instrumentation. | **MATCHES (not hardened)** |

## Things in mobile that don't exist on desktop

| # | Mobile-only finding | Significance |
|---|---|---|
| M1 | **Tenjin SDK** declared via `meta-data TENJIN_APP_STORE=googleplay` | Mobile attribution platform. Reports install/conversion events to `*.tenjin.com`. Used by the operator to measure affiliate ad-spend efficiency. |
| M2 | **`/api/v2/devices/register` reports Google Advertising ID + Firebase App Instance ID + Firebase Dynamic Link + Play install referrer** on first launch | Stronger cross-app tracking than the desktop equivalent. The GAID lets the operator correlate this app's user with all other apps the same GAID has used. |
| M3 | **Sidebar shortcut `https://ncwallet.net/benefits`** as a first-class entry alongside CT Pool and CB Game | NCWallet is more visible / pushed harder on mobile than on desktop. |
| M4 | **`REQUEST_INSTALL_PACKAGES` permission** | Allows the app to launch APK install intents -- a vector for socially-engineered side-load if a user is tricked into clicking "install this update" inside a webview. (Chrome stable also requests this, so not unique, but worth noting for a "free mining browser" with the audience CryptoTab targets.) |
| M5 | **`QUERY_ALL_PACKAGES`** | Lets the app enumerate the user's full installed package list. Often considered borderline and disallowed by Play unless justified. The likely justification is `Get_Install_Referrer` + intent resolution. Combined with reporting back to `api.cryptobrowser.site/api/v2/devices/register`, this means the operator could (if they wished) learn what other apps you have installed. We did not find DEX code that ships this back, but the capability is present. |
| M6 | **`READ_CONTACTS` (sdk23+ flag)** | Inherited from stock Chromium (for autofill), but still requested. |
| M7 | **`com.android.stamp.source = https://play.google.com/store`** + `STAMP_TYPE_DISTRIBUTION_APK` | The APK carries the Google Play stamp, meaning Play scanned the APK at distribution time. Sideloaded copies that lack this stamp would still install but would trigger a Play Protect warning on first launch. |
| M8 | **`isolatedSplits="true"` + missing `chrome__module` split** | The base APK is essentially a stub: the launcher activity, the main UI, the JNI Java code for the CryptoTab class (`org/chromium/chrome/browser/util/CryptoTab`), all live in feature-split APKs that Play delivers separately. **We have not been able to analyze that split.** Anything definitive about mining IPC / WebSocket use / `chrome.cryptobrowser.*` API will require also obtaining `chrome__module.apk`. |
| M9 | **Network security config explicitly allows cleartext + user CAs** | Identical posture to desktop (no pinning), but the explicit `cleartextTrafficPermitted="true"` is more visible in mobile's XML config. |
| M10 | **arm64-only build** (no armeabi-v7a, no x86) | The app refuses to install on 32-bit-only Android devices (mostly older / cheaper). |

## Things in desktop that explicitly do NOT exist on mobile (privacy/security wins for mobile)

| # | Desktop has | Mobile lacks | Implication |
|---|---|---|---|
| W1 | Self-hosted Safe Browsing (`safebrowsing.cryptobrowser.today`) | Yes, lacks it -- uses Google's | Mobile users don't have to trust the operator's blocklist; they get Google's. |
| W2 | Self-hosted Sentry (`snt.cryptobrowser.site/19`) | Yes, lacks it -- Crashpad default | Mobile crashes (which can leak page URLs, query strings, stack traces) do NOT flow back to the operator. |
| W3 | `eval()` of remote JS bodies in a service worker (`/api/v2/platform/pc/app`) | No equivalent mechanism in the base APK or libchrome.so | Mobile lacks the operator-RCE / anti-tamper channel that desktop has. |
| W4 | xmrig native miner | No native miner at all | Mobile cannot directly perform RandomX hashing on the device using native code. (Whether the webview-loaded mining page does WASM-based hashing is a separate question we cannot answer with static analysis of this APK.) |
| W5 | `api.ct-access.pro` (access/auth) | Not in this APK | Mobile may not interact with the access-API subsystem at all, or that subsystem is reached only via the webview. |
| W6 | `cryptotab.farm` (Boost backend) | Not in this APK | Same as above. |

Net assessment: **mobile has a smaller operator-controlled surface area** than desktop, both because of Play Store distribution constraints (mandatory standard FCM, Play crash reporting, no traditional extensions, signed-update channel) and because the operator apparently chose to use Google's stock infrastructure where they could on this build. The flip side is that **mobile adds attribution / tracking surface** (Tenjin, GAID, full install-referrer chain) that desktop doesn't have.
