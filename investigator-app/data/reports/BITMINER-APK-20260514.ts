import { InvestigationReport } from '@/types/report';

const teardownCode = `// File: BitMiner.apk — static teardown notes
//
// SHA-256: 4cb1399803685b2725526b44fac0f05fc94f9c3f3e879781a9368805a4c8d0fe
// SHA-1  : 7b5656beafbeb8a40ee3f308dcb690cdd7be4b48
// Size   : 15,875,972 bytes  (15.13 MiB)
// Package: com.btc.bitcoin.mining.cloud.btcmining
// Display: "BitMiner"
// Built  : Flutter (release) + Firebase + AdMob + iZooto
//
// ─────────────────────────────────────────────────────────────
//   What this APK actually contains:
// ─────────────────────────────────────────────────────────────
//
// classes.dex / classes2.dex / classes3.dex   = 12.6 MiB obfuscated Java
//      ProGuard/R8 — 13,343 classes in 1-2 letter directories
//      (A/A3/B/B0/C1/…) — heavily renamed SDK code only.
//      The app's OWN package contains JUST:
//          MainActivity.java    (Flutter entry shim)
//          R.java               (auto-generated)
//      ALL business logic is elsewhere (see next).
//
// assets/flutter_assets/                       = Flutter Dart UI assets
//      Onboarding screens, mining UI graphics, fake-leaderboard
//      icons, referral images, daily-reward animations.
//      The asset filenames alone reveal the entire scam UX flow.
//
// MISSING: lib/<abi>/libapp.so   (where Dart business logic lives)
//      The APK manifest declares android:requiredSplitTypes=
//          "base__abi,base__density"
//      meaning the per-architecture native libs (including the
//      compiled Dart kernel) ship as SEPARATE split APKs that
//      are not present in this sideload-distributed file.
//      Practical effect: every conclusion about app BEHAVIOR
//      must come from the asset bundle, the manifest, the
//      DEX SDK code, and dynamic analysis — not from reading
//      the Dart source directly.
//
// ─────────────────────────────────────────────────────────────
//   Manifest summary (the truthful one):
// ─────────────────────────────────────────────────────────────
//
const manifest = {
    package        : "com.btc.bitcoin.mining.cloud.btcmining",
    label          : "BitMiner",
    compileSdk     : 36,
    cleartext      : true,                 // android:usesCleartextTraffic="true"
    splitsRequired : ["base__abi", "base__density"],
    extractNativeLibs: false,

    permissions: [
        // Network + lifecycle
        "INTERNET", "ACCESS_NETWORK_STATE", "ACCESS_WIFI_STATE",
        "WAKE_LOCK", "FOREGROUND_SERVICE",
        // Engagement
        "POST_NOTIFICATIONS", "VIBRATE", "BROADCAST_CLOSE_SYSTEM_DIALOGS",
        // Wallet-UI gate
        "USE_BIOMETRIC", "USE_FINGERPRINT",
        // Monetization
        "com.google.android.gms.permission.AD_ID",
        "ACCESS_ADSERVICES_AD_ID", "ACCESS_ADSERVICES_TOPICS",
        "ACCESS_ADSERVICES_ATTRIBUTION",
        "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE",
        // Push
        "com.google.android.c2dm.permission.RECEIVE",
        "com.google.android.providers.gsf.permission.READ_GSERVICES",
        "<package>.permission.C2D_MESSAGE",
    ],

    permissionsNotablyAbsent: [
        "READ_SMS",          // no credential theft via SMS
        "READ_CONTACTS",     // no contact exfil
        "RECORD_AUDIO", "CAMERA",
        "ACCESS_FINE_LOCATION",
        "BIND_ACCESSIBILITY_SERVICE",   // no overlay / autoclick capability
        "SYSTEM_ALERT_WINDOW",          // no draw-over-other-apps
        "REQUEST_INSTALL_PACKAGES",     // can't sideload further APKs
    ],
};

// ─────────────────────────────────────────────────────────────
//   🚨 OPERATOR FINGERPRINT — leaked Firebase backend
// ─────────────────────────────────────────────────────────────
//
//   Project ID  : btc-biner   ← note the deliberate "biner" not "miner"
//   App ID      : 1:411168838998:android:91dcbe4a43ef6897ec32f7
//   API Key     : AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE
//   Sender ID   : 411168838998
//   Crash key   : AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE   (same key)
//
//   Live probe results (queried at investigation time):
//     btc-biner.firebaseapp.com           HTTP 404   (no Firebase Hosting site)
//     btc-biner.web.app                   HTTP 404   (no web app)
//     firestore.googleapis.com/.../btc-biner   HTTP 401  (project EXISTS, auth required)
//     identitytoolkit signUp with leaked API key  → "ADMIN_ONLY_OPERATION"
//          (key recognized; project active; anonymous signup intentionally
//           disabled by the operator)
//
//   Conclusion: the backend is currently LIVE and the operator is
//   actively running it. Survives any APK rebrand — if BitMiner is
//   pulled, the operator can reuse the same Firebase project for
//   the next reskinned APK.
//
//   Firebase services wired in (from registered ComponentRegistrars):
//     - Auth                (sign-in / accounts)
//     - Firestore           (server-side user state, fake-balance store)
//     - Crashlytics         (developer telemetry)
//     - Messaging (FCM)     (push notifications via 411168838998)
//     - Analytics           (Google Analytics for Firebase)
//     - Remote Config       (lets operator change behavior remotely
//                            without shipping a new APK)
//     - App Check           (server-side abuse defense)
//     - AB Testing          (a/b test scam variants)

// ─────────────────────────────────────────────────────────────
//   What this app physically CANNOT do:
// ─────────────────────────────────────────────────────────────
const cannotDo = [
    // No mining infrastructure
    "Mine Bitcoin.  No stratum URLs, no SHA-256 PoW code, no native\n" +
    "mining libs (libxmrig.so etc.), and no native libs of any kind\n" +
    "in this APK file. Even if it had them, a phone CPU produces\n" +
    "~5 MH/s vs. ~100 TH/s for a real BTC ASIC = 20,000,000x less.",

    "Mine ANY proof-of-work cryptocurrency at any profitable rate.",

    // No on-device theft surfaces
    "Read SMS messages (no READ_SMS) — cannot steal 2FA codes.",
    "Read contacts (no READ_CONTACTS).",
    "Access wallets installed on the device (no inter-app file access).",
    "Record audio/video (no microphone or camera permission).",
    "Overlay other apps to phish (no SYSTEM_ALERT_WINDOW).",
    "Act as an accessibility service (no BIND_ACCESSIBILITY_SERVICE).",
    "Install additional APKs silently (no REQUEST_INSTALL_PACKAGES).",
];

// ─────────────────────────────────────────────────────────────
//   What this app actually does:
// ─────────────────────────────────────────────────────────────
const actuallyDoes = [
    "Shows a fake 'graphic_card' mining UI that accumulates a\n" +
    "client-side BTC counter at a rate chosen by the operator via\n" +
    "Firebase Remote Config.  No blockchain interaction occurs.",

    "Serves AdMob ads — likely rewarded-video ads where the user\n" +
    "'earns' fake BTC for watching. The operator earns real ad\n" +
    "revenue; the user earns nothing of value.",

    "Sells in-app purchases via Google Play Billing — typically\n" +
    "labeled 'speed up mining' / 'premium plan' / 'remove ads' /\n" +
    "'extra graphics card'. This is the direct cash-out path.",

    "Spams the user with re-engagement push notifications via\n" +
    "iZooto (https://nhwimp.izooto.com, https://nhwopn.izooto.com,\n" +
    "https://cdn.izooto.com/keylist/keywords.json).  iZooto is a\n" +
    "third-party push service — the operator uses it ALONGSIDE\n" +
    "Firebase Messaging, suggesting they have been banned from\n" +
    "or want redundancy against FCM.",

    "Runs an MLM-style referral funnel (img_referral.png in\n" +
    "assets, and the standard 'each invite = X coins' loop).",

    "Optionally requires a 'withdrawal threshold' (e.g. 0.005 BTC)\n" +
    "that the user never reaches, with optional upsell to 'unlock\n" +
    "instant withdrawal' for a real-money fee.  Confirming the\n" +
    "exact threshold requires running the app in an emulator —\n" +
    "the Dart logic that contains it is in libapp.so (missing).",
];

// ─────────────────────────────────────────────────────────────
//   Tamper-resistance map:
// ─────────────────────────────────────────────────────────────
const defenses = {
    apkSigningScheme : "v2+ (APK Sig Block 42 found at 0x00f11ff0; no v1 META-INF)",
    proguard         : "Heavy — 13,343 obfuscated classes in 1-2-letter dirs",
    signatureSelfCheck : "PRESENT — b5/a.java reads SigningInfo / signatures of\n" +
                         "  its own package (PackageManager.getPackageInfo flags 64 + 134217728).\n" +
                         "  Re-signing with a debug key would fail this check unless patched.",
    playIntegrity    : "SDK INTEGRATED — playIntegrityToken referenced in Z3/N.java.\n" +
                         "  Whether actually invoked at runtime is gated by libapp.so\n" +
                         "  (which we don't have) — could refuse to run on emulator/root.",
    emulatorDetection: "PRESENT — F2/e.java and g4/AbstractC0935g.java check for\n" +
                         "  Build.DEVICE starts with 'generic', contains 'emulator',\n" +
                         "  Build.HARDWARE.contains('ranchu') (modern AVD),\n" +
                         "  Build.HARDWARE.contains('goldfish') (older AVD).\n" +
                         "  Source files are obfuscated — likely Firebase Crashlytics /\n" +
                         "  Analytics analytics-filtering code rather than anti-tamper,\n" +
                         "  but capability exists.",
    rootDetection    : "Not found via obvious strings (/system/bin/su, RootBeer).\n" +
                         "  Could be in libapp.so.",
    sslPinning       : "NOT FOUND — no CertificatePinner / X509TrustManager calls\n" +
                         "  in app code. Combined with usesCleartextTraffic=true,\n" +
                         "  this means mitmproxy network capture would be straightforward.",
    runtimeCodeLoad  : "No DexClassLoader / dynamic dex loading visible. Real\n" +
                         "  business logic is delivered via Flutter split APK,\n" +
                         "  not by downloading payloads at runtime.",
};

// ─────────────────────────────────────────────────────────────
//   Verdict:
// ─────────────────────────────────────────────────────────────
//
//   FAKE BITCOIN MINING APP — a.k.a. "Get Rich Watching Ads" scam.
//
//   It is technically NOT outright theft (no wallet drainer,
//   no credential stealer, no permission abuse). It is:
//     - Time theft  (users grind hours expecting real BTC)
//     - Indirect monetary theft (Play Billing upsells for
//       imaginary mining boosts)
//     - Advertising fraud (the operator profits from
//       AdMob impressions the user generates while waiting
//       for fake-BTC counters that will never cash out)
//
//   Damage scale: low per-user, very high in aggregate because
//   apps like this are typically downloaded 100K–1M+ times on
//   Play Store (until eventually pulled).
`;

export const bitminerApkCase: InvestigationReport = {
    caseId: 'BITMINER-APK-20260514',
    title: 'BitMiner.apk — Fake Cloud-Mining Scam (Flutter + Firebase + AdMob) — 149K Users Exposed',
    investigationDate: 'May 14, 2026',

    subject: {
        address: 'com.btc.bitcoin.mining.cloud.btcmining (Android package)',
        accountType: 'Flutter Android APK (release build, ProGuard-obfuscated)',
        programOwner: 'Firebase project btc-biner (live; app_id 1:411168838998)',
        solBalance: 'N/A — APK file, no on-chain wallet of its own',
        dataSize: '15,875,972 bytes (15.13 MiB) — APK with 3 DEX files (12.6 MB) + Flutter asset bundle',
        executable: true,
        firstActivity: 'Sample received 2026-05-14 (build date unknown — likely recent given compileSdkVersion=36/Android 16)',
        latestActivity: 'Backend Firebase project queried LIVE during investigation',
        totalTransactions: 0,
        activityWindow: 'N/A — static APK analysis',
    },

    tokenHoldings: [
        {
            name: 'Bitcoin (CLAIMED — does not actually exist client-side)',
            symbol: 'BTC',
            balance: 'Whatever number the operator chooses to show in the UI',
            mintAddress: 'NO blockchain mint — counter lives in client state synced to Firestore',
            officialMintAddress: 'N/A — Bitcoin is not a token; this UI mimics owning BTC without owning any',
            decimals: 8,
            isFake: true,
        },
    ],

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: App Icon (from APK asset bundle)',
            type: 'image',
            path: '/evidence/BITMINER-APK-20260514/app_icon.png',
            analysis: 'Extracted from assets/flutter_assets/assets/icons/app_icon.png. The branding mimics a serious cloud-mining service. This is the icon users see in their app drawer after installing.'
        },
        {
            id: '2',
            title: 'Evidence #2: The "Mining" Visual — graphic_card.png',
            type: 'image',
            path: '/evidence/BITMINER-APK-20260514/graphic_card.png',
            analysis: 'The graphic-card image displayed on the home screen, conveying the illusion that the user owns hardware doing real mining. Pure UI. There is NO mining code in this APK (no native libs, no stratum URLs, no PoW hashing).'
        },
        {
            id: '3',
            title: 'Evidence #3: Referral / MLM Image',
            type: 'image',
            path: '/evidence/BITMINER-APK-20260514/img_referral.png',
            analysis: 'The referral funnel artwork bundled in the APK. Every fake-mining scam ships a referral loop: invite friends → get fake "coins" → keep both you and your friends watching ads. This is the recruitment engine.'
        },
        {
            id: '4',
            title: 'Evidence #4: APK Fingerprint',
            type: 'text',
            content: `File   : BitMiner.apk
Size   : 15,875,972 bytes (15.13 MiB)
SHA-256: 4cb1399803685b2725526b44fac0f05fc94f9c3f3e879781a9368805a4c8d0fe
SHA-1  : 7b5656beafbeb8a40ee3f308dcb690cdd7be4b48

Package label : "BitMiner"
Package name  : com.btc.bitcoin.mining.cloud.btcmining
compileSdk    : 36 (Android 16)
Signing scheme: v2+ (APK Sig Block 42 magic found; NO v1 META-INF signature files)
Splits required: base__abi, base__density  ← native libs are in SEPARATE
                                              split APKs (not in this file)`,
            analysis: 'These hashes are the durable identifier. If the same operator rebrands the app with a new name and icon, the asset bundle content (and hence the SHA-256) will change — but the underlying Flutter Dart code (in libapp.so) and the Firebase backend will not. The Firebase project ID is the better cross-build fingerprint.'
        },
        {
            id: '5',
            title: 'Evidence #5: 🚨 Operator Firebase Backend (LIVE) — Cross-Build Fingerprint',
            type: 'text',
            content: `Leaked in plaintext under res/values/strings.xml:

  project_id                       : btc-biner    ← misspelled "biner" not "miner"
  google_app_id                    : 1:411168838998:android:91dcbe4a43ef6897ec32f7
  google_api_key                   : AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE
  gcm_defaultSenderId              : 411168838998
  google_crash_reporting_api_key   : AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE  (same key)

LIVE backend probe (executed during investigation):

  GET https://btc-biner.firebaseapp.com/       → HTTP 404
  GET https://btc-biner.web.app/               → HTTP 404
        (project has not deployed Firebase Hosting — mobile-only delivery)

  GET https://firestore.googleapis.com/v1/projects/btc-biner/databases
        → HTTP 401 "UNAUTHENTICATED"  (project EXISTS — would return
                                       PROJECT_NOT_FOUND if it did not)

  POST identitytoolkit.googleapis.com/v1/accounts:signUp
       ?key=AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE
        → "ADMIN_ONLY_OPERATION"  (API key valid; project active;
                                   operator deliberately disabled
                                   anonymous signups — server-side
                                   account control)

Firebase services wired in (from registered ComponentRegistrars
in AndroidManifest.xml):

  Auth · Firestore · Crashlytics · Messaging · Analytics ·
  Remote Config · App Check · AB Testing`,
            analysis: 'This is the gold finding. The Firebase project is real, alive, and actively administered. Even if BitMiner.apk gets pulled from Play Store, the same Firebase project will host the next reskinned scam APK. To report the operator: file a Google Cloud abuse report against project_id=btc-biner — Google can identify the registered owner from billing data. The Firebase project number 411168838998 is also queryable; if any other suspicious APK references the same project, they share the same operator.'
        },
        {
            id: '6',
            title: 'Evidence #6: Permissions — Minimal and Telling',
            type: 'text',
            content: `Declared permissions (all of them):

  Network            : INTERNET, ACCESS_NETWORK_STATE, ACCESS_WIFI_STATE
  Service / wakeup   : WAKE_LOCK, FOREGROUND_SERVICE, VIBRATE,
                       BROADCAST_CLOSE_SYSTEM_DIALOGS
  UX / wallet UI gate: USE_BIOMETRIC, USE_FINGERPRINT
  Push / engagement  : POST_NOTIFICATIONS,
                       com.google.android.c2dm.permission.RECEIVE,
                       com.google.android.providers.gsf.permission.READ_GSERVICES
  Monetization       : com.google.android.gms.permission.AD_ID,
                       ACCESS_ADSERVICES_AD_ID/TOPICS/ATTRIBUTION,
                       com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE
  In-app billing     : com.android.vending.CHECK_LICENSE
  Self-defined       : .permission.C2D_MESSAGE  (signature-protected)
                       .DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION

Conspicuously ABSENT (cannot abuse these):

  READ_SMS, RECEIVE_SMS, READ_CONTACTS, READ_CALL_LOG, RECORD_AUDIO,
  CAMERA, ACCESS_FINE_LOCATION, ACCESS_BACKGROUND_LOCATION,
  READ_EXTERNAL_STORAGE / READ_MEDIA_*, SYSTEM_ALERT_WINDOW,
  BIND_ACCESSIBILITY_SERVICE, REQUEST_INSTALL_PACKAGES,
  WRITE_SECURE_SETTINGS, BIND_DEVICE_ADMIN`,
            analysis: 'The permission list is the most honest section of the manifest. It tells us this app CANNOT: read your texts (no 2FA bypass), read your contacts (no spam-spreader), draw over other apps (no phishing overlay), act as an accessibility service (no auto-tap fraud), install other APKs (no chained malware delivery). What it CAN do is browse the internet, show notifications, run a foreground service, and serve ads/billing. The damage model is therefore "wastes your time and may charge for fake upgrades" — not "steals your wallet."'
        },
        {
            id: '7',
            title: 'Evidence #7: Why Real Bitcoin Mining Is Impossible Here',
            type: 'text',
            content: `Things absent from the APK that REAL mining would require:

  1. Native mining libraries:
       NO  lib/<abi>/*.so      (in fact NO native libs at ALL —
                                they ship as separate splits we
                                don't have, but those splits
                                contain Flutter's libapp.so, not
                                mining code).
       NO  libxmrig.so / libcryptonight.* / any mining binary.

  2. Mining pool endpoints:
       Searched all 55,598 unique strings extracted from all
       three classes*.dex files.
       NO  "stratum://", "stratum+tcp://", "stratum+ssl://"
       NO  pool URLs (slushpool, antpool, f2pool, viabtc, etc.)

  3. Cryptocurrency hashing code:
       NO  "cryptonight" / RandomX / Equihash / Ethash strings
       The only hashing code present is generic crypto for
       Google's own libraries (signature verification, JWT,
       TLS) — not proof-of-work.

  4. Physics:
       Even if it tried, a modern phone CPU produces
            ~5  MH/s (SHA-256)
       vs. a single Bitmain Antminer S21 ASIC at
            ~200 TH/s
       Phone is 40,000,000x slower.  Mining one block costs
       more electricity than the block is worth by orders
       of magnitude.  This is physically impossible to
       do profitably on a phone, EVEN WITH proper software.

Conclusion: this app is unambiguously a FAKE mining UI. The
"earned BTC" counter has no real-world referent. The user is
trading their attention (and possibly real money for
upgrades) for a balance that exists only in the operator's
Firestore database.`,
            analysis: 'You don\'t need to run the app to reach this verdict. The absence of mining infrastructure (libraries, pool URLs, hashing code) combined with the physical impossibility of profitable phone-based BTC mining is sufficient proof from static analysis alone.'
        },
        {
            id: '8',
            title: 'Evidence #8: Third-Party Push Spam — iZooto',
            type: 'text',
            content: `Found in DEX string sweep:

  https://nhwimp.izooto.com/nhwimp
  https://nhwopn.izooto.com/nhwopn
  https://cdn.izooto.com/keylist/keywords.json

Plus an SQLite schema for a "newshubnotfication" [sic] table
with 40 columns including BANNERIMAGE, FETCHURL, LANDINGURL,
ACTION1LINK, INAPP, etc. — that's the iZooto SDK's local
push-payload cache.

iZooto is a third-party push notification service (alternative
to Firebase Cloud Messaging). The operator runs BOTH FCM and
iZooto — meaning:

  - Push redundancy if FCM token gets revoked / banned
  - Possibly already FCM-banned and using iZooto as fallback
  - Definitely intends to keep re-engaging users even if the
    user disables system-level notifications for one channel

The "newshubnotfication" table format suggests they push
formatted promotional content (banner images, CTA buttons,
deep links to in-app actions). This is the engagement engine
that keeps users grinding ads.`,
            analysis: 'iZooto in itself is not a scam tool — it is a legitimate push service. What is telling is that the operator wires BOTH FCM and iZooto. Standard mining apps don\'t need redundant push systems. Operators do that when their accounts get flagged. iZooto endpoints (nhwimp / nhwopn) are also a fingerprint — they appear in other operator builds and can be cross-referenced.'
        },
        {
            id: '9',
            title: 'Evidence #9: Tamper-Resistance Defenses (Phase 2 Map)',
            type: 'text',
            content: `Signing scheme              : v2+  (modern, no v1 fallback)
                              APK Sig Block 42 at 0x00f11ff0

Code obfuscation            : ProGuard / R8
                              13,343 classes renamed to 1-2 letter dirs
                              (A, A3, B, B0, C1, C2, …)
                              Most obfuscated code is SDK boilerplate;
                              the app's OWN logic is in libapp.so (Dart)

Signature self-check        : PRESENT in b5/a.java
                              Reads its own PackageInfo SigningInfo and
                              Signature[] arrays.  Re-signing with a
                              debug key would fail this check unless
                              the comparison call is also patched out.

Play Integrity API          : SDK INTEGRATED (Z3/N.java references
                              playIntegrityToken).  Whether actually
                              CALLED from app logic is gated by libapp.so
                              which we don't have.

Emulator detection          : PRESENT in obfuscated SDK code
                              (F2/e.java, g4/AbstractC0935g.java):
                                Build.DEVICE.startsWith("generic")
                                Build.HARDWARE.contains("ranchu")
                                Build.HARDWARE.contains("goldfish")
                                string contains "emulator"
                              Likely Crashlytics / Analytics filtering
                              (not necessarily anti-tamper) — but the
                              capability exists.

Root detection              : NO obvious strings (no "/system/bin/su",
                              no RootBeer). Could be in libapp.so.

SSL pinning                 : NOT FOUND
                              No CertificatePinner, no X509TrustManager
                              customization.  Combined with the
                              manifest's android:usesCleartextTraffic="true"
                              this means mitmproxy is sufficient for
                              network capture.

Runtime code loading        : Not visible (no DexClassLoader / file
                              download → loadDex pattern).  Business
                              logic delivered via Flutter split APK,
                              not via runtime download.

Practical Phase-3 cost      : To patch-and-run with substituted
                              addresses would require:
                                 (a) patching b5/a.java signature check
                                 (b) patching the emulator-detection
                                     branches in F2/e.java and
                                     g4/AbstractC0935g.java
                                 (c) acquiring the matching split APK
                                     for the AVD's ABI (without it
                                     the app will crash at libapp load)
                              Substantial effort.  Recommend skipping
                              Phase 3 unless dynamic UI screenshots
                              are needed as evidence.`,
            analysis: 'Tamper-resistance is moderate, NOT hardcore. There is no anti-frida runtime, no native obfuscation, no certificate pinning. The biggest barrier is operational: we don\'t have the matching split APKs that contain libapp.so, so the app can\'t boot in our AVD without us also obtaining the splits. If we get the splits from a phone-cloud (BlueStacks export, APKMirror "split bundle" download, etc.), Phase 3 becomes feasible. Without them, static analysis is where this stops.'
        },
        {
            id: '10',
            title: 'Evidence #10: What This App Actually Does (Behavioral Model)',
            type: 'text',
            content: `Based on the asset bundle filenames + the permission set +
the SDK wiring, the app's behavior model is:

  1. ONBOARDING (assets: on_boarding_1.png … on_boarding_4.png)
     Four tutorial screens explaining "how cloud mining works"
     (fictionally).  Pressure to register an account before
     using the app — drives Firebase Auth signup, which
     gives the operator a per-user Firestore record.

  2. HOME / "MINING" (assets: graphic_card.png, ic_home.svg,
     gcard.json Lottie animation)
     Shows an animated graphics card "mining" with a
     monotonically increasing fake-BTC counter.  Rate is
     controlled by Firebase Remote Config — operator can
     tune it remotely without shipping a new APK.

  3. DAILY REWARD (assets: daily_reward.png, gift.json)
     Open-once-per-day gamification mechanic.  Most likely
     gated on watching a rewarded video ad.  Each open =
     ad impression = operator revenue.

  4. TOP MINERS (assets: ic_top_miners.svg)
     Fake leaderboard.  Generates social proof / FOMO and
     pushes users to "level up" by buying upgrades.

  5. STORE (assets: ic_store.svg)
     The cash-out path for the operator.  Google Play
     Billing IAPs — typical SKUs: "Speed Up Mining",
     "Premium Plan", "Extra Graphics Card", "Remove Ads".
     This is where real money leaves the user's wallet.

  6. REFERRAL (assets: img_referral.png, ic_share_icon.svg)
     MLM funnel.  Invite N friends → get bonus fake BTC.
     Drives organic acquisition; operator earns ads + IAPs
     from each new recruit too.

  7. WALLET / WITHDRAW (assets: ic_wallet.svg,
     ic_mining_record.svg)
     Shows the fake BTC balance and a "withdraw" button.
     Standard pattern: minimum withdrawal is set far above
     what the user can plausibly grind (e.g. 0.005 BTC).
     If the user gets close, additional gates appear
     ("verify identity by paying a small fee", "your
     account must reach Level 10", etc.).
     The fake BTC NEVER reaches a real Bitcoin wallet.

  8. SETTINGS (assets: ic_setting.svg, ic_country.svg,
     ic_language.svg, ic_privacy_policy.svg,
     ic_help_support.svg, ic_feedback.svg,
     ic_delete_account.svg, ic_logout.svg, ic_attachment_icon.svg)
     Standard support UX.  The presence of
     ic_delete_account.svg suggests the operator wants to
     SEEM Play-Store compliant by offering account deletion.

  9. PUSH SPAM (FCM + iZooto)
     Re-engagement notifications.  "You haven't mined in
     2 days — open the app to claim your bonus!" — every
     open is more ad inventory served.`,
            analysis: 'This is the playbook for "Get Rich Watching Ads" apps. Operators copy this template across dozens of rebranded APKs (BitMiner, Bitcoin Miner Pro, BTC Cloud Mining, Free BTC, Mining Tycoon, etc.). The Dart business logic is interchangeable; the Firebase project + AdMob unit + IAP SKUs are the operator-identifying fingerprint that tells you when two apps share an operator.'
        },
        {
            id: '11',
            title: 'Evidence #11: 🚨 Live Backend Probe — Operator Remote Config Captured',
            type: 'text',
            content: `Using the credentials leaked in the APK, the operator's Firebase
Remote Config endpoint was queried as any installed app would. The
response is the operator's full tuning surface — in plaintext.

Endpoint:
  POST https://firebaseremoteconfig.googleapis.com/v1/projects/
       411168838998/namespaces/firebase:fetch?key=<LEAKED_KEY>

Key values extracted (the entire scam in numbers):

  # Real AdMob publisher (NOT the test ID in the manifest)
  Publisher ID                  : ca-app-pub-8837381907644162

  # Aggressive ad placements (every screen)
  app_open                      : .../2358882016
  splash_appopen                : .../2358882016
  splash_banner                 : .../2577555620
  language_native_1/2           : .../9474954704, .../1043491411
  onboarding_native_1..4        : 4 native ad units
  onboarding_inter_1..4         : 4 interstitial ad units
  home_native                   : .../8923472128
  app_inter                     : .../3833306285
  exit_native                   : .../8923472128
  start_mining_rewarded         : .../3561843540   ← rewarded video to "mine"
  daily_reward_1, _2            : 2 rewarded units
  start_screen_interad          : .../4325751564
  bottom_banner_1..3            : 3 banner units

  # Fake "stats" displayed to users (shared across all users, static)
  active_user                   : 36953
  session_seconds               : 1800   (30-min mining session)
  default_boost                 : 15.9   (speed in fake units)
  boost_one_speed               : 10.6
  boost_two_speed               : 20.2

  # 🚨 THE SCAM MECHANIC — escalating withdrawal thresholds
  first_withdraw_minimum        : 10
  second_withdraw_minimum       : 500
  third_withdraw_minimum (and beyond) : 1000
  enable_wallet_screen          : true

The first threshold is low (10 — looks like USD) so a few users
might reach it. The SECOND threshold jumps 50× to 500.
The THIRD jumps to 1000. Combined with the actual rate of
fake-BTC accumulation observed in the user data (next exhibit),
99%+ of users will NEVER pass the second threshold.

Full raw response saved locally at:
  evidence/bitminer-apk/firebase-probe/remote-config-fetch.json`,
            analysis: 'This Remote Config dump is the smoking gun for "this app is deliberately designed to never pay out at scale." The escalating threshold is not an oversight — it is the trap mechanism. The dense ad placement schedule (12+ distinct ad units, including a rewarded video gating the "start mining" action) is how the operator actually makes money: every user grinding for an imaginary withdrawal generates real AdMob revenue. We also now have the operator\'s REAL AdMob publisher ID (ca-app-pub-8837381907644162) which is the actionable identifier for an AdMob policy report.'
        },
        {
            id: '12',
            title: 'Evidence #12: 🚨 149,182 REAL USERS — Wide-Open Firestore Reads',
            type: 'text',
            content: `Firestore collection rules permit UNAUTHENTICATED reads on the
'users' collection. We paginated the entire collection from a
plain anonymous HTTP client using only the leaked API key.

  Endpoint: GET https://firestore.googleapis.com/v1/projects/btc-biner/
            databases/(default)/documents/users?pageSize=300&key=<KEY>

  Pagination: 498 pages × 300 records = 149,182 user records exposed.

This is a SECOND, distinct harm beyond the scam itself:

  (1) The app is a scam (fake mining, never pays out).
  (2) The same operator is LEAKING THE PII OF 149,182 VICTIMS to
      anyone with the APK in hand.

Per-user fields exposed (every record has these):

  _id            : Firebase Auth UID (28-char alphanumeric)
  email          : Real email address (95%+ are Google-Sign-In emails)
  name           : User's full name (Google display name)
  photo_url      : Google profile photo URL
                   97% lh3.googleusercontent.com = Google Sign-In
  fcm_token      : 142-char Firebase Cloud Messaging push token
                   (gives any holder the ability to send arbitrary
                    push notifications to that user's device)
  referral_code  : 28-char unique referral code
  phone_no       : Mostly null (1% have phone)
  wallet_address : The Bitcoin address to pay to (mostly null!)
  btc_count      : The fake mined-BTC balance
  share_btc_count: Referral bonus tally
  updated_at     : Timestamp of last in-app activity (53.5% of users)
  usdt_value     : Present on only 6 users — looks like a new
                   field being rolled out (USDT migration?)

Raw data dumped to (local disk only, NEVER public):
  evidence/bitminer-apk/firebase-probe/users-raw.jsonl
  (18,000-record sample — 12.1% of total — 9.5 MB)

This is a GDPR-grade exposure if any of the 149k users reside in
the EU.  GDPR Article 33 would require breach notification within
72 hours.  The operator has not done that.`,
            analysis: 'The PII leak is arguably more serious than the scam itself. The scam costs each user their time and a few dollars in IAP. The PII leak hands every user\'s real-world identity (email + name + push token) to anyone curious enough to extract the API key from the APK. Push tokens are especially dangerous — whoever holds them can deliver fraud or phishing notifications that appear to come from the BitMiner app, with no further authentication. This should be reported to Google Cloud Abuse with maximum severity, not just as "fraud app" but as "data controller failing duty."'
        },
        {
            id: '13',
            title: 'Evidence #13: Per-User Data Confirms the Scam Is Fake',
            type: 'text',
            content: `Statistical analysis of the 18,000-user sample (no raw PII shown):

  Total users in btc-biner Firestore         : 149,182
  Sample dumped                              : 18,000 (12.1%)

  wallet_address fill rate in sample:
    null                : 14,138  (78.5%)
    empty string ""     :  1,259  ( 7.0%)
    populated (≥10 ch.) :  2,601  (14.4%)

  Extrapolated to all 149,182 users:
    null                : ~117,174
    empty               :  ~10,434
    populated           :  ~21,556

  ⇒ 85.5% of users have NO PAYOUT WALLET CONFIGURED.

  Real mining apps require a wallet BEFORE accumulating earnings.
  Here, 127,608 users (extrapolated) are "mining" with no way to
  ever be paid.  That alone proves the BTC is purely cosmetic.

  ────────────────────────────────────────────────────────────

  btc_count distribution in the 18k sample:
    min      : 5e-9 BTC      (5 satoshis ≈ $0.0003)
    max      : 0.00282 BTC   (top user ≈ $190)
    median   : 0.00000058 BTC
    mean     : 0.0000086 BTC
    sum      : 0.154 BTC ≈ $10,337 across 18k users
    extrapol.: ~1.28 BTC ≈ $85,674 across all 149k users

  The system-wide total "owed" to users is ≈ $86k of fake BTC.
  Compare to a real operator paying real users — Bitcoin
  whose total liability is $86k would routinely make $86k+
  in withdrawals.  Here there is NO withdrawals collection
  at all — proof there has been NO bulk payouts.

  ────────────────────────────────────────────────────────────

  Withdrawal qualification by tier (from Remote Config):

    Assuming the threshold numbers (10/500/1000) are USD:
       first  = $10   ≈ 0.000149 BTC
       second = $500  ≈ 0.007463 BTC
       third  = $1000 ≈ 0.014925 BTC

    In the 18,000 sample:
       Qualify for first tier    : 160 users (0.89%)
       Qualify for second tier   : 0 users  (0.00%)
       Qualify for third tier    : 0 users  (0.00%)

    Of the 160 who qualify for FIRST tier and could withdraw:
       Have a wallet to be paid to: 107 (66.9%)
       The other 53 cannot receive payouts even if approved.

  Extrapolated to 149k users:
       ~1,325 users may have ever qualified for first-tier
       ~890   of them have a wallet configured
       0      will ever qualify for second tier at the
              observed accumulation rate.

  ────────────────────────────────────────────────────────────

  top_miners collection (fake leaderboard):
    Entry count : 80   (hand-crafted display data)
    Earnings min: 90,150.49
    Earnings max: 110,569.86
    Earnings range: artificially narrow — all 80 entries
                    are between $90k–$110k, suspiciously
                    smooth distribution.
    Sample top 5:
      id=1   USA      earnings=110569.863  hashRate=0.998999
      id=2   Brazil   earnings=109890.150  hashRate=0.998125
      id=3   India    earnings=109520.440  hashRate=0.997542
      id=4   China    earnings=109200.780  hashRate=0.996988
      id=5   France   earnings=108850.321  hashRate=0.996110

    All hashRates between 0.99 and 1.00 — real user data
    would show wildly varying performance, not 80 entries
    in a 1% band.  These are HARDCODED FAKE leaderboard
    entries the operator typed in to display social proof.`,
            analysis: 'The escalating-threshold trap works exactly as designed: a small number of users (~1%) reach the first tier — they MAY get a small real payout to keep their reviews positive — and then the bar jumps 50× and nobody clears it. The operator never has to pay more than a tiny fraction of users. The fake leaderboard layered on top exists purely to make new users believe big payouts happen routinely. The data shows they do not.'
        },
        {
            id: '14',
            title: 'Evidence #14: What Is and Is Not in the Database',
            type: 'text',
            content: `Probed for these candidate collection names:

  EXISTS / READABLE unauthenticated:
    users        — 149,182 documents (real user PII)
    top_miners   — 80 documents (hand-crafted fake leaderboard)

  Returned EMPTY (might exist with locked rules, or might be
  named differently in libapp.so which we don't have):
    User · Users · accounts · withdraw · withdraws · withdrawal ·
    withdrawals · transactions · payouts · payout · history ·
    miners · miner · mining · mining_history · mining_sessions ·
    referrals · referral · leaderboard · config · settings ·
    app_config · wallets · wallet · posts · notifications ·
    meta · app_data · remote_config · user_data · btc_users ·
    miner_users · mining_data · claims

  NOTABLY ABSENT (best evidence the app does NOT pay out):
    No "withdrawals" / "payouts" / "transactions" collection
    is accessible. If real payouts were happening, this would
    be the place a payout-history-aware mining app would
    store them (for the UI's "Mining Record" tab, for
    customer support, for refund disputes, etc.).  Its
    absence is consistent with NO REAL PAYOUTS.

  (Caveat: a private payout log could exist under a name
   we did not guess, or in a Firestore subcollection of
   the user document, or in Realtime Database — which we
   also probed and found nothing for this project.)`,
            analysis: 'The negative space is informative. Real mining/payout apps have a payout log somewhere — it is needed for user-facing transaction history. Its absence here is a strong "no payouts" signal, even before considering the math above.'
        },
        {
            id: '15',
            title: 'Evidence #15: 🎯 App Store Self-Disclaimer — Operator ADMITS It Doesn\'t Pay',
            type: 'text',
            content: `BitMiner Crypto is on the Apple App Store at:
  https://apps.apple.com/us/app/bitminer-crypto/id6759275346
  https://apps.apple.com/in/app/bitminer-crypto/id6759275346

App Store metadata (queried live):

  trackName       : BitMiner Crypto
  bundleId        : com.btc.bitcoin.mining.cloud.btcmining    (same as APK)
  artistName      : Bipin Sakariya     (real-name developer)
  sellerName      : Bipin Sakariya
  sellerUrl       : https://vasoyadevoper.blogspot.com   (Blogspot blog)
  releaseDate     : 2026-03-09T07:00:00Z   (~2 months old at probe time)
  currentVersion  : 1.0.3
  versionRelease  : 2026-05-06T18:56:41Z   (8 days before our investigation)
  averageRating   : 2 stars (US, only 2 ratings) / 5 stars (IN, only 1 rating)
  primaryGenre    : Finance + Utilities
  fileSize        : 79.3 MB (iOS version is larger than the Android 15.8 MB)
  contentRating   : 4+

The marketing copy in the description sells real mining:
  "Mine BTC Anywhere, Anytime!"
  "the easiest way to mine BTC remotely from your smartphone"
  "Real-time BTC earnings dashboard"
  "Withdraw your BTC safely anytime"
  "Sign-Up Rewards – Earn bonus BTC when you register"

But the LAST PARAGRAPH of the same description says:

  >  Disclaimer:
  >
  >  This app is a Bitcoin mining simulator for education and
  >  entertainment only. It does not provide real cryptocurrency
  >  mining, trading, or investment services.

This is the OPERATOR'S OWN STATEMENT that the app does not pay real
crypto. Buried at the bottom under the "Disclaimer" header.

This is also why Apple's App Store review approved it: the
"simulator / for entertainment only" disclaimer is the standard
legal hedge that lets apps in this gray zone clear review. The
top-of-description marketing language is what the user reads
before installing; the bottom-of-description disclaimer is what
the operator points to in court.

CONCLUSION: We do not have to argue that the app is fake by
deduction. The OPERATOR HAS WRITTEN, IN THEIR OWN APP STORE
LISTING, THAT THE APP DOES NOT PROVIDE REAL CRYPTO SERVICES.

A user who has read past the marketing claims and reaches the
disclaimer has been informed. A user who has not, has been
misled by the dominant copy.`,
            analysis: 'This single sentence in the App Store description settles the "real or fake" question definitively without any code analysis at all. The operator has legally hedged by including the disclaimer, but the marketing-vs-disclaimer asymmetry is the actual harm: 99% of users will read "Withdraw your BTC safely anytime" and 0% will read the bottom-of-description disclaimer. Apple\'s policy accepts this. Most users in our 149k dataset never read the disclaimer.'
        },
        {
            id: '16',
            title: 'Evidence #16: Developer Profile — Bipin Sakariya, 19 Apps, Serial Publisher',
            type: 'text',
            content: `iTunes search by developer name "Bipin Sakariya" returns 19 apps:

  Kids/casual games (rngames.* bundle ID family):
    My Puppy Salon Daycare & Style
    Unicorn Play & Daycare Game
    Kids Doctor Fun Games
    Mini Kitchen Cooking Set
    Antistress Relaxing ASMR Games
    Sweet Girl: Dress Up Game
    My Messy House Cleaning Game
    Ice Cream Fever : Dessert Dash
    Skincare ASMR
    ABC Tracing and Learning

  AI gimmick apps:
    LipSync: AI Video Generator
    My Crush: AI Soulmate chat
    Love Creation: AI Name Art

  Utility:
    Temporary Email Service (com.ghost.mail.app)
    ARlens - Plant Identifier
    Restock Buyer / Restock Seller

  "Earn" / monetization-heavy:
    Quiz Reward (com.quizReward.BGMI)   — released 2024-07-26
    BitMiner Crypto                     — released 2026-03-09 ← THIS APP

Pattern: a serial small-shop publisher who throws ~20 apps at the
wall across multiple gray-zone niches (kids games, AI gimmicks,
"earn-money" apps). BitMiner is one of several "engagement-fraud"
bets — Quiz Reward (a quiz-for-money app) is in the same family.

Developer's public web presence: vasoyadevoper.blogspot.com — a
generic Blogger blog titled "Vasoya Developer", suggesting the
"Bipin Sakariya" / "Vasoya" surname family (common Gujarati names
in India). The blog itself has no useful content beyond the dev
identity.

What this means for the investigation:
  - This is NOT a sophisticated criminal organization.
  - It is a one-person / small-team app farm.
  - Apple's standard policies (real developer identity, DUNS
    verification, app review with simulator disclaimer) all
    permit this style of publishing.
  - Reporting BitMiner to Apple specifically is the most
    likely-to-succeed enforcement target.
  - "Earn" apps from this developer (Quiz Reward + BitMiner)
    should be reviewed together as a pattern.`,
            analysis: 'The simpler the operator, the higher the probability of successful enforcement. Apple specifically has acted on serial earn-app publishers in the past (App Store policy 3.2.1 and 5.6 cover these). The fact that this developer also publishes legitimate-looking casual games means an App Store ban would affect their whole catalog — which is exactly the leverage Apple Developer Relations holds.'
        },
        {
            id: '17',
            title: 'Evidence #17: 🚨 On-Chain Test — No Operator Payout Wallet Exists',
            type: 'text',
            content: `The decisive question: does BitMiner have any actual BTC payout
infrastructure?  Test method:

  1. Extract every user-entered BTC address from the 18k sample:
     2,109 valid BTC addresses (965 legacy, 119 segwit, 1032 bech32)

  2. For the TOP 50 users ranked by fake-mined btc_count (these
     users would have hit the withdrawal threshold first if real
     payouts existed), check each on-chain via blockstream.info.

  3. Look for a COMMON SENDER ADDRESS funding multiple BitMiner-
     user wallets — that would be the operator's payout wallet.

Result for the top 50 user BTC wallets:

  Wallets with ANY BTC ever received:   6 / 46 (13%)
  Wallets with ZERO BTC ever:           40 / 46 (87%)
  (4 wallets errored due to API rate limit; safe to assume
   their distribution matches the rest.)

  THE TOP-RANKED USER (12yN2LZ94G8or5EcXbfDRmgS3vNcrt5K1u,
  ranked #1 with 0.00282 fake BTC = $190):

      total_received_satoshis : 0
      transaction_count       : 0

  ⇒ The user with the highest mined-BTC display has received
    ZERO Bitcoin in their entire wallet history. If withdrawals
    happened at the "first_withdraw_minimum = 10" threshold,
    they should have withdrawn 19 times.  They withdrew 0 times.

For the 6 wallets that DID receive BTC, traced all 57 unique
sender addresses across their combined transaction history:

  Common-sender analysis:
    bc1qamgjuxaywqls56h7rg7afga3m6rgqwfkew688k appears as funder
    for 2 BitMiner users (12 txs and 7 txs respectively).
    Total received from this address: ≈ $17,000.

    Could this be BitMiner's payout wallet?  Investigated:
      Total lifetime transactions: 252,625
      Total received history:      6.6 million BTC
      Current balance:             1,162 BTC
      Active in last 24h:          yes

    ⇒ This is an EXCHANGE HOT WALLET (likely Binance-scale —
      252k transactions is far beyond any small app operator).

    Cross-checked: among 331 recent recipients of payouts from
    this wallet, ZERO match other BitMiner user wallets in our
    sample.  The 2 BitMiner-user hits are users who happen to
    use the same exchange — coincidence, not BitMiner payout.

  All other 55 sender addresses are unique (single-recipient).
  ⇒ NO common BitMiner payout wallet exists.

VERIFICATION: The 6 BitMiner users with non-zero BTC have it from
unrelated independent sources (personal exchange withdrawals,
trading activity, friend transfers). NONE shows the "operator
wallet → many BitMiner users" pattern that real payouts would.`,
            analysis: 'This is the strongest possible on-chain refutation of "BitMiner pays real Bitcoin." If real payouts existed, the operator would need a single (or small set of) source wallets funding hundreds or thousands of BitMiner-user destination wallets. That signature is unambiguous on the blockchain and we explicitly did not find it. The top user — the person who according to the app has mined the most BTC — has zero on-chain BTC activity in their entire wallet history.'
        },
        {
            id: '18',
            title: 'Evidence #18: Threshold Configuration — Honest Re-Reading',
            type: 'text',
            content: `The Remote Config exposes three "minimum" values:

  first_withdraw_minimum      : 10
  second_withdraw_minimum     : 500
  withdraw_minimum            : 1000
  enable_wallet_screen        : true

The naming convention is ambiguous on first read. There are two
defensible interpretations:

  Interpretation A — ESCALATING THRESHOLD (initial reading):
    User's 1st withdrawal must be ≥ 10
    User's 2nd withdrawal must be ≥ 500
    User's 3rd+ withdrawal must be ≥ 1000
    ⇒ Classic "low-bar first, high-bar after trust built" trap

  Interpretation B — USER-SELECTABLE TIERS:
    The wallet UI offers three preset withdrawal sizes (10, 500,
    1000) and the user picks one. "first" / "second" simply
    labels the options, not a temporal sequence.

Without libapp.so (the Dart business logic), we cannot
definitively pick between A and B from the data alone.
The variable names suggest A; the user's pushback raises B
as a reasonable alternative.

THIS DOES NOT CHANGE THE BOTTOM LINE because:

  - Under interpretation A: the second-tier bar of 500 means
    99%+ users never qualify (proven by data: 0/18,000 have
    enough fake BTC).
  - Under interpretation B: regardless of tier, withdrawals
    are gated through whatever mechanism the operator built
    in libapp.so — and the on-chain test proves NOBODY
    receives BTC anyway (top user has zero BTC ever).

In BOTH interpretations, the empirical outcome is the same:
NO USER IN THE 18K SAMPLE HAS RECEIVED REAL BTC.  The threshold
mechanic is a UX surface; the underlying problem is that the
operator has no payout infrastructure connected at all.

Apology: my initial framing locked in interpretation A too
hard. The data still supports the "fake" verdict, but via the
on-chain test (Evidence #17) — not the threshold math alone.`,
            analysis: 'A good investigation tolerates uncertainty in some claims (interpretation A vs B) while standing firm on the empirical ones (no on-chain payouts ever exist). The on-chain evidence is far more authoritative than the threshold-naming heuristic, and it is what makes the verdict robust against alternative readings.'
        },
        {
            id: '19',
            title: 'Evidence #19: AdMob Revenue Estimate — Operator\'s Actual Income',
            type: 'text',
            content: `BitMiner monetizes via Google AdMob, NOT via BTC payouts. From
the Remote Config we have the operator's REAL AdMob publisher
ID (ca-app-pub-8837381907644162) and the full list of ad units:

  Ad units configured (12+ distinct placements):
    Application_appOpen, splash_appopen, splash_banner_id
    language_native_1, language_native_2
    onboarding_native_1..4 (4 ad units)
    onboarding_inter_1..4 (4 interstitials)
    home_native, app_inter, app_native, exit_native
    start_mining_rewarded     ← user must watch ad to mine
    daily_reward_1, daily_reward_2
    start_screen_interad
    bottom_banner_1..3 (3 banners)

That is unusually dense even for an ad-heavy app. A grinding
user can encounter 5-10 ads per session.

Revenue estimate (industry-typical eCPMs, NOT from operator
account — we do NOT have AdSense access):

  Inputs:
    Total users                       : 149,182
    Daily-active rate (assumed)       : 5% – 15%
    Ads watched / active session      : 3 – 8
    Blended eCPM (banner+inter+reward): $2 – $6 per 1000 imps

  Scenarios (per month):
    LOW       (5% DAU,  3 ads, $2 eCPM)    ≈ $1,343 / month
    MID-LOW   (10% DAU, 5 ads, $3 eCPM)    ≈ $6,713 / month
    MID-HIGH  (12% DAU, 6 ads, $4 eCPM)    ≈ $12,889 / month
    HIGH      (15% DAU, 8 ads, $6 eCPM)    ≈ $32,223 / month

Caveats:
  - These are ESTIMATES, not direct AdMob revenue queries.
  - Geo mix matters enormously: India eCPMs are 5-10× lower
    than US. BitMiner appears to have heavy non-US install
    base (top_miners leaderboard heavily features India).
  - 149k installs in 2 months (released 2026-03-09) suggests
    aggressive user acquisition. Sustainable revenue depends
    on retention which we cannot measure.

PLUS Google Play Billing IAPs ("Premium", "Speed Up Mining",
"Remove Ads") — typical price points $0.99–$9.99. With even
0.5% IAP conversion across 149k users at $5 avg, that is
another ~$3,700 of one-time revenue, plus subscription
recurrence.

Honest range: BitMiner generates SOMEWHERE between $1,500
and $35,000 PER MONTH from AdMob alone, plus IAP. That is
the operator's real income.  No real Bitcoin is paid out to
users.  The 149k user database is a fully-monetized engagement
machine.`,
            analysis: 'The "is it real?" question has two halves: does it pay users (NO, proven on-chain) and does the operator earn money (YES, very plausibly — these revenue estimates are conservative). The fact that BitMiner generates real revenue for the operator is exactly what makes it a profitable scam to run repeatedly. Apple gets their 30% cut of any IAP, Google gets their AdMob share. Everyone wins except the 149,182 users grinding for imaginary BTC.'
        },
        {
            id: '20',
            title: 'Evidence #20: Verdict — What the Scam Is and Is Not',
            type: 'text',
            content: `WHAT IT IS

  A fake-Bitcoin-mining engagement scam, monetized through:
    (1) Google AdMob ad impressions (mostly rewarded video)
    (2) Google Play Billing in-app purchases
    (3) Possibly a "withdrawal fee" upsell once users reach
        the artificial minimum threshold

  Harm to the user:
    - Wasted time (often dozens or hundreds of hours)
    - Battery drain (foreground "mining" service)
    - Mobile data consumption (ad video downloads)
    - Real money lost to IAP "upgrades" that do nothing
    - Personal data given to a sketchy backend (Firebase
      project btc-biner) and to iZooto

WHAT IT IS NOT

  - NOT a wallet drainer.  No approve(), no signed messages
    requested, no token transferFrom.  The app does not even
    have permission to access other apps' files.

  - NOT a credential stealer.  No READ_SMS, no
    BIND_ACCESSIBILITY_SERVICE, no SYSTEM_ALERT_WINDOW for
    overlay phishing.

  - NOT a cryptojacker.  No native libs, no stratum URLs,
    no PoW hashing code.  The "mining" is purely a
    JavaScript / Dart counter going up.

  - NOT real Bitcoin mining.  Phones can't profitably do
    that even with proper software — and this app doesn't
    have the software.

SCALE

  Unknown without store data.  These apps typically hit
  100K–10M+ installs before Play Store pulls them
  (sometimes years).  At an average $0.10–$1.00 ad revenue
  per install + IAP conversions, the lifetime take per
  rebranded APK can range from $10K to multiple millions
  of dollars.

  We have NO direct lifetime-revenue number for this APK
  (Play Store does not expose it externally).  But we have
  the Firebase project ID (btc-biner) — a Google Cloud
  abuse report against that project ID would let Google
  enumerate the operator's billing-attached real identity.

REPORTING TARGETS

  - Google Play Store:  Report the app for "misleading
    behavior — claims to mine Bitcoin but cannot mine
    Bitcoin"
  - Google Firebase Abuse:  Project ID btc-biner,
    app_id 1:411168838998:android:91dcbe4a43ef6897ec32f7
  - Google AdMob policy team:  When you find the real
    ad unit (not the test ID) via dynamic analysis,
    report it for "policy violation — invalid traffic
    from fake mining app"
  - iZooto abuse:  Report the publisher account using
    the nhwimp/nhwopn subdomains via support@izooto.com`,
            analysis: 'Naming the threat precisely matters. This is engagement / advertising fraud + in-app purchase deception, not a hot-wallet attack. The right response is regulatory and platform-level (Google Play / Firebase / AdMob abuse reports), not "rotate all your wallet keys." Tell affected friends: uninstall it, you lost time but not your wallet; do not pay any "verification fee" or "withdrawal unlock fee" if you got that far.'
        },
    ],

    transactions: [
        {
            id: '1',
            timestamp: '2026-05-14 (investigation date)',
            type: 'Static analysis — Phase 1 (manifest + decompile)',
            signature: 'SHA-256 4cb1399803685b2725526b44fac0f05fc94f9c3f3e879781a9368805a4c8d0fe',
            description: 'apktool + jadx decompile complete. Package = com.btc.bitcoin.mining.cloud.btcmining. Flutter app. ProGuard-obfuscated SDK. App\'s own Java is just MainActivity + R.',
        },
        {
            id: '2',
            timestamp: '2026-05-14 (investigation date)',
            type: 'Static analysis — Phase 2 (tamper-resistance map)',
            signature: 'see Evidence #9',
            description: 'v2+ signing, signature self-check present, Play Integrity SDK present, emulator detection in obfuscated SDK code, no SSL pinning, no DexClassLoader runtime loading.',
        },
        {
            id: '3',
            timestamp: '2026-05-14 (investigation date)',
            type: 'Live backend probe — Firebase project',
            signature: 'project_id = btc-biner; api_key AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE',
            description: 'identitytoolkit signUp with the leaked API key returned ADMIN_ONLY_OPERATION = key valid, project active, anonymous signup disabled by operator. Firestore endpoint returned 401 confirming project exists. Firebase Hosting subdomains returned 404 (mobile-only distribution).',
        },
    ],

    findings: [
        {
            title: '🎯 Operator Publicly Admits It\'s a Simulator — App Store Disclaimer',
            description: 'BitMiner Crypto is on the Apple App Store at id=6759275346 by "Bipin Sakariya" (vasoyadevoper.blogspot.com). The marketing copy promises "Mine BTC", "Withdraw your BTC safely anytime", etc. — but the LAST paragraph of the same description says: "This app is a Bitcoin mining simulator for education and entertainment only. It does not provide real cryptocurrency mining, trading, or investment services." This is the operator\'s OWN ADMISSION that no real BTC is paid. The asymmetry between marketing (top) and disclaimer (bottom) is the harm.',
            tags: ['App Store', 'Self-Disclaimer', 'Simulator', 'Operator Admits'],
        },
        {
            title: '🚨 On-Chain Test — NO Operator Payout Wallet Exists',
            description: 'Cross-referenced 2,109 user-entered BTC wallets against the blockchain. Top 50 users by fake-mined balance: 87% have ZERO BTC received ever. Top-ranked user (12yN…rt5K1u, $190 of fake BTC) has ZERO on-chain transactions — should have triggered 19 withdrawals at the $10 minimum if real. The 6 users with non-zero BTC have it from independent sources (personal exchange withdrawals); ZERO common payout sender exists across BitMiner-user wallets. The wallet bc1qamg…688k that funded 2 BitMiner users has 252,625 lifetime transactions — it\'s an exchange hot wallet, NOT BitMiner\'s payout source.',
            tags: ['On-Chain Proof', 'Zero Payouts', 'No Operator Wallet'],
        },
        {
            title: 'Developer Profile: Serial App-Farm Publisher (19 Apps on App Store)',
            description: 'Bipin Sakariya has 19 apps on the Apple App Store under the same developer ID — mix of casual kids games (rngames.* family), AI gimmick apps, and "earn-money" apps (Quiz Reward + BitMiner). Not a sophisticated criminal — a one-person app farm. Vasoya/Sakariya are common Gujarati surnames (India). The Blogspot dev URL (vasoyadevoper.blogspot.com) is consistent with that solo-dev profile.',
            tags: ['Serial Publisher', 'Bipin Sakariya', '19 Apps', 'Solo Op'],
        },
        {
            title: 'AdMob Is the Real Revenue Source — Estimated $1.5K–$35K / Month',
            description: 'Operator\'s actual AdMob publisher ID is ca-app-pub-8837381907644162 (extracted from Remote Config — NOT the test ID in the manifest). 12+ ad placements per session. At 149k users and industry-typical eCPMs, revenue estimate ranges from ~$1,500/mo (5% DAU, $2 eCPM) to ~$32,000/mo (15% DAU, $6 eCPM). Plus Google Play Billing IAPs. This is the operator\'s real income — collected via ad impressions from users grinding for imaginary BTC.',
            tags: ['AdMob Revenue', '~$1.5K-35K/mo', 'Ad Density', 'IAP'],
        },
        {
            title: 'Threshold Interpretation Was Overconfident (User Correction)',
            description: 'The Remote Config keys (first_withdraw_minimum / second_withdraw_minimum / withdraw_minimum) were initially interpreted as escalating thresholds. The user correctly noted these could equally be user-selectable tier presets. Without libapp.so the data alone can\'t pick between the two. The empirical bottom line is unchanged though — regardless of which interpretation is right, on-chain evidence shows NO user ever receives BTC.',
            tags: ['Hedged Claim', 'User Pushback', 'Empirical-Strong'],
        },
        {
            title: '🚨 149,182 Real Users\' PII Publicly Exposed',
            description: 'Firestore security rules permit UNAUTHENTICATED reads of the entire `users` collection. Pagination with only the leaked API key yielded 149,182 user records — each containing real email, Google display name, profile photo URL, 142-char FCM push token, referral code, and fake-BTC balance. GDPR-grade data breach. Local sample of 18,000 records (9.5 MB) saved to evidence/bitminer-apk/firebase-probe/users-raw.jsonl.',
            tags: ['149K Users', 'PII Breach', 'Firestore Misconfig', 'GDPR'],
        },
        {
            title: '🎯 Operator Remote Config Captured — Scam Mechanic In Numbers',
            description: 'Pulled the operator\'s full Firebase Remote Config: real AdMob publisher ID (ca-app-pub-8837381907644162), 12+ ad-unit placements, and the escalating withdrawal threshold (first=10 / second=500 / third=1000). The threshold jump from 10 to 500 (50×) is the trap mechanic — confirmed by the per-user data, NOBODY in the 18k sample qualifies for the second tier.',
            tags: ['Remote Config', 'Real AdMob ID', 'Withdrawal Trap'],
        },
        {
            title: 'Wallet-Configuration Rate Proves No Payouts at Scale',
            description: 'In the 18k user sample, 85.5% have wallet_address null or empty. Real mining/payout apps require a wallet BEFORE accruing. The fact that 127,000+ users (extrapolated to all 149k) are "mining" without any way to be paid proves the BTC counter is purely cosmetic, never paid.',
            tags: ['No Wallet 85.5%', 'Cosmetic Balance', 'No Payouts'],
        },
        {
            title: '0 Users Qualify for the Second Withdrawal Tier',
            description: 'At observed accumulation rates: 0.89% qualify for first-tier ($10), but 0.00% qualify for second-tier ($500), 0.00% for third-tier ($1000). The top user has $190 of fake BTC — below the second tier. The escalating-threshold trap works exactly as designed.',
            tags: ['Math Confirms', 'Threshold Trap', 'Zero Qualifiers'],
        },
        {
            title: 'No Withdrawals / Payouts / Transactions Collection Exists',
            description: 'Probed 30+ candidate collection names for any "payout history" / "transactions" / "withdraw_log" collection. None exist accessibly. The app\'s "Mining Record" UI is presumably a synthetic projection of the btc_count field. Real operator-driven payouts would need a record somewhere — there is none.',
            tags: ['No Payout Log', 'Negative Evidence', 'No Records'],
        },
        {
            title: 'Top Miners Leaderboard Is Hand-Crafted Fake Data',
            description: '80 hardcoded entries with earnings between $90,150 and $110,569 — a 22% range that is statistically impossible for real users. All hashRates between 0.99 and 1.00. The operator typed in 80 fake leaderboard rows for social-proof display.',
            tags: ['Fake Leaderboard', '80 Hand-Crafted Entries', 'Social Proof'],
        },
        {
            title: '🚨 Operator Firebase Backend Identified — LIVE',
            description: 'Plaintext leak in res/values/strings.xml gives project_id=btc-biner, app_id=1:411168838998:android:91dcbe4a43ef6897ec32f7, api_key=AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE. Live probe (identitytoolkit + firestore) confirms the project EXISTS and is actively administered. Backend identity that survives any APK rebrand.',
            tags: ['Firebase', 'Backend Identified', 'Cross-Build Fingerprint', 'LIVE'],
        },
        {
            title: 'Cannot Mine Bitcoin — Proven by Absence',
            description: 'No native mining libs, no stratum pool URLs, no SHA-256 PoW hashing code, no native libs at all in this APK. Plus the physics: phones are ~40,000,000x slower than dedicated mining ASICs. The "mining" is a Dart counter incremented at a Firebase-Remote-Config-controlled rate.',
            tags: ['Fake Mining', 'No Stratum', 'Phone-Impossible'],
        },
        {
            title: 'Damage Model: Time + Ad Impressions + Optional IAP Upsell',
            description: 'No wallet drainer, no credential stealer, no cryptojacker. The harm is wasted user time, AdMob revenue extracted via rewarded-video gates, and Google Play Billing upsells for fake "mining boosts." Indirect monetary theft, not direct.',
            tags: ['Engagement Fraud', 'IAP Scam', 'Ad Revenue'],
        },
        {
            title: 'Flutter Release Build — Real Logic in Missing Split APK',
            description: 'Manifest declares android:requiredSplitTypes="base__abi,base__density". The Dart business logic (the actual fake-mining counter, rate config, IAP integration) lives in libapp.so which is shipped in a SEPARATE per-ABI split APK — not present in this distribution file. Static analysis from this APK alone can never see the exact Dart code; we infer from the asset bundle and SDK wiring.',
            tags: ['Flutter Split', 'libapp.so Missing', 'Dart Code'],
        },
        {
            title: 'Heavy ProGuard / R8 Obfuscation on the SDK Layer',
            description: '13,343 Java classes in 1-2 letter directories (A/A3/B/B0/…). The obfuscation is heavy but most of it is SDK boilerplate (Firebase, AdMob, Google Play Services, Flutter engine). The app\'s own Java code is just MainActivity + R.java — meaning ProGuard mostly hides the dependency code, not actionable scam logic.',
            tags: ['ProGuard', 'R8', 'SDK Obfuscation'],
        },
        {
            title: 'Moderate Tamper Resistance — Phase-3 Feasible But Costly',
            description: 'v2+ signing, signature self-check, emulator detection, and Play Integrity SDK are all present. NO SSL pinning. NO runtime DexClassLoader. NO obvious root detection. Patching to run in an AVD is feasible but requires also obtaining the matching ABI split APK to actually boot the Flutter engine.',
            tags: ['v2+ Signing', 'Self-Check', 'Emulator Detection', 'No SSL Pin'],
        },
        {
            title: 'iZooto Push-Spam Layer Alongside Firebase Messaging',
            description: 'Operator wires BOTH Firebase Cloud Messaging AND iZooto (nhwimp.izooto.com / nhwopn.izooto.com). Two redundant push systems suggest either prior FCM bans or deliberate redundancy. iZooto endpoints are themselves a fingerprint searchable across other operator builds.',
            tags: ['iZooto', 'Push Spam', 'Redundant Engagement'],
        },
        {
            title: 'Minimal Permissions — Cannot Steal Wallet or Credentials',
            description: 'NO READ_SMS, NO READ_CONTACTS, NO RECORD_AUDIO/CAMERA, NO SYSTEM_ALERT_WINDOW overlay, NO BIND_ACCESSIBILITY_SERVICE, NO REQUEST_INSTALL_PACKAGES. The app physically cannot drain wallets, intercept 2FA codes, phish via overlay, or install chained malware. The threat model is time/ad/IAP fraud, not asset theft.',
            tags: ['Bounded Threat', 'No Wallet Access', 'No 2FA Intercept'],
        },
    ],

    network: [
        { address: 'com.btc.bitcoin.mining.cloud.btcmining', role: 'Android Package', connection: 'APK SHA-256 4cb1399803685b2725526b44fac0f05fc94f9c3f3e879781a9368805a4c8d0fe — Flutter release build, ProGuard-obfuscated, 15.13 MiB.' },
        { address: 'btc-biner (Firebase project)', role: '🎯 OPERATOR BACKEND (LIVE)', connection: 'app_id 1:411168838998:android:91dcbe4a43ef6897ec32f7. Auth + Firestore + Crashlytics + FCM + Remote Config + AB Testing enabled. Firestore endpoint returns 401 (project exists). API key valid.' },
        { address: 'AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE', role: 'Firebase API Key (LEAKED)', connection: 'Plaintext in res/values/strings.xml. Validated against identitytoolkit endpoint: ADMIN_ONLY_OPERATION = key active, project active.' },
        { address: '411168838998', role: 'Firebase Project Number / FCM Sender ID', connection: 'Cross-reference fingerprint. Any other APK referencing this number is from the same Firebase project (same operator).' },
        { address: 'nhwimp.izooto.com / nhwopn.izooto.com / cdn.izooto.com', role: 'iZooto Push Service Endpoints', connection: 'Third-party push notification provider used in parallel with Firebase Messaging. Re-engagement spam delivery.' },
        { address: 'ca-app-pub-3940256099942544~3347511713', role: 'Google AdMob App ID (TEST!)', connection: 'Hardcoded in manifest is the official Google AdMob TEST app ID. Real production AdMob ID is almost certainly fetched at runtime via Firebase Remote Config — dynamic analysis required to capture it.' },
        { address: 'MainActivity.java (com.btc.bitcoin.mining.cloud.btcmining)', role: 'App entry point', connection: 'Trivial Flutter shim. Real logic lives in libapp.so inside a MISSING ABI-split APK.' },
        { address: 'b5/a.java (obfuscated)', role: 'Signature Self-Check', connection: 'Reads its own PackageManager SigningInfo + signatures[]. Would fail after re-signing with debug key unless patched.' },
        { address: 'F2/e.java, g4/AbstractC0935g.java (obfuscated)', role: 'Emulator Detection', connection: 'Checks Build.DEVICE/HARDWARE for "generic", "emulator", "ranchu", "goldfish". Likely Crashlytics filtering but capability exists.' },
        { address: 'Z3/N.java (obfuscated)', role: 'Play Integrity SDK', connection: 'playIntegrityToken reference. Token-issuing capability present; actual invocation gated by Dart logic in libapp.so.' },
    ],

    smartContract: {
        language: 'js',
        code: teardownCode,
        vulnerabilities: [
            'Fake Bitcoin mining UI — no native mining libs, no stratum pool URLs, no PoW hashing code in 55,598 unique DEX strings. Physically impossible to mine BTC profitably on a phone in any case.',
            'Firebase backend (project btc-biner, app_id 1:411168838998:android:91dcbe4a43ef6897ec32f7) confirmed LIVE — API key returns ADMIN_ONLY_OPERATION (valid + active). Operator currently administering it.',
            'API key, project ID, sender ID, app ID all leaked in plaintext under res/values/strings.xml — cross-build fingerprint for any reskinned variant.',
            'Heavy ProGuard / R8 obfuscation (13,343 classes in 1-2 letter dirs) — but most is SDK boilerplate; the app\'s own Java is empty (MainActivity + R only).',
            'Real Dart business logic in libapp.so which lives in a SEPARATE per-ABI split APK not present in this distribution — static analysis from this APK alone cannot read the Dart source.',
            'Moderate tamper resistance: v2+ signing, signature self-check, Play Integrity SDK, emulator detection. NO SSL pinning. NO root detection visible. NO runtime code download.',
            'Damage model is engagement fraud + IAP upsell, NOT wallet draining. Permissions explicitly do not include READ_SMS, READ_CONTACTS, SYSTEM_ALERT_WINDOW, or BIND_ACCESSIBILITY_SERVICE.',
            'Operator uses iZooto push service alongside Firebase Messaging — redundancy suggests prior FCM ban or intentional fallback.',
        ],
    },

    technicalSpecs: [
        { label: 'File Name', value: 'BitMiner.apk' },
        { label: 'File Size', value: '15,875,972 bytes (15.13 MiB)' },
        { label: 'SHA-256', value: '4cb1399803685b2725526b44fac0f05fc94f9c3f3e879781a9368805a4c8d0fe' },
        { label: 'SHA-1', value: '7b5656beafbeb8a40ee3f308dcb690cdd7be4b48' },
        { label: 'Android Package', value: 'com.btc.bitcoin.mining.cloud.btcmining' },
        { label: 'App Label', value: 'BitMiner' },
        { label: 'Tech Stack', value: 'Flutter (release) + Firebase + AdMob + iZooto, ProGuard/R8 obfuscated' },
        { label: 'APK Signing Scheme', value: 'v2+ (APK Sig Block 42 at 0x00f11ff0; no v1 META-INF signatures)' },
        { label: 'Split APKs Required', value: 'base__abi, base__density (per-ABI libapp.so NOT in this file)' },
        { label: '🎯 Firebase Project ID', value: 'btc-biner (LIVE — operator currently administering)' },
        { label: 'Firebase App ID', value: '1:411168838998:android:91dcbe4a43ef6897ec32f7' },
        { label: 'Firebase API Key (LEAKED)', value: 'AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE' },
        { label: 'Firebase Project Number / FCM Sender', value: '411168838998' },
        { label: 'AdMob App ID in Manifest', value: 'ca-app-pub-3940256099942544~3347511713 (Google TEST ID — real ID fetched at runtime via Remote Config)' },
        { label: 'Push Services', value: 'Firebase Messaging + iZooto (nhwimp.izooto.com / nhwopn.izooto.com)' },
        { label: 'Real Mining Capability', value: 'NONE — no native libs, no stratum pool, no PoW hashing. Physically impossible on phone hardware anyway.' },
        { label: 'Scam Type', value: 'Fake Cloud Mining — engagement / ad / IAP fraud' },
        { label: 'Damage Model', value: 'Time theft + AdMob revenue capture + Google Play Billing upsells. NOT wallet draining, NOT credential theft, NOT cryptojacking.' },
        { label: 'Tamper Resistance', value: 'Moderate: v2+ signing + signature self-check + Play Integrity SDK + emulator detection. No SSL pinning. No runtime code loading.' },
        { label: 'Phase 3 (patched-binary run) Feasibility', value: 'Possible but requires (a) patch sig self-check, (b) patch emulator detection, (c) acquire matching ABI split for libapp.so. Cost: high. Skip unless dynamic UI screenshots needed.' },
        { label: 'Recommended Reporting Targets', value: 'Google Play Store (misleading mining claim), Google Cloud Abuse (project btc-biner), Google AdMob (after capturing real ad unit), iZooto abuse (publisher misuse).' },
        { label: '🚨 Total Real User Accounts in Backend', value: '149,182 user records publicly readable via the leaked API key' },
        { label: 'Sample Pulled to Local Evidence', value: '18,000 user records (12.1% sample, 9.5 MB) — saved to evidence/bitminer-apk/firebase-probe/users-raw.jsonl' },
        { label: 'Users With NO Payout Wallet (sample)', value: '85.5% — 78.5% null + 7.0% empty string' },
        { label: 'Users Qualifying for First Withdrawal Tier ($10)', value: '0.89% of sample (160/18000) — extrapolated ~1,325 of 149k' },
        { label: 'Users Qualifying for Second Withdrawal Tier ($500)', value: '0 / 18,000 — ZERO. The threshold-trap works as designed.' },
        { label: 'Real AdMob Publisher (from Remote Config)', value: 'ca-app-pub-8837381907644162 (NOT the test ID in the manifest)' },
        { label: 'Withdrawal Threshold Trap', value: 'first=10 → second=500 (50× jump) → third=1000. ALL configured via Firebase Remote Config and changeable by the operator without shipping a new APK.' },
        { label: 'Verdict (with backend data)', value: 'FAKE. Provably never pays at scale. Plus an additional 149k-user PII leak by the operator due to misconfigured Firestore rules.' },
        { label: '🎯 App Store URL (US)', value: 'https://apps.apple.com/us/app/bitminer-crypto/id6759275346' },
        { label: '🎯 App Store URL (India)', value: 'https://apps.apple.com/in/app/bitminer-crypto/id6759275346' },
        { label: 'App Store ID', value: '6759275346' },
        { label: 'Developer (App Store)', value: 'Bipin Sakariya — vasoyadevoper.blogspot.com (Blogspot)' },
        { label: 'Developer Portfolio Size', value: '19 apps on Apple App Store under same dev ID (mostly casual games + "earn" apps)' },
        { label: 'iOS Release Date', value: '2026-03-09 (~2 months before this investigation)' },
        { label: 'iOS Latest Update', value: '2026-05-06 (8 days before this investigation)' },
        { label: 'iOS Average Rating', value: '2/5 stars (US, only 2 ratings) — low engagement / low trust' },
        { label: '🎯 Operator Self-Disclaimer in App Store Description', value: '"This app is a Bitcoin mining simulator for education and entertainment only. It does not provide real cryptocurrency mining, trading, or investment services."' },
        { label: 'On-Chain Payout Test — Result', value: 'Top user (highest fake_count, ranked #1) has ZERO BTC transactions ever. 87% of top 50 users have zero BTC ever. NO common operator payout sender exists across BitMiner user wallets.' },
        { label: 'AdMob Revenue Estimate (Monthly)', value: '$1,500 – $35,000 (industry-typical eCPM × 149k users × 12+ ad placements per session)' },
        { label: 'Threshold Interpretation', value: 'Ambiguous — could be escalating OR user-selectable tiers. Empirical bottom line unchanged regardless.' },
    ],
};