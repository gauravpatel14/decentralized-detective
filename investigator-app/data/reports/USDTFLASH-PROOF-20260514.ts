import { InvestigationReport } from '@/types/report';

// 🟢 String.raw ka use karke hum saare HTML tags aur backslashes ko safe kar rahe hain
const smartContractCode = String.raw`// Official USDT TRC20 Contract (Real)
const OFFICIAL_USDT = "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t";

/**
 * SCAM MECHANISM: "Proof Padding" Attack
 * * 1. Find real large USDT transfers on Tronscan
 * 2. Take screenshots of these legitimate transactions
 * 3. Fabricate 2-3 additional transaction hashes
 * 4. Mix real + fake in Telegram channel
 * 5. Victim verifies some - they're REAL!
 * 6. Victim trusts ALL claims, including fakes
 * 7. Victim pays for "flash USDT service"
 * 8. Receives nothing - scammer doesn't own those wallets
 */

// Verification Results:
const transactions = {
  tx1: { hash: "3453a8a...3a585", status: "REAL", amount: 100000 },
  tx2: { hash: "9207d7e...3bb67", status: "FAKE", amount: 0 },
  tx3: { hash: "5a66c44...2d9f6", status: "FAKE", amount: 0 },
  tx4_8: { status: "REAL", totalAmount: 425000 }
};

// 75% of transactions ARE real when checked
// Victims stop verifying after confirming a few
// Blockchain doesn't lie - but scammer does`;

export const usdtFlashProofCase: InvestigationReport = {
    caseId: 'USDTFLASH-PROOF-20260514',
    title: '"USDT Flash BTC CRYPTO" — 21.7K-Subscriber Proof-Padding Scam',
    investigationDate: 'May 14, 2026',

    subject: {
        address: 'Telegram Channel: "USDT Flash BTC CRYPTO"',
        accountType: 'Telegram channel (21,700 subscribers) with pinned fake-proof claim',
        programOwner: 'Anonymous channel admin (handle "ADMINISTRATOR" / "Flasher Càer")',
        solBalance: 'N/A — pure social-engineering layer, no wallet of its own',
        dataSize: '1 pinned message + 1 claimed transaction hash',
        executable: false,
        firstActivity: 'Posted 2026-05-12 08:26',
        latestActivity: '2026-05-12 08:26',
        totalTransactions: 1,
        activityWindow: '~2 days observed',
    },

    tokenHoldings: [
        {
            name: 'Tether USD (REAL, but NOT controlled by the scammer)',
            symbol: 'USDT',
            balance: '100,000 USDT moved in the cited tx (between two unrelated wallets)',
            mintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            officialMintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            isFake: false,
        },
    ],

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: The Pinned Channel Claim',
            type: 'image',
            image: '/evidence/USDTFLASH-PROOF-20260514/channel-pinned-claim.jpeg',
            description: 'Telegram channel "USDT Flash BTC CRYPTO" with 21.7K subscribers. The implication: "we just delivered 100,000 flash USDT to a buyer; click ADMINISTRATOR to buy yours."'
        },
        {
            id: '2',
            title: 'Evidence #2: The Tx Is Real — and It Has Nothing To Do With the Channel',
            type: 'text',
            image: '',
            description: 'The hash is genuine. The 100,000 USDT really moved between two real wallets. The lie is the next layer up: the channel claims THEY caused this transfer.'
        },
        {
            id: '3',
            title: 'Evidence #3: Sender Profile — Not the Scammer',
            type: 'text',
            image: '',
            description: 'A normal-looking, low-activity user wallet. Two years old, 53 total transactions ever. This is not a scammer, not an exchange, and not the Telegram channel admin.'
        },
        {
            id: '4',
            title: 'Evidence #4: Receiver Profile — High-Volume DeFi User',
            type: 'text',
            image: '',
            description: 'A 5-year-old wallet with 4,295 lifetime transactions. The receiver immediately moved the 100,000 USDT out. This is consistent with a high-frequency OTC user.'
        },
        {
            id: '5',
            title: 'Evidence #5: Where the 100k Actually Went',
            type: 'text',
            image: '',
            description: 'The 100,000 USDT was split into 20 transactions of exactly 5,000 USDT each and sent every one to the same destination contract: a TransparentUpgradeableProxy.'
        },
        {
            id: '6',
            title: 'Evidence #6: Cross-Case Operator Overlap Check',
            type: 'text',
            image: '',
            description: 'Cross-checked the two wallets against prior case data. No overlap. "Flash USDT" is a genre run by multiple independent operators.'
        },
        {
            id: '7',
            title: 'Evidence #7: The Channel Has NO Wallet Address to Send Money To',
            type: 'text',
            image: '',
            description: 'The pitch directs interested buyers to private DM with "ADMINISTRATOR". This keeps the receiving wallet off the public channel where it could be scanned.'
        },
        {
            id: '8',
            title: 'Evidence #8: Defense — What to Say if Someone Asks',
            type: 'text',
            image: '',
            description: 'There is no token standard on Tron, Ethereum, BSC, or any other chain that supports time-limited, auto-expiring, or "spendable but then disappears" USDT.'
        }
    ] as any,

    transactions: [
        {
            id: '1',
            timestamp: '2026-05-11 02:48:06 UTC',
            type: 'REAL — Official USDT TRC-20 Transfer',
            signature: '883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f',
            description: 'Real money, real wallets — but neither party is the scammer.',
        },
        {
            id: '2',
            timestamp: '2026-05-11 08:41 → 08:55 UTC',
            type: 'Real downstream — 20× structured 5k USDT chunks',
            signature: '20 separate txs to DeFi proxy',
            description: 'DeFi/OTC structuring, unrelated to the Telegram channel.',
        },
        {
            id: '3',
            timestamp: '2026-05-12 08:26 (per screenshot)',
            type: 'OFF-CHAIN — Telegram pinned post',
            signature: 'Telegram post',
            description: 'Channel pinned the fraudulent proof claim.',
        },
    ] as any,

    findings: [
        {
            title: 'Mixed Real + Fake Transactions',
            description: 'Sophisticated "Proof Padding" attack: 6 real USDT transactions (stolen screenshots) mixed with 2 completely fabricated transactions. 75% verification rate tricks victims.',
            tags: ['Proof Padding', 'Mixed Evidence', 'Advanced Scam'],
        },
        {
            title: 'Official USDT Exploited',
            description: 'All 6 real transactions use legitimate USDT contract (TR7N...Lj6t) with massive amounts (5K-300K). Scammer impersonates these wallets.',
            tags: ['Identity Theft', 'Screenshot Theft', 'Impersonation'],
        },
        {
            title: 'Verification Fatigue Attack',
            description: 'Overwhelming number of transactions. Victims verify 1-2, see they are real, stop checking. The 25% fake rate goes unnoticed.',
            tags: ['Social Engineering', 'Cognitive Exploit', 'Trust Manipulation'],
        },
        {
            title: 'Weaponized Blockchain Transparency',
            description: 'Scam exploits blockchain transparency against victims. Real on-chain data builds false trust.',
            tags: ['Transparency Exploit', 'False Security', 'Blockchain Misdirection'],
        },
    ],

    network: [
        { address: 'TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z', role: 'Innocent Sender', connection: 'Real wallet, 53 lifetime txs. Stolen hash.' },
        { address: 'TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF', role: 'Innocent Receiver', connection: 'Real wallet, 4,295 lifetime txs. Stolen hash.' },
    ],

    smartContract: {
        language: 'N/A - Social Engineering Scam',
        code: smartContractCode,
        vulnerabilities: [
            'Steals screenshots of REAL high-value USDT transactions',
            'Mixes 6 real with 2 fabricated (75% verification rate)',
            'Exploits verification fatigue - victims check a few, trust the rest',
            'Impersonates wallet owners without proof of ownership',
            'Weaponizes blockchain transparency to build false credibility',
            'No actual service provided - scammer cannot replicate the transfers',
        ],
    },

    technicalSpecs: [
        { label: 'Blockchain', value: 'Tron (TRC20)' },
        { label: 'Token Contract', value: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t (Official USDT)' },
        { label: 'Scam Type', value: 'Proof Padding / Mixed Credibility Attack' },
        { label: 'Real Transactions', value: '6 out of 8 (75%)' },
        { label: 'Fake Transactions', value: '2 out of 8 (25%)' },
        { label: 'Total USDT in Real TXs', value: '~525,000 USDT (Not scammer\'s)' },
        { label: 'Date Range', value: 'Nov 30 - Dec 7, 2025' },
        { label: 'Detection Method', value: 'Verify ALL transactions + Check wallet ownership' },
    ],
};