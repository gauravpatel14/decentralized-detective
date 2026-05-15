# CryptoTab Affiliate / MLM Structure

## 10-level unilevel commission table

CryptoTab's affiliate compensation plan is a classic **MLM unilevel structure** paying commissions 10 levels deep on the mining activity (and Cloud.Boost purchases) of recruited users.

The numbers stated in the Phase 2 brief (15/10/10/5/5/5/5/5/5/5) are **incorrect** based on what the company itself publishes; multiple secondary sources reporting from the company's own affiliate dashboard give a different, sharply decaying curve:

| Level | Commission rate | Source notes |
|---|---|---|
| L1 (direct) | **15%** | Confirmed on cryptobrowser.site/en/affiliate/ — "15% recurring commission" |
| L2 | **10%** | Confirmed by multiple secondary sources & FAQ |
| L3 | **5%** | Confirmed |
| L4 | **3%** | Per born2invest review |
| L5 | **2%** | Per born2invest review |
| L6 | **1%** | Per born2invest review |
| L7 | **0.50%** | Per born2invest review |
| L8 | **0.25%** | Per born2invest review |
| L9 | **0.13%** | Per born2invest review (≈0.125%) |
| L10 | **0.0625%** (often written 0.06%) | Confirmed by hive.blog 2025 review and other sources |

Sources:
- https://cryptobrowser.site/en/affiliate/
- https://www.affpaying.com/cryptotabaffiliate
- https://born2invest.com/articles/cryptotab-affiliate-program-review/
- https://hive.blog/browser-based/@access/cryptotab-browser-review-2025...

Sum of all 10 levels ≈ **36.94%** of the mining output of every user below you on the tree — but only if every downstream level is fully active. In practice, retention drops sharply at each layer, so the effective payout is concentrated in L1 and L2.

The Phase 1 hypothesis was 95%+ payout outflow (15+10×9 = 105%) which would be impossible — the actual curve geometrically decays, so the operator keeps ~**63%** of mining proceeds plus 100% of unmatched Cloud.Boost purchases.

## Network structure / theoretical depth

Per the born2invest source, recruits per level cascade as 5× per layer (5, 25, 125, 625…), with L10 reaching ~9.77M cumulative downline — a textbook MLM hierarchy. There is **no explicit rank/title qualification system** (no "Bronze/Silver/Gold/Diamond" tier publicly documented on cryptobrowser.site as of May 2026); rather, the differentiation is via the **product tier** of the app itself:

| App tier | Basic mining speed | Comments |
|---|---|---|
| CryptoTab **Lite** (free) | ~300 H/s | Default install |
| CryptoTab **Pro** | ~1,500 H/s | Paid product upgrade |
| CryptoTab **Max** | ~2,000 H/s | Higher paid product tier |

Source: https://cryptotabbrowser.com/ — site explicitly states "Basic speed: 300 H/s (Lite), 1500 H/s (Pro), 2000 H/s (Max)"

## Cloud.Boost — the real revenue driver

"Cloud.Boost" is a paid **multiplier subscription** that multiplies the displayed mining rate by a fixed factor for a fixed time window. Multipliers offered:

- **x2**, **x5**, **x10**, **x15** (per https://cryptobrowser.site/en/cloudboost/)
- Marketing claim: combine multiple boosts; pool mining speed adds "up to 20 million H/s" (cryptotabbrowser.com)
- Marketing claim: "15x faster mining" (https://cryptobrowser.site/en/news/cloudboost-x15/)

Pricing in BTC/USD is **not openly published** on the landing pages — it requires clicking through to `cryptobrowser.site/cloudboost/buy/`. One concrete data point from a 2025 hive.blog review: a **3-month x4 multiplier was ~0.00039058 BTC (~$22 at the time)**. This is the only credible specific price found in OSINT. Pricing scales upward with multiplier; estimates from secondary reviews suggest x15 multi-month bundles run into the low-three-figure USD range.

Payment methods:
- Bitcoin direct
- "CryptoTab funds" (mined balance) — i.e., the user can pay for boosts with the balance they accrued, **never withdrawing real BTC at all**. This is structurally important — it means a non-trivial share of "mined" earnings cycle back into Cloud.Boost purchases without leaving the operator.

## Withdrawal mechanics

From the official FAQ (https://cryptobrowser.site/en/faq/):

- **Minimum withdrawal: 0.00001 BTC** (≈ $0.70 at $70k/BTC; ≈ $1 at $100k/BTC).
- **No fee stated** on the FAQ ("no commissions" per the hive.blog review).
- **Payout currency: BTC** sent to a user-provided external BTC address.
- **Account termination clause:** *"In case you see a warning that mining is blocked, it means your account is terminated. This can happen if CryptoTab Browser terms of use are violated in any manner."* — an open-ended clause that is the user-facing surface of the moderation/banning behavior documented in `payout-economics.md`.

## Official URLs and what each one is for

| Domain | Purpose |
|---|---|
| **cryptotabbrowser.com** | Public marketing front for the browser product; includes affiliate landing pages with `/{ref-id}/?p=...` paths. |
| **cryptobrowser.site** | Operational/help/account site — hosts FAQ, Cloud.Boost purchase flow, withdrawals page, affiliate program details, news/promo content. The primary functional site. |
| **get.cryptobrowser.site** | Direct-download / install-funnel landing (also referenced in Sitejabber complaints). |
| **cryptocompany.io / cryptocompany.site** | Corporate site for Cryptocompany OÜ (referenced in the Estonian register entry). |
| **cryptotab.net** | Older marketing/news subdomain still serving promo content (e.g. cryptotab.net/en/news/referrals-bonus-x3/). |
| **cryptotab.farm** | Separate product — "CryptoTab Farm" — for multi-PC mining management (https://cryptotab.farm/). Linked product line under same operator. |

## Verification gaps

The brief stated commissions as 15%/10%/10%/5%/5%/5%/5%/5%/5%/5%. The OSINT-recovered curve is sharply geometric (15/10/5/3/2/1/0.5/0.25/0.125/0.0625). The flat 5%-tail figure does **not** appear on the company's own materials and is likely conflation with another MLM scheme. If the user later screenshots the affiliate dashboard from inside the app (Phase 3+), that should be the definitive source.

Sources:
- https://cryptobrowser.site/en/affiliate/
- https://cryptobrowser.site/en/faq/
- https://cryptobrowser.site/en/cloudboost/
- https://cryptobrowser.site/en/news/cloudboost-x15/
- https://cryptotabbrowser.com/
- https://www.affpaying.com/cryptotabaffiliate
- https://born2invest.com/articles/cryptotab-affiliate-program-review/
- https://hive.blog/browser-based/@access/cryptotab-browser-review-2025-can-you-really-earn-btc-while-you-surf-features-cloud-boost-referral-math-and-real-world-results
