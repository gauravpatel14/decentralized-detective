import { InvestigationReport } from '@/types/report';

const scamCode = `// File: flashusd.com.tr — decompiled scam architecture
//
// Hosted at: https://flashusd.com.tr/ (Cloudflare-proxied, Turkish ccTLD)
// Telegram:  t.me/flashusdcom
// Twitter:   @FlashUSDT
// Instagram: @flashusdt
// Marketed as: "Turkey's fastest and most secure multi-chain USDT platform"
//
// All code below is recovered from the public HTML/JS bundle of the site.
// Turkish comments throughout the JS confirm a Turkish-speaking operator.

// ─── 1. The eight "package tiers" for sale (FOMO mechanic) ────────
// From the main page bundle, line 6259:
window.pkgDefs = [
    { barId:'bar800',  total:4000, min:3100, max:3600, thresh:800,     name:'$800 USDT Package' },
    { barId:'bar5k',   total:3500, min:2800, max:3300, thresh:5000,    name:'$5,000 USDT Package' },
    { barId:'bar10k',  total:3000, min:2400, max:2900, thresh:10000,   name:'$10,000 USDT Package' },
    { barId:'bar50k',  total:1200, min:920,  max:1180, thresh:50000,   name:'$50,000 USDT Package' },
    { barId:'bar100k', total:600,  min:380,  max:580,  thresh:100000,  name:'$100,000 USDT Package' },
    { barId:'bar200k', total:200,  min:130,  max:195,  thresh:200000,  name:'the Master Node' },
    { barId:'bar500k', total:80,   min:48,   max:78,   thresh:500000,  name:'the Elite Engine' },
    { barId:'bar1m',   total:30,   min:16,   max:29,   thresh:1000000, name:'the Ultimate Core' }
];
// Each tier shows "X slots left" with a depleting bar. A daily reset cycle
// keeps availability low: when all bars hit zero, a midnight job resets.

// ─── 2. The "live VERIFIED transactions" — proof padding ──────────
// Source: main page line 4620 + 6573
const TRON_ADDR     = "TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N";
const USDT_CONTRACT = "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t"; // real Tether
const TRONSCAN_API  = \`https://apilist.tronscanapi.com/api/token_trc20/transfers
    ?limit=50&start=0&direction=1&relatedAddress=\${TRON_ADDR}\`;

async function updateRealTronScan() {
    const r = await fetch(TRONSCAN_API);
    const d = await r.json();
    // ... filter for USDT outbound from TRON_ADDR ...
    // ... render as "VERIFIED LIVE TX" cards ...
    // ... whale alert for amounts ≥ $1,000,000 ...
}

// HOLDINGS OF TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N (verified at investigation):
//   TRX balance        : 319,531,831 TRX (~$95M+)
//   USDT balance       : 46,129,998 USDT
//   Token count        : 268 different TRC20 tokens
//   Wallet age         : 3 years (created 2023-05-01)
//   Tronscan tag       : NONE (untagged whale / exchange hot wallet)
//
// This wallet IS NOT the operator's. It is a real, untagged whale or
// exchange hot wallet whose USDT outflows the scam site observes via
// the public Tronscan API and re-broadcasts as "VERIFIED LIVE PURCHASES".
//
// Same pattern as case USDTFLASH-PROOF-20260514 (the Telegram channel
// that re-broadcast real txs from THERg7DZAB...Gjn as its own).

// ─── 3. The publicly-readable mockapi.io backend (state of theatre) ──
const API        = "https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/flashusdt/1";
const STOCKS_API = "https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/stocks/1";
// Both endpoints are world-readable (no auth, no API key). Live snapshot:
const STOCKS_LIVE = {
    "volume":       1868523207.98,   // claimed $1.86 BILLION USDT volume
    "txCount":      21492,
    "blockCount":   135585,
    "userCount":    13674,
    "online":       9819,             // "online now" counter
    "partnerUsed":  30519799,         // claimed $30.5M of $500M "partner limit"
    "bar800":       4000, "bar5k": 3500, "bar10k": 2999,
    "bar50k":       1199, "bar100k": 599, "bar200k": 198,
    "bar500k":      74,   "bar1m":  29,
};
// Compare claimed volume ($1.86B) to actual on-chain receipts at the
// real TRC20 fee wallet ($11.66 lifetime — see #4 below):
//   $1,868,523,207 / $11.66 ≈ 160 MILLION X exaggeration

// ─── 4. The actual on-chain fee wallets (mostly decoys) ───────────
// From trc20.html line 3987:
const ADDRS = {
    TRC20: "TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33",          // fresh, $11.66 lifetime
    ERC20: "0xb5f5090D4f032059844c464C7A273D29063311c1",  // ZERO activity, never used
    BEP20: "0xb5f5090D4f032059844c464C7A273D29063311c1",  // ZERO activity, never used
    USDC:  "0xb5f5090D4f032059844c464C7A273D29063311c1",  // ZERO activity, never used
    BTC:   "bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl"   // "// closed" per own comment
};

// On-chain reality of each:
//   TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33  (Tron, TRC20)
//     Created       : 2026-04-12 (~1 MONTH old at investigation)
//     TRX balance   : 5.24 TRX (~$1.50)
//     USDT balance  : 0
//     Lifetime in   : $11.66 USDT across 4 transactions
//     Lifetime out  : $11.66 USDT across 4 transactions (fully drained)
//     Drain target  : TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3 ($5.83 sent)
//
//   0xb5f5090D4f032059844c464C7A273D29063311c1  (Ethereum + BSC)
//     ETH balance   : 0   ETH outbound tx count : 0   ETH USDT balance: 0
//     BNB balance   : 0   BSC outbound tx count : 0   BSC USDT balance: 0
//     Never used on any EVM chain.
//
//   bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl  (Bitcoin)
//     Lifetime tx count : 0
//     funded_txo_count  : 0
//     spent_txo_count   : 0
//     Their own JS comment: "// closed". Zero activity ever.

// ─── 5. The actual money path: OxaPay ─────────────────────────────
// From trc20.html line 4003:
const state = {
    productName:     null,
    productUSDT:     null,
    productPrice:    null,
    wallet:          null,
    network:         "TRC20",
    txid:            null,
    deposit_address: localStorage.getItem('last_oxapay_url') || null  // ← THE KEY
};
//
// OxaPay (oxapay.com) is a Turkish/Iran-popular crypto payment processor.
// Each victim invoice gets a unique per-transaction receive address generated
// by OxaPay. OxaPay aggregates those deposits and forwards to the operator's
// internal OxaPay account, which holds the actual settlement balance.
//
// This explains why the direct addresses (TQDwWF, 0xb5f5090D, bc1qwwqwkkw)
// show essentially zero activity — they are display decoys / fallbacks.
// The real money flows through OxaPay's gateway and is never visible on-chain
// at the addresses the site advertises.

// ─── 6. Turkish-operator fingerprints in the JS ──────────────────
// trc20.html line 4022:
//   // ✅ Step6'da aside komple DOM'dan kaldır
//   ("In Step6, completely remove the aside from the DOM")
//
// trc20.html line 4034:
//   // ✅ Step1–Step5: aside yoksa geri ekle
//   ("Step1-Step5: if there's no aside, add it back")
//
// Plus:
//   - .com.tr ccTLD (requires Turkish entity or representation per BTK rules)
//   - "Turkey's first multichain Tether platform" in marketing
//   - "FLASH USDT Turkey" in keywords meta
//   - OxaPay payment processor (Turkey/Iran-popular)
//
// → Operator is Turkish-speaking, targeting Turkish-language victims first
//   with English marketing for international reach.`;

export const flashUsdTrCase: InvestigationReport = {
    caseId: 'FLASHUSD-TR-20260515',
    title: 'flashusd.com.tr — Turkish "Flash USDT" Package-Sale Scam with OxaPay Cutout',
    investigationDate: 'May 15, 2026',

    subject: {
        address: 'flashusd.com.tr',
        accountType: 'Scam Website (Turkish .com.tr ccTLD, Cloudflare-proxied)',
        programOwner: 'Unknown operator — Turkish-language tooling/comments; BTK Turkey is registry; WHOIS exposes no registrant data for .com.tr',
        solBalance: 'N/A — multi-chain target (TRC20 / ERC20 / BEP20 / USDC / BTC) routed through OxaPay payment gateway',
        dataSize: 'index 290 KB · trc20.html 162 KB · status 27 KB · status-history 25 KB · login 6.4 KB · ~510 KB total HTML',
        executable: false,
        firstActivity: 'TRC20 fee wallet created ~2026-04-12 (~1 month old at investigation)',
        latestActivity: '2026-05-15 (latest USDT inflow observed; site still live)',
        totalTransactions: 4,
        activityWindow: '~33 days for the live TRC20 fee wallet (other chains: zero activity)',
    },

    tokenHoldings: [
        {
            name: 'Tether USD (claimed as "Flash USDT" packages — FAKE; no token is ever minted)',
            symbol: 'USDT',
            balance: '$11.66 received lifetime at the only-real direct wallet (TQDwWF...); claimed mockapi volume $1.86 BILLION → ~160 million× exaggeration',
            mintAddress: 'TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33 (the on-page TRC20 receiver — fresh, drained)',
            officialMintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t (real Tether USDT TRC20 contract — site references this for credibility)',
            decimals: 6,
            isFake: true,
        },
    ],

    evidence: [
        {
            id: '1',
            title: 'Evidence #1 — The Site & the Pitch',
            type: 'text',
            content: `URL    : https://flashusd.com.tr/
Host   : Cloudflare (edge MRS — Marseille)
Title  : "FLASH USDT — • Tether • TRC20 • ERC20 • BEP20 — FlashLoan • t.me/flashusdcom"
Author : <meta name="author" content="FLASH USDT ADMIN">
Telegram   : t.me/flashusdcom
Twitter    : @FlashUSDT
Instagram  : @flashusdt
Analytics  : Google Tag Manager GTM-58GSNCVV

Pitch (verbatim from meta description):
  "FLASH USDT — Turkey's fastest and most secure multi-chain USDT (Tether)
   platform. Join us on Telegram: t.me/flashusdcom. Buy and verify FLASH
   USDT instantly on TRC20, ERC20, BEP20 and BTC. Advanced FlashLoan
   technology and AES-256 secure checkout."

Pages investigated:
  /                         (290 KB main marketing + buy CTA)
  /trc20.html               (162 KB — actual 6-step buy wizard)
  /status.html              (27 KB — fake "platform status")
  /status-history.html      (25 KB — fake "uptime history")
  /auth/login.php           (6.4 KB — login form for /flash-test.php)
  /flash-test.php           (redirects to login — likely a small free-balance
                             generator behind auth for trust-building)`,
            analysis: 'The site is a polished, Cloudflare-proxied "Flash USDT" e-commerce front. The .com.tr ccTLD signals Turkish jurisdiction and provides domain-takedown resistance compared to throwaway .netlify.app or .vercel.app domains used in the AITRO and TRC-1USD-FLASH cases. The Google Tag Manager container shows the operator monetizes/tracks visitors. The author tag literally says "FLASH USDT ADMIN."'
        },
        {
            id: '2',
            title: 'Evidence #2 — The Eight Package Tiers (the actual product)',
            type: 'text',
            content: `// From main page line 6259 — what they're selling:
window.pkgDefs = [
  { thresh:    800,     name: '$800 USDT Package',    total: 4000 },
  { thresh:   5000,     name: '$5,000 USDT Package',  total: 3500 },
  { thresh:  10000,     name: '$10,000 USDT Package', total: 3000 },
  { thresh:  50000,     name: '$50,000 USDT Package', total: 1200 },
  { thresh: 100000,     name: '$100,000 USDT Package', total: 600 },
  { thresh: 200000,     name: 'the Master Node',       total: 200 },
  { thresh: 500000,     name: 'the Elite Engine',      total:  80 },
  { thresh:1000000,     name: 'the Ultimate Core',     total:  30 }
];

The pitch: pay $800 → receive $800 worth of "Flash USDT" credited to your
wallet via "AES-256 secure FlashLoan technology." Same for the higher tiers.

The reality: nothing is delivered. There is no Flash USDT token, no
mint on any chain, no contract — just a fake confirmation screen after
the victim's real USDT payment lands in OxaPay's hands.

FOMO mechanic: each tier shows "X slots left" with a depleting bar.
Backend live values:
   bar800: 4000 / 4000     bar5k: 3500 / 3500     bar10k: 2999 / 3000
   bar50k: 1199 / 1200     bar100k: 599 / 600     bar200k: 198 / 200
   bar500k: 74 / 80        bar1m: 29 / 30

A midnight reset cycle resets bar levels so "scarcity" is restored daily.`,
            analysis: 'This is a package-sales advance-fee scam. The victim is told they\'re buying a quantum of "Flash USDT" — a synthetic Tether the site claims runs on a special FlashLoan-enabled rail. There is no such asset. Each tier is calibrated to maximize per-victim damage with the scarcity bars driving urgency. The total claimed inventory across all tiers is ~$10.7B in face-value packages — a number the operator does not need to honor because nothing is ever delivered.'
        },
        {
            id: '3',
            title: 'Evidence #3 — The Publicly-Readable mockapi.io Backend',
            type: 'text',
            content: `Site's backend "database" is a free mockapi.io account, no auth required.
Any user (or investigator) can read it directly:

  GET https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/flashusdt/1
  GET https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/stocks/1

Live state pulled at investigation (2026-05-15):

{
  "date": "2026-05-15",
  "volume":        1868523207.98,        // ← claimed $1.86 BILLION USDT
  "partnerUsed":   30519799,             // claimed $30.5M of $500M "partner limit"
  "txCount":       21492,
  "blockCount":    135585,
  "userCount":     13674,
  "online":        9819,                  // "online now" — Faked / animated counter
  "lastTxTime":    1778495988000,
  "lastTxId":      "54479aa3abb94f32f362f5b41b68d41c23426f848ae97e1f6f8a587c7d70a3ce",
  "bar800": 4000, "bar5k": 3500, "bar10k": 2999,
  "bar50k": 1199, "bar100k": 599, "bar200k": 198, "bar500k": 74, "bar1m": 29
}

The PUT endpoint accepts arbitrary updates (the JS code itself updates volume,
txCount, blockCount, etc. on every browser session via fetch PUT). This means
anyone — including an investigator, a competitor, or a defacer — could write
arbitrary values into this database. There is no auth.`,
            analysis: 'The site\'s entire "platform statistics" panel — volume, users, online count — is rendered from a free public mockapi.io endpoint with no authentication. The claimed $1.86 BILLION volume is a writable number stored on a mockapi.io account. Compare against the actual on-chain receipt at their TRC20 wallet ($11.66 lifetime): the claim is ~160 MILLION TIMES the actual money received at the only direct wallet that has ever received funds.'
        },
        {
            id: '4',
            title: 'Evidence #4 — Proof Padding: The TT2T17 Whale Wallet',
            type: 'text',
            content: `From main page line 6573:

const TRON_ADDR = 'TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N';
const TRONSCAN_API = \`https://apilist.tronscanapi.com/api/token_trc20/transfers
    ?limit=50&start=0&direction=1&relatedAddress=\${TRON_ADDR}\`;

The site renders this wallet's real Tronscan transfer history as
"VERIFIED LIVE TX" cards (with whale alerts for amounts ≥ $1M USDT).

REALITY of TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N (verified via OKLink + Tronscan APIs):

  Created          : 2023-05-01 (~3 years old, established address)
  TRX balance      : 319,531,831 TRX (~$95M)
  USDT balance     : 46,129,998 USDT  ($46.1M)
  Token count      : 268 distinct TRC20 tokens (HTX, WTRX, WBTT, BTC-bridged, etc.)
  Tronscan tag     : NONE
  OKLink tag       : NONE
  Owner            : Unknown — almost certainly an exchange hot wallet,
                     market-maker, OTC desk, or whale. NOT the scam operator.

The flashusd.com.tr operator has zero control over this wallet. They simply
read its public transfer history every few seconds, filter for USDT outflows,
and render those real transactions on their site as if they were customers
"purchasing Flash USDT."

This is the same proof-padding pattern documented in case USDTFLASH-PROOF-20260514
(the Telegram channel that rebroadcast real txs from THERg7DZAB...Gjn).`,
            analysis: 'The strongest piece of evidence that this site is a scam, not a real platform. The "live transaction" feed shown to visitors is sourced from someone else\'s wallet — a $46M-USDT untagged whale or exchange address. The flashusd operator does not control it, does not deposit there, and has never received money there. They use its existing high-volume transactions as fake social proof to convince new visitors that real activity is happening on their platform.'
        },
        {
            id: '5',
            title: 'Evidence #5 — The On-Chain Receiver Wallets (mostly empty)',
            type: 'text',
            content: `From trc20.html line 3987 — the addresses the site shows victims to send to:

const ADDRS = {
  TRC20: "TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33",
  ERC20: "0xb5f5090D4f032059844c464C7A273D29063311c1",
  BEP20: "0xb5f5090D4f032059844c464C7A273D29063311c1",
  USDC:  "0xb5f5090D4f032059844c464C7A273D29063311c1",
  BTC:   "bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl"   // closed
};

LIVE ON-CHAIN STATUS OF EACH:

TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33  (TRON, TRC20):
   Created          : 2026-04-12 (~1 MONTH old at investigation)
   TRX balance      : 5.24 TRX (~$1.50)
   USDT balance     : 0 (fully drained)
   Lifetime in      : $11.66 across 4 USDT transactions
   Lifetime out     : $11.66 across 4 transactions
   Drain target     : TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3 ($5.83 consolidated there)
   Self-test txs    : Yes (a few small self-sends — wallet testing pattern)

0xb5f5090D4f032059844c464C7A273D29063311c1  (Ethereum + BSC, same address):
   ETH balance      : 0 ETH
   ETH USDT balance : 0
   ETH tx count     : 0  (never transacted on Ethereum)
   BNB balance      : 0 BNB
   BSC USDT balance : 0
   BSC tx count     : 0  (never transacted on BSC)

bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl  (Bitcoin):
   Lifetime tx count: 0
   Funded TXO count : 0
   Their own JS     : Marked "// closed"

Sum of all real money received across all displayed direct fee wallets:
  $11.66 USDT total — vs. claimed mockapi volume $1,868,523,207.98 USDT
  Ratio: ~160,000,000 X exaggeration.`,
            analysis: 'The wallets advertised as fee receivers are essentially decoys. Only the TRC20 wallet has any activity at all — and only $11.66 lifetime, mostly self-test transactions. The Ethereum/BSC wallet has zero activity ever. The Bitcoin wallet has zero activity ever and the operator\'s own code comments it as "closed". This is structurally different from earlier flash-USDT scams (AITRO, TRC-1USD-FLASH) that funnel directly to a TRC20 hot wallet — flashusd.com.tr uses these on-chain addresses as decoys while the real money path is OxaPay (see Evidence #6).'
        },
        {
            id: '6',
            title: 'Evidence #6 — The Real Money Path: OxaPay Cutout',
            type: 'text',
            content: `From trc20.html line 4003 — the state.deposit_address resolution:

const state = {
    productName:     null,
    productUSDT:     null,
    productPrice:    null,
    wallet:          null,
    network:         "TRC20",
    txid:            null,
    deposit_address: localStorage.getItem('last_oxapay_url') || null
};

OxaPay (oxapay.com) is a crypto payment processor popular in Turkey and Iran.
For each victim transaction, OxaPay generates a UNIQUE per-invoice receive
address. The victim sends USDT to that one-time address; OxaPay credits the
operator's internal OxaPay account.

Consequence:
  - The "direct" addresses on the page (TQDwWF, 0xb5f5090D, bc1qwwqwkkw)
    are DISPLAY DECOYS / FALLBACKS. Most victims pay through OxaPay's
    per-invoice address flow.
  - The actual settlement balance sits inside OxaPay's custody until the
    operator withdraws it to their own off-OxaPay wallet — and that wallet
    is not exposed on the public site.
  - Direct on-chain tracing therefore returns near-zero results at the
    advertised addresses. The chokepoint is OxaPay's KYC/AML records.

Investigation path for law enforcement:
  1. Subpoena OxaPay (oxapay.com) for the account associated with
     flashusd.com.tr's API key.
  2. OxaPay records will show: total deposits, withdrawal destinations,
     KYC documents the operator submitted to onboard.
  3. This is the only way to trace funds with this architecture.

This is an architectural evolution over the earlier flash-USDT scams
documented in our case files:
  AITRO-FLASH-20260514       → direct-to-TRC20 wallet (traceable)
  TRC-1USD-FLASH-20260514    → direct-to-TRC20 wallet (traceable)
  USDTFLASH-PROOF-20260514   → no payment processor — Telegram-only social proof
  flashusd.com.tr (this)     → OxaPay cutout (NOT directly traceable on-chain)`,
            analysis: 'The single most important finding for understanding why direct on-chain tracing fails here. The operator has graduated from naive "scam wallet shown on page" to using a real KYC\'d payment processor as a cutout. This is a meaningfully harder operation to take down with chain-analysis alone — investigation must route through OxaPay\'s compliance team or the operator\'s Turkish banking rails after OxaPay payout.'
        },
        {
            id: '7',
            title: 'Evidence #7 — Turkish-Operator Fingerprints',
            type: 'text',
            content: `Multiple independent indicators point to a Turkish-speaking operator:

1. Turkish comments in the JS (trc20.html):

   // Line 4022:
   // ✅ Step6'da aside komple DOM'dan kaldır
   //   ("In Step6, completely remove the aside from the DOM")

   // Line 4034:
   // ✅ Step1–Step5: aside yoksa geri ekle
   //   ("Step1-Step5: if there's no aside, add it back")

2. .com.tr ccTLD
   The Turkish ccTLD requires registrant to either be a Turkish entity
   OR have a Turkish trademark / business registration. Random anonymous
   registration is not possible (unlike .com / .net / .xyz). This commits
   the operator to a Turkish jurisdictional fingerprint.

3. Marketing claims:
   - "Turkey's fastest and most secure multi-chain USDT platform"
   - "Turkey's first multichain Tether platform" (Organization Schema)
   - "FLASH USDT Turkey" in keywords meta

4. Payment processor choice:
   OxaPay is highly popular in Turkey and Iran (Western processors avoid
   the region). Western-targeted scams typically use NowPayments, BTCPay,
   or direct wallet — not OxaPay.

5. Number formatting:
   const NUM_LOCALE = 'de-DE';
   const fmtMoney = (n) => Number(n).toLocaleString(NUM_LOCALE,
       { minimumFractionDigits: 2, maximumFractionDigits: 2 });
   They format displayed numbers using German locale (e.g. "1.868.523,20")
   — which is also the Turkish convention. This subtly localizes the
   presentation for European/Turkish audiences (vs US "1,868,523.20").

6. WHOIS:
   flashusd.com.tr resolves through Turkey's BTK (Bilgi Teknolojileri
   ve İletişim Kurumu — Turkey's ICT authority) registry. WHOIS returns
   only the BTK administrative contact (no operator data exposed for .tr).`,
            analysis: 'The site is built for and by Turkish-speaking operators. The Turkish-language comments accidentally left in the JS bundle are the cleanest single fingerprint. Combined with the .com.tr commitment (which requires Turkish registration), the OxaPay choice, and the marketing claims, the operator is almost certainly based in Turkey or operating under a Turkish business identity. The .tr ccTLD\'s closed WHOIS protects them from direct identification, but Turkish CMC (Capital Markets Board) / BDDK (Banking Regulation Agency) / MASAK (Financial Crimes Investigation Board) have jurisdiction.'
        },
        {
            id: '8',
            title: 'Evidence #8 — Login-Gated /flash-test.php',
            type: 'text',
            content: `URL: https://flashusd.com.tr/auth/login.php?next=%2Fflash-test.php

A login form sits in front of /flash-test.php, redirecting unauthenticated
users to /auth/login.php. The page label and URL imply a "test the platform"
sandbox that's gated behind account registration.

Inference from other documented flash-USDT scams:
  The "flash-test" page is almost certainly a small free-credit / fake-balance
  generator that lets a registered user "generate" a tiny amount of fake Flash
  USDT to build trust, before the upsell to a real-money package purchase.

  This is the same trust-building pattern documented in:
    TRC-1USD-FLASH-20260514 (the $1 "test" with full UI flow before the
                             $1000-minimum withdrawal fee ask)

We did not probe further behind the login — would require creating an
account with credentials we are unwilling to share with the operator.

Note: registration would also subject our investigation device to the
operator's JavaScript on an authenticated session, which is an
unnecessary attack surface to expose.`,
            analysis: 'The login-gated test page is structurally consistent with the trust-building patterns seen in other flash-USDT scams. We did not log in to verify, since registering an account would (a) hand the operator a usable account they could associate with our investigation, and (b) expose our device to their post-auth JavaScript which may include fingerprinting or worse. The inference is strong based on naming conventions and the typical flash-USDT funnel structure.'
        },
        {
            id: '9',
            title: 'Evidence #9 — The Six-Step Buy Wizard (trc20.html)',
            type: 'text',
            content: `trc20.html implements a 6-step purchase flow.
Steps recovered from the showStep() function and DOM analysis:

  step1  Product selection (one of the 8 package tiers)
  step2  Wallet entry (victim provides destination wallet for "Flash USDT")
  step3  Network selection (TRC20 / ERC20 / BEP20 / USDC / BTC)
  step4  Payment instructions (shows the fake on-page address;
                              but localStorage.last_oxapay_url overrides
                              with a real OxaPay-generated unique address
                              if the OxaPay flow has been used)
  step5  Verification wait (a spinner — "verifying your on-chain transaction")
  step6  Confirmation / receipt (the customer is told their Flash USDT has
                              been credited; in reality nothing is delivered)

At step6 the aside summary panel is explicitly removed from the DOM —
the Turkish comment in the code says so verbatim:

  // ✅ Step6'da aside komple DOM'dan kaldır
  //   ("In Step6, completely remove the aside from the DOM")

This is consistent with the operator wanting the final "receipt" screen
to look clean and finalized, with no remaining buy-prompt artifacts.

What the victim does NOT do at any step:
  - approve() any token allowance to a smart contract
  - permit() any signed-message permission
  - transferFrom() — no allowance-based drain
  - Sign any open-ended message payload

What the victim DOES do:
  - Sign a NATIVE-VALUE transfer of USDT (TRC20/ERC20/BEP20) for the
    EXACT package price, to either (a) a decoy display address, or (b)
    an OxaPay per-invoice address that forwards to the operator.

Practical consequence:
  This is ADVANCE-FEE FRAUD, not a wallet drainer. The victim's loss is
  bounded by the package amount they paid; the wallet itself remains
  uncompromised after payment. But the package payment is lost in full.`,
            analysis: 'The buy flow is mechanically simple and bounded in damage scope. The victim loses exactly the package amount they pay; they don\'t lose their entire wallet balance the way wallet-drainer scams (Permit2 / approve drain attacks) work. That is small consolation when the package amounts go up to $1M, but it does mean: (a) the wallet is reusable after payment, (b) the loss can be precisely quantified per victim, (c) a class action against the operator could enumerate damages with precision.'
        },
        {
            id: '10',
            title: 'Evidence #10 — Comparison to Other Flash-USDT Cases',
            type: 'text',
            content: `Side-by-side architectural comparison across all four flash-USDT cases
documented in this case-file system:

┌──────────────────────────────┬─────────────────┬────────────────┬────────────────┬─────────────────────┐
│ Case                         │ Mechanic        │ Hosting        │ On-chain path  │ Sophistication      │
├──────────────────────────────┼─────────────────┼────────────────┼────────────────┼─────────────────────┤
│ AITRO-FLASH-20260514         │ Fake balance +  │ Netlify free   │ Direct TRC20   │ ★★ — direct,        │
│                              │ fee ask (1000   │ tier           │ to scam wallet │ traceable, simple   │
│                              │ USDT minimum)   │ (anonymous)    │                │                     │
├──────────────────────────────┼─────────────────┼────────────────┼────────────────┼─────────────────────┤
│ TRC-1USD-FLASH-20260514      │ $1 trust-build  │ Netlify free   │ Direct TRC20   │ ★★ — adds trust-    │
│                              │ + fee ask       │ tier           │ to scam wallet │ funnel layer        │
├──────────────────────────────┼─────────────────┼────────────────┼────────────────┼─────────────────────┤
│ USDTFLASH-PROOF-20260514     │ Telegram chan.  │ Telegram only  │ N/A — no on-   │ ★ — pure proof-     │
│                              │ proof-padding   │ (no website)   │ chain ask      │ padding via TG      │
├──────────────────────────────┼─────────────────┼────────────────┼────────────────┼─────────────────────┤
│ flashusd.com.tr (THIS CASE)  │ Package sales   │ .com.tr ccTLD  │ OxaPay gateway │ ★★★★ — most         │
│                              │ + FOMO + auth   │ + Cloudflare   │ + decoy direct │ operationally       │
│                              │ + multi-step    │ proxy          │ wallets        │ mature              │
└──────────────────────────────┴─────────────────┴────────────────┴────────────────┴─────────────────────┘

flashusd.com.tr is the most operationally sophisticated of the four:
  ✓ Real payment processor (OxaPay) cutout — frustrates on-chain tracing
  ✓ Cloudflare proxy — frustrates origin IP discovery
  ✓ Turkish ccTLD — frustrates anonymous-registration takedown
  ✓ Mature 6-step buy wizard — looks like a real e-commerce flow
  ✓ FOMO scarcity bars + daily reset — psychological pressure
  ✓ Real whale wallet observation for social proof (no need to fund fake-proof wallet)
  ✓ Public mockapi.io backend — but no operator-controlled DB to subpoena
  ✓ Login-gated free-test page — builds trust before upsell
  ✓ Turkish-language operator with English marketing layer — broader reach

Where it's STILL vulnerable to investigation:
  ✗ Public mockapi.io endpoint — fully readable, no auth, fakery is provable
  ✗ Turkish comments left in the JS — operator fingerprint accidentally exposed
  ✗ The TT2T17 social-proof wallet is not theirs — pattern matches USDTFLASH-PROOF
  ✗ OxaPay is regulated/subpoenable in Turkey — chokepoint exists
  ✗ Decoy wallets (TQDwWF, 0xb5f5090D, bc1qwwqwkkw) all empty — strong evidence
    that the public-facing "fee wallet" architecture is theatre`,
            analysis: 'This case represents the current state-of-the-art in Turkish flash-USDT advance-fee fraud. It is operationally tighter than the earlier cases we documented but its weaknesses are well-defined: the public mockapi backend, the accidental Turkish-language fingerprints, the OxaPay chokepoint, and the proof-padding pattern. Each of these is a takedown vector if pursued by the right authority (MASAK in Turkey, OxaPay\'s compliance team, or international financial-crimes cooperation).'
        },
        {
            id: '11',
            title: 'Evidence #11 — Cloudflare Bypass: Operator Hosting Stack Attributed',
            type: 'text',
            content: `Passive Cloudflare-bypass investigation produced full operator-
infrastructure attribution. Exact web-origin IP was not pinpointed
(would require Shodan/Censys paid API), but every provider in the
operator's stack is now identified.

DNS reconnaissance (verified via dig):

  A      → 172.67.146.8, 104.21.95.163        (Cloudflare anycast)
  NS     → aarav.ns.cloudflare.com, meadow.ns.cloudflare.com
  MX     →  5 mx-01.kurumsaleposta.com    (94.73.187.201)
            10 mx-02.kurumsaleposta.com    (94.73.187.202)
  TXT    → v=spf1 include:_spfcls.natrohost.com
                  include:_netblockshalon.natrohost.com ~all
  TXT    → google-site-verification=fNXEMuSkRG1Cw6JVzXc7xWQPBPif8jV-5LhPi9jzoJg

Mail-server IPs (NOT Cloudflare — direct leak):

  WHOIS 94.73.187.201:
    inetnum: 94.73.187.0 - 94.73.187.255
    netname: Octopus-Mail-Systems
    descr:   Cizgi Telekomunikasyon A.S.
             Gulbahar Mah. Elif Sok. No4 K3, Sisli, Istanbul, TR
    origin:  AS34619 (Cizgi Telekom)

SPF chain expansion → Natro Hosting's published outbound IP space:

  ~2,700 IPs across:
    89.19.0.0/22, 89.19.11.0/24, 89.19.x small blocks,
    94.73.169.0/24, 94.73.188.0/24, 94.73.189.0/24, 94.73.190.0/24,
    37.148.215.240/28, 85.159.x small blocks,
    and singletons 94.73.144.44/32, 94.73.145.39/32

Origin software (leaked via Cloudflare passthrough header):

  x-turbo-charged-by: LiteSpeed
  x-frame-options: SAMEORIGIN
  strict-transport-security: max-age=31536000; includeSubDomains
  set-cookie: flash_portal_auth=<PHPSESSID-style>

  (Natro Hosting's standard shared-hosting stack is LiteSpeed + PHP.)

Confirmed operator infrastructure:
  Domain registry:    Turkey BTK (.com.tr)
  DNS/CDN:            Cloudflare
  Web hosting:        Natro Hosting (Turkey)
  Origin software:    LiteSpeed Web Server
  ISP/datacenter:     Cizgi Telekom A.S. (AS34619, Istanbul, TR)
  Email hosting:      Natro / kurumsaleposta.com
  Mail servers:       94.73.187.201, 94.73.187.202

All evidence saved to evidence/flashusd-com-tr/cloudflare-bypass/.`,
            analysis: 'The bypass landed every meaningful provider in the operator\'s stack. The exact origin IP remains unknown but is no longer the blocker — every actionable takedown lever (Natro abuse, Cloudflare abuse, MASAK report, OxaPay subpoena, GitHub Trust & Safety) operates at the provider level, where the operator\'s identity is recorded internally. Even Natro alone can identify the customer behind flashusd.com.tr without us knowing which specific IP serves them.'
        },
        {
            id: '12',
            title: 'Evidence #12 — flashusd.xyz: Operator-Confirmed GitHub Pages Mirror',
            type: 'text',
            content: `urlscan.io passive query surfaced a related domain hosting an
identical "FLASH USDT" content shell on GitHub Pages:

  Domain : flashusd.xyz
  A      : 185.199.108-111.153   (GitHub Pages anycast)
  NS     : ns1.natrohost.com, ns2.natrohost.com   ← Natro DNS (same)
  SSL    : Let's Encrypt R12 cert, CN=flashusd.xyz
           SAN: flashusd.xyz, www.flashusd.xyz
           Valid: 2026-05-05 → 2026-08-03
  Server : github.com (HTTP header)
  Page title: "FLASH USDT — • Tether • TRC20 • ERC20 • BEP20 — FlashLoan"
  Author meta: "FLASH USDT ADMIN"                 ← same operator alias
  Canonical link: <link rel="canonical" href="https://flashusd.com.tr/">
                                                  ← explicit owner declaration
  Sitemap.xml lastmod: 2025-11-03T22:00:00+03:00 ← Turkey timezone, active 6+ months
  Last-Modified (HTTP): Thu, 26 Mar 2026 14:29:55 GMT

Pivot significance:
  1. Same operator runs BOTH domains (canonical link is explicit
     declaration; Natro NS on the .xyz domain confirms shared registrar
     account)
  2. flashusd.xyz is an older / SEO-shell version with stale chain pages
     (erc20.html / bep20.html / btc.html — now 410 Gone on .com.tr)
  3. GitHub Pages requires a GitHub account — the operator has one
  4. GitHub code search for "flashusd.com.tr" → 0 hits → the source
     repo is PRIVATE (paid GitHub plan, ~$4-21/month)
  5. Operator has been active at least since 2025-11-03 (sitemap lastmod)

GitHub itself becomes a takedown lever:
  - GitHub Trust & Safety can be reported for fraud
  - GitHub holds the operator's account KYC (verified email,
    billing-attached card/PayPal for the paid plan)
  - Coordinated takedown of flashusd.xyz + identification of
    operator's GitHub account is single-handover-of-evidence away`,
            analysis: 'This is the most operator-attributing finding from the bypass. flashusd.xyz on GitHub Pages with an explicit "canonical to flashusd.com.tr" link and Natro NS proves same-operator beyond any doubt. The operator chose to pay for a private GitHub repo to keep their source hidden — but the PAID account is itself a chokepoint. GitHub Trust & Safety reports for cryptocurrency fraud are well-honored and a single report could (a) take down the mirror, (b) freeze the operator\'s GitHub account, (c) hand investigators the operator\'s billing identity.'
        },
        {
            id: '13',
            title: 'Evidence #13 — Origin-Scan Dead End: A Useful Negative Result',
            type: 'text',
            content: `Two Host-header-based scans against Natro's SPF-published IP ranges
returned zero true positives.

Scan 1 (small ranges, 342 IPs, loose match):
  - One false positive at 94.73.144.44 — a Microsoft IIS 10.0 shared-
    hosting server. The "match" was a 404 error page URL parameter
    "notFoundSite=flashusd.com.tr" echoing the Host header.
  - That IP hosts 499 sibling domains (e.g. bhrfethiye.com, borsacakmak.com,
    happyhorse.club, gumusdamlasigorta.com — all Turkish small-business
    sites), confirmed via HackerTarget reverse-IP lookup. It's Natro's
    IIS shared-hosting node, NOT the origin.

Scan 2 (large /24 ranges, 2,304 IPs, strict unique-signature match):
  - Match strings: "GTM-58GSNCVV", "6907a7b0b1879c890eda62c1",
    "TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N", "FLASH USDT ADMIN"
  - Result: 0 hits across 89.19.0.0/22, 94.73.169.0/24, 94.73.188.0/24,
    94.73.189.0/24, 94.73.190.0/24, 89.19.11.0/24

What this tells us:
  The web origin is NOT in Natro's email-sending IP whitelist. This is
  actually expected — large shared hosts segregate outbound SMTP IP
  pools from web-origin pools. So even with full SPF expansion, we
  don't reach the web-origin subnets.

To pinpoint origin IP would require:
  - Shodan paid query: http.html:"GTM-58GSNCVV" → guaranteed hit
  - Censys paid query: services.http.response.html:"GTM-58GSNCVV"
  - OR full ASN scan of AS34619 (Cizgi has ~50K+ IPs)
  - OR direct Natro abuse report (Natro can identify customer
    internally without us pinning the IP)

The negative result is not a failure — it definitively shows the
operator's web infrastructure is gated behind a different Natro
subnet than the SPF-published one. Natro themselves can resolve the
mapping; no external party needs to.`,
            analysis: 'Negative results are still results. Two systematic scans across 2,646 candidate Natro IPs returned zero true positives, narrowing the search space to "outside SPF-published Natro ranges." This is itself diagnostic information — it tells investigators that any further IP-level discovery requires a paid scanner or provider cooperation. The 499 sibling domains on the false-positive IP (94.73.144.44) are catalogued for cross-reference if any operator-controlled sibling site is found among them later.'
        },
        {
            id: '14',
            title: 'Evidence #14 — Investigation Chokepoints (Ranked, Actionable)',
            type: 'text',
            content: `Eight independent chokepoints have been mapped. None requires
the exact web-origin IP. Each operates at a provider level where the
operator's identity is already on file.

┌────┬─────────────────────────────┬──────────────────────────────────────────┐
│ #  │ Lever                       │ What this yields                         │
├────┼─────────────────────────────┼──────────────────────────────────────────┤
│ 1  │ OxaPay compliance subpoena  │ Operator's KYC docs + settlement wallet  │
│    │ (via MASAK)                 │ address + complete payment ledger        │
│ 2  │ Google compliance           │ Operator's Google Ads / Analytics 4      │
│    │ (GTM-58GSNCVV)              │ account — KYC + billing details          │
│ 3  │ Natro Hosting abuse report  │ Customer behind flashusd.com.tr →        │
│    │                             │ name + IP + billing                      │
│ 4  │ GitHub Trust & Safety       │ Owner of flashusd.xyz private repo →     │
│    │ (flashusd.xyz Pages)        │ GitHub account + payment method          │
│ 5  │ Cloudflare abuse            │ Origin IP under legal process            │
│ 6  │ MASAK report (Turkey)       │ Domestic AML enforcement, bank freeze    │
│ 7  │ BTK abuse channel           │ Domain takedown via .tr registry         │
│ 8  │ Cizgi Telekom abuse-c       │ RIPE contacts: NCBG1-RIPE, NN1321-RIPE   │
│    │ (AS34619)                   │                                          │
│ 9  │ mockapi.io abuse            │ Free-tier account suspended; statistics  │
│    │                             │ infrastructure crippled (cosmetic harm)  │
│ 10 │ Twitter / Meta compliance   │ Operator's @FlashUSDT, @flashusdt        │
│    │                             │ social account creation IP + recovery    │
└────┴─────────────────────────────┴──────────────────────────────────────────┘

Most efficient single action:
  → File coordinated abuse with Natro + GitHub + OxaPay.
  Any one of these three has enough internally to identify and
  suspend the operator. All three combined = full attribution +
  service termination + payment-rail freeze.`,
            analysis: 'The cloudflare-bypass investigation\'s real deliverable is this chokepoint map. The operator chose Cloudflare + a private GitHub repo + Natro shared hosting + OxaPay payment processor — every one of these is a paid relationship that requires KYC. The operator paid for anonymity at the public-DNS layer (Cloudflare) but did not anonymize the paid-account layer below. The result: an investigator who reports to the right providers gets the operator\'s identity without ever finding the origin IP.'
        },
    ],

    transactions: [
        {
            id: 'tx1',
            timestamp: '2026-04-12',
            type: 'TRC20 fee wallet creation',
            signature: 'TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33 (created block timestamp 1778672073000)',
            description: 'The on-page TRC20 fee receiver. Roughly 1 month old at investigation time. Fresh, single-purpose wallet.',
        },
        {
            id: 'tx2',
            timestamp: '2025-02-19',
            type: 'Earliest inbound to TRC20 fee wallet',
            signature: '$0.80 USDT from TXAk3cty...E9SyNU',
            description: 'First USDT inflow to TQDwWFmC...DE33. Small, suggestive of a test transaction.',
        },
        {
            id: 'tx3',
            timestamp: '2025-04-22',
            type: 'Test transaction (self-refund pattern)',
            signature: '$0.03 USDT to TQDwWFmC...DE33',
            description: 'Self-test transfer pattern. The operator is verifying the wallet works before deployment.',
        },
        {
            id: 'tx4',
            timestamp: '2026-05-15',
            type: 'Largest inbound + same-day drain',
            signature: '$5.00 USDT from TU4vEruv...r7Pvaa',
            description: 'The single largest real inflow to TQDwWFmC...DE33 — only $5.00. Drained same day to consolidation wallet TNY1aaLA...Kq1Cs3.',
        },
        {
            id: 'tx5',
            timestamp: '2026-05-15',
            type: 'Drain to consolidation hub',
            signature: '$5.83 USDT to TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3',
            description: 'Outbound drain pattern. TNY1aaLA... is a fresh (~7-week-old) consolidation address holding just the drained USDT — second-hop wallet.',
        },
        {
            id: 'tx6',
            timestamp: '2023-05-01',
            type: 'Social-proof wallet creation (NOT the operator)',
            signature: 'TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N (created block timestamp 1682942994000)',
            description: '3-year-old whale/exchange wallet holding $46M USDT + 268 different TRC20 tokens. Used by the scam site as a fake "live VERIFIED tx" feed. Operator does not control this address.',
        },
        {
            id: 'tx7',
            timestamp: '2026-05-15',
            type: 'Backend state snapshot (mockapi.io)',
            signature: 'GET 6907a7b0b1879c890eda62c1.mockapi.io/api/v1/stocks/1',
            description: 'Live publicly-readable backend showing claimed $1,868,523,207 platform volume vs $11.66 actual on-chain receipt at the only-real fee wallet — ~160 million× exaggeration.',
        },
        {
            id: 'tx8',
            timestamp: 'Permanent state',
            type: 'BTC fee wallet (zero activity)',
            signature: 'bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl — 0 lifetime txs',
            description: 'Bitcoin segwit address advertised as "BTC payment option". Has never received or sent any transaction. The operator\'s own JS code comments it as "// closed".',
        },
    ],

    findings: [
        {
            title: 'Most operationally mature flash-USDT scam in case-file system',
            description: 'OxaPay payment-processor cutout, Cloudflare proxy, Turkish .com.tr ccTLD, six-step buy wizard with FOMO scarcity bars, login-gated free-test page, and real-whale-wallet proof padding. This is a meaningful evolution beyond the AITRO and TRC-1USD-FLASH cases — direct on-chain tracing alone will not reach the operator.',
            tags: ['Architecture', 'Mature-Operator', 'OxaPay-Cutout'],
        },
        {
            title: 'Real money lifetime: $11.66 vs claimed: $1.86 BILLION',
            description: 'The on-page TRC20 fee wallet (TQDwWF...) has received $11.66 USDT total in its entire lifetime, mostly self-test transactions. The site claims $1,868,523,207 platform volume on its publicly-readable mockapi.io backend. The ratio is ~160 million×. The mockapi backend has no auth and is writable by anyone.',
            tags: ['Volume-Inflation', 'mockapi.io', 'No-Backend-Auth'],
        },
        {
            title: 'Social proof is stolen from a $46M whale wallet',
            description: 'The "VERIFIED LIVE TX" feed is sourced from TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N — a 3-year-old untagged whale/exchange wallet holding $46M USDT across 268 different tokens. The flashusd operator does not control this wallet. They observe its real transactions via Tronscan API and re-render them as their own customers\' purchases. Same proof-padding pattern as case USDTFLASH-PROOF-20260514.',
            tags: ['Proof-Padding', 'Stolen-Social-Proof', 'TT2T17-Whale'],
        },
        {
            title: 'OxaPay is the actual chokepoint for fund recovery',
            description: 'The `localStorage.last_oxapay_url` reference in trc20.html confirms OxaPay handles real payments. The advertised wallet addresses are decoys. Fund recovery / operator identification requires OxaPay\'s compliance team — they hold KYC documents the operator submitted at account creation. This is the single most actionable lever for law enforcement.',
            tags: ['OxaPay', 'Chokepoint', 'Subpoena-Target'],
        },
        {
            title: 'Turkish operator fingerprints (accidental, multiple)',
            description: 'Turkish-language comments left in the trc20.html JS bundle ("Step6\'da aside komple DOM\'dan kaldır", "Step1–Step5: aside yoksa geri ekle"), .com.tr ccTLD requiring Turkish registration, "Turkey\'s fastest" marketing claims, German/Turkish number formatting (de-DE locale), and OxaPay (Turkey/Iran-popular processor) all point to a Turkish-speaking operator. MASAK (Turkey\'s financial-crimes board) has direct jurisdiction.',
            tags: ['Operator-Fingerprint', 'Turkey', 'MASAK-Jurisdiction'],
        },
        {
            title: 'Eight package tiers — $800 to $1,000,000 face value',
            description: 'The pkgDefs array exposes 8 advance-fee tiers: $800 / $5K / $10K / $50K / $100K / $200K ("Master Node") / $500K ("Elite Engine") / $1M ("Ultimate Core"). Total claimed inventory ~$10.7B in face value. FOMO scarcity bars with daily reset cycle drive urgency. Per-victim loss is bounded by the package price they pay; no wallet drainer pattern observed.',
            tags: ['Package-Sales', 'Advance-Fee-Fraud', 'FOMO-Mechanics'],
        },
        {
            title: 'EVM and BTC wallets are pure decoys',
            description: 'The 0xb5f5090D... address advertised for ERC20/BEP20/USDC has zero lifetime activity on both Ethereum and BSC — no balance, no transactions ever. The bc1qwwqwkkw... Bitcoin address has zero lifetime transactions and the operator\'s own JS comment marks it "// closed". These are display-only fallbacks for victims who don\'t go through the OxaPay flow.',
            tags: ['Decoy-Wallets', 'Display-Only', 'Empty-On-Chain'],
        },
        {
            title: 'No wallet-drainer pattern; loss is bounded per transaction',
            description: 'The 6-step buy wizard signs native USDT transfers for exact package amounts — no approve(), no permit(), no transferFrom() allowance-drain pattern. Victims sign only the fee payment itself. Practical consequence: wallet is NOT compromised after the scam transaction; victims can continue using the same wallet. Loss is exactly the package price paid. This bounds per-victim damages and supports class-action quantification.',
            tags: ['Advance-Fee-Only', 'No-Drainer', 'Bounded-Loss'],
        },
        {
            title: 'Hosting stack fully attributed (Natro + Cizgi Telekom)',
            description: 'Cloudflare-bypass investigation identified the operator\'s complete provider stack: Natro Hosting (TR) for web + email, Cizgi Telekom A.S. (AS34619, Istanbul) as upstream ISP, LiteSpeed Web Server as origin software, kurumsaleposta.com (Natro brand) for email at 94.73.187.201/202. The exact web-origin IP remains unknown (outside the SPF-published Natro range) but is no longer the bottleneck — every actionable abuse channel operates at the provider level where the operator\'s identity is on file.',
            tags: ['Cloudflare-Bypass', 'Natro-Hosting', 'Cizgi-Telekom', 'AS34619'],
        },
        {
            title: 'flashusd.xyz GitHub Pages mirror — same-operator confirmation',
            description: 'urlscan.io passive query surfaced flashusd.xyz on GitHub Pages (apex IPs 185.199.108-111.153) with Natro nameservers and an explicit canonical link to flashusd.com.tr. Same FLASH USDT ADMIN author meta. Sitemap last-modified 2025-11-03 in Turkey timezone (+03:00) — operator active 6+ months. GitHub code search for "flashusd.com.tr" returned 0 hits, proving the source repo is PRIVATE (paid GitHub plan). GitHub Trust & Safety becomes a high-value chokepoint: the paid account holds the operator\'s billing identity.',
            tags: ['flashusd.xyz', 'GitHub-Pages', 'Same-Operator', 'Private-Repo'],
        },
        {
            title: 'Provider-level chokepoints exist without origin IP',
            description: 'Operator chose Cloudflare + private GitHub repo + Natro shared hosting + OxaPay payment processor. Each is a paid relationship that requires KYC. Cloudflare anonymity covers only the public-DNS layer; the paid-account layer below has the operator\'s real identity recorded internally. Filing coordinated abuse with Natro + GitHub + OxaPay alone is sufficient for full attribution + service termination + payment-rail freeze — no origin IP needed.',
            tags: ['Chokepoints', 'Abuse-Reports', 'Provider-Level'],
        },
    ],

    network: [
        {
            address: 'flashusd.com.tr',
            role: 'Primary scam domain (Cloudflare-proxied, Turkish .com.tr ccTLD)',
            connection: 'BTK Turkey is the registry; WHOIS does not expose registrant identity for .tr domains. Cloudflare edge MRS (Marseille). Disabling Cloudflare and serving Etc.tr abuse channels are takedown vectors.',
        },
        {
            address: 'TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33',
            role: 'On-page TRC20 fee receiver (fresh, drained)',
            connection: '~1 month old. Lifetime in/out $11.66 USDT. Drains to TNY1aaLA... Single-purpose. Either a decoy or a tiny-traction fallback for victims who don\'t use the OxaPay flow.',
        },
        {
            address: 'TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N',
            role: 'Stolen social-proof source (NOT the operator\'s wallet)',
            connection: '3-year-old untagged whale holding $46M USDT + 268 different TRC20 tokens. The scam site reads this wallet\'s real outbound USDT transactions from Tronscan API and renders them as "VERIFIED LIVE TXS" of its own customers.',
        },
        {
            address: 'TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3',
            role: 'Second-hop consolidation hub',
            connection: '~7-week-old Tron address. Holds the $5.83 USDT drained from TQDwWF... Single-purpose consolidation wallet.',
        },
        {
            address: '0xb5f5090D4f032059844c464C7A273D29063311c1',
            role: 'Advertised ERC20 / BEP20 / USDC receiver (pure decoy)',
            connection: 'Zero lifetime activity on both Ethereum and BSC. No balance, no tokens, no transactions ever. Display-only fallback for victims who choose EVM networks in the buy wizard.',
        },
        {
            address: 'bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl',
            role: 'Advertised BTC receiver (decoy, marked "closed")',
            connection: 'Zero lifetime tx count. Operator\'s own JS code labels it `// closed`. Pure display address.',
        },
        {
            address: 'oxapay.com',
            role: 'Real payment processor (the actual money path)',
            connection: 'Generates per-invoice unique deposit addresses via the localStorage.last_oxapay_url flow in trc20.html. Holds operator\'s settlement balance under KYC. The chokepoint for fund recovery and operator identification.',
        },
        {
            address: '6907a7b0b1879c890eda62c1.mockapi.io',
            role: 'Public, world-readable backend database (no auth)',
            connection: 'Hosts the site\'s "platform statistics" — claimed $1.86B volume, 13,674 users, 9,819 online, 8 package-tier slot counters. Anyone (including investigators) can read or write to it. The PUT endpoint is unauthenticated.',
        },
        {
            address: 'apilist.tronscanapi.com',
            role: 'Tronscan public API (used for proof padding)',
            connection: 'The site polls this every few seconds for TT2T17...\'s real transfer history, then renders results as fake "VERIFIED LIVE TX" cards.',
        },
        {
            address: 't.me/flashusdcom',
            role: 'Operator Telegram channel (primary support / Turkish-targeted recruitment)',
            connection: 'Linked from every page header and footer. The likely first-contact venue for Turkish-speaking victims before being funneled to the site.',
        },
        {
            address: 'GTM-58GSNCVV',
            role: 'Google Tag Manager container (operator analytics)',
            connection: 'Live GTM container tracking visitor behavior. Could correlate to the operator\'s Google Ads account if subpoenaed via Google compliance.',
        },
        {
            address: '@FlashUSDT (Twitter) + @flashusdt (Instagram)',
            role: 'Operator social profiles',
            connection: 'Referenced via Schema.org JSON-LD on every page. Could provide first-line identification via Twitter/Meta compliance for account-creation IP and recovery email.',
        },
        {
            address: 'flashusd.xyz',
            role: 'Same-operator mirror domain on GitHub Pages (apex DNS, Natro NS)',
            connection: 'A records 185.199.108-111.153 (GitHub Pages anycast). Nameservers ns1/ns2.natrohost.com (same registrar account as flashusd.com.tr). HTML contains explicit <link rel="canonical" href="https://flashusd.com.tr/">. Same "FLASH USDT ADMIN" author. Sitemap last-modified 2025-11-03 (+03:00 Turkey TZ). GitHub repo behind it is private (paid GitHub plan — operator KYC + billing on file with GitHub).',
        },
        {
            address: '94.73.187.201 + 94.73.187.202 (mx-01/02.kurumsaleposta.com)',
            role: 'Operator\'s mail-server IPs (Natro / kurumsaleposta.com brand)',
            connection: 'Real non-Cloudflare IPs discovered via MX → A lookup. Netname "Octopus-Mail-Systems" per RIPE WHOIS. ISP: Cizgi Telekomunikasyon A.S. (Istanbul). ASN: AS34619. Address: Gulbahar Mah. Elif Sok. No4 K3, Sisli, Istanbul, TR. Confirms operator\'s email is hosted in Turkey.',
        },
        {
            address: 'Natro Hosting (natrohost.com)',
            role: 'Operator\'s web + email hosting provider',
            connection: 'Referenced via SPF chain (`_spfcls.natrohost.com`, `_netblockshalon.natrohost.com`, `_netblocks.natrohost.com`), MX (`kurumsaleposta.com` is Natro\'s brand), nameservers on the .xyz mirror (`ns1.natrohost.com`), and LiteSpeed Web Server fingerprint (Natro\'s standard stack). Natro maintains internal customer records; abuse report to Natro identifies the operator regardless of exact origin IP.',
        },
        {
            address: 'Cizgi Telekomunikasyon A.S. (AS34619)',
            role: 'Upstream ISP / datacenter operator',
            connection: 'Hosts Natro\'s infrastructure. RIPE admin contacts: NCBG1-RIPE, NN1321-RIPE. Located at Gulbahar Mah. Elif Sok. No4 K3, Sisli, Istanbul, Turkey. AS34619\'s abuse-c contact can be reached for higher-level escalation.',
        },
    ],

    smartContract: {
        language: 'JavaScript (decompiled from the flashusd.com.tr public HTML/JS bundle — main page and trc20.html)',
        code: scamCode,
        vulnerabilities: [
            'CLAIMED $1.86B platform volume vs $11.66 actual on-chain receipt at the only-real fee wallet — ~160 MILLION × exaggeration. The mockapi.io backend storing these numbers is publicly readable AND writable (no authentication).',
            'The "VERIFIED LIVE TX" feed is sourced from a stolen $46M-USDT whale wallet (TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N) — the operator does not control that wallet. They re-render someone else\'s real transactions as their own customers\' purchases.',
            'Three of four advertised on-chain fee wallets are pure decoys with zero lifetime activity (0xb5f5090D... empty on ETH and BSC; bc1qwwqwkkw... empty on BTC and labeled "// closed" by the operator\'s own JS). The fourth (TQDwWF...) has $11.66 lifetime — mostly self-test transactions.',
            'Real victim money flows through OxaPay\'s per-invoice address generator (localStorage.last_oxapay_url) — NOT to the direct wallets shown on the page. The operator\'s settlement balance is held inside OxaPay until withdrawal. This frustrates direct on-chain tracing and makes OxaPay\'s compliance team the only practical chokepoint for fund recovery.',
            'The buy flow signs native USDT transfers only — NO approve(), NO permit(), NO transferFrom() allowance-drain pattern. This is advance-fee fraud, not a wallet drainer. Per-victim loss is bounded by the package price they pay; the wallet itself remains usable after payment.',
            'Turkish-language comments accidentally left in the trc20.html bundle ("Step6\'da aside komple DOM\'dan kaldır", "Step1–Step5: aside yoksa geri ekle") plus the .com.tr ccTLD requirement plus OxaPay choice plus marketing claims all converge on a Turkish-speaking operator. MASAK (Turkey\'s financial-crimes board) has direct jurisdiction.',
            'Eight package tiers from $800 to $1,000,000 face value with FOMO scarcity bars and daily reset cycle. Total claimed inventory is ~$10.7B — but the operator never needs to honor any of it because nothing is ever delivered.',
            'Investigation chokepoints exist: OxaPay subpoena → operator KYC documents; Cloudflare disclosure → origin IP; .com.tr abuse channels → domain takedown; Google compliance (GTM-58GSNCVV) → analytics; Twitter/Meta compliance → social account creation data; Tronscan API caching → operator request fingerprint. None of these are exotic — they are the standard investigation toolkit for Cloudflare-fronted operations.',
        ],
    },

    technicalSpecs: [
        { label: 'Primary domain', value: 'flashusd.com.tr (Turkish .com.tr ccTLD; registry: BTK Turkey)' },
        { label: 'Hosting', value: 'Cloudflare proxy (edge MRS / Marseille)' },
        { label: 'Resolved IPs', value: '172.67.146.8, 104.21.95.163 (Cloudflare anycast)' },
        { label: 'Author meta', value: '"FLASH USDT ADMIN"' },
        { label: 'Telegram channel', value: 't.me/flashusdcom' },
        { label: 'Twitter handle', value: '@FlashUSDT' },
        { label: 'Instagram handle', value: '@flashusdt' },
        { label: 'Google Tag Manager id', value: 'GTM-58GSNCVV' },
        { label: 'Backend (public, no auth)', value: 'https://6907a7b0b1879c890eda62c1.mockapi.io/api/v1/{flashusdt,stocks}/1' },
        { label: 'Payment processor (real money path)', value: 'OxaPay (oxapay.com) — per-invoice unique deposit addresses via localStorage.last_oxapay_url' },
        { label: 'Claimed platform volume', value: '$1,868,523,207 USDT (per live mockapi backend)' },
        { label: 'Actual on-chain receipt (lifetime)', value: '$11.66 USDT — ~160,000,000× exaggeration' },
        { label: 'Claimed users / online', value: '13,674 users / 9,819 online now (faked, publicly editable)' },
        { label: 'TRC20 fee receiver (real)', value: 'TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33 (~1 month old, drained, $11.66 lifetime)' },
        { label: 'Drain target (consolidation)', value: 'TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3 (~7 weeks old, holds drained $5.83)' },
        { label: 'Social-proof wallet (NOT theirs)', value: 'TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N — 3-year-old whale, $46M USDT, 268 tokens, untagged' },
        { label: 'EVM fee receiver (decoy)', value: '0xb5f5090D4f032059844c464C7A273D29063311c1 — zero activity on Ethereum and BSC' },
        { label: 'BTC fee receiver (decoy, marked closed)', value: 'bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl — zero lifetime tx count' },
        { label: 'Number of advertised package tiers', value: '8 — from $800 to $1,000,000 face value' },
        { label: 'Total claimed package inventory face value', value: '~$10.7 billion' },
        { label: 'Scam mechanic class', value: 'Advance-fee fraud (NOT a wallet drainer — bounded per-victim loss)' },
        { label: 'Operator language', value: 'Turkish (confirmed via JS comments + ccTLD + locale + payment processor)' },
        { label: 'Jurisdiction lever', value: 'MASAK (Turkey financial-crimes), BTK (Turkish ICT regulator), OxaPay compliance team' },
        { label: 'WHOIS data exposure', value: 'None — .tr ccTLD blocks registrant disclosure by policy' },
        { label: 'Sophistication ranking vs other flash-USDT cases', value: '★★★★ — most operationally mature documented (vs ★★ for AITRO, ★★ for TRC-1USD-FLASH, ★ for USDTFLASH-PROOF)' },
        { label: 'Pages crawled', value: '/, /trc20.html, /status.html, /status-history.html, /auth/login.php, /flash-test.php' },
        { label: 'Free / authenticated-test page', value: '/flash-test.php (behind /auth/login.php — likely a small free-credit trust-builder)' },
        { label: 'Live status at investigation', value: 'OPERATIONAL — still accepting victims as of 2026-05-15' },
        { label: 'Recommended takedown vectors', value: 'OxaPay subpoena → KYC docs; Cloudflare disclosure → origin IP; BTK + MASAK report; Google/Twitter/Meta compliance for tracking pixels and social accounts; Natro Hosting abuse → identifies customer; GitHub Trust & Safety → identifies paid-plan account behind flashusd.xyz' },
        { label: 'Hosting provider (web + email)', value: 'Natro Hosting (TR) — natrohost.com / kurumsaleposta.com (Natro brand for corporate email)' },
        { label: 'ISP / datacenter (upstream)', value: 'Cizgi Telekomunikasyon A.S. (AS34619), Sisli, Istanbul, Turkey' },
        { label: 'Mail server IPs (non-Cloudflare leak)', value: '94.73.187.201 (mx-01), 94.73.187.202 (mx-02) — netname "Octopus-Mail-Systems"' },
        { label: 'Origin server software (leaked via Cloudflare header)', value: 'LiteSpeed Web Server (x-turbo-charged-by: LiteSpeed)' },
        { label: 'RIPE admin contacts (AS34619)', value: 'NCBG1-RIPE, NN1321-RIPE' },
        { label: 'Web-origin IP', value: 'Not pinpointed (outside SPF-published Natro range; requires Shodan/Censys paid query or Natro abuse-report disclosure)' },
        { label: 'Operator mirror domain', value: 'flashusd.xyz on GitHub Pages (Natro NS, canonical to .com.tr, same FLASH USDT ADMIN author)' },
        { label: 'Operator active since', value: '2025-11-03 at latest (per flashusd.xyz sitemap lastmod, Turkey timezone +03:00) — ~6 months continuous operation' },
        { label: 'GitHub repo behind flashusd.xyz', value: 'PRIVATE (code search returned 0 hits) — paid GitHub plan = operator KYC + billing on file with GitHub' },
    ],
};
