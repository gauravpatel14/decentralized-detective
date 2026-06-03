'use client';

import { useState } from 'react';
import EvidenceCard from './EvidenceCard';

interface EvidenceSectionProps {
  evidence: any[];
}

export default function EvidenceSection({ evidence }: EvidenceSectionProps) {
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 1;

  const totalPages = Math.ceil(evidence.length / itemsPerPage);
  const indexOfLastItem = currentPage * itemsPerPage;
  const indexOfFirstItem = indexOfLastItem - itemsPerPage;
  const currentItems = evidence.slice(indexOfFirstItem, indexOfLastItem);

  if (!evidence || evidence.length === 0) return null;

  return (
    <div className="w-full bg-white border border-slate-200 shadow-sm rounded-none hover:border-slate-300 transition-colors">
      <div className="p-6 pb-2">
        {currentItems.map((item) => (
          <EvidenceCard key={item.id} item={item} />
        ))}
      </div>

      {totalPages > 1 && (
        <div className="flex justify-center items-center gap-6 px-6 py-4 bg-slate-50 border-t border-slate-200 select-none">
          <button
            onClick={() => setCurrentPage((prev) => Math.max(prev - 1, 1))}
            disabled={currentPage === 1}
            className="text-sm font-medium text-blue-500 hover:text-blue-700 disabled:text-slate-300 disabled:cursor-not-allowed transition-colors"
          >
            Previous
          </button>

          <div className="flex items-center gap-4">
            {Array.from({ length: totalPages }, (_, i) => i + 1).map((pageNumber) => {
              const isActive = currentPage === pageNumber;
              return (
                <button
                  key={pageNumber}
                  onClick={() => setCurrentPage(pageNumber)}
                  className={`text-sm font-semibold transition-colors bg-transparent border-0 p-0 m-0 cursor-pointer ${
                    isActive
                      ? 'text-blue-700 font-bold scale-110'
                      : 'text-blue-400 hover:text-blue-600'
                  }`}
                >
                  {pageNumber}
                </button>
              );
            })}
          </div>

          <button
            onClick={() => setCurrentPage((prev) => Math.min(prev + 1, totalPages))}
            disabled={currentPage === totalPages}
            className="text-sm font-medium text-blue-500 hover:text-blue-700 disabled:text-slate-300 disabled:cursor-not-allowed transition-colors"
          >
            Next
          </button>
        </div>
      )}
    </div>
  );
}