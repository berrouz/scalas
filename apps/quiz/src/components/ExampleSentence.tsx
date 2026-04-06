interface ExampleSentenceProps {
  sentence: string;
}

export default function ExampleSentence({ sentence }: ExampleSentenceProps) {
  return (
    <div className="mt-3 p-3 bg-gray-800/80 border border-gray-600 rounded-lg">
      <p className="text-sm text-gray-400 mb-1">Beispiel:</p>
      <p className="text-gray-100 italic">&bdquo;{sentence}&ldquo;</p>
    </div>
  );
}
