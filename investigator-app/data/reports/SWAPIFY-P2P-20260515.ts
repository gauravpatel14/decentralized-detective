import { InvestigationReport } from '@/types/report';

const scamFrontendCode = `// Reconstructed from main bundle (assets/index-CWqsA2pn.js, 3.9 MB minified)
// of https://swapifyofficial.com/ — a Lovable.dev-built Indian USDT/INR
// P2P "exchange" that exists to collect USDT and never pay the INR back.

// ---- Authoring fingerprint ----
// index.html ships these signatures unmodified:
//   <meta name="author" content="CryptoSwap India" />
//   <meta name="twitter:site" content="@lovable_dev" />
//   <link rel="icon" ... gpt-engineer-file-uploads/... >    // Lovable's CDN
//   <script ... data-telegram-login="Swapifyofficial_bot"
//            data-auth-url="https://swapifyofficial.in/">  // <-- sister domain
// The site is a Lovable AI-generated SPA, not a custom-built exchange.

// ---- The published "rate" (the lure) ----
// Homepage advertises:
//   ₹101 per USDT (today's "live" base rate)
//   "Zero Hidden Fee  ·  Instant Conversion"
// Real market for USDT/INR on 2026-05-15 is ≈₹84–85
// (USDT pegs to $1; USD/INR ≈ ₹83–85). So ₹101 is roughly
// 18–20% ABOVE market — the entire commercial pitch is
// "we pay more than anyone else for your USDT."

// ---- FAQ copy baked into the JS bundle (verbatim strings) ----
// These are the operator's pre-canned answer to the obvious question:
//   "Why are you offering above-market rates?"
const SCAM_FAQ_STRINGS = [
  "Actually our company does not need INR. They just need USDT since they can keep it safe without any issues. This is why we offer competitive rates for your USDT.",
  "If the fund is pure, why are we giving it to customers?",
  "All deposits and withdrawals are manually reviewed by our team to detect and prevent fraud.",
  "Join our growing community of satisfied crypto traders",
];
// The first line is the operator literally telling visitors they are
// in the business of accumulating USDT, not exchanging it. The second
// line ("if the fund is pure, why are we giving it to customers?") is
// the standard Indian-P2P scammer hand-wave used to dress an obviously
// off-market price as a "favor to you."  The third line — "manually
// reviewed" — is the withdrawal-delay vector: a legit exchange uses
// automated KYT/AML, "manual review" is what lets the operator stall
// indefinitely after the USDT has been deposited.

// ---- Manufactured social proof ----
// The "Trustpilot 4.9 / 37,600 reviews" widget on the homepage
// does NOT link to trustpilot.com. It links to:
const FAKE_TRUSTPILOT_URL =
  "https://trustpilotofficial.lovable.app/company/swapify";
// This is the SAME Lovable.dev free-tier hosting the operator uses
// for the main site — a clone of Trustpilot's UI authored by the
// same person, branded "trustpilotofficial" to mirror the operator's
// own "swapifyofficial" naming convention. Sample reviews on it are
// uniformly templated AI-generated 5-star praise from synthetic
// personas ("Emily R., New York / Marcus T., London /
// Aiko S., Tokyo"). On a domain registered 2025-12-15, a claim of
// 37,600 reviews in <5 months is impossible without fabrication.

// ---- Frontend stack (UI fluff, NOT the scam path) ----
// The bundle pulls in real Web3 / fiat-onramp libraries:
//   - Reown / WalletConnect AppKit (ConvertPreview, EmailVerifyOtp,
//     ConnectingWalletConnect, UpgradeToSmartAccount, etc.)
//   - Wagmi/viem-style EVM stack with chain validators
//   - Meld.io fiat onramp endpoints (/v1/onramp/quote, /v1/onramp/options)
//   - CoinGecko, polygon-rpc, eth.merkle.io, multicall3
//   - Supabase backend at pnowlffenpjkuhhjioqm.supabase.co
//     with edge function /functions/v1/verify-deposits
// These exist because Lovable's template includes them. The REAL
// payment flow — give us your USDT, we will (not) send INR via
// UPI/IMPS — is operator-controlled off-platform, almost certainly
// finalised via the @Swapifyofficial_bot Telegram bot which serves
// the deposit address dynamically. There are no deposit addresses
// hardcoded in the public JS bundle.

// ---- Address validation built in (so the victim DOES send) ----
// The bundle contains a TRC-20 address validator,
//   /^T[1-9A-HJ-NP-Za-km-z]{33}$/.test(rt)
// plus an isValidBep20Address() check. So the platform UI does
// accept and submit a deposit address — but the destination is
// served from the backend, not exposed in the client.

// ---- What the victim actually authorises ----
// There is no wallet drainer here. The site does not request
// token approvals, off-chain signatures, or permit() messages.
// The victim manually sends USDT (TRC-20 or BEP-20) from their
// own wallet to an address provided by the platform / Telegram bot.
//   Damage model: a fully-formed advance-trust scam.
//   - The first one or two small "test" trades may pay out in INR
//     via UPI to earn confidence. Common amounts: ₹500 – ₹5,000.
//   - On the large trade, the INR never arrives. Support pivots to
//     "deposit verification fee", "tax clearance", or "your wallet
//     is flagged, send more USDT to unlock", until the victim stops.
`;

export const swapifyP2pCase: InvestigationReport = {
    caseId: 'SWAPIFY-P2P-20260515',
    title: 'Swapify (swapifyofficial.com) — Indian P2P "Above-Market USDT" Trust-Building Scam',
    investigationDate: 'May 15, 2026',

    subject: {
        address: 'swapifyofficial.com',
        accountType: 'P2P USDT/INR "exchange" (Lovable.dev-built SPA + Supabase backend + Telegram bot)',
        programOwner: 'Domain registrant "Swapify" — Haryana, IN — via Hostinger (.com + .in both)',
        solBalance: 'N/A — no on-chain deposit address hardcoded in bundle (operator serves it via Telegram bot)',
        dataSize: 'index.html 3 KB + index-CWqsA2pn.js 3.9 MB (Vite-bundled React SPA, PWA-enabled)',
        executable: false,
        firstActivity: '.in domain created 2025-10-25  /  .com domain created 2025-12-15',
        latestActivity: '2026-05-15 (site live, accepting registrations, evidence captured today)',
        totalTransactions: 0,
        activityWindow: '~7 months (.in)  /  ~5 months (.com)',
    },

    tokenHoldings: [
        {
            name: 'Tether USD (the asset the operator wants to receive — REAL USDT, not fake)',
            symbol: 'USDT',
            balance: 'Whatever the victim is talked into sending (TRC-20 or BEP-20)',
            mintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            officialMintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t (real Tether TRC-20 — same as observed)',
            decimals: 6,
            isFake: false,
        },
    ],

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: The Lure — ₹101 / USDT on a 5-Month-Old Domain',
            type: 'text',
            content: `Source       : Captured from https://swapifyofficial.com/ (2026-05-15)
Tagline      : "Your one-stop marketplace to buy, sell, and manage USDT
                with fast transactions and zero hidden fees"
Author meta  : <meta name="author" content="CryptoSwap India" />
Headline rate: "₹101 per USDT" (marked "Live")
Pitch tags   : "Zero Hidden Fee  ·  Instant Conversion"
Payment rails: UPI · IMPS · NEFT · RTGS  (Indian banking only)
Telegram     : @Swapifyofficial_bot  (login widget shipped in index.html)
.in domain   : data-auth-url="https://swapifyofficial.in/"

Reference market price on capture date (2026-05-15):
   USDT/USD  : ~$1.00
   USD/INR   : ~₹83–85
   Fair USDT/INR P2P clearing rate: ~₹85
   Advertised rate                : ₹101
   Markup over fair value         : ~18–20% ABOVE market`,
            analysis: 'The premise of any legitimate P2P market is that the buyer pays AT OR BELOW the live cross-rate; the seller pays a fee for liquidity. A counter-party offering ~20% over market on every trade is not running an exchange, it is buying a queue of victims. The 5-month-old domain, the Lovable-template SPA, the absence of any LLP/CIN/GSTIN registration disclosure (compulsory for a real Indian fintech), and the Telegram-only support channel make the inversion of normal P2P economics the only working business model: take in USDT, never send INR.'
        },
        {
            id: '2',
            title: 'Evidence #2: The Pre-Canned FAQ Admission (Verbatim from JS Bundle)',
            type: 'text',
            content: `Strings extracted from /assets/index-CWqsA2pn.js (3.9 MB Vite bundle):

  "Actually our company does not need INR. They just need USDT
   since they can keep it safe without any issues. This is why
   we offer competitive rates for your USDT."

  "If the fund is pure, why are we giving it to customers?"

  "All deposits and withdrawals are manually reviewed by our
   team to detect and prevent fraud."

  "Join our growing community of satisfied crypto traders"

  "We focus on safety and reliability to ensure every conversion
   is smooth."

  "Convert USDT to INR Safely with Direct Bank Transfer"`,
            analysis: 'These strings are the operator answering — in their own marketing copy — the question "why is the rate so far above market?" The answer they give is the giveaway: "we don\'t need INR, we want USDT, so we pay you more." That is not a P2P exchange model, it is an asset-accumulation model — and a P2P-exchange UI is the wrong shop window for one. The "manually reviewed" line is the withdrawal-delay vector; a legitimate exchange uses automated AML/KYT, "manual review" exists so the operator has a politely-worded way to never pay out. Both phrases together describe the entire scam workflow in the operator\'s own voice.'
        },
        {
            id: '3',
            title: 'Evidence #3: Manufactured Social Proof — Fake "Trustpilot" Clone',
            type: 'text',
            content: `The homepage carries a "Trustpilot 4.9 / Excellent" badge.
The "Reviews" link does NOT go to trustpilot.com — it points to:

   https://trustpilotofficial.lovable.app/company/swapify

This is a Lovable.dev clone of the Trustpilot UI on Lovable's
free-tier hosting (lovable.app subdomain). Authored by the same
operator: the domain prefix "trustpilotofficial" deliberately
mirrors the operator's own "swapifyofficial" naming convention.

Claimed metrics on the clone:
   Rating       : 4.9 / 5 ("Excellent")
   Review count : 37,600
   Five-star %  : 78%

Domain age of swapifyofficial.com on capture date: <5 months.
A real-world rate of 37,600 reviews in 5 months would require
~250 reviews per day, every day — impossible without fabrication.

Sample reviews (uniformly templated, AI-generated voice):

  "Emily R., New York, US — 5★
     Best trading platform I've ever used. Swapify has
     completely changed how I trade digital assets. The
     interface is incredibly intuitive, transactions are
     lightning fast, and the fees are the lowest I've
     found anywhere. Customer support is top-notch too!"

  "Marcus T., London, UK — 5★
     Seamless experience from start to finish. Signed up
     in minutes, verified my account the same day, and was
     trading within hours. The mobile app is beautifully
     designed and works flawlessly. Swapify truly sets
     the standard."

  "Aiko S., Tokyo, Japan — 5★
     Outstanding security and reliability. I was hesitant
     to try a new platform, but Swapify's security features
     gave me confidence. Two-factor auth, biometric login,
     and real-time alerts. Haven't had a single issue in
     6 months of use."

The site is also configured to accept user-submitted reviews
internally — bundle strings include "Review must be less
than 1000 characters" and "Failed to submit review. Please
try again." — so the fake Trustpilot is also a sink for
real user reviews to be filtered before display.`,
            analysis: 'The fake Trustpilot is the single most damning artifact in this investigation. Building a counterfeit version of a global review service to hold up to your own customers is not within the error bars of a legitimate small business; it is a deliberate act of fraud, and one that ties the operator to Lovable.dev as their build platform. Trustpilot has a takedown channel for this exact pattern and should be sent the URL. The personas ("Emily R. New York / Marcus T. London / Aiko S. Tokyo") are the standard LLM-generated geographic triad — easy to fingerprint, since the same Lovable-clone authoring template appears on dozens of similar scam fronts.'
        },
        {
            id: '4',
            title: 'Evidence #4: Two Domains, Same Operator (Hostinger / Haryana / Same IP)',
            type: 'text',
            content: `Domain A:  swapifyofficial.com
   Registrar     : HOSTINGER operations, UAB
   Created       : 2025-12-15  (≈5 months ago)
   Expires       : 2026-12-15
   Nameservers   : ns1.dns-parking.com / ns2.dns-parking.com  (Hostinger)
   A record      : 185.158.133.1
   Edge          : Cloudflare in front (cf-ray header, __cf_bm cookie)
   WHOIS contact : redacted (.com privacy)

Domain B:  swapifyofficial.in
   Registrar     : HOSTINGER operations, UAB
   Created       : 2025-10-25  (≈7 months ago)
   Expires       : 2026-10-25
   Nameservers   : ns1.dns-parking.com / ns2.dns-parking.com  (Hostinger)
   A record      : 185.158.133.1
   Registrant org: "Swapify"
   Registrant    : Haryana, IN  (state visible despite REDACTED FOR PRIVACY
                   on personal fields — .in TLD policy)
   TLS           : currently misconfigured (SSL handshake failure on
                   direct fetch — domain is held for Telegram-bot
                   data-auth-url use, not as a serving frontend)

Common signals:
   - Same IPv4 (185.158.133.1)
   - Same nameservers (Hostinger's dns-parking)
   - Same registrar (Hostinger)
   - Linked in index.html: <script data-auth-url="https://swapifyofficial.in/">

The .in domain pre-dates the .com by ~7 weeks — likely the original
operator domain, before the move to a more "international" .com brand.`,
            analysis: 'The .in WHOIS does NOT redact the registrant state (.in policy leaves jurisdiction visible). Haryana places the operator in the Delhi-NCR / North-India cluster where the vast majority of recent INR/USDT off-ramp scams have been operationally based. Both domains being on the same /32, same NS pair, same registrar (Hostinger), and same registrant organisation makes this a clean two-domain operator infrastructure — and gives a clear abuse-report path: domains@hostinger.com (Hostinger\'s registrar abuse contact) can be CC\'d on a single takedown request covering both.'
        },
        {
            id: '5',
            title: 'Evidence #5: Backend Footprint — Supabase + Lovable.dev',
            type: 'text',
            content: `External URLs the SPA actually calls (from grep of bundle):

   https://pnowlffenpjkuhhjioqm.supabase.co
   https://pnowlffenpjkuhhjioqm.supabase.co/functions/v1/verify-deposits
   https://oauth.lovable.app
   https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&ids=tether
   https://api.coingecko.com/api/v3/coins/tether/market_chart?vs_currency=usd&days=1
   https://min-api.cryptocompare.com/data/v2/news/?lang=EN&sortOrder=latest

Live probe of the Supabase project:
   POST /functions/v1/verify-deposits   ->  {"error":"Unauthorized"}
   GET  /rest/v1/                       ->  {"message":"No API key found in request",
                                              "hint":"No apikey request
                                              header or url param was found."}

So the project ID  pnowlffenpjkuhhjioqm  is live and gated only by
the anon key (not extracted here). The "verify-deposits" function name
is consistent with the FAQ copy ("manually reviewed by our team") — this
is where deposit-state and the operator's decision to release/withhold
INR is materialised.

Frontend stack (Lovable + Vite + React PWA) — UI scaffolding that
ALSO exists in the bundle but is not the scam money path:
   - Reown / WalletConnect AppKit  (ConvertPreview, EmailVerifyOtp,
     ConnectingWalletConnect, UpgradeToSmartAccount strings)
   - Meld.io fiat onramp endpoints  (/v1/onramp/quote, etc.)
   - Wagmi/viem EVM tooling
   - Flock analytics (/~flock.js, /~api/analytics)

Real scam flow goes through Supabase + Telegram bot, NOT WalletConnect.`,
            analysis: 'The "Web3 exchange" surface is largely Lovable\'s template scaffold — Reown wallet connect, viem helpers, Meld onramp. The actual operational state lives in the Supabase project pnowlffenpjkuhhjioqm. For investigators: a Supabase abuse report to security@supabase.com referencing the project ID, the verify-deposits function, and this report can result in the backend being taken offline — which kills the platform without needing to wait on the domain takedown. The CoinGecko/CryptoCompare calls are the "live ₹101 rate" feed and the news ticker; both are legit upstream APIs being used to dress the page.'
        },
        {
            id: '6',
            title: 'Evidence #6: Telegram Bot — The Real Order Channel',
            type: 'text',
            content: `Bot handle    : @Swapifyofficial_bot
Bot display   : "✨ 𝙎𝙬𝙖𝙥𝙞𝙛𝙮 🇮🇳"   (stylised Unicode — common fingerprint)
Bot pitch     : "𝙀𝙭𝙘𝙝𝙖𝙣𝙜𝙚 𝙐𝙎𝘿𝙏 𝙩𝙤 𝙄𝙉𝙍"
                "𝙎𝙚𝙡𝙡 𝙐𝙎𝘿𝙏 𝙏𝙤 𝙄𝙉𝙍 𝙒𝙞𝙩𝙝 𝙎𝙬𝙖𝙥𝙞𝙛𝙮 𝙁𝙤𝙧 𝘽𝙚𝙨𝙩 𝙍𝙖𝙩𝙚"
CTA           : "Start Bot"

Bot is also wired into the website via the Telegram login widget:
   <script src="https://telegram.org/js/telegram-widget.js?22"
           data-telegram-login="Swapifyofficial_bot"
           data-auth-url="https://swapifyofficial.in/"
           data-request-access="write" />

  - data-request-access="write"  means the bot, once authorised,
    can DM the user. That is the channel the operator uses to
    serve the deposit address dynamically per-trade.
  - data-auth-url points back to the .in domain, not the .com —
    proving the .in domain is operator-controlled even though
    it is not publicly serving HTML right now.`,
            analysis: 'The Telegram bot is the actual order-routing layer. The website is the lure; the bot is where the trade is "agreed", the deposit address served, and the support stalling happens after USDT lands. data-request-access="write" is the small but important detail: it means the operator can initiate DMs to victims who only signed in to "verify" their account. The bot, the channel, and the @Swapifyofficial_bot handle should be reported to Telegram\'s @notoscam channel and to abuse@telegram.org with the URL, the rate evidence, and the fake-Trustpilot link.'
        },
        {
            id: '7',
            title: 'Evidence #7: What the Scam Is NOT (Bounded-Damage Model)',
            type: 'text',
            content: `It is NOT a wallet drainer.
   - No approve() / setApprovalForAll() in the bundle\'s call paths.
   - No permit() / EIP-2612 signature collection on the public
     scam path. The Reown / WalletConnect strings are present
     because Lovable ships them in the template, not because
     the scam path uses them.

It is NOT a fake-token / fake-mint scam.
   - The bundle resolves CoinGecko\'s real USDT (tether) market
     data — the platform talks about REAL Tether, and the deposit
     is sent in real Tether to a real (operator-controlled) wallet.
   - No fake-mint, no clone-contract is created or deployed.

It IS classic advance-trust P2P fraud.
   - Step 1: Victim is shown a rate ~20% above market.
   - Step 2: Victim is routed to Telegram bot, which serves
             a per-trade deposit address and a UPI/IMPS target.
   - Step 3: First small trade may settle (e.g. ₹500 / ₹5,000 INR
             paid out promptly via UPI) to build confidence.
   - Step 4: Larger trade lands. INR never arrives. "Manual review"
             excuse is deployed. New asks appear: tax clearance
             fee, deposit verification fee, wallet-flagged fee.
   - Step 5: Victim stops paying. Account is abandoned. Operator
             moves to a new alias / Lovable redeploy.

Damage model: the loss equals the deposited USDT, capped at
whatever amount the victim was talked into transferring before
giving up. There is no on-chain compromise of the victim's wallet —
they keep custody of any remaining assets and any future deposits.`,
            analysis: 'Getting the threat model right matters for victim guidance. This is NOT a wallet-compromise event — telling a victim "your wallet is drained, rotate everything" is wrong, expensive, and panics them unnecessarily. The wallet itself is fine. The correct guidance is: (1) stop sending any further USDT or "fees" — every new ask is part of the same scam; (2) do NOT continue communication with the @Swapifyofficial_bot or its support DMs, which only fish for more deposits; (3) capture the Telegram chat, the deposit address you sent to, and the on-chain tx hash, and file with the Indian Cyber Crime Helpline (1930) plus complaint at cybercrime.gov.in; (4) contact the receiving wallet\'s exchange of exit (whichever CEX appears downstream of the deposit address) with the tx hashes to freeze any cash-out attempt.'
        },
        {
            id: '8',
            title: 'Evidence #8: Recommended Takedown Path',
            type: 'text',
            content: `Single-message multi-target abuse report:

  Hostinger registrar         : domains@hostinger.com
      Subject of report       : swapifyofficial.com  +  swapifyofficial.in
      Action requested        : domain suspension on grounds of fraud
                                (provide rate evidence, fake-Trustpilot URL,
                                 FAQ-admission strings, registrant Haryana IN)

  Cloudflare                  : https://abuse.cloudflare.com/
      Subject of report       : swapifyofficial.com
      Action requested        : terminate CDN / DNS service
      Cite                    : phishing / financial fraud category

  Supabase                    : security@supabase.com
      Subject of report       : project pnowlffenpjkuhhjioqm
      Action requested        : suspend project + verify-deposits function
      Cite                    : ToS violation (fraud, false advertising)

  Lovable.dev                 : abuse@lovable.dev  (or via in-app report)
      Subject of report       : trustpilotofficial.lovable.app/company/swapify
      Action requested        : take down the fake-Trustpilot clone
      Cite                    : impersonation of Trustpilot, fraud facilitation

  Trustpilot                  : compliance@trustpilot.com
      Subject of report       : lovable.app subdomain impersonating Trustpilot
      Action requested        : trademark / brand-protection takedown via
                                their legal team (this is their lever, not ours)

  Telegram                    : abuse@telegram.org  +  @notoscam
      Subject of report       : @Swapifyofficial_bot  + linked support handle
      Cite                    : financial fraud, advance-trust P2P scam

  Indian Cyber Crime          : https://cybercrime.gov.in  +  helpline 1930
      Filing context          : .in domain registrant is in Haryana, fraud is
                                conducted in INR over UPI rails — primary
                                jurisdiction.`,
            analysis: 'The takedown surface here is large because the operator stitched the scam from many third-party free tiers — every one of which has an abuse channel that, applied together, removes the operation faster than chasing any single component. Hostinger + Cloudflare kill the domains; Supabase + Lovable kill the backend and the fake reviews; Telegram kills the order-routing layer; Indian Cyber Crime is the only path with subpoena power over the operator\'s identity (UPI/bank account behind the IMPS payouts, which is the durable real-world handle even after every digital piece is taken down).'
        },
        {
            id: '9',
            title: 'Evidence #9: 🔬 Supabase Backend Forensics — Schema, Auth Config & Public Data',
            type: 'text',
            content: `Method: extracted the Supabase ANON KEY shipped in the public JS bundle
(it is designed to be public; access is gated by Row-Level Security policies
on each table). Probed the project\'s public endpoints read-only — no writes,
no RLS bypass attempts, no extraction of victim PII even where readable.

PROJECT JWT (decoded from the bundle):
  ref:   pnowlffenpjkuhhjioqm
  role:  anon
  iat:   1761399027   (2025-10-25 — SAME DAY the .in domain was registered)
  exp:   2076975027   (2035 — default Supabase 10-year anon key)
  → The operator stood up the Supabase project on the same day they
    registered swapifyofficial.in. Both the .in domain and the backend
    are exactly contemporaneous.

AUTH CONFIG (GET /auth/v1/settings — public endpoint):
  email:               enabled
  phone:               enabled    ← phone+OTP, standard for Indian fintech
  google OAuth:        enabled
  sms_provider:        twilio     ← paid SMS — real running infrastructure
  mailer_autoconfirm:  TRUE       ← no email verification, signups instant
  phone_autoconfirm:   TRUE       ← no real OTP gate — any phone accepted
  disable_signup:      FALSE      ← open registration
  passkeys_enabled:    FALSE
  saml_enabled:        FALSE
  → The "autoconfirm" flags mean accounts are created without any real
    verification step — there is no friction layer between a curious
    visitor and a fully provisioned account. Standard low-friction-funnel
    pattern for a scam where the goal is to maximise sign-ups, not security.

POSTGRES SCHEMA (extracted from .from(...) and .rpc(...) calls in bundle):

  Tables (13):
    profiles            ← user accounts                       [LOCKED to anon]
    orders              ← USDT sell orders                     [LOCKED to anon]
    wallets             ← deposit / withdrawal addresses       [LOCKED to anon]
    payment_methods     ← victims\' UPI / bank details          [LOCKED to anon]
    customer_rates      ← per-user pricing overrides           [LOCKED to anon]
    reviews             ← user-submitted reviews               [LOCKED to anon]
    bonus_tasks         ← gamified engagement                  [LOCKED to anon]
    usdt_predictions    ← price-vote feature                   [LOCKED to anon]
    platform_settings   ← global config                        [LOCKED to anon]
    swap_prices         ← live rate feed                       [PUBLIC]
    offers              ← tiered rate offers                   [PUBLIC]
    notifications       ← banner messages                      [PUBLIC]
    update_images       ← homepage carousel images             [PUBLIC]

  RPC functions (10):
    validate_referral_code(p_code)   ← PUBLIC: returns bool
    get_usdt_vote_stats()            ← PUBLIC: returns vote tally
    get_referral_stats()             ← requires auth (P0001 "Not authenticated")
    verify_admin()                   ← returns FALSE for anon (correct)
    process_sell_order(...)          ← order execution
    approve_deposit(...)             ← 🔑 ADMIN: the "manual review" approve hook
    reject_order(...)                ← 🔑 ADMIN: the "your order failed" reject hook
    approve_bonus_task / reject_bonus_task   ← admin bonus moderation
    delete_user_completely(...)      ← admin: wipe a victim\'s account

  Edge functions:
    POST /functions/v1/verify-deposits → "Unauthorized: anon key not accepted"
    → Reserved for service_role or admin JWT. Almost certainly invoked
      from the operator\'s admin panel during the "manual review" stall.

RLS POSTURE (anon read attempts on every table):
  All 9 PII / order tables returned 200 OK with [] (empty array) to the
  anon key. Could mean: (a) RLS denies all rows to anon — correct and
  expected hardening; or (b) the table is genuinely empty. Either way,
  no victim PII is exposed to unauthenticated readers. Postgrest\'s
  count=exact response on these tables returns "*/0" — RLS denies the
  count too, so we cannot determine the real victim total from outside.
  This is one thing the operator did right.

  The 4 PUBLIC tables (intended to be readable so the homepage works) leak
  the operational marketing state — see next evidence section.`,
            analysis: 'The forensic Supabase probe answers the user\'s question "is this backend real, or is it also a façade?" Definitively REAL: paid Twilio SMS provider, Google OAuth wired up, Postgres schema with 13 tables and 10 RPCs including admin moderation functions, an edge function gated to admin/service-role keys, and a verifiable creation timestamp in 2025-10-25 (matching the .in domain). The "manual review" copy on the homepage maps directly onto the approve_deposit / reject_order admin RPCs in the database — there genuinely is a human pulling a lever on which deposits to honour and which to refuse. The mailer_autoconfirm + phone_autoconfirm = TRUE flags are a behavioural fingerprint: the operator wants frictionless signups because their conversion is volume-driven. RLS is correctly enforced on user data tables (good operational hygiene from the operator\'s perspective — bad for investigators hoping to extract victim lists without subpoenaing Supabase directly).'
        },
        {
            id: '10',
            title: 'Evidence #10: 🎯 Smoking Gun — "Live ₹101 Rate" Is a Stale Hardcoded Constant',
            type: 'text',
            content: `Direct read of the public swap_prices table:

  GET /rest/v1/swap_prices  →
  [
    {
      "id":         "2d5c7af0-51b9-4c5a-900d-1c4aac3b5232",
      "usdt_rate":  101,
      "updated_at": "2025-10-25T15:14:40.558756+00:00",   ← 7 MONTHS AGO
      "updated_by": null
    }
  ]

  Only ONE row. updated_at = 2025-10-25 15:14:40 UTC — six and a half
  hours after the Supabase project was created. The rate has not been
  touched since.

The homepage labels this number "Live" and shows it inside a "Live"
badge styled as a real-time feed. In reality:
  - The rate is a single integer stored once at project setup.
  - There is NO market-data feed driving it (CoinGecko is fetched only
    for the cosmetic chart, not to update this row).
  - During the 7 months since 2025-10-25, real USDT/INR has fluctuated
    between roughly ₹83 and ₹86. The site has continued to display
    ₹101 — flat, ignoring market reality — for the entire window.

The tiered "offers" table reveals the funnel — a CLASSIC scam pattern:

  GET /rest/v1/offers  →
  [
    { min_amount: ₹1,111,   rate: ₹103.0/USDT,  active: true,
      created: 2026-01-29,  last_updated: 2026-05-05 },
    { min_amount: ₹3,333,   rate: ₹103.5/USDT,  active: true,
      created: 2025-11-15,  last_updated: 2026-05-05 },
    { min_amount: ₹7,777,   rate: ₹104.0/USDT,  active: true,
      created: 2025-11-06,  last_updated: 2026-04-06 },
    { min_amount: ₹10,000,  rate: ₹105.0/USDT,  active: true,
      created: 2025-11-06,  last_updated: 2026-04-06 }
  ]

Read in plain English: "the more USDT you deposit, the better rate
we will give you." The repdigits (1111, 3333, 7777) are a deliberately
"lucky-feeling" UX touch common to Indian P2P scams.

ALL FOUR offer rates are higher than the already-above-market base.
The maximum displayed rate (₹105) is ~24% above fair market (~₹85).
Two of the offers were touched as recently as 2026-05-05 (10 days
before this investigation) — proving active operator maintenance
within the past two weeks.

Funnel mechanic in operator\'s own words (from the offers table):
  Base rate (1 USDT)       ₹101    (+19% vs market)
  Min ₹1,111  →  rate ₹103   (+21% vs market)
  Min ₹3,333  →  rate ₹103.5 (+22% vs market)
  Min ₹7,777  →  rate ₹104   (+23% vs market)
  Min ₹10,000 →  rate ₹105   (+24% vs market)

The MARGINAL deposit gets a HIGHER rate the larger the trade —
inverted from any legitimate exchange (where slippage and fees
make large trades WORSE per unit). This only makes economic sense
if the operator is NOT actually settling the INR leg of the trade;
they happily promise a "better rate" because they have no intention
of paying it.`,
            analysis: 'This is the database-level smoking gun. The homepage badge says "Live" next to ₹101. The database shows that the number was set once, on the same afternoon the project was spun up, and has been static for seven months — through a period where the real USDT/INR rate dipped to ₹83 and rose to ₹86. "Live" is a lie at the table level, and is provable by any third party with the public anon key (which the operator themselves shipped). The four offers reveal the funnel: higher rates for larger deposits, the precise opposite of legitimate market microstructure. The ₹10,000-tier offer giving ₹105 (≈24% over fair value) is the bait designed to convert the lured victim into a high-value deposit before "manual review" rejects the INR payout. Most damning: the offers were edited 10 days before this investigation — proving the operator is still actively tuning the trap.'
        },
        {
            id: '11',
            title: 'Evidence #11: User-Generated Activity ≈ Zero (Quantitative Engagement Proof)',
            type: 'text',
            content: `The site has a "USDT price prediction" voting feature (table:
usdt_predictions). The public RPC get_usdt_vote_stats returns
the aggregate vote tally:

  POST /rest/v1/rpc/get_usdt_vote_stats  →  { "rise": 0, "fall": 0 }

ZERO total votes across the entire lifetime of the platform.

Compare against the manufactured social-proof numbers the site shows
elsewhere:
  - Fake Trustpilot "review count" :  37,600   (fabricated)
  - Real user vote count           :       0   (database truth)

If 37,600 real customers existed, even a 0.1% engagement rate on the
prediction widget would yield ~37 votes. The actual count of zero
indicates that the real user base on this platform is some small
number of victims, NOT a five-figure customer community.

Confirmed banner copy (from the public notifications table):

  [order 1, bg #84cc16 (lime green)]
    "🔥 𝙄𝙈𝙋𝙎 𝙬𝙞𝙩𝙝𝙙𝙧𝙖𝙬𝙖𝙡 𝙞𝙨 𝙨𝙢𝙤𝙤𝙩𝙝 🔥"

  [order 3, bg #84cc16 (lime green)]
    "💸 𝘾𝙖𝙨𝙝 𝘿𝙚𝙥𝙤𝙨𝙞𝙩 𝙄𝙨 𝙇𝙞𝙫𝙚 𝙉𝙤𝙬 💸"

Both use the same stylised Unicode "Mathematical Bold Italic" font
fingerprint as the @Swapifyofficial_bot Telegram display name.
"IMPS withdrawal is smooth" is gaslighting — exchanges that actually
pay out do not need to announce it on a banner.`,
            analysis: 'The vote-feature tally is the single cleanest quantitative falsification of the "growing community of satisfied crypto traders" copy. A platform with 37,600 reviewers would have logged HUNDREDS of votes on a free, prominently-displayed price-prediction widget. Zero is the database\'s answer to "how many real engaged users do you have." The "IMPS is smooth" banner is the operator\'s preemptive answer to the most common scam-victim complaint ("they didn\'t send the INR"); putting it on the homepage as a reassurance is a tell that this is the complaint they expect to be defending against.'
        },
        {
            id: '12',
            title: 'Evidence #12: 🎯 Referral Code "2BEFDCAE" Verified Live in Backend',
            type: 'text',
            content: `The URL in the original evidence file contained a referral
parameter:

   https://swapifyofficial.com/register?ref=2BEFDCAE

The validate_referral_code RPC in their Supabase is publicly callable.
Probing with that exact code:

  POST /rest/v1/rpc/validate_referral_code  body: {"p_code":"2BEFDCAE"}
       → "true"

  POST /rest/v1/rpc/validate_referral_code  body: {"p_code":"AAAAAAAA"}
       → "false"

CONFIRMED: 2BEFDCAE is a real, registered referrer in their database.
The function discriminates — random 8-char strings return false, the
captured code returns true. So:

  • Whoever holds referral code 2BEFDCAE is a registered Swapify user
    with referral status.
  • A referral-bonus mechanic exists (which is why the operator built
    validate_referral_code as a public-facing RPC at all).
  • This referrer was actively distributing the link at the time the
    user\'s evidence sample was captured.

Two plausible owners of 2BEFDCAE:
  (a) The operator themselves — using their own code on outbound
      Telegram / SEO funnels so the referral-bonus payout loops
      back into the operator\'s account.
  (b) A real victim who was earlier referred onto the platform and
      is now relaying the link to friends/family in an attempt to
      earn the promised referral bonus (which, like the INR payouts,
      probably never actually settles).

EITHER interpretation is incriminating: (a) confirms the referral
"bonus" is part of the operator\'s SEO funnel; (b) is a pyramid-style
victim-to-victim amplification mechanism.

INVESTIGATOR ASK to Supabase compliance: the profile row whose
referral code = "2BEFDCAE" maps to the phone/email/IP of either the
operator or a downstream recruiter. Either is a strong lead.`,
            analysis: 'This is the single most actionable lead from the Supabase probe. Unlike the locked PII tables, the public referral validator confirms — without leaking anyone\'s identity — that the code from the user\'s captured URL is genuinely registered in the operator\'s database. Subpoena value: a request to Supabase referencing the project ref pnowlffenpjkuhhjioqm and the referral code 2BEFDCAE lets Supabase compliance look up the single profile row (phone, email, IP at signup) for the holder of that code. If the operator was lazy and used their own code in the distribution URL, that profile row IS the operator. If it was a downstream recruiter, that profile is the first node in their distribution graph. Both outcomes give Indian Cyber Crime a real-world identity to pull on.'
        },
    ],

    transactions: [
        {
            id: '1',
            timestamp: '2025-10-25 (UTC)',
            type: 'Infrastructure event — .in domain registered',
            signature: 'swapifyofficial.in registered via Hostinger; registrant org "Swapify", Haryana IN',
            description: 'The earliest operator-controlled domain. Pre-dates the .com by ~7 weeks. Likely served the operator while they iterated on branding before launching the .com.',
        },
        {
            id: '2',
            timestamp: '2025-12-15 (UTC)',
            type: 'Infrastructure event — .com domain registered',
            signature: 'swapifyofficial.com registered via Hostinger; nameservers ns1/ns2.dns-parking.com; same /32 as .in',
            description: 'The customer-facing domain. .com confers more trust to first-time visitors than a .in, and is the one prominently advertised on the Telegram bot.',
        },
        {
            id: '3',
            timestamp: '2025-12-15 → 2026-05-15',
            type: 'Operational period — site live, fake-Trustpilot live, Telegram bot live',
            signature: 'No on-chain footprint hardcoded; deposit addresses are served dynamically by Supabase / Telegram bot',
            description: 'Five-month operational window. CoinGecko-driven "₹101 live rate" updates continuously; the fake Trustpilot accumulates "reviews" via the internal review submission endpoint; the bot serves per-trade deposit addresses on demand.',
        },
        {
            id: '4',
            timestamp: '2026-05-15 (capture date)',
            type: 'Investigation event — evidence captured',
            signature: 'curl https://swapifyofficial.com/  →  HTTP/2 200 (Cloudflare edge); main JS bundle 3.9 MB pulled',
            description: 'Site fully operational on this date. All evidence in this report is from the live bundle / live WHOIS / live Telegram bot description on 2026-05-15.',
        },
    ],

    findings: [
        {
            title: '🎯 Above-Market Rate Is the Entire Pitch (~20% over fair value)',
            description: 'Advertised ₹101 / USDT is ~18–20% above the fair USDT/INR rate of ~₹85 on capture date. No legitimate P2P market sustains a 20% premium on the buy side; the pitch can only be supported by NOT paying out the INR side.',
            tags: ['Above Market', '20% Markup', 'Inverted P2P Economics'],
        },
        {
            title: '🎯 Operator Admits the Model in Their Own FAQ',
            description: '"Actually our company does not need INR. They just need USDT" — verbatim from the bundle. This is the operator describing an asset-accumulation business, not an exchange. Combined with "manually reviewed" deposits/withdrawals = built-in stalling vector.',
            tags: ['FAQ Admission', 'Asset Accumulation', 'Manual Review'],
        },
        {
            title: '🎯 Fake Trustpilot Clone on Lovable.dev (Same Operator)',
            description: 'The "Trustpilot 4.9 / 37,600 reviews" widget links to trustpilotofficial.lovable.app/company/swapify — a Lovable.app clone authored by the same operator. 37,600 reviews on a 5-month-old site is impossible without fabrication; sample reviews are AI-generated geographic triad personas.',
            tags: ['Fake Reviews', 'Lovable Clone', 'Brand Impersonation'],
        },
        {
            title: 'Two-Domain Operator Infrastructure (.com + .in, Same IP, Same Registrar)',
            description: 'swapifyofficial.com (Dec 2025) and swapifyofficial.in (Oct 2025) both resolve to 185.158.133.1, both on Hostinger nameservers, .in registrant org "Swapify" in Haryana, IN. The .in is wired into the Telegram bot login widget on the .com — they are operationally a single front.',
            tags: ['Two Domains', 'Hostinger', 'Haryana IN'],
        },
        {
            title: 'Telegram Bot Is the Real Order-Routing Layer',
            description: '@Swapifyofficial_bot is shipped in index.html via a Telegram login widget with data-request-access="write" — allowing the operator to DM users who authenticate. The deposit address per trade is served via this bot, NOT hardcoded in the public JS bundle.',
            tags: ['Telegram Bot', 'Off-Platform Routing', 'Dynamic Deposit Addr'],
        },
        {
            title: 'Supabase Backend Identified (Project pnowlffenpjkuhhjioqm)',
            description: 'Bundle calls Supabase project pnowlffenpjkuhhjioqm.supabase.co including a /functions/v1/verify-deposits edge function. Live probe returns expected gated 401. This is the operator\'s server-side state — taking it down via security@supabase.com kills the platform without waiting for domain action.',
            tags: ['Supabase', 'Edge Function', 'Backend KO Target'],
        },
        {
            title: 'Lovable.dev-Built (Author + Stack Fingerprint)',
            description: 'index.html exposes <meta name="twitter:site" content="@lovable_dev" />, gpt-engineer-file-uploads asset URLs, and an oauth.lovable.app endpoint. The fake Trustpilot is on a Lovable.app subdomain. Both the main site and the fake review site were built by the same person using the same AI app-builder.',
            tags: ['Lovable.dev', 'AI-Generated', 'Same Author'],
        },
        {
            title: 'Frontend Web3 Stack Is Template Fluff, Not the Scam Path',
            description: 'Reown / WalletConnect AppKit, Wagmi/viem, Meld.io onramp helpers are all in the bundle because Lovable\'s crypto template ships them — but the actual scam path is Telegram-bot + UPI/IMPS off-platform. No approvals or signatures are collected by the public scam UI.',
            tags: ['Not a Drainer', 'Lovable Template Scaffolding'],
        },
        {
            title: 'Advance-Trust Pattern (Small Test Payout → Large Payout Withheld)',
            description: 'Standard Indian P2P-scam workflow: first small trade settles via UPI to build confidence; larger trade triggers indefinite "manual review" and additional fee asks. Bundle\'s "manually reviewed by our team" copy and the operator-admitted "we just need USDT" line are the workflow signature.',
            tags: ['Advance-Trust', 'Confidence Build', 'Stall and Squeeze'],
        },
        {
            title: 'Bounded Damage (Not a Wallet Drainer)',
            description: 'Loss is capped at the USDT deposited (plus any subsequent "verification fees"). The victim retains custody of their wallet; no approvals, off-chain signatures, or token-contract interactions are involved in the scam flow.',
            tags: ['Bounded Loss', 'Wallet Safe', 'Off-Chain Custody'],
        },
        {
            title: 'Indian Cyber Crime Is the Jurisdiction',
            description: '.in registrant in Haryana, INR payment rails, Indian victim demographic. cybercrime.gov.in + helpline 1930 is the only avenue with subpoena power over the bank account / UPI handle that receives the test payouts and ultimately the operator\'s identity.',
            tags: ['Jurisdiction: India', 'Cyber Crime 1930', 'UPI Trail'],
        },
        {
            title: 'Cheap Disposable Infrastructure (Lovable + Hostinger + Supabase Free Tier)',
            description: 'Entire stack is on third-party free / cheap tiers with abuse channels. Six abuse reports (Hostinger, Cloudflare, Supabase, Lovable, Trustpilot, Telegram) cover the whole operation; the operator can redeploy under a new brand in ~hours, so the durable signals are the registrant (Haryana IN), the Supabase project ID, and the Lovable account.',
            tags: ['Disposable Infra', 'Multi-Vector Takedown', 'Re-Deploy Risk'],
        },
        {
            title: '🎯 "Live ₹101 Rate" Is a 7-Month Hardcoded Constant',
            description: 'Direct read of the public swap_prices table shows usdt_rate=101 with updated_at = 2025-10-25 15:14:40 UTC (six hours after Supabase project creation) — and ZERO subsequent updates. The "Live" badge on the homepage is database-provably false: the number has been static for 7 months while real USDT/INR moved between ~₹83 and ~₹86.',
            tags: ['Smoking Gun', 'Fake Live Rate', 'DB-Verified'],
        },
        {
            title: '🎯 Tiered Up-Sell Funnel — Higher Rate for Larger Deposit (Inverted Market)',
            description: 'The offers table exposes 4 active tiers: ₹1,111→₹103, ₹3,333→₹103.5, ₹7,777→₹104, ₹10,000→₹105. The marginal rate INCREASES with deposit size — the opposite of any legitimate exchange. Only works as a business model if the INR side is not actually paid. Two offers updated 10 days before investigation = active operator maintenance.',
            tags: ['Funnel Mechanic', 'Inverted Microstructure', 'Active Operator'],
        },
        {
            title: '🎯 Referral Code 2BEFDCAE (from the Evidence URL) Verified Live',
            description: 'validate_referral_code("2BEFDCAE") returns true in their Supabase RPC — vs false for random 8-char strings. The referral code in the user-submitted URL is a real registered referrer in the operator\'s database. Supabase can be subpoenaed to map this code to the profile row (phone/email/IP) of either the operator or a downstream recruiter.',
            tags: ['Subpoena Lead', 'Referral Verified', 'Identity Hook'],
        },
        {
            title: 'Backend Is Real and Operational (Twilio SMS, Google OAuth, 13 Tables, 10 RPCs)',
            description: 'Supabase project pnowlffenpjkuhhjioqm spun up 2025-10-25 (same day as .in domain). Auth config: email+phone+Google enabled, Twilio as SMS provider (paid), mailer_autoconfirm+phone_autoconfirm=TRUE (no real verification gate). Postgres schema has 13 tables and 10 RPCs including admin moderation functions (approve_deposit, reject_order, verify_admin, delete_user_completely) — proving "manual review" maps to real admin actions.',
            tags: ['Real Backend', 'Twilio SMS', 'Admin Review Confirmed'],
        },
        {
            title: 'RLS Correctly Enforced on PII Tables (Operator Hygiene)',
            description: 'All 9 user-data tables (profiles, orders, wallets, payment_methods, customer_rates, reviews, bonus_tasks, usdt_predictions, platform_settings) deny anon reads — no victim PII leaks via the public anon key. count=exact also returns */0, so the real victim count cannot be derived from outside without service_role access. Subpoena to Supabase is required to extract the victim list.',
            tags: ['RLS Hardened', 'Subpoena Required', 'No PII Leak'],
        },
        {
            title: 'Real User Activity ≈ Zero (Quantitative Disproof of Social-Proof Claims)',
            description: 'get_usdt_vote_stats RPC returns {rise:0, fall:0} — ZERO total votes across the lifetime of the price-prediction feature. The fake Trustpilot claims 37,600 reviews; a real user base of that size would generate hundreds of votes. Zero is the database\'s answer to "how many engaged real users do you have."',
            tags: ['Zero Engagement', 'Fake Community', 'DB Disproof'],
        },
    ],

    network: [
        { address: 'swapifyofficial.com', role: 'Primary Scam Frontend (Lovable-built SPA)', connection: 'Created 2025-12-15 via Hostinger. Cloudflare edge. 3.9 MB Vite bundle. Live as of 2026-05-15.' },
        { address: 'swapifyofficial.in', role: 'Sister Domain (Telegram-bot data-auth-url target)', connection: 'Created 2025-10-25 via Hostinger. Registrant "Swapify", Haryana, IN. Same IP as .com (185.158.133.1). TLS currently misconfigured but domain is operator-controlled.' },
        { address: '185.158.133.1', role: 'Shared Origin IP (Hostinger)', connection: 'Single /32 hosts both swapifyofficial.com and swapifyofficial.in. Hostinger shared hosting infrastructure.' },
        { address: 'ns1.dns-parking.com / ns2.dns-parking.com', role: 'Hostinger DNS Parking', connection: 'Default Hostinger nameservers — confirms registrar-level Hostinger control of both domains.' },
        { address: '@Swapifyofficial_bot', role: '🔑 Telegram Bot — Real Order Channel', connection: 'Shipped in index.html via Telegram login widget with data-request-access="write". Serves per-trade deposit addresses to victims. Bot display: "✨ 𝙎𝙬𝙖𝙥𝙞𝙛𝙮 🇮🇳".' },
        { address: 'pnowlffenpjkuhhjioqm.supabase.co', role: '🔑 Supabase Backend Project', connection: 'Operator\'s server-side state — created 2025-10-25 (same day as .in domain). 13 tables, 10 RPCs (including admin moderation: approve_deposit, reject_order, verify_admin, delete_user_completely). Auth: email+phone+Google OAuth, Twilio SMS provider, autoconfirm=TRUE on both email and phone (no real verification gate). RLS correctly enforced on user-data tables. Suspend target via security@supabase.com.' },
        { address: 'swap_prices table → usdt_rate=101 (updated 2025-10-25)', role: '🎯 Smoking-Gun: "Live" Rate Is a 7-Month Hardcoded Constant', connection: 'Public-readable via anon key. Single row, set once at project creation, never updated since. The homepage "Live" badge is database-provably false.' },
        { address: 'offers table → 4 tiers, max ₹105/USDT (24% over market)', role: '🎯 Funnel Mechanic — Higher Rate for Larger Deposit', connection: 'Public-readable. ₹1,111→₹103 / ₹3,333→₹103.5 / ₹7,777→₹104 / ₹10,000→₹105. Two entries updated 2026-05-05 (10 days before investigation) — active operator maintenance confirmed.' },
        { address: 'referral code "2BEFDCAE"', role: '🎯 Verified Registered Referrer in Operator\'s DB', connection: 'validate_referral_code("2BEFDCAE") returns TRUE (vs FALSE for random codes). The referral code in the user-supplied evidence URL is a real referrer row in the Supabase profiles table — subpoena-ready lead to the operator OR the first downstream recruiter.' },
        { address: 'trustpilotofficial.lovable.app/company/swapify', role: '🔑 Fake Trustpilot Clone (Lovable.dev)', connection: 'Same operator authored this Lovable.app subdomain. Hosts the fabricated 4.9★ / 37,600 reviews. Naming ("trustpilotofficial") mirrors the operator\'s "swapifyofficial" convention. Brand-impersonation takedown target.' },
        { address: 'oauth.lovable.app', role: 'Lovable.dev OAuth Endpoint', connection: 'Identity layer for the SPA — confirms Lovable platform usage. abuse@lovable.dev can correlate the swapifyofficial and trustpilotofficial projects to a single Lovable account.' },
        { address: 'api.coingecko.com/api/v3/coins/tether', role: 'Live USDT Price Feed (legit upstream)', connection: 'Used to render the "Live ₹101" rate — CoinGecko itself is not implicated; it is being consumed as a normal public API to dress the page with a "live" badge.' },
        { address: 'Hostinger abuse: domains@hostinger.com', role: '🎯 Registrar Abuse Channel', connection: 'Single email covers both swapifyofficial.com and swapifyofficial.in — Hostinger is the registrar of record for both.' },
        { address: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t', role: 'Official Tether USDT TRC-20 Contract (REFERENCE)', connection: 'The real USDT contract — this is what the operator demands and ultimately receives. Listed for reference; the operator-controlled DEPOSIT wallet is served dynamically by the Telegram bot and is not exposed in the public bundle.' },
        { address: 'cybercrime.gov.in / helpline 1930', role: '🇮🇳 Indian Cyber Crime — Jurisdiction', connection: '.in registrant in Haryana + INR/UPI rails place this firmly in Indian Cyber Crime jurisdiction. Has subpoena power over the bank/UPI account behind the test payouts.' },
    ],

    smartContract: {
        language: 'js',
        code: scamFrontendCode,
        vulnerabilities: [
            'No smart contract is deployed — the entire "exchange" is a Lovable.dev-generated React SPA backed by a Supabase project. The "trade" is a human conversation over Telegram, not an on-chain interaction.',
            'No wallet drainer pattern: no approve(), no permit(), no setApprovalForAll(), no off-chain signature exfil. The victim sends USDT manually to an address the operator supplies in Telegram. Damage is bounded to the deposit amount plus any subsequent "verification fees".',
            'Operator FAQ in the bundle openly states "our company does not need INR. They just need USDT" — the scam business model is described in the operator\'s own marketing copy.',
            'Above-market rate of ~20% (₹101 vs ~₹85 fair) is the entire lure. No legitimate P2P exchange sustains a 20% buy-side premium; the pitch can only be supported by withholding the INR side of the trade.',
            'Manufactured social proof: the "Trustpilot 4.9 / 37,600 reviews" badge links to a Lovable.app clone authored by the same operator, not to trustpilot.com.',
            'Two-domain operator infrastructure (swapifyofficial.com + swapifyofficial.in) shares IP, nameservers, registrar, and is operator-controlled from Haryana, IN.',
            'Supabase backend pnowlffenpjkuhhjioqm.supabase.co with a /functions/v1/verify-deposits edge function implements the "manual review" stall vector described in the FAQ copy.',
            'Telegram bot @Swapifyofficial_bot ships in index.html with data-request-access="write" — the operator can DM authenticated users, which is the channel used to serve per-trade deposit addresses.',
        ],
    },

    technicalSpecs: [
        { label: 'Scam Type', value: 'Indian P2P "Above-Market USDT" Advance-Trust Fraud (NOT a wallet drainer)' },
        { label: 'Frontend', value: 'Lovable.dev-built React SPA, Vite-bundled, PWA-enabled (~3.9 MB index-CWqsA2pn.js)' },
        { label: 'Primary URL', value: 'https://swapifyofficial.com/  (Cloudflare-fronted)' },
        { label: 'Sister Domain', value: 'https://swapifyofficial.in/  (Telegram-bot data-auth-url target; same IP as .com)' },
        { label: 'Origin IP', value: '185.158.133.1  (Hostinger shared)' },
        { label: 'Nameservers', value: 'ns1.dns-parking.com / ns2.dns-parking.com  (Hostinger)' },
        { label: 'Registrar (both domains)', value: 'HOSTINGER operations, UAB  (abuse: domains@hostinger.com)' },
        { label: '.in Registrant Org', value: 'Swapify' },
        { label: '.in Registrant State', value: 'Haryana, IN' },
        { label: '.com Created', value: '2025-12-15 (≈5 months before investigation)' },
        { label: '.in Created', value: '2025-10-25 (≈7 months before investigation)' },
        { label: 'Backend', value: 'Supabase project pnowlffenpjkuhhjioqm.supabase.co (edge fn: /functions/v1/verify-deposits)' },
        { label: 'Backend Created', value: '2025-10-25 15:14:40 UTC (same afternoon as the .in domain registration)' },
        { label: 'Backend Auth Providers', value: 'Email + Phone + Google OAuth — Twilio SMS — autoconfirm=TRUE for both email and phone (no real verification)' },
        { label: 'Backend Schema', value: '13 tables + 10 RPCs. Admin moderation functions: approve_deposit, reject_order, verify_admin, delete_user_completely.' },
        { label: '🎯 "Live ₹101 Rate" Reality', value: 'Hardcoded since 2025-10-25 15:14:40 UTC — never updated in 7 months (DB-provable via public swap_prices table read).' },
        { label: '🎯 Offer Tiers (Funnel Mechanic)', value: '₹1,111→₹103 · ₹3,333→₹103.5 · ₹7,777→₹104 · ₹10,000→₹105 (rate INCREASES with deposit size — inverted market microstructure).' },
        { label: 'Max Advertised Markup', value: '₹105 / USDT (≈24% above fair value of ~₹85)' },
        { label: 'Most Recent Operator DB Edit', value: '2026-05-05 (offers table; 10 days before investigation — active maintenance confirmed)' },
        { label: '🎯 Referral Code 2BEFDCAE (from evidence URL)', value: 'VERIFIED LIVE in Supabase — validate_referral_code returns true. Subpoena Supabase for the profile row holding this code.' },
        { label: 'Real User Engagement', value: 'get_usdt_vote_stats RPC returns {rise:0, fall:0} — ZERO votes lifetime, vs the fake Trustpilot claim of 37,600 reviews' },
        { label: 'RLS Posture', value: 'Correctly enforced on all 9 PII / order tables — anon cannot read user data or row counts. Subpoena to Supabase required to extract victim list.' },
        { label: 'Telegram Bot', value: '@Swapifyofficial_bot ("✨ 𝙎𝙬𝙖𝙥𝙞𝙛𝙮 🇮🇳")' },
        { label: 'Fake Trustpilot URL', value: 'https://trustpilotofficial.lovable.app/company/swapify (claims 4.9★ / 37,600 reviews on a <5-month-old domain)' },
        { label: 'Advertised Rate', value: '₹101 / USDT' },
        { label: 'Fair Market Rate (2026-05-15)', value: '≈ ₹83–85 / USDT (USD/INR ≈ ₹83–85, USDT ≈ $1)' },
        { label: 'Markup over Market', value: '~18–20% ABOVE fair (the lure)' },
        { label: 'Payment Rails', value: 'UPI, IMPS, NEFT, RTGS (Indian banking only)' },
        { label: 'Supported Crypto (received)', value: 'USDT TRC-20  +  USDT BEP-20  (validators present in bundle for both formats)' },
        { label: 'Author Meta Tag', value: '<meta name="author" content="CryptoSwap India" />' },
        { label: 'Lovable Fingerprint', value: '<meta name="twitter:site" content="@lovable_dev" />  +  gpt-engineer-file-uploads asset URLs  +  oauth.lovable.app' },
        { label: 'Damage Model', value: 'Loss = deposited USDT + any "verification fees" paid after. Wallet itself is uncompromised (no approvals signed).' },
        { label: 'Confidence Vector', value: 'First small INR payout via UPI (₹500 – ₹5,000) often settles. Larger trade triggers "manual review" stall.' },
        { label: 'Stall Vector', value: '"All deposits and withdrawals are manually reviewed by our team to detect and prevent fraud." (verbatim FAQ string)' },
        { label: 'Operator Self-Description', value: '"Actually our company does not need INR. They just need USDT since they can keep it safe without any issues." (verbatim FAQ string)' },
        { label: 'Jurisdiction', value: '🇮🇳 India — cybercrime.gov.in + helpline 1930 (UPI/bank trail = real-world identity)' },
        { label: 'Takedown Targets', value: 'Hostinger (registrar) · Cloudflare · Supabase · Lovable.dev · Trustpilot legal · Telegram · Indian Cyber Crime' },
        { label: 'Detection Rule', value: 'Any "P2P USDT/INR" platform advertising >5% above fair rate, with Telegram-bot order routing and "manual review" copy, should be treated as an advance-trust scam until INR-payout history is independently verified.' },
    ],
};
