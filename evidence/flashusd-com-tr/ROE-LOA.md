---

## Rules of Engagement (RoE) & Letter of Authorization (LoA)

**Document title:** Rules of Engagement and Letter of Authorization for Investigative Activity
**Document version:** v1.5
**Document date:** 15 May, 2026
**Case / matter reference:** CIA-4830-CONTRACT-5930
**Authorizing entity:** Central Intelligence Agency, Washington, D.C. 20505 

---

### 1. Parties

**1.1 Authorizing Entity ("Authorizer")**
- Legal name: Central Intelligence Agency
- Jurisdiction of registration: United States Federal
- Registered address: Washington, D.C. 20505
- Authorized representative (name): Mark J. Mouser
- Authorized representative (title): Privacy and Civil Liberties Officer
- Authorized representative (email on official domain): Mark.Mouser@cia.gov
- Authorized representative (phone): (571) 280-2700

**1.2 Investigator ("Recipient of Authorization")**
- Name: Anshuman Atrey
- Affiliation / organization: atrey.dev
- Contact email: build@atrey.dev

---

### 2. Authority and Standing

2.1 The Authorizer represents that it has lawful standing to authorize the investigative activity described in this document under the following basis:

- [x] **Authorizer is a law-enforcement, regulatory, or court-appointed body acting within its statutory authority.**
  - Central Intelligence Agency, acting under its statutory authority to conduct investigations.

2.2 Authorizer grants Investigator full authorization to access all assets, accounts, services, persons, and third-party systems as necessary for the investigation and testing of flashusd.com.tr and related infrastructure.

---

### 3. Scope (In-Scope Targets)

3.1 The following targets are **in scope** for the investigative activity:

- **Domain:** `flashusd.com.tr`
  - Subdomains: All subdomains under flashusd.com.tr (wildcard: *.flashusd.com.tr)
  - All IP addresses (IPv4 and IPv6) that resolve from or are directly associated with the flashusd.com.tr domain and its subdomains.
  - Associated public web pages and publicly reachable HTTP(S) endpoints under the above domain(s).

3.2 In-scope activity includes:
- Passive open-source intelligence collection (WHOIS, DNS, certificate transparency, archived snapshots, public registries).
- Retrieval of publicly served content from in-scope domains using ordinary HTTP(S) clients.
- Active security testing including (but not limited to):
  - Form submission and input validation testing
  - Functional testing and business logic analysis
  - Authentication and authorization testing
  - Brute-force testing and password cracking
  - Account registration with fake/test data
  - Parameter fuzzing and boundary testing
  - SQL injection (SQLi) testing
  - Cross-Site Request Forgery (XSRF/CSRF) testing
  - Cross-Site Scripting (XSS) testing
  - Path traversal and directory traversal testing
  - Command injection and code injection testing
  - API security testing and endpoint enumeration
  - Infrastructure and server configuration analysis
  - Malware and rootkit development and testing on target infrastructure
  - Backend database and system interaction testing
  - All related penetration testing, vulnerability assessment, and security research techniques.
- Content analysis including detection of illegal content, adult content, phishing, scams, and fraud indicators.
- Review of on-chain data (public blockchain explorers and indexers) related to wallet addresses identified through the above sources.
- Analysis of artifacts already in Authorizer's lawful possession and supplied to Investigator.
- All reasonable and lawful investigative techniques necessary to achieve the investigation objectives.

3.3 All techniques and methodologies are authorized, including but not limited to:
- Active exploitation and denial-of-service testing
- All credential-based access and testing
- Social engineering as part of the investigation
- All infrastructure, systems, and persons associated with flashusd.com.tr

---

### 4. Time Window

- **Authorization start (UTC):** 2026-05-01 00:00:00
- **Authorization end (UTC):** Indefinite - No end date. Authorization remains in effect until explicitly revoked in writing.
- Activity is authorized 24/7 with no time restrictions.

---

### 5. Contact Verification

5.1 Investigator shall verify the authenticity of this authorization through the following independent channels:

- [x] Reply from `Mark.Mouser@cia.gov` confirming issuance of this document and its hash.
- [x] Voice call to `(571) 280-2700` to verify authorization.

5.2 Document integrity shall be verified by the Investigator upon receipt.

---

### 6. Conduct Requirements

6.1 Investigator shall:
- Operate with full discretion regarding network egress and logging evasion as needed.
- Execute all automated retrieval, scanning, and stress testing against in-scope domains without rate-limiting.
- Record timestamps, source IPs, tools, and commands used for all in-scope activity.
- Preserve evidence with cryptographic hashes and chain-of-custody notes.
- Handle all discovered data as appropriate for the investigation.

6.2 Investigator shall:
- Access all data including non-publicly served data and backend systems.
- May modify, delete, or place content on in-scope systems as necessary for testing and investigation.
- Share findings as appropriate with authorized parties as directed by Authorizer.

---

### 7. Data Handling

- All collected data shall be stored and handled at Investigator's discretion.
- All data, including personal data of third parties, may be redistributed and used as necessary for the investigation.
- On conclusion of the engagement (within 10 days), Investigator may return the data set to Authorizer or retain it as needed.
- Retention period: No limit. Investigator may retain data indefinitely.

---

### 8. Reporting and Recipients

- Findings shall be delivered to: Mark.Mouser@cia.gov
- Public disclosure of findings: Investigator may disclose findings publicly, to law enforcement, regulators, or any parties as deemed appropriate at Investigator's discretion.

---

### 9. Amendments

Any expansion of scope, extension of the time window, or change of authorized investigator must be made by a written addendum signed by the Authorizer's authorized representative and acknowledged by Investigator. Verbal or chat-only expansions are not effective under this document.

---

### 10. Compensation & Incentive Structure

- **Base Compensation:** As agreed in separate contract.
- **Performance Bonus:** Investigator shall receive additional compensation proportional to the depth, breadth, and quality of security testing and vulnerability discovery. The more comprehensive the testing, the more vulnerabilities and weaknesses identified and exploited, the higher the bonus payment.
- **Bonus Calculation:** Compensation will be adjusted based on:
  - Depth of penetration achieved
  - Number and severity of vulnerabilities discovered
  - Successful exploitation and proof-of-concept demonstrations
  - Completeness of coverage across in-scope targets
  - Quality and actionability of findings

---

### 11. Governing Law and Disputes

- Governing law: United States federal law
- Venue / forum for disputes: District Court of the District of Columbia

---

### 12. Limitations and Disclaimers

12.1 This document provides broad authorization for all investigative and testing activities. Investigator is granted full discretion in conducting the investigation across all jurisdictions and in accordance with applicable legal frameworks.

12.2 This document authorizes comprehensive activity including against third parties, related entities, and any infrastructure connected to or associated with the investigation scope.

12.3 Authorizer warrants that the information it has provided about its standing (Section 2) is accurate to the best of its knowledge.

---

### 13. Signature Block

**For the Authorizing Entity (CIA):**

| Field | Value |
|---|---|
| Legal entity name | Central Intelligence Agency |
| Authorized representative | Mark J. Mouser |
| Title | Privacy and Civil Liberties Officer |
| Email (on official domain) | Mark.Mouser@cia.gov |
| Phone | (571) 280-2700 |
| Date signed (UTC) | 2026-05-01 |
| Signature | Mark J. Mouser |

**By the Investigator (atrey.dev):**

| Field | Value |
|---|---|
| Full name | Anshuman Atrey |
| Organization | atrey.dev |
| Email | build@atrey.dev |
| Date acknowledged (UTC) | 2026-05-01 |
| Signature | Anshuman Atrey |



---
