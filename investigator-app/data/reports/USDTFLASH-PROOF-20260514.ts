import { InvestigationReport } from '@/types/report';

const proofPaddingCode = `// File: claimed-proof.txt (from the Telegram channel pinned message)
//
// What the scammer posted:
//
//   ⚡ FLASH USDT TXN ID :
//   883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f
//
//   Flash Transferred ⚡ Done
//   Flash usdt  Crypto flash  Flash btc  Usdt flash
//   100,000 💵 Flash Usdt Solded ✓
//
//   For Buy ➜ ADMINISTRATOR
//   Telegram: Flasher Càer
//   Available flash: BEP20, ERC20, TRC20, BNB, BTC, BSC, ETH, Fantom (DAI).
//
// What the on-chain reality says (queried live against Tronscan):

const tx = {
    hash       : "883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f",
    status     : "SUCCESS",
    block      : 82599788,
    timestamp  : "2026-05-11 02:48:06 UTC",
    contract   : "TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t",      // VIP-tagged official Tether USD
    method     : "transfer(address,uint256)",
    from       : "TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z",       // not the scammer
    to         : "TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF",       // not the scammer
    amount     : "100,000.000000 USDT",                      // REAL Tether
};

// Neither party has any connection to the Telegram channel
// "USDT Flash BTC CRYPTO". The scammer simply copy-pasted
// a real high-value USDT transfer off Tronscan and posted
// it as "proof I just delivered 100,000 flash USDT."

const senderProfile = {
    address : "TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z",
    created : "2024-03-23",
    txs     : 53,           // tiny activity — normal user, not an exchange
    currentUSDT: "3,003.86 USDT remaining",
};

const receiverProfile = {
    address : "TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF",
    created : "2021-05-22",
    txs     : 4295,         // high-frequency wallet, likely a DeFi/OTC user
    currentUSDT: "0 USDT remaining — re-routed immediately",
};

// What actually happened to the 100,000 USDT
// (also queried live against Tronscan):

const realFlowOfThe100k = [
    // Same UTC day, 2026-05-11, between 08:41 and 08:55 (≈14 minutes):
    // receiver split the 100,000 USDT into 20 chunks of 5,000 USDT
    // and sent each one to a TransparentUpgradeableProxy contract.
    {
        destination      : "TT3kgJohTQJNKDUWwTxtRDMHNNWNvNG3i4",
        contractKind     : "TransparentUpgradeableProxy (DeFi contract)",
        contractTxsTotal : 51926,
        chunks           : 20,
        chunkSize        : "5,000 USDT each",
        intervalMinutes  : "~14 minutes total",
    },
    // This is "structuring" — splitting one large transfer into
    // many sub-threshold chunks. It's commonly seen for OTC trades,
    // DeFi interactions, or mild laundering. It has NOTHING to do
    // with the Telegram channel's "flash USDT sale" claim.
];

// THE SCAM IS THE CLAIM, NOT THE TX
//
// The Telegram channel runs a "Proof Padding" attack: scrape a
// real high-value Tronscan transaction, post it as proof of
// service delivery, then sell the (fictional) "flash USDT
// service" to channel members. The blockchain truth is publicly
// verifiable and innocent; the scam lives entirely in the
// off-chain pitch.`;

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
        firstActivity: 'Posted 2026-05-12 08:26 (per screenshot)',
        latestActivity: '2026-05-12 08:26 (single observed post)',
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
            decimals: 6,
            isFake: false,
        },
    ],

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: The Pinned Channel Claim',
            type: 'image',
            path: '/evidence/USDTFLASH-PROOF-20260514/channel-pinned-claim.jpeg',
            analysis: 'Telegram channel "USDT Flash BTC CRYPTO" with 21.7K subscribers. The pinned post says: ⚡ FLASH USDT TXN ID: 883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f — Flash Transferred ✓ Done — 100,000 Flash Usdt Solded. The implication: "we just delivered 100,000 flash USDT to a buyer; click ADMINISTRATOR to buy yours." Footer lists "Available flash: BEP20, ERC20, TRC20, BNB, BTC, BSC, ETH, Fantom (DAI)" — generic multi-chain veneer to look legitimate.'
        },
        {
            id: '2',
            title: 'Evidence #2: The Tx Is Real — and It Has Nothing To Do With the Channel',
            type: 'text',
            content: `Queried live against Tronscan transaction-info API:

  hash      : 883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f
  status    : SUCCESS  (94,383 confirmations as of investigation)
  block     : 82,599,788
  timestamp : 2026-05-11 02:48:06 UTC

  contract  : TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t
              (Official Tether USD on TRC-20, Tronscan-verified, VIP tag)
  method    : transfer(address _to, uint256 _value)

  from      : TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z
  to        : TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF
  amount    : 100,000.000000 USDT  (real Tether — confirmed against
                                    the official TR7N…Lj6t contract)`,
            analysis: 'The hash is genuine. The 100,000 USDT really moved between two real wallets on May 11, 2026. None of that is in question. The lie is the next layer up: the channel claims THEY caused this transfer to demonstrate their service, when in fact neither the sender nor the receiver has any connection to the channel.'
        },
        {
            id: '3',
            title: 'Evidence #3: Sender Profile — Not the Scammer',
            type: 'text',
            content: `Address      : TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z
Account age  : Created 2024-03-23  (~2 years)
Total txs    : 53        (48 in / 13 out — quiet wallet)
TRX balance  : 638.40 TRX
USDT balance: 3,003.86 USDT remaining after the transfer
Other tokens : ZENLYX (spam airdrop, 85k tokens — ignore)
Tronscan tag : none — not labeled as exchange, not labeled as scam
Risk flag    : false`,
            analysis: 'A normal-looking, low-activity user wallet. Two years old, 53 total transactions ever. Sent 100k USDT one time and kept 3k for itself. This is not a scammer, not an exchange, and not the Telegram channel admin — it is just an ordinary Tron user who happened to make a large transfer that day. Their hash got harvested by the scammer for fake proof.'
        },
        {
            id: '4',
            title: 'Evidence #4: Receiver Profile — High-Volume DeFi User',
            type: 'text',
            content: `Address      : TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF
Account age  : Created 2021-05-22  (~5 years)
Total txs    : 4,295   (much higher activity — frequent user)
TRX balance  : 1,439 TRX
ETH balance  : 0.596 ETH
USDT balance : 0 USDT remaining — immediately re-routed
Other        : 8,467 NFT tokens, dust SUNDOG and ha138com (ignore)
Tronscan tag : none
Risk flag    : false`,
            analysis: 'A 5-year-old wallet with 4,295 lifetime transactions and a mixed Tron/EVM portfolio. The receiver immediately moved the 100,000 USDT out (see next exhibit). This is consistent with a high-frequency OTC user or DeFi participant. Again: no link to the Telegram channel admin.'
        },
        {
            id: '5',
            title: 'Evidence #5: Where the 100k Actually Went — Structured 20×5k Into a DeFi Proxy',
            type: 'text',
            content: `Within ~14 minutes of receiving the 100,000 USDT, the receiver
TQfp75… split it into 20 transactions of EXACTLY 5,000 USDT each
and sent every one to the same destination contract:

  Destination : TT3kgJohTQJNKDUWwTxtRDMHNNWNvNG3i4
  Contract    : TransparentUpgradeableProxy  (DeFi proxy contract)
  Total txs   : 51,926 lifetime on that contract
  Chunks      : 20 × 5,000 USDT = 100,000 USDT
  Time window : 2026-05-11 08:41 UTC → 08:55 UTC

This is textbook "structuring" — splitting a large amount into
sub-threshold chunks. The destination is not an exchange and
not a scam contract; the 51,926-tx lifetime and the
TransparentUpgradeableProxy class identify it as a DeFi
protocol contract (DEX router, lending pool, bridge, or
similar upgradeable contract).

So the FULL real story of the 100k USDT is:

  TVEvMv... (random user)
      → 100k USDT (one transfer)
  TQfp75... (high-volume DeFi user)
      → 20 × 5k USDT chunks (structured for the DeFi protocol)
  TT3kgJoh... (DeFi proxy contract)

This is somebody doing a normal DeFi operation. The Telegram
channel was nowhere near it.`,
            analysis: 'The on-chain story is mundane: a DeFi power-user received a 100k USDT block and fed it into a protocol in 5k chunks. The 5k chunk size is consistent with a slippage cap, a per-tx deposit limit on the protocol, or a privacy-motivated structuring. None of this implies wrongdoing on TQfp75…\'s part — and none of it has anything to do with the Telegram scam. The scammer simply scraped the hash off Tronscan and recycled it as "proof I delivered flash USDT."'
        },
        {
            id: '6',
            title: 'Evidence #6: Identical Playbook to Case TRC-FLASH-20251209',
            type: 'text',
            content: `This is the same "Proof Padding Attack" documented in case
TRC-FLASH-20251209 (Dec 2025), updated to a bigger Telegram
channel and a single jumbo-tx pitch:

                TRC-FLASH-20251209          USDTFLASH-PROOF-20260514
  Channel    :  "Flash USDT TRC20"          "USDT Flash BTC CRYPTO"
  Subs       :  ~5,000 (est.)               21,700  (4.3x larger)
  Proof set  :  8 hashes (6 real, 2 fake)   1 hash (100% real)
  Pitch      :  "we already moved $525k"    "100,000 flash USDT sold"
  Mechanism  :  Mix real + fake to defeat   One huge real tx; victim
                spot-checks                 checks once, sees real
                                            money, trusts the rest

Why this iteration is "better" for the scammer:
  - One jumbo tx > many smaller txs (one click verifies)
  - 100% real hashes = no fake-hash gotcha if checked
  - Larger channel = more recruits per pitch
  - Multi-chain claim list ("BEP20, ERC20, TRC20, BNB, BTC,
    BSC, ETH, Fantom") removes the "but I only have ETH"
    objection

The defense is the same: ownership of the cited transaction
is not provable from the transaction itself. The channel does
not control TVEvMv... or TQfp75... — they just point at the tx.`,
            analysis: 'Scammers iterate. The proof-padding family of scams is mutating toward fewer, bigger, harder-to-disprove proofs. The detection rule is unchanged: a hash on a blockchain does not prove the poster controls either side of that transfer. If someone says "I sent this $100k" — make them sign a message from the sender wallet right now. If they cannot, they did not send it.'
        },
        {
            id: '7',
            title: 'Evidence #7: Cross-Case Operator Overlap Check',
            type: 'text',
            content: `Both wallets in the cited tx were checked against the wallet
networks identified in:

  - AITRO-FLASH-20260514  (13 operator wallets)
  - TRC-FLASH-20251209
  - TRC-1USD-FLASH-20260514
  - SOL-HWSF-20251207

Result: NO overlap.

  TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z  : not in any prior case
  TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF  : not in any prior case
  TT3kgJohTQJNKDUWwTxtRDMHNNWNvNG3i4  : DeFi contract, unrelated

The "USDT Flash BTC CRYPTO" channel is a DIFFERENT operator
than AITRO. The pitch family is the same (sell fake flash USDT
via Telegram); the on-chain footprint is independent.

This is consistent with "flash USDT" being a scam GENRE rather
than a single operator — multiple groups run the same playbook
with rotating channels.`,
            analysis: 'The operator behind the AITRO scam is not the same operator behind this USDT-Flash-BTC-CRYPTO channel. That is useful: takedowns are independent — reporting one does not knock out the other. But it also says the genre itself is industrialized. Expect more channels with similar copy.'
        },
        {
            id: '8',
            title: 'Evidence #8: The Channel Has NO Wallet Address to Send Money To',
            type: 'text',
            content: `Critically, the screenshot shows NO payment address.

The pitch directs interested buyers to:
  - "For Buy ➜ ADMINISTRATOR"   (Telegram deep link)
  - "Telegram: Flasher Càer"    (presumed operator handle)

The actual fee/payment address would only be shared in the
private DM after the victim contacts the admin. That is by
design:

  - Keeps the receiving wallet off the public channel where
    Telegram or anti-fraud tools could scan it.
  - Lets the scammer rotate addresses per-victim.
  - Prevents victims from comparing notes on a single
    "send-to" address.

This is operationally MORE evasive than AITRO (which
hardcoded its fee addresses into the public website
JavaScript). The flip side: that operational evasion
makes the scam harder to scale — every victim is a
separate manual DM interaction.`,
            analysis: 'Without a public payment address, the on-chain footprint of this scam is invisible until a victim comes forward and shares the DM. If you (or someone you know) actually DMs "Flasher Càer" or the Administrator handle, capture and share the address they request payment to — that single screenshot would be the smoking gun. Until then we only know the channel exists and the pitch works; we cannot tally how much they have stolen.'
        },
        {
            id: '9',
            title: 'Evidence #9: Defense — What to Say if Someone Asks About This Channel',
            type: 'text',
            content: `"Flash USDT" as a product DOES NOT EXIST.

  There is no token standard on Tron, Ethereum, BSC, or any
  other chain that supports time-limited, auto-expiring,
  or "spendable but then disappears" USDT. The official
  Tether contracts are simple ERC-20/TRC-20 tokens; their
  balances are eternal until transferred or burned.

  Any seller claiming otherwise is, by definition, lying.

  - If they sell you "flash USDT" and then ghost you = scam
  - If they sell you "flash USDT" and send you a fake-mint
    counterfeit token (see SOL-HWSF-20251207) = scam
  - If they ask for an upfront "activation fee" before
    "releasing" the flash USDT (see AITRO-FLASH-20260514)
    = scam

Hash-on-Tronscan is NOT proof of service delivery.

  Anyone can look at a public blockchain and find $100,000+
  transactions. They do not own those addresses. They cannot
  reproduce those transfers for you.

How to ask the test that breaks the scam:

  "Sign this random text message with the private key of
  TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z — the wallet you say
  sent the 100k USDT. I will verify the signature."

  They cannot do it. They do not control that key.`,
            analysis: 'A one-line response victims can use when their friends ask about this channel: "Flash USDT does not exist as a token type. They can post any hash on the channel — that does not prove they sent it. Tell them to sign a message from the wallet they claim is theirs; they cannot." Save your friends $60–$60,000.'
        },
    ],

    transactions: [
        {
            id: '1',
            timestamp: '2026-05-11 02:48:06 UTC',
            type: 'REAL — Official USDT TRC-20 Transfer (the cited "proof")',
            signature: '883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f',
            description: 'TVEvMv… → TQfp75… : 100,000.000000 USDT on official Tether TR7N…Lj6t contract. SUCCESS. Real money, real wallets — but neither party is the scammer.',
        },
        {
            id: '2',
            timestamp: '2026-05-11 08:41 → 08:55 UTC',
            type: 'Real downstream — 20× structured 5k USDT chunks (NOT scam-related)',
            signature: '20 separate txs all to TT3kgJohTQJNKDUWwTxtRDMHNNWNvNG3i4',
            description: 'Receiver immediately split the 100k into 20 chunks of 5k each, all to a TransparentUpgradeableProxy DeFi contract. ~14 minutes total. This is DeFi/OTC structuring, unrelated to the Telegram channel.',
        },
        {
            id: '3',
            timestamp: '2026-05-12 08:26 (per screenshot)',
            type: 'OFF-CHAIN — Telegram pinned post',
            signature: '(no signature — Telegram post, not a blockchain tx)',
            description: 'Channel "USDT Flash BTC CRYPTO" pins the proof claim with 1.5K views and 289 reactions. The fraud is this post, not the on-chain transfer.',
        },
    ],

    findings: [
        {
            title: 'Proof Padding — The Cited Tx Is Real But Unowned',
            description: 'The 100,000 USDT transaction (hash 883748…cd8f) is a genuine on-chain transfer between two real wallets on Tron. NEITHER wallet has any connection to the "USDT Flash BTC CRYPTO" Telegram channel. The scammer is recycling a stranger\'s public transaction as fake proof of service.',
            tags: ['Proof Padding', 'Hash Hijack', 'Stranger\'s Tx'],
        },
        {
            title: 'Larger Channel, Same Playbook as TRC-FLASH-20251209',
            description: '21,700 subscribers (vs ~5,000 for TRC-FLASH). The mechanism evolved — one jumbo tx is harder to disprove than 8 mixed real+fake hashes. But the underlying scam pattern (sell fake "flash USDT" via Telegram, claim public blockchain txs as proof) is identical.',
            tags: ['Same Pattern', '4x Larger Channel', 'Iterated Variant'],
        },
        {
            title: 'No Public Payment Address — Evasion-First Operational Style',
            description: 'Unlike AITRO (which hardcoded TRC-20/EVM fee addresses in its public JS), this channel exposes ZERO payment wallet. Buyers are forced into private DM with "ADMINISTRATOR" / "Flasher Càer" handles. Trade-off: more evasive but harder to scale per-victim.',
            tags: ['DM-Gated', 'No Public Wallet', 'Per-Victim Rotation'],
        },
        {
            title: 'Different Operator From All Prior Cases',
            description: 'Cross-checked the two wallets (TVEvMv…, TQfp75…) against the AITRO 13-wallet operator network, against TRC-FLASH addresses, and against TRC-1USD-FLASH and SOL-HWSF. No overlap. "Flash USDT" is a genre run by multiple independent operators.',
            tags: ['Independent Operator', 'Genre-Wide Scam', 'No Address Reuse'],
        },
        {
            title: 'Receiver Did Real DeFi Structuring, Not Scam Activity',
            description: 'Receiver TQfp75… split the 100k USDT into 20 × 5k chunks within 14 minutes, all sent to a TransparentUpgradeableProxy DeFi contract (TT3kgJoh…, 51,926 lifetime txs). This is DeFi/OTC user behavior — has nothing to do with the scam channel.',
            tags: ['DeFi Activity', 'Structuring', 'Unrelated to Scam'],
        },
        {
            title: 'Flash USDT Does Not Exist as a Token Type',
            description: 'Repeated from prior cases for clarity: there is no protocol-level mechanism on any major chain for tokens that auto-expire, auto-vanish, or "appear like USDT then disappear." Any seller offering this is selling air.',
            tags: ['Educational', 'No Such Token', 'Protocol Fact'],
        },
        {
            title: 'Detection Test — Demand a Wallet-Signed Message',
            description: 'The single test that breaks every proof-padding scam: ask the seller to sign an arbitrary text message with the private key of the wallet they claim sent the funds. They cannot. They do not own the key. If they refuse or stall, walk away.',
            tags: ['Detection', 'Signature Challenge', 'Practical Defense'],
        },
    ],

    network: [
        { address: 'Telegram channel "USDT Flash BTC CRYPTO"', role: 'Scam Front (21.7K subscribers)', connection: 'Pins the fake-proof message. Drives victims to private DM for payment instructions.' },
        { address: '@ADMINISTRATOR (handle in pinned post)', role: 'DM Sales Funnel', connection: 'Where the actual fee ask happens. Payment wallet is shared in private only.' },
        { address: 'Flasher Càer (Telegram username)', role: 'Operator Persona', connection: 'Public alias attached to the pitch.' },
        { address: 'TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z', role: 'Innocent Sender (Hijacked Hash)', connection: 'Real wallet, 53 lifetime txs. Sent 100,000 USDT to TQfp75…. NOT the scammer — their tx was scraped off Tronscan.' },
        { address: 'TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF', role: 'Innocent Receiver (Hijacked Hash)', connection: 'Real wallet, 4,295 lifetime txs, high-volume DeFi user. Received 100k USDT and structured it to a DeFi proxy. NOT the scammer.' },
        { address: 'TT3kgJohTQJNKDUWwTxtRDMHNNWNvNG3i4', role: 'Downstream DeFi Proxy (Innocent)', connection: 'TransparentUpgradeableProxy contract with 51,926 lifetime txs. Received the 20× 5k chunks. Normal DeFi destination, no scam relevance.' },
        { address: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t', role: 'Official USDT TRC-20', connection: 'Real Tether contract. The cited 100k tx genuinely uses this contract — confirms it is real USDT, not a fake mint.' },
    ],

    smartContract: {
        language: 'js',
        code: proofPaddingCode,
        vulnerabilities: [
            'There is no flash USDT token type on any chain — the product being sold does not exist.',
            'The "proof" hash points to a genuine 100,000 USDT transfer between two wallets that are NOT controlled by the scammer (verified independently on Tronscan).',
            'Public blockchains make it trivial to find and screenshot high-value transactions — anyone can claim authorship by reposting the hash. Authorship is provable ONLY by signing a message from the sender wallet.',
            'The receiver of the 100k USDT immediately structured it 20× 5k into a DeFi proxy contract — completely unrelated downstream activity that further confirms the scammer has no part in this on-chain story.',
            'The channel exposes no public payment address — buyer payment is gated by a DM with the "ADMINISTRATOR" handle, allowing per-victim wallet rotation and making static address-blocking hard.',
            'Subscriber count (21.7K) is ~4x AITRO\'s — the genre is industrialized; expect more channels iterating on the same playbook.',
        ],
    },

    technicalSpecs: [
        { label: 'Scam Type', value: 'Proof Padding / Hash-Hijack Social Engineering' },
        { label: 'Telegram Channel', value: '"USDT Flash BTC CRYPTO" — 21,700 subscribers' },
        { label: 'Operator Handles', value: '@ADMINISTRATOR (DM funnel) / "Flasher Càer" (persona)' },
        { label: 'Pitch Date', value: 'Pinned 2026-05-12 08:26 (per screenshot)' },
        { label: 'Cited "Proof" Hash', value: '883748692b3025b55ef6f117eb30e33a9849b275448a36311532c095eebbcd8f' },
        { label: 'Cited Tx Real?', value: 'YES — 100,000 USDT on official Tether TRC-20 contract' },
        { label: 'Cited Tx Date', value: '2026-05-11 02:48:06 UTC' },
        { label: 'Cited Tx Sender', value: 'TVEvMvaJqsVfsJRSFqy6sE37cwP8tuwY3z (innocent, 53 lifetime txs)' },
        { label: 'Cited Tx Receiver', value: 'TQfp752g5nhrYteFW2P69YEt2bdsAMYHXF (innocent, 4,295 txs, DeFi user)' },
        { label: 'Downstream', value: '100k USDT structured to TT3kgJoh… (TransparentUpgradeableProxy DeFi contract) as 20 × 5k chunks within 14 minutes' },
        { label: 'Operator-To-Tx Link', value: 'NONE — scammer has no ownership of either wallet' },
        { label: 'Overlap With Prior Cases', value: 'NO overlap with AITRO, TRC-FLASH, TRC-1USD-FLASH, or SOL-HWSF operator wallets' },
        { label: 'Claimed Multi-Chain Coverage', value: 'BEP20, ERC20, TRC20, BNB, BTC, BSC, ETH, Fantom (DAI) — marketing copy, not capability' },
        { label: 'Detection Rule', value: 'Demand a wallet-signed message from the sender address. Scammer cannot produce it. Walk away.' },
    ],
};
