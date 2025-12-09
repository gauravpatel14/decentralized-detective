interface CodeBlockProps {
    code: string;
    vulnerabilities: string[];
}

export default function CodeBlock({ code, vulnerabilities }: CodeBlockProps) {
    return (
        <div>
            <div className="bg-[#0a0a0a] p-6 border border-gray-800 overflow-x-auto">
                <pre className="text-sm font-mono leading-relaxed">
                    <code dangerouslySetInnerHTML={{ __html: code }} />
                </pre>
            </div>

            {vulnerabilities.length > 0 && (
                <div className="mt-6 p-4 bg-black border-l-4 border-solana-purple">
                    <h4 className="font-semibold mb-4">Key Vulnerabilities Identified:</h4>
                    <ul className="text-gray-300 space-y-3">
                        {vulnerabilities.map((vuln, index) => (
                            <li key={index} className="text-sm leading-relaxed flex items-start">
                                <span className="text-solana-purple mr-2">•</span>
                                <span>{vuln}</span>
                            </li>
                        ))}
                    </ul>
                </div>
            )}
        </div>
    );
}
