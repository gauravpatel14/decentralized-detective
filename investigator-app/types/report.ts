export interface SubjectInfo {
  address: string;
  accountType: string;
  programOwner: string;
  solBalance: string;
  dataSize: string;
  executable: boolean;
  firstActivity: string;
  latestActivity: string;
  totalTransactions: number;
  activityWindow: string;
}

export interface TokenInfo {
  name: string;
  symbol: string;
  balance: string;
  mintAddress: string;
  officialMintAddress?: string;
  decimals?: number;
  isFake?: boolean;
}

export interface TokenMetadata {
  updateAuthority: string;
  mintAuthority: {
    enabled: boolean;
    controller: string;
  };
  freezeAuthority: {
    enabled: boolean;
    controller: string;
  };
  isMutable: boolean;
  sellerFee: number;
  uri?: string;
}

export interface CreatorInfo {
  address: string;
  accountType: string;
  solBalance: string;
  role: string;
  fundingSource?: {
    address: string;
    platform: string;
    type: string;
    firstTransaction: string;
    date: string;
  };
  tokens: {
    name: string;
    balance: string;
    notes: string;
  }[];
}

export interface SecondTokenInfo {
  name: string;
  symbol: string;
  mintAddress: string;
  totalSupply: string;
  creatorHoldings: string;
  creatorPercentage: number;
  mintAuthority: string;
  freezeAuthority: string;
}

export interface Transaction {
  id: string;
  title: string;       
  date: string;        
  description: string; 
  hash: string;        
  type: string;
  signature: string;
}

export interface Finding {
  title: string;
  description: string;
  tags: string[];
}

export interface Evidence {
  id: string;
  title: string;
  type: 'image' | 'text';
  image: string;       
  description: string; 
  path?: string;
  content?: string;
  analysis?: string;
}

export interface NetworkAddress {
  address: string;
  role: string;
  connection: string;
}

export interface SmartContractCode {
  language: string;
  code: string;
  vulnerabilities: string[];
}

export interface TechnicalSpec {
  label: string;
  value: string;
}

export interface InvestigationReport {
  caseId: string;
  title: string;
  investigationDate: string;

  subject: SubjectInfo;
  tokenHoldings: TokenInfo[];
  tokenMetadata?: TokenMetadata;

  creator?: CreatorInfo;
  secondToken?: SecondTokenInfo;

  evidence: Evidence[];
  transactions: Transaction[];
  findings: Finding[];
  network: NetworkAddress[];

  smartContract?: SmartContractCode;
  technicalSpecs: TechnicalSpec[];
}
