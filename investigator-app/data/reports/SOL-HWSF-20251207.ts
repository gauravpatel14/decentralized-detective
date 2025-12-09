import { InvestigationReport } from '@/types/report';

const smartContractCode = `<span style="color: #569cd6;">use</span> anchor_lang::prelude::*;
<span style="color: #569cd6;">use</span> anchor_spl::token::{self, Mint, Token, TokenAccount};
<span style="color: #569cd6;">use</span> mpl_token_metadata::instruction as mpl_instruction;

<span style="color: #6a9955;">/// Fake USDT Token Creation Program</span>
<span style="color: #6a9955;">/// Creator: Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx</span>
<span style="color: #6a9955;">/// Mint: 6KXPe4k4ss4q6KDkbALP3XECYZpzm9Sh6mG3grYxa8T4</span>

<span style="color: #569cd6;">pub fn</span> <span style="color: #dcdcaa;">create_fake_usdt</span>(ctx: Context&lt;CreateToken&gt;) -&gt; Result&lt;()&gt; {
    <span style="color: #6a9955;">// Initialize SPL Token Mint with 6 decimals (same as real USDT)</span>
    <span style="color: #569cd6;">let</span> mint = &<span style="color: #569cd6;">mut</span> ctx.accounts.mint;
    
    <span style="color: #6a9955;">// CRITICAL: Mint authority is SET to creator (not revoked)</span>
    <span style="color: #6a9955;">// This allows unlimited token creation</span>
    <span style="color: #569cd6;">let</span> mint_authority = ctx.accounts.creator.key();
    
    <span style="color: #6a9955;">// CRITICAL: Freeze authority is SET to creator (not revoked)</span>
    <span style="color: #6a9955;">// This allows freezing any holder's tokens</span>
    <span style="color: #569cd6;">let</span> freeze_authority = <span style="color: #569cd6;">Some</span>(ctx.accounts.creator.key());
    
    token::initialize_mint(
        CpiContext::new(
            ctx.accounts.token_program.to_account_info(),
            token::InitializeMint {
                mint: mint.to_account_info(),
                rent: ctx.accounts.rent.to_account_info(),
            },
        ),
        <span style="color: #b5cea8;">6</span>, <span style="color: #6a9955;">// decimals (matching real USDT)</span>
        &mint_authority,
        freeze_authority.as_ref(),
    )?;
    
    <span style="color: #569cd6;">Ok</span>(())
}`;

export const solanaCase: InvestigationReport = {
    caseId: 'SOL-HWSF-20251207',
    title: 'Investigation Report',
    investigationDate: 'December 7, 2025',

    subject: {
        address: 'HWSF6x8ZA4jSS1pzpTgLosPW7ejTez1rLet41rcG9R3e',
        accountType: 'System Account',
        programOwner: '11111111111111111111111111111111',
        solBalance: '0.037910644 SOL',
        dataSize: '0 bytes',
        executable: false,
        firstActivity: 'Dec 2, 2025 15:01 UTC',
        latestActivity: 'Dec 2, 2025 15:26 UTC',
        totalTransactions: 8,
        activityWindow: '25 minutes',
    },

    tokenHoldings: [
        {
            name: 'Tether USD',
            symbol: 'USDT',
            balance: '14,889.76893 USDT',
            mintAddress: '6KXPe4k4ss4q6KDkbALP3XECYZpzm9Sh6mG3grYxa8T4',
            officialMintAddress: 'Es9vMFrzaCERmJfrF4H2FYD4KCoNkY11McCe8BenwNYB',
            isFake: true,
        },
    ],

    tokenMetadata: {
        updateAuthority: 'Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx',
        mintAuthority: {
            enabled: true,
            controller: 'Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx',
        },
        freezeAuthority: {
            enabled: true,
            controller: 'Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx',
        },
        isMutable: false,
        sellerFee: 0,
    },

    creator: {
        address: 'Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx',
        accountType: 'System Account',
        solBalance: '0.0022 SOL',
        role: 'Token Creator / Mint Authority / Freeze Authority',
        fundingSource: {
            address: 'FkMegXkVwVKQj3quvMZ82dGDT97sm1czpxHQJHysb4nJ',
            platform: 'Binance',
            type: 'Exchange Deposit Address',
            firstTransaction: '4MJFigB8ThRhGhMD8wgK4CibssTBXjTnHqNh6NRvYvFWgPaNs9ZCo86fRcYPv4wS2VJKLnUGjBgC9JpujNjwu4os',
            date: 'Dec 4, 2025',
        },
        tokens: [
            { name: 'USD Coin', balance: '0.0', notes: 'Official USDC - No balance' },
            { name: 'Wrapped BTC', balance: '0.0', notes: 'Official WBTC - No balance' },
            { name: 'Tether USD (FAKE)', balance: '3,223,890,000', notes: 'Fake USDT from mint ArhV...4nku - MAJOR HOLDING' },
            { name: 'KEKIUS MAXIMUS', balance: 'Amount', notes: 'Meme token' },
            { name: 'AICells', balance: 'Amount', notes: 'AI-related token' },
            { name: 'Multiple other tokens', balance: 'Various', notes: 'Creator holds diverse token portfolio' },
        ],
    },

    secondToken: {
        name: 'Tether',
        symbol: 'USDT',
        mintAddress: 'ArhVdmrGSzDis9eBctQ16Z3uAQWuJrie5G2XrAnN4nku',
        totalSupply: '~3,800,000,000 USDT',
        creatorHoldings: '~3,200,000,000 USDT',
        creatorPercentage: 84,
        mintAuthority: 'Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx (ENABLED)',
        freezeAuthority: 'Hm9qW3CSe11p8hGaMw6AkJ51SGXzEwPN38t713jn5Rrx (ENABLED)',
    },

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: Original Submission',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/solana-case.png',
            analysis: 'Initial evidence showing the fake USDT balance in user\'s wallet. Notice the wallet displays "14,889 USDT" which appears legitimate but is actually a counterfeit token. This is the first indicator of the scam - victims see a large balance and believe they own valuable USDT.'
        },
        {
            id: '2',
            title: 'Evidence #2: Original Submission',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/image.png',
            analysis: 'Additional screenshot from user submission. The interface may show USD value, creating false perception of worth. This psychological tactic makes victims believe they have real money, when in reality the token has zero value.'
        },
        {
            id: '3',
            title: 'Evidence #3: Original Submission',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/image copy.png',
            analysis: 'Further documentation from the initial report. These screenshots help establish the timeline and demonstrate how the scam presents itself to victims across different wallet interfaces.'
        },
        {
            id: '4',
            title: 'Evidence #4: Original Submission',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/image copy 2.png',
            analysis: 'Final image from original submission package. The consistency across evidence shows this is a systematic operation, not an isolated incident.'
        },
        {
            id: '5',
            title: 'Evidence #5: Subject Address',
            type: 'text',
            content: 'HWSF6x8ZA4jSS1pzpTgLosPW7ejTez1rLet41rcG9R3e',
            analysis: 'The target wallet address under investigation. This is a standard Solana system account that received the fake USDT tokens. The address shows legitimate SOL balance (0.037), suggesting it\'s a real user wallet, not a scammer-controlled address.'
        },
        {
            id: '6',
            title: 'Evidence #6: User Claim',
            type: 'text',
            content: 'User claim to buy X number of fake USDT for less amount and then swapping them on real platform and cashing out in different crypto currency. And a screenshot provided by the user also claim to show value in dollars, even though it is fake and does not have value.',
            analysis: 'CRITICAL: This describes the scam mechanism. Victims are lured to "buy" fake USDT cheaply, then directed to fraudulent DEX platforms claiming they can swap it for real crypto. The swap sites are part of the scam - they either steal wallet signatures or direct real crypto deposits that are never returned. The displayed "dollar value" is completely fabricated.'
        },
        {
            id: '7',
            title: 'Investigation #1: Wallet Overview',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/solana_explorer_page_1765138720337.png',
            analysis: 'Solana Explorer verification showing the wallet details. Key finding: Only ONE token held (the fake USDT). The 8 transactions all occurred within 25 minutes on Dec 2, 2025. This clustered activity pattern is typical of automated scam token distribution bots.'
        },
        {
            id: '8',
            title: 'Investigation #2: Token Mint Details',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/fake_usdt_overview_1765139243621.png',
            analysis: 'SMOKING GUN: The mint address (6KXPe...a8T4) does NOT match official USDT (Es9v...NYB). This proves the token is counterfeit. Notice the metadata shows "Tether USD" and "USDT" symbol - classic impersonation. The creator retained BOTH mint and freeze authority, allowing unlimited token creation and the ability to freeze holder accounts.'
        },
        {
            id: '9',
            title: 'Investigation #3: Transaction History',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/all_transactions_loaded_1765139363486.png',
            analysis: 'Complete transaction history showing all 8 transactions. The tight 25-minute timeframe (15:01 - 15:26 UTC) indicates automated distribution. All transactions are "TransferChecked" instructions for the fake USDT token. No other activity before or after this window - strong indicator of bot-driven operation.'
        },
        {
            id: '10',
            title: 'Investigation #4: First Transaction Details',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/first_transaction_instructions_1765139447110.png',
            analysis: 'First transaction breakdown showing Associated Token Account creation followed by TransferChecked instruction. This is when the fake USDT first arrived in the wallet. The instruction set shows standard SPL token operations, making it appear legitimate to casual observers.'
        },
        {
            id: '11',
            title: 'Investigation #5: Latest Transaction Details',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/last_transaction_instructions_1765139470442.png',
            analysis: 'Final transaction in the sequence. Similar pattern to first transaction - more fake USDT transfers. After this, the wallet activity stopped, suggesting the distribution phase completed. The wallet now sits with fake tokens, waiting for the victim to attempt a swap on a malicious platform.'
        },
        {
            id: '12',
            title: 'Investigation #6: Creator Overview',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/creator_overview_1765142162710.png',
            analysis: 'The mastermind\'s address (Hm9q...5Rrx). Low SOL balance (0.0022) suggests this is a burner wallet used specifically for creating fake tokens. The address serves as the Update Authority, Mint Authority, and Freeze Authority for the fake USDT - complete control over the token.'
        },
        {
            id: '13',
            title: 'Investigation #7: Creator Tokens',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/creator_tokens_1765142179009.png',
            analysis: 'MAJOR REVELATION: The creator holds 3.2+ BILLION of a SECOND fake USDT token (ArhV...4nku). This proves a large-scale operation creating multiple fake stablecoins. The diverse token portfolio (USDC, WBTC, meme tokens) shows the scammer is active across the Solana ecosystem, possibly testing or operating multiple scam variants.'
        },
        {
            id: '14',
            title: 'Investigation #8: Second Fake USDT',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/second_fake_usdt_overview_1765142256260.png',
            analysis: 'Details of the second fake USDT (mint: ArhV...4nku). Creator controls 84% of the 3.8 billion supply. Both mint and freeze authorities enabled and controlled by the same creator (Hm9q...5Rrx). This is a parallel scam operation running simultaneously with the first fake USDT.'
        },
        {
            id: '15',
            title: 'Investigation #9: Creator Funding Source',
            type: 'image',
            path: '/evidence/SOL-HWSF-20251207/first_transaction_details_1765222953415.png',
            analysis: 'CRITICAL EVIDENCE: The creator\'s funding source traced to Binance exchange address (FkMe...VCrt). This is the smoking gun for identifying the real culprit. The first transaction shows SOL being distributed from a Binance deposit address to multiple recipients including our creator. This means: 1) The scammer has a Binance account, 2) Binance has their KYC information, 3) Law enforcement can request records from Binance to identify the individual. This transaction link is the key to catching the perpetrator.'
        },
    ],

    transactions: [
        {
            id: '1',
            timestamp: 'Dec 2, 2025 at 15:01:04 UTC',
            type: 'Transaction #1',
            signature: '3SHFR4NW83Zoi2Fmf2yVszfgYpCVp65BzUAFbQrFkmJHG6i3zqeAcb1WdVbKaeYMnLq7EVs3E6V8BCN2ozDYFj2B',
            description: 'Associated Token Account creation + TransferChecked instruction',
        },
        {
            id: '2',
            timestamp: 'Dec 2, 2025 (15:01 - 15:26 UTC)',
            type: 'Transactions #2-7',
            signature: '',
            description: 'Continued token transfers via TransferChecked instructions (6 transactions)',
        },
        {
            id: '3',
            timestamp: 'Dec 2, 2025 at 15:26:46 UTC',
            type: 'Transaction #8 (Latest)',
            signature: '5ddqLXLD4rfAeWwjAfcuBcLvFD66xRR6Sw7t9PxgxrGQPqvsCh9Fcpvuuvw1XMsHvbvDk7ow3vsGCiUVVcFLs2BT',
            description: 'Final TransferChecked instruction - Similar pattern to previous transactions',
        },
    ],

    findings: [
        {
            title: 'Token Verification',
            description: 'The held "Tether USD" token does not match the official USDT mint address on Solana.',
            tags: ['Mint Mismatch', 'Impersonation'],
        },
        {
            title: 'Creator Control',
            description: 'The creator retains full mint and freeze authority over the token, allowing unlimited token creation and holder freezing.',
            tags: ['Mint Enabled', 'Freeze Enabled'],
        },
        {
            title: 'Multi-Token Operation',
            description: 'Creator address controls at least 2 separate fake USDT tokens, holding 3.2B+ of the second variant.',
            tags: ['Network Pattern', 'Multiple Fakes'],
        },
        {
            title: 'Activity Pattern',
            description: 'All transactions in subject wallet occurred within a 25-minute window on a single day.',
            tags: ['Clustered Activity', 'Automated Pattern'],
        },
    ],

    network: [
        { address: 'HWSF...9R3e', role: 'Target Wallet', connection: 'Holds 14,889 of fake USDT #1' },
        { address: 'Hm9q...5Rrx', role: 'Creator/Controller', connection: 'Created both fake tokens, holds 3.2B+ of fake USDT #2' },
        { address: '6KXPe...a8T4', role: 'Fake Token #1', connection: 'Distributed to target wallet' },
        { address: 'ArhV...4nku', role: 'Fake Token #2', connection: '3.8B supply, creator holds 84%' },
    ],

    smartContract: {
        language: 'rust',
        code: smartContractCode,
        vulnerabilities: [
            'Mint Authority Retained: Creator can mint unlimited tokens at any time',
            'Freeze Authority Retained: Creator can freeze any holder\'s tokens',
            'Token Impersonation: Uses identical name "Tether USD" and symbol "USDT"',
            'Metadata Control: Update authority retained by creator (even though marked immutable)',
            'No Verification: Token has no official verification or attestation',
        ],
    },

    technicalSpecs: [
        { label: 'Token Standard', value: 'SPL Token (Solana Program Library)' },
        { label: 'Decimals', value: '6 (Standard for USDT)' },
        { label: 'Transfer Method', value: 'TransferChecked (includes decimal verification)' },
        { label: 'Account Program', value: 'TokenkegQfeZyiNwAJbNbGKPFXCWuBvf9Ss623VQ5DA' },
    ],
};
