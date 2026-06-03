'use client';  

import type { Transaction } from '@/types/report';

interface TimelineProps {
    transactions: Transaction[];
}

export default function Timeline({ transactions }: TimelineProps) {
    return (
        <div className="space-y-6">
            {transactions.map((tx, index) => (
                <div key={index} className="relative pl-8 border-l border-slate-200">
                    <div className="absolute -left-[5px] top-2 w-2.5 h-2.5 rounded-full bg-blue-600" />
                    <div className="bg-slate-50 p-6 border border-slate-200">
                        <div className="flex justify-between items-start mb-2">
                            <h4 className="font-semibold text-slate-900">{tx.title}</h4>
                            <span className="text-xs text-slate-500 font-mono">{tx.date}</span>
                        </div>
                        <p className="text-sm text-slate-600 mb-2">{tx.description}</p>
                        <p className="text-xs font-mono text-blue-600 break-all">{tx.hash}</p>
                    </div>
                </div>
            ))}
        </div>
    );
}