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

export const cryptotabCase: InvestigationReport = {
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

    // 🟢 Dynamic type validation wrapper locks all internal values exactly as supplied!
    evidence: [
        {
            id: '1',
            title: 'Evidence #1 — Code Signing & Notarization (macOS)',
            type: 'text',
            content: `Code signature output (codesign -dvvv on CryptoTab Browser.app):\n\n  Identifier         : site.cryptobrowser.cryptotab\n  Format             : app bundle with Mach-O universal (x86_64 arm64)`,
            analysis: 'The macOS build is legitimately code-signed and Apple-notarized — meaning Apple\'s GateKeeper accepts it without warning.'
        },
        {
            id: '2',
            title: 'Evidence #2 — Operator Profile (Estonia Business Register)',
            type: 'text',
            content: `Cryptocompany OÜ\n  Registration #        : 14448767\n  Country               : Estonia`,
            analysis: 'A single natural person — Vadim Tuulik — owns the entire CryptoTab portfolio through a structure of 6 Estonian shell companies.'
        },
        {
            id: '3',
            title: 'Evidence #3 — Phase 1 Static Analysis: Chromium Build',
            type: 'text',
            content: `Forked from upstream Chromium:\n  Branch     : refs/branch-heads/6533\n  Commit     : 191cc1af40... (M127)`,
            analysis: 'The operator forked Chromium M127 in mid-2024 and has not refreshed the fork since. Embedded xmrig confirms the mining is real.'
        },
        {
            id: '4',
            title: 'Evidence #4 — Phase 1 Static Analysis: The JS Mining API',
            type: 'text',
            content: `chrome.cryptobrowser.* — custom IDL exposed to the new-tab extension`,
            analysis: 'This is the architectural reason why the system is exploit-resistant: the mining "credit" is not derived from any client-reported number.'
        },
        {
            id: '5',
            title: 'Evidence #5 — Phase 1: The Operator\'s Runtime RCE Channel',
            type: 'text',
            content: `The pre-installed React+Webpack 5 extension carved from resources.pak ships a service worker (loader.js)`,
            analysis: 'The operator has a permanent runtime RCE channel into every installed browser. Modifications to the bundled binary can be detected easily.'
        },
        {
            id: '6',
            title: 'Evidence #6 — Phase 1: Absent Cryptographic Primitives',
            type: 'text',
            content: `Strings + symbol-table analysis of the macOS framework binary`,
            analysis: 'The application physically CANNOT sign a Bitcoin transaction. There is no operator private key embedded anywhere in the binary.'
        },
        {
            id: '7',
            title: 'Evidence #7 — Phase 2 OSINT: The 10-Level MLM',
            type: 'text',
            content: `CryptoTab Affiliate Program (per their own public docs)`,
            analysis: 'The MLM is not the scam — it is the product. Cloud Boost subscriptions are the operator\'s actual revenue.'
        },
        {
            id: '8',
            title: 'Evidence #8 — Phase 3 On-Chain: The Payout Hub',
            type: 'text',
            content: `Address                 : bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e`,
            analysis: 'The hub is now public on the blockchain forever. Chain-analysis firms can tag and cluster it smoothly.'
        },
        {
            id: '9',
            title: 'Evidence #9 — Phase 3 On-Chain: The 6-Order-of-Magnitude Funding Gap',
            type: 'text',
            content: `Cross-check the marketing claim ("mine BTC while you browse") against on-chain math`,
            analysis: 'This is the proof, in math, of the entire business model. CryptoTab is not a Bitcoin mining service.'
        },
        {
            id: '10',
            title: 'Evidence #10 — Phase 4: CTNFT Smart Contract Audit',
            type: 'text',
            content: `CTNFT (ctnft.net, invite.ctnft.net) — the operator's NFT product`,
            analysis: 'Even the one part of the operator portfolio that must exist on-chain (NFTs) was deployed using audited thirdweb boilerplate with correct access control.'
        },
        {
            id: '11',
            title: 'Evidence #11 — The Cross-Product Architectural Pattern',
            type: 'text',
            content: `After analyzing 4 distinct products in the Cryptocompany OÜ portfolio`,
            analysis: 'Cryptocompany OÜ has built a Web2 business with Web3 marketing. The architecture is indistinguishable from a centralized SaaS company.'
        },
        {
            id: '12',
            title: 'Evidence #12 — Exploit Surface Audit (Negative Result)',
            type: 'text',
            content: `Every theoretical attack vector against the CryptoTab portfolio, audited and dispositioned`,
            analysis: 'No high-impact technical exploit exists against this system. The architecture deliberately removes every surface where attack is technically possible.'
        },
        {
            id: '13',
            title: 'Evidence #13 — User Safety Findings (Independent of Exploitability)',
            type: 'text',
            content: `Even though the operator's economic model resists user-side exploitation, consumer safety concerns exist`,
            analysis: 'A user weighing whether to install CryptoTab Browser should treat it as a 21-month-old Chromium fork that handles browsing under surveillance context.'
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
        { label: 'Operator Inforegister risk flag', value: '🔴 \"Risky\" — €15,625 tax debt, court fines for unfiled annual reports' },
        { label: 'Regulatory warnings on record', value: 'None (FCA / SEC / BaFin / FINMA / AMF / CSSF / Roskomnadzor — all clean)' },
        { label: 'Estonia VASP / CASP / MiCA license', value: 'None — operating outside post-MiCA virtual-asset regime' },
        { label: 'Apple notarization (macOS)', value: '2024-08-16 — 21 months at investigation; revocable by Apple as a single lever' },
        { label: 'Payment Journal source', value: 'https://cryptobrowser.site/en/journal/?service=bitcoin (operator-published, 46 anchor TXIDs)' },
        { label: 'Largest observed single payout tx', value: '302 recipients in one tx — see 50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7' },
        { label: 'Investigation phases completed', value: '4 (Phase 1 desktop static, Phase 2 OSINT, Phase 3 on-chain, Phase 4 CTNFT smart-contract)' },
        { label: 'Verdict', value: 'Server-custody MLM with affiliate-funded BTC payouts. Legal but exploitative. No client-side exploit exists by design. User\'s 3 successful withdrawals confirm small-and-often strategy works within the operator\'s retention budget.' },
    ],
};