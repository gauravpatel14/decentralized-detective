# flashusd.com.tr — Wallet Inventory

All addresses extracted from the site's public HTML/JS. On-chain status verified via Tronscan / public RPC / Blockstream / OKLink at investigation time (2026-05-15).

## Address #1 — "Social Proof" wallet (NOT the operator)

| Field | Value |
|---|---|
| Address | `TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N` |
| Chain | Tron (TRC20) |
| First seen on site | Homepage line 4620 + 6573, as `TRON_ADDR` |
| Page usage | Source for the live "VERIFIED TX" grid via Tronscan API |
| Created | 2023-05-01 (~3 years old, well-established) |
| TRX balance | **319,531,831 TRX** (~$95M+ at current prices) |
| USDT balance | **46,129,998 USDT** (verified via OKLink) |
| Token count | 268 different TRC20 tokens (HTX, WTRX, WBTT, BTC-bridged, ETH-bridged, etc.) |
| Tronscan tag | None (untagged) |
| OKLink tag | None (untagged) |

**Conclusion**: This is a real, unlabeled whale or exchange hot wallet holding ~$46M USDT.
**It does not belong to the flashusd.com.tr operator.** The site simply hits the public
Tronscan API for this wallet's transfers and re-renders them as a "live verified transaction"
feed, fooling new visitors into thinking massive USDT flows are flowing through the platform.

This is the same proof-padding pattern documented in the USDTFLASH-PROOF-20260514 case file.

---

## Address #2 — Actual TRC20 fee-payment wallet

| Field | Value |
|---|---|
| Address | `TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33` |
| Chain | Tron (TRC20) |
| First seen on site | `trc20.html` line 3719 (displayed as pay-address) + line 3988 (ADDRS.TRC20) |
| Page usage | Direct on-chain payment fallback for the buy-flow on `/trc20.html` |
| Created | 2026-04-12 (**~1 month old at investigation**) |
| TRX balance | 5.243933 TRX (~$1.50) |
| USDT balance | 0 |
| Total incoming USDT (lifetime) | **$11.66 across 4 transactions** |
| Total outgoing USDT (lifetime) | **$11.66 across 4 transactions** (fully drained) |

### Lifetime inbound

```
2026-05-15  $5.83 USDT  from TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33  (SELF — test)
2026-05-15  $5.00 USDT  from TU4vEruv...r7Pvaa
2025-04-22  $0.03 USDT  from TQZCZccU...eGre4F
2025-02-19  $0.80 USDT  from TXAk3cty...E9SyNU
```

### Lifetime outbound (drain pattern)

```
2026-05-15  $5.83 USDT  to TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3   (consolidation hub)
2026-05-15  $5.00 USDT  to TQDwWFmC...DE33   (self)
2025-04-22  $0.03 USDT  to TQDwWFmC...DE33   (self)
2025-02-19  $0.80 USDT  to TXAk3cty...E9SyNU (back-to-sender — test refund)
```

**Conclusion**: This wallet has received **$11.66 in real victim money in its entire
lifetime**. It is either (a) a fresh test wallet with virtually no traction, or (b) a
decoy — the actual payments flow through OxaPay (see Architecture below).

The $5.83 drain to `TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3` is a consolidation pattern.

---

## Address #3 — Consolidation hub (drain target)

| Field | Value |
|---|---|
| Address | `TNY1aaLAsmddN2ERG2AjBTefRa1wKq1Cs3` |
| Chain | Tron (TRC20) |
| Created | 2026-03-22 (~7 weeks old) |
| TRX balance | 1.000002 |
| USDT balance | **5.83** (the entire drain from address #2) |
| Token count | 1 (USDT) |

**Conclusion**: A second-hop consolidation address. Receiving the trickle from #2.
Single-purpose, fresh, no activity beyond the one drain.

---

## Address #4 — Claimed ERC20 / BEP20 / USDC fee wallet

| Field | Value |
|---|---|
| Address | `0xb5f5090D4f032059844c464C7A273D29063311c1` |
| Chains | Ethereum, BSC (per `ADDRS` table in trc20.html) |
| ETH balance | 0 ETH |
| ETH outbound tx count | 0 |
| ETH USDT balance | 0 USDT |
| BNB balance | 0 BNB |
| BSC outbound tx count | 0 |
| BSC USDT (BEP20) balance | 0 USDT |

**Conclusion**: Completely unused on both Ethereum and BSC. No activity ever.
Either a decoy placeholder or a never-deployed wallet.

---

## Address #5 — Claimed Bitcoin fee wallet (already marked "closed")

| Field | Value |
|---|---|
| Address | `bc1qwwqwkkw7aqvg5j58peskg0hw4xuyeeucahg7gl` |
| Chain | Bitcoin (bech32 segwit) |
| In-page comment | `// closed` (their own JS comment) |
| Funded TXO count | 0 |
| Spent TXO count | 0 |
| Lifetime tx count | **0** |

**Conclusion**: Zero on-chain activity, ever. The operator's own JS comment says "closed".

---

## Tether reference addresses (NOT scam wallets — for context only)

| Address | Chain | Purpose |
|---|---|---|
| `TR7NHqjeKQxGTCi8q8ZY4pL8otSzgjLj6t` | Tron | Real Tether USD (TRC20) contract |
| `0xdac17f958d2ee523a2206206994597c13d831ec7` | Ethereum | Real Tether USD (ERC20) contract |
| `0x55d398326f99059fF775485246999027B3197955` | BSC | Real Tether USD (BEP20) contract |

These are linked from the site as "Token Contracts" — they are the legitimate Tether
contracts, used by the site to lend credibility.

---

## The architecture that explains the empty wallets

From `trc20.html` line 4003:

```javascript
deposit_address: localStorage.getItem('last_oxapay_url') || null
```

The site uses **OxaPay** (oxapay.com) — a Turkish-popular crypto payment processor that
issues a **unique per-invoice receive address** for each victim transaction. That's why
the direct wallets on the page show essentially zero activity: they're decoy/fallback
addresses. The actual money flows through OxaPay's gateway.

To trace the real money:
1. The operator's OxaPay account is the chokepoint
2. OxaPay aggregates per-invoice deposits → forwards to the operator's settlement wallet
3. The settlement wallet is one OxaPay would know but isn't exposed on the public site
4. Investigation would require OxaPay's cooperation (subpoena territory)

This is a notable difference from AITRO-FLASH-20260514 (direct-to-wallet TRC20 transfer)
and matches the institutional-grade scam evolution: use a real payment processor so the
hot wallet displayed isn't the actual fund destination, frustrating direct on-chain tracing.
