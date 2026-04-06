interface ErrorRateBarProps {
  errorRate: number;
  className?: string;
}

export default function ErrorRateBar({ errorRate, className }: ErrorRateBarProps) {
  const pct = Math.round(errorRate * 100);
  return (
    <div className={`w-full bg-gray-700 rounded-full h-2 ${className ?? ''}`}>
      <div
        className="bg-red-500 h-2 rounded-full transition-all duration-300"
        style={{ width: `${pct}%` }}
      />
    </div>
  );
}
