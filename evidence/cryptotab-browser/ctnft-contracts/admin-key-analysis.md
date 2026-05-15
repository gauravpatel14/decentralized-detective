# Admin / owner key analysis

Three distinct admin EOAs control the eight CTNFT contracts. All are EOAs (no `eth_getCode` bytecode). None is a Gnosis Safe / multisig.

## 1. `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` — primary CTNFT operator key

| Property | Value |
|---|---|
| Type | EOA |
| Polygonscan tag | **"The Legend of CryptoTab: Deployer"** (public verified tag) |
| Polygon txs | 7 930 |
| Ethereum txs | 306 |
| Current balance | $74.75 (across 3 chains: ETH, Polygon, and one other small balance) |
| Contracts controlled (owner) | B1 ETH `0xEE9BF4d9…`, B2 Polygon `0x73f9ea50…`, B3 `0x783676df…`, B4 `0xee0920db…`, B6 `0x58314ad8…` |
| Number of contracts controlled | 5 of 8 |
| Activity pattern | Constant low balance — funds in / funds out, indicates an automated hot wallet |

### Cross-reference with Phase 3 findings

Phase 3 documented the CryptoTab Browser custodial BTC hub `bc1qqy6097…`. That is a Bitcoin segwit address; this Ethereum/Polygon EOA cannot be the same key (different curve). No textual link between the two addresses has been found in CTNFT's published metadata.

However, the *operational pattern* is identical:
- Single hot wallet receives all NFT-deploy and primary-sale revenue.
- Funds are swept out within hours of arrival (consistent with low static balance).
- No multisig — one private key controls all NFT primary-sale and royalty redirection.

This matches the Cryptocompany OÜ playbook: every product runs from a single operator-controlled key on the relevant chain.

### Risk profile

If `0xcda31ef0…` is compromised, an attacker can:
1. Mint unlimited additional NFTs across 5 collections.
2. Redirect `primarySaleRecipient` and `royaltyRecipient` to siphon all future sale and royalty revenue.
3. Sign off-chain `MintRequest`s for zero-price mints to themselves (and immediately list on OpenSea/Rarible).

What they **cannot** do:
- Steal existing NFTs from current holders (transfers still go through ERC-721/1155 ownership checks).
- Drain any TVL from the contracts (they hold $0).

The financial blast radius is bounded by ongoing CTNFT primary-sale flow + secondary-market royalties. Given low on-chain volume (see `economic-attack-surface.md`), that is **not a high-value target** for a key-theft attack — well under five figures USD per month, ballpark.

## 2. `0x18e2883864abd904ac88db3a792fddab731e16be` — secondary admin

| Property | Value |
|---|---|
| Type | EOA |
| Polygonscan tag | (none) |
| Polygon txs | **2** |
| Ethereum txs | 0 |
| Balance | <$1 |
| Contracts controlled (owner) | B5 `0x8a705160…` (CryptoTab Collectables), B7 `0xea2b5048…` (CryptoTab Live Eggs) |

This key has executed exactly **2 transactions on Polygon, ever**. Almost certainly used only to call `setOwner()` after a deployment was transferred to this address. Could be a cold key that they "rotated to" for these two collections, or a stale signer that was never properly used.

Risk: medium — same single-EOA pattern. The fact that it has 2 lifetime txs means it has not been used administratively for a long time. It might be a "burn-in-place" admin key (set and forgotten).

## 3. `0x7951c1be03de17fb7616e05c5a515cc705db2787` — B8 admin (Rarible-proxy collection)

| Property | Value |
|---|---|
| Type | EOA |
| Polygonscan tag | (none) |
| Polygon txs | 2 176 |
| Ethereum txs | 0 |
| Balance | <$1 |
| Contracts controlled (owner) | B8 `0x3b10994f…` (Love Vibes by CryptoTab — the EIP-1167 proxy) |

This is **not** the same admin as the other CTNFT contracts. It is the EOA used by **thirdweb's NFT-collection factory** when deploying via thirdweb's web dashboard — or, less likely, a CTNFT staff member's own deployer key. Activity (2 176 txs) suggests an active dashboard user.

Since this key controls **only B8** — which uses thirdweb's hosted minimal-proxy pattern — and B8 has a different `_owner` from B1–B7, this collection was deployed by a **different process / different person** than the others. Could be:

- An employee who used thirdweb's no-code dashboard while the rest of the team deployed direct.
- A test deployment that was later marketed.
- An outsourced agency / contractor's wallet.

Without further OSINT (Twitter, GitHub) we cannot attribute this EOA to a specific person.

## Has any admin key ever been rotated?

Reading the on-chain history of each contract for `OwnerUpdated` events (thirdweb emits this in `setOwner`): not directly checked in this round due to the lack of an API key for `eth_getLogs` over a wide range on the free RPC tier. From inspection of the admin EOAs' tx counts, `0x18e2…` has only 2 lifetime txs — consistent with **no rotation** ever having occurred on its contracts. `0xcda31e…` and `0x7951c1…` have heavier histories but most txs are mint events or marketplace approvals, not admin rotations.

**Conclusion**: no evidence of key hygiene (no multisig, no rotation, no role separation). This is consistent with the rest of the Cryptocompany OÜ portfolio's "operator-key-runs-everything" model.

## Is the admin a known address (e.g. tagged on Etherscan)?

- `0xcda31ef0…`: tagged **"The Legend of CryptoTab: Deployer"** on Polygonscan. No tag on Etherscan.
- `0x18e2…`: no public tag on any explorer.
- `0x7951c1…`: no public tag on any explorer.

`0xcda31ef0…` is therefore the de-facto **public** CTNFT operator key. It would be the natural address for a responsible-disclosure e-mail to reference if a code bug were ever found.
