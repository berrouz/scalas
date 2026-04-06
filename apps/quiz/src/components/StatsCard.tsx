interface StatsCardProps {
  label: string;
  value: string | number;
  sub?: string;
}

export default function StatsCard({ label, value, sub }: StatsCardProps) {
  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-lg p-4 text-center">
      <div className="text-2xl font-bold text-white">{value}</div>
      <div className="text-gray-400 text-sm">{label}</div>
      {sub && <div className="text-gray-500 text-xs mt-1">{sub}</div>}
    </div>
  );
}
