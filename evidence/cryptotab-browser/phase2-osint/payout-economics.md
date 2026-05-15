# Payout Economics — Where Does the Money Actually Come From?

## The central question

The user has personally received three withdrawals from CryptoTab. That is genuine on-chain BTC. So the question is **not** "is it a scam" — it's **"what funds the payouts and what is the steady-state economics?"**

## Steady-state hypothesis

Net inflows to the operator have three sources:

1. **Cloud.Boost purchases** (paid in BTC or with mined-balance) — the high-margin product.
2. **CryptoTab Pro / Max paid-tier app upgrades.**
3. **Mining revenue actually generated** by the entire user base — real but tiny per user.

Net outflows have two sources:

1. **Real mining payouts** (the CPU work each user did — pennies per day).
2. **Affiliate commissions** (the 36.94% theoretical / ~25% effective slice paid to upline networks).

Because mining at modest CPU speeds yields **fractions of a cent per hour per machine** (see `mining-tech-truth.md`), the bulk of the payouts the operator distributes can only be funded by **Cloud.Boost purchases and Pro/Max upgrade revenue**. This is structurally consistent with a **subsidy-from-paid-users model**, where buyers of Cloud.Boost effectively subsidize the payouts that go to small free miners and to upline affiliates.

This is **not** a pure Ponzi (where new deposits pay old "investors"). It is closer to a **paid-feature MLM** where the paid feature (Cloud.Boost) funds the affiliate-commission stack and the small free-tier payouts that maintain credibility.

## Evidence supporting this hypothesis

### (a) The mining math doesn't reconcile

- CryptoTab itself says its earnings calculator uses **"$4/month average per user"** (https://hive.blog/browser-based/@access/cryptotab-browser-review-2025...).
- Real CPU mining of Monero (which CryptoTab admits is what it actually does — see `mining-tech-truth.md`) on an Apple M1 produces ~2–5 MH/s of RandomX. At current Monero pool difficulty, that's ~$0.05–$0.15/day **gross** — most of which is captured by the operator before being converted to BTC.
- Multiplied across 35M claimed users, that's ~$1–3M/month of real mining revenue at most.
- Yet the company declares Estonian turnover of **€4.9M in 2024 and projects €9.1M in 2026** (per inforegister.ee), and that's only CryptoCompany OÜ — not counting CryptoTab OÜ, True Wallet OÜ, or Code Wizard OÜ.
- The delta points to **paid-feature revenue (Cloud.Boost + Pro/Max) being the dominant inflow**, not mining.

### (b) The "pay with CryptoTab funds" loop

The official Cloud.Boost purchase flow allows users to **buy boosts using the BTC they've "mined"** rather than withdrawing it (https://cryptobrowser.site/en/news/cloudboost-btc-balance/, and explicitly documented at https://cryptobrowser.site/en/cloudboost/ctpay/). This means a meaningful fraction of accrued balances **never leave the operator's books at all** — they recycle into Cloud.Boost subscriptions, which is precisely the cost-control mechanism a paid-feature pyramid would design.

### (c) The "small payouts approved, big payouts blocked" pattern

This is the single most consistent complaint across Trustpilot, Sitejabber, Reddit, and Google Play reviews:

- **Trustpilot:** *"The app approves withdrawals for small amounts in the beginning, creating a false impression that it works, but when the balance grows and a larger withdrawal is requested, the payment is stopped and remains 'pending' forever."* (paraphrased pattern across reviews — https://www.trustpilot.com/review/cryptobrowser.site)
- **Specific Trustpilot reports:**
  - Pending withdrawal not processed for **8 months**.
  - Pending Bitcoin withdrawal of **0.00245125 BTC for over 1.5 years**.
  - Funds stuck in "Processing" for **>7.5 months** with no refund and templated support responses.
- **Sitejabber:** Pattern of accounts "suspended" right after a user attempts to withdraw a large balance. Cited reason is "violation of Terms of Use" (which is the FAQ-stated termination clause — see `mlm-structure.md`).
- **Reddit thread cited by androidb.com (2024):** "70+ replies … CryptoTab was acceptable in the past but now blocks a large number of payments."
- **Google Play Community thread:** Users reporting accounts being terminated "with no detail" after purchasing Cloud.Boost subscriptions.
- **Medium investigation:** *"Another has 10 withdrawals 'pending' since February 19th, totaling over 73,000 satoshis — with no way to cancel, no refund."* (https://medium.com/the-pub/cryptotab-its-a-scam-and-it-s-hiding-in-plain-sight-...)

This is a classic **MLM cost-control mechanism**: honor small payouts to keep the recruitment story credible, block or zero large payouts where individual users have built balances large enough to threaten unit economics.

### (d) The user's three personal payouts fit the pattern

The user reports three completed withdrawals. The fact that they were completed places those withdrawals on the **small / sub-threshold** side of the operator's risk tolerance. The OSINT pattern is consistent: the user has not yet crossed the implicit threshold where the operator's adverse-selection moderation activates.

## Time-to-first-withdrawal — community reports

- Self-reported solo (no referrals) users on Reddit and Quora report **months of CPU-only mining** to reach the 0.00001 BTC minimum, then several days to processing.
- Active affiliates with downlines report first BTC withdrawals within **2–4 weeks** of recruiting a handful of L1 users.
- "Pro" users running Cloud.Boost x10 or x15 report withdrawals within **days** at small amounts.

(Aggregated from Trustpilot pages 1–8, Sitejabber, and the bittime.com / asknaij.com review pages.)

## Reported per-machine earnings

| Setup | Reported per-day BTC value | Source |
|---|---|---|
| Free Lite, M1 CPU, no boost | **$0.01–$0.05/day** equivalent in BTC | Quora aggregations |
| Free Lite, Intel i5/i7, no boost | **$0.02–$0.10/day** | Quora, Trustpilot |
| Pro tier + x10 Cloud.Boost | **$0.30–$2/day** equivalent (multiplier display) | Marketing claim 1500 H/s; user-reported low end |
| Max tier + x15 Cloud.Boost | **$1–$5/day** (display value) | Marketing claim 2000 H/s; rare user reports |

Important caveat: the **displayed BTC accrual rate** on screen is not necessarily the real hashrate × pool rate. The boost is, per the FAQ, "a multiplier on your mining count" — it does not necessarily correspond to additional real cryptographic work being done off-device on the user's behalf (see `mining-tech-truth.md`).

## Account zeroing / "fraud" claim mechanism

Documented from public reviews:

1. User mines on free tier, accrues ~$5–$20 worth of BTC.
2. User buys Cloud.Boost (~$22 for 3-month x4 reported price) hoping to accelerate.
3. Balance grows to **$50–$300** range.
4. User requests withdrawal.
5. Withdrawal goes to "Pending" or "Processing" indefinitely; OR account is **terminated with a generic "Terms of Use violation" notice**; OR accrued balance is reset to zero.
6. Support responses are templated; no appeals path.

This sequence has been reported repeatedly across **Trustpilot (1.8★ Sitejabber, multi-page Trustpilot pattern), Google Play, Reddit, and Medium**.

## Conclusion

The payouts the user received are real BTC. The funding source for those payouts is, with very high confidence, **NOT primarily the mining work the user's machine performed** — it is, primarily, **revenue from paid Cloud.Boost subscriptions and Pro/Max app upgrades purchased by other users**, with a secondary contribution from real (Monero→BTC) mining revenue aggregated across the entire user base.

The operator manages payout cost by:
- Encouraging users to recycle balances into Cloud.Boost rather than withdraw.
- Approving small withdrawals freely (cheap, builds credibility).
- Slow-rolling or terminating large withdrawals via the open-ended "Terms of Use violation" clause.

This is a **paid-feature MLM with selective payout moderation**, not a pure Ponzi. It is legal under current Estonian/EU law because it pays out enough to enough people that no individual loss reaches a regulatory threshold. The cost is borne predominantly by Cloud.Boost buyers who never recover their investment.

Sources:
- https://www.trustpilot.com/review/cryptobrowser.site (and pages 2–8)
- https://www.trustpilot.com/review/cryptotab.com
- https://www.sitejabber.com/reviews/get.cryptobrowser.site
- https://support.google.com/googleplay/thread/295998521/cryptotab-browser-app-is-a-scam-should-be-investigated
- https://www.androidb.com/2024/12/cryptotab-scam/
- https://medium.com/the-pub/cryptotab-its-a-scam-and-it-s-hiding-in-plain-sight-e45f001316d7
- https://miningtip.com/cryptotab-browser/
- https://www.bittime.com/en/blog/apakah-cryptotab-browser-legit-atau-scam-analisis-mendalam
- https://www.inforegister.ee/en/14448767-CRYPTOCOMPANY-OU/
- https://cryptobrowser.site/en/news/cloudboost-btc-balance/
