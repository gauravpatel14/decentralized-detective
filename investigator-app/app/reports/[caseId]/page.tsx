import { notFound } from 'next/navigation';
import { solanaCase } from '@/data/reports/SOL-HWSF-20251207';
import { tronFlashCase } from '@/data/reports/TRC-FLASH-20251209';
import { trc1UsdFlashCase } from '@/data/reports/TRC-1USD-FLASH-20260514';
import { aitroFlashCase } from '@/data/reports/AITRO-FLASH-20260514';
import { usdtFlashProofCase } from '@/data/reports/USDTFLASH-PROOF-20260514';
import { bitminerApkCase } from '@/data/reports/BITMINER-APK-20260514';
import { cryptotabCase } from '@/data/reports/CRYPTOTAB-20260514';
import { swapifyP2pCase } from '@/data/reports/SWAPIFY-P2P-20260515';
import { flashUsdTrCase } from '@/data/reports/FLASHUSD-TR-20260515';
import DataTable from '@/components/DataTable';
import Carousel from '@/components/Carousel';
import Timeline from '@/components/Timeline';
import CodeBlock from '@/components/CodeBlock';
import type { InvestigationReport } from '@/types/report';

// Map of all available reports
const reports: Record<string, InvestigationReport> = {
    'SOL-HWSF-20251207': solanaCase,
    'TRC-FLASH-20251209': tronFlashCase,
    'TRC-1USD-FLASH-20260514': trc1UsdFlashCase,
    'AITRO-FLASH-20260514': aitroFlashCase,
    'USDTFLASH-PROOF-20260514': usdtFlashProofCase,
    'BITMINER-APK-20260514': bitminerApkCase,
    'CRYPTOTAB-20260514': cryptotabCase,
    'SWAPIFY-P2P-20260515': swapifyP2pCase,
    'FLASHUSD-TR-20260515': flashUsdTrCase,
};

export async function generateStaticParams() {
    return Object.keys(reports).map((caseId) => ({
        caseId,
    }));
}

export default async function ReportPage({ params }: { params: Promise<{ caseId: string }> }) {
    const { caseId } = await params;
    const report = reports[caseId];

    if (!report) {
        notFound();
    }

    return (
        <div className="max-w-[1400px] mx-auto px-8 py-8">
            {/* Header */}
            <header className="mb-12 pb-8 border-b border-gray-800">
                <h1 className="text-4xl font-bold mb-4">{report.title}</h1>
                <div className="flex justify-between text-sm text-gray-400 font-mono">
                    <span>CASE-ID: {report.caseId}</span>
                    <span>Investigation Date: {report.investigationDate}</span>
                </div>
            </header>

            {/* Subject Address */}
            <section className="mb-12">
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Subject Address
                </h2>
                <div className="bg-gray-950 border border-gray-800 p-6 mb-6">
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

                <h3 className="text-lg font-semibold text-solana-purple mb-4">Activity Summary</h3>
                <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
                    <div className="bg-black border border-gray-800 p-4">
                        <div className="text-gray-400 text-sm mb-2">Total Transactions</div>
                        <div className="text-xl font-semibold">{report.subject.totalTransactions}</div>
                    </div>
                    <div className="bg-black border border-gray-800 p-4">
                        <div className="text-gray-400 text-sm mb-2">First Activity</div>
                        <div className="text-base font-semibold">{report.subject.firstActivity}</div>
                    </div>
                    <div className="bg-black border border-gray-800 p-4">
                        <div className="text-gray-400 text-sm mb-2">Latest Activity</div>
                        <div className="text-base font-semibold">{report.subject.latestActivity}</div>
                    </div>
                    <div className="bg-black border border-gray-800 p-4">
                        <div className="text-gray-400 text-sm mb-2">Activity Window</div>
                        <div className="text-xl font-semibold">{report.subject.activityWindow}</div>
                    </div>
                </div>
            </section >

            {/* Token Holdings */}
            < section className="mb-12" >
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Token Holdings Analysis
                </h2>
                <div className="bg-gray-950 border border-gray-800 p-6">
                    <h3 className="text-lg font-semibold text-solana-purple mb-4">Identified Token</h3>
                    <DataTable
                        data={[
                            { label: 'Token Name', value: report.tokenHoldings[0].name },
                            { label: 'Symbol', value: report.tokenHoldings[0].symbol },
                            { label: 'Balance', value: report.tokenHoldings[0].balance },
                            { label: 'Mint Address', value: report.tokenHoldings[0].mintAddress, copyable: true, link: `https://explorer.solana.com/address/${report.tokenHoldings[0].mintAddress}` },
                        ]}
                    />

                    <h3 className="text-lg font-semibold text-solana-purple mt-8 mb-4">
                        Verification: Mint Address Comparison
                    </h3>
                    <div className="grid grid-cols-2 gap-4">
                        <div className="bg-black border border-gray-800 p-4">
                            <div className="text-gray-400 text-sm mb-2">Observed Mint</div>
                            <div className="font-mono text-xs break-all">{report.tokenHoldings[0].mintAddress}</div>
                        </div>
                        <div className="bg-black border border-solana-purple p-4">
                            <div className="text-gray-400 text-sm mb-2">Official USDT Mint (Tether)</div>
                            <div className="font-mono text-xs break-all text-solana-green">
                                {report.tokenHoldings[0].officialMintAddress}
                            </div>
                        </div>
                    </div>
                    <p className="mt-4 text-gray-300 text-sm">
                        <strong>Finding:</strong> The mint addresses do NOT match. The observed token is not the official Tether USD stablecoin.
                    </p>

                    {report.tokenMetadata && (
                        <>
                            <h3 className="text-lg font-semibold text-solana-purple mt-8 mb-4">
                                Token Metadata (Metaplex)
                            </h3>
                            <DataTable
                                data={[
                                    { label: 'Update Authority', value: report.tokenMetadata.updateAuthority, copyable: true, link: `https://explorer.solana.com/address/${report.tokenMetadata.updateAuthority}` },
                                    { label: 'Mint Authority', value: <><span className="inline-block px-3 py-1 text-xs bg-purple-900/20 border border-solana-purple text-solana-purple">ENABLED</span> (Controlled by creator)</> },
                                    { label: 'Freeze Authority', value: <><span className="inline-block px-3 py-1 text-xs bg-purple-900/20 border border-solana-purple text-solana-purple">ENABLED</span> (Controlled by creator)</> },
                                    { label: 'Is Mutable', value: report.tokenMetadata.isMutable ? 'Yes' : 'No' },
                                    { label: 'Seller Fee', value: `${report.tokenMetadata.sellerFee} basis points` },
                                ]}
                            />
                        </>
                    )}
                </div>
            </section >

            {/* Creator Investigation */}
            {
                report.creator && (
                    <section className="mb-12">
                        <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                            Token Creator Investigation
                        </h2>
                        <div className="bg-gray-950 border border-gray-800 p-6 mb-6">
                            <h3 className="text-lg font-semibold text-solana-purple mb-4">
                                Creator Address (Update Authority)
                            </h3>
                            <DataTable
                                data={[
                                    { label: 'Address', value: report.creator.address, copyable: true, link: `https://explorer.solana.com/address/${report.creator.address}` },
                                    { label: 'Account Type', value: report.creator.accountType },
                                    { label: 'SOL Balance', value: report.creator.solBalance },
                                    { label: 'Role', value: report.creator.role },
                                ]}
                            />

                            {report.creator.fundingSource && (
                                <>
                                    <div className="mt-8 p-6 bg-red-950/20 border-2 border-red-500">
                                        <h3 className="text-lg font-semibold text-red-400 mb-4 flex items-center gap-2">
                                            <span className="text-2xl">🚨</span>
                                            CRITICAL: Funding Source Traced to Binance
                                        </h3>
                                        <p className="text-gray-200 mb-4 leading-relaxed">
                                            The creator wallet was initially funded from a Binance exchange address. This is the <strong className="text-red-400">smoking gun</strong> for law enforcement:
                                        </p>
                                        <DataTable
                                            data={[
                                                { label: 'Funding Address', value: report.creator.fundingSource.address, copyable: true, link: `https://explorer.solana.com/address/${report.creator.fundingSource.address}` },
                                                { label: 'Platform', value: report.creator.fundingSource.platform },
                                                { label: 'Address Type', value: report.creator.fundingSource.type },
                                                { label: 'First Transaction', value: report.creator.fundingSource.firstTransaction, copyable: true, link: `https://explorer.solana.com/tx/${report.creator.fundingSource.firstTransaction}` },
                                                { label: 'Date', value: report.creator.fundingSource.date },
                                            ]}
                                        />
                                        <div className="mt-4 p-4 bg-black border-l-4 border-red-500">
                                            <h4 className="font-semibold text-red-400 mb-3">Why this matters:</h4>
                                            <ul className="space-y-2 text-gray-200 text-sm">
                                                <li className="flex items-start">
                                                    <span className="text-red-400 mr-2">1.</span>
                                                    <span>Binance requires KYC (Know Your Customer) for all accounts</span>
                                                </li>
                                                <li className="flex items-start">
                                                    <span className="text-red-400 mr-2">2.</span>
                                                    <span>Law enforcement can subpoena Binance for account holder information</span>
                                                </li>
                                                <li className="flex items-start">
                                                    <span className="text-red-400 mr-2">3.</span>
                                                    <span>The transaction link provides irrefutable on-chain proof connecting the scammer to their Binance account</span>
                                                </li>
                                                <li className="flex items-start">
                                                    <span className="text-red-400 mr-2">4.</span>
                                                    <span>This information can identify the real person behind the scam operation</span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </>
                            )}

                            <h3 className="text-lg font-semibold text-solana-purple mt-8 mb-4">
                                Creator's Token Holdings
                            </h3>
                            <p className="text-gray-300 text-sm mb-4">
                                Analysis of tokens held by the creator address:
                            </p>
                            <table className="w-full border-collapse">
                                <thead>
                                    <tr className="border-b border-gray-800">
                                        <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm">Token</th>
                                        <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm">Balance</th>
                                        <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm">Notes</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {report.creator.tokens.map((token, i) => (
                                        <tr key={i} className="border-b border-gray-800">
                                            <td className={`py-3 px-4 ${i === 2 ? 'text-solana-purple' : ''}`}>{token.name}</td>
                                            <td className={`py-3 px-4 ${i === 2 ? 'text-solana-purple font-bold' : ''}`}>{token.balance}</td>
                                            <td className={`py-3 px-4 ${i === 2 ? 'text-solana-purple font-bold' : ''}`}>{token.notes}</td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>

                        {report.secondToken && (
                            <div className="bg-gray-950 border border-gray-800 p-6">
                                <h3 className="text-lg font-semibold text-solana-purple mb-4">
                                    Second Fake USDT Token Discovery
                                </h3>
                                <p className="text-gray-300 text-sm mb-4">
                                    The creator address holds 3.2 BILLION tokens of a SECOND fake "Tether USD" (USDT).
                                </p>
                                <DataTable
                                    data={[
                                        { label: 'Token Name', value: report.secondToken.name },
                                        { label: 'Symbol', value: report.secondToken.symbol },
                                        { label: 'Mint Address', value: report.secondToken.mintAddress, copyable: true, link: `https://explorer.solana.com/address/${report.secondToken.mintAddress}` },
                                        { label: 'Total Supply', value: report.secondToken.totalSupply },
                                        { label: "Creator's Holdings", value: `${report.secondToken.creatorHoldings} (${report.secondToken.creatorPercentage}% of supply)` },
                                        { label: 'Mint Authority', value: report.secondToken.mintAuthority },
                                        { label: 'Freeze Authority', value: report.secondToken.freezeAuthority },
                                    ]}
                                />
                                <div className="mt-6 p-4 bg-black border-l-4 border-solana-purple">
                                    <p className="text-gray-300 text-sm leading-relaxed">
                                        <strong>Network Finding:</strong> The same creator address <code className="font-mono">Hm9q...5Rrx</code> has created and controls at least TWO separate fake USDT tokens, both with mint and freeze authorities enabled.
                                    </p>
                                </div>
                            </div>
                        )}
                    </section>
                )
            }

            {/* Evidence */}
            <section className="mb-12">
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Evidence Documentation
                </h2>
                <Carousel evidence={report.evidence} />
            </section>

            {/* Transaction Timeline */}
            <section className="mb-12">
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Transaction Timeline
                </h2>
                <div className="bg-gray-950 border border-gray-800 p-6">
                    <p className="text-gray-300 text-sm mb-6">
                        Complete chronological record of on-chain activity ({report.subject.totalTransactions} transactions)
                    </p>
                    <Timeline transactions={report.transactions} />
                </div>
            </section>

            {/* Key Observations */}
            <section className="mb-12">
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Key Observations
                </h2>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    {report.findings.map((finding, i) => (
                        <div key={i} className="bg-gray-950 border border-gray-800 p-6">
                            <h3 className="text-lg font-semibold text-solana-purple mb-3">{finding.title}</h3>
                            <p className="text-gray-300 text-sm mb-4 leading-relaxed">{finding.description}</p>
                            <div className="flex flex-wrap gap-2">
                                {finding.tags.map((tag, j) => (
                                    <span
                                        key={j}
                                        className="inline-block px-3 py-1 text-xs bg-purple-900/20 border border-solana-purple text-solana-purple"
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
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Network Analysis
                </h2>
                <div className="bg-gray-950 border border-gray-800 p-6">
                    <h3 className="text-lg font-semibold text-solana-purple mb-4">
                        Connected Addresses & Token Network
                    </h3>
                    <p className="text-gray-300 text-sm mb-6">
                        Investigation revealed a multi-address network involving fake token creation and distribution.
                    </p>
                    <table className="w-full border-collapse">
                        <thead>
                            <tr className="border-b border-gray-800">
                                <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm">Address</th>
                                <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm">Role</th>
                                <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm">Connection</th>
                            </tr>
                        </thead>
                        <tbody>
                            {report.network.map((item, i) => (
                                <tr key={i} className="border-b border-gray-800">
                                    <td className={`font-mono py-3 px-4 ${i === 1 ? 'text-solana-purple' : ''}`}>
                                        {item.address}
                                    </td>
                                    <td className={`py-3 px-4 ${i === 1 ? 'font-bold' : ''}`}>{item.role}</td>
                                    <td className="py-3 px-4 text-sm">{item.connection}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </section>

            {/* Smart Contract */}
            {
                report.smartContract && (
                    <section className="mb-12">
                        <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                            Smart Contract Code Analysis
                        </h2>
                        <div className="bg-gray-950 border border-gray-800 p-6">
                            <h3 className="text-lg font-semibold text-solana-purple mb-4">
                                Reconstructed Token Creation Code
                            </h3>
                            <p className="text-gray-300 text-sm mb-6">
                                Based on on-chain data analysis, the following is a reconstructed representation of how this fake USDT token was created using SPL Token + Metaplex standards.
                            </p>
                            <CodeBlock
                                code={report.smartContract.code}
                                vulnerabilities={report.smartContract.vulnerabilities}
                            />
                        </div>
                    </section>
                )
            }

            {/* Technical Details */}
            <section className="mb-12">
                <h2 className="text-2xl font-bold mb-6 border-l-4 border-solana-purple pl-4">
                    Technical Specifications
                </h2>
                <div className="bg-gray-950 border border-gray-800 p-6">
                    <h3 className="text-lg font-semibold text-solana-purple mb-4">
                        Observed Token Characteristics
                    </h3>
                    <DataTable data={report.technicalSpecs.map(spec => ({ label: spec.label, value: spec.value }))} />
                </div>
            </section>

            {/* Footer */}
            <footer className="text-center py-8 border-t border-gray-800 mt-12 text-sm text-gray-400">
                <p>Forensic Investigation Report Generated by Crypto Investigator Unit</p>
                <p className="mt-2">Case ID: {report.caseId} | Report Date: {report.investigationDate}</p>
                <p className="mt-4">
                    <a href={`https://explorer.solana.com/address/${report.subject.address}`} target="_blank" rel="noopener noreferrer" className="text-solana-purple hover:underline mx-3">
                        View on Solana Explorer
                    </a>
                    |
                    <a href={`https://solscan.io/account/${report.subject.address}`} target="_blank" rel="noopener noreferrer" className="text-solana-purple hover:underline mx-3">
                        View on Solscan
                    </a>
                </p>
            </footer>
        </div >
    );
}
