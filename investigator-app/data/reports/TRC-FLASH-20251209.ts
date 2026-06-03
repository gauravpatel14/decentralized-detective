import { InvestigationReport } from '@/types/report';

const smartContractCode = `// Official USDT TRC20 Contract (Real)
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

export const tronFlashCase: InvestigationReport = {
    caseId: 'TRC-FLASH-20251209',
    title: 'Telegram "Flash USDT" Mixed Credibility Scam',
    investigationDate: 'December 9, 2025',

    subject: {
        address: 'Telegram Channel: Flash USDT Seller',
        accountType: 'Sophisticated Scam Operation',
        programOwner: 'Unknown (Proof Padding Attack)',
        solBalance: 'N/A - Tron Network',
        dataSize: '8 Transaction Claims (6 Real, 2 Fake)',
        executable: false,
        firstActivity: 'November 30, 2025',
        latestActivity: 'December 7, 2025',
        totalTransactions: 6,
        activityWindow: '7 days',
    },

    tokenHoldings: [
        {
            name: 'Tether USD (Official)',
            symbol: 'USDT',
            balance: '~525,000 USDT (Across 6 transactions)',
            mintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            officialMintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            isFake: false,
        },
    ],

    // 🟢 Strict override applied to keep all your analysis data intact
    evidence: [
        {
            id: '1',
            title: 'Evidence #1: Telegram Channel Promotion',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/Channel-Screenshot-1.png',
            description: 'Screenshot of Telegram channel promoting "Flash USDT TRC20" services. The sophisticated aspect of this scam is that they provide REAL transaction links mixed with FAKE ones, weaponizing blockchain transparency against victims.'
        },
        {
            id: '2',
            title: 'Evidence #2: Mixed Real + Fake Transactions',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/Channel-Screenshot-2.png',
            description: 'Shows transaction hashes. Our verification revealed this is a "Proof Padding" attack - scammers steal screenshots of REAL large USDT transfers and mix them with fabricated transaction IDs. 6 out of 8 transactions are real, 2 are fake.'
        },
        {
            id: '3',
            title: 'Evidence #3: Large Amount Claims ($15K+)',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/Channel-Screenshot-3.png',
            description: 'Claims of "$15,000 USDT" transfers with Tronscan URLs. When victims verify on Tronscan, they DO find real transactions! This builds false trust. Victims verify 1-2 links, see massive amounts, and assume ALL claims are real.'
        },
        {
            id: '4',
            title: 'Evidence #4: Additional Transaction Proof',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/Channel-Screenshot-4.png',
            description: 'More transaction evidence. The scam psychology: overwhelming victims with multiple pieces of evidence where most (75%) are verifiable on-chain. This creates verification fatigue.'
        },
        {
            id: '5',
            title: 'Verification: Real TX #1 - 100,000 USDT',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/tx_1_details_1765232020407.png',
            description: 'VERIFIED REAL: Transaction 3453a8a...3a585 shows legitimate 100,000 USDT transfer using official contract. The scammer did NOT perform this transfer - they simply found it on Tronscan and claimed it as their proof.'
        },
        {
            id: '6',
            title: 'Verification: Real TX #8 - 10,000 USDT',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/tx_8_details_1765232225850.png',
            description: 'VERIFIED REAL: Transaction 631c914...266380 shows 10,000 USDT transfer. The scammer is impersonating the sender/receiver, claiming they can replicate these transfers. They cannot.'
        },
        {
            id: '7',
            title: 'Verification: FAKE TX #2 - Does Not Exist',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/tx_2_9207d7e_not_found_1765231676595.png',
            description: 'EXPOSED AS FAKE: Transaction hash 9207d7e...3bb67 returns "Search not found" on Tronscan. This transaction NEVER HAPPENED. The scammer fabricated this hash to pad their success rate.'
        },
        {
            id: '8',
            title: 'Verification: FAKE TX #3 - Does Not Exist',
            type: 'image',
            image: '/evidence/TRC-FLASH-20251207/tx_3_5a66c44_not_found_1765231688628.png',
            description: 'EXPOSED AS FAKE: Transaction hash 5a66c44...2d9f6 also returns "Search not found". Another completely fabricated transaction. The 25% fake rate inflates claimed volume without arousing suspicion.'
        }
    ] as any,

    transactions: [
        {
            id: '1',
            timestamp: '2025-11-30 19:15:33 UTC',
            type: 'REAL - Official USDT Transfer',
            signature: '3453a8a226415668ea8837958df77390f9b27b070770340cda1464b81b33a585',
            description: 'VERIFIED REAL: 100,000 USDT transfer. Scammer stole this screenshot.',
        },
        {
            id: '2',
            timestamp: 'Never occurred',
            type: 'FABRICATED',
            signature: '9207d7e16b702075e4d20c522ea4b80a6298e73bb67',
            description: 'FAKE: "Search not found" on Tronscan. Does not exist.',
        },
        {
            id: '3',
            timestamp: 'Never occurred',
            type: 'FABRICATED',
            signature: '5a66c4495408d635f12af976e2fbe5062ce6a9df0871bfdd130e8caa81e2d9f6',
            description: 'FAKE: "Search not found" on Tronscan. Does not exist.',
        },
        {
            id: '4',
            timestamp: '2025-12-01 03:21:15 UTC',
            type: 'REAL - Official USDT Transfer',
            signature: 'e7401fec92e32da9f7fa1a6c8904130ea00ce5b72dc49c9ae44807a539ed58d8',
            description: 'VERIFIED REAL: 5,000 USDT transfer. Scammer stole this screenshot.',
        },
        {
            id: '5',
            timestamp: '2025-12-03 14:52:09 UTC',
            type: 'REAL - Official USDT Transfer',
            signature: '21f6a682fd2ab7de9cb54689b6d742be396d7d26db22d866c41dfbade7245ed3',
            description: 'VERIFIED REAL: 10,000 USDT transfer. Scammer stole this screenshot.',
        },
        {
            id: '6',
            timestamp: '2025-12-05 08:30:42 UTC',
            type: 'REAL - Official USDT Transfer',
            signature: 'ebc3685624125cf4dd1e91ed3f4cccf1dd991f9095168ae940b0c2a1b0ae280a',
            description: 'VERIFIED REAL: 300,000 USDT transfer. Scammer stole this screenshot.',
        },
        {
            id: '7',
            timestamp: '2025-12-07 11:18:27 UTC',
            type: 'REAL - Official USDT Transfer',
            signature: '184316c0bc91129a04b27282b73ebce92597a8943247dc38c0ad39a68553e822',
            description: 'VERIFIED REAL: 100,000 USDT transfer. Scammer stole this screenshot.',
        },
        {
            id: '8',
            timestamp: '2025-12-05 19:43:12 UTC',
            type: 'REAL - Official USDT Transfer',
            signature: '631c91468166a8407158276257cbf0bef5c5df573387d57a6bd5ff50a0266380',
            description: 'VERIFIED REAL: 10,000 USDT transfer. Scammer stole this screenshot.',
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
        { address: 'TMSJAE...DygxhVHq', role: 'Real USDT Sender (Impersonated)', connection: 'Scammer stole their transaction screenshots' },
        { address: 'TMrbUc...ZAkhP4D4', role: 'Real USDT Receiver (Impersonated)', connection: 'Scammer claims to replicate these transfers' },
        { address: 'TR7N...Lj6t', role: 'Official USDT Contract', connection: 'Real contract - scammer just references' },
        { address: '9207d7e...3bb67', role: 'Fake Transaction', connection: 'Does not exist - fabricated' },
        { address: '5a66c44...2d9f6', role: 'Fake Transaction', connection: 'Does not exist - fabricated' },
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