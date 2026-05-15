# Bundled Resources Inventory

## Localizations (.lproj/ directories)

Two parallel sets of `.lproj/` directories exist:

1. `Contents/Resources/*.lproj/` — each contains only `InfoPlist.strings` (the Mac display-name localization, plus the file-type names from `Info.plist`). 55 locales.
2. `Contents/Frameworks/CryptoTab Browser Framework.framework/Versions/127.0.6533.100/Resources/*.lproj/` — each contains the Chromium `locale.pak` for that language (the full UI translations). Also 55 locales.

### Target-market signals from the language list

```
af  am  ar  bg  bn  ca  cs  da  de  el  en  en_GB  es  es_419  et  fa  fi  fil
fr  gu  he  hi  hr  hu  id  it  ja  kn  ko  lt  lv  ml  mr  ms  nb  nl  pl
pt_BR  pt_PT  ro  ru  sk  sl  sr  sv  sw  ta  te  th  tr  uk  ur  vi  zh_CN  zh_TW
```

**This is the upstream Chromium full language set, verbatim.** CryptoTab has not added, removed, or reweighted any languages — they ship every locale Google ships. The list of locales therefore does NOT reveal a target market different from "global." (Notable presences that align with reported CryptoTab user-base markets — Russian `ru`, Ukrainian `uk`, Portuguese-Brazilian `pt_BR`, Spanish-Latam `es_419`, Hindi `hi`, Persian `fa`, Vietnamese `vi`, Indonesian `id`, Filipino `fil`, Turkish `tr`, Bengali `bn`, Urdu `ur` — these are simply Chrome's standard set.)

A spot-check of `Contents/Resources/en.lproj/InfoPlist.strings` shows only the standard Chromium file-type descriptors ("GIF image", "HTML document", etc.), no CryptoTab-specific UI strings — those are all in `resources.pak` and the remote-eval'd JS.

## Top-level `Contents/Resources/` (952 KB total)

| Item | Notes |
|---|---|
| `app.icns` (50 KB) | App icon |
| `document.icns` (211 KB) | Document-type icon |
| `scripting.sdef` (16 KB) | Standard Chromium AppleScript dictionary (renamed for CryptoTab; uses commands like `BrowserCrApplication`, `make new tab`, etc.) |
| `site.cryptobrowser.cryptotab.manifest/` | A renamed Chromium MDM (mobile device management) policy template — just the standard `Google_Chrome.manifest` Apple-Configurator plist with the domain reset to `site.cryptobrowser.cryptotab`. **No CryptoTab-specific policy keys were added.** This is the "use Apple-Configurator or Jamf to manage CryptoTab" file. |
| `*.lproj/InfoPlist.strings` | 55 locale dirs, see above |

`site.cryptobrowser.cryptotab.manifest/Contents/Resources/site.cryptobrowser.cryptotab.manifest` is a 147 KB XML plist; `Localizable.strings` inside it (311 KB) is the English description of every Chrome enterprise policy — verbatim Google Chrome enterprise documentation strings.

## Framework `Resources/` (the heavy hitter)

`<framework>/Versions/127.0.6533.100/Resources/` contains all the standard Chromium runtime:

| Item | Size | Notes |
|---|---|---|
| `resources.pak` | **8.5 MB** | The GRIT pack file containing UI HTML/CSS/JS, error pages, the bundled CryptoTab extension, and the Chrome internal pages (`chrome://settings`, `chrome://extensions`, etc.) — see "Carved CryptoTab extension" below |
| `chrome_100_percent.pak` | 1.2 MB | 1× DPI images |
| `chrome_200_percent.pak` | 2.0 MB | 2× DPI images |
| `icudtl.dat` | 10.3 MB | ICU Unicode data (locales/timezones/text) |
| `v8_context_snapshot.arm64.bin` | 1.3 MB | V8 startup snapshot, arm64 |
| `v8_context_snapshot.x86_64.bin` | 1.3 MB | V8 startup snapshot, x86_64 |
| `gpu_shader_cache.bin` | ~3 KB | Standard Chromium |
| `product_logo_32.png` | ~3 KB | Branded logo |
| `Info.plist` / `app_mode-Info.plist` | small | Standard |
| `install.sh` | 6.5 KB | **Chromium's standard "copy from .dmg into /Applications" helper** — its content is upstream-unchanged. It references a `ChromiumUpdater.app` that is not bundled. |
| 55× `*.lproj/locale.pak` | varies | Full Chromium UI translation files |

## Framework `Libraries/`

```
libEGL.dylib              497 KB    OpenGL ES emulation
libGLESv2.dylib            14 MB    Same — the bulk of ANGLE
libvk_swiftshader.dylib    20 MB    SwiftShader Vulkan SW rasterizer
vk_swiftshader_icd.json   110 B    SwiftShader ICD descriptor
MEIPreload/                         Chromium media-engagement preload data
```

These are all stock Chromium runtime libraries (ANGLE / SwiftShader). Nothing CryptoTab-specific.

## Framework `Helpers/`

Five sandboxed helper bundles + three single-binary helpers:

```
CryptoTab Browser Helper.app                  (generic service helper)
CryptoTab Browser Helper (Renderer).app       (renderer sub-process)
CryptoTab Browser Helper (GPU).app
CryptoTab Browser Helper (Plugin).app
CryptoTab Browser Helper (Alerts).app
chrome_crashpad_handler                       (crash reporter, 2.0 MB)
app_mode_loader                               (PWA app-mode loader, 1.2 MB)
web_app_shortcut_copier                       (PWA shortcut helper, 410 KB)
```

All helper `.app` bundles are signed by `Cryptocompany OU (46J7LAWF9F)` with the identical hardened-runtime entitlement set as the parent app. These match upstream Chromium's helper-process layout 1:1.

## Carved CryptoTab MV3 extension (inside `resources.pak`)

Parsed `resources.pak` as Chromium GRIT v5 (`encoding=1` UTF-8 gzip, 2804 resources, 25 aliases). The CryptoTab-specific resources are:

| Resource ID | Filename | Raw size | Decompressed | Type |
|---|---|---|---|---|
| 17768 | (manifest.json) | 1241 | 1241 | JSON |
| 19502 | (loader.js)    | 113838 | 370633 | JS bundle (MV3 service worker) |
| 19504 | (ruleset_1.json) | 428 | 428 | JSON |
| 19506 | (tab.js)       | 105678 | 347649 | JS bundle (new-tab React app) |
| 20389 | (tab.html)     | 461 | 993 | HTML shell |

(IDs above are GRIT IDs; the human filenames come from the embedded source-path strings `cryptotab/manifest.json`, `cryptotab/loader.js`, etc. that appear in the framework binary.)

Carved copies were saved to `/tmp/cryptotab-strings/pak_extracted/<id>.bin` for further analysis.

### Extension's static UI shell (`cryptotab/tab.html`)
```html
<!doctype html>
<html dir="$i18n{textdirection}" lang="$i18n{language}">
  <head>
    <meta charset="utf-8">
    <title>$i18n{title}</title>
    <style>
      body { background: $i18n{backgroundColor}; margin: 0; }
      #backgroundImage { ... }
    </style>
  </head>
  <body>
    <iframe id="backgroundImage" src="$i18nRaw{backgroundImageUrl}"></iframe>
    <ntp-app></ntp-app>
    <script type="module" src="new_tab_page.js"></script>
    <link rel="stylesheet" href="chrome://resources/css/text_defaults_md.css">
    <link rel="stylesheet" href="chrome://theme/colors.css?sets=ui,chrome">
    <link rel="stylesheet" href="shared_vars.css">
    <script type="module" src="cryptotab.js"></script>
  </body>
</html>
```

CryptoTab's new-tab page is the **standard Chrome NTP** (`new_tab_page.js`) with a **second script tag loading `cryptotab.js`** alongside it. The Chrome NTP renders first; `cryptotab.js` then attaches the CryptoTab miner-controls UI on top of it. This explains why CryptoTab looks like Chrome's New Tab Page with extra widgets.

`cryptotab.js` is not a separate `.pak` resource in the bundle — it is presumably emitted by webpack into the same chunk as `tab.js` (the names diverged after minification).

## Wallet / Bitcoin code? (We looked — none found.)

`strings | grep -iE 'wallet|btc|bitcoin|satoshi'` returns:

- All Chromium autofill / password-manager strings ("AutofillWallet", "SignedInAndWalletSyncTransportEnabled"). Standard Chrome.
- `SatoshiLabs` — the manufacturer of the Trezor HW wallet (Chromium has WebUSB autocomplete data for Trezor). Standard Chrome.
- `Bitcoin Wallet [TREZOR]` — same Trezor WebUSB autocomplete dictionary. Standard Chrome.
- `Digital Photo viewer [Wallet Pix]` — a Microsoft Office hardware peripheral string in Chrome's USB peripheral dictionary. Unrelated.

**No CryptoTab-specific wallet code.** No `secp256k1` library, no `libwally`, no `bitcoin-core` symbols, no `electrum`, no BIP-32 / BIP-39 strings, no key-generation strings, no signature-creation strings. The user's BTC balance is server-held; the user provides a destination BTC address at withdraw time, which the operator's server sends from a server-controlled hot wallet.

This is significant: **CryptoTab is not a wallet.** It is a mining client + payout-accounting frontend. Custody of BTC is 100% operator-side. The user never holds keys.

## Anything else unusual?

- The `scripting.sdef` contains the standard Chromium AppleScript dictionary (`tell application "CryptoTab Browser" to make new tab ...`). This means AppleScript can drive the browser — useful if/when a malicious app on the same Mac wants to puppeteer the browser. This is standard Chrome behaviour, not CryptoTab-specific.
- `NSAppleScriptEnabled=true` in `Info.plist` is also a Chromium default. (Brave and Edge ship the same.)
- The MDM-policy bundle (`site.cryptobrowser.cryptotab.manifest`) is unchanged from Google's policy template apart from the domain rename. Enterprises CAN manage CryptoTab via MDM the same way they manage Chrome. **There are no CryptoTab-specific policy keys** (e.g. there is no `MiningEnabled`, no `AffiliateIdRequired`, etc.). MLM operator presumably manages users by user-account, not by MDM policy.
- No native messaging hosts (`com.cryptotab.*.json`) are bundled — there is no out-of-process native helper.
- No XPC services in the bundle.
- No LaunchAgent / LaunchDaemon plists.
