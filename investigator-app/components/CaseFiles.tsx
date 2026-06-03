'use client';

import { useState } from 'react';
import { FileText, Download, Image as ImageIcon, Search, FolderOpen } from 'lucide-react';

interface CaseFile {
  id: string;
  name: string;
  type: 'image' | 'text' | 'json';
  date: string;
  size: string;
}

export default function CaseFiles({ files }: { files: CaseFile[] }) {
  const [search, setSearch] = useState('');

  const filteredFiles = files.filter(f => 
    f.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="bg-white border border-slate-200 shadow-sm p-6">
      <div className="flex justify-between items-center mb-8">
        <h2 className="text-xl font-bold text-slate-900 flex items-center gap-2">
            <FolderOpen className="w-5 h-5 text-blue-600" /> Evidence Locker
        </h2>
        <div className="relative">
            <Search className="absolute left-3 top-2.5 w-4 h-4 text-slate-400" />
            <input 
                type="text"
                placeholder="Search files..."
                className="pl-10 pr-4 py-2 border border-slate-200 text-sm focus:outline-none focus:border-blue-500"
                onChange={(e) => setSearch(e.target.value)}
            />
        </div>
      </div>

      <div className="overflow-x-auto">
        <table className="w-full text-left">
          <thead>
            <tr className="text-[10px] uppercase text-slate-400 border-b border-slate-200">
              <th className="pb-4 pl-2">Name</th>
              <th className="pb-4">Type</th>
              <th className="pb-4">Date</th>
              <th className="pb-4">Size</th>
              <th className="pb-4 text-right">Action</th>
            </tr>
          </thead>
          <tbody className="text-sm">
            {filteredFiles.map((file) => (
              <tr key={file.id} className="border-b border-slate-50 hover:bg-slate-50">
                <td className="py-4 pl-2 flex items-center gap-3">
                  {file.type === 'image' ? <ImageIcon className="w-4 h-4 text-blue-500" /> : <FileText className="w-4 h-4 text-slate-400" />}
                  {file.name}
                </td>
                <td className="py-4 text-slate-500">{file.type.toUpperCase()}</td>
                <td className="py-4 text-slate-500">{file.date}</td>
                <td className="py-4 text-slate-400 font-mono">{file.size}</td>
                <td className="py-4 text-right">
                  <button className="text-blue-600 hover:text-blue-800 flex items-center justify-end gap-1">
                    <Download className="w-4 h-4" />
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}