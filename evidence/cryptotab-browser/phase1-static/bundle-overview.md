# CryptoTab Browser — Bundle Overview

**Source:** `/Users/atrey/Desktop/code/crypto-investigator/evidence/cryptotab-browser/extracted/CryptoTab Browser.app`

## High-level identity

| Field | Value |
|---|---|
| Bundle ID | `site.cryptobrowser.cryptotab` |
| Display name | `CryptoTab Browser` |
| Short version | `127.0.6533.100` (Chromium version) |
| Bundle version | `6533.100` |
| Bundle signature | `Cr24` (standard Chromium) |
| SCM revision | `191cc1af405dffccb2a183efdcf0a370625f9b92-refs/branch-heads/6533@{#1911}` |
| Code-signing authority | `Developer ID Application: Cryptocompany OU (46J7LAWF9F)` |
| Apple notarization | Timestamped **16 Aug 2024 20:10:45** |
| Universal binary | x86_64 + arm64 (Mach-O fat) |
| Min macOS | 10.15 (Catalina) |
| Built with | Xcode 15.4 (build 15F31d), macOS 14.5 SDK |
| Runtime | Hardened runtime, version 14.5.0 |
| URL schemes registered | `http`, `https`, `cryptotab`, `file` |

## Sizes

| Component | Size |
|---|---|
| `Contents/MacOS/CryptoTab Browser` (launcher) | 412 KB |
| `Contents/Frameworks/CryptoTab Browser Framework.framework/` | **496 MB** (whole framework) |
| `Contents/Frameworks/.../Versions/127.0.6533.100/CryptoTab Browser Framework` (main shared library) | **393 MB** |
| `Contents/Resources/` | 952 KB |
| `Contents/Frameworks/.../Libraries/libGLESv2.dylib` | 14.4 MB |
| `Contents/Frameworks/.../Libraries/libvk_swiftshader.dylib` | 20 MB |
| `Contents/Frameworks/.../Helpers/chrome_crashpad_handler` | 2.0 MB |
| `Contents/Frameworks/.../Helpers/app_mode_loader` | 1.2 MB |

## Component layout (Chromium-standard except where noted)

```
CryptoTab Browser.app/
  Contents/
    Info.plist                         (CryptoTab-customised; details below)
    MacOS/CryptoTab Browser            (thin launcher)
    Resources/
      app.icns, document.icns
      scripting.sdef                   (AppleScript dictionary)
      site.cryptobrowser.cryptotab.manifest/   <-- CryptoTab MDM policy plist
      *.lproj/InfoPlist.strings        (55 locale dirs)
    Frameworks/CryptoTab Browser Framework.framework/
      Versions/127.0.6533.100/
        CryptoTab Browser Framework    (393 MB main shared lib — the entire Chromium fork)
        Helpers/
          CryptoTab Browser Helper.app                 (sandboxed sub-process)
          CryptoTab Browser Helper (Renderer).app
          CryptoTab Browser Helper (GPU).app
          CryptoTab Browser Helper (Plugin).app
          CryptoTab Browser Helper (Alerts).app
          chrome_crashpad_handler                       (crash reporter)
          app_mode_loader, web_app_shortcut_copier      (PWA support)
        Libraries/
          libEGL.dylib, libGLESv2.dylib, libvk_swiftshader.dylib
          MEIPreload/                  (Chromium media engagement preload)
        Resources/
          resources.pak                (8.5 MB — contains embedded CryptoTab extension)
          chrome_100_percent.pak, chrome_200_percent.pak
          icudtl.dat, v8_context_snapshot.{arm64,x86_64}.bin
          install.sh                   (Chromium copy-to-Applications helper)
          *.lproj/locale.pak           (55 locale dirs)
```

## Embedded "CryptoTab" web extension (bundled inside `resources.pak`)

Carving `resources.pak` (Chromium GRIT pack format v5, 2804 resources, encoding=1=UTF-8 gzip) reveals a pre-installed extension keyed `cryptotab/`:

- `cryptotab/manifest.json` (resource id 17768)
- `cryptotab/loader.js` (resource id 19502, 113 KB compressed → 371 KB JS — the MV3 service worker)
- `cryptotab/tab.js` (resource id 19506, 106 KB compressed → 348 KB JS — the new-tab UI bundle)
- `cryptotab/ruleset_1.json` (resource id 19504, 428 bytes — declarativeNetRequest rule injecting `X-CB-Data` header)
- `cryptotab/tab.html` (resource id 20389 — new-tab page shell that loads `cryptotab.js`)
- `cryptotab/icons/icon_default*.png`, `cryptotab/icons/icon_started.png`

Carved JS / manifest copies saved to `/tmp/cryptotab-strings/pak_extracted/*.bin`.

### Extracted manifest.json
```json
{
  "manifest_version": 3,
  "version": "3.0.12",
  "name": "CryptoTab",
  "description": "A chrome extension CryptoTab built with Manifest V3, Webpack 5, React 18",
  "action": {"default_icon":"icons/icon_default.png","default_title":"CryptoTab"},
  "background": {"service_worker":"loader.js"},
  "host_permissions": ["http://*/*","https://*/*"],
  "declarative_net_request": {"rule_resources":[{"id":"ruleset_1","enabled":false,"path":"ruleset_1.json"}]},
  "key": "MIIBIjANBgkqhkiG9w0BAQE...AQAB",       (RSA pubkey pinning the extension ID)
  "permissions": [
    "storage","activeTab","tabs","identity","contextMenus","management",
    "notifications","declarativeNetRequest","browsingData","bookmarks",
    "cryptobrowser",                              <-- custom CryptoTab extension API
    "declarativeNetRequest","declarativeNetRequestFeedback","alarms",
    "system.memory","system.storage","system.cpu",
    "notifications","webRequest","gcm"
  ]
}
```
The `cryptobrowser` permission is a custom permission they added to Chromium itself — see `mining-protocol.md`.

### Extracted ruleset_1.json (declarative network request)
```json
[{
  "id": 1, "priority": 1,
  "action": { "type": "modifyHeaders",
              "requestHeaders": [{"header":"X-CB-Data","operation":"set","value":"::3.0.12:"}]},
  "condition": { "requestDomains": ["cryptobrowser.site"],
                 "resourceTypes": ["main_frame","sub_frame","script","xmlhttprequest"]}
}]
```
Stamps every request to `cryptobrowser.site` with an `X-CB-Data` header containing the extension version. Disabled by default but available as a runtime toggle.

### Embedded extension source code
The source paths embedded in the main framework binary reveal the three CryptoTab-authored Chromium C++ files:

- `../../cryptotab/chrome/browser/extensions/api/cryptobrowser/chrome_miner.cc`
- `../../cryptotab/chrome/browser/extensions/api/cryptobrowser/cryptobrowser_api.cc`
- `../../cryptotab/chrome/browser/extensions/api/cryptobrowser/cryptobrowser_mining.cc`

These implement the in-process CPU miner exposed to JS as `chrome.cryptobrowser.*`.

## Info.plist key fields

```
CFBundleIdentifier            = site.cryptobrowser.cryptotab
CFBundleShortVersionString    = 127.0.6533.100
CFBundleURLSchemes            = http, https, cryptotab, file
CFBundleDocumentTypes         = GIF, HTML, XHTML, JS, JPEG, MHTML, OGG audio,
                                OGV, PNG, SVG, text, WebM, WebP, .crx, PDF, .crwebloc
NSAppleScriptEnabled          = true
NSAppTransportSecurity        = NSAllowsArbitraryLoads = true     <-- ATS fully disabled
LSFileQuarantineEnabled       = true
LSMinimumSystemVersion        = 10.15
SCMRevision                   = 191cc1af405...refs/branch-heads/6533@{#1911}
```

### Custom URL scheme
`cryptotab://` is registered. There is no string evidence of a handler path in the binary; the scheme is most likely consumed by the embedded extension/server-loaded UI for deep links from `cryptobrowser.site` web pages back into the browser (login callback, install confirmation, referral attribution).

## Entitlements (main app)

`codesign -d --entitlements -` on the .app yielded:
```
com.apple.security.cs.allow-dyld-environment-variables       = true
com.apple.security.cs.allow-jit                              = true
com.apple.security.cs.allow-unsigned-executable-memory       = true
com.apple.security.cs.disable-executable-page-protection     = true
com.apple.security.cs.disable-library-validation             = true
com.apple.security.device.audio-input                        = true
com.apple.security.device.camera                             = true
com.apple.security.device.microphone                         = true
```
These are the **standard Chromium hardened-runtime entitlements** required for V8 JIT, plus the standard browser permissions for camera/mic. **Identical entitlements** are applied to every helper sub-process (`Renderer`, `GPU`, `Plugin`, `Alerts`, `Helper`). Notably absent: no app-sandbox entitlement (browsers can't easily sandbox), no networking/file-access restrictions beyond what macOS imposes by default.

Of note for our investigation:
- `allow-unsigned-executable-memory` + `disable-executable-page-protection` means the CPU miner thread (which JIT-compiles RandomX/CryptoNight inner loops) is permitted to write+execute pages without `MAP_JIT`. This is **the same configuration Chrome itself ships with**, so it is not a CryptoTab-specific red flag — but it does mean the mining VM can run native-speed JITted code from RandomX dataset transformations.

## Helper processes

5 helper variants, identical entitlements, all signed by `Cryptocompany OU (46J7LAWF9F)`:

- `CryptoTab Browser Helper.app` — generic Chromium service helper
- `CryptoTab Browser Helper (Renderer).app` — sandboxed renderer process
- `CryptoTab Browser Helper (GPU).app` — GPU sub-process
- `CryptoTab Browser Helper (Plugin).app` — plugin sub-process (PPAPI)
- `CryptoTab Browser Helper (Alerts).app` — native notification helper

These mirror upstream Chromium's process-isolation model 1:1.

## What's missing vs. Google Chrome

- **No ChromiumUpdater/GoogleUpdater/Keystone bundled.** `install.sh` references `Contents/Frameworks/Chromium Framework.framework/Helpers/ChromiumUpdater.app/Contents/MacOS/ChromiumUpdater` (under the wrong-cased "Chromium" framework name) but that path **does not exist** in this bundle. No `ksadmin`, no `*Updater*` binary anywhere. Implication: auto-update is **disabled / external**. See `chromium-version.md` for the update-server analysis.
- No Widevine CDM (`libwidevinecdm.dylib`) is bundled — DRM video on Netflix/Spotify will not play unless they ship it via a component update.
- No Google API key strings, no `gaia` references in unusual contexts beyond standard Chromium account-sync code.
- The `LSEnvironment` includes `MallocNanoZone=0` which disables Apple's nano malloc — a known Chromium workaround for sandboxed-renderer crashes.

## CryptoTab-specific MDM policy bundle

`Contents/Resources/site.cryptobrowser.cryptotab.manifest/` contains a 146 KB Chromium enterprise-policy schema (renamed Google_Chrome policy template). It's just a copy of the upstream policy template renamed under their bundle ID — it lets MDM tools manage CryptoTab the same way they manage Chrome.
