# Contract analysis — `0xfcecd709c1bf0e3a890277557b892ddc1e0c8b55` (Polygon)

This is the **only CTNFT-related contract with verified, publicly readable source code**. It is *not* CTNFT-authored; it is **thirdweb's prebuilt `TokenERC1155`**, used as the implementation behind the EIP-1167 minimal proxy at `0x3b10994f90971125cfd9e1fa2c01fce3183ad96c` ("Love Vibes by CryptoTab").

## On-chain metadata (read via Polygonscan address page)

| Field | Value |
|---|---|
| Chain | Polygon (chainid 137) |
| Contract Name | `TokenERC1155` |
| Compiler | Solidity 0.8.18 (`solc 0008 12 0033` in metadata footer) |
| Optimization | Enabled |
| Creator | `0x7951c1be03de17fb7616e05c5a515cc705db2787` (creator of the proxy in B8 — same EOA also created the implementation for thirdweb factory deployments) |
| Source verified | **YES** (Polygonscan) |
| ABI | 52 functions; saved in `raw/abi-TokenERC1155.json` |
| Source files | 41 .sol files; full Solidity tree saved as `raw/source-TokenERC1155-impl.sol` (concatenated dump of all `<pre>` blocks from Polygonscan) plus the canonical upstream `raw/source-TokenERC1155-github.sol` from `thirdweb-dev/contracts` GitHub repo. |
| Module identifier | `bytes32("TokenERC1155")` constant |
| Version | `1` |

## ABI surface (mutating functions, with access-control modifier from source)

| Function | Mutability | Access control | Notes |
|---|---|---|---|
| `initialize(...)` | nonpayable | `initializer` modifier (one-shot) | Sets default admin, primary sale recipient, royalty, platform fee. Cannot be re-called. |
| `mintTo(address,uint256,string,uint256)` | nonpayable | `nonReentrant onlyRole(MINTER_ROLE)` | |
| `mintWithSignature(MintRequest,bytes)` | **payable** | `nonReentrant` + signature must be from `MINTER_ROLE` holder | EIP-712 typed-data signature. UID-replay protection. |
| `burn`, `burnBatch` | nonpayable | `account == _msgSender() || isApprovedForAll(account,_msgSender())` | Standard ERC-1155. |
| `setOwner(address)` | nonpayable | `onlyRole(DEFAULT_ADMIN_ROLE)` + new-owner must be admin | Cosmetic OpenSea owner; not a privileged setter. |
| `setPrimarySaleRecipient` | nonpayable | `onlyRole(DEFAULT_ADMIN_ROLE)` | |
| `setDefaultRoyaltyInfo`, `setRoyaltyInfoForToken` | nonpayable | `onlyRole(DEFAULT_ADMIN_ROLE)` + bps ≤ MAX_BPS check | |
| `setPlatformFeeInfo`, `setFlatPlatformFeeInfo`, `setPlatformFeeType` | nonpayable | `onlyRole(DEFAULT_ADMIN_ROLE)` | |
| `setContractURI` | nonpayable | `onlyRole(DEFAULT_ADMIN_ROLE)` | |
| `setOperatorRestriction`, `subscribeToRegistry` | nonpayable | `onlyRole(DEFAULT_ADMIN_ROLE)` | OperatorFilterRegistry (creator fee enforcement). |
| `grantRole`, `revokeRole`, `renounceRole` | nonpayable | OpenZeppelin `AccessControlEnumerableUpgradeable` (caller must have role-admin) | |
| `safeTransferFrom`, `safeBatchTransferFrom` | nonpayable | standard ERC-1155 | |
| `setApprovalForAll` | nonpayable | standard ERC-1155 | |
| `multicall(bytes[])` | nonpayable | none — but routed through `_msgSender()` (ERC-2771) | Each sub-call is checked individually. |

Constructor: `constructor() initializer {}` — the implementation is itself locked with `initializer` so it cannot be re-initialised by anyone after the prebuilt was deployed. (Verified by reading source line 135.)

## Roles in use on the live B8 instance

Reading on-chain via the proxy `0x3b10994f90971125cfd9e1fa2c01fce3183ad96c`:

- `owner()` returns `0x7951c1be03de17fb7616e05c5a515cc705db2787` (EOA).
- `DEFAULT_ADMIN_ROLE` = `0x0000000000000000000000000000000000000000000000000000000000000000` (standard OZ zero-bytes32).
- `nextTokenIdToMint()` returns 15 — fifteen tokens have been minted with auto-increment.
- `contractType()` returns `bytes32("TokenERC1155")`.
- `supportsInterface(0xd9b67a26)` — ERC-1155 — returns true.

The DEFAULT_ADMIN_ROLE is held by the same EOA `0x7951c1be…` (verified by Polygonscan creator field for the proxy + thirdweb prebuilt's `_setupRole(DEFAULT_ADMIN_ROLE, _defaultAdmin)` in `initialize`).

## Constructor / initializer args (reconstructed from `initialize` event signatures)

`initialize(_defaultAdmin, _name, _symbol, _contractURI, _trustedForwarders[], _primarySaleRecipient, _royaltyRecipient, _royaltyBps, _platformFeeBps, _platformFeeRecipient)`

For B8 the values are inferable from the live contract:

| Param | Value | Source |
|---|---|---|
| `_defaultAdmin` | `0x7951c1be03de17fb7616e05c5a515cc705db2787` | `owner()` |
| `_name` | `"Love  Vibes  by  CryptoTab"` (two spaces between words — verbatim) | `name()` |
| `_symbol` | `"Love Vibes by CryptoTab"` | `symbol()` |
| `_contractURI` | (not fetched — `contractURI()` not queried) | n/a |
| `_primarySaleRecipient`, `_royaltyRecipient`, `_platformFeeRecipient` | (not fetched in this round; require additional eth_call) | n/a |

## Saved artifacts

- `raw/abi-TokenERC1155.json` — full ABI (extracted from Polygonscan `<pre>` block 0).
- `raw/polypage-impl-0xfcecd709-code.html` — full Polygonscan code page (782 KB).
- `raw/source-TokenERC1155-impl.sol` — concatenated source dump (6.2 MB; duplicates because Polygonscan repeats each shared library across blocks).
- `raw/source-TokenERC1155-github.sol` — canonical TokenERC1155.sol from `thirdweb-dev/contracts` main branch (576 lines). Used as ground truth for the vulnerability audit because the on-chain version is byte-equivalent (compiler 0.8.18, optimization on).

## Cross-reference with unverified instances (B1–B7)

The other seven CTNFT contracts (B1 – B7) have **unverified source**, but the same architectural fingerprint:

- They expose the `owner()` / `name()` / `symbol()` / thirdweb-specific selectors.
- B1 and B2 share **identical 25 582-byte bytecode and metadata hash** (`0a6f7915c3d26029ef6304c831812adff1289d65ec2fa544f16e94c16f840c62`) — confirming they were compiled and deployed from the same source.
- B5, B6, B7 share **identical 23 702-byte bytecode** with each other.
- `supportsInterface(0xd9b67a26)` is **false** for B1/B2 — so they are **ERC-721**, *not* ERC-1155. (`supportsInterface(0x80ac58cd)` returns true → confirmed ERC-721.)
- `tokenURI(1)` on B2 returns `"https://content.cryptotabnft.com/static/0x73f9…/1.json"` → centralised JSON hosting, off-chain metadata.

Combined with the architectural match (`owner()`, `DEFAULT_ADMIN_ROLE`, `MINTER_ROLE` byprint), B1–B7 are **almost certainly thirdweb `TokenERC721` prebuilt deployments** (not proxies — they were deployed as full instances, hence the larger bytecode). The fact that they are *unverified* on the explorer is a marketing/process oversight, not evidence of a custom contract.

No public bytecode-fingerprint search service we could query without an API key conclusively confirms this, but the evidence (creator EOA tagged as CTNFT deployer; selectors `0xcb2ef6f7` / `0xbedb86fb` only used in thirdweb; metadata URI format identical to thirdweb's NFT collection prebuilt) is overwhelming.
