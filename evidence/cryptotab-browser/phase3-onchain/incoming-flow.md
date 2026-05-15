# Where Does CryptoTab's Payout-Hot-Wallet Get Funded?

The single most decisive question of this entire investigation. If CryptoTab really mines BTC (or really converts mined Monero into BTC), the inflow should trace back to:
- (a) Coinbase outputs from a mining pool (real BTC mining), or
- (b) An exchange's hot wallet (BTC bought on an exchange after selling XMR / paying Cloud Boost revenue)

If inflow traces to neither — i.e. it comes only from anonymous private wallets and rotation patterns — that is itself evidence: the operator is intentionally obscuring the source.

## Method

1. Listed all **47 distinct input addresses** that funded the 46 sample payout transactions.
2. Listed all **63 distinct parent transactions** that funded those input addresses.
3. For each parent tx, checked `vin[].is_coinbase` to detect mining-pool origin.
4. Listed all **grandparent funder addresses** (~85 distinct).
5. Checked top recurring grandparent funders against known exchange/mining-pool labels.

API calls used:
```
GET https://mempool.space/api/tx/<txid>           (×63 parent txs)
GET https://mempool.space/api/address/<addr>      (×60+ funder lookups)
GET https://mempool.space/api/address/<addr>/txs  (for deep-dive on top 5 hubs)
```

Raw responses in `raw/parent_txs/` and `raw/addrstats/`.

## Result 1: ZERO coinbase parents

**Of the 63 immediate parent transactions of CryptoTab payout txs, none have `is_coinbase: true` on any input.** None trace back to a mining-pool block reward directly.

This is the key negative finding. If F2Pool, AntPool, ViaBTC, Foundry, Slush, or NiceHash were paying CryptoTab mining rewards, we would expect at least *some* of those payouts to come directly from a pool-cluster address. None do.

(Caveat: some pools batch their own payouts through change addresses, so 0/63 doesn't *prove* no mining — but it makes a direct mining-revenue model very implausible.)

## Result 2: Funding is from ephemeral/rotated private addresses

The 63 parent txs are themselves funded by **85 distinct grandparent addresses**, of which the only recurring ones are:

| Funder | Lifetime tx | Lifetime BTC | Profile |
|---|---:|---:|---|
| `bc1qqy6097…` (the hub) | 149 | 1.63 | Self-funding hop — this is internal rotation, not outside money |
| `bc1q3parjj…` (secondary hub) | 158 | 0.0083 | Same — internal |
| `1MRsBGuT4LPNZwyfqy6ePGQWVuyQ9NW282` | 75 | 0.106 | Drained-to-0 hop wallet |
| `1AtXUfiEUFaNs6ZxEcV4HHunRHfJrfJaq4` | 45 | 0.047 | Drained-to-0 hop wallet |
| `1DHRJRmKA6avcNy8dVtXfd2EqbiVEQgB3Q` | 25 | 0.004 | Drained-to-0 hop wallet |
| `1NnLV57NZ7tEn6BAAfDBDpPoG4A9TEEYKg` | 6 | 0.029 | Drained-to-0 hop wallet |
| `1LxFr6SE9JLG7B1LdkbKG9ssmQTw2s3G5d` | 14 | 0.011 | Drained-to-0 hop wallet |
| `1HD6FgpwjDHUAoG7QDbRdGJfkZPnRdSNnc` | 6 | 0.003 | Drained-to-0 hop wallet |

**Every one** of these recurring upstream funders shows the same pattern: short tx-count, full drain, no balance, no incoming from a labeled cluster. The cluster is built on **single-use address rotation**, deliberately preventing standard chain-analysis heuristics from linking to a treasury.

## Result 3: No identifiable exchange-cluster fingerprint

Cross-referencing the top funder addresses against the WalletExplorer database returned **no matches** for:
- Binance / Coinbase / Kraken / OKX / MEXC / Bybit / KuCoin hot wallets
- F2Pool / AntPool / ViaBTC / Foundry / Slush / NiceHash payout addresses
- BitFinex / Bitstamp / Gemini

The funder addresses are all custom one-time-use addresses. Exchanges and mining pools — by contrast — reuse their hot wallets heavily and accumulate in well-known clusters that WalletExplorer indexes.

## Result 4: Inflow structure is consolidation-style "many-to-one"

Looking at the 78 receiving transactions of hub `bc1qqy6097…`:
- Median **10 inputs** per tx (range 1–44)
- Mostly **1 output** to the hub (a few have 2 outputs — change + hub)
- Inputs are mixed legacy `1…` P2PKH and SegWit `bc1q…` addresses

This is canonical consolidation — many small UTXOs pooled into one. It is the EXACT opposite of an exchange withdrawal (which is typically 1-to-many).

Example funding tx pattern (from raw data):

| Tx | vin | vout | BTC funded | Funder pattern |
|---|---:|---:|---:|---|
| `102239a3cd80` | 13 | 1 | 0.00617 | 13 distinct legacy 1… addresses |
| `746d9c387f22` | 12 | 1 | 0.01102 | 12 distinct legacy 1… addresses |
| `91cd15806c0b` | 21 | 1 | 0.02549 | 21 distinct legacy 1… addresses |
| `68ce56a2b4fa` | 18 | 2 | 0.01986 | 18 distinct legacy 1… addresses |

## Interpretation

**The on-chain inflow signature is consistent with one of three operating models**:

1. **Coin-mixer / privacy-rotation pattern.** The operator intentionally maintains a self-laundering address pool to obscure where the money actually originates. This is what an MLM/affiliate-funded payout operation would look like if the operator deliberately avoided depositing through identifiable exchanges. **This is most likely.**

2. **The operator has been depositing externally-purchased BTC via a peer-to-peer service or no-KYC OTC desk.** Such services would not have a chain-analytics label. Consistent with operating from Estonia where P2P BTC is widely available.

3. **A long upstream chain ending at an exchange.** In theory, deep enough analysis (10+ hops back) might end at Binance/Coinbase. We did not pursue 10-hop analysis because the pattern is already deliberately obscured — and a 10-hop chain that ends at an exchange would prove nothing about CryptoTab specifically.

**The on-chain inflow signature is NOT consistent with**:
- Real BTC mining (would show coinbase parents)
- Real Monero-to-BTC conversion through public exchange (would show withdrawals from Kraken / Binance / etc. hot wallets)

## Conclusion

CryptoTab's payouts come from an **opaque, self-rotating private cluster** — not from labeled mining pools and not from labeled exchanges. The structure is designed to be unverifiable as either mining-funded or trading-funded.

Combined with the economics in `economics-cross-check.md` (where browser-based mining is shown to produce ~0.0000000015 BTC/day across all 35M users vs observed ~0.0023 BTC/day payouts), the most plausible explanation is that **CryptoTab funds its payouts from internal revenue** (Cloud Boost subscription purchases, mostly), buys BTC OTC or via small/no-KYC channels, and pushes it through a deliberately obfuscating rotation cluster before paying users.

This is the on-chain signature of an **MLM/affiliate revenue-recirculation model**, not of a Bitcoin mining service.
