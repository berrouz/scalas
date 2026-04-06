'use client';

import { Question } from '@/types/question';
import OptionButton from './OptionButton';
import ExplanationPanel from './ExplanationPanel';
import CodeBlock from './CodeBlock';
import LevelBadge from './LevelBadge';

interface QuizCardProps {
  question: Question;
  selectedAnswer: number | null;
  showExplanation: boolean;
  questionNumber: number;
  totalQuestions: number;
  onSelectAnswer: (index: number) => void;
  onNext: () => void;
  germanLevel?: string;
}

export default function QuizCard({
  question,
  selectedAnswer,
  showExplanation,
  questionNumber,
  totalQuestions,
  onSelectAnswer,
  onNext,
  germanLevel,
}: QuizCardProps) {
  const isGerman = question.language === 'german';

  return (
    <div className="max-w-3xl mx-auto">
      <div className="flex justify-between items-center mb-4 text-sm text-gray-400">
        <span>{isGerman ? `Frage ${questionNumber} von ${totalQuestions}` : `Question ${questionNumber} of ${totalQuestions}`}</span>
        <span className="flex items-center gap-2">
          {isGerman && germanLevel && <LevelBadge level={germanLevel} />}
          <span className="capitalize">{question.subcategory}</span>
        </span>
      </div>

      <div className="bg-gray-800/50 rounded-xl p-6 border border-gray-700">
        <h2 className="text-lg font-medium text-gray-100 mb-4">{question.question}</h2>

        {question.codeSnippet && (
          <CodeBlock code={question.codeSnippet} language={question.language} />
        )}

        <div className="space-y-3 mt-4">
          {question.options.map((opt, i) => (
            <OptionButton
              key={i}
              index={i}
              text={opt}
              selected={selectedAnswer === i}
              correct={i === question.correctAnswer}
              revealed={showExplanation}
              onClick={() => onSelectAnswer(i)}
            />
          ))}
        </div>

        {showExplanation && (
          <>
            <ExplanationPanel
              explanation={question.explanation}
              codeSnippet={question.codeSnippet}
              language={question.language}
              exampleSentence={question.exampleSentence}
              grammarRule={question.grammarRule}
            />
            <button
              onClick={onNext}
              className="mt-4 w-full py-3 bg-blue-600 hover:bg-blue-700 text-white rounded-lg font-medium transition-colors"
            >
              {isGerman ? 'Nächste Frage →' : 'Next Question →'}
            </button>
            <p className="text-center text-gray-500 text-xs mt-2">
              {isGerman ? 'oder Enter drücken' : 'or press Enter'}
            </p>
          </>
        )}
      </div>

      <p className="text-center text-gray-600 text-xs mt-3">
        {isGerman ? 'Taste 1-4 zum Auswählen' : 'Press 1-4 to select answer'}
      </p>
    </div>
  );
}
