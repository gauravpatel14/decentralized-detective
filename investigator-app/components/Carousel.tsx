'use client';

import { useState } from 'react';
import { ChevronLeft, ChevronRight } from 'lucide-react';
import { Evidence } from '@/types/report';
import Image from 'next/image';

interface CarouselProps {
    evidence: Evidence[];
}

export default function Carousel({ evidence }: CarouselProps) {
    const [currentSlide, setCurrentSlide] = useState(0);

    const nextSlide = () => {
        setCurrentSlide((prev) => (prev + 1) % evidence.length);
    };

    const prevSlide = () => {
        setCurrentSlide((prev) => (prev - 1 + evidence.length) % evidence.length);
    };

    const goToSlide = (index: number) => {
        setCurrentSlide(index);
    };

    return (
        <div className="relative bg-gray-950 border border-gray-800 min-h-[400px]">
            {/* Slides */}
            <div className="h-[600px] overflow-y-auto p-6">
                {evidence.map((item, index) => (
                    <div
                        key={item.id}
                        className={`${index === currentSlide ? 'flex flex-col' : 'hidden'}`}
                    >
                        <h3 className="text-lg font-semibold text-solana-purple mb-4">
                            {item.title}
                        </h3>

                        {item.type === 'image' && item.path && (
                            <div className="flex justify-center items-center mb-4">
                                <Image
                                    src={item.path}
                                    alt={item.title}
                                    width={1200}
                                    height={800}
                                    className="max-h-[500px] w-auto object-contain border border-gray-800"
                                />
                            </div>
                        )}

                        {item.type === 'text' && item.content && (
                            <div className="bg-black p-6 border border-gray-800 font-mono text-sm whitespace-pre-wrap mb-4">
                                {item.content}
                            </div>
                        )}

                        {item.analysis && (
                            <div className="bg-black border-l-4 border-solana-green p-4 mt-4">
                                <h4 className="text-sm font-semibold text-solana-green mb-2">Analysis:</h4>
                                <p className="text-gray-300 text-sm leading-relaxed">{item.analysis}</p>
                            </div>
                        )}
                    </div>
                ))}
            </div>

            {/* Controls */}
            <div className="flex justify-center gap-4 p-4 border-t border-gray-800">
                <button
                    onClick={prevSlide}
                    className="bg-solana-purple text-white px-6 py-2 hover:opacity-80 transition-opacity font-semibold"
                >
                    <ChevronLeft className="inline w-4 h-4" /> Previous
                </button>
                <button
                    onClick={nextSlide}
                    className="bg-solana-purple text-white px-6 py-2 hover:opacity-80 transition-opacity font-semibold"
                >
                    Next <ChevronRight className="inline w-4 h-4" />
                </button>
            </div>

            {/* Indicators */}
            <div className="flex justify-center gap-2 pb-4">
                {evidence.map((_, index) => (
                    <div
                        key={index}
                        onClick={() => goToSlide(index)}
                        className={`w-2 h-2 cursor-pointer transition-colors ${index === currentSlide ? 'bg-solana-purple' : 'bg-gray-700'
                            }`}
                    />
                ))}
            </div>
        </div>
    );
}
