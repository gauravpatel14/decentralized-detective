'use client';

import { Copy, ExternalLink } from 'lucide-react';
import { copyToClipboard } from '@/lib/utils';
import { useState } from 'react';

interface DataTableProps {
    data: Array<{
        label: string;
        value: string | React.ReactNode;
        copyable?: boolean;
        link?: string;
    }>;
}

export default function DataTable({ data }: DataTableProps) {
    const [copied, setCopied] = useState<string | null>(null);

    const handleCopy = (text: string, label: string) => {
        copyToClipboard(text);
        setCopied(label);
        setTimeout(() => setCopied(null), 2000);
    };

    return (
        <table className="w-full border-collapse">
            <tbody>
                {data.map((row, index) => (
                    <tr key={index} className="border-b border-gray-800">
                        <th className="text-left text-gray-400 font-medium py-3 px-4 text-sm w-[30%]">
                            {row.label}
                        </th>
                        <td className="font-mono text-sm py-3 px-4">
                            <div className="flex items-center gap-2">
                                <span className={row.copyable ? 'text-solana-green break-all' : ''}>
                                    {row.value}
                                </span>
                                {row.copyable && typeof row.value === 'string' && (
                                    <button
                                        onClick={() => handleCopy(row.value as string, row.label)}
                                        className="text-gray-400 hover:text-solana-purple transition-colors"
                                        title="Copy to clipboard"
                                    >
                                        {copied === row.label ? '✓' : <Copy className="w-4 h-4" />}
                                    </button>
                                )}
                                {row.link && (
                                    <a
                                        href={row.link}
                                        target="_blank"
                                        rel="noopener noreferrer"
                                        className="text-gray-400 hover:text-solana-purple transition-colors"
                                    >
                                        <ExternalLink className="w-4 h-4" />
                                    </a>
                                )}
                            </div>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}
