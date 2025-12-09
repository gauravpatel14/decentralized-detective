import { Transaction } from '@/types/report';

interface TimelineProps {
    transactions: Transaction[];
}

export default function Timeline({ transactions }: TimelineProps) {
    return (
        <div className="relative pl-8">
            {/* Vertical line */}
            <div className="absolute left-0 top-0 bottom-0 w-0.5 bg-solana-purple" />

            {transactions.map((tx, index) => (
                <div key={tx.id} className="relative mb-6 pl-8">
                    {/* Marker */}
                    <div className="absolute left-[-0.35rem] top-1 w-[0.7rem] h-[0.7rem] bg-solana-purple" />

                    {/* Content */}
                    <div className="bg-black p-4 border border-gray-800">
                        <div className="flex justify-between items-start mb-2">
                            <strong className="text-sm">{tx.type}</strong>
                            <span className="text-gray-400 text-sm">{tx.timestamp}</span>
                        </div>
                        {tx.description && (
                            <p className="text-gray-300 text-sm mb-2">{tx.description}</p>
                        )}
                        <code className="text-solana-green text-xs font-mono">
                            {tx.signature}
                        </code>
                    </div>
                </div>
            ))}
        </div>
    );
}
