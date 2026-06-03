'use client';

import { useState } from 'react';

interface CarouselProps {
    evidence: Array<{
        title: string;
        type: 'image' | 'text';
        path?: string;
        content?: string;
        analysis?: string;
    }>;
}

export default function Carousel({ evidence }: CarouselProps) {
    const [currentIndex, setCurrentIndex] = useState(0);
    const item = evidence[currentIndex];

    const next = () => setCurrentIndex((prev) => (prev + 1) % evidence.length);
    const prev = () => setCurrentIndex((prev) => (prev - 1 + evidence.length) % evidence.length);

    if (!evidence || evidence.length === 0) return null;

    return (
        <div className="bg-white border border-slate-200 p-6 rounded-lg shadow-sm">
            
            {item.type === 'image' && item.path && (
                <div className="mb-6">
                    <img 
                        src={item.path} 
                        alt={item.title} 
                        className="w-full h-auto max-h-[500px] object-contain rounded-md border border-slate-100"
                    />
                </div>
            )}

            <div className="mb-6">
                <h3 className="font-semibold text-slate-900 text-lg mb-2">{item.title}</h3>
                {item.analysis && <p className="text-sm text-slate-600 leading-relaxed">{item.analysis}</p>}
                {item.content && <p className="text-sm text-slate-600 mt-2 font-mono bg-slate-50 p-4 border border-slate-100">{item.content}</p>}
            </div>
            
            {/* Navigation Controls */}
            <div className="flex justify-between items-center mt-6 pt-6 border-t border-slate-100">
                <button 
                    onClick={prev}
                    className="px-4 py-2 bg-slate-50 hover:bg-slate-100 border border-slate-200 text-slate-700 rounded text-sm font-medium transition-colors"
                >
                    &lt; Previous
                </button>

                {/* Optional: Dots for quick reference */}
                <div className="flex gap-2">
                    {evidence.map((_, index) => (
                        <div
                            key={index}
                            className={`w-2.5 h-2.5 rounded-full ${index === currentIndex ? 'bg-blue-600' : 'bg-slate-200'}`}
                        />
                    ))}
                </div>

                <button 
                    onClick={next}
                    className="px-4 py-2 bg-slate-50 hover:bg-slate-100 border border-slate-200 text-slate-700 rounded text-sm font-medium transition-colors"
                >
                    Next &gt;
                </button>
            </div>
        </div>
    );
}