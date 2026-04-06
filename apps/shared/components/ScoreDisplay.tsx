interface ScoreDisplayProps {
  score: number;
  total: number;
  label?: string;
}

export default function ScoreDisplay({ score, total, label = 'Score' }: ScoreDisplayProps) {
  const pct = total > 0 ? Math.round((score / total) * 100) : 0;
  const color = pct >= 80 ? 'text-green-400' : pct >= 50 ? 'text-yellow-400' : 'text-red-400';

  return (
    <div className="text-center">
      <div className={`text-3xl font-bold ${color}`}>{score}/{total}</div>
      <div className="text-gray-400 text-sm">{label} — {pct}%</div>
    </div>
  );
}
