# CryptoTab Browser Lite Android - APK Overview

## File

- Path: `/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/CryptoTab-Lite-Android.apk`
- Size: 222 MB (221,863,385 bytes)
- Type: ZIP archive (valid APK, no `META-INF/` directory - signed via v2/v3 schemes only)

## Application identity

| Field | Value |
|---|---|
| Package name | `lite.cryptotab.android` |
| App name | CryptoTab Browser Lite |
| Version name | **6.2.34** |
| Version code | 260119 |
| minSdkVersion | 26 (Android 8.0) |
| targetSdkVersion | 35 (Android 15) |
| compileSdkVersion | 35 / Codename 15 |
| Build artifact (from R8 map id) | `chromium-ChromePublic.aab-stable-260119` |
| Stamp source | `https://play.google.com/store` (Google Play stamp) |
| Stamp type | `STAMP_TYPE_DISTRIBUTION_APK` |
| isolatedSplits | **true** (this APK is the base; required splits: `chrome__module`, `cablev2_authenticator__module`) |

## Signing certificate

- Schemes used: **v2 + v3 only** (no v1, hence no `META-INF/CERT.RSA`)
- Cert SHA-1: `2920b2552b95994465828f07005a120504690c8b`
- Cert SHA-256: `e8809404b627204ac58dfd9fe59c3a83180b405552435c333c73618866d9c46a`
- Cert MD5: `8b417158ef6c918807e8a41c9ac30750`
- Public key: RSA 4096-bit
- **Subject = Issuer** (self-signed): `CN=Android, OU=Android, O=Google Inc., L=Mountain View, ST=California, C=US`
- Validity: 2021-04-30 -> 2051-04-30 (30 years)
- Serial: `0xd488d8b4e3cacd5837b55ba2e45d5a702407f925`

Note: the "Google Inc." subject string is the default `debug.keystore`-style identity that Chromium-based builds typically carry; it is the developer's signing key, NOT Google's. The 30-year validity and 2021-04-30 issue date are consistent across the entire CryptoTab Android signing identity.

## File-size breakdown

| Bucket | Size | Notes |
|---|---|---|
| `lib/arm64-v8a/` | 201.3 MB | 3 ELF .so files, arm64 only (no x86 or armeabi-v7a) |
| `classes.dex` | 4.3 MB | R8/D8-compiled, single dex |
| `res/` | 3.7 MB | Standard Chromium resources |
| `assets/` | 2.3 MB | Chromium `.pak`, V8 snapshots, tiny webapk8.dex |
| `resources.arsc` | 1.3 MB | Resource table |
| `AndroidManifest.xml` | 42 KB | Binary AXML |
| `META-INF/` | 0 bytes | No v1 signature files |
| **Total** | **212.9 MB** | |

Native libs:
- `lib/arm64-v8a/libchrome.so` - 200.1 MB (ELF aarch64, stripped, BuildID `a2a070c37f1639f93e5c46952992f9a8cfe3df4a`). Stripped of internal symbols (877 dynsyms total, all libc imports).
- `lib/arm64-v8a/libchrome_crashpad_handler.so` - 1.14 MB (Crashpad handler executable).
- `lib/arm64-v8a/libarcore_sdk_c.so` - 66 KB (Google ARCore loader stub - Chromium leftover).

## Application attributes (from `AndroidManifest.xml` -> `<application>`)

- `android:name = org.chromium.chrome.browser.base.SplitChromeApplication` (split-aware Application class)
- `android:appComponentFactory = org.chromium.chrome.browser.base.SplitCompatAppComponentFactory`
- `android:zygotePreloadName = org.chromium.content_public.app.ZygotePreload`
- `android:allowBackup = false`
- `android:largeHeap = false`
- `android:extractNativeLibs = false` (native libs loaded from APK without unpacking)
- `android:debuggable` -> not present (= false)
- `android:usesCleartextTraffic` -> not on `<application>`, but see network security config below
- `android:networkSecurityConfig = @xml/...`  (see below)
- `android:memtagMode = "async"` (MTE async mode requested where supported)
- `android:enableOnBackInvokedCallback = false`
- `android:allowAudioPlaybackCapture = false`

## Network security configuration (`res/xml/.../0x7f180026.xml`)

```xml
<network-security-config>
    <base-config cleartextTrafficPermitted="true">
        <trust-anchors>
            <certificates src="user" />
            <certificates src="system" />
        </trust-anchors>
    </base-config>
</network-security-config>
```

**Notable**: `cleartextTrafficPermitted="true"` is set globally - the app will accept HTTP traffic to any domain. User-added CA certs are trusted (= NO certificate pinning anywhere). This matches the desktop posture (also no pinning observed in Phase 1) but is unusual for a 2025-vintage browser that *could* easily ship a pinning policy for its own first-party endpoints.

## Permissions

39 permissions total. Categorized below.

### Network / connectivity (standard for a browser)
- `INTERNET`, `ACCESS_NETWORK_STATE`, `ACCESS_WIFI_STATE` (sdk23+)
- `NFC`

### Privacy-sensitive (notable for a browser)
- `ACCESS_FINE_LOCATION`, `ACCESS_COARSE_LOCATION` (consent-gated at runtime)
- `CAMERA`, `RECORD_AUDIO`, `MODIFY_AUDIO_SETTINGS`, `READ_MEDIA_AUDIO`
- `READ_CONTACTS` (sdk23+) - inherited from stock Chromium for autofill
- `GET_ACCOUNTS`, `MANAGE_ACCOUNTS`, `USE_CREDENTIALS` - Google account binding
- `USE_BIOMETRIC`, `USE_FINGERPRINT` - device unlock for Credential Manager
- `BLUETOOTH`, `BLUETOOTH_ADMIN` (sdk30-max), `BLUETOOTH_CONNECT`, `BLUETOOTH_SCAN` (neverForLocation), `BLUETOOTH_ADVERTISE` - WebBluetooth API
- `CREDENTIAL_MANAGER_QUERY_CANDIDATE_CREDENTIALS`, `CREDENTIAL_MANAGER_SET_ALLOWED_PROVIDERS`, `CREDENTIAL_MANAGER_SET_ORIGIN`

### Storage
- `READ_EXTERNAL_STORAGE`, `WRITE_EXTERNAL_STORAGE`, `DOWNLOAD_WITHOUT_NOTIFICATION`

### Power & lifecycle
- `WAKE_LOCK`, `VIBRATE`, `POST_NOTIFICATIONS`, `RECEIVE_BOOT_COMPLETED`
- `FOREGROUND_SERVICE`, `FOREGROUND_SERVICE_MEDIA_PLAYBACK`, `FOREGROUND_SERVICE_DATA_SYNC`
- `RUN_USER_INITIATED_JOBS` (Android 14 user-initiated long-running jobs)

### Notable / borderline
- **`REQUEST_INSTALL_PACKAGES`** (sdk23+) - permits the app to launch `ACTION_INSTALL_PACKAGE` intents to install side-loaded APKs. Standard Chromium downloads do this; combined with a browser that visits arbitrary URLs and can be social-engineered, this is a real attack surface for drive-by APK pushes if the user grants the runtime grant. (Chrome stable does request this too.)
- **`QUERY_ALL_PACKAGES`** - lets the app enumerate every installed package on the device (Google policy normally restricts this). Used for the `Get_Install_Referrer` service and intent resolution; commonly abused by attribution SDKs.
- `ACCESS_ADSERVICES_ATTRIBUTION` (sdk23+) - Android 13 SDK Sandbox attribution API.

### Push & ads
- `com.google.android.c2dm.permission.RECEIVE` - FCM
- `com.google.android.gms.permission.AD_ID` - Google Advertising ID

### Play Billing / install referrer (monetization)
- `com.android.vending.BILLING`, `com.android.vending.CHECK_LICENSE`
- `com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE`

### Custom / app-private (defined by CryptoTab)
- `lite.cryptotab.android.permission.C2D_MESSAGE` (FCM)
- `lite.cryptotab.android.permission.READ_WRITE_BOOKMARK_FOLDERS`
- `lite.cryptotab.android.TOS_ACKED`

### NOT REQUESTED (and the absence is meaningful)
- `BIND_ACCESSIBILITY_SERVICE` - **NOT present.** Excellent. (No overlay/keystroke-harvest accessibility-service vector.)
- `BIND_NOTIFICATION_LISTENER_SERVICE` - NOT present.
- `BIND_DEVICE_ADMIN`, `BIND_VPN_SERVICE` - NOT present.
- `SYSTEM_ALERT_WINDOW` (overlay) - NOT present.
- `PACKAGE_USAGE_STATS`, `WRITE_SECURE_SETTINGS`, `BIND_INPUT_METHOD` - NOT present.
- `READ_PHONE_STATE`, `READ_SMS`, `SEND_SMS`, `READ_CALL_LOG` - NOT present.

## Components

Because of `isolatedSplits="true"`, the **entry-point launcher activity lives in the `chrome__module` feature split**, not in the base APK. The base APK declared:

### Activities (4)
- `com.android.billingclient.api.ProxyBillingActivity` (not exported)
- `com.android.billingclient.api.ProxyBillingActivityV2` (not exported)
- `com.google.android.play.core.common.PlayCoreDialogWrapperActivity` (not exported)
- `com.google.android.gms.common.api.GoogleApiActivity` (not exported)

The main `org.chromium.chrome.browser.app.ChromeTabbedActivity` or equivalent is NOT in this base APK manifest. The actual launcher intent-filter would be in the chrome split's own manifest.

### Services (50)
- **45 Chromium sandbox/privileged process service hosts**: `org.chromium.content.app.SandboxedProcessService0..39` + `PrivilegedProcessService0..4` (declared via metadata `NUM_SANDBOXED_SERVICES=40`, `NUM_PRIVILEGED_SERVICES=5`).
- 1 `com.google.firebase.components.ComponentDiscoveryService`
- 1 `com.google.firebase.messaging.FirebaseMessagingService`
- 2 `com.google.android.gms.cast.framework` services (`MediaNotificationService`, `ReconnectionService`)
- 2 `com.google.android.gms.measurement` services (`AppMeasurementService`, `AppMeasurementJobService`)

### Receivers (3)
- `com.google.android.gms.cast.framework.media.MediaIntentReceiver`
- `com.google.android.gms.measurement.AppMeasurementReceiver`
- `com.google.firebase.iid.FirebaseInstanceIdReceiver` (exported = true; requires `com.google.android.c2dm.permission.SEND`)

### Providers (6)
- `com.google.firebase.provider.FirebaseInitProvider`
- `org.chromium.chrome.browser.pdf.PdfContentProvider`
- `org.chromium.ui.dragdrop.DropDataContentProvider`
- `org.chromium.chrome.browser.util.ChromeFileProvider`
- `org.chromium.chrome.browser.download.DownloadFileProvider`
- **`org.chromium.chrome.browser.provider.ChromeBrowserProvider`** -- **EXPORTED**, authorities = `lite.cryptotab.android.ChromeBrowserProvider; lite.cryptotab.android.browser; lite.cryptotab.android`

### Intent filters / URL schemes / deep links

- `<queries>` declares the app wants to discover apps with `MAIN/LAUNCHER`, with `com.android.vending.billing.InAppBillingService.BIND`, and the `com.google.ar.core` package.
- No `intent-filter` in the base manifest accepts custom schemes like `cryptotab://` or `ncwallet://`. (The chrome split would carry the http/https BROWSABLE filters for the main activity.)

## Notable `<meta-data>` keys

- `TENJIN_APP_STORE = googleplay` - **Tenjin SDK** (mobile attribution platform) is initialized.
- `org.chromium.content.browser.NUM_SANDBOXED_SERVICES = 40`
- `org.chromium.content.browser.NUM_PRIVILEGED_SERVICES = 5`
- `com.google.ar.core = optional` and `com.google.ar.core.load_32bit_so_from_split_module = optional`
- `com.google.android.play.billingclient.version = 7.0.0`
- `com.google.ar.core.min_apk_version = 231450000`
- Firebase ComponentRegistrar entries for: `dynamiclinks`, `iid`, `installations`, `messaging`, `analytics.connector` -- but NO `auth`, NO `crashlytics`, NO `remote_config`.
- `com.android.stamp.source = https://play.google.com/store`
- `com.android.stamp.type = STAMP_TYPE_DISTRIBUTION_APK`
- `com.android.vending.derived.apk.id = 2`
- `com.android.vending.splits.required = true`
- `android.allow_multiple_resumed_activities = true`
- Samsung multi-window enable hints (`com.samsung.android.sdk.multiwindow.*`)
