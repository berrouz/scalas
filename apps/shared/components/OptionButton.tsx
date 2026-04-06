interface OptionButtonProps {
  index: number;
  text: string;
  selected: boolean;
  correct: boolean;
  revealed: boolean;
  onClick: () => void;
}

export default function OptionButton({ index, text, selected, correct, revealed, onClick }: OptionButtonProps) {
  let bg = 'bg-gray-800 hover:bg-gray-700 border-gray-700';
  if (revealed) {
    if (correct) bg = 'bg-green-900/60 border-green-500';
    else if (selected) bg = 'bg-red-900/60 border-red-500';
    else bg = 'bg-gray-800 border-gray-700 opacity-60';
  }

  const labels = ['A', 'B', 'C', 'D'];

  return (
    <button
      onClick={onClick}
      disabled={revealed}
      className={`w-full text-left p-4 rounded-lg border-2 transition-all ${bg} ${!revealed ? 'cursor-pointer' : 'cursor-default'}`}
    >
      <span className="inline-flex items-center gap-3">
        <span className={`inline-flex items-center justify-center w-8 h-8 rounded-full text-sm font-bold ${
          revealed && correct ? 'bg-green-500 text-white' :
          revealed && selected ? 'bg-red-500 text-white' :
          'bg-gray-700 text-gray-300'
        }`}>
          {labels[index]}
        </span>
        <span className="text-gray-100">{text}</span>
      </span>
    </button>
  );
}
