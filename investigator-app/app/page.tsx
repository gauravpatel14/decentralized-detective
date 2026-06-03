import Link from 'next/link';

export default function Dashboard() {
  const allReports = [
    { id: 'SOL-HWSF-20251207', title: 'Solana Fake USDT Investigation', type: 'Phishing', status: 'COMPLETED' },
    { id: 'TRC-FLASH-20251209', title: 'Telegram Flash USDT TRC20 Scam', type: 'Flash Scam', status: 'COMPLETED' },
    { id: 'TRC-1USD-FLASH-20260514', title: '"$1 Flash USDT" Cross-Chain Trust-Building Scam', type: 'Advance-Fee', status: 'COMPLETED' },
    { id: 'AITRO-FLASH-20260514', title: 'AITRO Flash USDT — Netlify-Hosted Fraud', type: 'Advance-Fee', status: 'COMPLETED' },
    { id: 'USDTFLASH-PROOF-20260514', title: '"USDT Flash BTC CRYPTO" — Proof-Padding Scam', type: 'Social Eng.', status: 'COMPLETED' },
    { id: 'BITMINER-APK-20260514', title: 'BitMiner.apk — Fake Cloud-Mining Scam', type: 'Malware', status: 'COMPLETED' },
    { id: 'CRYPTOTAB-20260514', title: 'CryptoTab Browser — Server-Custody Mining MLM', type: 'MLM/Affiliate', status: 'COMPLETED' },
    { id: 'SWAPIFY-P2P-20260515', title: 'Swapify — Indian P2P Above-Market Scam', type: 'P2P Fraud', status: 'COMPLETED' },
    { id: 'FLASHUSD-TR-20260515', title: 'flashusd.com.tr — Turkish Flash USDT Scam', type: 'Flash Scam', status: 'COMPLETED' },
  ];

  return (
    <div className="min-h-screen bg-white">
      <main className="max-w-6xl mx-auto px-12 py-16">
        <header className="mb-16">
          <h1 className="text-4xl font-normal text-slate-950 tracking-tighter mb-4">Dashboard</h1>
          <p className="text-slate-600">Verified forensic intelligence and investigation logs.</p>
        </header>

        <section className="grid grid-cols-1 md:grid-cols-3 gap-6">
          {allReports.map((report) => (
            <Link key={report.id} href={`/reports/${report.id}`} className="border border-slate-200 p-6 hover:border-slate-400 transition-all bg-white hover:bg-slate-50">
              <div className="flex justify-between items-start mb-2">
                <span className="text-[10px] font-mono text-slate-400 tracking-wider">{report.id}</span>
                <span className="text-[10px] font-bold tracking-wider text-green-600">
                    {report.status}
                </span>
              </div>
              <h3 className="text-sm font-semibold text-slate-900 mt-2">{report.title}</h3>
              <p className="text-[11px] text-slate-500 mt-1">{report.type}</p>
            </Link>
          ))}
        </section>
      </main>
    </div>
  );
}