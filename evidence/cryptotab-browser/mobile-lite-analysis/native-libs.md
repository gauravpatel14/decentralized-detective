# CryptoTab Browser Lite Android - Native Libraries

The APK ships exactly three `.so` files in `lib/arm64-v8a/`. **No `armeabi-v7a`, no `x86`, no `x86_64`** -- this is an arm64-only build (consistent with Google Play's late-2024 mandate, but means the APK refuses to install on 32-bit-only devices).

## 1. `libchrome.so` (200.1 MB)

### File metadata

```
ELF 64-bit LSB shared object, ARM aarch64, version 1 (SYSV)
dynamically linked, stripped
BuildID[sha1]=a2a070c37f1639f93e5c46952992f9a8cfe3df4a
SHA-256 = 45f399254b10ae1c8dd71ee885986c29af2965036c0607b0fe3dfaade53e5344
```

Heavily stripped: only **877 dynamic symbols** total, all of which are libc/Android imports (`pthread_*`, `__cxa_*`, `memcmp`, etc.). No internal Chromium function names are exported. No interesting `RTTI` strings remain.

### Dynamic linking (`DT_NEEDED`)

```
libdl.so
libm.so
libandroid.so
liblog.so
libjnigraphics.so
libaaudio.so
libmediandk.so
libc.so
```

All standard Bionic/Android NDK libraries. **No `libssl.so`/`libcrypto.so` link** -- TLS is statically linked from Chromium's bundled BoringSSL. **No `libxmrig.so`** or similar separate native miner. No vendor-specific JNI surfaces (`libArtPlus.so`, `libArtCompat.so`, etc.). Everything is in the one monolithic `libchrome.so`.

### Chromium version pin

```
Chrome/128.0.6613.148
Mozilla/5.0 (%s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s.0.0.0 %sSafari/537.36
```

**Mobile pins to Chromium M128 (stable build `128.0.6613.148`)**, NOT the M127 that desktop is built from. Mobile is roughly **one major version newer** than desktop. As of late 2024/early 2025, M128 was released 2024-08-20 and is approximately 18-20 months stale at the time of this analysis (today 2026-05-15) -- not as bad as desktop, but still hundreds of CVEs behind the current stable Chrome.

### xmrig / mining native code -- **NOT PRESENT**

Exhaustive search of the 200 MB binary for xmrig signatures returned ZERO hits:

| Token | Hits |
|---|---|
| `xmrig` | 0 |
| `randomx` | 0 |
| `RandomX` | 0 |
| `argon2` | 0 |
| `cryptonight` | 0 |
| `RX_FLAG_` | 0 |
| `cant allocated randomx cache` (desktop's verbatim source typo) | 0 |
| `stratum`, `stratum+tcp` | 0 |
| `wss://` | 0 |
| `wss://api` | 0 |
| `submitWork`, `submitHash`, `submit_share` | 0 |
| `job_id`, `mining.subscribe`, `mining.authorize` | 0 |

**Conclusion: the mobile build does not bundle xmrig, does not implement a Stratum / Stratum-like protocol client, and never opens a WebSocket from the client.** All mining for Android happens server-side at `cryptobrowser.site/mobile/android` (which presumably renders an HTML page that either streams accumulated hash-rate "credits" from the server, or invokes some JS in the page to do hashing -- but the client-side native binary has no role).

### CryptoTab branding / endpoints inside libchrome.so

Total unique CryptoTab strings: **5**. Specifically:

```
cryptotab
cryptotabdash
lite.cryptotab.android
org/chromium/chrome/browser/util/CryptoTab           (JNI class name)
../../chrome/browser/ui/webui/cryptobrowser/webui_message_handler.cc   (source-path string)
https://cryptobrowser.site/static/browser/images/external/cryptotab-browser_logo.png
https://search.cryptobrowser.site/?q={searchTerms}&f=cba&a={searchId}
https://search.cryptobrowser.site/api/suggestions/?...
https://search.cryptobrowser.site/favicon.ico
```

That's it. The native binary contains:
- A registered Chromium internal scheme handler for `chrome://cryptotabdash/` (the C++ message handler lives at `chrome/browser/ui/webui/cryptobrowser/` in the source tree).
- A search-engine entry for `search.cryptobrowser.site` (default search).
- A logo URL.
- A registered JNI class `org/chromium/chrome/browser/util/CryptoTab` (whose Java side lives in the missing `chrome__module` split).

### Desktop endpoint strings in libchrome.so

| Desktop endpoint | Present in mobile libchrome.so? |
|---|---|
| `api.cryptobrowser.site` | **NO** in libchrome.so. **YES** in classes.dex (used by `Qu1.java` / `C0717gY.java` for device + FCM registration). |
| `api.ct-access.pro` | **NO** anywhere in the APK |
| `invite.ctnft.net` | **NO** (the lowercase `ctnft` appears once, but in a Chromium autofill domain list -- unrelated) |
| `cryptotab.farm` | **NO** anywhere in the APK |
| `safebrowsing.cryptobrowser.today` | **NO** anywhere |
| `snt.cryptobrowser.site` (self-hosted Sentry) | **NO** anywhere |
| FCM sender id `752301524429` | **NO** anywhere |
| Boost extension ID `kommlffgagciikldkpkedfjpmpofobch` | **NO** anywhere |

**This is a major divergence from desktop.** The mobile build:
- Uses **Google's standard Safe Browsing** (`safebrowsing.googleapis.com/v4`) instead of the self-hosted `safebrowsing.cryptobrowser.today` that desktop uses. Three strings: `https://safebrowsing.googleapis.com/v4`, `https://sb-ssl.google.com/safebrowsing/clientreport/login`, `https://sb-ssl.google.com/safebrowsing/clientreport/phishing`. (= less data flowing back to the operator.)
- Uses **standard Firebase Cloud Messaging** (`fcm.googleapis.com`) and **standard Firebase analytics** (`app-measurement.com`) instead of routing crash reports through `snt.cryptobrowser.site`. Crashpad's upload URL is left at the Chromium default `https://crashpad.chromium.org/`.
- Does NOT bundle the `kommlffgagciikldkpkedfjpmpofobch` "Boost" companion extension (Android Chromium doesn't support extensions in this app, so unsurprising).
- Does NOT contain `api.ct-access.pro` (the auth/access API) or `invite.ctnft.net` (the affiliate invite domain) -- so the mobile app is not exposed to those subsystems directly.

### Bitcoin / wallet signing code -- **NOT PRESENT**

Same as desktop, but worth re-confirming for the mobile build:

| Token | Hits in libchrome.so |
|---|---|
| `secp256k1` | 0 |
| `bitcoin` | 0 |
| `BIP32` / `BIP39` | 0 |
| `mnemonic` | 0 |
| `SIGHASH` | 0 |
| `xprv` / `xpub` | 0 |

No on-device crypto wallet, no signing code, no key material handling. Confirms the **fully custodial** architecture extends to mobile.

### Other notable findings in libchrome.so

- **`isAccessibilityToolPresent=`** and **`isAnyAccessibilityServiceEnabled=`** appear as Chromium internal heuristics (used for "is a screen reader connected" UX adaptations). The app does NOT request `BIND_ACCESSIBILITY_SERVICE` itself, so this is just Chromium querying the platform.
- **Tenjin SDK references**: none found in the .so itself (the SDK lives in the chrome split). Only the manifest meta-data `TENJIN_APP_STORE=googleplay` is in the base APK.
- Chromium's bundled component-extension IDs (e.g. `fhbeibbmaepakgdkkmjgldjajgpkkhfj` = Google PDF Viewer, `aagaghndoahmfdbmfnajfklaomcanlnh` = Cloud Print) are all present and standard. **None of these are CryptoTab additions.**
- `Omaha` / `ComponentUpdater` / `GoogleUpdate` strings ARE present (4-8 hits each), but these are Chromium's component-update plumbing left in place. On Android, app updates happen via Play Store, and the Chrome component-updater fetches things like Widevine DRM modules and the Safe Browsing list -- nothing CryptoTab-specific.

## 2. `libchrome_crashpad_handler.so` (1.14 MB)

```
ELF 64-bit LSB pie executable, ARM aarch64
BuildID[sha1]=9093cef6a7b5462621f32e3aab6bcca046112a7f
SHA-256 = 5247a4769210039d5c132e28d31cf7f84174dbb651c70989548e177bd3968938
```

Standard Chromium Crashpad handler (the small out-of-process binary that catches main-process crashes). Strings reveal:

- `--annotation=KEY=VALUE  set a process annotation in each crash report`
- `--url=URL               send crash reports to this Breakpad server URL`
- `https://crashpad.chromium.org/` (the *default* Chromium upload URL placeholder)

CryptoTab has **NOT overridden** this with the self-hosted `snt.cryptobrowser.site/19` Sentry endpoint that desktop uses. On mobile, crashes either silently dropped, or routed via Firebase / Play Console crash reporting -- not the operator's Sentry. This is consistent with the lack of `snt.cryptobrowser.site` anywhere in the binary.

## 3. `libarcore_sdk_c.so` (66 KB)

```
ELF 64-bit LSB shared object, ARM aarch64
BuildID[md5/uuid]=4fc83f9d63e2f3c7efd7d0231a87fb61
SHA-256 = 05113b41d180cb7afd6db3a71213c4bd6f45a9179d6317639cdf4f8977736006
```

Tiny Google ARCore loader stub. Exports `ArCoreApk_loadSymbolTable`, `ArCoreApk_isSymbolLoaded`, `ArSession_create*`, etc. This is the loader shim that dynamically opens the real ARCore native library when the user grants the AR feature -- Chromium uses it for WebXR. **Stock Chromium leftover, no CryptoTab modifications.** The manifest declares ARCore optional (`com.google.ar.core = optional`).
