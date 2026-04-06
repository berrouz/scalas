interface QuizControlsProps {
  onRetryWrong: () => void;
  onRandom: () => void;
  onRestart: () => void;
  wrongCount: number;
  labels?: {
    restart?: string;
    random?: string;
    retryWrong?: string;
  };
}

export default function QuizControls({
  onRetryWrong,
  onRandom,
  onRestart,
  wrongCount,
  labels = {},
}: QuizControlsProps) {
  const { restart = 'Restart All', random = 'Random 20', retryWrong = 'Retry Wrong' } = labels;

  return (
    <div className="flex flex-wrap gap-3 justify-center mt-6">
      <button
        onClick={onRestart}
        className="px-4 py-2 bg-gray-700 hover:bg-gray-600 text-white rounded-lg transition-colors"
      >
        {restart}
      </button>
      <button
        onClick={onRandom}
        className="px-4 py-2 bg-purple-700 hover:bg-purple-600 text-white rounded-lg transition-colors"
      >
        {random}
      </button>
      {wrongCount > 0 && (
        <button
          onClick={onRetryWrong}
          className="px-4 py-2 bg-red-700 hover:bg-red-600 text-white rounded-lg transition-colors"
        >
          {retryWrong} ({wrongCount})
        </button>
      )}
    </div>
  );
}
