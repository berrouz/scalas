'use client';

import { useEffect, useState, useMemo } from 'react';
import Link from 'next/link';
import { Question } from '@/types/question';
import { useQuiz } from '@/hooks/useQuiz';
import { useStats } from '@/hooks/useStats';
import QuizCard from '@/components/QuizCard';
import ScoreDisplay from '@/components/ScoreDisplay';
import QuizControls from '@/components/QuizControls';
import ProgressBar from '@/components/ProgressBar';
import LevelBadge from '@/components/LevelBadge';
import WeakTopicsList from '@/components/WeakTopicsList';
import { getCategoryMeta, isMultiLevelLanguage, getMultiLevelLevels, getMultiLevelCategoryMeta } from '@/data/registry';
import { getQuizKey } from '@/lib/progress';
import { useProgress } from '@/hooks/useProgress';
import { loadAllQuestions } from '@/lib/questionLoader';
import { aggregateByCategory, aggregateBySubcategory, aggregateByTag } from '@/lib/statsAggregation';
import { selectSmartQuestions } from '@/lib/smartPractice';

const BORDER_COLORS = [
  'border-blue-700 hover:border-blue-500',
  'border-green-700 hover:border-green-500',
  'border-yellow-700 hover:border-yellow-500',
  'border-orange-700 hover:border-orange-500',
  'border-red-700 hover:border-red-500',
  'border-purple-700 hover:border-purple-500',
  'border-cyan-700 hover:border-cyan-500',
  'border-pink-700 hover:border-pink-500',
  'border-teal-700 hover:border-teal-500',
  'border-indigo-700 hover:border-indigo-500',
];

// Multi-level stats page
function MultiLevelStatsPage({ language, levelSlug }: { language: string; levelSlug: string }) {
  const levels = getMultiLevelLevels(language);
  const level = levels.find(l => l.slug === levelSlug);
  const { stats, loaded } = useStats();
  const [questions, setQuestions] = useState<Question[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadAllQuestions(language, levelSlug).then((qs) => {
      setQuestions(qs);
      setLoading(false);
    });
  }, [language, levelSlug]);

  if (!level) {
    return <div className="text-center text-gray-400 mt-20">Level not found</div>;
  }

  if (loading || !loaded) {
    return <div className="text-center text-gray-400 mt-20">Loading stats...</div>;
  }

  const byCategory = aggregateByCategory(questions, stats);
  const bySubcategory = aggregateBySubcategory(questions, stats);
  const byTag = aggregateByTag(questions, stats);
  const hasData = byCategory.length > 0 || bySubcategory.length > 0 || byTag.length > 0;

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-1">
          {level.icon} {level.fullName} — Stats
        </h1>
        <p className="text-gray-400">Your weakest areas based on answer history</p>
      </div>

      {!hasData && (
        <div className="text-center text-gray-400 mt-12">
          <p className="text-xl mb-2">No stats yet</p>
          <p className="text-sm">Answer some questions to see your weak areas here.</p>
        </div>
      )}

      {hasData && (
        <>
          <div className="mb-6">
            <Link
              href={`/${language}/${levelSlug}/smart`}
              className="inline-block bg-purple-600 hover:bg-purple-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors"
            >
              Smart Practice
            </Link>
          </div>

          <WeakTopicsList title="Weakest Categories" items={byCategory} />
          <WeakTopicsList title="Weakest Subcategories" items={bySubcategory} />
          <WeakTopicsList title="Weakest Tags" items={byTag} />
        </>
      )}
    </div>
  );
}

// Multi-level smart practice page
function MultiLevelSmartPage({ language, levelSlug }: { language: string; levelSlug: string }) {
  const levels = getMultiLevelLevels(language);
  const level = levels.find(l => l.slug === levelSlug);
  const { stats, loaded: statsLoaded } = useStats();
  const [allQuestions, setAllQuestions] = useState<Question[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadAllQuestions(language, levelSlug).then((qs) => {
      setAllQuestions(qs);
      setLoading(false);
    });
  }, [language, levelSlug]);

  const smartQuestions = useMemo(() => {
    if (!statsLoaded || allQuestions.length === 0) return [];
    return selectSmartQuestions(allQuestions, stats, 20);
  }, [allQuestions, stats, statsLoaded]);

  const quiz = useQuiz(smartQuestions, language, levelSlug, 'smart');

  if (!level) {
    return <div className="text-center text-gray-400 mt-20">Level not found</div>;
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
          <p className="text-gray-400">Smart Practice — {level.fullName}</p>
        </div>
        <div className="mt-6 flex flex-col sm:flex-row gap-3 justify-center">
          <Link
            href={`/${language}/${levelSlug}/stats`}
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
            <span className="text-purple-400 font-medium">Smart Practice</span> — {level.fullName}
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
          germanLevel={language === 'german' ? levelSlug : undefined}
        />
      )}
    </div>
  );
}

// Multi-level parts page
function MultiLevelPartsPage({ language, levelSlug, categorySlug }: { language: string; levelSlug: string; categorySlug: string }) {
  const cat = getMultiLevelCategoryMeta(language, categorySlug);
  const { progress, loaded } = useProgress();

  if (!cat) {
    return <div className="text-center text-gray-400 mt-20">Category not found</div>;
  }

  const parts = Array.from({ length: cat.parts! }, (_, i) => `part${i + 1}`);

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-1">{cat.name}</h1>
        <p className="text-gray-400">{cat.description}</p>
      </div>

      <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4 max-w-3xl">
        {parts.map((part, idx) => {
          const key = getQuizKey(language, levelSlug, categorySlug, part);
          const score = loaded ? progress.scores[key] : undefined;
          const colorClass = BORDER_COLORS[idx % BORDER_COLORS.length];
          const from = idx * 50 + 1;
          const to = (idx + 1) * 50;

          return (
            <Link key={part} href={`/${language}/${levelSlug}/${categorySlug}/${part}`}>
              <div className={`bg-gray-800/50 border-2 ${colorClass} rounded-lg p-5 transition-colors cursor-pointer`}>
                <h3 className="text-lg font-semibold text-white mb-1">Part {idx + 1}</h3>
                <p className="text-gray-400 text-sm mb-2">Questions {from}–{to}</p>
                <p className="text-gray-500 text-xs">50 questions</p>
                {score && (
                  <p className="text-sm mt-2">
                    <span className={score.correct / score.total >= 0.8 ? 'text-green-400' : score.correct / score.total >= 0.5 ? 'text-yellow-400' : 'text-red-400'}>
                      {score.correct}/{score.total} ({Math.round((score.correct / score.total) * 100)}%)
                    </span>
                  </p>
                )}
              </div>
            </Link>
          );
        })}
      </div>
    </div>
  );
}

// Regular quiz page component
function RegularQuizPage({ language, category, level }: { language: string; category: string; level: string }) {
  const [questions, setQuestions] = useState<Question[]>([]);
  const [loading, setLoading] = useState(true);
  const cat = getCategoryMeta(language, category);

  useEffect(() => {
    setLoading(true);
    import(`@/data/${language}/${category}/${level}`)
      .then((mod) => {
        setQuestions(mod.default || mod.questions || []);
        setLoading(false);
      })
      .catch(() => {
        setQuestions([]);
        setLoading(false);
      });
  }, [language, category, level]);

  const quiz = useQuiz(questions, language, category, level);
  const quizKey = getQuizKey(language, category, level);
  const wrongCount = (quiz.progress.wrong[quizKey] ?? []).length;

  if (loading || !quiz.loaded) {
    return <div className="text-center text-gray-400 mt-20">Loading questions...</div>;
  }

  if (questions.length === 0) {
    return (
      <div className="text-center text-gray-400 mt-20">
        <p className="text-xl mb-2">No questions available yet</p>
        <p className="text-sm">Questions for {cat?.name} {level} are coming soon.</p>
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
            {quiz.state.mode === 'retry' ? 'Retry Wrong' : quiz.state.mode === 'random' ? 'Random 20' : cat?.name} — {level.replace('level', 'Level ')}
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
          <span className="text-gray-400 text-sm capitalize">{cat?.name} — {level.replace('level', 'Level ')}</span>
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

export default function LevelPage({ params }: { params: { language: string; category: string; level: string } }) {
  const { language, category, level } = params;

  // Multi-level languages: language=german/english, category=b1/b2/c1/c2, level=stats/smart/categorySlug
  if (isMultiLevelLanguage(language)) {
    if (level === 'stats') return <MultiLevelStatsPage language={language} levelSlug={category} />;
    if (level === 'smart') return <MultiLevelSmartPage language={language} levelSlug={category} />;
    return <MultiLevelPartsPage language={language} levelSlug={category} categorySlug={level} />;
  }

  return <RegularQuizPage language={language} category={category} level={level} />;
}
