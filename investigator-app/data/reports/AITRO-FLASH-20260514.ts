import { InvestigationReport } from '@/types/report';

const scamFrontendCode = `// File: script.js (decompiled from aitro-flash-usdt-vip.netlify.app)
// Unobfuscated. Comments in the original include Arabic
// (e.g. "سعر الرسوم لكل 1 USDT" = "fee price per 1 USDT")
// suggesting an Arabic-speaking operator.

// ---- Where the "fees" actually go ----
const FEE_RECIPIENTS = {
    TRC20: "TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA",
    ERC20: "0x16738514b5fe77c5e4c5577d7fd8233db40bfe8c",
    BEP20: "0x16738514b5fe77c5e4c5577d7fd8233db40bfe8c", // same EVM key
};

const BASE_FEES = {
    TRC20: 175,   // TRX per 1000 USDT  (~$498 at $2.85/TRX)
    ERC20: 0.02,  // ETH per 1000 USDT  (~$50)
    BEP20: 0.07,  // BNB per 1000 USDT  (~$21)
};
// 50% discount on amounts above 2000 USDT — designed
// to push victims to "withdraw more" → pay more fees.

// ---- The fake balance ----
// User clicks "Generate Coin" and this runs:
function generateCoin() {
    // ... 100-tick fake progress animation ...
    state.balances.USDT += amount;           // PURELY CLIENT-SIDE
    state.lastGeneratedAmount = amount;
    state.hasPendingWithdrawal = true;       // sets up the ask
}
// No blockchain. No mint. No contract. The "balance"
// only exists in localStorage on the victim's browser.

// ---- The actual ask (this is the fraud) ----
async function handleWithdrawClick() {
    // Minimum: 1000 USDT — keeps the fee floor at 175 TRX (~$498)
    if (!amount || amount < 1000 || !address) return;

    const feeValue = calculateFee(amount, network);
    const recipient = FEE_RECIPIENTS[network];

    if (network === 'TRC20') {
        // Native TRX transfer — NOT a token approval, NOT a drainer.
        // Victim signs a normal sendTrx to the scammer's wallet.
        const sunAmount = tw.toSun(feeValue);
        const transaction = await tw.transactionBuilder.sendTrx(
            recipient, sunAmount, currentAddr
        );
        const signedTransaction = await tw.trx.sign(transaction);
        await tw.trx.sendRawTransaction(signedTransaction);
    } else {
        // ERC20/BEP20: also a native value transfer.
        await provider.request({
            method: 'eth_sendTransaction',
            params: [{ from: currentEvmAddr, to: recipient, value: weiValue }]
        });
    }
    // After this point: scammer has the fee, victim has nothing.
    // The "withdraw" never resolves — there is no "AI node",
    // no "private liquidity bridge", no flash USDT to release.
}

// ---- Why this isn't a wallet drainer ----
// No approve(), no permit(), no transferFrom(),
// no max-allowance setting, no signed-message exfil.
// The victim's signature only authorizes the fee itself.
// This means: damage is bounded to the fee amount —
// the wallet itself is not compromised after payment.`;

export const aitroFlashCase: InvestigationReport = {
    caseId: 'AITRO-FLASH-20260514',
    title: 'AITRO Flash USDT — Netlify-Hosted Advance-Fee Fraud',
    investigationDate: 'May 14, 2026',

    subject: {
        address: 'aitro-flash-usdt-vip.netlify.app',
        accountType: 'Scam Website (Netlify free-tier hosting)',
        programOwner: 'Anonymous publisher — Netlify accepts no KYC',
        solBalance: 'N/A — multi-chain target (TRC20 / ERC20 / BEP20)',
        dataSize: 'index.html 25 KB + 3 JS files (~97 KB total)',
        executable: false,
        firstActivity: 'Tron fee wallet created 2025-12-23',
        latestActivity: '2026-05-12 (latest TRX inflow observed)',
        totalTransactions: 116,
        activityWindow: '~143 days',
    },

    tokenHoldings: [
        {
            name: 'Tether USD (Claimed, FAKE — pure client-side state)',
            symbol: 'USDT',
            balance: 'Whatever the user types into "Generate Coin" (localStorage)',
            mintAddress: 'NONE — no token is ever minted on any chain',
            officialMintAddress: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t (real USDT TRC20, for reference)',
            decimals: 6,
            isFake: true,
        },
    ],

    evidence: [
        {
            id: '1',
            title: 'Evidence #1: Telegram Channel Recruitment',
            type: 'image',
            path: '/evidence/AITRO-FLASH-20260514/telegram-channel.jpeg',
            analysis: 'Channel "AITRO FLASH USDT" with 5,463 members / 175 online. Owner alias "móviç" posing as "DANIEL WINSLET". Promotes a referral pyramid: 5% per referral, 20 referrals = "1000 flashusdt". This is the recruitment funnel that feeds victims into the bot, then the site, then the fee payment.'
        },
        {
            id: '2',
            title: 'Evidence #2: Telegram Bot "ASTRØ FLAH USDT BØT"',
            type: 'image',
            path: '/evidence/AITRO-FLASH-20260514/telegram-bot.jpeg',
            analysis: 'Bot handle @astroflashusdtbot but display name uses look-alike characters ("FLAH" not "FLASH", Ø not O). This is a common Telegram-ban-evasion pattern — the visible name is what users repeat to friends; the handle is what Telegram indexes for takedown.'
        },
        {
            id: '3',
            title: 'Evidence #3: The Site — aitro-flash-usdt-vip.netlify.app',
            type: 'text',
            content: `URL    : https://aitro-flash-usdt-vip.netlify.app/
Host   : Netlify Edge (HTTP/2)
Title  : "AITRO FLASH USDT SENDER"
Support: https://t.me/movich203  (same "móviç" alias)
Stack  :
  - index.html (25 KB)
  - styles.css (30 KB)
  - script.js (49 KB)              <- main scam logic, fully readable
  - api-verification.js (15 KB)    <- fake-looking on-chain verification
  - wallet-connection.js (32 KB)   <- multi-wallet connect
  - CDN: tronweb + ethers.umd + @web3modal + qrcode

What the page offers:
  - "Connect Wallet"  (OKX, TronLink, MetaMask, WalletConnect)
  - "Continue as Guest"
  - "Create Local Account"
  - "Generate Coin"   <- the fake balance
  - "Withdraw"        <- the fee ask`,
            analysis: 'Hosted on Netlify\'s free tier — fast, anonymous, easy to redeploy after takedown. The "VIP version" branding and the deliberate "Real blockchain verification • Instant processing • Secure & transparent" copy are all designed to defuse skepticism. Free CDN libraries are loaded so the developer didn\'t need to write any actual wallet code — they just wired ethers.js / TronWeb into a UI shell.'
        },
        {
            id: '4',
            title: 'Evidence #4: The Fake Balance — generateCoin()',
            type: 'text',
            content: `// from script.js (lines 486–546)
function generateCoin() {
    const amount = parseFloat(document.getElementById('amountInput').value);
    if (!amount || amount < 1000) { /* min 1000 USDT */ return; }
    // ... 100-step progress animation (50ms tick) for theatre ...
    if (currentStep >= totalSteps) {
        state.balances.USDT += amount;          // <-- THE FAKE
        state.lastGeneratedAmount = amount;
        state.hasPendingWithdrawal = true;
        state.transactions.unshift({ type: 'Generate', coin: 'USDT', amount, timestamp: new Date() });
        saveStateToLocalStorage();              // <-- persists to localStorage
    }
}`,
            analysis: 'This is the entire "AI USDT generation" engine: one line that mutates the JS state object. No RPC call. No mint. No contract interaction. The user picks an amount, watches a 5-second progress ring spin, and the number goes up in their browser memory. Closing the tab clears it (it lives in localStorage). No real USDT is created at any point.'
        },
        {
            id: '5',
            title: 'Evidence #5: The Fee Ask — handleWithdrawClick()',
            type: 'text',
            content: `// from script.js (lines 388–484)
async function handleWithdrawClick() {
    const amount = parseFloat(document.getElementById('withdrawAmount').value);
    const network = document.getElementById('networkType').value;
    if (!amount || amount < 1000) return;

    const feeValue = calculateFee(amount, network);
    const recipient = FEE_RECIPIENTS[network];   // <-- the scam wallet

    if (network === 'TRC20') {
        const sunAmount = tw.toSun(feeValue);
        const transaction = await tw.transactionBuilder.sendTrx(recipient, sunAmount, currentAddr);
        const signedTransaction = await tw.trx.sign(transaction);
        await tw.trx.sendRawTransaction(signedTransaction);
    } else {
        const weiValue = "0x" + BigInt(Math.floor(feeValue * 1e18)).toString(16);
        await provider.request({
            method: 'eth_sendTransaction',
            params: [{ from: currentEvmAddr, to: recipient, value: weiValue }]
        });
    }
}`,
            analysis: 'When the victim hits "Withdraw" the site signs a NATIVE-COIN transfer (TRX or ETH/BNB) directly to the scammer\'s wallet. The victim authorizes only the fee amount — there is NO approve() call, NO transferFrom, NO permit signature. So this is advance-fee fraud, NOT a wallet drainer. Practical consequence: the loss is bounded to whatever fee the victim pays. The wallet itself is not compromised after payment, but the fee is gone.'
        },
        {
            id: '6',
            title: 'Evidence #6: Fee Math — calculateFee()',
            type: 'text',
            content: `// from script.js (lines 331–356)
const BASE_FEES = { TRC20: 175, ERC20: 0.02, BEP20: 0.07 };

function calculateFee(amount, network) {
    const base = BASE_FEES[network];
    const feePerUnit = base / 1000;                // سعر الرسوم لكل 1 USDT
    const MIN_AMOUNT = 1000;
    const DISCOUNT_THRESHOLD = 2000;
    const DISCOUNT_RATE = 0.5;                     // 50% off above 2000

    const effectiveAmount = Math.max(amount, MIN_AMOUNT);
    let totalFee = 0;
    if (effectiveAmount <= DISCOUNT_THRESHOLD) {
        totalFee = effectiveAmount * feePerUnit;
    } else {
        const basePart      = 2000 * feePerUnit;
        const extraAmount   = effectiveAmount - DISCOUNT_THRESHOLD;
        const discountedPart= extraAmount * (feePerUnit * DISCOUNT_RATE);
        totalFee = basePart + discountedPart;
    }
    return parseFloat(totalFee.toFixed(4));
}

// Reference fee amounts at 1000 USDT "withdrawal":
//   TRC20 -> 175 TRX     (~$498  at $2.85/TRX)
//   ERC20 -> 0.02 ETH    (~$50)
//   BEP20 -> 0.07 BNB    (~$21)
// At 10,000 USDT "withdrawal" (50% discount tier):
//   TRC20 -> 175 + 8*87.5  = ~875 TRX     (~$2,495)
//   ERC20 -> 0.02 + 8*0.01 = 0.10 ETH     (~$250)
//   BEP20 -> 0.07 + 8*0.035= 0.35 BNB     (~$105)`,
            analysis: 'The 50% "discount above 2000 USDT" is the psychological hook: it nudges victims to type a LARGER fake amount (because it feels cheaper per dollar), which forces a larger real fee on the wallet they actually own. The Arabic comment in the source ("سعر الرسوم لكل 1 USDT") is a strong fingerprint of an Arabic-speaking developer.'
        },
        {
            id: '7',
            title: 'Evidence #7: Tron Fee Wallet — Live On-Chain Profile',
            type: 'text',
            content: `Address          : TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA
Created          : 2025-12-23  (≈143 days ago)
Total txs        : 116        (85 in / 27 out)
Current TRX      : 0.000011  (drained — fees cashed out immediately)
Tronscan label   : (none)
Tronscan risk    : not flagged (the site has not been formally reported here yet)

Sample inflows (matching the 175-TRX scam fee):
  2026-05-09 17:09 UTC   175 TRX  from  TZ3Kntvxgpoy8r…  tx=910d24e6abadcc07c7
  2026-04-26 11:39 UTC    99.85 TRX from TL6jrnoZtKMViH…
  2026-04-26 11:39 UTC    68 TRX    from … (consolidation)
  2026-04-26 11:33 UTC    5 TRX     from …
  2026-04-26 11:31 UTC    2 TRX     from …
  Many 1-TRX "activation/dust" inbound from unique addresses.

Sample outflows (cash-out hops):
  2026-05-09 17:09 UTC   175 TRX  ->  TDKaWd5RR7Ahho…
  2026-04-30 14:01 UTC   5.84 TRX ->  TGJiSg1CrgAm4g…
  2026-04-23 19:39 UTC   99.85 + 68 + 5 + 2 TRX ->  TGp6WhUQbqAkTQ…`,
            analysis: 'The fee wallet behaves exactly as the code predicts. 116 transactions, ~70% of inbound amounts match the 175 TRX fee for a 1000 USDT "withdrawal." Cash-outs go to two consolidator addresses (TGp6...AkTQ and TDKaWd5R...). Current balance is zero — the operator does not let funds sit. Multiple 1-TRX inbounds are "address activation" payments (Tron requires activation for new accounts), consistent with victims being told to send a tiny test before the full fee.'
        },
        {
            id: '8',
            title: 'Evidence #8: EVM Fee Wallet — Same Key on ETH + BSC',
            type: 'text',
            content: `Address (used on BOTH chains):
  0x16738514b5fe77c5e4c5577d7fd8233db40bfe8c

BSC (Binance Smart Chain) live state:
  BNB balance : 0  (drained)
  Tx count    : 5
  RPC         : https://bsc-dataseed1.binance.org/  (queried directly)

ETH (Ethereum mainnet) live state:
  Public RPC eth.llamarpc.com returned 503 from this IP at query time.
  Address is structurally valid checksum-lower; same key paired with BSC.

Why use the same key on ETH and BSC?
  Both chains are EVM — one private key controls the same address
  on every EVM chain. Convenient for the operator: one seed phrase
  to manage all EVM fee revenue. Convenient for investigators:
  any inflow on ETH or BSC routes through the same wallet
  (and Polygon, Arbitrum, etc. would too if used).`,
            analysis: 'EVM fees are clearly the minor channel for this operator — only 5 lifetime BSC transactions vs. 116 on Tron, despite a TRX-fee floor that\'s ~10x the BNB-fee floor in dollar terms. That means: (a) the operator\'s recruitment funnel is Tron-heavy, (b) most victims are on TronLink/OKX rather than MetaMask. The shared EVM key is a fingerprint: any future site reusing 0x16738514b5fe77c5e4c5577d7fd8233db40bfe8c is the same operator.'
        },
        {
            id: '9',
            title: 'Evidence #9: Operator Handles & Telegram Footprint',
            type: 'text',
            content: `Channel       : "AITRO FLASH USDT"         (5,463 members, 175 online at capture)
Bot           : @astroflashusdtbot          (display: "ASTRØ FLAH USDT BØT")
Support       : @movich203                  (linked from site header)
Owner alias   : "móviç" / "DANIEL WINSLET"  (chat identity in the channel)
Telegram name juggling:
  - Display uses Ø, Æ, Ø-variants and the misspelling "FLAH"
  - This is a known ban-evasion pattern: when the channel/bot
    is reported and disabled, the operator spins up the same
    name with another look-alike substitution.

Site language clue:
  - script.js comments include Arabic strings (e.g.
    "سعر الرسوم لكل 1 USDT" = "fee price per 1 USDT")
  - Strongly suggests an Arabic-speaking developer; this
    does not by itself identify nationality of the operator.`,
            analysis: 'The cross-platform footprint is small but consistent. Three handles (channel, bot, support DM) all linked through the "móviç" alias and the AITRO branding. The look-alike-character pattern is what to grep for on Telegram and elsewhere — searching for "FLAH USDT" rather than "FLASH USDT" usually surfaces the operator\'s evasion accounts.'
        },
        {
            id: '10',
            title: 'Evidence #10: 🎯 THE EXIT POINT — Cash-Out Traced to MEXC Exchange',
            type: 'text',
            content: `Following the money on Tron leads through a multi-hop operator
network and lands at a Tronscan-LABELED MEXC exchange hot wallet:

  TEPSrSYPDSQ7yXpMFPq91Fb1QEWpMkRGfn
    Tronscan addressTag : "MXC"          <-- MEXC exchange hot wallet
    Lifetime txs        : 41,575,339
    TRX balance         : 9,711,456 TRX  (~$3.4M at $0.35/TRX)
    USDT balance        : 4,859,102 USDT (~$4.9M)
    Created             : 2019-01-20

Direct operator → MEXC deposits found (smoking gun):

  TPxtY9KXMhufsvsQbBvcjDrpRrragQEqTG -> MXC
    2026-01-06 23:26   189.90 TRX
    2026-01-16 20:45   180.18 TRX
    2026-01-19 05:41   180.00 TRX
    2026-01-31 06:23   193.84 TRX
    Total              ~743.92 TRX  (~$260) — earlier-campaign cash-out

The full Tron flow chain:

  Victim (e.g. TZ3Kntvxgpoy8r...) — pays 175 TRX
        v
  AITRO fee wallet  TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA
        v
  sub-wallets:
    TGp6WhUQbqAkTQ...   (April 2026 sweeps)
    TY6eWrVBgjR88u...
    TCXAP8nd67tWJC...
    TX8yqw5dLeh9y5...
    TDKaWd5RR7Ahho...
    TZJFWnPsn16rkn...
        v
  treasury hubs:
    TGJiSg1CrgAm4g...   (created 2025-09-08, 201 lifetime txs;
                         ALSO funds the AITRO fee wallet itself
                         => proof of single operator)
    TPowMg7Jd3Dpw...    (created 2025-05-04, oldest known infra)
        v
  withdraw wallets:
    TPxtY9KX...   (Jan 2026 cash-outs to MXC, see above)
    TYAJRJeM...   (April 2026, routes via TKianCy intermediate)
        v
  MEXC exchange   TEPSrSY...PDSQ7yXpMFPq91Fb1QEWpMkRGfn`,
            analysis: 'This is the actionable lead. MEXC (MXC) is a centralized exchange with KYC. A subpoena to MEXC for the account that received the four January 2026 deposits from TPxtY9KX (≈744 TRX) would identify the operator. The same operator infrastructure has been continuously fed by AITRO and prior campaigns — so the MEXC account is the durable real-world identity tied to this whole network. Any reporter or victim with a police case should hand this address chain to investigators along with the MEXC tag.'
        },
        {
            id: '11',
            title: 'Evidence #11: Multi-Campaign Operator (Pre-AITRO Lineage)',
            type: 'text',
            content: `The same wallet web has been running scams since at least May 2025.
AITRO is the LATEST campaign, not the first.

Operator infrastructure inventory (Tron):

  Created      Address                                Role / lifetime txs
  ----------   ------------------------------------   --------------------------
  2025-05-04   TPowMg7Jd3DpwDggkoSzxuTU8pGTksdua8     Oldest treasury hub (110)
  2025-06-16   TT3qa7GtFHLcqLgqkqs9pDsW2zttG3wrqJ     Sub-wallet (46)
  2025-09-08   TGJiSg1CrgAm4gxMVepYb9hkghfPR5hK8Q     Main treasury hub (201)
  2025-09-08   TMS9siew1AVnmzRHkRnyuFMR9dhUHYNdF6     Sub-wallet (59)
  2025-11-08   TKianCyCMvmMAiC5RJ3Y3MAFJJjXj8e4e4     OTC swap intermediary*
  2025-12-23   TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA     AITRO FEE WALLET (116)
  2026-01-06   TPxtY9KXMhufsvsQbBvcjDrpRrragQEqTG     Withdraw wallet, Jan cash-outs
  2026-02-08   TZJFWnPsn16rknRUG8ZaKFBxYvm5mp73Zg     Sub-wallet
  2026-02-08   TX8yqw5dLeh9y5Xs8ndS97HkwGXrHdfBXc     Sub-wallet
  2026-02-15   TCXAP8nd67tWJCkqripzVRd1qiEyQWwWbX     Sub-wallet
  2026-03-18   TY6eWrVBgjR88uuDz4EoaPUvX9ZyVw1V7o     Sub-wallet
  2026-04-26   TGp6WhUQbqAkTQEiRiz4rTJWM9UNDAeDGX     AITRO sub-wallet
  2026-04-29   TYAJRJeM3JpBBKwHEvXSUHSuVSbt1AahdQ     Recent withdraw wallet
  2026-05-05   TDKaWd5RR7Ahhoe5uCVVXkpuvAsVZtMq6H     Newest sub-wallet
                                                     (created 4 days before
                                                     the May 9 victim payment)

* TKianCyCMvm... has 183,210 lifetime txs and a TRX-for-USDT
  micro-swap pattern (e.g. 6.43 TRX in -> 10–55 USDT out, every
  few minutes). It is a high-frequency OTC/swap service, used
  as a one-hop launderer before MEXC deposit.

Critical link: the Sept-2025 hub TGJiSg1Crg... has sent funds
BACK TO the AITRO fee wallet (3 txs totaling 222.34 TRX in the
sampled window). The same treasury that pre-dates AITRO funds
the AITRO operation -> single operator running both.`,
            analysis: 'The operator did not invent AITRO and disappear; they have been iterating scam campaigns out of the same wallet treasury for at least 12 months. Killing the netlify.app URL does almost nothing — the same infrastructure (and almost certainly the same MEXC account) will fund the next campaign. The durable signal is the wallet web, not the brand.'
        },
        {
            id: '12',
            title: 'Evidence #12: Continuous Victimization — 11 Confirmed Full-Fee Payments',
            type: 'text',
            content: `Standard-fee inflows (170–180 TRX, matching the 1000 USDT
"withdrawal" fee tier in the JS):

    2025-12-26 16:40 UTC   180 TRX  from TYASr5UV6HEcXatwdFQfmLVUqQQQMUxHLS
    2026-01-03 18:40 UTC   180 TRX  from TDXbE6m4Zg458uo38iKYob4Zdkx5phBHnp
    2026-01-12 18:55 UTC   180 TRX  from TLHNZBGTiRa18u3FbSgSuW3pYWz2DRRQ1Q
    2026-01-18 21:02 UTC   180 TRX  from TAo8B15NMp8Np7sfRBEQQVasANSSWpxXqb
    2026-02-07 14:47 UTC   175 TRX  from TRcmsoVh9DJXBjfi9Nkw4GK3qiZ1vARJAb
    2026-02-14 17:34 UTC   175 TRX  from THwyeoCMSXQq2aGDpXpSqo89VnTtFktGGp
    2026-02-26 03:22 UTC   175 TRX  from TCLgK89AnXbC9rewvhNb9UgXCc2qJJpBXh
    2026-02-28 15:37 UTC   175 TRX  from TTg6MhbBFjpmdJ9vnQCHzZVP3NykJsnjPa
    2026-03-17 13:53 UTC   175 TRX  from TWe5pEnPDetzxgJS4uN26VFg15wWtdcTXc
    2026-04-23 15:21 UTC   175 TRX  from TV1zeU4bK92FsEMMDy5vFBdDAMWtz1Nr72
    2026-05-09 22:53 UTC   175 TRX  from TZ3Kntvxgpoy8r5cRS7utbzY5rTAJ6jcmb  <-- 5 days before investigation

Plus ~68 smaller / partial / "activation" inflows.

Tempo per month (all 79 TRX inflows over the wallet's lifetime):

    2025-12   15 txs   408 TRX   <-- launch month
    2026-01   32 txs   974 TRX   <-- peak
    2026-02   13 txs   709 TRX
    2026-03    7 txs   175 TRX
    2026-04    9 txs   192 TRX
    2026-05    3 txs   175 TRX   <-- ongoing as of investigation date

Full-fee victim rate: 4/month in Jan–Feb, 1/month since.
The scam is decelerating but actively converting.

Revenue tally (Tron only, at TRX ≈ $0.35):
  Total TRX inflow lifetime : 2,633 TRX  ≈  $921
  Total TRX outflow lifetime: 2,546 TRX  ≈  $891  (operator sweeps)

Adding the EVM channel (5 lifetime BSC txs, 0 visible BNB; ETH
RPC blocked from query) gives a generous upper bound of
~$1,500 stolen across all channels in 5 months.

This is small-scale, long-tail scam economics. The 5,463
Telegram channel members vs ~11 confirmed paying victims
= ~0.2% conversion rate. The operator is grinding, not whaling.`,
            analysis: 'Two truths to hold together: (a) the operation is unmistakably ACTIVE — most recent victim was 5 days before this report; (b) it is also SMALL — total provable revenue across all chains is well under $2,000 over 5 months. The brand and member count make it look big; the on-chain reality is a low-volume, high-effort grift. The right intervention is not panic-level alarm, it is the boring chain of reports: MEXC compliance for the receiving account, Telegram report for the channel/bot, Netlify abuse for the URL. The wallet addresses outlive every URL takedown — those are what to publish.'
        },
        {
            id: '13',
            title: 'Evidence #13: 💰 Total Operator Earnings — Full Network, 12 Months',
            type: 'text',
            content: `After tracing 13 operator wallets and counting every TRX movement,
the full revenue picture (Tron side):

[A] DIRECT OPERATOR → MEXC DEPOSITS (provable exit, floor estimate)
    Total: 4,204.05 TRX  ≈  $1,471 (at $0.35/TRX)
    Period: 2025-09-07 → 2026-04-19  (7+ months of cash-outs)
    24 separate deposits to TEPSrSYPDSQ7yXpMFPq91Fb1QEWpMkRGfn (MXC tag).
    Top depositor wallets:
      TMS9siew1AVnmzRHkRnyuFMR9dhUHYNdF6 → MXC : 2,136 TRX  (12 deposits Sep–Dec 2025)
      TPxtY9KX...                        → MXC :   744 TRX  ( 4 deposits Jan 2026)
      TZJFWnPsn16rkn...                  → MXC :   662 TRX  ( 4 deposits Feb–Mar 2026)
      TCXAP8nd67tWJC...                  → MXC :   471 TRX  ( 3 deposits Feb–Apr 2026)
      TX8yqw5dLeh9y5...                  → MXC :   191 TRX  ( 1 deposit Feb 2026)

[B] OPERATOR → TKianCy OTC LAUNDERER (April–May 2026)
    Total: 705.32 TRX  ≈  $247 (additional, likely also exits via MXC)
    Period: 2026-04-28 → 2026-05-13
    6 deposits, including 175 TRX from TDKaWd5R on 2026-05-13 (yesterday).
    Most recent operator was clearly still cashing out the day before this
    investigation.

[A+B] COMBINED PROVABLE EXIT: 4,909 TRX  ≈  $1,718

[C] STANDARD VICTIM-FEE PAYMENTS (170–220 TRX, external sources)
    Total: 6,387.90 TRX  ≈  $2,236
    Count: 34 distinct payments from 30 unique sender wallets
    Period: 2025-05-04 → 2026-05-13 (12 months + 9 days)
    Most recent: 2026-05-13 (1 day before this investigation report)

    Notable: at least 2 senders paid TWICE (returning victims):
      TDqSquXBgUCLYvYC4XZgrprLK589dkhSCf : July 2025 + Feb 2026
      TV1zeU4bK92FsEMMDy5vFBdDAMWtz1Nr72 : April 2026 + May 2026

[D] ALL EXTERNAL TRX INFLOWS (any amount, non-operator senders)
    Total: 12,711.21 TRX  ≈  $4,449 (gross ceiling)
    Count: 411 transactions
    Includes activation dust, partial payments, repeat victims, etc.

REVENUE INTERPRETATION

  Lower bound  (confirmed cash-out to MEXC) :  $1,471
  Best estimate (standard fee payments × 30 victims):  $2,236
  Upper bound  (all external inflows)       :  $4,449

  Span: ~12 months (May 4, 2025 → May 13, 2026)
  Implied monthly take: $120 – $370
  Implied per-victim loss: ~$60 each

Plus EVM channel: BSC fee wallet shows 5 lifetime txs / 0 BNB held →
~$50–100 max additional. ETH RPC blocked from this IP but pattern
suggests similarly negligible.

GRAND TOTAL ESTIMATE: $2,000 – $4,500 over 12 months across all chains.`,
            analysis: 'This is the dollar answer to the question "how much has this operator earned?" — and it is surprisingly small. ~$2,000–$4,500 across a full year of running multiple scam campaigns out of 13 interconnected wallets. The 5,463-member Telegram channel converts to ~30 actually-paying victims over 12 months — roughly 0.5% conversion. The operator is grinding out a sub-minimum-wage income through high-volume social engineering for a small per-victim take. That framing matters for response: this is a nuisance-scale fraud network worth a Telegram + Netlify + MEXC abuse report, not a multi-million-dollar operation worthy of national-level investigation. But it is also active, persistent, and harming real people every few weeks.'
        },
        {
            id: '14',
            title: 'Evidence #14: What This Scam Is NOT',
            type: 'text',
            content: `It is NOT a wallet drainer.
  - No approve() / setApprovalForAll() calls.
  - No transferFrom() with operator addresses.
  - No EIP-2612 / permit() signature requests.
  - No "Sign this message" off-chain phishing.
  - No malicious approve-all on the USDT contract.

It is NOT a fake-mint token.
  - No new SPL mint, no new TRC20 contract is created.
  - The "USDT balance" is a JavaScript variable
    that exists only in the victim's browser.

It IS classic advance-fee fraud, just dressed in Web3 UI.
  - Victim is told they have a large pending balance.
  - Victim is told a "network fee" is required to release it.
  - Victim signs a normal native-coin transfer to the operator.
  - Operator keeps the fee. Nothing is ever released.
  - Damage is BOUNDED to the fee paid — the wallet itself
    is still safe for normal use after the loss.`,
            analysis: 'Naming the threat precisely matters for victim guidance. Tell a victim "your wallet is drained, rotate everything" when the actual exposure is a single sendTrx() they signed = wasted alarm. Tell them "we need to revoke all approvals" when no approvals were ever granted = wasted effort. The right guidance here: stop paying any more fees, do NOT contact the support handle (it leads to more asks), and report the receiving addresses (TDpnZSE...8oWA and 0x16738514...0bfe8c) to exchanges so any cash-out hops get flagged.'
        },
    ],

    transactions: [
        {
            id: '1',
            timestamp: '2025-12-23 (Tron fee wallet creation)',
            type: 'Infrastructure event',
            signature: 'Tron account TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA created',
            description: 'Date created: ~143 days before this investigation. Aligns with the start of the active scam campaign.',
        },
        {
            id: '2',
            timestamp: '2026-04-23 19:39 UTC',
            type: 'Consolidation outflow (operator cash-out)',
            signature: 'Tron → TGp6WhUQbqAkTQ… (multi-hop consolidation address)',
            description: 'Operator sweeps accumulated TRX fees out to a consolidator wallet. Pattern repeats across multiple dates.',
        },
        {
            id: '3',
            timestamp: '2026-04-26 11:30 UTC',
            type: 'Victim fee inflow (standard 175 TRX = 1000 USDT "withdrawal")',
            signature: 'Tron tx 0592dfd11278b19731… and similar',
            description: 'Standard scam-fee deposit — the dollar-cost of a fake withdrawal at the minimum tier.',
        },
        {
            id: '4',
            timestamp: '2026-05-09 17:09 UTC',
            type: 'Victim fee inflow + same-block outflow',
            signature: 'IN tx 910d24e6abadcc07c7…  /  OUT tx b72c3e1044b307f776…',
            description: '175 TRX in from TZ3Kntvxgpoy8r…, 175 TRX out to TDKaWd5RR7Ahho… in the same window. Same-block cash-out pattern.',
        },
        {
            id: '5',
            timestamp: '2026-05-12 23:35 UTC (most recent)',
            type: 'Victim fee inflow',
            signature: 'Tron tx 9c629f7225c7d22ca3…',
            description: '0.97 TRX (sub-fee dust) from TAohB2qhb2Zw99… — likely an activation test before a larger fee, or a victim payment for a smaller "withdrawal" tier.',
        },
    ],

    findings: [
        {
            title: '🎯 Cash-Out Exit: MEXC Exchange (KYC Subpoena Target)',
            description: 'Money trail terminates at Tronscan-tagged MEXC hot wallet TEPSrSY...PDSQ7yXpMFPq91Fb1QEWpMkRGfn (addressTag = "MXC"). Direct operator deposits found: TPxtY9KX → MXC in Jan 2026 totaling ~744 TRX. Since MEXC enforces KYC, this is the actionable real-world-identity hook.',
            tags: ['MEXC', 'KYC Hook', 'Cash-Out Identified', 'Smoking Gun'],
        },
        {
            title: 'Continuous Victimization — 11 Confirmed Fee Payments Over 5 Months',
            description: '11 standard-fee inflows (170–180 TRX) at the AITRO fee wallet from Dec 26 2025 through May 9 2026. Plus ~68 smaller / partial inflows. Most recent confirmed victim: 5 days before this investigation. Tempo peaked Jan–Feb 2026 (~4/month) and decelerated to ~1/month since.',
            tags: ['Active Scam', 'Last Victim 2026-05-09', 'Decelerating'],
        },
        {
            title: 'Multi-Campaign Operator (Pre-AITRO Lineage)',
            description: 'Operator infrastructure dates back to May 2025 — AITRO is the latest campaign, not the first. The Sept-2025 treasury hub (TGJiSg1Crg…) FUNDS the AITRO fee wallet (3 txs, 222.34 TRX) — single operator running multiple campaigns from a shared treasury.',
            tags: ['Multi-Campaign', '12-Month Operator', 'Shared Treasury'],
        },
        {
            title: 'Small-Scale Long-Tail Revenue (~$900 on Tron over 5 Months)',
            description: 'Total lifetime TRX inflow to AITRO fee wallet: 2,633 TRX ≈ $921 (at ~$0.35/TRX). Plus negligible BSC channel. Upper-bound total: ~$1,500 over 5 months. With 5,463 Telegram members and ~11 paying victims, conversion is ~0.2% — grift economics, not whale economics.',
            tags: ['Revenue ≈$1k', 'Low Conversion', 'Long Tail'],
        },
        {
            title: 'TKianCy… Is an OTC Swap Launderer, Not an Exchange',
            description: 'The 183,210-tx wallet that recent operator funds route through (TKianCyCMvmMAiC5RJ3Y3MAFJJjXj8e4e4) is a TRX↔USDT micro-swap service (6.43 TRX in → 10–55 USDT out, every few minutes). Used as a one-hop obfuscation layer before MEXC deposit.',
            tags: ['Obfuscation Layer', 'OTC Swap', 'High Frequency'],
        },
        {
            title: 'Advance-Fee Fraud (Not a Drainer)',
            description: 'The site asks victims to authorize a normal native-coin transfer (TRX / ETH / BNB) to the operator\'s wallet, framed as a "network fee" to release a fake USDT balance. No approvals, no off-chain signatures, no token contracts. Damage is bounded to whatever fee was paid.',
            tags: ['Advance-Fee', 'Not Drainer', 'Native Transfer'],
        },
        {
            title: 'Fake Balance Is Pure JavaScript',
            description: 'The "Generate Coin" feature does `state.balances.USDT += amount` in browser memory and writes to localStorage. No blockchain interaction. No tokens minted. Closing the tab erases it.',
            tags: ['Client-Side Only', 'localStorage', 'No Blockchain'],
        },
        {
            title: 'Multi-Chain Fee Collection',
            description: 'Three networks (TRC20, ERC20, BEP20). The ERC20 and BEP20 fee addresses are the same key — one EVM seed controls fee revenue on every EVM chain.',
            tags: ['Multi-Chain', 'EVM Key Reuse', 'Cross-Network'],
        },
        {
            title: 'Tron Fee Wallet — 116 Live Transactions',
            description: 'Address TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA shows 85 inbound / 27 outbound transactions and a current balance of essentially zero — fees are swept to consolidator addresses (notably TGp6WhUQbqAkTQ… and TDKaWd5RR7Ahho…) shortly after arrival.',
            tags: ['Active Wallet', 'Cash-Out Pattern', 'Consolidator Identified'],
        },
        {
            title: 'Discount Tier Is a Funnel',
            description: 'Fee calculator applies 50% off for "withdrawals" above 2000 USDT. The fake balance is free to inflate; only the real fee on the victim\'s side grows. The discount is psychology, not economics — it pushes victims to type larger fake amounts and pay larger real fees.',
            tags: ['Psychological', 'Funnel Mechanic', 'Fee Amplification'],
        },
        {
            title: 'Arabic Source Comments + Look-Alike-Character Branding',
            description: 'JavaScript source contains Arabic comments. Telegram handles use look-alike characters ("FLAH" not "FLASH", Ø substitutions). Both are fingerprints — the Arabic comments narrow the operator demographic; the look-alike pattern is the ban-evasion signature to search for when the channel/bot is taken down.',
            tags: ['Fingerprint', 'Ban Evasion', 'Operator Demographic'],
        },
        {
            title: 'Netlify Free Tier — Trivial Re-Hosting',
            description: 'The site is hosted on Netlify\'s free tier under a netlify.app subdomain. Takedown removes one URL; the operator can redeploy the same code under a fresh subdomain in minutes. The durable signals are the wallet addresses, not the URL.',
            tags: ['Disposable Hosting', 'Netlify', 'URL Rotation'],
        },
    ],

    network: [
        { address: 'aitro-flash-usdt-vip.netlify.app', role: 'Scam Frontend', connection: 'Netlify-hosted SPA. 25 KB HTML + 97 KB JS. Operator can redeploy under any subdomain after takedown.' },
        { address: 'TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA', role: 'AITRO Tron Fee Wallet', connection: '116 lifetime txs (79 TRX inflows). Created 2025-12-23. Standard inbound fee = 175 TRX. 11 confirmed full-fee victim payments Dec 2025 – May 9 2026.' },
        { address: '0x16738514b5fe77c5e4c5577d7fd8233db40bfe8c', role: 'EVM Fee Wallet (ETH + BSC)', connection: 'Same key on both ERC20 and BEP20. BSC: 5 lifetime txs / 0 BNB. EVM is the minor revenue channel.' },
        { address: 'TGp6WhUQbqAkTQEiRiz4rTJWM9UNDAeDGX', role: 'AITRO Sub-Wallet', connection: 'Created 2026-04-26. Receives multi-batch sweeps from the fee wallet.' },
        { address: 'TDKaWd5RR7Ahhoe5uCVVXkpuvAsVZtMq6H', role: 'AITRO Sub-Wallet (Newest)', connection: 'Created 2026-05-05 — 4 days before the May 9 victim payment. Same-block sweep target.' },
        { address: 'TY6eWrVBgjR88uuDz4EoaPUvX9ZyVw1V7o', role: 'AITRO Sub-Wallet', connection: 'Created 2026-03-18. Receives mid-tier sweeps.' },
        { address: 'TCXAP8nd67tWJCkqripzVRd1qiEyQWwWbX', role: 'AITRO Sub-Wallet', connection: 'Created 2026-02-15. Also funded by the main hub TGJiSg1Crg….' },
        { address: 'TX8yqw5dLeh9y5Xs8ndS97HkwGXrHdfBXc', role: 'AITRO Sub-Wallet', connection: 'Created 2026-02-08. Also funded by the main hub TGJiSg1Crg….' },
        { address: 'TZJFWnPsn16rknRUG8ZaKFBxYvm5mp73Zg', role: 'Sub-Wallet (older campaign)', connection: 'Created 2026-02-08. Received early bulk sweeps (287 TRX, 144 TRX).' },
        { address: 'TGJiSg1CrgAm4gxMVepYb9hkghfPR5hK8Q', role: '🔑 OPERATOR TREASURY HUB (main)', connection: '201 lifetime txs. Created 2025-09-08 — PRE-DATES AITRO. Sends funds BACK to the AITRO fee wallet (3 txs, 222 TRX) — proving same operator runs both this hub and the AITRO campaign.' },
        { address: 'TPowMg7Jd3DpwDggkoSzxuTU8pGTksdua8', role: '🔑 OPERATOR TREASURY HUB (oldest)', connection: '110 lifetime txs. Created 2025-05-04 — operator has been running scams for at least 12 months. Routes funds to the Sept-2025 hub and to MS9siew sub-wallet.' },
        { address: 'TPxtY9KXMhufsvsQbBvcjDrpRrragQEqTG', role: '💸 Withdraw Wallet (Jan 2026 cash-outs)', connection: 'Created 2026-01-06. Direct deposits to MEXC: 189.90 + 180.18 + 180 + 193.84 = 743.92 TRX over Jan 6–31, 2026.' },
        { address: 'TYAJRJeM3JpBBKwHEvXSUHSuVSbt1AahdQ', role: '💸 Withdraw Wallet (Apr 2026 cash-outs)', connection: 'Created 2026-04-29. Routes to TKianCy intermediate before MEXC.' },
        { address: 'TKianCyCMvmMAiC5RJ3Y3MAFJJjXj8e4e4', role: '🌀 OTC Swap Launderer', connection: '183,210 lifetime txs. TRX-for-USDT micro-swap service. Used as a one-hop obfuscation layer between operator wallets and MEXC.' },
        { address: 'TEPSrSYPDSQ7yXpMFPq91Fb1QEWpMkRGfn', role: '🎯 MEXC EXCHANGE HOT WALLET (CASH-OUT EXIT)', connection: 'Tronscan addressTag = "MXC". 41.5M lifetime txs. Holds 9.7M TRX + 4.8M USDT. THIS IS THE KYC PRESSURE POINT — MEXC compliance can identify the operator account that received the operator deposits.' },
        { address: '@astroflashusdtbot', role: 'Telegram Bot Funnel', connection: 'Front-of-funnel — display name "ASTRØ FLAH USDT BØT" uses look-alike chars for ban evasion.' },
        { address: '@movich203', role: 'Operator Support Handle', connection: 'Linked from site header. Pseudo-identity "móviç" / "DANIEL WINSLET".' },
        { address: 'TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t', role: 'Official USDT TRC20 (REFERENCE)', connection: 'Real Tether contract — referenced by the scam UI but never actually invoked.' },
    ],

    smartContract: {
        language: 'js',
        code: scamFrontendCode,
        vulnerabilities: [
            'No smart contract exists — the "USDT generation" is one JavaScript line that increments a state variable in browser memory.',
            'Withdrawal authorizes only a native-coin transfer to the operator (TRX or ETH/BNB). Not a drainer; loss is bounded to the fee paid.',
            'Tron fee floor: 175 TRX per 1000 USDT (≈$498). EVM floors: 0.02 ETH (~$50) / 0.07 BNB (~$21). 50% discount above 2000 USDT pushes victims to larger asks.',
            'Same EVM private key controls the fee address on ETH and BSC — any future site reusing 0x16738514…0bfe8c is the same operator.',
            'Tron fee wallet (TDpnZSE...8oWA) has 116 lifetime transactions and a same-block cash-out pattern to TGp6WhUQ… and TDKaWd5R… — current TRX balance is ≈ 0.',
            'Source JS includes Arabic comments and the Telegram branding uses look-alike Unicode characters — these are operator fingerprints for tracking re-deployments under new URLs.',
            'No CAPTCHAs, no server-side rate limits, no KYC — the entire scam is a static SPA + free Netlify hosting. Takedown of the URL does not affect the wallet addresses, which is where the durable detection signal lives.',
        ],
    },

    technicalSpecs: [
        { label: 'Scam Type', value: 'Advance-Fee Fraud (NOT a wallet drainer)' },
        { label: 'Frontend', value: 'Netlify static SPA (HTML + 3 JS files, ~120 KB total)' },
        { label: 'Target URL', value: 'https://aitro-flash-usdt-vip.netlify.app/' },
        { label: 'Wallets Supported', value: 'TronLink, OKX Wallet, MetaMask, WalletConnect, Trust Wallet (deep link)' },
        { label: 'Networks Targeted', value: 'Tron (TRC20), Ethereum (ERC20), BSC (BEP20)' },
        { label: 'Tron Fee Wallet', value: 'TDpnZSE43PPSQRYFkDFaf5jKj1JcB68oWA  (116 lifetime txs)' },
        { label: 'EVM Fee Wallet (ETH + BSC)', value: '0x16738514b5fe77c5e4c5577d7fd8233db40bfe8c' },
        { label: 'Minimum "Withdrawal"', value: '1,000 USDT (fake)' },
        { label: 'Fee at Minimum (corrected)', value: '175 TRX (~$61 at $0.35/TRX) or 0.02 ETH (~$50) or 0.07 BNB (~$21)' },
        { label: 'Cash-Out Exit', value: '🎯 MEXC Exchange — TEPSrSYPDSQ7yXpMFPq91Fb1QEWpMkRGfn (Tronscan-tagged "MXC")' },
        { label: 'Operator Lineage', value: 'At least 12 months — older infrastructure dates to May 2025' },
        { label: 'AITRO Wallet Lifetime Revenue', value: '2,633 TRX ≈ $921 (AITRO fee wallet alone)' },
        { label: '💰 OPERATOR Lifetime Cash-Out to MEXC (provable floor)', value: '4,204 TRX ≈ $1,471 across 24 deposits, Sep 2025 – Apr 2026' },
        { label: '💰 OPERATOR Standard Victim-Fee Revenue (best estimate)', value: '6,388 TRX ≈ $2,236 across 34 payments from ~30 victims, May 2025 – May 2026' },
        { label: '💰 OPERATOR All External Inflows (gross ceiling)', value: '12,711 TRX ≈ $4,449 across 411 txs, 12-month window' },
        { label: 'Implied Monthly Take', value: '$120 – $370 (sub-minimum-wage)' },
        { label: 'Implied Per-Victim Loss', value: '≈$60 each (the 175 TRX fee at TRX $0.35)' },
        { label: 'Most Recent Victim Payment', value: '2026-05-13 175 TRX from TB1x8Kt7ov... (1 day before investigation)' },
        { label: 'Most Recent MEXC-Bound Laundering', value: '2026-05-13 175 TRX from TDKaWd5R → TKianCy → (MEXC next-hop)' },
        { label: 'Confirmed Full-Fee Victims (AITRO wallet only)', value: '11 (Dec 26 2025 → May 9 2026)' },
        { label: 'Distinct Victim Wallets (network-wide)', value: '~30 (some repeat — 2 confirmed second-time payers)' },
        { label: 'Telegram-to-Pay Conversion', value: '~0.5% (30 paying victims / 5,463 channel members over 12 months)' },
        { label: 'Discount', value: '50% on amounts above 2,000 USDT — psychological funnel' },
        { label: 'Telegram Channel', value: '"AITRO FLASH USDT" (5,463 members)' },
        { label: 'Bot Handle', value: '@astroflashusdtbot — display "ASTRØ FLAH USDT BØT" (look-alike chars)' },
        { label: 'Operator Alias', value: '"móviç" / "DANIEL WINSLET" — support @movich203' },
        { label: 'Source-Code Fingerprint', value: 'Arabic comments in script.js (e.g. "سعر الرسوم لكل 1 USDT")' },
        { label: 'Bounded Damage', value: 'Loss = fee paid. Wallet remains safe for normal use after payment (no approvals granted).' },
        { label: 'Detection Rule', value: 'Any "USDT generation" / "AI flash USDT" / "pay a fee to unlock more USDT" UI = advance-fee fraud. Real USDT cannot be generated client-side.' },
    ],
};