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
};

// Cross-chain pattern indicates the same operator
// (or operator network) targets the same victim on
// whichever chain the victim is willing to use.`;

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

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: Original Chat Log',
            type: 'text',
            content: `[14/05/26, 1:17:44 PM] ~$Burhanuddin$: d20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d
[14/05/26, 1:35:22 PM] ~$Burhanuddin$: 4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h

person got 1$ token and was told this is flash token`,
            analysis: 'Source intake. Two transaction identifiers from two different chains (Tron 64-hex hash + Solana 88-char base58 signature), plus the victim\'s description: "told this is flash token." The fact that the scammer is sending value on multiple chains points to either the same operator or coordinated operators targeting the same victim across whichever network the victim is willing to use.'
        },
        {
            id: '2',
            title: 'Evidence #2: Tron Transaction — 1 USDT Bait (REAL)',
            type: 'text',
            content: `Transaction hash : d20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d
Status           : SUCCESS
Block            : 82,575,246
Timestamp        : 2026-05-10 17:00:42 UTC
Contract         : TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t  (Tronscan-verified Tether USD, VIP-tagged)
Method           : transfer(address,uint256)
From             : TGcreFnmjcoijQwchDTXAeCiDxdi5A2VPz   (scammer / sender)
To               : TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9   (victim)
Amount (raw)     : 1,000,000
Decimals         : 6
Amount (USDT)    : 1.000000 USDT
Network fee paid : 13,046,000 sun fee_limit; 130,285 energy used`,
            analysis: 'This is REAL USDT on the real Tether TRC-20 contract — Tronscan tags the contract as VIP/legitimate. The bait is exactly $1. The scam is not the token (the token is genuine) — the scam is the lie wrapped around it ("this is flash USDT"). A wallet UI cannot tell the victim that the dollar is "flash" because there is no such on-chain attribute; the deception lives entirely in the chat.'
        },
        {
            id: '3',
            title: 'Evidence #3: Solana Transaction — 10 USDT Bait (REAL)',
            type: 'text',
            content: `Signature        : 4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h
Status           : Ok
Slot             : 383,995,064
Block time       : 2025-12-02 14:24:01 UTC
Mint             : Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB  (official Tether USD on Solana)
Instruction      : TransferChecked (spl-token)
Source authority : BWLCMMhFgtgPa7FDQfjRX66NZ9xDGDYbTpCjYL2Qg6db  (one-time burner — only 2 txs ever)
Source ATA       : 3tSnu4yQTy4Ns8QUx1VxJQzFJPoHF8NFB26qS3fr1z8J
Destination ATA  : DxyZ66WZfqKK6z4z8toLp4qc54swHGCMJ2NBKe3UCwi1
Destination owner: 7t5913G7eYyg6qXto935KKt3HQmUJWsqjkZyqwMZQxrb  (victim's Solana wallet)
Fee payer        : 6cRBcJy8YatfNYLHD5kyNtCX9ypENwXerB36MKUNUK4e  (active service wallet, ~5 SOL)
Amount (raw)     : 10,000,000
Decimals         : 6
Amount (USDT)    : 10.000000 USDT
Network fee      : 11,876 lamports`,
            analysis: 'Same playbook, different chain. Real USDT (real Es9vMFrz... mint), token account funded just enough to send a $10 demonstration, then drained. The source authority (BWLC...) is a one-shot burner — it has only two signatures in its entire history, both on the same day in Dec 2025, and now holds 0 SOL. Meanwhile the fee payer (6cRBc...) is an active wallet doing dozens of transactions per minute with ~5 SOL of fuel — characteristic of an OTC / scam-service gas wallet, not a normal user.'
        },
        {
            id: '4',
            title: 'Evidence #4: Tron Sender (Scammer) — Address Profile',
            type: 'text',
            content: `Address          : TGcreFnmjcoijQwchDTXAeCiDxdi5A2VPz
Account created  : 2026-05-01  (less than 2 weeks before the bait tx)
Total txs        : 22  (15 in, 7 out)
Current USDT     : 2 USDT
Current TRX      : 96.17 TRX
TRC-10 holdings  : BlockGames "ha138com" (138,138,000), 9pay.org (8,888,888)
Tronscan risk    : not flagged
Tag              : none`,
            analysis: 'Fresh burner address — 13 days old at the time it sent the bait. Holds typical dust/airdrop TRC-10 spam tokens that anyone receives passively on Tron (those are not the scam tokens here, they are just chain noise). The dangerous signals are: (a) the wallet is newer than any "established merchant" claim would justify, (b) it has very few transactions, (c) it has just enough USDT to repeat the bait a few times before refilling.'
        },
        {
            id: '5',
            title: 'Evidence #5: Tron Receiver (Victim) — Address Profile',
            type: 'text',
            content: `Address          : TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9
Account created  : 2026-02-26
Total txs        : 8  (7 in, 1 out)
Current USDT     : 1 USDT  (the bait)
Current TRX      : 0.000002 TRX  (functionally empty — cannot pay tx fees)
TRC-10 dust      : GasFreeSolution "TRC20Ucom", BestAdsCoin "TRC20AdsCOM", 9pay.org
Tronscan risk    : not flagged`,
            analysis: 'This is the victim wallet. The 1 USDT bait is still sitting in it (live on-chain at the time of investigation). The wallet has functionally zero TRX, which means the victim cannot even move the 1 USDT out without first receiving TRX for energy — a constraint scammers often weaponize ("send us a small fee and we will release more"). The dust TRC-10 tokens are typical victim-wallet noise — phishing TRC-10 airdrops that link to malicious sites.'
        },
        {
            id: '6',
            title: 'Evidence #6: Verify on Tronscan',
            type: 'text',
            content: `Tron transaction:
  https://tronscan.org/#/transaction/d20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d

Scammer (sender) wallet:
  https://tronscan.org/#/address/TGcreFnmjcoijQwchDTXAeCiDxdi5A2VPz

Victim wallet:
  https://tronscan.org/#/address/TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9

Official USDT contract (for comparison):
  https://tronscan.org/#/token20/TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t`,
            analysis: 'All identifiers were checked live against Tronscan. The contract address on the bait transaction matches the official Tether USD TRC-20 contract exactly (TR7NHqj...Lj6t) — Tronscan flags it as VIP / verified. So when the victim verifies the tx, the chain says "yes, you received 1 real USDT." That truth is then re-packaged as "yes, you received 1 flash USDT" by the scammer in chat.'
        },
        {
            id: '7',
            title: 'Evidence #7: Verify on Solana',
            type: 'text',
            content: `Solana transaction:
  https://solscan.io/tx/4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h

Scammer burner (source):
  https://solscan.io/account/BWLCMMhFgtgPa7FDQfjRX66NZ9xDGDYbTpCjYL2Qg6db

Fee-payer service wallet (likely operator gas):
  https://solscan.io/account/6cRBcJy8YatfNYLHD5kyNtCX9ypENwXerB36MKUNUK4e

Victim's Solana wallet:
  https://solscan.io/account/7t5913G7eYyg6qXto935KKt3HQmUJWsqjkZyqwMZQxrb

Official Solana USDT mint:
  https://solscan.io/token/Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB`,
            analysis: 'Same verification pattern. The mint on the Solana bait tx is the official Solana USDT mint (Es9vMFrz...). The interesting operational tell is the split between the burner source (BWLC...) and the active fee-payer (6cRBc...). One-shot sources + persistent gas wallet is a service-style pattern: the operator keeps a hot gas wallet topped up and rotates fresh source accounts for each victim so no single source ever accumulates a flag.'
        },
        {
            id: '8',
            title: 'Evidence #8: Victim Claim Decoded',
            type: 'text',
            content: `"person got 1$ token and was told this is flash token"

Two things are true at the same time:
  1. The victim DID receive value (1 USDT real on Tron, 10 USDT real on Solana).
  2. That value is NOT "flash USDT" in any technical sense — there is no
     such concept on Tron or Solana. Tokens do not auto-expire or
     auto-disappear after a duration.

The scam is the BRANDING applied to a real transfer.

What the scammer is setting up next (typical sequence — to watch for):
  - "$X gets you $X*1000 worth of flash USDT — limited offer"
  - "Pay activation fee to unlock the full flash USDT amount"
  - "Connect your wallet to this site to swap flash USDT to real USDT"
    (this last step is the actual drain — wallet-approval phishing)`,
            analysis: 'The intake quote IS the scam. The technical investigation confirms that what the victim received is real, small, and a deliberate trust-building demonstration. No tokens auto-disappear; "flash USDT" as a product category does not exist. Anything that follows from the scammer ("send a fee", "use this swap site", "we will multiply this for you") is the actual loss vector.'
        },
    ],

    transactions: [
        {
            id: '1',
            timestamp: '2025-12-02 14:24:01 UTC',
            type: 'Solana — Bait #1 (10 USDT real)',
            signature: '4qvsLLZjHP5sTF9xvkr6ns4Gxba1JmVy3rdcWBNxabxJj7PXnRLC56zxWPp4qVqP9YCeUi13zGCGAMPiDfwXbP7h',
            description: '10 real USDT from one-time burner BWLC...Qg6db to victim Solana wallet 7t59...QxrB. Fee paid by separate service wallet 6cRBc...UK4e (~5 SOL fuel). Mint: Es9v...NYB (official).',
        },
        {
            id: '2',
            timestamp: '2026-05-10 17:00:42 UTC',
            type: 'Tron — Bait #2 (1 USDT real)',
            signature: 'd20ef7f0fe3a110bb54e844750cdccab570bd0110c54f0e57e3fce1a9ff4d76d',
            description: '1 real USDT from scammer wallet TGcr...PvbN to victim Tron wallet TVHe6...aEN9. Contract: TR7NHqj...Lj6t (official Tether). Scammer wallet was created only 13 days earlier (2026-05-01).',
        },
        {
            id: '3',
            timestamp: 'After bait (expected, not yet observed on-chain)',
            type: 'Expected next step — OFF-CHAIN ASK',
            signature: '(no signature — happens in Telegram / chat)',
            description: 'Based on the standard "flash USDT" playbook: scammer will ask victim to send real money for a much larger "flash USDT" amount, OR direct them to a wallet-draining swap site. The on-chain bait above is the trust-builder for this step.',
        },
    ],

    findings: [
        {
            title: 'Real Token, Fake Story',
            description: 'Both bait transactions transfer GENUINE USDT on the official Tether contracts (TR7N...Lj6t on Tron, Es9v...NYB on Solana). The "flash" label is a verbal lie applied to real on-chain value to manufacture trust.',
            tags: ['Real USDT', 'Branding Deception', 'Trust Build'],
        },
        {
            title: 'Cross-Chain Operator Pattern',
            description: 'The same victim received bait USDT on Solana (Dec 2025) and Tron (May 2026). Either one operator across chains, or coordinated operators using the same script. The cross-chain footprint expands the attack surface to whichever wallet the victim uses.',
            tags: ['Cross-Chain', 'Multi-Network', 'Coordinated'],
        },
        {
            title: 'Burner Source + Service Fee-Payer (Solana)',
            description: 'On Solana the source authority is a one-shot burner with only 2 lifetime txs and 0 SOL remaining, while the fee was paid by a separate service wallet that is highly active (dozens of txs/min, ~5 SOL fuel). This is operator infrastructure, not a personal wallet.',
            tags: ['Burner Wallet', 'Service Wallet', 'Operator Infra'],
        },
        {
            title: 'Fresh Sender Wallet (Tron)',
            description: 'The Tron sender wallet was created on 2026-05-01 — 13 days before the bait transfer. It has 22 total transactions and 2 USDT remaining. New, low-history wallets sending unsolicited USDT are a strong red flag.',
            tags: ['Fresh Wallet', 'Low History', 'Red Flag'],
        },
        {
            title: 'Victim Wallet Stranded by Design',
            description: 'The Tron victim wallet holds 1 USDT but only 0.000002 TRX — not enough energy to send the USDT back out. This is consistent with the next-step ask ("pay activation fee in TRX so you can unlock more flash USDT").',
            tags: ['Energy Trap', 'Locked Funds', 'Fee Ask Setup'],
        },
        {
            title: '"Flash USDT" Does Not Exist',
            description: 'There is no token standard on Tron (TRC-20) or Solana (SPL) that supports time-limited, auto-expiring, or auto-vanishing balances. Any product sold under that name is either a scam, a counterfeit token impersonating USDT (see SOL-HWSF-20251207), or both.',
            tags: ['Educational', 'Protocol Fact', 'No Such Token'],
        },
    ],

    network: [
        { address: 'TGcreFnmjcoijQwchDTXAeCiDxdi5A2VPz', role: 'Tron Sender (Scammer)', connection: 'Fresh wallet, May 1 2026. Sent 1 USDT bait on 2026-05-10. Currently holds 2 USDT.' },
        { address: 'TVHe63DWqqaSuAULGTqiu3tWW9rWRdaEN9', role: 'Tron Receiver (Victim)', connection: 'Received 1 USDT bait. Stranded — has 0.000002 TRX, cannot pay tx fees.' },
        { address: 'BWLCMMhFgtgPa7FDQfjRX66NZ9xDGDYbTpCjYL2Qg6db', role: 'Solana Source (Burner)', connection: 'One-shot burner. 2 lifetime txs, 0 SOL remaining. Sent 10 USDT on 2025-12-02.' },
        { address: '6cRBcJy8YatfNYLHD5kyNtCX9ypENwXerB36MKUNUK4e', role: 'Solana Fee Payer (Operator Service)', connection: 'Paid gas for the bait. Dozens of txs per minute, ~5 SOL fuel — service-wallet pattern.' },
        { address: '7t5913G7eYyg6qXto935KKt3HQmUJWsqjkZyqwMZQxrb', role: 'Solana Receiver (Victim, same person)', connection: 'Cross-chain confirmation that the same victim was targeted on Solana before Tron.' },
        { address: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t', role: 'Official USDT Contract (Tron)', connection: 'Real Tether — exploited only as the carrier of the bait amount, not impersonated.' },
        { address: 'Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB', role: 'Official USDT Mint (Solana)', connection: 'Real Tether — same role on the Solana side.' },
    ],

    smartContract: {
        language: 'js',
        code: scamMechanismCode,
        vulnerabilities: [
            'No protocol-level "flash USDT" feature exists on Tron or Solana — the term is marketing, not a token property.',
            'Real USDT is used as bait — victim verifies on-chain and (correctly) sees real value, which is then re-labeled "flash" off-chain.',
            'Cross-chain pattern: same victim approached on Solana then Tron — operator can pivot to whichever chain the victim funds.',
            'Operator infrastructure on Solana: rotating one-shot source wallets + a persistent gas/service wallet — designed to keep any single source from accumulating a fraud flag.',
            'Energy/fee trap: victim wallet is left without TRX so they cannot move the bait themselves, setting up a "send a small fee to unlock" ask.',
            'The actual loss vector is OFF-CHAIN: a wallet-drain swap site, an "activation fee" demand, or an upfront purchase for a much larger (non-existent) flash USDT amount.',
        ],
    },

    technicalSpecs: [
        { label: 'Scam Type', value: 'Real-Token-As-Bait / "Flash USDT" Branding Deception' },
        { label: 'Networks Involved', value: 'Tron (TRC-20) + Solana (SPL Token)' },
        { label: 'Tron Token Contract', value: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t (Official Tether USD)' },
        { label: 'Solana Token Mint', value: 'Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB (Official Tether USD)' },
        { label: 'Bait Amount (Tron)', value: '1.000000 USDT' },
        { label: 'Bait Amount (Solana)', value: '10.000000 USDT' },
        { label: 'Tron Bait Date', value: '2026-05-10 17:00:42 UTC' },
        { label: 'Solana Bait Date', value: '2025-12-02 14:24:01 UTC' },
        { label: 'Tron Sender Age at Bait', value: '13 days (created 2026-05-01)' },
        { label: 'Solana Source Lifetime Txs', value: '2 (both same day, one-shot burner)' },
        { label: 'Solana Fee Payer Pattern', value: 'Persistent service wallet (~5 SOL, dozens of txs/min)' },
        { label: 'Detection Rule', value: 'Unsolicited USDT from a new/burner wallet + an off-chain claim of "flash"/"multiply"/"unlock" = scam. Do NOT pay any "fee" or connect wallet to any "swap" link.' },
    ],
};
