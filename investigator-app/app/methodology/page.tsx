'use client';

import { useState } from 'react';
import CodeBlock from '@/components/CodeBlock';

export default function MethodologyPage() {
  const [activeTab, setActiveTab] = useState('wallets');

  const tabs = [
    { id: 'wallets', label: 'Wallet Profiling' },
    { id: 'tokens', label: 'Token Mint Audit' },
    { id: 'contracts', label: 'Smart Contracts' },
    { id: 'api', label: 'CLI & RPC Matrix' },
  ];

  return (
    <div className="min-h-screen bg-white text-slate-900">
      <main className="max-w-6xl mx-auto px-12 py-16">
        {/* Header Block */}
        <header className="mb-12 pb-8 border-b border-slate-200">
          <a href="/" className="text-[10px] uppercase font-bold text-slate-400 hover:text-blue-600 tracking-widest mb-4 block">
            ← Back to Dashboard
          </a>
          <h1 className="text-4xl font-normal tracking-tighter text-slate-950">
            Cryptocurrency Investigation Methodology
          </h1>
          <p className="text-sm text-slate-500 mt-2 font-mono">
            FRAMEWORK v2.4 // SOLANA BLOCKCHAIN FORENSICS PROTOCOLS
          </p>
        </header>

        {/* Interactive Tab Navigation */}
        <div className="flex border-b border-slate-200 mb-8 overflow-x-auto gap-2">
          {tabs.map((tab) => (
            <button
              key={tab.id}
              onClick={() => setActiveTab(tab.id)}
              className={`flex items-center gap-2 px-5 py-3 text-sm font-medium border-b-2 transition-all whitespace-nowrap ${
                activeTab === tab.id
                  ? 'border-blue-600 text-blue-600 font-semibold bg-blue-50/30'
                  : 'border-transparent text-slate-500 hover:text-slate-800 hover:border-slate-300'
              }`}
            >
            
              {tab.label}
            </button>
          ))}
        </div>

        {/* Dynamic Content Sections */}
        <div className="space-y-6">
          {activeTab === 'wallets' && (
            <div className="space-y-8 animate-fadeIn">
              <div className="border border-slate-200 p-8 bg-slate-50/50">
                <h2 className="text-xl font-bold text-slate-900 mb-4 flex items-center gap-2">
                  <span className="text-blue-600">Procedure A:</span> Standard Wallet Address Profiling
                </h2>
                <p className="text-slate-600 text-sm mb-6">
                  Target Identification Matrix: tracking 32-44 character base58 strings to chart entity structure, holdings, and transaction cadence patterns.
                </p>

                <div className="space-y-6">
                  <div className="bg-white border border-slate-200 p-5 shadow-sm">
                    <h3 className="font-semibold text-sm uppercase tracking-wider text-slate-400 mb-3 font-mono">Step 1 . Account Verification</h3>
                    <p className="text-slate-700 text-sm leading-relaxed">
                      Verify type inside <strong>Solana Explorer &gt; Account Tab</strong>. If executable status triggers true, re-route immediately to Smart Contract matrix checks.
                    </p>
                  </div>

                  <div className="bg-white border border-slate-200 p-5 shadow-sm">
                    <h3 className="font-semibold text-sm uppercase tracking-wider text-slate-400 mb-3 font-mono">Step 2 . Extract Vital Metrics</h3>
                    <ul className="list-disc pl-5 text-sm text-slate-600 space-y-2">
                      <li>Log complete on-chain SOL Balance & Token holdings index.</li>
                      <li>Extract historical <strong>First Activity Date</strong> to track core fund routing setup timeframe.</li>
                      <li>Document minimum 50 signature sequences to analyze target operational patterns.</li>
                    </ul>
                  </div>

                  <div className="bg-red-50/50 border border-red-200 p-5">
                    <h4 className="font-bold text-red-800 text-sm flex items-center gap-2 mb-2">
                      🚨 CRITICAL INVESTIGATION PATTERN: Funding Source Tracing
                    </h4>
                    <p className="text-red-700 text-sm leading-relaxed">
                      Scroll to the absolute first transaction at the bottom of the ledger. Isolate the origin transaction funder. Check centralized exchange tags (Binance, Coinbase API nodes) to subpoena real KYC endpoints.
                    </p>
                  </div>
                </div>
              </div>
            </div>
          )}

          {activeTab === 'tokens' && (
            <div className="space-y-8 animate-fadeIn">
              <div className="border border-slate-200 p-8 bg-slate-50/50">
                <h2 className="text-xl font-bold text-slate-900 mb-4 flex items-center gap-2">
                  <span className="text-blue-600">Procedure B:</span> Token Mint Security Audit
                </h2>
                <p className="text-slate-600 text-sm mb-6">
                  Analyzing counterfeit token architectures, market decentralization metrics, and core token permission parameters.
                </p>

                <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6">
                  <div className="bg-white border border-red-200 p-5 shadow-sm">
                    <h4 className="font-bold text-red-700 text-sm mb-2">⚠️ Red Flag: Mint Authority Enabled</h4>
                    <p className="text-slate-600 text-xs leading-relaxed">
                      Allows token creators to execute infinite creation scripts mid-cycle, dropping value pools instantly (Rug-pull vulnerability).
                    </p>
                  </div>
                  <div className="bg-white border border-red-200 p-5 shadow-sm">
                    <h4 className="font-bold text-red-700 text-sm mb-2">⚠️ Red Flag: Freeze Authority Enabled</h4>
                    <p className="text-slate-600 text-xs leading-relaxed">
                      Enables creator wallets to lock target holder transactions entirely, forcing a systemic honeypot exploit environment.
                    </p>
                  </div>
                </div>

                <div className="bg-white border border-slate-200 p-5 shadow-sm">
                  <h3 className="font-semibold text-sm uppercase tracking-wider text-slate-400 mb-3 font-mono">Metaplex Metadata Extraction</h3>
                  <p className="text-sm text-slate-700 mb-3">
                    Solscan preferred rendering logic targets the <strong>Update Authority</strong>. This address is the absolute origin source behind token creation parameters.
                  </p>
                </div>
              </div>
            </div>
          )}

          {activeTab === 'contracts' && (
            <div className="space-y-8 animate-fadeIn">
              <div className="border border-slate-200 p-8 bg-slate-50/50">
                <h2 className="text-xl font-bold text-slate-900 mb-4 flex items-center gap-2">
                  <span className="text-blue-600">Procedure C:</span> Smart Contract & Program Decompilation
                </h2>
                <p className="text-slate-600 text-sm mb-6">
                  Validating Anchor Framework structures, IDL interface trees, and identifying hidden administrative malicious functions.
                </p>

                <div className="space-y-4">
                  <div className="bg-white border border-slate-200 p-5 shadow-sm">
                    <h4 className="font-bold text-slate-900 text-sm mb-2 font-mono">Upgrade Authority Validation</h4>
                    <p className="text-sm text-slate-600 leading-relaxed">
                      If <code>Upgrade Authority == null</code>, the contract logic is immutable and frozen. If an address is bound, that specific endpoint maintains complete control to silently replace live bytecode via program dumps.
                    </p>
                  </div>

                  <div className="bg-white border border-slate-200 p-5 shadow-sm">
                    <h4 className="font-bold text-slate-900 text-sm mb-2 font-mono">Common Exploitation Routines</h4>
                    <ul className="list-disc pl-5 text-xs text-slate-600 space-y-1">
                      <li><code>withdraw_all</code> / <code>emergency_withdraw</code> without caller constraint signers.</li>
                      <li>Hidden authority change states (<code>set_authority</code> proxies).</li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          )}

          {activeTab === 'api' && (
            <div className="space-y-8 animate-fadeIn">
              <div className="border border-slate-200 p-8 bg-slate-50/50">
                <h2 className="text-xl font-bold text-slate-900 mb-4 flex items-center gap-2">
                  <span className="text-blue-600">Procedure D:</span> Console Command Execution Matrix
                </h2>
                <p className="text-slate-600 text-sm mb-6">
                  Standard execution hooks for Solana Command Line Interface nodes and direct JSON-RPC cURL requests.
                </p>

                <div className="space-y-6">
                  <div>
                    <span className="text-xs font-mono text-slate-400 uppercase block mb-2">// Fetch Account Info Data</span>
                    <CodeBlock 
                      code={`curl https://api.mainnet-beta.solana.com -X POST -H "Content-Type: application/json" -d '
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "getAccountInfo",
  "params": [
    "SUjbAd...78eW",
    { "encoding": "jsonParsed" }
  ]
}' | jq`}
                      vulnerabilities={[]}
                    />
                  </div>

                  <div>
                    <span className="text-xs font-mono text-slate-400 uppercase block mb-2">// Audit Token Accounts by Owner Wallet</span>
                    <CodeBlock 
                      code={`spl-token accounts --owner WALLET_ADDRESS_HERE`}
                      vulnerabilities={[]}
                    />
                  </div>
                </div>
              </div>
            </div>
          )}
        </div>
{/* General Methodology Checklist Card - Premium Light Visual Fix */}
        <section className="mt-16 bg-white border border-slate-200 p-8 shadow-sm relative overflow-hidden group hover:border-blue-300 transition-all">
          {/* Subtle Accent Edge Accent */}
          <div className="absolute top-0 left-0 right-0 h-[3px] bg-gradient-to-r from-blue-500 to-indigo-600"></div>
          
          <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-4 mb-6 pb-4 border-b border-slate-100">
            <h3 className="text-sm font-bold tracking-widest uppercase text-slate-900 font-mono flex items-center gap-2">
              <span className="text-blue-600 font-sans text-base">✓</span> 
              Forensic Field Investigation Audit Rules
            </h3>
            <span className="text-[10px] bg-blue-50 text-blue-700 font-mono font-bold px-2.5 py-1 uppercase tracking-wider border border-blue-100">
              Mandatory Protocol
            </span>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-2 gap-x-8 gap-y-4 text-sm text-slate-700">
            <div className="flex items-start gap-3 bg-slate-50/50 hover:bg-slate-50 p-3 border border-slate-100 transition-colors">
              <div className="mt-0.5 flex items-center justify-center w-4 h-4 border-2 border-blue-600 text-blue-600 rounded-none bg-blue-50/50 text-[10px] font-bold select-none">
                ✓
              </div>
              <span className="leading-relaxed">
                Always identify the exact <strong className="text-slate-900 font-semibold">Update Authority</strong> before finalizing token metrics.
              </span>
            </div>

            <div className="flex items-start gap-3 bg-slate-50/50 hover:bg-slate-50 p-3 border border-slate-100 transition-colors">
              <div className="mt-0.5 flex items-center justify-center w-4 h-4 border-2 border-blue-600 text-blue-600 rounded-none bg-blue-50/50 text-[10px] font-bold select-none">
                ✓
              </div>
              <span className="leading-relaxed">
                Cross-check all mint hashes against the official <strong className="text-slate-900 font-semibold">Tether contract</strong> pool signatures.
              </span>
            </div>

            <div className="flex items-start gap-3 bg-slate-50/50 hover:bg-slate-50 p-3 border border-slate-100 transition-colors">
              <div className="mt-0.5 flex items-center justify-center w-4 h-4 border-2 border-blue-600 text-blue-600 rounded-none bg-blue-50/50 text-[10px] font-bold select-none">
                ✓
              </div>
              <span className="leading-relaxed">
                Map out funding trails back to <strong className="text-slate-900 font-semibold">centralized exchange</strong> cluster endpoints.
              </span>
            </div>

            <div className="flex items-start gap-3 bg-slate-50/50 hover:bg-slate-50 p-3 border border-slate-100 transition-colors">
              <div className="mt-0.5 flex items-center justify-center w-4 h-4 border-2 border-blue-600 text-blue-600 rounded-none bg-blue-50/50 text-[10px] font-bold select-none">
                ✓
              </div>
              <span className="leading-relaxed">
                Flag any instances where <strong className="text-slate-900 font-semibold">Mint or Freeze</strong> options evaluate as enabled.
              </span>
            </div>
          </div>
        </section>
        
      </main>
    </div>
  );
}