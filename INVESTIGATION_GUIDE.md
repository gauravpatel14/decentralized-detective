# Cryptocurrency Investigation Methodology Guide (Solana Blockchain)

## Table of Contents
1. [Investigation Types](#investigation-types)
2. [Tools & Resources](#tools--resources)
3. [Step-by-Step Procedures](#step-by-step-procedures)
4. [API & Command Line Methods](#api--command-line-methods)
5. [Smart Contract Analysis](#smart-contract-analysis)

---

## Investigation Types

### Type 1: Wallet Address Investigation
**Identifier**: 32-44 character base58 string (e.g., `HWSF...9R3e`)
**Purpose**: Track wallet activity, holdings, and transaction patterns

### Type 2: Token Mint Investigation
**Identifier**: Same format as wallet, but represents a token mint
**Purpose**: Verify token legitimacy, find creator, analyze supply

### Type 3: Program/Contract Investigation
**Identifier**: Program ID (e.g., `TokenkegQfeZ...`)
**Purpose**: Analyze smart contract code, find vulnerabilities

### Type 4: Transaction Investigation
**Identifier**: Transaction signature (base58 string ~88 chars)
**Purpose**: Trace money flow, identify involved parties

---

## Tools & Resources

### Block Explorers
1. **Solana Explorer** (https://explorer.solana.com)
   - Official, always accessible
   - Best for: Overview, transactions, account details
   
2. **Solscan** (https://solscan.io)
   - Most detailed information
   - Best for: Token metadata, holder distribution, analytics
   - May have bot protection

3. **SolanaFM** (https://solana.fm)
   - Alternative explorer
   - Best for: When others are blocked

### Developer Tools
1. **Solana CLI** (Command line)
   ```bash
   solana --version
   ```

2. **Metaplex** (Token metadata standard)
   - https://www.metaplex.com/

3. **Anchor** (Smart contract framework)
   - https://www.anchor-lang.com/

### Scam Detection Tools
1. **RugCheck.xyz** (https://rugcheck.xyz)
2. **Sol Sniffer** (https://solsniffer.com)
3. **De.Fi Scanner** (https://de.fi)

### API Access
1. **Solana RPC API** (Free, rate-limited)
2. **Helius API** (https://helius.dev) - Enhanced RPC
3. **QuickNode** (https://quicknode.com) - Paid RPC

---

## Step-by-Step Procedures

### Procedure A: Investigating a Wallet Address

#### Step 1: Identify Address Type
**Explorer**: Solana Explorer > Search address
**Check**: "Account" tab header
- If shows "Account": Standard wallet
- If shows "Program": Smart contract
- If shows "Token": Token mint

#### Step 2: Get Basic Information
**Data to Extract**:
- [ ] SOL Balance
- [ ] Account Owner/Program
- [ ] Data Size
- [ ] Executable status
- [ ] First activity date
- [ ] Last activity date

**Where**: Overview/Details tab on any explorer

#### Step 3: List Token Holdings
**Explorer**: Tokens tab
**For EACH token**:
- [ ] Token name
- [ ] Token symbol
- [ ] Balance
- [ ] **Mint Address** (CRITICAL - click token name)
- [ ] Verify mint against official sources

#### Step 4: Transaction History Analysis
**Explorer**: History/Transactions tab
**Minimum to Document**: First 50 transactions

**For Each Transaction**:
- [ ] Timestamp
- [ ] Transaction signature
- [ ] Type (Transfer, Swap, etc.)
- [ ] Involved addresses
- [ ] Amount/value

**Patterns to Look For**:
- Clustered activity (many txns in short time)
- Large transfers
- Repeated interactions with specific addresses
- Token creation events

#### Step 5: Click Individual Transactions
**For suspicious transactions**:
- [ ] Click signature to view details
- [ ] Scroll to "Instructions" section
- [ ] Note instruction types (SetAuthority, MintTo, etc.)
- [ ] Capture involved accounts
- [ ] Take screenshots

---

### Procedure B: Investigating a Token Mint

#### Step 1: Access Token Mint Page
**Methods**:
1. From wallet holdings: Click on token name
2. Direct: `https://explorer.solana.com/address/[MINT_ADDRESS]`
3. Solscan: Better metadata display

#### Step 2: Extract Core Token Information
**Overview Tab**:
- [ ] Token Name
- [ ] Symbol
- [ ] Total Supply
- [ ] Decimals
- [ ] Current Holders
- [ ] **Mint Authority** (Enabled/Disabled)
- [ ] **Freeze Authority** (Enabled/Disabled)

**⚠️ RED FLAGS**:
- Mint Authority Enabled = Unlimited token creation possible
- Freeze Authority Enabled = Tokens can be frozen

#### Step 3: Get Metadata (CRITICAL - OFTEN MISSED)
**Solscan Preferred**: Better metadata display

**Navigate to**: "Metadata" or "Token Info" section

**Extract**:
- [ ] **Update Authority** (Creator address - MOST IMPORTANT)
- [ ] Metadata URI
- [ ] Is Mutable
- [ ] Primary Sale Happened

**Example on Solscan**:
```
Metaplex Metadata (on-chain data)
{
  key: 4
  updateAuthority: "[CREATOR_ADDRESS]"  ← THIS IS THE CREATOR
  mint: "[TOKEN_MINT_ADDRESS]"
  data: {
    name: "Token Name"
    symbol: "SYMBOL"
    uri: "https://..."
    sellerFeeBasisPoints: 0
  }
  isMutable: 0/1
}
```

#### Step 4: Investigate the Update Authority (Creator)
**This is the address that created the token**

**Action**: Start a NEW investigation on this address (Procedure A)

**Focus**:
- [ ] How was this address funded? (First transaction source)
- [ ] What other tokens did they create?
- [ ] Are there similar scam patterns?

#### Step 5: Check Token Metadata URI
**Extract URI from metadata**

**Methods**:
1. Browser: Open URI in new tab
2. Command line:
   ```bash
   curl "https://arweave.net/[ID]" | jq
   ```

**Look for**:
- Token image/logo (check if stolen)
- Social links (verify legitimacy)
- Description (look for typos, scam language)

#### Step 6: Analyze Holders
**Solscan**: "Holders" tab

**Check**:
- [ ] Top holder distribution
- [ ] Number of unique holders
- [ ] If top holders control >50% (centralization risk)

#### Step 7: Check Liquidity & Markets
**Where**: "Markets" or "Pairs" tab

**For Each DEX Pair**:
- [ ] Liquidity amount
- [ ] Pool address
- [ ] When liquidity was added
- [ ] If liquidity was removed (rug pull sign)

---

### Procedure C: Finding Related Tokens by Creator

#### Method 1: Via Explorer
**Solscan preferred**

1. Go to creator address page
2. Check "Token Accounts" tab
3. Look for other tokens they created
4. Click "Transactions" and filter by "Create Token"

#### Method 2: Via RPC API
```bash
# Get all token accounts created by address
curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getTokenAccountsByOwner",
  "params": [
    "CREATOR_ADDRESS_HERE",
    {
      "programId": "TokenkegQfeZyiNwAJbNbGKPFXCWuBvf9Ss623VQ5DA"
    },
    {
      "encoding": "jsonParsed"
    }
  ]
}
' | jq
```

#### Method 3: Manual Transaction Search
1. Go to creator address
2. Click "Transactions"
3. Look for "CreateToken" or "InitializeMint" instructions
4. Each creates a new token mint

---

### Procedure D: Tracing Funding Sources

#### Step 1: Find First Transaction
**Goal**: Who funded this wallet?

**Process**:
1. Go to address transaction history
2. Scroll to OLDEST transaction (bottom)
3. **OR** Sort by date ascending if available
4. Click on the first transaction

#### Step 2: Analyze First Transaction
**Check**:
- [ ] Who sent SOL to this address? (Funder)
- [ ] How much?
- [ ] When?

#### Step 3: Investigate the Funder
**Common Sources**:
- **Exchange address** (Binance, Coinbase, etc.)
  - Check if it's a known deposit address
  - Lists: https://github.com/bitcoin-data/mining-pools-addresses
- **Other scammer wallet**
  - Continue investigating
- **New wallet**
  - Trace further back

#### Step 4: Check Exchange Attribution
**Tools**:
1. **WalletExplorer.com** (Bitcoin/some crypto)
2. **Google search**: Copy address and search
3. **Solscan Labels**: Some exchanges are labeled

**Example Check**:
```bash
# Search for known exchange addresses
curl "https://api.solscan.io/account/[ADDRESS]" | jq '.data.label'
```

---

### Procedure E: Smart Contract / Program Investigation

#### Step 1: Identify Program Type
**Check**: Account page "Executable" field

**If Executable = Yes**: This is a smart contract

#### Step 2: Get Program Data
**Solana Explorer**: "Program" section

**Extract**:
- [ ] Program ID
- [ ] Executable
- [ ] Upgradeable Authority (who can modify)
- [ ] Data length

#### Step 3: Check if Anchor Program
**Anchor** = Popular Solana framework with IDL (Interface Definition)

**Method 1: Solscan**
- Look for "Anchor Program" section
- If available, you'll see IDL JSON

**Method 2: Via API**
```bash
# Try to fetch IDL from program
curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getAccountInfo",
  "params": [
    "PROGRAM_ID_HERE",
    {
      "encoding": "base64"
    }
  ]
}
' | jq
```

#### Step 4: Decompile/Analyze Program
**For BPF Programs** (compiled code):

**Tools**:
1. **Solana Verify** (https://verify.osec.io)
   - Can verify against source code
   
2. **Local Analysis**:
   ```bash
   # Download program
   solana program dump [PROGRAM_ID] program.so
   
   # Analyze with objdump
   llvm-objdump -d program.so
   ```

#### Step 5: Analyze IDL (if Anchor Program)
**IDL shows**:
- All function names
- Parameters
- Accounts needed

**Look for Suspicious Functions**:
- `withdraw_all`
- `emergency_withdraw`
- `set_authority`
- `pause`
- Functions with "admin" or "owner" in name

**Example**:
```json
{
  "instructions": [
    {
      "name": "initialize",
      "accounts": [...],
      "args": [...]
    },
    {
      "name": "withdraw",  ← Check this
      "accounts": [
        {"name": "authority", "isMut": false, "isSigner": true}
      ],
      "args": []
    }
  ]
}
```

#### Step 6: Check Program Upgrade Authority
**Critical**: Who can change the program?

**If Upgrade Authority = Some address**:
- That address can modify program logic
- High risk if not revoked

**If Upgrade Authority = null**:
- Program is immutable
- Higher trust level

---

### Procedure F: Transaction Deep Dive

#### Step 1: Access Transaction
**URL Format**: `https://explorer.solana.com/tx/[SIGNATURE]`

#### Step 2: Extract Transaction Details
**Overview**:
- [ ] Block number
- [ ] Timestamp
- [ ] Fee paid
- [ ] Status (Success/Failed)

#### Step 3: Analyze Instructions
**Scroll to "Instructions" section**

**For Each Instruction**:
- [ ] Program ID (which program was called)
- [ ] Instruction type (Transfer, Swap, etc.)
- [ ] Accounts involved
- [ ] Data/Parameters

**Common Instruction Types**:
- `Transfer` - SOL transfer
- `TransferChecked` - Token transfer
- `InitializeMint` - Create new token
- `MintTo` - Create new tokens
- `SetAuthority` - Change permissions
- `CloseAccount` - Destroy account

#### Step 4: Trace Token Flow
**For token transfers**:
- [ ] From account
- [ ] To account
- [ ] Amount
- [ ] Token mint

#### Step 5: Check Inner Instructions
**Often hidden**: Scroll down to "Inner Instructions"

**These show**:
- Auto-created accounts
- Intermediate transfers
- DEX swap details

---

## API & Command Line Methods

### Setup Solana CLI
```bash
# Install
sh -c "$(curl -sSfL https://release.solana.com/stable/install)"

# Set RPC endpoint
solana config set --url https://api.mainnet-beta.solana.com

# Verify
solana --version
```

### Get Account Information
```bash
# Basic info
solana account [ADDRESS]

# Get balance
solana balance [ADDRESS]
```

### Get Token Account Info
```bash
# Get all tokens
spl-token accounts --owner [WALLET_ADDRESS]

# Get specific token balance
spl-token balance [MINT_ADDRESS] --owner [WALLET_ADDRESS]
```

### Get Token Mint Info
```bash
# Token supply and authorities
spl-token supply [MINT_ADDRESS]
spl-token display [MINT_ADDRESS]
```

### RPC API Calls (cURL)

#### Get Account Info
```bash
curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getAccountInfo",
  "params": [
    "ADDRESS_HERE",
    {
      "encoding": "jsonParsed"
    }
  ]
}
' | jq
```

#### Get Transaction History
```bash
curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getSignaturesForAddress",
  "params": [
    "ADDRESS_HERE",
    {
      "limit": 100
    }
  ]
}
' | jq
```

#### Get Token Supply
```bash
curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getTokenSupply",
  "params": [
    "MINT_ADDRESS_HERE"
  ]
}
' | jq
```

#### Get Token Metadata
```bash
# Using Metaplex metadata program
curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getAccountInfo",
  "params": [
    "METADATA_PDA_ADDRESS",
    {
      "encoding": "base64"
    }
  ]
}
' | jq
```

---

## Smart Contract Analysis

### Identifying Contract Functions

#### For Anchor Programs
1. Get IDL from explorer or:
```bash
anchor idl fetch [PROGRAM_ID]
```

2. Review all functions in IDL

#### For Non-Anchor Programs
1. Download program:
```bash
solana program dump [PROGRAM_ID] output.so
```

2. Disassemble:
```bash
llvm-objdump -d output.so > disassembly.txt
```

3. Analyze assembly for function calls

### Common Malicious Patterns

#### 1. Hidden Mint Authority
```rust
// Look for MintTo instructions without proper checks
invoke(
    &spl_token::instruction::mint_to(...)
    // No authority check = anyone can mint
)
```

#### 2. Unauthorized Withdrawals
```rust
// Look for transfers without signer validation
invoke(
    &system_instruction::transfer(...)
    // Missing: require!(ctx.accounts.authority.is_signer)
)
```

#### 3. Authority Changes
```rust
// Can the authority be changed mid-execution?
invoke(
    &spl_token::instruction::set_authority(...)
)
```

### Testing Contract Functions Locally

#### Setup
```bash
# Install Solana test validator
solana-test-validator

# In another terminal
solana config set --url http://localhost:8899
```

#### Interact with Program
```bash
# Call program (requires building transaction)
solana program invoke [PROGRAM_ID] --keypair your-keypair.json
```

---

## Investigation Checklist Template

### For Any Investigation, Always Document:

#### 1. Subject Information
- [ ] Primary address
- [ ] Account type
- [ ] Current balance
- [ ] First activity date
- [ ] Latest activity date

#### 2. Token Information (if applicable)
- [ ] Token mint address
- [ ] Token name and symbol
- [ ] Total supply
- [ ] Mint authority status
- [ ] Freeze authority status
- [ ] **Update authority (creator) address**
- [ ] Metadata URI
- [ ] Is mutable?

#### 3. Creator Investigation
- [ ] Update authority address
- [ ] How was creator funded?
- [ ] Other tokens created by same address
- [ ] Transaction patterns
- [ ] Links to exchanges or known entities

#### 4. Transaction Analysis
- [ ] Total transaction count
- [ ] First transaction details
- [ ] Recent transaction patterns
- [ ] Large transfers
- [ ] Suspicious instructions

#### 5. Smart Contract (if applicable)
- [ ] Program ID
- [ ] Is upgradeable?
- [ ] Upgrade authority
- [ ] Available functions
- [ ] Suspicious function names
- [ ] Source code (if available)

#### 6. Network Analysis
- [ ] Connected addresses
- [ ] Funding sources
- [ ] Destination addresses
- [ ] Common transaction partners

---

## Quick Reference: Critical Steps Often Missed

### ❗ MUST-DO for Token Investigation
1. **Find the Update Authority** (creator address)
   - Solscan > Metadata section > updateAuthority field
   
2. **Investigate the Creator**
   - Search their address
   - Check their funding source
   - Find other tokens they created

3. **Get Metadata URI**
   - Download and analyze JSON
   - Verify images and links

4. **Check Authority Status**
   - Mint Authority: Enabled = Can create unlimited tokens
   - Freeze Authority: Enabled = Can freeze holdings

5. **Trace First Funding**
   - First transaction = Who gave them SOL to start?
   - Is it an exchange? Another scammer?

### ❗ MUST-DO for Smart Contract
1. **Check Upgrade Authority**
   - Can the program be modified?
   - By whom?

2. **Get IDL (if Anchor)**
   - Shows all functions
   - Reveals capabilities

3. **Analyze Suspicious Functions**
   - Look for admin functions
   - Withdrawal capabilities
   - Authority changes

---

## Appendix: Useful Links

- Solana Docs: https://docs.solana.com
- SPL Token Docs: https://spl.solana.com/token
- Metaplex Docs: https://docs.metaplex.com
- Anchor Docs: https://www.anchor-lang.com/docs
- Solana Cookbook: https://solanacookbook.com
- RPC Methods: https://docs.solana.com/api/http
