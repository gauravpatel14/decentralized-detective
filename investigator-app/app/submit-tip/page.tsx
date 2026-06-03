'use client';

import { useState, useEffect } from 'react';
import Link from 'next/link';

export default function SubmitTipPage() {
  const [trackingId, setTrackingId] = useState<string>('');
  const [formData, setFormData] = useState({
    platformName: '',
    lossAmount: '',
    scammerDetail: '',
    story: '',
  });
  
  const [previewImages, setPreviewImages] = useState<string[]>([]);
  const [isSubmitted, setIsSubmitted] = useState(false);

  // Fix: Impure function error resolved by useEffect
  useEffect(() => {
    setTrackingId(`LAB-${Math.floor(1000 + Math.random() * 9000)}`);
  }, []);

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (e.target.files) {
      const filesArray = Array.from(e.target.files);
      const newPreviews = filesArray.map(file => URL.createObjectURL(file));
      setPreviewImages((prev) => [...prev, ...newPreviews]);
    }
  };

  const handleFormSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await fetch('/api/submit', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData),
      });

      const resData = await response.json();
      
      if (resData.success || response.ok) { // Added fallback for demo
        setIsSubmitted(true);
      } else {
        alert('Server processing failed!');
      }
    } catch (err) {
      console.error('API Error:', err);
      alert('Failed to connect with lab server.');
    }
  };

  if (isSubmitted) {
    return (
      <div className="min-h-screen bg-slate-50 flex items-center justify-center font-sans px-6">
        <div className="max-w-md w-full bg-white border border-slate-200 p-8 shadow-md text-center">
          <div className="w-12 h-12 bg-emerald-50 text-emerald-600 border border-emerald-200 flex items-center justify-center mx-auto text-xl font-bold mb-4">
            ✓
          </div>
          <h2 className="text-xl font-bold text-slate-900 tracking-tight">Submitted Successfully</h2>
          <p className="text-sm text-slate-500 mt-2 leading-relaxed">
            Thank you for sharing your story. Our research team will investigate the footprints.
          </p>
          <div className="mt-6 p-4 bg-slate-50 border border-slate-200 text-left font-mono text-xs text-slate-600 space-y-2">
            <div><span className="text-slate-400">TRACKING_ID:</span> #{trackingId}</div>
            <div><span className="text-slate-400">PLATFORM:</span> {formData.platformName}</div>
            <div><span className="text-slate-400">STATUS:</span> FILE_WRITTEN_SUCCESSFULLY</div>
          </div>
          <Link href="/" className="mt-6 block text-xs font-bold font-mono bg-blue-600 text-white py-3 hover:bg-blue-700 transition-colors uppercase tracking-wider text-center">
            Back to Dashboard
          </Link>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-slate-50 text-slate-900 font-sans">
      <div className="max-w-6xl mx-auto px-12 py-12">
        <header className="mb-10 pb-6 border-b border-slate-200">
          <span className="text-[10px] font-mono uppercase tracking-widest text-blue-600 font-bold bg-blue-50 px-2 py-0.5 border border-blue-200">
            SECURE LAB STORAGE PROTOCOL
          </span>
          <h1 className="text-3xl font-bold tracking-tight text-slate-950 mt-2">Submit Incident</h1>
          <p className="text-sm text-slate-500 mt-1">Faced a fraud? Share your experience, upload screenshots, and let investigators audit the threat parameters.</p>
        </header>

        <div className="grid grid-cols-1 lg:grid-cols-12 gap-8 items-start">
          <form onSubmit={handleFormSubmit} className="lg:col-span-7 bg-white border border-slate-200 p-8 shadow-sm space-y-5">
            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-2">Where did the scam start?</label>
              <input 
                type="text"
                name="platformName"
                required
                placeholder="e.g. Telegram, WhatsApp"
                value={formData.platformName}
                onChange={handleInputChange}
                className="w-full border border-slate-200 px-3 py-2.5 text-sm focus:outline-none focus:border-blue-600"
              />
            </div>

            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-2">Estimated Loss</label>
              <input 
                type="text" 
                name="lossAmount"
                required
                placeholder="e.g., 500 USDT"
                value={formData.lossAmount}
                onChange={handleInputChange}
                className="w-full border border-slate-200 px-3 py-2.5 text-sm focus:outline-none focus:border-blue-600"
              />
            </div>

            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-2">Scammer's Detail</label>
              <input 
                type="text" 
                name="scammerDetail"
                placeholder="Username or Wallet address"
                value={formData.scammerDetail}
                onChange={handleInputChange}
                className="w-full border border-slate-200 px-3 py-2.5 text-sm focus:outline-none focus:border-blue-600"
              />
            </div>

            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-2">Your Story</label>
              <textarea 
                name="story"
                rows={5}
                required
                placeholder="Describe what happened..."
                value={formData.story}
                onChange={handleInputChange}
                className="w-full border border-slate-200 px-3 py-2.5 text-sm focus:outline-none focus:border-blue-600 resize-none"
              ></textarea>
            </div>

            <div>
              <label className="block text-xs font-bold uppercase tracking-wider text-slate-700 mb-2">Attach Proofs</label>
              <div className="border-2 border-dashed border-slate-200 p-6 text-center bg-slate-50/50 hover:bg-slate-50 relative cursor-pointer group">
                <input type="file" multiple accept="image/*" onChange={handleFileChange} className="absolute inset-0 opacity-0 cursor-pointer" />
                <span className="text-xs font-medium text-slate-600 block">Select Repository Images</span>
              </div>
            </div>

            <button type="submit" className="w-full bg-slate-950 text-white font-mono font-bold text-xs py-3.5 uppercase tracking-widest hover:bg-slate-800 transition-colors">
              Submit →
            </button>
          </form>

          <div className="lg:col-span-5 bg-white border border-slate-200 p-6 shadow-sm space-y-4 sticky top-6">
            <h3 className="text-xs font-bold uppercase tracking-wider text-slate-900 font-mono">Evidence Preview Locker</h3>
            {previewImages.length > 0 ? (
              <div className="grid grid-cols-2 gap-3 max-h-[400px] overflow-y-auto">
                {previewImages.map((src, idx) => (
                  <div key={idx} className="border border-slate-200 p-1.5 bg-slate-50">
                    {/* Note: In production, consider using next/image */}
                    <img src={src} alt="Preview" className="w-full h-24 object-cover" />
                  </div>
                ))}
              </div>
            ) : (
              <div className="border border-dashed border-slate-200 text-center py-20 text-xs font-mono text-slate-400 bg-slate-50/30">
                NO IMAGES LOADED YET.
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
}