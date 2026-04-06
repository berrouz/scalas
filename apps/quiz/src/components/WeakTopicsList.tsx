import { TopicStat } from '@/lib/statsAggregation';
import ErrorRateBar from './ErrorRateBar';

interface WeakTopicsListProps {
  title: string;
  items: TopicStat[];
  limit?: number;
}

export default function WeakTopicsList({ title, items, limit = 10 }: WeakTopicsListProps) {
  const visible = items.slice(0, limit);
  if (visible.length === 0) return null;

  return (
    <div className="mb-8">
      <h2 className="text-xl font-bold mb-4">{title}</h2>
      <div className="space-y-3">
        {visible.map((item) => (
          <div key={item.name} className="bg-gray-800/50 border border-gray-700 rounded-lg p-4">
            <div className="flex justify-between items-center mb-2">
              <span className="text-white font-medium">{item.name}</span>
              <span className="text-red-400 text-sm font-mono">
                {Math.round(item.errorRate * 100)}% errors
              </span>
            </div>
            <ErrorRateBar errorRate={item.errorRate} />
            <div className="flex justify-between mt-2 text-gray-400 text-xs">
              <span>{item.correct}/{item.correct + item.wrong} correct</span>
              <span>{item.total} questions total</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
