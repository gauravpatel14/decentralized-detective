# CryptoTab Browser Lite Android -- Verdict

## Is mobile architecturally identical to desktop?

**No -- mobile is materially different, and at least three of those differences reduce the operator's attack surface compared to desktop.**

Justifications (highest-impact differences first):

- **No xmrig in the mobile binary.** The 200 MB `libchrome.so` has zero `xmrig` / `randomx` / `cryptonight` / `argon2` / `stratum` / `wss://` strings. Desktop has all of these including the verbatim source typo `cant allocated randomx cache`. Whatever "mining" the mobile app does, it does not do via local Stratum hashing in native code; it almost certainly happens server-side at `cryptobrowser.site/mobile/android` (a normal web page rendered inside the browser, possibly performing WASM hashing inside the webview but not via a privileged native API).
- **No operator-controlled Safe Browsing endpoint.** Mobile uses Google's standard `safebrowsing.googleapis.com/v4`. Desktop uses the operator's self-hosted `safebrowsing.cryptobrowser.today`. Mobile users get an independent third-party blocklist; desktop users do not.
- **No operator-controlled crash-reporting endpoint.** Mobile's Crashpad has the default Chromium URL (effectively meaning crashes go nowhere or to Firebase/Play). Desktop ships crashes (including page URLs + stack traces) to `snt.cryptobrowser.site/19`.
- **No `eval()` of remote-supplied JS bodies in the base APK.** Desktop has a service worker that fetches and `eval()`s operator-controlled JS via `/api/v2/platform/pc/app` -- a clean RCE / anti-tamper channel. The mobile base APK has no equivalent. (Caveat: the missing `chrome__module` split could theoretically carry one, but the native-code support that the desktop version uses to enable it is not present in libchrome.so.)
- **No `api.ct-access.pro`, `invite.ctnft.net`, `cryptotab.farm`, or the FCM sender `752301524429`** anywhere in the APK. The mobile operator-API footprint is just `api.cryptobrowser.site` (two endpoints: FCM register, devices register) and `cryptobrowser.site` (the user-facing affiliate / web UI).
- **Chromium version is different**: M128 mobile vs M127 desktop. The mobile branch is exactly one major version ahead, but still substantially out of date (about 18-20 months stale as of today).

Things that DO match desktop (the architecture is the same in spirit):
- Fully custodial / no on-device wallet, no Bitcoin signing, no secp256k1, no BIP32/39 code.
- No affiliate L1..L10 constants in the binary; all affiliate logic is server-rendered HTML.
- The CryptoTab WebUI scheme is registered natively (`chrome://cryptotabdash/` -> C++ handler at `chrome/browser/ui/webui/cryptobrowser/webui_message_handler.cc`), confirming that CryptoTab has compiled in a Chromium patch but the operator did not surface mining-IPC IDL symbols on this build.
- Cleartext traffic permitted globally + user-added CAs trusted = no TLS pinning anywhere.
- No anti-tamper / Frida / root / Xposed detection -- the app does not try to resist dynamic analysis.

## Mobile-specific attack surface that doesn't exist on desktop

1. **Google Advertising ID + Firebase App Instance ID + Play install referrer + Firebase Dynamic Link** are all sent to `api.cryptobrowser.site/api/v2/devices/register` on first launch (DEX class `C0717gY.java`). This gives the operator a cross-app behavioral tracking primitive that the desktop build cannot match. The data is reported once at install + on app updates.
2. **FCM token sent to `api.cryptobrowser.site/api/v2/fcm/register`** (DEX class `Qu1.java`), with the user's app-specific `bid` and Firebase token. The operator can push silent messages to any installed copy at any time, keyed on this token.
3. **Tenjin SDK** (mobile attribution platform) is wired in via `meta-data TENJIN_APP_STORE=googleplay`. Tenjin endpoints (`*.tenjin.com`) are pinged with conversion events.
4. **`REQUEST_INSTALL_PACKAGES`** permission is requested. Combined with a browser that visits arbitrary URLs and the `READ_EXTERNAL_STORAGE` / `WRITE_EXTERNAL_STORAGE` + `DOWNLOAD_WITHOUT_NOTIFICATION` permissions, this gives the app the capability to download and install APKs without user-visible notifications. The user still has to confirm the system install dialog, but the *prompt* itself can be triggered without UI. (Chrome stable has the same permission, so this is not unique to CryptoTab, but it is part of the attack surface.)
5. **`QUERY_ALL_PACKAGES`** lets the app enumerate every installed app. We did not find DEX code that exfiltrates this list, but the capability is present.
6. **Sandboxed Chromium content processes** (40 of them) -- this is privacy *protection*, not attack surface, but worth noting as a structural difference: mobile's renderer processes are properly sandboxed by Android's seccomp+SELinux; desktop on macOS uses Chromium's sandbox, but `xmrig` runs in the browser process and is therefore NOT sandboxed. **Mobile cannot have an unsandboxed CPU-pegging miner in the main process the way desktop does** -- if anything mines on mobile, it does so inside a renderer process, subject to Android's process-budget killing.

## Android-specific permissions that are surprising

| Permission | Surprise level | Verdict |
|---|---|---|
| `BIND_ACCESSIBILITY_SERVICE` | **NOT requested** | Excellent. This is the huge red flag for Android malware (overlay attacks, keylogging, click-jacking). CryptoTab Lite does NOT request it. |
| `SYSTEM_ALERT_WINDOW` | NOT requested | Good. No overlay capability. |
| `BIND_NOTIFICATION_LISTENER_SERVICE` | NOT requested | Good. No reading other apps' notifications. |
| `BIND_DEVICE_ADMIN` / `BIND_VPN_SERVICE` | NOT requested | Good. |
| `READ_PHONE_STATE` / `READ_SMS` / `SEND_SMS` / `READ_CALL_LOG` | NOT requested | Good. No SIM/SMS/call surveillance. |
| `REQUEST_INSTALL_PACKAGES` | requested | Moderate concern -- but matches stock Chrome. |
| `QUERY_ALL_PACKAGES` | requested | Moderate concern -- Google Play normally restricts this to specific use cases. |
| `READ_CONTACTS` | requested | Inherited from stock Chrome autofill. |
| `RECORD_AUDIO` / `CAMERA` / `ACCESS_FINE_LOCATION` | requested | Standard for getUserMedia / WebRTC / Geolocation. Runtime-gated. |

Overall the permission set is what you would expect from a Chromium fork on Android -- **no Android-specific weaponization beyond the Chromium baseline**. This is a *much* better story than "shady free Android browser" in terms of permission-driven risk.

## Whether mobile users face materially different risks than desktop users

**Slightly lower direct risk; somewhat higher tracking exposure.**

Lower direct risk (mobile vs desktop):
- No native xmrig in the binary -> the app cannot peg the CPU at 100% from an OS-blessed background service. Whatever mining happens has to go through a webview tab, which Android can throttle / kill.
- No operator-RCE channel via `eval()` of remote JS in a service worker -> the operator cannot push arbitrary native-process code at will.
- Google Safe Browsing + Google Crashpad pipeline means less data being routed through operator-controlled infrastructure.
- App updates flow through Play Store -> tampered / malicious updates have to clear Google Play's review and trust the same signing key as the original.
- Process-level sandbox of renderers -> even if a malicious tab gets RCE, the sandbox plus SELinux limit blast radius.

Higher tracking exposure:
- GAID + Firebase IDs + Tenjin attribution -> the operator gets much stronger cross-app identity correlation than they do on desktop.
- FCM push token gives the operator a guaranteed message channel into every installed copy.
- `QUERY_ALL_PACKAGES` and the install referrer give the operator a lot of contextual signals about how the user arrived.

Net: a mobile user who downloads this app expecting "free passive Bitcoin mining" is most likely getting (a) an entirely cosmetic mining UI that accrues server-side "credits" the operator controls, (b) a strong tracking primitive (GAID + FCM token + install referrer), and (c) a 18-20-month stale Chromium engine for normal browsing. The most likely actual risk is **(c)** -- being phished or exploited through an old-Chrome web vulnerability while normal-browsing -- combined with the affiliate / withdraw-fee scam economics already documented in Phases 2-3 for desktop.

## Things the analysis could NOT determine (limits of static analysis on a split APK)

- **The chrome split APK was not available.** Anything that lives only in `chrome__module.apk` (the actual launcher activity, the `org.chromium.chrome.browser.util.CryptoTab` Java class implementation, the `google-services.json` Firebase project ID, the Tenjin app key) is invisible to this analysis. To get those, we would need to either (a) install the app and dump the Play-delivered splits from `/data/app/`, or (b) obtain an `xapk` / `apks` bundle that includes the splits.
- **What the `chrome://cryptotabdash/` WebUI actually does at runtime.** The C++ handler is registered (`webui_message_handler.cc` source path is in libchrome.so) but the HTML/JS it serves is not in the base APK's resources.pak (which is a Chromium-format resource bundle we didn't unpack). It is plausible that the HTML/JS, served from this internal page, embeds a WebWorker / WASM hasher that does the actual mining work -- but we cannot confirm or deny this without unpacking the .pak or instrumenting the app.
- **Whether the mining web page (`cryptobrowser.site/mobile/android`) is real PoW or pure theatre.** From this static analysis alone we have no way to tell, because the page is fetched at runtime.

## Recommended additions to the synthesis report

1. **Update the headline finding** from "fully custodial CryptoTab uses bundled xmrig and proxies it through a WebSocket" to a two-build statement: desktop bundles xmrig + WebSocket-proxies it; mobile does neither, and mining on mobile is either pure server-side credit accrual or webview-side WASM (undetermined). This is a major architectural divergence and worth its own paragraph.
2. **Add a row for mobile tracking primitives.** GAID + FCM + Tenjin + Play install referrer is a stronger user-identity-correlation primitive than anything in the desktop binary. The synthesis should mention this.
3. **Add the mobile chrome version drift.** M127 (desktop) vs M128 (mobile) is a small but consistent finding: the operator maintains two separate Chromium branches, both stale, but mobile is one major version ahead. Suggests a small engineering team that updates each platform on its own cadence.
4. **Add an Android-specific permission appendix** noting what CryptoTab Lite *does not* ask for (BIND_ACCESSIBILITY_SERVICE, SYSTEM_ALERT_WINDOW, NOTIFICATION_LISTENER, etc.). This rules out the worst-case "weaponized Android mining browser" scenario and is worth saying explicitly in the report because it's the question every reader will silently ask.
5. **Acknowledge the split APK limitation.** Be clear that the launcher activity and main JNI Java surface for the CryptoTab class live in the `chrome__module` split that we did not analyze, and explain what kinds of conclusions that limitation does and does not affect (it does not affect anything about libchrome.so or the FCM/devices-register flow; it does affect anything about exact deep-link intent filters, runtime JS bridges installed on the main activity's webview, and the Firebase project ID).
6. **Confirm the "no Bitcoin code anywhere" finding on a second platform.** This is the single strongest "the operator never had your keys, they only had your account balance on their server" data point for the synthesis. Repeating it on mobile makes it bulletproof.
