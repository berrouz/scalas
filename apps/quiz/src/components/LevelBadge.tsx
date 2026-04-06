interface LevelBadgeProps {
  level: string;
}

const levelColors: Record<string, string> = {
  b1: 'bg-green-600',
  b2: 'bg-blue-600',
  c1: 'bg-orange-600',
  c2: 'bg-red-600',
};

export default function LevelBadge({ level }: LevelBadgeProps) {
  return (
    <span className={`inline-block px-2 py-0.5 rounded text-xs font-bold text-white uppercase ${levelColors[level] ?? 'bg-gray-600'}`}>
      {level}
    </span>
  );
}
