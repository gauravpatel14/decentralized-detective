# flashusd.com.tr — Scam Architecture (JS Decompiled)

Site is a Turkish-language `.com.tr` domain selling fake "Flash USDT" packages.
Hosted behind Cloudflare. WHOIS for the domain returns only Turkey's BTK
(Bilgi Teknolojileri ve İletişim Kurumu) registry contact — operator identity not
exposed on the public WHOIS record.

## Marketing pitch

- "Turkey's fastest and most secure multi-chain USDT (Tether) platform"
- "FlashLoan technology and AES-256 secure checkout"
- Telegram: `t.me/flashusdcom`
- Twitter: `@FlashUSDT`
- Instagram: `@flashusdt`
- Title meta: `"FLASH USDT — • Tether • TRC20 • ERC20 • BEP20 — FlashLoan • t.me/flashusdcom"`

## The eight package tiers (from `pkgDefs` in the page bundle, line 6259)

| Bar ID | Display | Slot count | Range (`min`..`max`) | Threshold (claimed value) |
|---|---|---|---|---|
| bar800 | "$800 USDT Package" | 4000 | 3100..3600 | $800 |
| bar5k | "$5,000 USDT Package" | 3500 | 2800..3300 | $5,000 |
| bar10k | "$10,000 USDT Package" | 3000 | 2400..2900 | $10,000 |
| bar50k | "$50,000 USDT Package" | 1200 | 920..1180 | $50,000 |
| bar100k | "$100,000 USDT Package" | 600 | 380..580 | $100,000 |
| bar200k | "the Master Node" | 200 | 130..195 | $200,000 |
| bar500k | "the Elite Engine" | 80 | 48..78 | $500,000 |
| bar1m | "the Ultimate Core" | 30 | 16..29 | $1,000,000 |

**FOMO mechanic**: each tier shows "X slots left" — drives urgency. The `lastReviewBucket`
field in the backend drives an automatic decrement; when all slots are full, a
midnight reset cycles availability.

## The publicly-readable mockapi.io backend

```
GET https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/flashusdt/1
GET https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/stocks/1
```

Both endpoints are world-readable (no auth, no API key). Live snapshot at investigation:

```json
{
  "date": "2026-05-15",
  "bar800": 4000, "bar5k": 3500, "bar10k": 2999,
  "bar50k": 1199, "bar100k": 599, "bar200k": 198, "bar500k": 74, "bar1m": 29,
  "partnerUsed": 30519799,
  "volume": 1868523207.982037,
  "txCount": 21492, "blockCount": 135585, "userCount": 13674,
  "online": 9819,
  "lastTxTime": 1778495988000,
  "lastTxId": "54479aa3abb94f32f362f5b41b68d41c23426f848ae97e1f6f8a587c7d70a3ce"
}
```

Note the **claimed $1.86 BILLION volume** vs the actual TQDwWF wallet's
$11.66 lifetime inflow — a 160-million-times exaggeration.

## The "live transactions" feed — proof padding

From main page line 6573–6655: the site fetches `TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N`'s
real Tronscan TRC20 transfer history every few seconds:

```javascript
const TRONSCAN_API = `https://apilist.tronscanapi.com/api/token_trc20/transfers
    ?limit=50&start=0&direction=1&relatedAddress=${TRON_ADDR}`;
```

It filters for outbound USDT transfers from that wallet (so the displayed transactions
are real, with real TXIDs, real recipients, real Tronscan links), then renders them as
"VERIFIED" tx cards with whale alerts for amounts ≥ $1,000,000.

**The wallet at TT2T17... holds $46M USDT.** It is some real entity's address
(unlabeled — could be exchange hot wallet, market maker, OTC desk, whale). The flashusd
operator did not deposit there and does not control it. They use its
transactions as social proof.

This is the same pattern documented in case **USDTFLASH-PROOF-20260514** (the Telegram
channel that re-broadcast real txs from `THERg7DZAB75qTNH3aZpKQ4UAjxFZL6Gjn` as their
own).

## The buy flow (trc20.html)

A 6-step wizard:

1. **Product selection** — pick a package tier
2. **Wallet entry** — user provides the destination wallet for their (fake) Flash USDT
3. **Network selection** — TRC20 / ERC20 / BEP20 / USDC / BTC
4. **Payment** — user pays USDT (real) to the displayed address
5. **Verify** — wait for "verification"
6. **Receipt** — claimed delivery of Flash USDT

The actual on-chain receiver depends on which network:

```javascript
const ADDRS = {
    TRC20: "TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33",      // fresh, $11.66 lifetime
    ERC20: "0xb5f5090D4f032059844c464C7A273D29063311c1",   // ZERO activity
    BEP20: "0xb5f5090D4f032059844c464C7A273D29063311c1",   // ZERO activity
    USDC:  "0xb5f5090D4f032059844c464C7A273D29063311c1",   // ZERO activity
    BTC:   "bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl"    // marked // closed
};
```

But the state object pulls `last_oxapay_url` from `localStorage` — meaning the
**real payment flow goes through OxaPay's per-invoice address generator**, not
directly to these wallet addresses. The wallets above are decoys / fallbacks shown
on the page; victim funds flow into OxaPay's gateway and from there to the operator's
OxaPay account.

## Turkish-operator fingerprints

JS comments and UI strings reveal Turkish-language development:

```javascript
// trc20.html line 4022:
// ✅ Step6'da aside komple DOM'dan kaldır
//   ("In Step6, completely remove the aside from the DOM")

// trc20.html line 4034:
// ✅ Step1–Step5: aside yoksa geri ekle
//   ("Step1-Step5: if there's no aside, add it back")
```

Combined with:
- `.com.tr` ccTLD (requires Turkish entity or representation)
- "Turkey's first multichain Tether platform" in marketing
- "FLASH USDT Turkey" in keywords meta
- Telegram handle `@flashusdcom` (Turkish-style userbase)
- Use of OxaPay (Iran/Turkey-popular payment processor)

→ Operator is almost certainly **Turkish-speaking, targeting Turkish-language
victims first**, with the English marketing layer for international reach.

## Login gate

URLs `/auth/login.php` and `/flash-test.php` redirect to login.

`/flash-test.php` is interesting: it implies an authenticated "test" feature
(probably a small fake-balance generator for new users to build trust before
upselling them on a paid package). Behind the login wall — would require user
registration to investigate further.

## Tracking / monetization

- **Google Tag Manager**: `GTM-58GSNCVV` (their analytics container)
- **Cloudflare**: site sits behind CF proxy (edge `MRS` = Marseille)
- **Cloudflare email decoder** loaded — suggests they obfuscate email contact addresses

## Comparison to other documented flash-USDT cases

| Case | Mechanic | Direct on-chain receiver | Payment processor |
|---|---|---|---|
| AITRO-FLASH-20260514 | Fake balance generator | Yes (TRC20 direct) | None |
| TRC-1USD-FLASH-20260514 | $1 trust-builder + fee | Yes (TRC20 direct) | None |
| USDTFLASH-PROOF-20260514 | Proof padding via Telegram | N/A (Telegram only) | None |
| **flashusd.com.tr** | **Package sales w/ FOMO** | **No (decoys) — via OxaPay** | **OxaPay gateway** |

flashusd.com.tr is the most operationally mature of the four:
- Real payment processor abstraction layer (OxaPay) instead of direct deposits
- Public mockapi.io backend for state synchronization across sessions
- Package-tier model (sales) instead of fake-balance-then-fee
- Real whale-wallet observation for social proof (no need to fund a fake-proof wallet)
- Cloudflare proxy + Turkish ccTLD (better domain-takedown resistance than .netlify.app)
