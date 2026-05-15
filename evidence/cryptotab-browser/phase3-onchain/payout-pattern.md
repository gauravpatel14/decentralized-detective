# CryptoTab Payout Pattern — Empirical Analysis

Source: All 71 outbound transactions from the primary NC Wallet payout hub `bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e`, covering 2024-03-22 → 2026-03-04 (712 calendar days).

## Sample of 35 most recent outbound payments

| # | Date (UTC) | TXID | vin | vout | BTC sent |
|---:|---|---|---:|---:|---:|
| 1 | 2026-03-04 11:29 | `558e33f6b142` | 1 | 14 | 0.006154 |
| 2 | 2026-02-26 14:18 | `5ce4c9547057` | 1 | 51 | 0.019915 |
| 3 | 2026-02-06 10:10 | `67de51285f4e` | 2 | 34 | 0.012242 |
| 4 | 2026-02-04 16:40 | `31edf1b3b503` | 2 | 11 | 0.003683 |
| 5 | 2026-02-03 23:01 | `d6aa69710471` | 2 | 22 | 0.006332 |
| 6 | 2026-01-27 14:05 | `f98e234eff5a` | 5 | 12 | 0.008400 |
| 7 | 2026-01-24 13:53 | `04e875709686` | 1 | 10 | 0.004966 |
| 8 | 2026-01-22 18:32 | `74ab967da557` | 1 | 10 | 0.001957 |
| 9 | 2026-01-21 23:52 | `cb7c11a2a227` | 4 | 7  | 0.003142 |
| 10 | 2026-01-15 23:11 | `875db1e9bb39` | 1 | 14 | 0.010573 |
| 11 | 2026-01-15 19:51 | `f81b16a667b5` | 2 | 36 | 0.011763 |
| 12 | 2026-01-13 15:55 | `a70dc724f3e0` | 2 | 31 | 0.018636 |
| 13 | 2026-01-12 09:19 | `349c4beaec56` | 1 | 18 | 0.012447 |
| 14 | 2026-01-07 11:26 | `815a18b823ef` | 2 | 34 | 0.020184 |
| 15 | 2025-12-27 21:40 | `3ddf5232b167` | 2 | 21 | 0.025124 |
| 16 | 2025-12-27 10:50 | `beefa3283b2e` | 3 | 43 | 0.020775 |
| 17 | 2025-12-25 10:08 | `12d2b9ad7faf` | 1 | 43 | 0.016181 |
| 18 | 2025-12-24 06:54 | `8501d280c26c` | 2 | 7  | 0.004828 |
| 19 | 2025-12-22 07:36 | `b38a709e5bc8` | 2 | 22 | 0.009534 |
| 20 | 2025-12-21 19:51 | `dbae01b85dee` | 2 | 51 | 0.013623 |
| 21 | 2025-12-20 08:00 | `cf17274c0031` | 4 | 18 | 0.012433 |
| 22 | 2025-12-18 21:43 | `4209c2bf762a` | 1 | 35 | 0.025446 |
| 23 | 2025-12-14 15:59 | `7202eef2ea24` | 3 | 20 | 0.007494 |
| 24 | 2025-12-11 19:08 | `0e2c13676080` | 2 | 6  | 0.012815 |
| 25 | 2025-12-09 18:29 | `3c81fcdc8f18` | 3 | 54 | 0.026212 |
| 26 | 2025-12-06 00:40 | `0bec41040926` | 2 | 27 | 0.022944 |
| 27 | 2025-12-02 23:05 | `4e43c656fc3d` | 1 | 48 | 0.019829 |
| 28 | 2025-11-30 10:09 | `55e2243e72aa` | 1 | 44 | 0.020851 |
| 29 | 2025-11-25 23:44 | `857dff2b4145` | 3 | 67 | 0.028139 |
| 30 | 2025-11-22 14:53 | `1a54affc36e5` | 1 | 18 | 0.029876 |
| 31 | 2025-11-22 00:12 | `d8eb018fb3d3` | 4 | 39 | 0.037731 |
| 32 | 2025-11-19 21:53 | `7c1a8505532d` | 2 | 70 | 0.037582 |
| 33 | 2025-11-12 17:58 | `73fa3b653b31` | 1 | 27 | 0.049975 |
| 34 | 2025-11-10 15:38 | `3205377beb65` | 1 | 26 | 0.029708 |
| 35 | 2025-11-09 11:55 | `b2e478579a7c` | 1 | 59 | 0.029950 |

API calls used to produce this:
```
GET https://mempool.space/api/address/bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e/txs
GET https://mempool.space/api/address/bc1qqy6097.../txs/chain/<last_txid>   (×4)
```

## Per-recipient payout size statistics

Across **5,273 individual user payments** that came out of the hub during its 712-day lifetime:

| Percentile | Sats | BTC | ~USD @ $60k/BTC |
|---|---:|---:|---:|
| Minimum | 660 | 0.00000660 | $0.40 |
| p10 | 1,062 | 0.00001062 | $0.64 |
| p25 | 1,782 | 0.00001782 | $1.07 |
| **p50 (median)** | **6,056** | **0.00006056** | **$3.63** |
| p75 | 20,373 | 0.00020373 | $12.22 |
| p90 | 57,117 | 0.00057117 | $34.27 |
| Maximum | 4,103,831 | 0.04103831 | $2,462 |
| Mean | 31,856 | 0.00031857 | $19.11 |

The **typical user payout is ~$3.60 worth of BTC**. p90 is $34, max is one outlier of $2,462. This is a hard ceiling on what a "normal" CryptoTab miner is paid.

## Batched vs. per-user

- **70 of 71 send txs (98.6%) have ≥5 outputs** — i.e. they are batched payouts. The exception is a 4-output cleanup tx.
- Median outputs per send tx = **54 user payouts in a single Bitcoin transaction**.
- Largest single batched payout tx = **302 user payouts in one tx** (txid `50baf3171d0182e26ca63f16ea8fc63d4b1e509ee9e7964aed24a4d9a6ff99c7`).

This **exactly matches NC Wallet's published claim** that "to save on fees, they send transactions to the blockchain in bulk" — quoted from `ncwallet.net` FAQ. CryptoTab is operationally truthful about this: it really does batch withdrawals on-chain.

## Frequency of payments

| Metric | Value |
|---|---|
| Calendar days lifetime | 712 |
| Days with ≥1 send tx | 64 (9.0% of days) |
| Avg interval between batches | **~11.1 days** |
| Total user-payments in window | 5,273 |
| Avg user-payments per active day | 82.4 |
| Avg user-payments per calendar day (overall) | 7.4 |
| Max user-payments in one day | 302 (2025-08-23) |

**Key observation**: the hub processes a payout batch roughly **every 1–2 weeks**, not daily as marketing suggests. The actual on-chain settlement cadence is much slower than the user-facing UI implies (the user's balance in CryptoTab updates daily; the actual BTC transfer is batched).

## Estimated user-payout rate vs. claimed user base

CryptoTab marketing claims **35 million users**.

Through this single hub: ~7.4 user payouts per calendar day across all 35M users = **roughly 1 in every 4.7 million users receives a payout on any given day** through this wallet.

**Even if we generously assume 10× more hub wallets** of similar capacity exist (a total of ~74 user payouts per day across all hubs), that's still only **~520 user payouts per week** vs. 35M users — or about **0.0015% of the user base** receiving a payout per week.

That's consistent with what the user-complaints OSINT (`phase2-osint`) found: **most users mine forever and never reach minimum withdrawal threshold**, while a small minority (likely the ones who reach the threshold via referral commissions or Cloud Boost) get periodic payouts. The user in this investigation is one of those — they received 3 withdrawals personally.

## What this tells us about the business model

A real Bitcoin mining service that serves 35M users would have far higher payout volume — either:
- (a) more frequent batched payouts (daily or hourly), or
- (b) larger per-batch dollar amounts.

Instead, the on-chain reality is **very low total volume** (1.63 BTC in 2 years through the most-active hub), batched on a slow ~11-day cadence, with **micropayments averaging $19 each**. This is the on-chain footprint of a **proof-of-payout system designed to maintain credibility with affiliates/influencers** — not a real mining operation. The payouts function as marketing expense, not as revenue distribution.
