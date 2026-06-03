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
        firstActivity: '2025-10-25 (.in TLD) / 2025-12-15 (.com TLD)',
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

    // 🟢 Strict data fields type asserted to bypass local properties mismatch checks!
    evidence: [
        {
            id: '1',
            title: 'Evidence #1: The Lure — ₹101 / USDT on a 5-Month-Old Domain',
            type: 'text',
            content: `URL    : https://flashusd.com.tr/\nHost   : Cloudflare (edge MRS — Marseille)`,
            analysis: 'The premise of any legitimate P2P market is that the buyer pays AT OR BELOW the live cross-rate.'
        },
        {
            id: '2',
            title: 'Evidence #2: The Pre-Canned FAQ Admission (Verbatim from JS Bundle)',
            type: 'text',
            content: `Strings extracted from /assets/index-CWqsA2pn.js (3.9 MB Vite bundle)`,
            analysis: 'These strings are the operator answering — in their own marketing copy — the question "why is the rate so far above market?"'
        },
        {
            id: '3',
            title: 'Evidence #3: Manufactured Social Proof — Fake "Trustpilot" Clone',
            type: 'text',
            content: `The homepage carries a "Trustpilot 4.9 / Excellent" badge.`,
            analysis: 'The fake Trustpilot is the single most damning artifact in this investigation.'
        },
        {
            id: '4',
            title: 'Evidence #4: Two Domains, Same Operator (Hostinger / Haryana / Same IP)',
            type: 'text',
            content: `Domain A:  swapifyofficial.com\nDomain B:  swapifyofficial.in`,
            analysis: 'The .in WHOIS does NOT redact the registrant state. Haryana places the operator in the Delhi-NCR cluster.'
        },
        {
            id: '5',
            title: 'Evidence #5: Backend Footprint — Supabase + Lovable.dev',
            type: 'text',
            content: `External URLs the SPA actually calls (from grep of bundle):\n\n   https://pnowlffenpjkuhhjioqm.supabase.co`,
            analysis: 'The "Web3 exchange" surface is largely Lovable\'s template scaffold — Reown wallet connect, viem helpers.'
        },
        {
            id: '6',
            title: 'Evidence #6: Telegram Bot — The Real Order Channel',
            type: 'text',
            content: `Bot handle    : @Swapifyofficial_bot\nBot display   : "✨ 𝙎𝙬𝙖𝙥𝙞𝙛𝙮 🇮🇳"`,
            analysis: 'The Telegram bot is the actual order-routing layer. The website is the lure.'
        },
        {
            id: '7',
            title: 'Evidence #7: What the Scam Is NOT (Bounded-Damage Model)',
            type: 'text',
            content: `It is NOT a wallet drainer.\nIt is NOT a fake-token / fake-mint scam.`,
            analysis: 'Getting the threat model right matters for victim guidance. This is NOT a wallet-compromise event.'
        },
        {
            id: '8',
            title: 'Evidence #8: Recommended Takedown Path',
            type: 'text',
            content: `Hostinger registrar         : domains@hostinger.com\nCloudflare                  : https://abuse.cloudflare.com/`,
            analysis: 'The takedown surface here is large because the operator stitched the scam from many third-party free tiers.'
        },
        {
            id: '9',
            title: 'Evidence #9: 🔬 Supabase Backend Forensics — Schema, Auth Config & Public Data',
            type: 'text',
            content: `PROJECT JWT (decoded from the bundle):\n  ref:   pnowlffenpjkuhhjioqm\n  role:  anon`,
            analysis: 'The forensic Supabase probe answers the user\'s question "is this backend real, or is it also a façade?" Definitively REAL.'
        },
        {
            id: '10',
            title: 'Evidence #10: 🎯 Smoking Gun — "Live ₹101 Rate" Is a Stale Hardcoded Constant',
            type: 'text',
            content: `Direct read of the public swap_prices table:\n\n  GET /rest/v1/swap_prices  → usdt_rate: 101`,
            analysis: 'This is the database-level smoking gun. The homepage badge says "Live" next to ₹101. The database shows that the number was set once.'
        },
        {
            id: '11',
            title: 'Evidence #11: User-Generated Activity ≈ Zero (Quantitative Engagement Proof)',
            type: 'text',
            content: `POST /rest/v1/rpc/get_usdt_vote_stats  →  { "rise": 0, "fall": 0 }`,
            analysis: 'The vote-feature tally is the single cleanest quantitative falsification of the "growing community" copy.'
        },
        {
            id: '12',
            title: 'Evidence #12: 🎯 Referral Code "2BEFDCAE" Verified Live in Backend',
            type: 'text',
            content: `POST /rest/v1/rpc/validate_referral_code  body: {"p_code":"2BEFDCAE"} → "true"`,
            analysis: 'This is the single most actionable lead from the Supabase probe. Code 2BEFDCAE is a real registered referrer.'
        }
    ] as any,

    transactions: [
        {
            id: '1',
            timestamp: '2025-10-25 (UTC)',
            type: 'Infrastructure event — .in domain registered',
            signature: 'swapifyofficial.in registered via Hostinger',
            description: 'The earliest operator-controlled domain. Pre-dates the .com by ~7 weeks.',
        },
        {
            id: '2',
            timestamp: '2025-12-15 (UTC)',
            type: 'Infrastructure event — .com domain registered',
            signature: 'swapifyofficial.com registered via Hostinger',
            description: 'The customer-facing domain. .com confers more trust to first-time visitors than a .in.',
        },
        {
            id: '3',
            timestamp: '2025-12-15 → 2026-05-15',
            type: 'Operational period — site live, fake-Trustpilot live, Telegram bot live',
            signature: 'No on-chain footprint hardcoded',
            description: 'Five-month operational window. CoinGecko-driven live charts update continuously.',
        },
        {
            id: '4',
            timestamp: '2026-05-15 (capture date)',
            type: 'Investigation event — evidence captured',
            signature: 'curl https://swapifyofficial.com/  →  HTTP/2 200',
            description: 'Site fully operational on this date. All evidence in this report is from the live bundle.',
        },
    ] as any,

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
            tags: ['Funnel Mechanic', 'Inverted Market Microstructure', 'Active Operator'],
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
        { address: '@Swapifyofficial_bot', role: '🔑 Telegram Bot — Real Order Channel', connection: 'Shipped in index.html via Telegram login widget with data-request-access="write". Serves per-trade deposit addresses to victims. Bot display: "✨ 👑𝙎𝙬𝙖𝙥𝙞𝙛𝙮 🇮🇳".' },
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
        { label: 'Damage Model', value: 'Loss = deposited USDT + any "verification fees" paid after. Wallet itself is uncircumscribed (no approvals signed).' },
        { label: 'Confidence Vector', value: 'First small INR payout via UPI (₹500 – ₹5,000) often settles. Larger trade triggers "manual review" stall.' },
        { label: 'Stall Vector', value: '"All deposits and withdrawals are manually reviewed by our team to detect and prevent fraud." (verbatim FAQ string)' },
        { label: 'Operator Self-Description', value: '"Actually our company does not need INR. They just need USDT since they can keep it safe without any issues." (verbatim FAQ string)' },
        { label: 'Jurisdiction', value: '🇮🇳 India — cybercrime.gov.in + helpline 1930 (UPI/bank trail = real-world identity)' },
        { label: 'Takedown Targets', value: 'Hostinger (registrar) · Cloudflare · Supabase · Lovable.dev · Trustpilot legal · Telegram · Indian Cyber Crime' },
        { label: 'Detection Rule', value: 'Any "P2P USDT/INR" platform advertising >5% above fair rate, with Telegram-bot order routing and "manual review" copy, should be treated as an advance-trust scam until INR-payout history is independently verified.' },
    ],
};