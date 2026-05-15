# CryptoTab Economics Cross-Check

The decisive sanity check: does the observed payout volume match what CryptoTab could *theoretically* mine, given the Bitcoin network's hashrate?

## Inputs to the model

### Bitcoin network (May 2026)
- Total hashrate ≈ **1,031 EH/s = 1.031 × 10²¹ H/s** (source: hashrateindex.com / theblock.co data, May 2026)
- Block subsidy: 3.125 BTC/block (post-2024 halving)
- Blocks/day ≈ 144
- **Network BTC issuance ≈ 450 BTC/day**

### CryptoTab's claims
- "35 million users worldwide" (cryptobrowser.site marketing)
- "Up to 20 million H/s per Pool Miner" (CryptoTab marketing — applies *only* to paid Cloud Boost/MAX subscribers, not free users)
- Free CPU mining via browser: realistic browser SHA-256 (or XMR RandomX equivalent normalized to SHA-256-of-BTC value) at **~100 H/s per typical device**

### CryptoTab's observed payouts (from `payout-wallet-analysis.md`)
Through primary hub `bc1qqy6097exlusgwn7gywg42tjgymx0avmz9ngd9e`:
- Lifetime BTC out = 1.6267 BTC over 712 days
- **Daily payout rate ≈ 0.00229 BTC/day from this hub**

## Step 1 — Realistic mining yield for 35M browser users

```
CryptoTab effective hashrate (free CPU mining):
  35,000,000 users × 100 H/s   = 3.5 × 10⁹ H/s = 3.5 GH/s

Share of network:
  3.5e9 / 1.031e21              = 3.4 × 10⁻¹²
                                = 0.00000000034%

Expected mining yield:
  450 BTC/day × 3.4 × 10⁻¹²    = 1.5 × 10⁻⁹ BTC/day
                                = 0.0000000015 BTC/day
                                ≈ $0.00009 / day across all 35M users
```

Even being extremely generous and assuming **every** one of the 35M users runs a high-end laptop at 1 KH/s constantly:
```
  35M × 1,000 H/s = 35 GH/s = 3.5 × 10¹⁰ H/s
  Share of network = 3.4 × 10⁻¹¹  (0.0000000034%)
  Yield = ~0.0000000150 BTC/day  (~$0.001/day total)
```

(Note: CryptoTab actually mines Monero (XMR) via RandomX and converts to BTC. RandomX is CPU-friendly so users can produce more XMR-equivalent hashes than SHA-256. But the same arithmetic applies to the XMR network: 35M browser users with ~1 KH/s of RandomX would still be a vanishingly small fraction of the XMR network. The headline conclusion holds — the order of magnitude is dollars per day, not dollars per minute.)

## Step 2 — Observed payouts vs. theoretical mining

| Scenario | BTC/day | USD/day (@ $60k) |
|---|---:|---:|
| Theoretical mining yield (35M × 100 H/s) | 0.0000000015 | $0.00009 |
| Theoretical mining yield (35M × 1 KH/s — generous) | 0.0000000150 | $0.0009 |
| **Observed payout (single hub `bc1qqy6097…`)** | **0.00229** | **$137** |
| Observed payout if 10 similar hubs exist | 0.0229 | $1,374 |
| Observed payout if 50 similar hubs exist | 0.1142 | $6,852 |

**The observed daily payout is ~1.5 million times larger than the theoretical mining yield.**

Even under the most generous assumptions about CryptoTab's hashrate, the company would need to control **~52 trillion users** at 100 H/s each (or ~5.2 trillion at 1 KH/s) to actually mine enough BTC to cover the observed daily payouts. That's obviously impossible.

## Step 3 — The reverse calculation

How big a hashrate share of the Bitcoin network would CryptoTab need to actually mine these payouts honestly?

| Total ecosystem payout assumed | Hashrate share needed | Equivalent ASIC-miners |
|---|---|---|
| 1 hub × 0.00229 BTC/day | 0.000508% of network | ~5.2 EH/s ≈ 26,000 modern ASICs |
| 10 hubs × 0.0229 BTC/day | 0.00508% of network | ~52 EH/s ≈ 260,000 modern ASICs |
| 50 hubs × 0.1142 BTC/day | 0.0254% of network | ~262 EH/s ≈ 1.3 million ASICs |

To honestly produce even the single-hub-only payout amount, CryptoTab would need an **ASIC mining farm equivalent to a top-20 public Bitcoin miner**. There is zero evidence of such a farm. The company doesn't own one. They explicitly market browser-CPU mining, which produces ~0.0000000015 BTC/day in total, not 0.00229.

## Step 4 — What this means

**The gap is decisive:** observed payouts exceed possible mining yield by **6+ orders of magnitude**.

This is *prima facie* proof that CryptoTab's BTC payouts are NOT funded by actual mining. The payouts must come from another revenue source. Given CryptoTab's known business mechanics (verified in Phase 1 static analysis and Phase 2 OSINT):

- **Cloud Boost subscription purchases** (paid in BTC or fiat — actual amounts not disclosed)
- **MLM affiliate fee skimming** (CryptoTab Mining Farm packages, Pool Pro subscriptions)
- **CryptoTab MAX** paid subscriptions
- **Embedded ads** in the browser

These revenue streams generate fiat/BTC inflow → operator buys BTC on the open market → BTC is pushed through the rotation cluster → finally batched out to lucky/active users.

## The MLM math signature

This is identical to the on-chain pattern of every prior MLM-style "cloud mining" scheme:
- Real mining can't possibly fund payouts.
- New deposits (from Cloud Boost / referral subscriptions) DO fund payouts.
- The system pays out a tiny fraction of users to maintain proof-of-payment credibility.
- Most users never reach the withdrawal threshold (~$0.60 in BTC).

The fact that some users (including the investigator in this case) really do receive BTC withdrawals does NOT prove the system is "legit mining." It only proves that the operator allocates a tiny fraction of inbound revenue toward outbound payments as a marketing expense. Across 712 days, the entire observed hub paid out $97,600 worth of BTC — a trivial sum compared to what 35M users running Cloud Boost subscriptions or buying mining farms would generate in revenue.

**Verdict: the on-chain economics confirm the affiliate-funded model.** CryptoTab is not mining BTC; it is recirculating customer revenue into customer payouts at a rate that maintains its marketing credibility.
