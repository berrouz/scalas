'use client';

import { useEffect, useState } from 'react';
import { Question } from '@/types/question';
import { useQuiz } from '@/hooks/useQuiz';
import QuizCard from '@/components/QuizCard';
import ScoreDisplay from '@/components/ScoreDisplay';
import QuizControls from '@/components/QuizControls';
import ProgressBar from '@/components/ProgressBar';
import { getMultiLevelCategoryMeta } from '@/data/registry';
import { getQuizKey } from '@/lib/progress';

export default function MultiLevelQuizPage({ params }: { params: { language: string; category: string; level: string; part: string } }) {
  const { language, category, level, part } = params;
  // language=german/english, category=b1/b2/c1/c2 (level), level=artikel/email/... (category slug), part=part1/...
  const [questions, setQuestions] = useState<Question[]>([]);
  const [loading, setLoading] = useState(true);
  const cat = getMultiLevelCategoryMeta(language, level);
  const isGerman = language === 'german';

  useEffect(() => {
    setLoading(true);
    import(`@/data/${language}/${category}/${level}/${part}`)
      .then((mod) => {
        setQuestions(mod.default || mod.questions || []);
        setLoading(false);
      })
      .catch(() => {
        setQuestions([]);
        setLoading(false);
      });
  }, [language, category, level, part]);

  const quiz = useQuiz(questions, language, category, level, part);
  const quizKey = getQuizKey(language, category, level, part);
  const wrongCount = (quiz.progress.wrong[quizKey] ?? []).length;

  if (loading || !quiz.loaded) {
    return <div className="text-center text-gray-400 mt-20">Loading questions...</div>;
  }

  if (questions.length === 0) {
    return (
      <div className="text-center text-gray-400 mt-20">
        <p className="text-xl mb-2">No questions available yet</p>
        <p className="text-sm">Questions for {cat?.name} {part} coming soon.</p>
      </div>
    );
  }

  if (quiz.isFinished) {
    return (
      <div className="max-w-lg mx-auto text-center mt-12">
        <h2 className="text-2xl font-bold mb-6">Quiz Complete!</h2>
        <ScoreDisplay score={quiz.state.score} total={quiz.state.answered} />
        <div className="mt-4">
          <p className="text-gray-400">
            {quiz.state.mode === 'retry' ? 'Retrying wrong' : quiz.state.mode === 'random' ? 'Random 20' : cat?.name} — {part.replace('part', 'Part ')}
          </p>
        </div>
        <QuizControls
          onRetryWrong={quiz.retryWrong}
          onRandom={quiz.randomTwenty}
          onRestart={quiz.restart}
          wrongCount={wrongCount}
        />
      </div>
    );
  }

  return (
    <div>
      <div className="mb-6">
        <div className="flex justify-between items-center mb-2">
          <span className="text-gray-400 text-sm">{cat?.name} — {part.replace('part', 'Part ')}</span>
          <span className="text-gray-400 text-sm">
            {quiz.state.score}/{quiz.state.answered} correct
          </span>
        </div>
        <ProgressBar current={quiz.state.currentIndex} total={quiz.total} />
      </div>

      {quiz.currentQuestion && (
        <QuizCard
          question={quiz.currentQuestion}
          selectedAnswer={quiz.state.selectedAnswer}
          showExplanation={quiz.state.showExplanation}
          questionNumber={quiz.state.currentIndex + 1}
          totalQuestions={quiz.total}
          onSelectAnswer={quiz.selectAnswer}
          onNext={quiz.nextQuestion}
          germanLevel={isGerman ? category : undefined}
        />
      )}

      <div className="mt-8 flex justify-center">
        <QuizControls
          onRetryWrong={quiz.retryWrong}
          onRandom={quiz.randomTwenty}
          onRestart={quiz.restart}
          wrongCount={wrongCount}
        />
      </div>
    </div>
  );
}
