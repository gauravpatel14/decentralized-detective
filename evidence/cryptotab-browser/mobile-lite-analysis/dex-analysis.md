# CryptoTab Browser Lite Android - DEX Analysis

## Decompilation tool

`jadx` v1.x ran cleanly against `classes.dex` (4.5 MB single dex). Output saved to `raw/jadx-out/sources/`.

R8 obfuscation in use - most classes have one-letter / `defpackage.AbcXyz123` names. The map ID embedded in the dex is:

```
"pg-map-id":"chromium-ChromePublic.aab-stable-260119 (lite.cryptotab.android)"
"r8-mode":"full"
"min-api":26
```

This confirms the build is derived from Chromium's standard `ChromePublic.aab` (the open-source build) with R8 full-mode shrinking.

## Top-level package layout

```
android/        - empty shims (e.g. android.hardware.*, android.adservices.*) - shadow classes
androidx/       - AndroidX support libs (activity, fragment, recyclerview, appcompat, etc.)
com/
    android/billingclient/      - Google Play Billing
    android/installreferrer/    - Google Install Referrer
    android/volley/             - Google Volley HTTP client
    google/firebase/            - Firebase (analytics, components, dynamiclinks, encoders, iid, installations, messaging, provider)
    google/android/             - Google Play Services + Google Material design
    google/ipc/                 - Firebase IPC
    google/protobuf/            - Protocol Buffers runtime
defpackage/     - 1000s of R8-shortened classes (all the CryptoTab + Chromium glue lives here)
J/              - empty/jadx-marker
kotlin/         - Kotlin stdlib
kotlinx/coroutines/
lite/cryptotab/android/   - Just `R.java` (resource references)
org/chromium/   - Chromium Java glue (ui, net, content, content_public, url, components, chrome, mojo, cc, base, media, webapk, jni_zero)
```

## Entry-point activity

The base APK does NOT contain the launcher activity. `AndroidManifest.xml` declares `isolatedSplits="true"` and `requiredSplitTypes="cablev2_authenticator__module,chrome__module"`. The actual launcher (`ChromeTabbedActivity` or similar) lives in the **`chrome__module` split APK** which is delivered separately by Play Store at install time. We do not have that split.

What we DO have in the base manifest is the application class `org.chromium.chrome.browser.base.SplitChromeApplication` and its component factory `SplitCompatAppComponentFactory` -- both of these are standard Chromium split-loader plumbing. The application class loads the main split into the same process when needed.

## CryptoTab-specific code in classes.dex (the interesting bits)

### `lQ.java` (the main CryptoTab URL/route table)

```java
public abstract class lQ {
    static {
        a = Jd.a("6.2.34");
        b = new C1726xM1[]{
            new C1726xM1("/affiliate/dashboard", "Balance",   Ip1.ic_balance),
            new C1726xM1("/affiliate/referrals", "Referrals", Ip1.ic_referrals),
            new C1726xM1("/faq",                 "FAQ",       Ip1.ic_faq),
            new C1726xM1("/affiliate/boost",     "Boost",     Ip1.ic_boost),
            new C1726xM1("/mobile/android",                          "Mining",   Ip1.ic_mining),
            new C1726xM1("/mobile/android/tutorial",                 "Tutorial", Ip1.ic_mining),
            new C1726xM1("/mobile/android/default_browser_tutorial", "Default browser tutorial", Ip1.ic_mining),
            new C1726xM1("/api/v1/browser/android/install", "", 0),
            new C1726xM1("/login", "login", Ip1.ic_mining)
        };
        c = new C0377am2[]{
            new C0377am2("https://ncwallet.net/benefits",          "NC Wallet", Ip1.ic_nc_wallet),
            new C0377am2("https://pool.cryptobrowser.site/landing","CT Pool",   Ip1.ic_ct_pool),
            new C0377am2("chrome://bot",                            "CB Game",  Ip1.ic_cb_game)
        };
    }

    public static String b(int i) {
        if (aM1.a(i, 5)) return "chrome://cryptotabdash/";
        if (aM1.a(i, 6)) return "chrome://welcome/";
        return "https://cryptobrowser.site" + b[aM1.b(i)].c + "/";
    }
    ...
}
```

What this tells us:
- The browser's "home" / dashboard is the internal Chromium WebUI page **`chrome://cryptotabdash/`** (whose backing C++ handler is `chrome/browser/ui/webui/cryptobrowser/webui_message_handler.cc` per the libchrome.so source-path strings).
- The mining page is a normal `https://cryptobrowser.site/mobile/android` web page. No native miner.
- Three external links are hard-coded shortcuts: NCWallet ("benefits"), the CT Pool landing page, and `chrome://bot` (the "CB Game" - confirmed in Phase 1 desktop too).
- Affiliate dashboards, referrals, FAQ, boost are all server-rendered HTML at `cryptobrowser.site/affiliate/...` paths.

### `Qu1.java` (FCM token registration)

```java
String url = "https://api.cryptobrowser.site/api/v2/fcm/register?app_id={pkg}&av=0.0.0&v=6.2.34&bid={bid_pref}"
JSONObject body = { "token": "<fcm_token>", "device_type": "android" }
```

Reports the device's Firebase Cloud Messaging token + a `bid` (user-bound ID stored in shared prefs) to the operator's API. This gives the operator a push-message channel into every installed copy.

### `C0717gY.java` (Device registration with Advertising ID)

```java
String url = "https://api.cryptobrowser.site/api/v2/devices/register?app_id={pkg}&av=0.0.0&v=6.2.34&platform=android&gaid={Google Advertising ID}"
JSONObject body = {
    "app_instance_id": "<Firebase app instance id>",
    "dl_url":          "<Firebase Dynamic Link URL on first launch>",
    "ref":             "<URL-encoded Play Store install referrer string>"
}
```

This is the device fingerprint + attribution tuple. On first launch the app reports:
- Google Advertising ID (gaid) - cross-app advertising tracker
- Firebase App Instance ID
- Firebase Dynamic Link (if the install came from a CT-affiliate link)
- Play Store Install Referrer (so the operator can attribute the install to a specific affiliate)
- App package name + version + a `bid_pref` user identifier

Together with `Qu1.java`'s FCM registration, these two endpoints establish a persistent operator->device channel keyed on `bid` + FCM token, before any user interaction with the browser UI.

### `TB1.java`

One line reference: `if (str.equals("type=__alt__ddc_cryptobrowser_site"))`. This is a search-engine / new-tab variant switch (also evidenced by the `__alt__ddc_cryptobrowser_site` token in the dex strings: `"type=__alt__ddc_cryptobrowser_site"`). Probably toggles between a default Google search NTP and the CryptoTab-themed NTP.

## Third-party SDK inventory

| SDK | Package(s) found | Purpose |
|---|---|---|
| Firebase Analytics | `com.google.firebase.analytics.*` | Product analytics + DebugView |
| Firebase Messaging (FCM) | `com.google.firebase.messaging.*` + `iid`, `installations` | Push notifications (token reported to `api.cryptobrowser.site`) |
| Firebase Dynamic Links | `com.google.firebase.dynamiclinks.*` | Install referrer / deferred deep-linking (reported to `api.cryptobrowser.site`) |
| Google Play Services Ads (AdId) | `com.google.android.gms.ads.identifier.AdvertisingIdClient` | Google Advertising ID (reported to `api.cryptobrowser.site`) |
| Google Play Services Measurement | `com.google.android.gms.measurement.*` | Analytics |
| Google Cast Framework | `com.google.android.gms.cast.framework.*` | Chromecast support (stock Chromium) |
| Google Play Billing | `com.android.billingclient.*` v7.0.0 | In-app purchases - notable for a "free" browser; may be used by the Boost / Pro upgrade flow |
| Google Play Install Referrer | `com.android.installreferrer.*` | Install attribution |
| Google Volley | `com.android.volley.*` | HTTP client used for `api.cryptobrowser.site` calls |
| Protobuf | `com.google.protobuf.*` | Bundled |
| Tenjin SDK | (referenced via manifest meta-data `TENJIN_APP_STORE=googleplay`) | Mobile attribution / install tracking |

NOT FOUND (each absence is a positive signal):
- AppsFlyer, Adjust, Branch, OneSignal, Amplitude, Mixpanel, Segment, Singular, Flurry
- Sentry, Crashlytics (Firebase Crashlytics is NOT registered in the manifest meta-data, even though desktop has self-hosted `snt.cryptobrowser.site` Sentry)
- Facebook SDK, TikTok / ByteDance SDK, Umeng, Tencent

## Mining-related code in DEX

**None present.** Specifically:
- No class with name containing `Miner`, `Mining`, `Hash`, `Stratum`, `WorkProvider`, `RandomX`, `xmrig`.
- No JavaScript interface (`@JavascriptInterface`) bridge class exposing mining methods.
- No string containing `workStart`, `setJob`, `onHashFounded`, `onHashRateStats`, `submitHash`, `submitJob`, or any Stratum protocol token.
- The only DEX class with "Mining" in its data is `lQ.java` -- and that's just the display label `"Mining"` attached to a route that opens `https://cryptobrowser.site/mobile/android` in a web view.

The mining functionality on mobile is delivered as ***server-side rendered HTML/JS at `cryptobrowser.site/mobile/android`***, not via local hash computation. (See `mobile-vs-desktop-diff.md` and `verdict.md` for what this implies.)

## Crypto / wallet / key-management code in DEX

**None present in any operationally meaningful way.** Specifically searched:
- `secp256k1`, `BIP32`, `BIP39`, `mnemonic`, `sighash`, `xprv`, `xpub` -> zero hits.
- `signTx`, `signTransaction` -> zero hits.
- The DEX *does* contain `Ljava/security/PrivateKey;`, `signWithPrivateKey`, `encryptWithPrivateKey`, `privateKeySupportsCipher`, `privateKeySupportsSignature` -- but these are Chromium's WebCrypto / WebAuthn glue around the platform `java.security.PrivateKey` interface and have nothing to do with Bitcoin or Monero.
- The only `wallet` references are: `NC Wallet` display label, `ic_nc_wallet` resource id, `https://ncwallet.net/benefits` link, and Chromium's autofill autofill_wallet_management strings (browser-saved-payment-cards UI).

This matches desktop: the wallet is fully custodial / server-side. The Android app has no key material and signs no transactions.

## Anti-tamper / Frida / root / Xposed detection

**None present.** Searched DEX strings exhaustively:
- `frida`, `Frida`, `re.frida.server`, `/data/local/tmp/re.` -> zero meaningful hits (only HTML cruft like `...friday...` and `Exposed`-in-`ExposedDropdownMenu` false-positives).
- `xposed`, `Xposed`, `magisk`, `Magisk` -> zero meaningful hits.
- `/system/bin/su`, `/su/bin`, `busybox`, `test-keys` -> zero hits.
- `TracerPid`, `ptrace`, `Debug.isDebuggerConnected` -> not present in DEX.
- No SafetyNet/Play Integrity attestation call (`com.google.android.gms.safetynet.SafetyNetClient` not present; no `playintegrity` strings either).

The app is **not hardened against dynamic analysis** -- a runtime hooker (Frida) on a rooted device would have free reign. (Whether that's good or bad for users depends on perspective: it makes the app easier for security researchers to audit, but also easier for malware that runs alongside it to interfere.)

## Notable Java strings worth noting

```
chrome://cryptotabdash/                     # main dashboard WebUI scheme
chrome://bot                                # "CB Game" mini-game (also present desktop)
chrome://new-tab-page/
chrome://welcome/
https://app-measurement.com/a               # Firebase Analytics ingest
https://search.cryptobrowser.site/?q=       # default search engine
https://search.cryptobrowser.site/api/suggestions/
https://search.yahoo.com/beacon/geop/p?     # Yahoo affiliate/redirect (s=1197812100&hspart=domaindev&hsimp=yhs-domaindev_ddc_extensions&traffic_source=yhs_domaindev_ddc_extensions_search)
https://www.googleadservices.com/pagead/conversion/app/deeplink
https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps
"type=__alt__ddc_cryptobrowser_site"        # NTP variant switch
"cr_CryptoTabUtils"                          # logger tag
"cr_DeviceRegistration"                      # logger tag
"cr_AppInstanceIdController"
"cr_DynamicLinkController"
"cr_InstallReferrerController"
"cr_UrlSafeEncoder"
"RequestSingleton"                            # logger tag for FCM token registration
```

The Yahoo `s=1197812100&hsimp=yhs-domaindev_ddc_extensions` parameter is a Yahoo distribution-partner ID; the `domaindev` partner string suggests CryptoTab is a Yahoo search-affiliate revenue source. The same partner-id is referenced in the desktop binary (Phase 1) and is unchanged here.
