interface GrammarRuleBoxProps {
  rule: string;
}

export default function GrammarRuleBox({ rule }: GrammarRuleBoxProps) {
  return (
    <div className="mt-3 p-3 bg-yellow-900/20 border border-yellow-700/40 rounded-lg">
      <p className="text-sm text-yellow-400 mb-1">Regel:</p>
      <p className="text-gray-200 text-sm">{rule}</p>
    </div>
  );
}
