'use client';

import { useEffect, useState, useMemo } from 'react';
import Link from 'next/link';
import { useSession } from 'next-auth/react';
import { Question } from '@/types/question';
import { useStats } from '@/hooks/useStats';
import { useQuiz } from '@/hooks/useQuiz';
import { loadAllQuestions } from '@/lib/questionLoader';
import { selectSmartQuestions } from '@/lib/smartPractice';
import { getLanguageMeta, isMultiLevelLanguage } from '@/data/registry';
import { StatsData } from '@/types/stats';
import QuizCard from '@/components/QuizCard';
import ScoreDisplay from '@/components/ScoreDisplay';
import ProgressBar from '@/components/ProgressBar';

export default function SmartPracticePage({ params }: { params: { language: string } }) {
  const { language } = params;
  const lang = getLanguageMeta(language);
  const { data: session } = useSession();
  const { stats: localStats, loaded: statsLoaded } = useStats();
  const [allQuestions, setAllQuestions] = useState<Question[]>([]);
  const [dbStats, setDbStats] = useState<StatsData | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (isMultiLevelLanguage(language)) {
      setAllQuestions([]);
      setLoading(false);
      return;
    }
    loadAllQuestions(language).then((qs) => {
      setAllQuestions(qs);
      setLoading(false);
    });
  }, [language]);

  // Fetch DB stats if authenticated
  useEffect(() => {
    if (session?.user && language !== 'german') {
      fetch(`/api/stats/smart?language=${language}`)
        .then(r => r.json())
        .then(data => setDbStats({ questions: data.questions }))
        .catch(() => {});
    }
  }, [session, language]);

  // Merge: prefer DB stats over localStorage, use DB if available
  const effectiveStats = useMemo(() => {
    if (dbStats && Object.keys(dbStats.questions).length > 0) return dbStats;
    return localStats;
  }, [dbStats, localStats]);

  const smartQuestions = useMemo(() => {
    if (!statsLoaded || allQuestions.length === 0) return [];
    return selectSmartQuestions(allQuestions, effectiveStats, 20);
  }, [allQuestions, effectiveStats, statsLoaded]);

  const quiz = useQuiz(smartQuestions, language, 'smart');

  if (!lang) {
    return <div className="text-center text-gray-400 mt-20">Language not found</div>;
  }

  if (isMultiLevelLanguage(language)) {
    return (
      <div className="text-center text-gray-400 mt-20">
        <p>Please select a level for smart practice.</p>
        <Link href={`/${language}`} className="text-blue-400 hover:underline mt-2 inline-block">Back to levels</Link>
      </div>
    );
  }

  if (loading || !statsLoaded || !quiz.loaded) {
    return <div className="text-center text-gray-400 mt-20">Loading smart practice...</div>;
  }

  if (smartQuestions.length === 0) {
    return (
      <div className="text-center text-gray-400 mt-20">
        <p className="text-xl mb-2">No questions available</p>
        <p className="text-sm">Answer some questions first, then come back for smart practice.</p>
      </div>
    );
  }

  if (quiz.isFinished) {
    return (
      <div className="max-w-lg mx-auto text-center mt-12">
        <h2 className="text-2xl font-bold mb-6">Smart Practice Complete!</h2>
        <ScoreDisplay score={quiz.state.score} total={quiz.state.answered} />
        <div className="mt-4">
          <p className="text-gray-400">Smart Practice — {lang.name}</p>
          {dbStats && <p className="text-green-500/60 text-xs mt-1">Using server stats</p>}
        </div>
        <div className="mt-6 flex flex-col sm:flex-row gap-3 justify-center">
          <Link
            href={`/${language}/stats`}
            className="inline-block bg-gray-600 hover:bg-gray-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors"
          >
            View Stats
          </Link>
          <button
            onClick={() => window.location.reload()}
            className="bg-purple-600 hover:bg-purple-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors"
          >
            Practice Again
          </button>
        </div>
      </div>
    );
  }

  return (
    <div>
      <div className="mb-6">
        <div className="flex justify-between items-center mb-2">
          <span className="text-gray-400 text-sm">
            <span className="text-purple-400 font-medium">Smart Practice</span> — {lang.name}
            {dbStats && <span className="text-green-500/60 text-xs ml-2">(server stats)</span>}
          </span>
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
        />
      )}
    </div>
  );
}
