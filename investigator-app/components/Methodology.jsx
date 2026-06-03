export default function Methodology() {
  return (
    <div className="max-w-4xl mx-auto py-12 px-6 text-slate-800">
      <header className="mb-12 border-b border-slate-200 pb-8">
        <h1 className="text-4xl font-bold tracking-tighter text-slate-950">Investigation Methodology</h1>
        <p className="mt-4 text-slate-600">Standardized forensic workflow for Solana blockchain investigations.</p>
      </header>

      {/* Investigation Types */}
      <section className="mb-12">
        <h2 className="text-xl font-bold mb-6 border-l-4 border-blue-600 pl-4">Investigation Types</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
          {[
            { title: "Wallet Investigation", desc: "Track patterns & holdings for 32-44 char addresses[cite: 1]." },
            { title: "Token Mint", desc: "Verify legitimacy & find creators[cite: 1]." },
            { title: "Program/Contract", desc: "Analyze smart contract logic & vulnerabilities[cite: 1]." },
            { title: "Transaction", desc: "Trace money flow & involved parties[cite: 1]." }
          ].map((item, i) => (
            <div key={i} className="p-4 border border-slate-200 bg-white">
              <h3 className="font-semibold text-slate-900">{item.title}</h3>
              <p className="text-sm text-slate-600 mt-1">{item.desc}</p>
            </div>
          ))}
        </div>
      </section>

      {/* Procedures Section */}
      <section className="mb-12">
        <h2 className="text-xl font-bold mb-6 border-l-4 border-blue-600 pl-4">Core Procedures</h2>
        <div className="space-y-6">
          <div className="bg-white p-6 border border-slate-200">
            <h3 className="font-semibold text-lg mb-4">Procedure A: Wallet Address Analysis</h3>
            <ul className="list-disc list-inside text-sm text-slate-600 space-y-2">
              <li>Identify address type (Account vs Program)[cite: 1].</li>
              <li>Extract core metrics: Balance, Executable status, First/Last activity[cite: 1].</li>
              <li>Analyze transaction history for clustered activity[cite: 1].</li>
            </ul>
          </div>
          
          <div className="bg-white p-6 border border-slate-200">
            <h3 className="font-semibold text-lg mb-4">Procedure B: Token Mint Verification</h3>
            <ul className="list-disc list-inside text-sm text-slate-600 space-y-2">
              <li>Compare observed mint address vs. official contract[cite: 1].</li>
              <li>Check Mint & Freeze Authority statuses (Major scam indicators)[cite: 1].</li>
              <li>Extract Metadata (Update Authority, URI)[cite: 1].</li>
            </ul>
          </div>
        </div>
      </section>

      {/* Footer / Resources */}
      <footer className="mt-16 pt-8 border-t border-slate-200">
        <h2 className="text-lg font-bold mb-4">Resources</h2>
        <div className="text-sm text-slate-500 space-y-2">
          <p>Explorers: Solana Explorer, Solscan, SolanaFM[cite: 1]</p>
          <p>Detection: RugCheck.xyz, Sol Sniffer[cite: 1]</p>
          <p>Frameworks: Metaplex, Anchor[cite: 1]</p>
        </div>
      </footer>
    </div>
  );
}