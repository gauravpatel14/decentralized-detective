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
