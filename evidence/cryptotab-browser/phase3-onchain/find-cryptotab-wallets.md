# CryptoTab — Identifying On-Chain Payout Wallets

## Methodology

WalletExplorer.com has **no labeled cluster** for "CryptoTab" or "Cryptocompany OÜ" — confirmed by direct query (`https://www.walletexplorer.com/?q=cryptotab` returns "Pattern not recognized"). Bitcoinabuse / Chainabuse also returned no direct hits. CryptoTab does not publish a master donation address.

However, the company itself maintains a **public, verifiable Payments Journal** on its own site that links out to live blockchain.info / blockstream.info transaction explorer URLs. That is the cleanest possible on-chain attribution: the operator's own server is asserting that these transactions are CryptoTab payouts. The journal is auto-rendered server-side from CryptoTab's database; the live URLs at the time of pull are stored in `raw/journal-bitcoin.html` and `raw/journal_pages/`.

### Source URLs

- Live journal (BTC tab): `https://cryptobrowser.site/en/journal/?service=bitcoin`
- Live journal (NCWallet tab): `https://cryptobrowser.site/en/journal/?service=ncw`
- Sample TX link CryptoTab itself publishes: `https://blockchain.info/tx/50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7`

### Key infrastructure finding

Every entry in the journal is tagged **"NC Wallet priority withdrawal"**. NC Wallet (`ncwallet.net`) is the custodial-wallet sister-product of CryptoTab, owned by the same Cryptocompany OÜ. **CryptoTab Browser does not pay users out of its own BTC wallets directly — it routes withdrawals through NC Wallet's batched on-chain transactions.** This is a critical structural finding: the "payout" addresses we trace are NC Wallet's hot infrastructure, not a CryptoTab-only wallet.

## Identified payout cluster — confidence ratings

From parsing 46 most-recent BTC withdrawal transaction IDs out of the journal (full list in `raw/all-txids.txt`) and mapping inputs/outputs (raw API responses in `raw/txs/`):

### Tier 1 — Confirmed core payout-hot-wallet (HIGH confidence)
| Address | Lifetime tx_count | Lifetime BTC in | Role | Confidence |
|---|---|---|---|---|
| `bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e` | 149 | 1.6267 | **Primary recurring payout consolidator/dispatch hub** for NC Wallet/CryptoTab. Fans out to 3,078+ distinct user addresses in 71 send txs. First seen 2024-03-22, last seen 2026-03-04. | HIGH |
| `bc1q3parjj5mhtkaxp3tr7n5dk6rem43k47t82txaj` | 158 | 0.00835 | **Secondary dispatcher** — reused for small-batch payouts. Receives from `bc1qqy6097…` 14x; sends to 81 distinct user addresses. | HIGH |
| `bc1q466q7cnz94pszrhdjq6u03gmvdgvdfn5zr40cy` | 20 | 0.1585 | **Tertiary dispatcher** — 487 distinct payout destinations. | HIGH |

### Tier 2 — Identified ephemeral senders (HIGH confidence as cluster, low individual value)
**45 single-use SegWit `bc1q…` addresses** observed funding the 46 sample payout transactions, each with exactly 2 lifetime txs (one receive, one spend, drained to 0 balance). These are clearly programmatically-generated one-time send wallets used by NC Wallet for its bulk withdrawal pipeline. Full list in `raw/addrstats/`. Examples:
- `bc1q2s05mzcuft6jm7g8ruexvek9stprjq8h52vm8l`
- `bc1q3aur8y0f0q99nkl6a2plgs5qk5tucmr8qntxwl`
- `bc1qk8m7c8cdd4zqx3k5xst9gf6pxlcn94g05d4mme`
- `bc1qmmaszuyvd4swshaeavde0jkrrgj4pzsrgu4x3c`

### Tier 3 — Upstream funder/consolidator wallets (MEDIUM confidence — these may belong to upstream actor before NC Wallet receives BTC)
Top recurring funders of `bc1qqy6097…`:
| Address | tx_count | Lifetime BTC | Role |
|---|---|---|---|
| `1MRsBGuT4LPNZwyfqy6ePGQWVuyQ9NW282` | 75 | 0.1061 | Repeat-funder of hub (consolidator) |
| `1AtXUfiEUFaNs6ZxEcV4HHunRHfJrfJaq4` | 45 | 0.0468 | Repeat-funder |
| `1DHRJRmKA6avcNy8dVtXfd2EqbiVEQgB3Q` | 25 | 0.0036 | Repeat-funder |
| `1LxFr6SE9JLG7B1LdkbKG9ssmQTw2s3G5d` | 14 | 0.0107 | Repeat-funder |

All Tier-3 wallets exhibit the same fully-drained, short-lifecycle pattern. They are likely also internal NC Wallet rotation addresses.

## What WalletExplorer / Chainabuse / Bitinfocharts told us

- `walletexplorer.com` — no CryptoTab/Cryptocompany cluster tag.
- `chainabuse.com/address/cryptotab` — 404 (no public attribution).
- `bitcoinabuse.com/reports/cryptotab` — redirects to chainabuse 404; no public abuse reports.

This is unusual: a 9-year-old operation paying out tens of millions of users has no public chain-analytic attribution. That is because NC Wallet's address-rotation pattern (single-use SegWit senders, drained on every tx) prevents naive cluster-by-co-spend heuristics. Sophisticated analytic firms (Chainalysis, Crystal, TRM Labs) likely have internal clusters for NC Wallet but have not made them public.

## Files

- `raw/journal-bitcoin.html` — Saved copy of CryptoTab's own Bitcoin payment journal (46 txids, all linking to blockchain.info)
- `raw/all-txids.txt` — 46 unique txids extracted
- `raw/txs/*.json` — Mempool.space API responses for each payout tx
- `raw/hub/p1-p5.json` — Full 149-tx history for `bc1qqy6097…`
- `raw/addrstats/*.json` — Lifetime stats for 47 distinct sender addresses
- `raw/parent_txs/*.json` — Parent transactions (63 unique upstream txs)
