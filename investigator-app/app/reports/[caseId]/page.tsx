import { notFound } from "next/navigation";
import { solanaCase } from "@/data/reports/SOL-HWSF-20251207";
import { tronFlashCase } from "@/data/reports/TRC-FLASH-20251209";
import { trc1UsdFlashCase } from "@/data/reports/TRC-1USD-FLASH-20260514";
import { aitroFlashCase } from "@/data/reports/AITRO-FLASH-20260514";
import { usdtFlashProofCase } from "@/data/reports/USDTFLASH-PROOF-20260514";
import { bitminerApkCase } from "@/data/reports/BITMINER-APK-20260514";
import { cryptotabCase } from "@/data/reports/CRYPTOTAB-20260514";
import { swapifyP2pCase } from "@/data/reports/SWAPIFY-P2P-20260515";
import { flashUsdTrCase } from "@/data/reports/FLASHUSD-TR-20260515";
import DataTable from "@/components/DataTable";
import EvidenceCard from "@/components/EvidenceCard";
import EvidenceSection from "@/components/EvidenceSection";
import Timeline from "@/components/Timeline";
import CaseFiles from "@/components/CaseFiles";
import CodeBlock from "@/components/CodeBlock";
import type { InvestigationReport } from "@/types/report";

const reports: Record<string, InvestigationReport> = {
  "SOL-HWSF-20251207": solanaCase,
  "TRC-FLASH-20251209": tronFlashCase,
  "TRC-1USD-FLASH-20260514": trc1UsdFlashCase,
  "AITRO-FLASH-20260514": aitroFlashCase,
  "USDTFLASH-PROOF-20260514": usdtFlashProofCase,
  "BITMINER-APK-20260514": bitminerApkCase,
  "CRYPTOTAB-20260514": cryptotabCase,
  "SWAPIFY-P2P-20260515": swapifyP2pCase,
  "FLASHUSD-TR-20260515": flashUsdTrCase,
};


export async function generateStaticParams() {
  return Object.keys(reports).map((caseId) => ({ caseId }));
}

export default async function ReportPage({
  params,
}: {
  params: Promise<{ caseId: string }>;
}) {
  const { caseId } = await params;
  const report = reports[caseId];

  if (!report) notFound();

  
  const evidenceFiles = report.evidence.map((ev, i) => ({
    id: String(i + 1),
    name: ev.title || `evidence_file_${i}.txt`,
    type: ev.type === 'image' ? ('image' as const) : ('text' as const),
    date: report.investigationDate,
    size: 'N/A'
  }));

  return (
    <div className="min-h-screen bg-white text-slate-900">
      <main className="max-w-6xl mx-auto px-12 py-16">
        <header className="mb-16 pb-8 border-b border-slate-200">
          <a href="/" className="text-[10px] uppercase font-bold text-slate-400 hover:text-blue-600 tracking-widest mb-4 block">← Back to Dashboard</a>
          <h1 className="text-4xl font-normal tracking-tighter text-slate-950">{report.title}</h1>
          <div className="flex gap-4 mt-4 text-xs text-slate-500 font-mono">
            <span>CASE-ID: {report.caseId}</span>
            <span>•</span>
            <span>DATE: {report.investigationDate}</span>
          </div>
        </header>

            {/* Subject Address */}
            <section className="mb-16">
                <h2 className="text-sm font-bold uppercase tracking-widest text-slate-900 mb-8 border-l-2 border-blue-600 pl-4">
                    Subject Address
                </h2>
                <div className="border border-slate-200 p-8 shadow-sm mb-6 bg-white">
                    <DataTable
                        data={[
                            { label: 'Address', value: report.subject.address, copyable: true, link: `https://explorer.solana.com/address/${report.subject.address}` },
                            { label: 'Account Type', value: report.subject.accountType },
                            { label: 'Program Owner', value: report.subject.programOwner },
                            { label: 'SOL Balance', value: report.subject.solBalance },
                            { label: 'Data Size', value: report.subject.dataSize },
                            { label: 'Executable', value: report.subject.executable ? 'Yes' : 'No' },
                        ]}
                    />
                </div >

                <h3 className="text-sm font-semibold text-slate-900 mt-8 mb-4">Activity Summary</h3>
                <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
                    <div className="bg-white border border-slate-200 p-4 shadow-sm">
                        <div className="text-slate-500 text-xs mb-1 font-mono uppercase tracking-wider">Total Transactions</div>
                        <div className="text-xl font-semibold text-slate-900">{report.subject.totalTransactions}</div>
                    </div>
                    <div className="bg-white border border-slate-200 p-4 shadow-sm">
                        <div className="text-slate-500 text-xs mb-1 font-mono uppercase tracking-wider">First Activity</div>
                        <div className="text-xl font-semibold text-slate-900">{report.subject.firstActivity}</div>
                    </div>
                    <div className="bg-white border border-slate-200 p-4 shadow-sm">
                        <div className="text-slate-500 text-xs mb-1 font-mono uppercase tracking-wider">Latest Activity</div>
                        <div className="text-xl font-semibold text-slate-900">{report.subject.latestActivity}</div>
                    </div>
                    <div className="bg-white border border-slate-200 p-4 shadow-sm">
                        <div className="text-slate-500 text-xs mb-1 font-mono uppercase tracking-wider">Activity Window</div>
                        <div className="text-xl font-semibold text-slate-900">{report.subject.activityWindow}</div>
                    </div>
                </div>
            </section >


        {/* Token Holdings */}
<section className="mb-12">
  <h2 className="text-2xl font-bold mb-6 border-l-4 border-slate-900 pl-4 text-slate-900">
    Token Holdings Analysis
  </h2>

  <div className="bg-white border border-slate-200 p-6 shadow-sm">
    <h3 className="text-lg font-semibold text-slate-900 mb-4">
      Identified Token
    </h3>

    <DataTable
      data={[
        { label: 'Token Name', value: report.tokenHoldings[0].name },
        { label: 'Symbol', value: report.tokenHoldings[0].symbol },
        { label: 'Balance', value: report.tokenHoldings[0].balance },
        {
          label: 'Mint Address',
          value: report.tokenHoldings[0].mintAddress,
          copyable: true,
          link: `https://explorer.solana.com/address/${report.tokenHoldings[0].mintAddress}`
        }
      ]}
    />

    <h3 className="text-lg font-semibold text-slate-900 mt-8 mb-4">
      Verification: Mint Address Comparison
    </h3>

    <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
      <div className="bg-white border border-slate-200 p-4 shadow-sm">
        <div className="text-slate-500 text-sm mb-2">Observed Mint</div>
        <div className="font-mono text-xs break-all text-slate-900">
          {report.tokenHoldings[0].mintAddress}
        </div>
      </div>

      <div className="bg-white border border-slate-300 p-4 shadow-sm">
        <div className="text-slate-500 text-sm mb-2">
          Official USDT Mint (Tether)
        </div>
        <div className="font-mono text-xs break-all text-emerald-600">
          {report.tokenHoldings[0].officialMintAddress}
        </div>
      </div>
    </div>

    <p className="mt-4 text-slate-600 text-sm">
      <strong className="text-slate-900">Finding:</strong> The mint addresses do NOT match. The observed token is not the official Tether USD stablecoin.
    </p>

    {report.tokenMetadata && (
      <>
        <h3 className="text-lg font-semibold text-slate-900 mt-8 mb-4">
          Token Metadata (Metaplex)
        </h3>

        <DataTable
          data={[
            {
              label: 'Update Authority',
              value: report.tokenMetadata.updateAuthority,
              copyable: true,
              link: `https://explorer.solana.com/address/${report.tokenMetadata.updateAuthority}`
            },
            {
              label: 'Mint Authority',
              value: (
                <>
                  <span className="inline-block px-3 py-1 text-xs bg-purple-100 border border-purple-300 text-purple-700 rounded">
                    ENABLED
                  </span>{' '}
                  (Controlled by creator)
                </>
              )
            },
            {
              label: 'Freeze Authority',
              value: (
                <>
                  <span className="inline-block px-3 py-1 text-xs bg-purple-100 border border-purple-300 text-purple-700 rounded">
                    ENABLED
                  </span>{' '}
                  (Controlled by creator)
                </>
              )
            },
            {
              label: 'Is Mutable',
              value: report.tokenMetadata.isMutable ? 'Yes' : 'No'
            },
            {
              label: 'Seller Fee',
              value: `${report.tokenMetadata.sellerFee} basis points`
            }
          ]}
        />
      </>
    )}
  </div>
</section>

        {/* Creator Investigation */}
{report.creator && (
<section className="mb-12">
  <h2 className="text-2xl font-bold mb-6 border-l-4 border-slate-900 pl-4 text-slate-900">
    Token Creator Investigation
  </h2>

  <div className="bg-white border border-slate-200 p-6 mb-6 shadow-sm">
    <h3 className="text-lg font-semibold text-slate-900 mb-4">
      Creator Address (Update Authority)
    </h3>

    <DataTable
      data={[
        {
          label: 'Address',
          value: report.creator.address,
          copyable: true,
          link: `https://explorer.solana.com/address/${report.creator.address}`
        },
        { label: 'Account Type', value: report.creator.accountType },
        { label: 'SOL Balance', value: report.creator.solBalance },
        { label: 'Role', value: report.creator.role }
      ]}
    />

    {report.creator.fundingSource && (
      <>
        <div className="mt-8 p-6 bg-red-50 border-2 border-red-300 rounded">
          <h3 className="text-lg font-semibold text-red-700 mb-4 flex items-center gap-2">
            <span className="text-2xl">🚨</span>
            CRITICAL: Funding Source Traced to Binance
          </h3>

          <p className="text-slate-700 mb-4 leading-relaxed">
            The creator wallet was initially funded from a Binance exchange address.
          </p>

          <DataTable
            data={[
              {
                label: 'Funding Address',
                value: report.creator.fundingSource.address,
                copyable: true,
                link: `https://explorer.solana.com/address/${report.creator.fundingSource.address}`
              },
              { label: 'Platform', value: report.creator.fundingSource.platform },
              { label: 'Address Type', value: report.creator.fundingSource.type },
              {
                label: 'First Transaction',
                value: report.creator.fundingSource.firstTransaction,
                copyable: true,
                link: `https://explorer.solana.com/tx/${report.creator.fundingSource.firstTransaction}`
              },
              { label: 'Date', value: report.creator.fundingSource.date }
            ]}
          />

          <div className="mt-4 p-4 bg-white border-l-4 border-red-400">
            <h4 className="font-semibold text-red-700 mb-3">
              Why this matters:
            </h4>

            <ul className="space-y-2 text-slate-700 text-sm">
              <li className="flex items-start">
                <span className="text-red-500 mr-2">1.</span>
                <span>Binance requires KYC for accounts</span>
              </li>

              <li className="flex items-start">
                <span className="text-red-500 mr-2">2.</span>
                <span>Law enforcement can subpoena Binance records</span>
              </li>

              <li className="flex items-start">
                <span className="text-red-500 mr-2">3.</span>
                <span>On-chain proof links the wallet to Binance</span>
              </li>

              <li className="flex items-start">
                <span className="text-red-500 mr-2">4.</span>
                <span>Can help identify the real person behind the scam</span>
              </li>
            </ul>
          </div>
        </div>
      </>
    )}

    <h3 className="text-lg font-semibold text-slate-900 mt-8 mb-4">
      Creator's Token Holdings
    </h3>

    <p className="text-slate-600 text-sm mb-4">
      Analysis of tokens held by the creator address:
    </p>

    <table className="w-full border-collapse">
      <thead>
        <tr className="border-b border-slate-200">
          <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm">
            Token
          </th>

          <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm">
            Balance
          </th>

          <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm">
            Notes
          </th>
        </tr>
      </thead>

      <tbody>
        {report.creator.tokens.map((token, i) => (
          <tr key={i} className="border-b border-slate-200">
            <td className={`py-3 px-4 ${i === 2 ? 'text-purple-700 font-semibold' : 'text-slate-700'}`}>
              {token.name}
            </td>

            <td className={`py-3 px-4 ${i === 2 ? 'text-purple-700 font-bold' : 'text-slate-700'}`}>
              {token.balance}
            </td>

            <td className={`py-3 px-4 ${i === 2 ? 'text-purple-700 font-semibold' : 'text-slate-700'}`}>
              {token.notes}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>

  {report.secondToken && (
    <div className="bg-white border border-slate-200 p-6 shadow-sm">
      <h3 className="text-lg font-semibold text-slate-900 mb-4">
        Second Fake USDT Token Discovery
      </h3>

      <p className="text-slate-600 text-sm mb-4">
        The creator address holds 3.2 BILLION tokens of a second fake "Tether USD" (USDT).
      </p>

      <DataTable
        data={[
          { label: 'Token Name', value: report.secondToken.name },
          { label: 'Symbol', value: report.secondToken.symbol },
          {
            label: 'Mint Address',
            value: report.secondToken.mintAddress,
            copyable: true,
            link: `https://explorer.solana.com/address/${report.secondToken.mintAddress}`
          },
          { label: 'Total Supply', value: report.secondToken.totalSupply },
          {
            label: "Creator's Holdings",
            value: `${report.secondToken.creatorHoldings} (${report.secondToken.creatorPercentage}% of supply)`
          },
          { label: 'Mint Authority', value: report.secondToken.mintAuthority },
          { label: 'Freeze Authority', value: report.secondToken.freezeAuthority }
        ]}
      />

      <div className="mt-6 p-4 bg-slate-50 border-l-4 border-purple-500">
        <p className="text-slate-700 text-sm leading-relaxed">
          <strong>Network Finding:</strong> The same creator address has created and controls at least two separate fake USDT tokens.
        </p>
      </div>
    </div>
  )}
</section>
)}

{/* 4. Evidence Documentation */}
        <section className="mb-16">
          <h2 className="text-sm font-bold uppercase tracking-widest text-slate-900 mb-8 border-l-2 border-blue-600 pl-4">
            Evidence Documentation
          </h2>
          <EvidenceSection evidence={report.evidence} />
        </section>

{/* Transaction Timeline */}
        <section className="mb-16">
          <div className="flex justify-between items-center mb-6 border-l-4 border-blue-600 pl-4">
            <h2 className="text-2xl font-bold text-slate-900">
              Transaction Timeline
            </h2>
            <div className="text-xs font-mono text-slate-500 bg-slate-100 px-2 py-1 border border-slate-200">
              TOTAL: {report.subject.totalTransactions} TRANSACTIONS
            </div>
          </div>

          <div className="bg-white border border-slate-200 p-8 shadow-sm">
            <p className="text-slate-600 text-sm mb-8">
              Complete chronological record of on-chain activity ({report.subject.totalTransactions} transactions)
            </p>

            <div className="relative pl-6 border-l-2 border-slate-200 space-y-8 ml-2">
              {report.transactions.map((tx: any, i: number) => (
                <div key={i} className="relative">
                  <span className="absolute -left-[31px] top-1.5 bg-blue-600 w-3 h-3 rounded-full border-4 border-white ring-2 ring-blue-100"></span>
                  
                  <div className="border border-slate-200 bg-slate-50/50 p-5 hover:bg-white hover:border-slate-300 transition-all shadow-sm">
                    <div className="flex flex-col sm:flex-row sm:items-center justify-between gap-2 mb-2">
                      <h3 className="font-bold text-slate-900 text-sm">
                        {tx.title || tx.action || `Transaction #${i + 1}`}
                      </h3>
                      <span className="text-xs font-mono text-slate-500 bg-white border border-slate-100 px-2 py-0.5">
                        {tx.date || tx.timestamp}
                      </span>
                    </div>

                    <p className="text-slate-700 text-sm mb-3 leading-relaxed">
                      {tx.description || tx.method || 'No method sequence details logs noted.'}
                    </p>

                    
                    {(tx['from'] || tx['to'] || tx['counterparty'] || tx['amount']) && (
                      <div className="text-xs text-slate-600 space-y-1 font-mono bg-white p-3 border border-slate-200 mb-3">
                        {tx['from'] && <div><span className="text-slate-400">From:</span> {tx['from']}</div>}
                        {tx['to'] && <div><span className="text-slate-400">To:</span> {tx['to']}</div>}
                        {tx['counterparty'] && <div><span className="text-slate-400">Counterparty:</span> {tx['counterparty']}</div>}
                        {tx['amount'] && <div><span className="text-slate-400">Amount:</span> <span className="font-bold text-slate-900">{tx['amount']} {tx['asset'] || 'SOL'}</span></div>}
                      </div>
                    )}

                    {(tx.signature || tx.hash) && (
                      <div className="mt-2 pt-2 border-t border-slate-100">
                        <span className="text-[11px] font-mono font-medium text-slate-400 block mb-1 uppercase tracking-wider">Transaction Hash</span>
                        <span className="font-mono text-xs text-blue-600 bg-blue-50/50 border border-blue-100 px-2 py-1 block break-all select-all">
                          {tx.signature || tx.hash}
                        </span>
                      </div>
                    )}
                  </div>
                </div>
              ))}
            </div>
          </div>
        </section>

        {/* Key Observations */}
<section className="mb-12">
  <h2 className="text-2xl font-bold mb-6 border-l-4 border-slate-900 pl-4 text-slate-900">
    Key Observations
  </h2>

  <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
    {report.findings.map((finding, i) => (
      <div
        key={i}
        className="bg-white border border-slate-200 rounded-xl p-6 shadow-sm hover:shadow-md transition-all"
      >
        <h3 className="text-lg font-semibold text-slate-900 mb-3">
          {finding.title}
        </h3>

        <p className="text-slate-600 text-sm mb-4 leading-relaxed">
          {finding.description}
        </p>

        <div className="flex flex-wrap gap-2">
          {finding.tags?.map((tag, j) => (
            <span
              key={j}
              className="inline-block px-3 py-1 text-xs bg-purple-100 border border-purple-300 text-purple-700 rounded-full"
            >
              {tag}
            </span>
          ))}
        </div>
      </div>
    ))}
  </div>
</section>
        

  {/* Network Analysis */}
<section className="mb-12">
  <h2 className="text-2xl font-bold mb-6 border-l-4 border-slate-900 pl-4 text-slate-900">
    Network Analysis
  </h2>

  <div className="bg-white border border-slate-200 rounded-xl p-6 shadow-sm">
    <h3 className="text-lg font-semibold text-slate-900 mb-4">
      Connected Addresses & Token Network
    </h3>

    <p className="text-slate-600 text-sm mb-6">
      Investigation revealed a multi-address network involving fake token creation and distribution.
    </p>

    <div className="overflow-x-auto">
      <table className="w-full border-collapse">
        <thead>
          <tr className="border-b border-slate-200 bg-slate-50">
            <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm">
              Address
            </th>

            <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm">
              Role
            </th>

            <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm">
              Connection
            </th>
          </tr>
        </thead>

        <tbody>
          {report.network.map((item, i) => (
            <tr
              key={i}
              className="border-b border-slate-200 hover:bg-slate-50 transition-all"
            >
              <td className={`font-mono py-4 px-4 text-sm break-all ${i === 1 ? 'text-purple-700 font-semibold' : 'text-slate-700'}`}>
                {item.address}
              </td>

              <td className={`py-4 px-4 text-sm ${i === 1 ? 'font-bold text-purple-700' : 'text-slate-700'}`}>
                {item.role}
              </td>

              <td className="py-4 px-4 text-sm text-slate-600">
                {item.connection}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  </div>
</section>

{/* Smart Contract */}
{report.smartContract && (
<section className="mb-12">
  <h2 className="text-2xl font-bold mb-6 border-l-4 border-slate-900 pl-4 text-slate-900">
    Smart Contract Code Analysis
  </h2>

  <div className="bg-white border border-slate-200 rounded-xl p-6 shadow-sm">
    <h3 className="text-lg font-semibold text-slate-900 mb-4">
      Reconstructed Token Creation Code
    </h3>

    <p className="text-slate-600 text-sm mb-6">
      Based on on-chain data analysis, the following is a reconstructed representation of how this fake USDT token was created using SPL Token + Metaplex standards.
    </p>

    <CodeBlock
      code={report.smartContract.code}
      vulnerabilities={report.smartContract.vulnerabilities}
    />
  </div>
</section>
)}

{/* Technical Details */}
        {report.technicalSpecs && report.technicalSpecs.length > 0 && (
          <section className="mb-12">
            <h2 className="text-2xl font-bold mb-6 border-l-4 border-slate-900 pl-4 text-slate-900">
              Technical Specifications
            </h2>

            <div className="bg-white border border-slate-200 p-6 shadow-sm">
              <h3 className="text-lg font-semibold text-slate-900 mb-4">
                Observed Token Characteristics
              </h3>

              <DataTable
                data={report.technicalSpecs.map((spec: any) => ({
                  label: spec.label,
                  value: spec.value
                }))}
              />
            </div>
          </section>
        )}

{/* Footer */}
<footer className="text-center py-8 border-t border-slate-200 mt-12 text-sm text-slate-500">
  <p className="text-slate-700 font-medium">
    Forensic Investigation Report Generated by Crypto Investigator Unit
  </p>

  <p className="mt-2">
    Case ID: {report.caseId} | Report Date: {report.investigationDate}
  </p>

  <div className="mt-4 flex items-center justify-center gap-4 flex-wrap">
    <a
      href={`https://explorer.solana.com/address/${report.subject.address}`}
      target="_blank"
      rel="noopener noreferrer"
      className="text-purple-700 hover:text-purple-900 hover:underline"
    >
      View on Solana Explorer
    </a>

    <span className="text-slate-300">|</span>

    <a
      href={`https://solscan.io/account/${report.subject.address}`}
      target="_blank"
      rel="noopener noreferrer"
      className="text-purple-700 hover:text-purple-900 hover:underline"
    >
      View on Solscan
    </a>
  </div>
</footer>
</main>
    </div>
  );
}