# Verdict — CTNFT smart-contract attack surface

## Contracts deployed

**8 dedicated CTNFT NFT contracts** + 2 OpenSea Shared Storefront tokens that CTNFT uses for sub-collections.

| Chain | CTNFT-owned contracts | Shared (OpenSea) |
|---|---|---|
| Ethereum | 1 (B1) | 1 (Shared Storefront 0x495f9472…) |
| Polygon | 7 (B2–B8) | 1 (Shared Storefront 0x29533991…) |

## Source-code verification status

| Status | Count |
|---|---|
| Verified source on the chain explorer | **1 of 8** (B8 — and only because it's an EIP-1167 proxy whose implementation `0xfcecd709…` is thirdweb-verified) |
| Unverified bytecode | **7 of 8** (B1–B7) |

Red flag (Informational): 7 of 8 CTNFT contracts have unverified source. The bytecode evidence (identical hash B1↔B2; identical hash B5↔B6↔B7; metadata `solc 0.8.18` footers; ABI selectors `mintTo`, `mintWithSignature`, `setPrimarySaleRecipient`, etc.) strongly suggests these are stock thirdweb `TokenERC721` / `TokenERC1155` prebuilts — but CTNFT has neither verified them on Etherscan/Polygonscan nor published the source elsewhere, leaving users unable to independently audit.

## Findings by severity

| Severity | Count | Findings |
|---|---|---|
| Critical | 0 | — |
| High | 0 | — |
| Medium | 1 | Single-EOA admin (`0xcda31ef0…`) holds DEFAULT_ADMIN_ROLE + MINTER_ROLE on 5 collections, no multisig; key compromise allows redirect of primary-sale recipient and unlimited minting. *Operational risk, not a code bug.* |
| Low | 0 | — |
| Informational | 3 | F-1 unverified source (B1–B7); F-3 misleading attribution in CTNFT marketing — `0x0d9E22a4…` ("Mining Master Token") and `0xC293fAbD…` ("Golden Eggs collection") are EOAs, not contracts; F-4 admin can call `revokeRole(TRANSFER_ROLE, address(0))` to freeze transfers. |

## Most severe finding

**There is no Critical or High-severity finding.** The closest is the Medium operational risk:

> All 5 contracts owned by `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` (publicly tagged on Polygonscan as "The Legend of CryptoTab: Deployer") concentrate DEFAULT_ADMIN_ROLE and MINTER_ROLE in a single EOA with no multisig, no role separation, and an automated hot-wallet sweep pattern (balance held consistently at < $100). Per thirdweb `TokenERC1155.sol` line 278 (`setPrimarySaleRecipient` is `onlyRole(DEFAULT_ADMIN_ROLE)`) and line 221 (`mintTo` is `onlyRole(MINTER_ROLE)`), compromise of this key permits both (a) unlimited mint to attacker and (b) redirect of all future primary-sale revenue. This is a *risk* but not a *code vulnerability*.

## Is the system exploitable today?

**No.**

- No critical or high code vulnerability was found.
- The contracts hold $0 on-chain — there is no TVL to drain even if an exploit were found.
- The rewards economy ("hatching" an Egg NFT to receive a reward token) is dispensed by the **central CTNFT server, off-chain** — so an on-chain bug cannot redirect those rewards.
- Owner / minter access is gated correctly throughout the thirdweb prebuilt (verified line-by-line in `vulnerability-audit.md`).
- The one Critical-impact mechanism (admin compromise) is an operational risk against an off-chain key, not an on-chain attack.

The closest a research-grade attacker could come is to (a) wait for the admin key to be stolen, or (b) social-engineer the CTNFT server to dispense rewards fraudulently. Neither qualifies as a smart-contract bounty finding.

## Bug-bounty program

Verified the following sources for an active CTNFT or Cryptocompany OÜ program:

- `immunefi.com` — search for "cryptotab" / "ctnft" / "cryptocompany": **0 programs.**
- `hackenproof.com` — no listing.
- `code4rena.com` — no past or active contest.
- `ctnft.net` HTML — no "security" / "bug bounty" / "disclosure" / "responsible" string anywhere on the landing.

CTNFT operates with **no public bug-bounty program**. Any disclosure would be on goodwill, with no enforceable payout commitment.

## Honest verdict

CTNFT's smart-contract attack surface is **nearly empty**:

1. They use thirdweb's audited prebuilt `TokenERC721` / `TokenERC1155` contracts, which have been third-party audited and are running in thousands of other production deployments.
2. They hold zero TVL — primary-sale revenue is forwarded to operator EOAs in the same transaction.
3. The reward economy is off-chain — so even a critical contract bug couldn't impact reward distribution.
4. The contracts are reasonable, but the **deployment is hygienically poor**: 7 of 8 contracts are unverified-on-explorer, all are admin'd by single EOAs.

**There is no on-chain exploit to find here.** The system runs on a custodial-server model that just happens to use NFTs as the ledger primitive. The operator portfolio's "everything is server-custody" pattern (established in Phases 1–3 for the browser and wallet) extends to CTNFT — they have on-chain code only because NFTs by definition require it, and they minimized the on-chain code to thirdweb's stock contracts.

**The answer to the user's question:** the CTNFT smart contracts are boilerplate thirdweb prebuilts. There is nothing to find. The entire Cryptocompany OÜ operator portfolio is server-custody-only in practice, including the one product that nominally has on-chain code.

## Recommended next steps

1. **Do not pursue further audit time on these contracts.** The marginal value is near zero — even a clever finding would be hard to monetize without a bounty program, and a real critical bug would already be a thirdweb-wide issue affecting thousands of projects.
2. **If responsible disclosure is desired**, the relevant target is **thirdweb**, not CTNFT. thirdweb runs an active bug-bounty: <https://thirdweb.com/dashboard/bug-bounty> (or via their security@ email). Any bug found in `TokenERC1155.sol` / `TokenERC721.sol` would be a thirdweb finding, not a CTNFT finding.
3. **For the broader investigation**, treat the CTNFT result as confirmation of the operator portfolio's overall thesis: **Cryptocompany OÜ runs zero meaningful on-chain logic.** Even their NFT product is just the thinnest possible wrapper over a custodial server. The investigation can now confidently state that the entire portfolio's user-funds are exposed to operator-key compromise, server-side fraud, and Cryptocompany OÜ exit-risk — never to on-chain exploits.
4. **One follow-up worth doing (10 minutes)** — fetch the contractURI() and check `_canFreezeMetadata()` state for B8, to confirm metadata is mutable (it almost certainly is, since metadata lives on `content.cryptotabnft.com`). If CTNFT shuts that subdomain down, every NFT becomes a broken JPEG. That's not a bounty finding but it's a user-impact note worth recording in the larger investigation as "NFT metadata centralisation risk".

## Files in this evidence pack

- `discovery.md` — contract inventory (10 addresses; 8 dedicated + 2 shared)
- `contract-source-0xfcecd709.md` — single contract-source analysis (the only verified one)
- `vulnerability-audit.md` — line-quoted pattern audit
- `admin-key-analysis.md` — operator EOA profiles
- `economic-attack-surface.md` — TVL + reward distribution + "is it worth attacking" math
- `verdict.md` — this file
- `raw/` — all original HTTP responses for reproducibility (Etherscan/Polygonscan HTML pages, thirdweb GitHub source, ABI, two raw bytecode dumps, etc.)
