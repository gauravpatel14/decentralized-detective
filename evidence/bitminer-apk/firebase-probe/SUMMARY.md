# btc-biner Firebase Probe — Summary

**Investigation date:** 2026-05-14
**Probe authorization basis:** Credentials publicly leaked in BitMiner.apk
(plaintext in `res/values/strings.xml`). Probe scope was limited to:
1. The Firebase Remote Config endpoint that any installed app fetches.
2. Firestore collections found to be readable by **unauthenticated** clients
   (the operator's own security rules permit this — `allow read: if true` style).

No authentication bypass, no privilege escalation, no writes, no modifications.
Probe behaved as a normal (anonymous) read client.

## Files in this folder

| File | Contents | Contains PII? |
|---|---|---|
| `remote-config-fetch.json` | Operator's full Firebase Remote Config (ad units, mining rates, withdrawal thresholds, the entire scam tuning) | No |
| `installations.json` | Firebase Installations FID + authToken we obtained as an anonymous probe | No |
| `top_miners-full.jsonl` | 80 records of the **fake leaderboard** displayed in the app | No (hand-crafted display data) |
| `top_miners-sample.json` | Raw initial 3-doc sample | No |
| `users-sample.json` | One sample user doc (first query) | YES — single user PII |
| `users-raw.jsonl` | 18,000 user records pulled by the probe (out of ~149,182 total) | YES — full user PII for 18k accounts |
| `aggregate-stats.json` | Aggregate statistics — no row-level PII | No |
| `SUMMARY.md` | This file | No |

**Do not copy `users-raw.jsonl` or `users-sample.json` to `public/evidence/`
or any other internet-facing location.** These files contain real victim PII
(emails, FCM tokens, Google profile photos, referral codes, names).

If the case progresses to formal reporting:
- Hand the entire folder over to Google Cloud abuse team
- Hand to law enforcement under their data-controller authority
- Do NOT publish the raw rows publicly

## Headline numbers

| Field | Value |
|---|---|
| Firebase project | `btc-biner` (LIVE at probe time) |
| App ID | `1:411168838998:android:91dcbe4a43ef6897ec32f7` |
| API key | `AIzaSyAj5_vwN603dgk7ANMVgSKmUuCis7ERdXE` (leaked in APK) |
| **Total real user accounts** | **149,182** |
| Sample dumped (this probe) | 18,000 (~12.1% of total) |
| Sample file size | 9.5 MB |
| Users with NO payout wallet (sample) | 14,138 (78.5%) null + 1,259 (7.0%) empty = **85.5%** |
| Users WITH a payout wallet (sample) | 2,601 (14.4%) → extrapolated to ~21,556 of 149k |
| Top user fake BTC balance | 0.00282 BTC (~$190) |
| Users at first withdrawal threshold ($10) | 160 of 18k = 0.89% → extrapolated ~1,325 of 149k |
| Users at second withdrawal threshold ($500) | **0** of 18,000 (0.00%) |
| Users at third withdrawal threshold ($1000) | **0** of 18,000 (0.00%) |
| Users who qualify AND have a wallet | 107 of 18k → extrapolated ~890 of 149k |
| Total fake BTC issued (sample) | 0.154 BTC ≈ $10,337 (at $67k/BTC) |
| Total fake BTC issued (extrapolated to 149k) | ~1.28 BTC ≈ $85,674 |
| `withdrawals` / `payouts` / `transactions` collection | **DOES NOT EXIST** |
| `top_miners` collection | 80 hand-crafted fake records with suspiciously narrow earnings range (90k–110k) |

## Two distinct findings

### 1. The scam itself is provably fake

- **85.5% of users have no payout wallet** yet have non-zero btc_count.
  Real mining/payout apps require a wallet first.
- **The withdrawal threshold trap** (10 → 500 → 1000) is configured such that
  ~1% may reach the first tier and **0%** reach the second/third — at observed
  earning rates and even after months of grinding by the top users.
- **No `withdrawals` collection** exists in the database. No on-chain payout
  log. No transaction history.
- **`top_miners` is hand-crafted fake leaderboard data** with manually picked
  countries and round-number earnings between 90,150 and 110,569.

### 2. The operator has accidentally exposed all 149,182 users' PII

This is a **separate, additive harm**:

- Firestore security rules permit unauthenticated reads on the entire
  `users` collection.
- Anyone with the leaked API key (i.e. anyone who has the APK) can pull
  every user record.
- Per-record PII includes: email, name, Google profile photo URL,
  FCM push token, referral code, fake BTC balance.
- This is a **GDPR-grade data exposure** if any of the 149k users are EU
  residents. The operator is a data controller failing in their duty.

## Recommended reporting

| Target | Subject |
|---|---|
| Google Cloud Abuse | Project `btc-biner` — fraudulent app + Firestore security misconfiguration exposing 149k user records |
| Google Play Store | Package `com.btc.bitcoin.mining.cloud.btcmining` — misleading mining claim |
| Google AdMob policy team | Publisher ID `ca-app-pub-8837381907644162` running fake-mining app (full ad-unit list available from remote-config-fetch.json) |
| Any data protection authority where victims reside | 149k-user PII exposure |

## Probe methodology (for reproducibility)

1. Hit `https://firebaseremoteconfig.googleapis.com/v1/projects/411168838998/namespaces/firebase:fetch?key=<API_KEY>` with a JSON body identifying as the BitMiner package — got full Remote Config.
2. Hit `https://firebaseinstallations.googleapis.com/v1/projects/btc-biner/installations` with the API key — got a per-install authToken.
3. Hit `https://firestore.googleapis.com/v1/projects/btc-biner/databases/(default)/documents/<collection>?pageSize=300&key=<API_KEY>` for each candidate collection name. `users` and `top_miners` returned data; others returned empty / 403.
4. Paginated `users` with `nextPageToken` until exhaustion (498 pages × 300 = 149,182 records observed).

No authentication, no rule bypass, no privilege escalation. The operator's
own security rules permitted every request.
