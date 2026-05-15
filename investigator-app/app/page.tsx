import Link from 'next/link';

export default function HomePage() {
  const cases = [
    {
      id: 'SOL-HWSF-20251207',
      title: 'Solana Fake USDT Investigation',
      date: 'December 7, 2025',
      status: 'Completed',
    },
    {
      id: 'TRC-FLASH-20251209',
      title: 'Telegram Flash USDT TRC20 Scam',
      date: 'December 9, 2025',
      status: 'Completed',
    },
    {
      id: 'TRC-1USD-FLASH-20260514',
      title: '"$1 Flash USDT" Cross-Chain Trust-Building Scam',
      date: 'May 14, 2026',
      status: 'Completed',
    },
    {
      id: 'AITRO-FLASH-20260514',
      title: 'AITRO Flash USDT — Netlify-Hosted Advance-Fee Fraud',
      date: 'May 14, 2026',
      status: 'Completed',
    },
    {
      id: 'USDTFLASH-PROOF-20260514',
      title: '"USDT Flash BTC CRYPTO" — 21.7K-Subscriber Proof-Padding Scam',
      date: 'May 14, 2026',
      status: 'Completed',
    },
    {
      id: 'BITMINER-APK-20260514',
      title: 'BitMiner.apk — Fake Cloud-Mining Scam (Flutter + Firebase + AdMob)',
      date: 'May 14, 2026',
      status: 'Completed',
    },
    {
      id: 'CRYPTOTAB-20260514',
      title: 'CryptoTab Browser — Server-Custody Mining MLM, Affiliate-Funded BTC Payouts',
      date: 'May 14–15, 2026',
      status: 'Completed',
    },
    {
      id: 'SWAPIFY-P2P-20260515',
      title: 'Swapify (swapifyofficial.com) — Indian P2P "Above-Market USDT" Trust-Building Scam',
      date: 'May 15, 2026',
      status: 'Completed',
    },
    {
      id: 'FLASHUSD-TR-20260515',
      title: 'flashusd.com.tr — Turkish "Flash USDT" Package-Sale Scam with OxaPay Cutout',
      date: 'May 15, 2026',
      status: 'Completed',
    },
  ];

  return (
    <div className="max-w-7xl mx-auto px-4 py-12">
      <header className="mb-12 border-b border-gray-800 pb-8">
        <h1 className="text-4xl font-bold mb-2">Crypto Investigator</h1>
        <p className="text-gray-400">Blockchain Investigation Reports</p>
      </header>

      <section>
        <h2 className="text-2xl font-semibold mb-6 border-l-4 border-solana-purple pl-4">
          Investigation Cases
        </h2>
        <div className="grid gap-6">
          {cases.map((caseItem) => (
            <Link
              key={caseItem.id}
              href={`/reports/${caseItem.id}`}
              className="block bg-gray-950 border border-gray-800 p-6 hover:border-solana-purple transition-colors"
            >
              <div className="flex justify-between items-start mb-2">
                <h3 className="text-xl font-semibold text-solana-purple">
                  {caseItem.title}
                </h3>
                <span className="text-sm text-gray-400">{caseItem.status}</span>
              </div>
              <p className="text-gray-400 text-sm">Case ID: {caseItem.id}</p>
              <p className="text-gray-400 text-sm">Date: {caseItem.date}</p>
            </Link>
          ))}
        </div>
      </section>
    </div>
  );
}
