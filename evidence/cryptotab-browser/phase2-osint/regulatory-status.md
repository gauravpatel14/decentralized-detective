# Regulatory Status — CryptoCompany OÜ / CryptoTab Browser

This document records the result of regulator-warning-list checks against:
- **Cryptocompany OÜ** (Estonia, registry 14448767)
- **CryptoTab OÜ** (Estonia, registry 14429787)
- **Vadim Tuulik** (sole director and beneficial owner, Estonian personal ID 38607082775)

Public records were checked on May 14, 2026.

## UK — Financial Conduct Authority (FCA)

- **FCA Warning List of unauthorised firms** — https://www.fca.org.uk/consumers/warning-list-unauthorised-firms
- **Result: NOT LISTED** as of May 2026.
- Note: the FCA list is now extensive (>12,200 entries per protos.com) and CryptoTab has been aggressively marketed in the UK affiliate space for years without being added. This is consistent with the operator being technically a software publisher (not promoting "investments" within the FCA's MiCA-aligned definition) rather than a regulated financial services firm.

## United States

- **SEC EDGAR / Litigation Releases / Press Releases** — no actions on file against Cryptocompany OÜ, CryptoTab OÜ, or Vadim Tuulik.
- **FTC enforcement actions** — no match found.
- **State AG actions (NY, CA, TX, MA)** — no published action found.
- Result: no US regulatory action. Note that CryptoTab's payout model — paying small free-tier amounts and slow-rolling large ones — keeps individual losses below typical state-AG action thresholds.

## Estonia — Financial Intelligence Unit (Rahapesu Andmebüroo, FIU)

- **Cryptocompany OÜ does NOT appear to hold a Virtual Asset Service Provider (VASP) license.** Its EMTAK business activity code is **62901** ("Other information technology and computer service activities") — a non-financial classification.
- This is a deliberate structural choice: by framing itself as a software publisher rather than a custodian of user funds, the company avoids being regulated as a VASP under Estonian AML law.
- However, **CryptoTab does custody user balances** (mined BTC sits on the operator's books until withdrawn), and it does pay out BTC to external addresses. Under MiCA (in force since 30.12.2024 across the EU) and Estonia's Crypto Asset Market Act (CMA, force date 01.07.2024), this activity may meet the threshold for a "crypto-asset service provider" (CASP).
- From **01.07.2026**, all previously-issued VASP licenses are revoked and any CASP-classified business must hold a license issued by the **Estonian Financial Supervision Authority (FSA)**. Sources: https://charltonsquantum.com/estonia-virtual-assets-regulation/ and https://hacken.io/discover/estonia-crypto-license/.
- **Open question:** whether the Estonian FSA, when reviewing the perimeter of MiCA, will rule that CryptoTab's mining-payout business is a CASP. If yes, the company has 6 weeks from this report's date to hold a license or cease operations in Estonia. **No public statement from Cryptocompany OÜ on MiCA/CASP compliance has been found.**

## Estonia — tax and reporting compliance

From inforegister.ee (https://www.inforegister.ee/en/14448767-CRYPTOCOMPANY-OU/):
- **🔴 "Risky" credit rating** (score 0.99).
- **Active tax debt: €15,625.20** to the Estonian Tax and Customs Board, payment plan to 20.10.2026.
- **Multiple court-issued fines** for failure to file annual reports — 09.12.2023, 01.03.2024, 22.05.2024, 10.09.2024, 16.10.2024.
- One court decision in tax law case **3-23-2862/2 (14.12.2023)**.

These are administrative/civil findings, not criminal — but they indicate a company that has repeatedly failed to meet basic Estonian filing obligations.

## Germany — BaFin

- BaFin's unauthorised-business warning list — no listing for Cryptocompany OÜ or CryptoTab.
- Cryptocompany OÜ does **not** appear in BaFin's MiCA pre-passport registry as of May 2026.

## Switzerland — FINMA

- FINMA's warning list of unauthorised entities — no listing.

## France — AMF

- AMF "blacklist" of unauthorised crypto-asset service providers — no listing.

## Luxembourg — CSSF

- CSSF unauthorised entities list — no listing.

## Russia / CIS — Roskomnadzor

- Roskomnadzor (Russian internet regulator) blocklist — no listing found.
- This is notable given (a) CryptoTab marketing has historically been very active in Russian-speaking affiliate communities, and (b) Russian authorities have aggressively prosecuted crypto-MLM schemes (e.g. Finiko, Antares Trade). The absence of action suggests either insufficient consumer complaint volume in Russia or political/jurisdictional reasons.

## Google Play / App Store moderation

- **Google Play Community thread** (https://support.google.com/googleplay/thread/295998521/) — multiple users have filed reports asking Google to investigate CryptoTab Browser apps. As of May 2026 the apps remain published on Google Play and the App Store. The apps are also Apple-notarized (Team ID `46J7LAWF9F`) for the macOS distribution, per Phase 1 evidence.

## Summary — regulatory posture

CryptoCompany OÜ operates in a **regulatory grey zone**:

1. It is **legally registered and active** as an Estonian OÜ.
2. It is **not on any major regulator's warning list**.
3. It **does not hold a VASP license** in Estonia (and may technically need a MiCA CASP license once Estonia's FSA finalizes its scope rulings).
4. It has **multiple Estonian administrative compliance failures** (unfiled reports, current tax debt) but no criminal action.
5. Its products **remain available on Apple, Google Play, and direct download** with no platform-level enforcement.

The operator's regulatory strategy is to (a) classify itself as a software publisher, not a financial service provider; (b) keep individual user losses small enough to stay below complaint-action thresholds; (c) maintain a high enough volume of small honored withdrawals to keep credibility intact across review platforms.

**Absence of regulatory action is itself a data point**: it tells you the operator has, so far, kept the per-victim damage below the threshold that triggers consumer-protection enforcement in any jurisdiction.

Sources:
- https://www.fca.org.uk/consumers/warning-list-unauthorised-firms
- https://protos.com/fca-crypto-crackdown-brings-warning-list-up-to-12200-firms/
- https://www.inforegister.ee/en/14448767-CRYPTOCOMPANY-OU/
- https://ariregister.rik.ee/eng/company/14448767/CryptoCompany-O%C3%9C
- https://charltonsquantum.com/estonia-virtual-assets-regulation/
- https://hacken.io/discover/estonia-crypto-license/
- https://support.google.com/googleplay/thread/295998521/cryptotab-browser-app-is-a-scam-should-be-investigated
