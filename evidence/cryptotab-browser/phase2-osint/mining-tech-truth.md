# Mining — Technical Truth

## What is actually mined? (Confirmed from the company's own FAQ)

CryptoTab Browser is marketed as **"mine BTC while you browse"**, but the company's own help center admits this is not what's happening:

> *"In fact, CryptoTab software mines **Monero (XMR)** and converts Monero to Bitcoin according to current exchange rate."*

— https://cryptobrowser.site/en/faq/mining/mine-other-cryptocurrencies/

This is the most important technical disclosure in the entire CryptoTab body of documentation. The displayed-on-screen "BTC accrual" is a **derived value**: actual mining is on Monero's RandomX algorithm, balances are tracked in BTC by applying the live XMR/BTC exchange rate, and withdrawals are paid in BTC.

This makes structural sense:
- **Real Bitcoin mining** requires ASICs (specialized hardware). A consumer CPU cannot meaningfully contribute to BTC's hashrate — its share of the network would round to zero. A CPU mining BTC would earn approximately **$0 over a human lifetime**.
- **Monero's RandomX** is deliberately CPU-friendly (ASIC-resistant by design). A consumer CPU can produce a measurable share of the Monero hashrate, and pooled CPU mining of XMR is a real, established practice.

So CryptoTab is **not lying about doing crypto mining** — it's lying about **which crypto**.

## Measured benchmarks — real per-hour rates on common CPUs

Sources: pool.kryptex.com, cryptoage.com, 9to5mac.com, and forum aggregations.

### RandomX (Monero) hashrate by CPU:

| CPU | Hashrate | Power | Notes |
|---|---|---|---|
| Apple M1 (8-core) | ~2–5 KH/s (≈ 2,000–5,000 H/s) | ~17 W | Power-efficient but low absolute rate |
| Apple M1 Pro (10-core) | ~5 KH/s | ~17–25 W | 9to5mac: "just over 5 Mh/s" was a typo — actual is ~5 KH/s on RandomX |
| Apple M2 / M3 | ~5–8 KH/s | similar | Improved single-threaded throughput |
| Intel i5-12600K | ~6–9 KH/s | ~65 W | Strong RandomX, but power cost matters |
| Intel i7-1165G7 (laptop) | ~2.7 KH/s | low | Source: cryptoage.com |
| AMD Ryzen 7 5800H | ~5.4 KH/s | mid | Mobile/laptop AMD chip |
| AMD Ryzen 9 7950X (desktop top) | ~20–25 KH/s | ~170 W | Best consumer CPU for RandomX |

### Translating that to real BTC earnings:

At ~5 KH/s, Monero pool difficulty, and an XMR price around $150–200 and BTC at $70–100k:
- **Gross XMR earned per day** ≈ 0.00007 XMR ≈ $0.012–$0.014/day
- **Converted to BTC** ≈ 0.0000001–0.0000002 BTC/day
- **At CryptoTab's $4/month claim**, that implies the user is earning **~$0.13/day**, which is **~10× the realistic CPU-mining yield** at advertised hashrates.

The math only works if either:
- (a) CryptoTab's reported hashrate massively overstates the actual cryptographic work being done, OR
- (b) Cloud.Boost / Pro / Max users are subsidizing the free-tier "$4 average," OR
- (c) Both.

## What is Cloud.Boost actually doing?

This is the structurally most important technical question, and the company **does not explain it in plain text on their site**.

The marketing copy says (https://cryptobrowser.site/en/cloudboost/):
> *"Cloud.Boost is unlimited speed without power consumption … 1500× faster mining with Cloud.Boost"*

The phrase "without power consumption" is the giveaway. It means: **the boost is not doing more cryptographic work on your hardware.** It is also not — based on the absence of any technical disclosure — described as renting additional remote ASIC/CPU hashing power on the user's behalf.

Two possible technical implementations are consistent with the public marketing:

1. **Aggregation-pool credit allocation** — The operator runs (or buys hashpower from) a real mining pool/farm; "Cloud.Boost" reassigns a share of that pool's output to the booster's account. The user pays a fixed fee, the operator delivers a fixed slice of pool revenue, and the operator pockets the spread.
2. **Display multiplier with operator-funded payouts** — The boost is purely a UI multiplier on the displayed BTC accrual rate; actual payouts come from the Cloud.Boost-purchase revenue pool (i.e. other Cloud.Boost buyers). This is functionally a paid subscription with "earnings" that approximate but never quite equal the subscription cost.

In either case, **the source of the BTC paid out to a Cloud.Boost user is operator funds, not the user's CPU**. The only meaningful difference between (1) and (2) is whether the operator actually runs/buys real hashpower behind the scenes. Public OSINT cannot definitively distinguish — there is no public disclosure of an operator-side mining farm or hashpower agreement.

What the FAQ **does** confirm is that Cloud.Boost subscriptions can be paid with the user's accrued mined balance (https://cryptobrowser.site/en/news/cloudboost-btc-balance/), which means at least some of the inflow is recycled balance, not fresh BTC.

## Comparison to "CryptoTab Farm" — separate product, different model

The operator's separate product **CryptoTab Farm** (https://cryptotab.farm) is sold as desktop-software for managing **many** computers' mining at once. It's marketed at people who want to convert spare PCs into rigs. This is the closest thing to honest CPU-mining product CryptoCompany OÜ sells — and notably it does NOT emphasize the same affiliate pyramid. The fact that the operator runs both a clean-ish product (Farm) and an MLM-funnel product (Browser) is consistent with **the Browser being primarily a recruitment/Cloud.Boost-selling vehicle**, not primarily a mining tool.

## Bottom line — technical truth in one paragraph

CryptoTab Browser performs real **Monero (XMR) RandomX CPU mining** on the user's machine, then displays the proceeds as Bitcoin using the live exchange rate. Real per-device earnings at consumer-CPU hashrates are on the order of **$0.01–$0.15 per day gross**, the majority of which is captured by the operator before user payout. **Cloud.Boost** is a paid multiplier subscription whose underlying mechanic is not technically disclosed; on the public evidence it most plausibly works as either a pool-credit reallocation or a UI multiplier funded by Cloud.Boost subscription revenue, neither of which corresponds to additional cryptographic work being done on the user's behalf. The marketing claim of "1500× faster" describes a UI/account multiplier, **not** 1500× more hashes per second.

Sources:
- https://cryptobrowser.site/en/faq/mining/mine-other-cryptocurrencies/ (admission: mines Monero, converts to BTC)
- https://cryptobrowser.site/en/faq/
- https://cryptobrowser.site/en/cloudboost/
- https://cryptobrowser.site/en/news/cloudboost-x15/
- https://cryptobrowser.site/en/news/cloudboost-btc-balance/
- https://9to5mac.com/2021/11/10/m1-pro-macbook-pro-cryptocurrency-mining/
- https://www.aldomedia.com/blog/apple-m5-crypto-mining-profitability
- https://pool.kryptex.com/device/cpu/apple/apple-m1
- https://cryptoage.com/en/2655-apple-m1-pro-and-m1-max-tested-in-mining-monero-cryptocurrency-randomx.html
- https://www.cpubenchmark.net/cpu.php?cpu=Apple+M1+8+Core+3200+MHz&id=4104
- https://cryptotab.farm/
