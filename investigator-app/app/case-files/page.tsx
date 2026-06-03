'use client';

import { useState } from 'react';
import Link from 'next/link';

// Mapped Real Project Case Folders with absolute paths to your repo assets
const caseFolders = [
  {
    id: 'SOL-HWSF-20251207',
    name: 'SOL-HWSF-20251207 (Solana Fake USDT)',
    date: 'Dec 07, 2025',
    size: '4.2 MB',
    reportPath: '/reports/SOL-HWSF-20251207',
    // 📂 Linked to real local images in your public/ directory
    screenshots: [
      { name: 'evidence_screenshot_1.png', path: '/evidence_file_1.png' },
      { name: 'evidence_screenshot_2.png', path: '/evidence_file_2.png' }
    ]
  },
  {
    id: 'TRC-FLASH-20251209',
    name: 'TRC-FLASH-20251209 (Tron Flash Scam)',
    date: 'Dec 09, 2025',
    size: '2.8 MB',
    reportPath: '/reports/TRC-FLASH-20251209',
    screenshots: [
      { name: 'tron_leak_proof.jpg', path: '/tron_leak_proof.jpg' }
    ]
  },
  {
    id: 'BITMINER-APK-20260514',
    name: 'BITMINER-APK-20260514 (Malicious Miner APK)',
    date: 'May 14, 2026',
    size: '12.4 MB',
    reportPath: '/reports/BITMINER-APK-20260514',
    screenshots: [
      { name: 'apk_malware_manifest.png', path: '/apk_malware_manifest.png' }
    ]
  },
  {
    id: 'SWAPIFY-P2P-20260515',
    name: 'SWAPIFY-P2P-20260515 (Swapify P2P Fraud)',
    date: 'May 15, 2026',
    size: '1.1 MB',
    reportPath: '/reports/SWAPIFY-P2P-20260515',
    screenshots: [
      { name: 'p2p_chat_logs.png', path: '/p2p_chat_logs.png' }
    ]
  }
];

export default function CaseFilesPage() {
  const [selectedFolder, setSelectedFolder] = useState<any>(null);

  return (
    <div className="min-h-screen bg-slate-50/50 text-slate-900">
      <main className="max-w-7xl mx-auto px-12 py-12">
        
        {/* Top Path Navigation / Clean Breadcrumb */}
        <div className="flex items-center justify-between mb-8 border-b border-slate-200 pb-5">
          <div className="flex items-center gap-2 text-sm font-medium text-slate-500 font-mono">
            <Link href="/" className="hover:text-blue-600 transition-colors">My Drive</Link>
            <span>&gt;</span>
            <span className="text-slate-900 font-semibold">Case Files Locker</span>
          </div>
        </div>

        {/* Root Directory Folders Grid */}
        <h2 className="text-xs font-bold uppercase tracking-widest text-slate-400 mb-4 font-mono">Folders</h2>
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4 mb-12">
          {caseFolders.map((folder) => (
            <div
              key={folder.id}
              onClick={() => setSelectedFolder(folder)}
              className={`border p-4 bg-white shadow-sm flex items-start gap-4 cursor-pointer select-none transition-all ${
                selectedFolder?.id === folder.id
                  ? 'border-blue-500 ring-1 ring-blue-100 bg-blue-50/10'
                  : 'border-slate-200 hover:border-slate-300 hover:bg-slate-50'
              }`}
            >
              <div className="text-2xl p-2 bg-slate-100 text-slate-600 rounded">
                📁
              </div>
              <div className="truncate flex-1">
                <div className="font-medium text-sm text-slate-900 truncate" title={folder.name}>
                  {folder.name}
                </div>
                <div className="text-xs text-slate-400 font-mono mt-1">
                  {folder.date} • {folder.size}
                </div>
              </div>
            </div>
          ))}
        </div>

        {/* Dynamic Inner Active Folder Contents Area */}
        {selectedFolder ? (
          <div className="bg-white border border-slate-200 shadow-sm p-6 animate-fadeIn">
            <div className="flex flex-col sm:flex-row sm:items-center justify-between border-b border-slate-100 pb-4 mb-6 gap-4">
              <div>
                <h3 className="text-base font-bold text-slate-900 font-mono">
                  📂 {selectedFolder.name}
                </h3>
                <p className="text-xs text-slate-500 mt-0.5">Secure Evidence Archive Vault Matrix</p>
              </div>
              <button 
                onClick={() => setSelectedFolder(null)}
                className="text-xs font-mono text-slate-400 hover:text-slate-600"
              >
                ✕ Close Folder
              </button>
            </div>

            {/* Sub-Files Section inside Folder Container */}
            <div className="space-y-6">
              
              {/* 1. Core Cryptographic Investigation Report Link Document */}
              <div>
                <h4 className="text-xs font-bold uppercase tracking-wider text-slate-400 mb-3 font-mono">Reports Documents</h4>
                <div className="flex items-center justify-between p-4 border border-slate-150 bg-slate-50/50 hover:bg-slate-50 transition-colors">
                  <div className="flex items-center gap-3 text-sm font-medium text-slate-800">
                    <span className="text-red-500 font-bold">📄</span>
                    <span>{selectedFolder.id}_FINAL_FORENSIC_REPORT.html</span>
                  </div>
                  <Link 
                    href={selectedFolder.reportPath}
                    className="text-xs font-semibold bg-blue-600 text-white px-4 py-2 hover:bg-blue-700 transition-colors font-mono"
                  >
                    OPEN REPORT →
                  </Link>
                </div>
              </div>

              {/* 2. Real Screenshots Matrix rendering directly from your repo */}
              {selectedFolder.screenshots && selectedFolder.screenshots.length > 0 && (
                <div>
                  <h4 className="text-xs font-bold uppercase tracking-wider text-slate-400 mb-3 font-mono">
                    Evidence Vault (Screenshots / Proofs)
                  </h4>
                  <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-4">
                    {selectedFolder.screenshots.map((pic: any, idx: number) => (
                      <div key={idx} className="border border-slate-200 bg-slate-50 group overflow-hidden shadow-sm">
                        {/* Render Local Static Image */}
                        <div className="h-44 overflow-hidden relative border-b border-slate-100 bg-slate-100 flex items-center justify-center">
                          <img 
                            src={pic.path} 
                            alt={pic.name} 
                            className="w-full h-full object-cover group-hover:scale-105 transition-transform duration-300"
                            onError={(e) => {
                              // Fallback handle to ensure image layout never breaks if names mismatch
                              (e.target as HTMLElement).style.display = 'none';
                            }}
                          />
                        </div>
                        
                        <div className="p-3 flex items-center justify-between gap-2 bg-white">
                          <span className="text-xs font-mono text-slate-600 truncate flex-1" title={pic.name}>
                            📷 {pic.name}
                          </span>
                          <a 
                            href={pic.path}
                            download={pic.name}
                            className="text-[11px] font-bold font-mono text-blue-600 hover:text-blue-800 transition-colors shrink-0"
                          >
                            DOWNLOAD
                          </a>
                        </div>
                      </div>
                    ))}
                  </div>
                </div>
              )}

            </div>
          </div>
        ) : (
          <div className="border border-dashed border-slate-300 bg-white p-12 text-center text-slate-400 font-mono text-sm shadow-sm">
            🔍 Select any case directory folder from the drive matrix to review live evidence payloads.
          </div>
        )}

      </main>
    </div>
  );
}