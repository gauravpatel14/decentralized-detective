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
                    // Border color changed to slate-200
                    <tr key={index} className="border-b border-slate-200">
                        {/* Text color changed to slate-500 */}
                        <th className="text-left text-slate-500 font-medium py-3 px-4 text-sm w-[30%]">
                            {row.label}
                        </th>
                        <td className="font-mono text-sm py-3 px-4 text-slate-900">
                            <div className="flex items-center gap-2">
                                <span className={row.copyable ? 'break-all' : ''}>
                                    {row.value}
                                </span>
                                {row.copyable && typeof row.value === 'string' && (
                                    <button
                                        onClick={() => handleCopy(row.value as string, row.label)}
                                        className="text-slate-400 hover:text-blue-600 transition-colors"
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
                                        className="text-slate-400 hover:text-blue-600 transition-colors"
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