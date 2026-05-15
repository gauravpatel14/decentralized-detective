# CTNFT Smart Contract Discovery

Investigation date: 2026-05-15. All on-chain reads are view-only via public RPCs (publicnode.com) and HTML scraping of etherscan.io / polygonscan.com. No keys used; rate-limited fetches saved to `raw/`.

## Sources mined

| Source | URL | Result |
|---|---|---|
| CTNFT landing | `https://ctnft.net/` | Only links to OpenSea Shared Storefront tokens. No own contracts referenced. |
| Invite subdomain | `https://invite.ctnft.net/` | Same HTML as ctnft.net (serves the landing). |
| Web app | `https://app.ctnft.net/` | SPA. Build hash `cdb569d0`, main JS `app.ctnft.net/961/cdb569d0/static/js/main.00c9852f.js` (3.6 MB). |
| Companion site | `https://cryptotabnft.com/` | The actual "NFT showcase" — links every collection page with explicit contract addresses. |
| Robots | `https://ctnft.net/robots.txt` | Standard content-signals; no admin endpoints. |
| Sitemap | `https://ctnft.net/sitemap.xml` | Marketing pages only. |
| OpenSea | Searched for "cryptotab" collections | Confirmed collections on OpenSea Shared Storefront contracts (ETH `0x495f9472…` and Polygon `0x29533991…`). |
| Rarible | Linked from cryptotabnft.com | Eight standalone Polygon collections + one ETH collection. |

## Contract inventory

CTNFT runs **two classes of NFT contracts**:

1. **Shared-storefront tokens** on OpenSea's lazy-mint contracts. These contracts are *not* CTNFT's — they belong to OpenSea. CTNFT just owns specific tokenIds inside them.
2. **Dedicated thirdweb prebuilt collections** (mostly thirdweb's `TokenERC721`-class bytecode, one `TokenERC1155` via EIP-1167 proxy).

### A. Shared / third-party (not CTNFT's code)

| # | Address | Chain | Identity | Verified | Confidence it's "CTNFT's contract" |
|---|---|---|---|---|---|
| A1 | `0x495f947276749ce646f68ac8c248420045cb7b5e` | Ethereum | OpenSea: OPENSTORE Token (Shared Storefront, ERC-1155) | Unverified by Etherscan but well-known | **LOW** — owned by OpenSea, not CTNFT. CTNFT just mints tokenIds inside it. |
| A2 | `0x2953399124f0cbb46d2cbacd8a89cf0599974963` | Polygon | OpenSea: OPENSTORE Token (Shared Storefront, ERC-1155) | Verified | **LOW** — owned by OpenSea, not CTNFT. |

These two underpin the `vibes`, `kickers`, `moments`, `action`, and `utility` "collections" advertised on cryptotabnft.com. They are out-of-scope for CTNFT-bug-bounty purposes because CTNFT has no privilege over them.

### B. CTNFT-deployed dedicated collections (verified by on-chain `owner()` call)

All owners are EOAs controlled by CryptoTab Browser operator (Cryptocompany OÜ). The primary deployer `0xcda31ef0…` is publicly tagged on Polygonscan as **"The Legend of CryptoTab: Deployer"** — that public tag confirms attribution.

| # | Address | Chain | Name | Symbol | Owner / DEFAULT_ADMIN | Bytecode size (hex chars) | Verified source | Confidence |
|---|---|---|---|---|---|---|---|---|
| B1 | `0xEE9BF4d956e303E3a19B49f11c2B380493Bc007b` | Ethereum | The Legend of CryptoTab: Age of Eggs IV | CTAOE4 | `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` | 25 582 | **No** (Etherscan unverified) | **HIGH** — owner is the labelled CTNFT deployer; metadata URI hosted on `content.cryptotabnft.com`. |
| B2 | `0x73f9ea501f1d874c6afa3442c8971e1e278469a3` | Polygon | The Legend of CryptoTab: Age of Eggs III | CTAOE3 | `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` | 25 582 | **No** | **HIGH** — same. Bytecode is byte-identical to B1 (same metadata IPFS hash `0a6f7915…`). |
| B3 | `0x783676df75400120a35af7a6312696e41198b87f` | Polygon | The Legend of CryptoTab: Age of Eggs (I) | CTAOE | `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` | 19 272 | **No** | **HIGH** |
| B4 | `0xee0920dbd1c41c5215ab0b2aacd240456833af3b` | Polygon | (no name returned — Level Up tier per landing) | — | `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` | 28 156 | **No** | **MEDIUM** — listed by CTNFT, owner matches, but `name()` reverts. |
| B5 | `0x8a705160ba5e100c7c1dcf86c547099d127ce586` | Polygon | CryptoTab Collectables | CTCOL | `0x18e2883864abd904ac88db3a792fddab731e16be` | 23 702 | **No** | **HIGH** |
| B6 | `0x58314ad8cc3762011f49c7fa13ffe2bb40015e12` | Polygon | CryptoTab Magic Live Eggs | CTMEGGS | `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` | 23 702 (byte-identical to B5, B7) | **No** | **HIGH** |
| B7 | `0xea2b5048241fbda3af4253ef6fd0c01f4fcba224` | Polygon | CryptoTab Live Eggs | CTEGGS | `0x18e2883864abd904ac88db3a792fddab731e16be` | 23 702 | **No** | **HIGH** |
| B8 | `0x3b10994f90971125cfd9e1fa2c01fce3183ad96c` | Polygon | Love Vibes by CryptoTab | "Love Vibes by CryptoTab" | `0x7951c1be03de17fb7616e05c5a515cc705db2787` | 92 (EIP-1167 minimal proxy → `0xfcecd709c1bf0e3a890277557b892ddc1e0c8b55` = thirdweb `TokenERC1155`) | **Yes** (implementation is verified thirdweb prebuilt) | **HIGH** — only one whose implementation source is publicly verified. |

### C. Implementation behind B8

| Address | Chain | Identity | Verified | Notes |
|---|---|---|---|---|
| `0xfcecd709c1bf0e3a890277557b892ddc1e0c8b55` | Polygon | thirdweb `TokenERC1155` (the prebuilt; ABI confirmed via Polygonscan page) | **Yes** | This is thirdweb's well-known audited prebuilt contract — *not* CTNFT-authored. CTNFT just cloned it. |

### D. False positives (originally in the address sweep, ruled out)

| Address | Reason |
|---|---|
| `0x0d9E22a4B0964010c7440Ea7121C96361C45a671` | EOA (no bytecode) — but the CTNFT *app* tells users to "Add Token" pointing at this EOA as the **"Mining Master Token"** (see app-main.js / `"Address:":"<b>Adresse:</b> 0x0d9E22a4B0964010c7440Ea7121C96361C45a671"`). It cannot be a token contract. Balance $86, 24 txs on ETH only. This is misleading UX, **not** a smart-contract finding. |
| `0xC293fAbDC6e6F1729D931bDE85664daAD42dbF40` | Same — EOA (`eth_getCode` returns `0x`). The cryptotabnft.com landing labels it as the contract for the "Golden Eggs" collection. It is not a contract at all. **Misleading attribution by their own marketing site.** |

## Deployer transaction profile

| Admin EOA | Polygon txs | Ethereum txs | Balance | Public tag |
|---|---|---|---|---|
| `0xcda31ef080e99f60573c4d8c426d32b05a44ac4f` | 7 930 | 306 | $74.75 across 3 chains | **"The Legend of CryptoTab: Deployer"** (Polygonscan label) |
| `0x18e2883864abd904ac88db3a792fddab731e16be` | 2 | 0 | <$1 | None |
| `0x7951c1be03de17fb7616e05c5a515cc705db2787` | 2 176 | 0 | <$1 | None |

`0xcda31ef0…` is a working hot wallet — the primary CTNFT operator key. The fact that it currently holds only $74 means it is **drained as fast as funds arrive**, which is consistent with a server-pushed "auto-sweep" pattern.

## Searches that came up empty

- BSC, Arbitrum, Base, Optimism, Avalanche: no CTNFT-tagged contracts on the explorers (verified by searching name + checking each contract's chain field).
- DappRadar listing: CTNFT is not tracked (not a dapp by their definition — it's a custodial-server NFT product).
- Twitter/X `@CryptoTabApp`: no contract addresses posted historically that don't already point to the eight above.
- Bug-bounty programs: `immunefi.com` search returns 0 results for "cryptotab" / "ctnft". HackenProof, Code4rena similarly show no programs.

## Summary

- **8 dedicated NFT contracts** under CTNFT's control (1 on ETH, 7 on Polygon).
- **0 of 8 have their own source code verified on the relevant explorer.** Only one (B8) is a proxy clone of thirdweb's publicly-verified `TokenERC1155`.
- **0 contracts have any ETH/MATIC TVL** — all return `eth_getBalance` = 0.
- All admin keys are **single EOAs** (no Gnosis Safe / multisig detected).
- The "Mining Master Token" and "Golden Eggs collection" addresses promoted in CTNFT's app/marketing are **EOAs, not contracts** — misleading attribution but no exploitable bug.
