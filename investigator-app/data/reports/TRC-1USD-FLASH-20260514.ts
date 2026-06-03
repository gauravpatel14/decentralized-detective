import { InvestigationReport } from '@/types/report';

const scamMechanismCode = `// "Flash USDT" branding deception (cross-chain)
//
// There is NO protocol-level mechanism on Tron or Solana
// for tokens that "appear like USDT then vanish."
// "Flash USDT" as advertised does not exist on-chain.
//
// What actually happened in this case:

const REAL_USDT_TRON   = "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t";
const REAL_USDT_SOLANA = "Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB";

// Step 1 — Scammer sends a small, REAL amount of USDT
//          to the victim, on the real Tether contract.
//
//   Tron  : 1  USDT  TGcre...XX  ->  TVHe6...N9   (2026-05-10)
//   Solana: 10 USDT  BWLC...db  ->  7t59...rB    (2025-12-02)
//
// Step 2 — Scammer tells the victim "this is FLASH USDT"
//          (which the victim's wallet UI does NOT distinguish
//          from real USDT — because it IS real USDT).
//
// Step 3 — Scammer offers to sell more "flash USDT"
//          (claim: "$1000 will get you $100,000 of flash that
//          you can cash out within 24h").
//
// Step 4 — One of:
//   (a) Victim sends real money; scammer ghosts.
//   (b) Victim is directed to a fake "swap" / "activation"
//       site that drains their wallet on signature.
//   (c) Victim is asked for repeated "release fees" before
//       the (non-existent) flash USDT will "unlock".
//
// The on-chain evidence is the bait amount.
// The deception is entirely off-chain (Telegram / chat).

const trustBuilder = {
  realToken:   true,
  smallAmount: true,
  claimedAs:   "FLASH USDT",
  actuallyIs:  "Real USDT (worth $1 / $10)",
  purpose:     "Buy victim's trust before the ask",
};`;

export const trc1UsdFlashCase: InvestigationReport = {
    caseId: 'TRC-1USD-FLASH-20260514',
    title: '"$1 Flash USDT" Cross-Chain Trust-Building Scam',
    investigationDate: 'May 14, 2026',

    subject: {
        address: 'TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9',
        accountType: 'Tron Wallet (Victim)',
        programOwner: 'N/A — Tron Network',
        solBalance: '0.000002 TRX (effectively zero)',
        dataSize: '8 transactions (cross-chain pattern)',
        executable: false,
        firstActivity: 'Feb 26, 2026',
        latestActivity: 'May 10, 2026',
        totalTransactions: 8,
        activityWindow: '~73 days',
    },

    tokenHoldings: [
        {
            name: 'Tether USD (Real)',
            symbol: 'USDT',
            balance: '1.0 USDT (received as "flash" bait)',
            mintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            officialMintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t',
            decimals: 6,
            isFake: false,
        },
    ],

    // 🟢 Override schema properties using 'as any' for full evidence integrity
    evidence: [
        {
            id: '1',
            title: 'Evidence #1: Original Chat Log',
            type: 'text',
            content: `[14/05/26, 1:17:44 PM] ~$Burhanuddin$: d20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d\n[14/05/26, 1:35:22 PM] ~$Burhanuddin$: 4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h`,
            analysis: 'Source intake. Two transaction identifiers from two different chains (Tron 64-hex hash + Solana 88-char base58 signature), plus the victim\'s description: "told this is flash token."'
        },
        {
            id: '2',
            title: 'Evidence #2: Tron Transaction — 1 USDT Bait (REAL)',
            type: 'text',
            content: `Transaction hash : d20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d`,
            analysis: 'This is REAL USDT on the real Tether TRC-20 contract. The scam is not the token — the scam is the lie wrapped around it ("this is flash USDT").'
        },
        {
            id: '3',
            title: 'Evidence #3: Solana Transaction — 10 USDT Bait (REAL)',
            type: 'text',
            content: `Signature        : 4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h`,
            analysis: 'Same playbook, different chain. Real USDT (real Es9vMFrz... mint), token account funded just enough to send a $10 demonstration, then drained.'
        },
        {
            id: '4',
            title: 'Evidence #4: Tron Sender (Scammer) — Address Profile',
            type: 'text',
            content: `Address          : TGcreFnmjcoijQwchDTXAeCiDxdi5A2VPz`,
            analysis: 'Fresh burner address — 13 days old at the time it sent the bait. Holds typical dust/airdrop TRC-10 spam tokens.'
        },
        {
            id: '5',
            title: 'Evidence #5: Tron Receiver (Victim) — Address Profile',
            type: 'text',
            content: `Address          : TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9`,
            analysis: 'This is the victim wallet. The 1 USDT bait is still sitting in it. The wallet has functionally zero TRX, which means the victim cannot even move the 1 USDT out without first receiving TRX.'
        },
        {
            id: '6',
            title: 'Evidence #6: Verify on Tronscan',
            type: 'text',
            content: `Tron transaction:\nhttps://tronscan.org/#/transaction/d20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d`,
            analysis: 'The contract address on the bait transaction matches the official Tether USD TRC-20 contract exactly (TR7NHqj...Lj6t).'
        },
        {
            id: '7',
            title: 'Evidence #7: Verify on Solana',
            type: 'text',
            content: `Solana transaction:\nhttps://solscan.io/tx/4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h`,
            analysis: 'The mint on the Solana bait tx is the official Solana USDT mint (Es9vMFrz...). One-shot sources + persistent gas wallet is a service-style pattern.'
        },
        {
            id: '8',
            title: 'Evidence #8: Victim Claim Decoded',
            type: 'text',
            content: `"person got 1$ token and was told this is flash token"`,
            analysis: 'The victim DID receive value (1 USDT real on Tron, 10 USDT real on Solana). That value is NOT "flash USDT" in any technical sense.'
        }
    ] as any,

    transactions: [
        {
            id: '1',
            timestamp: 'Dec 2, 2025 at 14:24:01 UTC',
            type: 'Solana — Bait #1 (10 USDT real)',
            signature: '4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h',
            description: '10 real USDT from one-time burner BWLC...Qg6db to victim Solana wallet 7t59...QxrB.',
        },
        {
            id: '2',
            timestamp: '2026-05-10 17:00:42 UTC',
            type: 'Tron — Bait #2 (1 USDT real)',
            signature: 'd20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d',
            description: '1 real USDT from scammer wallet TGcr...PvbN to victim Tron wallet TVHe6...aEN9.',
        },
        {
            id: '3',
            timestamp: 'After bait (expected, not yet observed on-chain)',
            type: 'Expected next step — OFF-CHAIN ASK',
            signature: '(no signature — happens in Telegram / chat)',
            description: 'Based on the standard "flash USDT" playbook: scammer will ask victim to send real money for a much larger "flash USDT" amount.',
        },
    ] as any,

    findings: [
        {
            title: 'Real Token, Fake Story',
            description: 'Both bait transactions transfer GENUINE USDT on the official Tether contracts. The "flash" label is a verbal lie applied to real on-chain value to manufacture trust.',
            tags: ['Real USDT', 'Branding Deception', 'Trust Build'],
        },
        {
            title: 'Cross-Chain Operator Pattern',
            description: 'The same victim received bait USDT on Solana (Dec 2025) and Tron (May 2026). The cross-chain footprint expands the attack surface to whichever wallet the victim uses.',
            tags: ['Cross-Chain', 'Multi-Network', 'Coordinated'],
        },
    ],

    network: [
        { address: 'TGcreFnmjcoijQwchDTXAeCiDxdi5A2VPz', role: 'Tron Sender (Scammer)', connection: 'Fresh wallet, May 1 2026. Sent 1 USDT bait on 2026-05-10.' },
        { address: 'TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9', role: 'Tron Receiver (Victim)', connection: 'Received 1 USDT bait. Stranded — has 0.000002 TRX.' },
    ],

    smartContract: {
        language: 'js',
        code: scamMechanismCode,
        vulnerabilities: [
            'No protocol-level "flash USDT" feature exists on Tron or Solana.',
            'Real USDT is used as bait — victim verifies on-chain and sees real value, which is re-labeled.',
            'The actual loss vector is OFF-CHAIN: a wallet-drain swap site or an "activation fee" demand.',
        ],
    },

    technicalSpecs: [
        { label: 'Scam Type', value: 'Real-Token-As-Bait / "Flash USDT" Branding Deception' },
        { label: 'Networks Involved', value: 'Tron (TRC-20) + Solana (SPL Token)' },
        { label: 'Tron Token Contract', value: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t (Official Tether USD)' },
        { label: 'Solana Token Mint', value: 'Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB (Official Tether USD)' },
        { label: 'Bait Amount (Tron)', value: '1.000000 USDT' },
    ],
};