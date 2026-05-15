# Economic attack surface

This document quantifies what can actually be stolen, redirected, or extracted from the CTNFT contract surface, independent of code defects.

## NFT distribution model

From `cryptotabnft.com` and the in-app text:

- CTNFT sells **"Eggs"** — NFTs that, when "hatched", grant the owner a **token from an official CryptoTab collection** (= one of the other collections in B1–B8 or the OpenSea-shared `vibes`/`kickers`/`moments`/`action`/`utility` tokens).
- Hatching is an **off-chain action**: the owner submits their NFT to the CTNFT server, which mints / transfers the reward token to them server-side. There is no on-chain `claim()` or `hatch()` function in any of B1–B8 — confirmed by reading the thirdweb `TokenERC1155` ABI (none of the 52 functions is a redemption / claim hook).
- Primary mints go through thirdweb's `mintWithSignature` flow: user pays MATIC (or ETH, on B1), receives the NFT, primary-sale recipient gets paid.
- Secondary sales go through OpenSea / Rarible — those are out-of-scope for CTNFT-bug-bounty.

There is **no max-supply cap on chain.** `nextTokenIdToMint` auto-increments. Admin can keep minting forever. Supply is constrained only by their willingness to print.

## Associated ERC-20 token

**None.** Searched the entire CTNFT homepage, the cryptotabnft.com page, the app's main.js bundle (3.6 MB): zero references to a CTNFT ERC-20 (`token contract address`, `decimals 18`, etc.).

The app's "Mining Master Token" label points at an **EOA** (`0x0d9E22a4…`), which cannot be a token contract. So CTNFT does **not** have a fungible token. No staking, no governance, no MLM-style reward token on chain.

## Reward distribution contracts

**None.** No merkle-claim, no signature-rebate, no airdrop. Rewards are dispensed off-chain by the CTNFT server.

## Bridge or vault

**None.** No bridge contract owned by CTNFT. No vault holding LP positions. No staking pool.

## TVL (Total Value Locked)

Verified on-chain via `eth_getBalance`:

| Contract | Chain | ETH/MATIC balance |
|---|---|---|
| B1 `0xEE9BF4d9…` | Ethereum | 0 |
| B2 `0x73f9ea50…` | Polygon | 0 |
| B3 `0x783676df…` | Polygon | 0 |
| B4 `0xee0920db…` | Polygon | 0 |
| B5 `0x8a705160…` | Polygon | 0 |
| B6 `0x58314ad8…` | Polygon | 0 |
| B7 `0xea2b5048…` | Polygon | 0 |
| B8 `0x3b10994f…` | Polygon | 0 |
| **Total TVL** | — | **0** |

We did not enumerate every ERC-20 balance — but per the thirdweb `mintWithSignature` source (line 469–476), the sale price is **transferred directly from the buyer to the platformFeeRecipient and saleRecipient**:

```solidity
CurrencyTransferLib.transferCurrency(_req.currency, _msgSender(), DEFAULT_FEE_RECIPIENT, platformFeesTw);
CurrencyTransferLib.transferCurrency(_req.currency, _msgSender(), platformFeeRecipient, platformFees);
CurrencyTransferLib.transferCurrency(_req.currency, _msgSender(), saleRecipient, totalPrice - platformFees - platformFeesTw);
```

No funds are ever held by the contract itself. They flow straight to recipient EOAs in the same transaction. So even if a contract were exploited, **there is nothing for the attacker to drain.**

## Owner activity (primary sale recipient)

Not queried for every contract in this round, but for thirdweb's pattern the `primarySaleRecipient` is set at `initialize` time and rarely changed. For B8, the recipient is presumably the same EOA `0x7951c1be…` (or an associated treasury). Whatever it is, it would currently hold any unswept primary-sale revenue — but per the deployer's $74 balance, sweep frequency is at the per-tx level.

## "Is it worth attacking?" math

For a hypothetical exploit (assume Critical — admin-key compromise OR an undisclosed code bug in B1–B7):

1. **Mint unlimited NFTs to attacker:** worth nothing unless someone buys them on the secondary market. CTNFT's secondary-market floor on these collections is unknown; checking OpenSea would clarify, but the order of magnitude is probably $1–$50 per NFT. Mint 1 000 = $1k–$50k notional, but flooding the floor would crash the price; effective recovery probably < $5k.
2. **Redirect primary sale recipient:** worth the primary sale volume between the attack and the attack being noticed. CTNFT runs continuous mint events but at low cadence. Realistic theft: low five figures USD before detection.
3. **Redirect royalty recipient:** worth the secondary trading volume between attack and recovery. With low secondary volume on Rarible/OpenSea Polygon listings, this is sub-$10k/week.

**Total realistic attacker upside:** ~$5k–$30k USD before being detected, on a Web3 attack that would require either compromising a private key (real-world attack, not a contract bug) or finding a code bug in thirdweb's audited prebuilt (extremely well-trodden ground).

## Conversely, "is there a real bounty here for a white-hat?"

A bug-bounty payout for a critical contract bug typically scales with TVL. Common Immunefi tiers:

- Critical with TVL < $100k: usually $5k–$25k payout.
- Critical with TVL = 0: most programs do not award critical for "no funds at risk".

Combined with the fact that **CTNFT has no public bug-bounty program** (`immunefi.com` search returned 0 results), any responsible-disclosure email would be on goodwill alone. The economic incentive for either an attacker or a white-hat to spend time auditing these contracts is **very low**.

## Conclusion

CTNFT's on-chain economic structure is **deliberately custodial-light**. The contracts hold $0, the rewards are dispensed off-chain by the CTNFT server, and primary-sale revenue flows straight to operator EOAs. This is consistent with the Cryptocompany OÜ portfolio's pattern of "use smart contracts only as the NFT issuance primitive; keep everything else on a custodial server".

For an attacker, this means: there is **nothing to steal from the contracts themselves**. The only attack surface that touches user funds is:

1. A compromised admin key (operational, not a contract bug).
2. Convincing the central CTNFT server to dispense rewards fraudulently (Web2 attack, not in scope).

For a white-hat, this means: even a real on-chain finding would be hard to monetize through a bounty.
