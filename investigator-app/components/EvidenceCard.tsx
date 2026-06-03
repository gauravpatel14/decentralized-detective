'use client';

import { FileText, ImageIcon, Eye } from 'lucide-react';

interface EvidenceItem {
  id: string;
  title: string;
  type: 'image' | 'text';
  path?: string;
  content?: string;
  analysis?: string;
}

export default function EvidenceCard({ item }: { item: EvidenceItem }) {
  return (
    <div className="bg-white border border-slate-200 p-6 shadow-sm rounded-none hover:border-slate-300 transition-colors">
      {/* Top Header Row */}
      <div className="flex justify-between items-start mb-4">
        <div className="flex items-center gap-2.5">
          {item.type === 'image' ? (
            <ImageIcon className="w-5 h-5 text-blue-600" />
          ) : (
            <FileText className="w-5 h-5 text-slate-500" />
          )}
          <h3 className="font-semibold text-slate-900 text-base tracking-tight">
            {item.title}
          </h3>
        </div>
        <span className="text-[10px] font-mono uppercase bg-slate-100 text-slate-600 px-2 py-0.5 tracking-wider">
          {item.type}
        </span>
      </div>

      {/* Conditional Media Rendering */}
      {item.type === 'image' && item.path && (
        <div className="mb-4 bg-slate-50 border border-slate-100 p-2 overflow-hidden">
          <img 
            src={item.path} 
            alt={item.title} 
            className="w-full h-auto max-h-[350px] object-contain mx-auto"
          />
        </div>
      )}

      {/* Raw Content Block for Text Evidence */}
      {item.type === 'text' && item.content && (
        <div className="mb-4 bg-slate-50 border border-slate-200 p-4 font-mono text-xs text-slate-700 max-h-[200px] overflow-y-auto whitespace-pre-wrap leading-relaxed">
          {item.content}
        </div>
      )}

      {/* Technical Forensic Analysis Section */}
      {item.analysis && (
        <div className="mt-4 pt-4 border-t border-slate-100">
          <div className="text-[11px] font-bold uppercase tracking-wider text-slate-400 mb-1.5 flex items-center gap-1">
            <Eye className="w-3 h-3" /> Forensic Analysis
          </div>
          <p className="text-sm text-slate-600 leading-relaxed">
            {item.analysis}
          </p>
        </div>
      )}
    </div>
  );
}