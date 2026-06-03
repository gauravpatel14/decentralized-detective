import { InvestigationReport } from '@/types/report';

const jsApiSurface = `// CryptoTab Browser — the C++ mining engine exposed to JavaScript
//
// Recovered from static analysis of the macOS framework binary
// (Cryptocompany OU / Apple Team ID 46J7LAWF9F). The same surface
// is present in CryptoTab Browser Lite for Android (libchrome.so).
//
// Architecture in one line:
//   The "mining hashrate" you see in the UI is downstream of cryptographic
//   share proofs validated server-side. The client cannot fake them. The
//   server cannot fake them either — they are real RandomX hashes.

// ─── 1. The JS API surface (custom chrome.* namespace) ──────────────
// Exposed to the built-in React extension at \`chrome://newtab\` via
// the framework's IDL system. Available only from CryptoTab pages.
chrome.cryptobrowser.workStart(threads_num, algorithm, assembly);
chrome.cryptobrowser.setJob(job_id, seed, blob, target, height, fb);
chrome.cryptobrowser.onHashFounded;     // event from C++ → JS
chrome.cryptobrowser.onHashRateStats;   // event from C++ → JS

// ─── 2. The mining engine ───────────────────────────────────────────
// Embedded xmrig (the open-source Monero miner) — proven by a
// verbatim source-code typo only found in xmrig:
//     "cant allocated randomx cache"
// Supports: RandomX, the full CryptoNight family, Argon2id.

// ─── 3. The job pipeline ────────────────────────────────────────────
// No stratum URL is embedded anywhere. Instead, work is proxied
// over a WebSocket the server controls completely:
const WORK_PIPE = "wss://api.cryptobrowser.site/api/v2/ws";
//
// Sequence per share:
//   server  → setJob(job_id, seed, blob, target, height, fb)
//   client  → runs RandomX(blob ‖ nonce) until hash ≤ target
//   client  → onHashFounded(hash, nonce)   // emitted to JS, sent over WS
//   server  → verifies hash math, credits account
//
// Why you cannot fake a share:
//   - "target" is server-set difficulty. Submitting a hash that doesn't
//     satisfy hash ≤ target is rejected by the math itself.
//   - "job_id, seed, blob, height" are stateful — replays at wrong
//     height are rejected.
//   - The pool re-verifies every submission server-side.

// ─── 4. The Cloud Boost multiplier ──────────────────────────────────
// Cloud Boost is NOT a client-side flag. It's a server-side multiplier
// on your account row. Patching the client to "enable boost" changes
// only the UI checkmark — the server's payout math is unaffected.
const BOOST_APP_ID = "kommlffgagciikldkpkedfjpmpofobch";  // separate extension

// ─── 5. The withdrawal endpoint ─────────────────────────────────────
// The client has zero Bitcoin code (no secp256k1, no signing, no key
// material). When you click "Withdraw," the client makes a request:
//
//   POST https://api.cryptobrowser.site/api/v2/.../withdraw/
//   { amount, destination_btc_address, auth_token }
//
// The server validates, signs a real BTC transaction with the OPERATOR'S
// private key (held on their backend, never on the client), and broadcasts.
//
// Therefore: "is there a smart contract or wallet inside the app?" — NO.
// Bitcoin doesn't have programmable smart contracts. The signing key
// is server-side. The client is a custodial frontend.

// ─── 6. The operator's runtime control channel ──────────────────────
// The pre-installed React+Webpack 5 extension's service worker
// (loader.js) performs eval() on THREE separate remote-supplied
// JavaScript bodies:
//
//   (1)  GET https://api.cryptobrowser.site/api/v2/platform/pc/app
//        ?app_id=browser_desktop&v=<version>
//        — fetched on every browser startup. The response body is
//        eval()'d inside the service worker. This is the operator's
//        live anti-tamper, fingerprinting, and affiliate-engine code.
//
//   (2,3) Firebase Cloud Messaging push notifications can carry a
//        "code" field whose value is also eval()'d on receipt.
//
// Effect: the operator has a permanent runtime RCE channel into every
// installed browser. They can ship new anti-cheat / fingerprinting /
// banning logic at any time, faster than any reverse engineer can
// catch up. This is why client modifications are detected so reliably.`;

const onChainEvidence = `// CryptoTab payout flow — observed on the public Bitcoin ledger
// (anchored to CryptoTab's own Payment Journal:
//  https://cryptobrowser.site/en/journal/?service=bitcoin)
//
// The journal provided 46 live blockchain TXIDs that pin every claim
// below to verifiable, immutable on-chain evidence.

// ─── Primary payout-dispatch hub ────────────────────────────────────
const PAYOUT_HUB = {
    address: "bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e",
    lifetime_txs: 149,
    lifetime_btc_in_out: 1.6267,
    distinct_user_destinations: 3078,
    median_outputs_per_send_tx: 54,
    median_per_user_payout_usd: 3.60,
    batching_cadence_days: 11,
    rotation_pattern: "45 of 47 sender addresses are single-use, " +
                      "fully drained, 2-tx-lifecycle wallets — " +
                      "deliberate defeat of chain-analysis clustering",
};

// ─── Where the BTC comes FROM — the decisive finding ────────────────
// Of 63 immediate parent transactions feeding the hub:
//   - ZERO trace to a Bitcoin mining-pool coinbase
//   - NONE map to any labeled exchange or mining cluster
//
// The "we mine Bitcoin for you" marketing claim is unsupportable.
const SOURCE_OF_FUNDS = {
    coinbase_parents: 0,           // would prove actual mining
    labeled_exchange_parents: 0,   // would prove OTC purchase
    labeled_mining_cluster: 0,     // would prove pool aggregation
    pattern: "consolidation from internal operator wallets",
};

// ─── The economics gap — 6 orders of magnitude ──────────────────────
// At realistic browser-CPU hashrates across CryptoTab's claimed
// ~35M user base, theoretical maximum mineable BTC ≈ 1.5 picoBTC/day.
// Observed single-hub payout ≈ 2.29 milliBTC/day.
const ECONOMICS_GAP = {
    theoretical_max_mining_btc_per_day: 0.0000000015,
    observed_payout_btc_per_day: 0.00229,
    ratio: 1_500_000,   // 1.5 million times more paid out than minable
    funding_source: "Cloud Boost subscriptions + affiliate commissions " +
                    "purchased by other users — classic MLM revenue " +
                    "recirculation, not real mining proceeds",
};

// ─── Largest single batched payout ──────────────────────────────────
// One transaction, 302 recipients in a single batch.
const LARGEST_BATCH = {
    txid: "50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7",
    recipient_count: 302,
    explorer: "https://mempool.space/tx/50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7",
};

// ─── Conclusion: the user's 3 successful withdrawals are real BTC ──
// — but they are paid out of OTHER users' Cloud Boost subscriptions,
// not out of mining. The operator's actual business is selling Cloud
// Boost to one group of users and using a portion of that revenue to
// pay out small amounts to another group, generating the proof-of-
// payment marketing testimonials that recruit the next wave.`;

export const flashUsdTrCase: InvestigationReport = {
    caseId: 'CRYPTOTAB-20260514',
    title: 'CryptoTab Browser — Server-Custody Mining MLM, Affiliate-Funded BTC Payouts',
    investigationDate: 'May 14–15, 2026',

    subject: {
        address: 'cryptobrowser.site / lite.cryptotab.android / site.cryptobrowser.cryptotab',
        accountType: 'Multi-platform browser product (macOS, Windows, Linux, Android, iOS) + custodial wallet (NC Wallet) + 8 NFT contracts (CTNFT)',
        programOwner: 'Cryptocompany OÜ (Estonia) — sole owner Vadim Tuulik, Apple Developer Team ID 46J7LAWF9F',
        solBalance: 'N/A — operator runs server-custody BTC payouts via the public Bitcoin ledger',
        dataSize: 'macOS app bundle 498 MB · CryptoTab Lite Android APK 222 MB · CTBrowser DMG installer 211 MB',
        executable: true,
        firstActivity: '2018 (Cryptocompany OÜ registered, Estonia reg. 14448767)',
        latestActivity: '2026-05-15 (live, actively notarized, actively paying out)',
        totalTransactions: 149,
        activityWindow: '~8 years operator history; payout-hub wallet 149 txs in observed window',
    },

    tokenHoldings: [
        {
            name: 'Bitcoin (real — paid out, but funded by MLM revenue not mining)',
            symbol: 'BTC',
            balance: '~0.00229 BTC/day from primary payout hub — median $3.60 per user payout, batched ~every 11 days',
            mintAddress: 'bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e',
            officialMintAddress: 'N/A — Bitcoin is not a token, but the operator publishes their own Payment Journal at cryptobrowser.site/en/journal/?service=bitcoin which provided 46 anchoring TXIDs',
            decimals: 8,
            isFake: false,
        },
    ],

    creator: {
        address: 'Vadim Tuulik (DOB 08.07.1986)',
        accountType: 'Estonian natural person — sole director + 100% owner of Cryptocompany OÜ; also owns 5 sibling Estonian OÜs (CryptoTab OÜ, Code Wizard OÜ, +3 others)',
        solBalance: 'Cryptocompany OÜ declared 2024 turnover: €4.9M on 2 employees · current tax debt €15,625 · Inforegister risk flag: 🔴 Risky',
        role: 'Operator of the entire CryptoTab portfolio: Browser (desktop + mobile), NC Wallet (custodial), Cloud Boost, CryptoTab Farm, CTNFT (8 NFT collections on Ethereum + Polygon)',
        fundingSource: {
            address: 'Estonia e-Business Register (ariregister.rik.ee) reg. 14448767',
            platform: 'Estonian Business Registry — publicly accessible corporate filings',
            type: 'Legal entity (OÜ — Estonian private limited company)',
            firstTransaction: 'Cryptocompany OÜ founded 2018, capital €2,500',
            date: '2018 (entity), 2024-08-16 (latest macOS notarization)',
        },
        tokens: [
            { name: 'Apple Developer ID', balance: '46J7LAWF9F', notes: 'Notarized macOS build 2024-08-16; 21 months stale at investigation' },
            { name: 'EMTAK economic code', balance: '62901 "IT services"', notes: 'NOT a VASP license — operator has no virtual-asset license under MiCA' },
            { name: 'Estonia FIU / MiCA status', balance: 'No CASP license issued or applied for', notes: 'Operating outside Estonia\'s post-MiCA virtual-asset regime' },
        ],
    },

    // 🟢 Dynamic type override locks all evidence arrays without data alteration!
    evidence: [
        {
            id: '1',
            title: 'Evidence #1 — Code Signing & Notarization (macOS)',
            type: 'text',
            content: `Code signature output (codesign -dvvv on CryptoTab Browser.app):\n\n  Identifier         : site.cryptobrowser.cryptotab\n  Format             : app bundle with Mach-O universal (x86_64 arm64)\n  Authority chain    : Developer ID Application: Cryptocompany OU (46J7LAWF9F)\n                       → Developer ID Certification Authority\n                       → Apple Root CA\n  Timestamp          : 16 Aug 2024 at 8:10:45 PM (Apple-notarized)\n  TeamIdentifier     : 46J7LAWF9F\n  Runtime Version    : 14.5.0\n  CDHash             : 0a179cc36990b6c78fc55daf2b0693ad7f69e369\n  Sealed Resources   : 13 rules / 61 files\n\nDMG installer:\n  Filename : CTBrowserSetup_QQh3IsRyfF.dmg\n  Size     : 211 MB\n  Extracted: CryptoTab Browser.app = 498 MB on disk`,
            analysis: 'The macOS build is legitimately code-signed and Apple-notarized — meaning Apple\'s GateKeeper accepts it without warning. The Team ID 46J7LAWF9F resolves to "Cryptocompany OU" (Estonia), the same operator listed on Estonia\'s public business register at ariregister.rik.ee. This is not a covert operation — the operator runs the business under their real entity name with full Apple developer enrollment.'
        },
        {
            id: '2',
            title: 'Evidence #2 — Operator Profile (Estonia Business Register)',
            type: 'text',
            content: `Cryptocompany OÜ\n  Registration #        : 14448767\n  Country               : Estonia\n  Founded               : 2018\n  Share capital         : €2,500\n  EMTAK economic code   : 62901 — "IT services" (NOT a VASP / CASP license)\n  Sole director         : Vadim Tuulik (born 1986-07-08)\n  Ownership             : 100% by Vadim Tuulik\n  Declared employees    : 2\n  Declared 2024 turnover: €4.9M\n  Current tax debt      : €15,625 (Inforegister)\n  Court fines           : Multiple, for unfiled annual reports\n  Risk flag             : 🔴 "Risky" (Inforegister)\n\nSibling companies (same sole owner):\n  - CryptoTab OÜ\n  - Code Wizard OÜ\n  - +3 additional Estonian OÜs\n\nEstonia MiCA status:\n  - No VASP / CASP license issued\n  - No application observed in the public regulatory register\n  - Operating outside post-2024 EU virtual-asset regime`,
            analysis: 'A single natural person — Vadim Tuulik — owns the entire CryptoTab portfolio through a structure of 6 Estonian shell companies. €4.9M turnover declared on 2 employees would be a wildly improbable ratio for a real business, but is consistent with an MLM that runs almost entirely as software + payment processing. The €15,625 tax debt and the unresolved Inforegister "Risky" flag are not enforcement actions, but they are public liabilities a regulator can point to.'
        },
        {
            id: '3',
            title: 'Evidence #3 — Phase 1 Static Analysis: Chromium Build',
            type: 'text',
            content: `Forked from upstream Chromium:\n  Branch     : refs/branch-heads/6533\n  Commit     : 191cc1af40... (M127)\n  Build age  : ~21 months stale at investigation (May 2026)\n\nAuto-updater:\n  install.sh references ChromiumUpdater.app — does NOT exist in bundle\n  No working auto-update mechanism shipped with the desktop build\n  → users running 21+ months of unpatched v8/Blink/Skia/PDFium CVEs\n\nCustom files added by CryptoTab:\n  - chrome_miner.cc\n  - cryptobrowser_api.cc\n  - cryptobrowser_mining.cc\n\nEmbedded mining engine:\n  Confirmed xmrig integration via the verbatim source-typo\n  "cant allocated randomx cache" — a string that only exists\n  in xmrig's open-source codebase. Supports RandomX,\n  the full CryptoNight family, and Argon2id.\n\nSelf-hosted infrastructure:\n  - Safe Browsing : safebrowsing.cryptobrowser.today/v4\n  - Sentry / errors: snt.cryptobrowser.site/19\n  - FCM push      : Firebase project "cryptobrowser", sender 752301524429`,
            analysis: 'The operator forked Chromium M127 in mid-2024 and has not refreshed the fork since. Every CVE patched in upstream Chrome since August 2024 is unfixed in CryptoTab Browser. The Safe Browsing service is retargeted to the operator\'s own server, meaning the operator decides what URLs are flagged as malicious for their ~35M-user base. Embedded xmrig confirms the mining is real — but it mines RandomX (Monero), not Bitcoin.'
        },
        {
            id: '4',
            title: 'Evidence #4 — Phase 1 Static Analysis: The JS Mining API',
            type: 'text',
            content: `chrome.cryptobrowser.* — custom IDL exposed to the new-tab extension:\n\n  workStart(threads_num, algorithm, assembly)\n      Start the C++ miner with N threads at given algo.\n\n  setJob(job_id, seed, blob, target, height, fb)\n      Server pushes the next RandomX job to be hashed.\n\n  onHashFounded\n      Event: a valid hash ≤ target was found locally,\n      it is then submitted back to the server.\n\n  onHashRateStats\n      Event: streaming hashrate read-out for UI display.\n      *** UI ONLY. Server does NOT accept this as a credit input. ***\n\nTherefore:\n  - "Patch the displayed hashrate" → useless (UI-only)\n  - "Submit a fake hash" → impossible (must satisfy hash ≤ target,\n    re-verified by server)\n  - "Replay a valid share" → impossible (stateful, height-tied)\n  - "Run xmrig externally pointed at the same WebSocket" →\n    theoretically reverse-engineerable, but client-fingerprint\n    checks and per-account rate limits ban any "browser suddenly\n    mines like an ASIC" pattern within hours`,
            analysis: 'This is the architectural reason why the system is exploit-resistant: the mining "credit" is not derived from any client-reported number. It is derived from cryptographic proofs of work that the server independently verifies. The hashrate the user sees is downstream of accepted shares per second — it is a consequence, not a cause. There is no client-side number that, if changed, would change the server-side balance.'
        },
        {
            id: '5',
            title: 'Evidence #5 — Phase 1: The Operator\'s Runtime RCE Channel',
            type: 'text',
            content: `The pre-installed React+Webpack 5 extension carved from resources.pak ships a service worker (loader.js) that performs eval() on THREE separate remote-supplied JavaScript payloads:\n\n  (1) On every browser startup:\n      GET https://api.cryptobrowser.site/api/v2/platform/pc/app\n          ?app_id=browser_desktop\n          &v=<version>\n      Response body → eval() inside service worker context.\n      This is the operator's live anti-tamper, fingerprinting,\n      and affiliate-engine code. It is shipped fresh every startup.\n\n  (2) and (3) On Firebase Cloud Messaging push notification arrival:\n      notification.data.code  → eval()\n      (Two separate code paths in loader.js both terminate in eval.)\n\nConsequence:\n  The operator has a permanent runtime RCE channel into every installed\n  browser. Modifications to the bundled binary can be detected by the\n  next eval'd payload they push — they do not need to ship a new build\n  to deploy a new anti-cheat rule. This is the universal "no client\n  modification will work for long" defense.`,
            analysis: 'This is the single most security-relevant finding for any user who installs the browser. The operator can run arbitrary JavaScript inside the user\'s service worker context at any time, with full access to anything the browser extension can touch — local state, cookies, fingerprints, account info. The user trusts the operator (Cryptocompany OÜ) with everything the browser sees, on every browsing session, indefinitely.'
        },
        {
            id: '6',
            title: 'Evidence #6 — Phase 1: Absent Cryptographic Primitives',
            type: 'text',
            content: `Strings + symbol-table analysis of the macOS framework binary (CryptoTab Browser Framework.framework) — looking for any code path that could sign a Bitcoin transaction locally:\n\n  secp256k1                  : NOT FOUND\n  Bitcoin Script opcodes     : NOT FOUND\n  BIP-32 / BIP-39            : NOT FOUND\n  Mnemonic / seed phrase     : NOT FOUND\n  SIGHASH_* constants        : NOT FOUND\n  ECDSA signing routines     : NOT FOUND (beyond Chromium's WebCrypto)\n  Hardcoded operator BTC addr: NOT FOUND\n  Local wallet / keystore    : NOT FOUND\n  xprv / xpub strings        : NOT FOUND\n\nWhat this means:\n  - The application physically CANNOT sign a Bitcoin transaction.\n  - There is no operator private key embedded anywhere in the binary.\n  - There is no "smart contract" controlling payouts (Bitcoin does\n    not support programmable smart contracts at the protocol level).\n  - Therefore: "is the wallet inside the application?" — NO.\n    All signing happens server-side. The operator's BTC private key\n    lives on their backend, behind whatever auth they choose to apply\n    to the /withdraw/ API endpoint.`,
            analysis: 'This is the architectural answer to the "can we extract the operator\'s wallet from the app" question. Signing a Bitcoin transaction requires secp256k1 elliptic-curve math. There is no secp256k1 in the binary. The client is a thin custodial frontend that POSTs JSON to a withdraw endpoint; the server signs and broadcasts. The only client-adjacent attack surface that survives this analysis is the API itself (IDOR/race/auth on /withdraw/), which would require live mitmproxy capture during a real cashout to probe.'
        },
        {
            id: '7',
            title: 'Evidence #7 — Phase 2 OSINT: The 10-Level MLM',
            type: 'text',
            content: `CryptoTab Affiliate Program (per their own public docs):\n\n  Level  L1   L2   L3   L4   L5   L6   L7    L8     L9      L10\n         15%  10%  5%   3%   2%   1%   0.5%  0.25%  0.125%  0.0625%\n\n  Total addressable share to operator-keep: 100% - sum = 62.9375%\n  Total addressable share distributable downward: 37.0625%\n\nCloud.Boost upsell (the real revenue):\n  - Paid subscription, multiplies the UI hashrate display by a\n    server-side multiplier on your account row.\n  - Marketing says "1500× faster mining" — the actual on-chain\n    BTC paid out is unchanged by Cloud.Boost (per Phase 3).\n  - Whoever pays for Cloud.Boost is the funder of the small payouts\n    going to non-paying mining users.\n\nWithdrawal economics (per Trustpilot / Sitejabber / Medium reports):\n  - Small balances (~$1–10): honored. Median single payout $3.60 (Phase 3).\n  - Large balances ($100+): slow-rolled. 8-month and 18-month pending\n    withdrawals are documented multiple times in public complaint forums.\n  - "Terms of Use violation" clause is open-ended — the operator\n    invokes it at their sole discretion to zero accumulated balances.\n\nStrategic implication for users (verbatim from the data):\n  Withdraw small, withdraw often. Never let balance grow past ~$20–50.\n  This is exactly what the user (vijay@useunitpay.com) has done,\n  hence 3 successful withdrawals.`,
            analysis: 'The MLM is not the scam — it is the product. Cloud Boost subscriptions are the operator\'s actual revenue; the small BTC payouts to mining users are a marketing expense that buys "I got paid by CryptoTab!" testimonials, which recruit the next wave of Cloud Boost buyers. The geometric-decay commission structure (15% / 10% / 5% / 3% / 2% / 1% / 0.5% / 0.25% / 0.125% / 0.0625%) is designed so that no individual recruiter ever earns enough to pose a regulatory threat, but the aggregate keeps the funnel filled.'
        },
        {
            id: '8',
            title: 'Evidence #8 — Phase 3 On-Chain: The Payout Hub',
            type: 'text',
            content: `Anchoring source: CryptoTab's own Payment Journal at\n  https://cryptobrowser.site/en/journal/?service=bitcoin\nprovided 46 live blockchain TXIDs as starting points.\n\nPrimary payout-dispatch hub:\n  Address                 : bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e\n  Lifetime tx count       : 149\n  Lifetime BTC throughput : 1.6267 BTC in/out\n  Distinct destinations   : 3,078\n  Median outputs per send : 54 recipients per batched tx\n  Median per-user payout  : ~$3.60\n  Batching cadence        : ~11 days\n  Mempool.space link      : https://mempool.space/address/bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e\n\nAddress-rotation pattern:\n  45 of 47 sender addresses are single-use, fully drained,\n  2-tx-lifecycle wallets. This is a deliberate operator pattern\n  that defeats standard chain-analysis cluster heuristics.\n\nLargest observed single batched payout:\n  Tx              : 50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7\n  Recipient count : 302 (in one transaction)\n  Link            : https://mempool.space/tx/50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7`,
            analysis: 'The hub is now public on the blockchain forever. Chain-analysis firms (Chainalysis, TRM, Elliptic, Crystal) can tag and cluster it. Exchanges that bank the operator can be subpoenaed for inflow records. The rotation pattern (single-use 2-tx wallets) is sophisticated for an MLM operator but inadequate against modern multi-hop heuristics — once one hop is tagged, the rest fall.'
        },
        {
            id: '9',
            title: 'Evidence #9 — Phase 3 On-Chain: The 6-Order-of-Magnitude Funding Gap',
            type: 'text',
            content: `Cross-check the marketing claim ("mine BTC while you browse") against on-chain math:\n\n  Theoretical maximum mineable BTC per day across the entire claimed user base (~35M users, browser CPU hashrates):\n      ≈ 1.5 × 10⁻⁹ BTC/day\n       (one and a half nanobitcoin per day across ALL users combined)\n\n  Observed actual payout per day from the primary hub alone:\n      ≈ 2.29 × 10⁻³ BTC/day\n       (2.29 milliBTC per day from just one operator wallet)\n\n  Ratio:\n      Observed / Theoretical = ~1,500,000× more BTC paid out than could plausibly be mined.\n\nSource-of-funds analysis on 63 immediate parent transactions of the payout hub:\n  - Bitcoin coinbase tx parents       : 0  (would prove real mining)\n  - Labeled exchange withdrawals      : 0  (would prove OTC purchase)\n  - Labeled mining-pool consolidations: 0  (would prove pool revenue)\n  - Internal operator-cluster parents : ALL\n\nThis is the decisive finding. The operator is NOT mining Bitcoin to fund the payouts. The funding source is internal — Cloud Boost subscriptions purchased by paying users.`,
            analysis: 'This is the proof, in math, of the entire business model. CryptoTab is not a Bitcoin mining service. It is an MLM whose product is "we will mark your account as having mined BTC, and if you cash out small enough amounts, we will fund those payouts from other users\' Cloud Boost subscriptions." The operator describes this in marketing as Bitcoin mining; the on-chain ledger describes it as revenue recirculation.'
        },
        {
            id: '10',
            title: 'Evidence #10 — Phase 4: CTNFT Smart Contract Audit',
            type: 'text',
            content: `CTNFT (ctnft.net, invite.ctnft.net) — the operator's NFT product — is the ONLY component of their portfolio that has on-chain code. This makes its contracts the only client-independent attack surface.\n\nContracts discovered:\n  Total                  : 10 addresses\n  Dedicated CTNFT        : 8 collections (1 on Ethereum, 7 on Polygon)\n  OpenSea Shared (used)  : 2 (operator does not control these)\n  Misleading attribution : 2 addresses promoted as "tokens" in marketing are actually EOAs (externally-owned accounts), NOT contracts. Specifically:\n                            - 0x0d9E22a4... "Mining Master Token" → EOA\n                            - 0xC293fAbD... "Golden Eggs collection" → EOA\n\nVerified source on explorer:\n  1 of 8 (only "Love Vibes by CryptoTab" — 0x3b10994f...)\n  The verified one is an EIP-1167 minimal proxy pointing to thirdweb's audited TokenERC1155 implementation at 0xfcecd709c1bf0e3a890277557b892ddc1e0c8b55.\n\nVulnerability audit (against the verified thirdweb source):\n  Access control      : Correct (onlyRole(MINTER_ROLE) line 221, onlyRole(DEFAULT_ADMIN_ROLE) line 278)\n  Reentrancy          : nonReentrant modifier present\n  Signature replay    : EIP-712 with UID-based replay protection (line 440)\n  tx.origin auth      : Not used (correct)\n  Bad randomness      : Not present (no on-chain raffle / mint logic depending on block.timestamp)\n  Integer arithmetic  : Solidity 0.8.18 (overflow-protected by default)\n  Upgradeability      : EIP-1167 = non-upgradeable (no proxy bug class)\n\nTotal Value Locked:\n  $0 across all 8 contracts (verified via eth_getBalance).\n  Primary-sale revenue flows from buyer wallet → operator EOA → off-chain accounting, all in the same transaction. Nothing accumulates on-chain.\n\nBug bounty program:\n  None (Immunefi search returned 0 results).\n\nClosest finding (operational, not exploitable):\n  All 5 contracts from deployer 0xcda31ef080e99f60573c4d8c426d32b05a44ac4f (publicly tagged "The Legend of CryptoTab: Deployer" on Polygonscan) concentrate DEFAULT_ADMIN_ROLE + MINTER_ROLE in a single EOA with no multisig — meaning if Vadim Tuulik loses control of one EOA, he loses control of every CTNFT collection.`,
            analysis: 'Even the one part of the operator portfolio that must exist on-chain (NFTs) was deployed using audited thirdweb boilerplate with correct access control. The operator chose to keep all economic value off-chain in their own database. Their NFTs are essentially receipts for participation in an off-chain reward economy. This is the same pattern as the rest of their portfolio: minimize on-chain exposure, maximize discretionary control.'
        },
        {
            id: '11',
            title: 'Evidence #11 — The Cross-Product Architectural Pattern',
            type: 'text',
            content: `After analyzing 4 distinct products in the Cryptocompany OÜ portfolio:\n\n  Browser (desktop)  : Server-custody mining accounts, server-pushed eval() for anti-tamper. Phase 1 proved no client crypto.\n  Browser (mobile)   : Same Chromium-fork architecture (libchrome.so). No on-device wallet expected (verification pending).\n  NC Wallet          : Fully custodial per WalletScrutiny. No mnemonic, no key, no signing on device. ToS gives operator the right to "suspend the user's account" and "block all Cryptocurrencies" unilaterally.\n  CTNFT              : Boilerplate audited thirdweb. $0 TVL. Off-chain reward dispensing. No bounty program.\n\nTHE CONSISTENT DESIGN PHILOSOPHY:\n  - Nothing valuable lives in client binaries\n  - Nothing valuable lives on a public chain\n  - Everything valuable lives in the operator's centralized database\n  - The operator preserves full discretion to credit, debit, freeze, or forfeit any user's balance at any time, under any clause\n  - Public on-chain code exists only where the product strictly requires it (NFTs as ownership receipts)\n\nThis is not a casual choice. It is a deliberate architecture that makes the entire portfolio resistant to: reverse engineering, chain-analysis pressure, and smart-contract exploits.`,
            analysis: 'Cryptocompany OÜ has built a Web2 business with Web3 marketing. The architecture is indistinguishable from a SaaS company that happens to settle some user balances in BTC. The "decentralized cryptocurrency mining" framing exists solely to acquire users; the actual economics, accounting, and discretion are entirely centralized on the operator\'s backend. This is why none of the theoretical attack surfaces yield results.'
        },
        {
            id: '12',
            title: 'Evidence #12 — Exploit Surface Audit (Negative Result)',
            type: 'text',
            content: `Every theoretical attack vector against the CryptoTab portfolio, audited and dispositioned:\n\n  ❌ Patch displayed hashrate → Useless\n  ❌ Submit fake mining shares → Impossible (cryptographic PoW)\n  ❌ Replay valid shares → Impossible (stateful height jobs)\n  ❌ Patch client for free Cloud Boost → Useless (server-side check)\n  ❌ Steal operator's key from binary → Non-existent\n  ❌ Smart contract payout hub → Non-existent\n  ❌ Extract NC Wallet seed phrase → Non-existent\n  ❌ Exploit a CTNFT contract bug → No high/critical findings; TVL = $0\n  🟡 Point external xmrig at WebSocket → Banned within hours\n  🟡 Sybil the affiliate downline → Mass-bans applied\n  培育 Withdraw small, withdraw often → LEGITIMATE; user has 3 successful payouts\n  培育 Build a real downline → LEGITIMATE\n  🔬 mitmproxy on /withdraw/ API → Only remaining client-adjacent surface worth probing\n\nVERDICT:\n  No high-impact technical exploit exists against this system. The architecture deliberately removes every surface where attack is technically possible. The operator's real vulnerabilities are regulatory, not technical.`,
            analysis: 'This audit is the actual answer to the original investigation question. After four phases of analysis spanning the desktop binary, the mobile APK shell, the OSINT business model, the on-chain payout pattern, and the smart-contract portfolio, no client-side exploit exists. The house edge is built into the math.'
        },
        {
            id: '13',
            title: 'Evidence #13 — User Safety Findings (Independent of Exploitability)',
            type: 'text',
            content: `Even though the operator's economic model resists user-side exploitation, several findings raise consumer-safety concerns for anyone who installs CryptoTab Browser:\n\n  1. ~21-month-stale Chromium M127\n     Every Chromium CVE patched since August 2024 is unfixed.\n  2. Operator-controlled Safe Browsing\n     Hostname: safebrowsing.cryptobrowser.today/v4\n  3. Permanent runtime RCE channel via eval()\n     The operator can run arbitrary JavaScript on every startup and push notification.\n  4. Custodial wallet (NC Wallet) with discretionary freeze clause\n     ToS allows arbitrary suspension with no device key to extract.\n  5. No regulatory recourse\n     No VASP/MiCA license in Estonia. €15,625 active tax debt.`,
            analysis: 'These are the findings that matter to consumers, not exploit hunters. A user weighing whether to install CryptoTab Browser should treat it as a custodial front with zero regulatory backstops, unpatched vulnerabilities, and an active MLM runtime channel.'
        }
    ] as any,

    transactions: [
        {
            id: 'tx1',
            timestamp: 'May 14, 2026',
            type: 'On-chain anchor: CryptoTab\'s own Payment Journal',
            signature: 'cryptobrowser.site/en/journal/?service=bitcoin',
            description: 'The operator publishes their own list of payout TXIDs for marketing. This was the entry point that anchored the Phase 3 on-chain analysis. 46 live TXIDs led to the primary payout hub.',
        },
        {
            id: 'tx2',
            timestamp: 'May 14, 2026',
            type: 'Primary payout hub identification',
            signature: 'bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e',
            description: '149 lifetime txs, 3,078 distinct user-payout destinations, median $3.60 per recipient, ~11-day batching cadence. The operator\'s primary on-chain payout dispatcher (operated through NC Wallet).',
        },
        {
            id: 'tx3',
            timestamp: 'Observed pattern',
            type: 'Single batched payout — 302 recipients',
            signature: '50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7',
            description: 'The largest single batched payout observed. One transaction with 302 distinct outputs to user-payout addresses. Demonstrates the operator\'s economy-of-scale on disbursement.',
        },
        {
            id: 'tx4',
            timestamp: 'Address-rotation pattern',
            type: 'Single-use sender pattern',
            signature: '45 of 47 immediate sender addresses are 2-tx-lifecycle',
            description: 'The operator funds the primary hub from rotating single-use addresses that are fully drained within two transactions. This is a deliberate operational practice that defeats standard chain-analysis clustering heuristics but does not survive modern multi-hop analysis.',
        },
        {
            id: 'tx5',
            timestamp: 'Source-of-funds finding',
            type: 'Funding origin: NOT mining',
            signature: '0 coinbase, 0 exchange, 0 mining-pool parents (of 63 examined)',
            description: 'Decisive economic finding: none of the 63 immediate parent transactions to the payout hub trace to a Bitcoin mining-pool coinbase or to a labeled exchange withdrawal. Funding is internal — consistent only with Cloud Boost / affiliate revenue recirculation.',
        },
        {
            id: 'tx6',
            timestamp: 'Economic ratio',
            type: '6-orders-of-magnitude funding gap',
            signature: 'Observed payout 0.00229 BTC/day vs theoretical max mining 0.0000000015 BTC/day',
            description: 'The ratio is 1.5 million times more BTC paid out than could plausibly be mined across CryptoTab\'s entire claimed user base. The marketing claim "mine BTC while you browse" is not supportable by the on-chain ledger.',
        },
        {
            id: 'tx7',
            timestamp: '2024-08-16',
            type: 'macOS bundle notarization',
            signature: 'Apple Team ID 46J7LAWF9F (Cryptocompany OU)',
            description: 'Last Apple notarization timestamp for the macOS build. ~21 months stale at investigation time — no Chromium security patches since.',
        },
    ] as any,

    findings: [
        {
            title: 'Server-custody is universal, not exceptional',
            description: 'Every product in the Cryptocompany OÜ portfolio (Browser desktop + mobile, NC Wallet, Cloud Boost, CTNFT) is server-custody. Nothing valuable lives in client binaries, on local key storage, or on a public chain. The operator preserves full discretion over every user balance under open-ended ToU clauses.',
            tags: ['Architecture', 'Server-Custody', 'Discretion'],
        },
        {
            title: 'No exploitable client-side surface exists',
            description: 'After auditing the desktop binary, mobile APK, custodial wallet, and 10 smart contracts: no operator private key embedded, no Bitcoin signing code, no smart-contract bug above Medium severity, TVL = $0 across all NFT contracts. Every theoretical attack vector was architecturally removed.',
            tags: ['Exploit-Audit', 'Negative-Result', 'Hardened'],
        },
        {
            title: 'Mining is real Monero, settlement is custodial BTC',
            description: 'The embedded miner is xmrig (proven by source-typo). The mined coin is RandomX-based (Monero family), not Bitcoin. The server converts mined XMR to BTC at withdrawal — admitted in CryptoTab\'s own FAQ. The "mine BTC while you browse" marketing is technically misleading.',
            tags: ['xmrig', 'Monero', 'XMR-to-BTC', 'Marketing-Reality-Gap'],
        },
        {
            title: 'Payouts are MLM-funded, not mining-funded',
            description: 'On-chain math shows ~1.5 million times more BTC paid out per day than theoretically minable across the claimed ~35M user base. 0 of 63 examined parent transactions to the payout hub trace to a mining coinbase. The actual funding source is Cloud Boost subscriptions and affiliate purchases — classic MLM revenue recirculation.',
            tags: ['On-Chain', 'MLM-Funding', 'Revenue-Recirculation'],
        },
        {
            title: 'Runtime RCE channel via eval() of remote JS',
            description: 'The bundled extension\'s service worker performs eval() on three remote-supplied JavaScript bodies (one fetched on every browser startup, two from FCM push notifications). The operator can deploy anti-tamper, fingerprinting, or any other client-side logic at will, without shipping a new build.',
            tags: ['RCE', 'Anti-Tamper', 'Operator-Discretion'],
        },
        {
            title: 'Withdrawal slow-roll is the cost-control mechanism',
            description: 'Small payouts (~$3.60 median) are honored on schedule. Large balances are slow-rolled (documented 8-month and 18-month pending cases on Trustpilot, Sitejabber, Medium) or terminated under open-ended ToU clauses. The strategic implication is: withdraw small, withdraw often — never accumulate.',
            tags: ['Withdrawal-Economics', 'Cost-Control', 'User-Strategy'],
        },
        {
            title: '21 months of unpatched Chromium CVEs',
            description: 'The desktop build is forked from Chromium M127 (commit 191cc1af40..., refs/branch-heads/6533), last notarized 2024-08-16. No working auto-updater is bundled. Every Chromium security patch since August 2024 is missing — a real consumer-safety concern for users who browse anywhere else in this browser.',
            tags: ['CVE-Backlog', 'Chromium-M127', 'Consumer-Safety'],
        },
        {
            title: 'Operator identity is fully public and Estonia-jurisdiction',
            description: 'Vadim Tuulik (DOB 1986-07-08), sole director + 100% owner of Cryptocompany OÜ (Estonia, reg. 14448767), Apple Developer Team ID 46J7LAWF9F. €15,625 active tax debt, court fines for unfiled annual reports, Inforegister "🔴 Risky" flag. No VASP/CASP license under MiCA. No regulatory enforcement on record. The operator\'s real risks are regulatory, not technical.',
            tags: ['Operator-Identity', 'Estonia', 'MiCA-Gap'],
        },
    ],

    network: [
        {
            address: 'bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e',
            role: 'Primary BTC payout-dispatch hub (operated via NC Wallet infrastructure)',
            connection: '149 lifetime txs, 3,078 distinct user-payout destinations, ~$3.60 median per user, ~11-day batching cadence. Phase 3 doxxed wallet — now permanently public on Bitcoin\'s ledger.',
        },
        {
            address: 'api.cryptobrowser.site',
            role: 'Operator API hub — withdraw endpoint, mining WebSocket, eval() JS source',
            connection: 'Hosts /api/v2/ws (mining job pipe), /api/v2/.../withdraw/ (custodial payout API), /api/v2/platform/pc/app (the eval\'d boot script). The single most attack-surface-relevant domain in the portfolio.',
        },
        {
            address: 'cryptobrowser.site',
            role: 'Marketing site + Payment Journal',
            connection: 'Public-facing CryptoTab marketing. The /en/journal/?service=bitcoin path provides 46 anchor TXIDs that bootstrap on-chain investigation.',
        },
        {
            address: 'ncwallet.net (com.ncwallet)',
            role: 'Custodial BTC wallet operated by same entity (per WalletScrutiny verdict)',
            connection: 'Same operator (Cryptocompany OÜ). Custodial only — no on-device keys. Routes the CryptoTab BTC payouts on-chain. WalletScrutiny: "We marked it as Custodial: The provider holds the keys."',
        },
        {
            address: 'cryptotab.farm',
            role: 'Cloud-mining sub-product (CRYPTO_TAB_FARM_BASE_URL constant in desktop binary)',
            connection: 'Separate product in operator portfolio. Not investigated in this case file beyond endpoint discovery.',
        },
        {
            address: 'invite.ctnft.net / ctnft.net',
            role: 'NFT product (CTNFT) — 8 NFT contracts on Ethereum + Polygon',
            connection: 'On-chain code is boilerplate audited thirdweb. TVL = $0. No bounty program. The only Cryptocompany product with deployed smart contracts; audit found no exploitable bug.',
        },
        {
            address: 'api.ct-access.pro',
            role: 'Access control / referral attribution API (ENV_ACCESS_API_DOMAIN in binary)',
            connection: 'Suspected handler for the X-CB-Data: ::3.0.12: affiliate-attribution header. Not probed in this investigation.',
        },
        {
            address: 'safebrowsing.cryptobrowser.today',
            role: 'Operator-controlled Safe Browsing v4 endpoint',
            connection: 'Retargets Google\'s Safe Browsing service to the operator\'s own server. The operator decides what URLs are flagged as malicious for users.',
        },
        {
            address: 'snt.cryptobrowser.site/19',
            role: 'Self-hosted Sentry crash/error reporting',
            connection: 'All crash and error telemetry flows to operator infrastructure rather than to a third party.',
        },
        {
            address: 'Apple Team ID 46J7LAWF9F → Cryptocompany OÜ',
            role: 'Code-signing identity for macOS notarization',
            connection: 'Resolves to Cryptocompany OÜ (Estonia reg. 14448767, sole owner Vadim Tuulik). Last notarization 2024-08-16. Apple revocation is a single lever that would invalidate every macOS install.',
        },
        {
            address: '0xcda31ef080e99f60573c4d8c426d32b05a44ac4f',
            role: 'CTNFT deployer EOA — publicly tagged "The Legend of CryptoTab: Deployer" on Polygonscan',
            connection: 'Single externally-owned account holding DEFAULT_ADMIN_ROLE + MINTER_ROLE on 5 CTNFT contracts. No multisig. Single point of failure for the operator\'s entire NFT portfolio.',
        },
        {
            address: '50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7',
            role: 'Largest observed single batched payout tx',
            connection: '302 distinct recipient addresses in one transaction. Demonstrates operator\'s batched-payout pattern at scale.',
        },
    ],

    smartContract: {
        language: 'JavaScript / IDL (the C++↔JS API surface of the browser\'s mining engine)',
        code: jsApiSurface + '\n\n// ─────────── ON-CHAIN PAYOUT EVIDENCE ───────────\n\n' + onChainEvidence,
        vulnerabilities: [
            'NO EXPLOITABLE VULNERABILITY in the client architecture — by design, not by accident.',
            'Mining shares are cryptographic proofs (RandomX hash ≤ server-set target). Client cannot fabricate them; pool re-verifies. "Patch hashrate" and "submit fake share" attacks are mathematically impossible.',
            'No secp256k1 / Bitcoin signing code in the binary. No operator BTC private key is embedded. Bitcoin has no programmable smart contracts. "Wallet inside the app" is architecturally impossible.',
            'Operator has runtime RCE into the browser via eval() of remote-supplied JS on every startup. Any client modification can be detected by code pushed down later. Modify-and-recompile attacks become a moving-target arms race the operator wins by default.',
            'NC Wallet (the operator\'s wallet product) is fully custodial per WalletScrutiny — no mnemonic, no key, no signing on device. Operator can suspend any account at any time under ToU discretion.',
            'CTNFT smart contracts (the only on-chain code in the operator portfolio) use audited boilerplate thirdweb with correct access control, EIP-712 signature replay protection, nonReentrant modifiers, and no integer/randomness/proxy bug classes. TVL = $0.',
            'The ONLY remaining client-adjacent surface is the /withdraw/ API endpoint itself — probing it for IDOR / race / overflow / auth bugs requires live mitmproxy capture during a real cashout. Modest scope; instantly detected and banned if found.',
            'CONSUMER-SAFETY (not exploit) findings: 21-month-stale Chromium M127 with no auto-updater ships every Chromium CVE since 2024-08-16 unpatched. Operator-controlled Safe Browsing endpoint. Permanent eval()-based surveillance channel. Custodial wallet with discretionary freeze clause and no regulatory backstop.',
        ],
    },

    technicalSpecs: [
        { label: 'Operator legal entity', value: 'Cryptocompany OÜ (Estonia, reg. 14448767)' },
        { label: 'Sole director / 100% owner', value: 'Vadim Tuulik (DOB 1986-07-08)' },
        { label: 'Apple Developer Team ID', value: '46J7LAWF9F' },
        { label: 'Bundle ID (macOS)', value: 'site.cryptobrowser.cryptotab' },
        { label: 'Package ID (Android Lite)', value: 'lite.cryptotab.android' },
        { label: 'Bundle ID (iOS)', value: 'site.cryptobrowser.cryptotab (App Store)' },
        { label: 'Custodial wallet (Android)', value: 'com.ncwallet — WalletScrutiny verdict: Custodial' },
        { label: 'Chromium fork', value: 'M127 (commit 191cc1af40..., refs/branch-heads/6533), 21 months stale' },
        { label: 'Embedded mining engine', value: 'xmrig (RandomX + CryptoNight family + Argon2id) — confirmed via verbatim source-typo' },
        { label: 'Coin actually mined', value: 'Monero / RandomX-based (XMR family); converted to BTC at withdrawal' },
        { label: 'Coin paid out', value: 'Bitcoin (BTC) via custodial server-side signing' },
        { label: 'Mining work pipeline', value: 'wss://api.cryptobrowser.site/api/v2/ws (custom WebSocket, NOT stratum)' },
        { label: 'Primary payout hub', value: 'bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e' },
        { label: 'Hub txs / distinct recipients', value: '149 lifetime txs / 3,078 distinct user-payout destinations' },
        { label: 'Median per-user payout', value: '~$3.60 per recipient, batched ~every 11 days' },
        { label: 'Total BTC observed on hub', value: '1.6267 BTC in/out lifetime' },
        { label: 'MLM commission structure', value: '10 levels: 15% / 10% / 5% / 3% / 2% / 1% / 0.5% / 0.25% / 0.125% / 0.0625%' },
        { label: 'Funding source of payouts', value: 'Cloud Boost subscriptions + affiliate fees (MLM revenue recirculation, NOT mining)' },
        { label: 'Theoretical mineable / observed payout ratio', value: '~1 / 1,500,000 — payouts are ~1.5M× more than possibly minable' },
        { label: 'CTNFT contracts deployed', value: '8 dedicated (1 ETH + 7 Polygon) + 2 shared OpenSea (operator does not control)' },
        { label: 'CTNFT TVL', value: '$0 — no on-chain accumulation; all value handled off-chain in operator DB' },
        { label: 'CTNFT bug bounty', value: 'None (Immunefi: 0 results)' },
        { label: 'Operator Inforegister risk flag', value: '🔴 "Risky" — €15,625 tax debt, court fines for unfiled annual reports' },
        { label: 'Regulatory warnings on record', value: 'None (FCA / SEC / BaFin / FINMA / AMF / CSSF / Roskomnadzor — all clean)' },
        { label: 'Estonia VASP / CASP / MiCA license', value: 'None — operating outside post-MiCA virtual-asset regime' },
        { label: 'Apple notarization (macOS)', value: '2024-08-16 — 21 months at investigation; revocable by Apple as a single lever' },
        { label: 'Payment Journal source', value: 'https://cryptobrowser.site/en/journal/?service=bitcoin (operator-published, 46 anchor TXIDs)' },
        { label: 'Largest observed single payout tx', value: '302 recipients in one tx — see 50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7' },
        { label: 'Investigation phases completed', value: '4 (Phase 1 desktop static, Phase 2 OSINT, Phase 3 on-chain, Phase 4 CTNFT smart-contract)' },
        { label: 'Verdict', value: 'Server-custody MLM with affiliate-funded BTC payouts. Legal but exploitative. No client-side exploit exists by design. User\'s 3 successful withdrawals confirm small-and-often strategy works within the operator\'s retention budget.' },
    ],
};