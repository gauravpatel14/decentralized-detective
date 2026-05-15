# flashusd.com.tr — Cloudflare Bypass Results

**Investigation date**: 2026-05-15
**Status**: Partial. Operator infrastructure & jurisdiction fully attributed; exact web-origin IP not yet located.

## Verdict at a glance

| Goal | Status |
|---|---|
| Identify operator's email-hosting IP | ✅ Done — `94.73.187.201/202` (Natro / Cizgi Telekom, Istanbul) |
| Identify operator's DNS provider | ✅ Done — Cloudflare (`aarav.ns.cloudflare.com`, `meadow.ns.cloudflare.com`) |
| Identify operator's hosting provider | ✅ Done — Natro Hosting (TR) on Cizgi Telekom AS34619 |
| Identify operator's web origin server IP | ❌ Not found in scanned ranges — likely outside the SPF-published Natro IP list |
| Identify operator-controlled "mirror" domain | ✅ Done — `flashusd.xyz` on GitHub Pages with Natro NS |
| Identify operator's origin software | ✅ Done — LiteSpeed Web Server (leaked through Cloudflare header `x-turbo-charged-by: LiteSpeed`) |
| Identify operator personally | ❌ No — `.com.tr` WHOIS does not expose registrant; GitHub repo behind flashusd.xyz is private |

The bypass landed enough operator-attribution evidence to file abuse reports with Natro, Cloudflare, GitHub, BTK, and MASAK — even without the exact origin IP.

---

## 1. DNS reconnaissance

### Root flashusd.com.tr

```
A      → 172.67.146.8, 104.21.95.163       (Cloudflare anycast)
AAAA   → 2606:4700:3036::6815:5fa3, 2606:4700:3035::ac43:9208  (CF)
MX     → 5 mx-01.kurumsaleposta.com, 10 mx-02.kurumsaleposta.com
NS     → aarav.ns.cloudflare.com, meadow.ns.cloudflare.com
SOA    → aarav.ns.cloudflare.com. dns.cloudflare.com. ...
TXT    → google-site-verification=fNXEMuSkRG1Cw6JVzXc7xWQPBPif8jV-5LhPi9jzoJg
TXT    → v=spf1 include:_spfcls.natrohost.com include:_netblockshalon.natrohost.com ~all
```

### Mail server origin IPs (NOT Cloudflare)

```
mx-01.kurumsaleposta.com A → 94.73.187.201
mx-02.kurumsaleposta.com A → 94.73.187.202

WHOIS 94.73.187.201:
  inetnum:  94.73.187.0 - 94.73.187.255
  netname:  Octopus-Mail-Systems
  descr:    Cizgi Telekomunikasyon A.S.
            CIZGI TELEKOM BLOCK
  country:  TR
  origin:   AS34619
```

### Operator's SPF-published infrastructure netblocks

Expanded from the SPF macro chain (`_netblocks.natrohost.com`,
`_spfhalon01.natrohost.com`, `_spfhalon02.natrohost.com`):

```
ip4:89.19.0.0/22      (1,024 IPs)
ip4:89.19.6.240/28    (16)
ip4:89.19.9.128/26    (64)
ip4:89.19.11.0/24     (256)
ip4:89.19.11.65/26    (64)
ip4:89.19.12.16/28    (16)
ip4:89.19.13.0/27     (32)
ip4:89.19.15.16/28    (16)
ip4:89.19.17.0/28     (16)
ip4:37.148.215.240/28 (16)
ip4:85.159.65.16/28   (16)
ip4:85.159.69.0/27    (32)
ip4:85.159.70.128/27  (32)
ip4:85.159.70.240/28  (16)
ip4:94.73.131.240/28  (16)
ip4:94.73.135.240/28  (16)
ip4:94.73.144.44/32   (1 ← singleton)
ip4:94.73.145.39/32   (1 ← singleton)
ip4:94.73.169.0/24    (256)
ip4:94.73.188.0/24    (256)
ip4:94.73.189.0/24    (256)
ip4:94.73.190.0/24    (256)

Total: ~2,700 IPs
```

These are Natro Hosting's email-sending IP ranges. The web origin
appears to be **outside this published list**, meaning Natro's web
hosting subnets differ from its email-sending subnets — common for
shared hosts that segregate outbound SMTP from web origin IPs.

---

## 2. Origin scan attempts (Host header technique)

Method: for each candidate IP, send
`curl -sk -H "Host: flashusd.com.tr" https://<IP>/`
and check the response body for unique site signatures:
- `GTM-58GSNCVV` (the operator's Google Tag Manager ID)
- `6907a7b0b1879c890eda62c1` (the operator's mockapi.io project ID)
- `TT2T17KZhoDu47i2E4FWxfG79zdkEWkU9N` (the social-proof Tron wallet)
- `TQDwWFmC2fMCDzLmrndc2bsiB7vK78DE33` (the real fee wallet)
- `FLASH USDT ADMIN` (the operator's author meta)

### Scan 1 — small SPF subnets (342 IPs)

Initial run with looser matching produced one apparent hit at
`94.73.144.44`, but on inspection that IP is a Microsoft IIS 10.0
server returning a 404 page with `notFoundSite=flashusd.com.tr`
as a URL parameter — the match string was just echoed in the error
URL, not actual site content. **False positive.**

`94.73.144.44` is a 499-domain shared IIS server at Natro (Cizgi
Istanbul). Saved domains list at `reverse-ip-94.73.144.44.txt`.

### Scan 2 — larger Natro /24 subnets (2,304 IPs)

Run with strict unique-signature matching against:
- `89.19.0.0/22` (1024 IPs)
- `94.73.190.0/24` (256)
- `94.73.169.0/24` (256)
- `94.73.189.0/24` (256)
- `94.73.188.0/24` (256)
- `89.19.11.0/24` (256)

**Result: 0 hits.** No IP in these ranges serves the actual
flashusd.com.tr content when accessed directly via Host header.

Conclusion: the web origin is in a Natro range NOT published in the
SPF email-sending whitelist, OR on a different hosting provider
entirely.

---

## 3. The flashusd.xyz GitHub Pages mirror (operator confirmation)

A passive urlscan.io query surfaced a related domain:

```
flashusd.xyz
  A:    185.199.108-111.153   (GitHub Pages anycast)
  NS:   ns1.natrohost.com, ns2.natrohost.com   (Natro DNS!)
  SSL:  Let's Encrypt R12, Subject CN=flashusd.xyz
  Title: "FLASH USDT — • Tether • TRC20 • ERC20 • BEP20 — FlashLoan"
  Canonical link: https://flashusd.com.tr/      ← explicit owner declaration
  Author meta:     "FLASH USDT ADMIN"            ← same operator string
  Telegram:        t.me/flashusdcom              ← same operator channel
  Sitemap last-modified: 2025-11-03T22:00:00+03:00   ← Turkey timezone
```

**Significance**:
- Same operator hosts `flashusd.xyz` on GitHub Pages (free, anonymous
  hosting) with the **same content shell** and a `canonical` link
  pointing to the main `.com.tr` site
- GitHub Pages requires a GitHub account — operator has one
- Apex DNS configuration (no CNAME file present at `/CNAME`)
- GitHub code search for "flashusd.com.tr" returned **0 hits**,
  meaning the repo behind `flashusd.xyz` is **private** (requires
  paid GitHub plan)
- Operator was active **at least since November 2025** based on the
  sitemap.xml `lastmod` timestamp

---

## 4. Where the bypass dead-ends

The remaining options to actually pinpoint the origin IP all require
either paid API access or active probing of the operator's
infrastructure:

| Technique | Status | Why dead-ended |
|---|---|---|
| `crt.sh` CT logs | ❌ HTTP 502 at investigation | Backend down |
| `certspotter` | ✅ Run | Only wildcard cert; no subdomains issued |
| `viewdns.info` historical | ⚠️ Requires API key | Free tier limited; needs paid plan |
| `securitytrails.com` | ⚠️ Requires API key | Same |
| `dnsdumpster` | ⚠️ Requires browser session | Anti-bot |
| `shodan.io` HTML search | ❌ Requires API key | Anonymous search limited |
| `censys.io` host search | ❌ HTTP 403 | Login required |
| `onyphe.io` | ⚠️ Anonymous-search blocked | Free tier limited |
| `fofa.info` | ⚠️ Requires login | Same |
| Mass IP scan of ALL Natro IPs (~10K+) | ⏱️ Time-consuming | Possible from a Turkish exit node; rate-limited from elsewhere |
| Email bounce headers | ❌ Out of scope | Active interaction with operator's mail server |
| BGPview API for AS34619 prefixes | ⚠️ Network blocked from current host | Could retry from different network |

A successful next step would be **Shodan or Censys paid query**:
`http.html:"GTM-58GSNCVV"` or `http.html:"6907a7b0b1879c890eda62c1"` —
that would identify any IP that serves this exact GTM ID or mockapi
project ID in its HTML response. Single-API-call confirmation.

---

## 5. What we **do** have (sufficient for abuse reports)

Even without the exact origin IP, the bypass produced enough
infrastructure attribution to act on:

### Operator's email infrastructure (definitive)

```
Mail servers: mx-01.kurumsaleposta.com (94.73.187.201)
              mx-02.kurumsaleposta.com (94.73.187.202)
Provider:     Natro Hosting / "kurumsaleposta.com" (Turkish corporate email)
ASN:          AS34619 (Cizgi Telekom A.S., Istanbul, TR)
Netblock:     94.73.187.0/24 (Octopus-Mail-Systems)
Datacenter:   Gulbahar Mah. Elif Sok. No4 K3, Sisli, Istanbul, Turkey
```

### Operator's web hosting provider (high confidence)

- **Natro Hosting** (Turkish hosting company)
- Connected via:
  - DNS (NS records on flashusd.xyz)
  - SPF chain (`_netblockshalon.natrohost.com` etc.)
  - Email MX hosting (kurumsaleposta.com is Natro's brand)
  - LiteSpeed Web Server (Natro's standard hosting stack)
  - Same upstream ISP as mail (Cizgi AS34619)

### Operator's chosen anonymity stack

| Component | Provider | Lever |
|---|---|---|
| Domain | `.com.tr` (Turkey BTK registry) | BTK abuse report |
| DNS / CDN | Cloudflare | Cloudflare Trust & Safety report |
| Web hosting | Natro Hosting (Turkey) | Natro abuse report → identifies customer |
| Email | Natro / kurumsaleposta.com | Natro abuse report |
| ISP / Datacenter | Cizgi Telekom A.S. (Istanbul) | RIPE abuse-c contacts: `NCBG1-RIPE`, `NN1321-RIPE` |
| Mirror domain | flashusd.xyz on GitHub Pages | **GitHub Trust & Safety report** |
| Payment processor | OxaPay | **OxaPay compliance — the actual settlement chokepoint** |
| Analytics | Google Tag Manager `GTM-58GSNCVV` | Google subpoena → operator's Google account KYC |

### Operator personal identity fingerprints

- **Turkish-speaking** (multiple JS comments in Turkish)
- **`.com.tr` registrant** (must satisfy BTK rules for Turkish entity/trademark)
- **Operator active since at least November 2025** (per `flashusd.xyz` sitemap)
- **Multiple alias handles**: `@flashusdcom` (Telegram), `@FlashUSDT` (Twitter), `@flashusdt` (Instagram)
- **GitHub account holder** (the private repo behind flashusd.xyz)
- **Self-declared author**: "FLASH USDT ADMIN" (the meta-author tag)

---

## 6. The Cloudflare /cdn-cgi/trace endpoint (sanity check)

Just to confirm: the operator's CDN config does not leak more than
expected.

```
GET https://flashusd.com.tr/cdn-cgi/trace
→
fl=1131f100
h=flashusd.com.tr
ip=2401:4900:8feb:823b:9413:4f5:668b:6d25   (← my IP, irrelevant)
ts=1778835456.000
visit_scheme=https
uag=Mozilla/5.0
colo=MRS                                       (Marseille CF edge)
sliver=none
http=http/2
loc=IN                                         (← my location, irrelevant)
tls=TLSv1.3
sni=plaintext
warp=off
gateway=off
rbi=off
kex=X25519
```

No origin leak — Cloudflare is configured correctly on the
operator's side.

---

## 7. Files generated by this phase

```
evidence/flashusd-com-tr/cloudflare-bypass/
├── CLOUDFLARE-BYPASS-RESULTS.md         (this file)
├── cf-ipv4-ranges.txt                   (Cloudflare's own IP ranges for filtering)
├── certspotter.json                     (CT log query result — only wildcard cert)
├── crt-flashusd.json                    (502 from crt.sh)
├── crt-flashusd-exact.json              (same)
├── github-search.json                   (GitHub code search — 0 hits)
├── github-repos.json                    (GitHub repo search — 109 unrelated flashusd-* repos)
├── urlscan.json                         (urlscan.io result — flashusd.xyz discovery)
├── viewdns-iphistory.html               (ViewDNS landing — needs paid API)
├── flashusd.xyz.html                    (full GH Pages mirror page)
├── flashusd.xyz.headers                 (CF / GitHub Pages headers)
├── origin-94.73.144.44.html             (false-positive IIS 404 page)
├── origin-default.html                  (same IP, default response)
├── origin-index.html                    (IIS 10.0 detailed error)
├── reverse-ip-94.73.144.44.txt          (499 sibling domains on Natro IIS server)
├── whois-94.73.144.44.txt               (full WHOIS for the false-positive IP)
├── natro-scan-results.txt               (small-range scan output)
├── natro-big-scan-results.txt           (big-range scan output — 0 hits)
├── bgpview-as34619.json                 (empty — network blocked here)
└── bgpview-natro.json                   (same)
```

---

## 8. Recommended next steps (in priority order)

1. **Shodan paid query**: `http.html:"GTM-58GSNCVV"` or
   `http.html:"6907a7b0b1879c890eda62c1"` — single API call,
   guaranteed to return the origin IP if Shodan has indexed it.
2. **Censys paid query**: same idea, with `services.http.response.html`.
3. **Natro abuse report**: file abuse against the customer behind
   `flashusd.com.tr` — Natro maintains internal customer records
   and can suspend or attribute regardless of the exact origin IP.
4. **GitHub Trust & Safety report**: file against `flashusd.xyz` —
   GitHub will receive the operator's account KYC + payment-method
   data internally, even if we never see it.
5. **OxaPay compliance**: subpoena via MASAK for the operator's
   OxaPay merchant account.
6. **Cloudflare abuse**: report `flashusd.com.tr` for fraud; CF can
   reveal origin IP under legal process.
7. **BTK abuse**: domain takedown for `.com.tr` policy violations.

None of these require pinpointing the origin IP first — every one
operates at the provider level, where the operator's identity is
known internally.
