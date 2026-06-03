
import Link from 'next/link';

export default function Navbar() {
  return (
    <nav className="w-full bg-white border-b border-slate-200 py-4 px-12">
      <div className="max-w-7xl mx-auto flex justify-between items-center">
        
        {/* Logo and Brand */}
        <div className="flex items-center gap-2">
          <div className="flex gap-1">
            <div className="w-2 h-2 bg-blue-500 rounded-full"></div>
            <div className="w-2 h-2 bg-red-500 rounded-full"></div>
            <div className="w-2 h-2 bg-yellow-400 rounded-full"></div>
            <div className="w-2 h-2 bg-green-500 rounded-full"></div>
          </div>
          <span className="font-bold text-slate-900">R&D Forensic Lab</span>
        </div>
        
        {/* Updated Navigation Links (Case Files Removed) */}
        <div className="flex items-center gap-6 text-sm text-slate-600">
          <Link href="/" className="hover:text-blue-600 transition-colors">Dashboard</Link>
          <Link href="/methodology" className="hover:text-blue-600 transition-colors">Methodology</Link>
        </div>

        
        <div className="flex items-center gap-4">
          <Link href="/submit-tip">
            <button className="bg-blue-600 text-white text-sm px-4 py-2 rounded font-medium hover:bg-blue-700 transition-colors cursor-pointer">
              Submit
            </button>
          </Link>
        </div>

      </div>
    </nav>
  );
}