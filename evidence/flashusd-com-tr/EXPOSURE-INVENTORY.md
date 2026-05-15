# flashusd.com.tr — Exposure / Leak Inventory

**Investigation date**: 2026-05-15
**Status of site at investigation**: LIVE and operational

This document is the consolidated catalog of every leak, exposed endpoint,
hardcoded value, and operational fingerprint recovered from the site.
Each item has the raw artifact saved on disk under one of:

  - `crawl/` — HTML/JS captures of public pages
  - `backend/` — backend endpoint responses, headers, timestamped
  - `onchain/` — Tronscan / blockstream / mockapi-state dumps
  - `js-analysis/` — decompiled scam-mechanic notes
  - `wallets/` — per-wallet on-chain summary

---

## 1. Is the website "real"?

**The site is a real, live website.** It is not a real "Flash USDT" platform.

| Claim by the site | Reality from evidence |
|---|---|
| "Turkey's fastest multichain USDT platform" | A static HTML/JS frontend backed by free mockapi.io database |
| `$1,868,602,565` claimed platform volume | $11.66 actual on-chain receipt across all four displayed wallet addresses |
| `13,724` users, `9,967` online now | Public-writable mockapi field that visitors' own browsers PUT-inflate |
| Real-time "VERIFIED LIVE TX" feed | Hijacked tx history of an unrelated $46M whale wallet (TT2T17KZ...kU9N) |
| 8 package tiers worth ~$10.7B inventory | No "Flash USDT" token exists on any chain. Nothing is ever delivered. |
| AES-256 secure FlashLoan technology | No such technology — marketing language only |

**Operator**: anonymous; Turkish-speaking (Turkish-language comments left
in `trc20.html` JS); `.com.tr` ccTLD requires Turkish entity per BTK rules
but WHOIS does not expose registrant.

**Architectural truth**: it is a Cloudflare-fronted, LiteSpeed-PHP
backend, mockapi.io-fed, OxaPay-cutout advance-fee scam. Victims pay real
money (through OxaPay's per-invoice gateway) and never receive anything.

---

## 2. The publicly-readable + writable mockapi.io backend ⚠️ CRITICAL

The site's "database" is a free [mockapi.io](https://mockapi.io) project
exposed at:

```
https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/flashusdt/1
https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/stocks/1
```

**No auth. No API key. Read AND write.** Their own client JS performs
unauthenticated PUT requests from every visitor's browser (proof of
write-capability without ever attempting one ourselves).

### Live snapshots captured at investigation

**`backend/mockapi-flashusdt-20260515T084038Z.json`** (smaller / internal-flavored):
```json
{"txCount":3641, "blockCount":65446, "userCount":656, "volume":7421748, "flashusdt":"1"}
```

**`backend/mockapi-stocks-20260515T084038Z.json`** (the bigger / marketing-flavored):
```json
{
  "date": "2026-05-15",
  "volume":      1868602565.98,
  "partnerUsed": 39086966,
  "txCount":     21531,
  "blockCount":  135786,
  "userCount":   13724,
  "online":      9967,
  "bar800": 4000, "bar5k": 3500, "bar10k": 2999,
  "bar50k": 1199, "bar100k": 599, "bar200k": 198, "bar500k": 74, "bar1m": 29,
  "lastTxTime":  1778495988000,
  "lastTxId":    "54479aa3abb94f32f362f5b41b68d41c23426f848ae97e1f6f8a587c7d70a3ce",
  "lastReviewBucket": 21
}
```

### Volume-growth-over-time proof of automation

Between two snapshots taken ~30 minutes apart:

| Field | First snapshot | Latest snapshot | Delta |
|---|---:|---:|---:|
| `volume` | $1,868,523,208 | $1,868,602,566 | **+$79,358 in 30 min** |
| `online` | 9,819 | 9,967 | +148 |
| `partnerUsed` | $30,519,799 | $39,086,966 | **+$8,567,167 in 30 min** |
| `txCount` | 21,492 | 21,531 | +39 |

These numbers are not real transactions — they are inflations the
operator's own JavaScript writes to the mockapi backend from every
visitor's browser. The "$8.5M" partnerUsed jump is implausible for
any real business in 30 minutes.

### Anyone who has the project ID can rewrite reality

`6907a7b0b1879c890eda62c1` is the mockapi project token. With it,
any party can:

- Read every state value
- Write arbitrary replacements (set volume to 0, userCount to "SCAM", reset all `bar*` slots to 0 forcing the entire homepage into "SOLD OUT" state, edit `lastTxId`, etc.)
- The PUT endpoint accepts arbitrary JSON updates with no auth

**I did not write to the mockapi backend** (would be active interference).
The JS source is sufficient proof that writes are possible — it does
them constantly.

---

## 3. robots.txt advertises every "hidden" path 🟠 SECURITY-BY-OBSCURITY FAIL

Operator's own robots.txt at `crawl/flashusd.com.tr_robots.txt` literally
discloses what they want hidden:

```
Disallow: /trcprivate.html             ← exists, 403
Disallow: /flashusdeploy.html          ← exists, 302 → /flashusdeploy.php (auth-gated)
Disallow: /payment-received.html       ← public, 200
Disallow: /donation-received.html      ← public, 200
Disallow: /admin_panel.php             ← exists, 302 → /auth/login.php?next=%2Fadmin_panel.php
Disallow: /auth/                       ← exists, 403
Disallow: /private/                    ← 404
Disallow: /*.php                       ← scope hint: PHP backend
Disallow: /*.json                      ← scope hint: JSON endpoints exist
Disallow: /*.sol                       ← false-positive (CSS class names, not Solidity)
```

The classic anti-pattern: telling Google not to crawl something means
telling every adversary that something exists. We confirmed every
listed path's existence in a single recon pass.

---

## 4. Backend PHP endpoints (recovered from JS calls)

Each endpoint's response headers + body are saved to `backend/`
with UTC timestamp suffix.

| Endpoint | Method (from JS) | Public response | Function |
|---|---|---|---|
| `/admin_panel.php` | GET | 302 → `/auth/login.php?next=%2Fadmin_panel.php` | **Operator admin panel** |
| `/flashusdeploy.php` | GET | 302 → `/auth/login.php?next=%2Fflashusdeploy.php` | Post-login operator tool (flash-USDT "deploy") |
| `/auth/login.php` | GET / POST | 200 with form; POST processes login | Login form (csrf + username + password) |
| `/auth/logout.php` | GET | 302 | Session destroy |
| `/auth/save_custom_request.php` | POST | 521 origin-down | "Custom request" contact form — writes to filesystem |
| `/save_payment.php` | POST | 403 | Session-gated; records payment attempts |
| `/verify_status.php?txid=...` | GET | 403 / "FORBIDDEN" | Session-gated; tx status check |
| `/oxapay_checkout.php` | POST | `{"message":"Unauthorized access. (Mode: denied)"}` | Creates OxaPay invoice |
| `/get_daily_creds.php` | GET | 200 JSON (active=false right now) | **Free-test credentials dispenser** (see §5) |

### Form structure recovered from `/auth/login.php`

```html
<form method="post" action="/auth/login.php" autocomplete="off">
  <input type="hidden" name="csrf"     value="8d311783dfeffea6805efd8767ca53c0d4466bcaa2c05856ad4ff38f53ad161d">
  <input type="hidden" name="next"     value="/flashusdeploy.php">
  <input        name="username"  maxlength="64">
  <input type="password" name="password" maxlength="256">
</form>
```

- CSRF token = 32-byte hex (server-side random; properly random length)
- `next` default = `/flashusdeploy.php` (confirms the operator's primary post-login tool)
- Password max length 256 (high — supports passphrases)
- No password complexity hint exposed publicly

### Form structure recovered from `/auth/save_custom_request.php`

```javascript
fd.append("network", network);
fd.append("email",   email);
fd.append("telegram",telegram);
fd.append("wallet",  wallet);
fd.append("notes",   notes);
fd.append("company", company);  // ← honeypot field
```

- `company` is a **honeypot** — visible in HTML but legitimate users
  don't fill it; if filled, request is rejected as spam
- Backend error names `WRITE_FAILED_PERMISSIONS` and `WRITE_FAILED`
  indicate the endpoint **writes user-submitted data to the filesystem**
  (not a database) — path-traversal class bugs may matter, but we did
  not probe (active testing)

### Session cookie behavior

```
Set-Cookie: flash_portal_auth=<26-char-base36>; path=/; secure; HttpOnly; SameSite=Strict
Set-Cookie: flash_portal_auth=deleted; expires=Thu, 01-Jan-1970 00:00:01 GMT; Max-Age=0; ...
```

- Cookie name: `flash_portal_auth` (PHPSESSID-format value)
- Properly hardened: `secure`, `HttpOnly`, `SameSite=Strict`
- "Set then immediately deleted" pattern on unauthenticated requests —
  means session is created and discarded on each anonymous hit
- Cookie name `flash_portal_auth` is distinctive; useful for identifying
  victims later from browser-history or cookie-store evidence

---

## 5. `get_daily_creds.php` — public credential dispenser ⚠️ CRITICAL

The operator publishes a public endpoint that hands out **free
24h-rotating test credentials** for the `/flash-test.php` page.

Current public response (saved at `backend/get_daily_creds-20260515T084038Z.json`):

```json
{
  "active":       false,
  "error":        "SESSION EXPIRED",
  "msg":          "Current test quota has been reached. Peer nodes have purged existing signatures.",
  "next_sync_in": 2778
}
```

When `active: true` the endpoint returns the JSON shape (from the
client JS that consumes it):

```javascript
fetch('get_daily_creds.php')
  .then(res => res.json())
  .then(data => {
    if (data.active) {
      renderCredentials(data.creds);
      // creds.expires_in is the seconds remaining (typically 1800 = 30 min)
    } else {
      renderExpired(data);
    }
  });
```

UI promise on the homepage:

> *"Protocol Sync credentials rotate every 24h. Valid for 30min session sync."*

**This is the operator's intended free-test trust-building mechanism.**
Anyone can poll the endpoint until it returns `active: true` and
receive valid login credentials. No rate-limiting beyond the quota
counter; no auth required.

To use credentials safely for UI testing, see safety guidance in §9.

---

## 6. Hardcoded values & operator fingerprints

| What | Value | Significance |
|---|---|---|
| mockapi project token | `6907a7b0b1879c890eda62c1` | Full R/W access to operator's mockapi data |
| Google Tag Manager id | `GTM-58GSNCVV` | Subpoena Google for the operator's GTM/GA account (KYC) |
| Sample CSRF token | `8d311783dfeffea6805efd8767ca53c0d4466bcaa2c05856ad4ff38f53ad161d` | 32-byte hex; properly random |
| Origin server software | LiteSpeed Web Server | `x-turbo-charged-by: LiteSpeed` header — popular in Turkish/cPanel hosting |
| Session cookie name | `flash_portal_auth` | Identifies operator's PHP backend |
| Cloudflare edge | `MRS` (Marseille) | Visitor reaches site via CF Marseille PoP — implies most victims are Europe-Turkey region |
| TRC20 "social proof" wallet | `TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N` | $46M USDT whale — NOT theirs |
| TRC20 receiver | `TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33` | $11.66 lifetime; drained |
| EVM receiver (ETH+BSC+USDC) | `0xb5f5090D4f032059844c464C7A273D29063311c1` | Decoy, zero activity |
| BTC receiver | `bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl` | Decoy, marked `// closed` |
| Drain target | `TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3` | $5.83 USDT consolidation hub |
| Telegram channel | `t.me/flashusdcom` | First-contact recruitment funnel |
| Twitter handle | `@FlashUSDT` | Operator social — subpoena for account creation IP |
| Instagram handle | `@flashusdt` | Operator social — Meta compliance lever |
| Apple/Google handles | None observed | No mobile app linkage discovered |
| Real Tether contracts referenced for credibility | `TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t`, `0xdac17f958d...ec7`, `0x55d398326f99...955` | Reference links to legitimate Tether — NOT scam wallets |

---

## 7. Turkish-language operator fingerprints (accidental)

Comments left in `crawl/flashusd.com.tr_trc20.html.html`:

```javascript
// Line 4022:
// ✅ Step6'da aside komple DOM'dan kaldır
//    "In Step6, completely remove the aside from the DOM"

// Line 4034:
// ✅ Step1–Step5: aside yoksa geri ekle
//    "Step1-Step5: if there's no aside, add it back"
```

Additional fingerprints:
- `.com.tr` ccTLD requires Turkish entity / Turkish trademark per BTK policy
- "Turkey's first multichain Tether platform" in Organization Schema
- `NUM_LOCALE = 'de-DE'` for number formatting (Turkish convention)
- OxaPay payment processor — Turkey/Iran-popular
- LiteSpeed server — common in Turkish hosting providers
- Marseille Cloudflare edge — Europe-Turkey-MENA region traffic

Jurisdiction: **MASAK** (Turkey financial-crimes board), **BTK** (Turkish
ICT regulator), **BDDK** (Banking Regulation Agency) all have authority.

---

## 8. On-chain wallet decoy pattern

See `wallets/wallet-summary.md` for full per-wallet table. Summary:

| Wallet | Chain | Lifetime txs | Lifetime USDT received | Verdict |
|---|---|---:|---:|---|
| `TT2T17KZ...kU9N` | Tron | Thousands | **$46M held** | NOT operator's; observed for fake "live tx" feed |
| `TQDwWFmC...DE33` | Tron | 4 inbound | **$11.66** | Real fee wallet, fresh (~1 mo), mostly self-test |
| `TNY1aaLA...Kq1Cs3` | Tron | 1 | $5.83 | Drain target (consolidation) |
| `0xb5f5090D...11c1` | Ethereum + BSC | **0 each** | $0 | Decoy, never used |
| `bc1qwwqwkkw...g7gl` | Bitcoin | **0** | $0 | Decoy, "// closed" per operator's own JS |

**$11.66 actual on-chain receipt** versus **$1.86B claimed mockapi volume**
= ~160 million times exaggeration.

The decoys exist because the **actual money path is OxaPay** —
per-invoice unique deposit addresses generated by OxaPay's gateway,
forwarded to the operator's OxaPay account, held under OxaPay's KYC.
Direct on-chain tracing dead-ends at the decoy wallets; investigation
must route through OxaPay compliance.

---

## 9. Login + UI-testing safety guidance

If you want to use the free credentials from `get_daily_creds.php` to
log in and inspect `/flash-test.php`, do this in a sandboxed environment:

1. **Clean browser profile** — fresh Chrome/Firefox profile, no
   extensions, no saved accounts/cards. Ideally in a VM (UTM/Parallels)
   you can dispose of afterward.
2. **VPN or burner IP** — operator logs your IP at login; using a clean
   exit IP keeps your investigation IP unbinded from any future testing.
3. **No real wallet** — do not connect MetaMask / TronLink / WalletConnect
   with a wallet holding real funds. Use a fresh empty keypair if a
   wallet is required.
4. **No real PII** — burner email, throwaway Telegram. Their
   `save_custom_request.php` collects `email`, `telegram`, `wallet`, `notes` —
   assume any of those go into their CRM (and may be sold or targeted).
5. **Block clipboard write** — some scam sites silently replace copied
   wallet addresses with operator's via `navigator.clipboard.writeText()`.
   Use a clipboard-protection extension during testing.
6. **Don't paste real txids into `verify.html`** — every txid you submit
   gets logged.
7. **Capture all traffic with mitmproxy or DevTools** — the highest-EV
   part of testing is seeing `verify_status.php` and `oxapay_checkout.php`
   in flight. Save HAR exports to `/Users/atrey/Desktop/code/crypto-investigator/evidence/flashusd-com-tr/post-login-traffic/`.

---

## 10. Investigation chokepoints (what would actually identify the operator)

Ordered by likely effort vs payoff:

| Lever | Authority | Yields |
|---|---|---|
| **OxaPay compliance subpoena** | Turkish / Iranian financial authority | Operator's KYC docs + settlement wallet address |
| **Google compliance (`GTM-58GSNCVV`)** | Google Trust & Safety | Operator's Google Ads / Analytics account → likely linked to operator's personal/business identity |
| **MASAK report** (Turkey financial-crimes board) | Turkey AML authority | Domestic enforcement; banking-rail freeze |
| **BTK abuse channel** | Turkey ICT regulator | Domain takedown via the .tr registry |
| **Cloudflare disclosure** | Cloudflare Trust & Safety | Origin IP behind CF proxy |
| **Twitter / Meta compliance** (`@FlashUSDT`, `@flashusdt`) | Twitter / Meta | Account-creation IP, recovery email/phone |
| **Cloudflare-bypass via subdomain enumeration** | Public passive recon | Possible direct origin IP if any subdomain leaks (mail, dev, etc.) — not yet attempted |
| **mockapi.io abuse report** | mockapi.io | Take down operator's free tier; cripple their state-of-record (cosmetic) |

None of these are exotic. They are the standard toolkit for
Cloudflare-fronted scam operations. The Cloudflare-bypass step is the
one passive recon move that could yield a direct origin IP, which
would in turn reveal hosting provider → enable hosting-abuse takedown.

---

## File inventory under `evidence/flashusd-com-tr/`

```
evidence/flashusd-com-tr/
├── EXPOSURE-INVENTORY.md          (this file)
├── evidence.txt                    (original URL list provided)
├── crawl/                          (13 raw HTML/XML captures)
│   ├── flashusd.com.tr.html                            290 KB main page
│   ├── flashusd.com.tr_trc20.html.html                 162 KB buy wizard
│   ├── flashusd.com.tr_verify.html.html                 45 KB
│   ├── flashusd.com.tr_platform_guide.html.html         49 KB
│   ├── flashusd.com.tr_credit.html.html                 27 KB
│   ├── flashusd.com.tr_status.html.html                 27 KB
│   ├── flashusd.com.tr_status-history.html.html         25 KB
│   ├── flashusd.com.tr_security.html.html               19 KB
│   ├── flashusd.com.tr_payment-received.html.html        6 KB
│   ├── flashusd.com.tr_donation-received.html.html       5 KB
│   ├── flashusd.com.tr_auth_login.php.html               6.5 KB login form
│   ├── flashusd.com.tr_flash-test.html                   6.5 KB (login redirect)
│   ├── flashusd.com.tr_flashusdeploy.html.html           771 B 302 redirect
│   ├── flashusd.com.tr_robots.txt                      2.5 KB ← sensitive-path disclosure
│   └── flashusd.com.tr_sitemap.xml                     3.6 KB ← page enumeration
├── backend/                        (timestamped backend probes)
│   ├── get_daily_creds-20260515T084038Z.json           ← free-creds endpoint
│   ├── mockapi-flashusdt-20260515T084038Z.json         ← live state snapshot 2
│   ├── mockapi-stocks-20260515T084038Z.json            ← live state snapshot 2 (bigger counters)
│   ├── admin_panel.php-20260515T084038Z.{headers,body} ← admin panel exists, 302 to login
│   ├── flashusdeploy.html-20260515T084038Z.{headers,body}
│   ├── flashusdeploy.php-20260515T084038Z.{headers,body}
│   ├── auth-login-20260515T084038Z.{headers,body}      ← login page response with cookie
│   ├── auth-dir-20260515T084038Z.{headers,body}        ← /auth/ 403
│   └── trcprivate.html-20260515T084038Z.{headers,body} ← 403
├── onchain/                        (Tronscan + initial mockapi dumps)
│   ├── mockapi-flashusdt.json                          ← first mockapi snapshot (~30 min earlier)
│   ├── mockapi-stocks.json                             ← first mockapi snapshot
│   ├── tron-TT2T17-account.json                        ← $46M whale wallet
│   ├── tron-TT2T17-transfers.json                      ← whale's tx history (their "proof feed")
│   ├── tron-TQDwWF-account.json                        ← real fee wallet
│   ├── tron-TQDwWF-transfers.json
│   ├── tron-TQDwWF-incoming.json                       ← $11.66 lifetime in
│   ├── tron-TQDwWF-outgoing.json                       ← $11.66 lifetime out (drain)
│   └── tron-TNY1-account.json                          ← drain target ($5.83 USDT)
├── js-analysis/
│   └── scam-architecture.md                            ← decompiled JS scam map
└── wallets/
    └── wallet-summary.md                               ← per-wallet on-chain table
```

The dynamic-route report at
`investigator-app/data/reports/FLASHUSD-TR-20260515.ts` references
all of the above evidence and renders at `/reports/FLASHUSD-TR-20260515`.
