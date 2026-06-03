interface CodeBlockProps {
    code: string;
    vulnerabilities: string[];
}

export default function CodeBlock({ code, vulnerabilities }: CodeBlockProps) {
    return (
        <div>
            {/* Background changed to slate-50 and border to slate-200 */}
            <div className="bg-slate-50 p-6 border border-slate-200 overflow-x-auto">
                <pre className="text-sm font-mono leading-relaxed text-slate-800">
                    <code dangerouslySetInnerHTML={{ __html: code }} />
                </pre>
            </div>

            {vulnerabilities.length > 0 && (
                
                <div className="mt-6 p-4 bg-white border border-slate-200 border-l-4 border-l-blue-600">
                    <h4 className="font-semibold mb-4 text-slate-900">Key Vulnerabilities Identified:</h4>
                    <ul className="text-slate-600 space-y-3">
                        {vulnerabilities.map((vuln, index) => (
                            <li key={index} className="text-sm leading-relaxed flex items-start">
                                <span className="text-blue-600 mr-2">•</span>
                                <span>{vuln}</span>
                            </li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}