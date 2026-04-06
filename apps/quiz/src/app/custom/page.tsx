'use client';

import { useEffect, useState, useMemo, useCallback } from 'react';
import Link from 'next/link';
import { Question } from '@/types/question';
import { useQuiz } from '@/hooks/useQuiz';
import { loadAllQuestions } from '@/lib/questionLoader';
import { languages, isMultiLevelLanguage } from '@/data/registry';
import { pickRandom } from '@scalas/quiz-shared';
import QuizCard from '@/components/QuizCard';
import ScoreDisplay from '@/components/ScoreDisplay';
import ProgressBar from '@/components/ProgressBar';
import type { LanguageMeta, CategoryMeta } from '@/types/question';

type Phase = 'config' | 'quiz';

const LEVEL_LABELS: Record<string, string> = {
  level1: 'Level 1 — Basics',
  level2: 'Level 2 — Intermediate',
  level3: 'Level 3 — Advanced',
  level4: 'Level 4 — Expert',
};

const COUNT_PRESETS = [10, 20, 30, 50, 100];

// Only programming languages (not multi-level like german/english)
const quizLanguages = languages.filter((l) => !isMultiLevelLanguage(l.slug) && l.categories.length > 0);

export default function CustomTestPage() {
  const [allQuestions, setAllQuestions] = useState<Map<string, Question[]>>(new Map());
  const [loadingLangs, setLoadingLangs] = useState<Set<string>>(new Set());
  const [loadedLangs, setLoadedLangs] = useState<Set<string>>(new Set());

  // Config state
  const [selectedLangs, setSelectedLangs] = useState<Set<string>>(new Set());
  const [selectedCategories, setSelectedCategories] = useState<Set<string>>(new Set()); // "lang:categoryName"
  const [selectedLevels, setSelectedLevels] = useState<Set<string>>(new Set(['level1', 'level2', 'level3', 'level4']));
  const [questionCount, setQuestionCount] = useState(20);

  const [phase, setPhase] = useState<Phase>('config');
  const [quizQuestions, setQuizQuestions] = useState<Question[]>([]);

  // Load questions when a language is selected
  useEffect(() => {
    for (const slug of selectedLangs) {
      if (loadedLangs.has(slug) || loadingLangs.has(slug)) continue;
      setLoadingLangs((prev) => new Set(prev).add(slug));
      loadAllQuestions(slug).then((qs) => {
        setAllQuestions((prev) => new Map(prev).set(slug, qs));
        setLoadedLangs((prev) => new Set(prev).add(slug));
        setLoadingLangs((prev) => {
          const next = new Set(prev);
          next.delete(slug);
          return next;
        });
      });
    }
  }, [selectedLangs, loadedLangs, loadingLangs]);

  // When a language is toggled on, auto-select all its categories
  const toggleLang = useCallback((slug: string) => {
    const lang = quizLanguages.find((l) => l.slug === slug);
    if (!lang) return;

    setSelectedLangs((prev) => {
      const next = new Set(prev);
      const wasSelected = next.has(slug);

      if (wasSelected) {
        next.delete(slug);
        // Remove all categories for this language
        setSelectedCategories((prevCats) => {
          const nextCats = new Set(prevCats);
          lang.categories.forEach((c) => nextCats.delete(`${slug}:${c.name}`));
          return nextCats;
        });
      } else {
        next.add(slug);
        // Auto-select all categories
        setSelectedCategories((prevCats) => {
          const nextCats = new Set(prevCats);
          lang.categories.forEach((c) => nextCats.add(`${slug}:${c.name}`));
          return nextCats;
        });
      }
      return next;
    });
  }, []);

  const toggleCategory = useCallback((langSlug: string, catName: string) => {
    const key = `${langSlug}:${catName}`;
    setSelectedCategories((prev) => {
      const next = new Set(prev);
      if (next.has(key)) next.delete(key);
      else next.add(key);
      return next;
    });
  }, []);

  const toggleLevel = useCallback((level: string) => {
    setSelectedLevels((prev) => {
      const next = new Set(prev);
      if (next.has(level)) next.delete(level);
      else next.add(level);
      return next;
    });
  }, []);

  const toggleAllCategoriesForLang = useCallback((slug: string) => {
    const lang = quizLanguages.find((l) => l.slug === slug);
    if (!lang) return;
    setSelectedCategories((prev) => {
      const langKeys = lang.categories.map((c) => `${slug}:${c.name}`);
      const allSelected = langKeys.every((k) => prev.has(k));
      const next = new Set(prev);
      if (allSelected) {
        langKeys.forEach((k) => next.delete(k));
      } else {
        langKeys.forEach((k) => next.add(k));
      }
      return next;
    });
  }, []);

  // Build filtered pool
  const poolQuestions = useMemo(() => {
    const pool: Question[] = [];
    for (const [slug, qs] of allQuestions) {
      if (!selectedLangs.has(slug)) continue;
      for (const q of qs) {
        const catKey = `${slug}:${q.category}`;
        if (selectedCategories.has(catKey) && selectedLevels.has(q.level)) {
          pool.push(q);
        }
      }
    }
    return pool;
  }, [allQuestions, selectedLangs, selectedCategories, selectedLevels]);

  const isLoading = loadingLangs.size > 0;
  const availableCount = poolQuestions.length;
  const effectiveCount = Math.min(questionCount, availableCount);

  const startQuiz = useCallback(() => {
    setQuizQuestions(pickRandom(poolQuestions, effectiveCount));
    setPhase('quiz');
  }, [poolQuestions, effectiveCount]);

  const backToConfig = useCallback(() => {
    setPhase('config');
    setQuizQuestions([]);
  }, []);

  const quiz = useQuiz(quizQuestions, 'custom');

  // Quiz phase
  if (phase === 'quiz') {
    if (!quiz.loaded) {
      return <div className="text-center text-gray-400 mt-20">Loading quiz...</div>;
    }

    if (quiz.isFinished) {
      const langNames = [...selectedLangs].map((s) => quizLanguages.find((l) => l.slug === s)?.name).filter(Boolean);
      return (
        <div className="max-w-lg mx-auto text-center mt-12">
          <h2 className="text-2xl font-bold mb-6">Custom Test Complete!</h2>
          <ScoreDisplay score={quiz.state.score} total={quiz.state.answered} />
          <div className="mt-4">
            <p className="text-gray-400">Custom Test — {langNames.join(', ')}</p>
            <p className="text-gray-500 text-sm mt-1">
              {selectedCategories.size} topic{selectedCategories.size !== 1 ? 's' : ''} · {[...selectedLevels].sort().map((l) => l.replace('level', 'L')).join(', ')}
            </p>
          </div>
          <div className="mt-6 flex flex-col sm:flex-row gap-3 justify-center">
            <button
              onClick={backToConfig}
              className="bg-green-600 hover:bg-green-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors"
            >
              New Custom Test
            </button>
            <Link
              href="/"
              className="inline-block bg-gray-600 hover:bg-gray-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors"
            >
              Home
            </Link>
          </div>
        </div>
      );
    }

    const currentLang = quiz.currentQuestion
      ? quizLanguages.find((l) => l.slug === quiz.currentQuestion!.language)
      : null;

    return (
      <div>
        <div className="mb-6">
          <div className="flex justify-between items-center mb-2">
            <span className="text-gray-400 text-sm">
              <span className="text-green-400 font-medium">Custom Test</span>
              {currentLang && <span> — {currentLang.icon} {currentLang.name}</span>}
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

  // Config phase
  const canStart = selectedCategories.size > 0 && selectedLevels.size > 0 && availableCount > 0 && !isLoading;

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-1">Custom Test</h1>
        <p className="text-gray-400">Mix questions from different quizzes into one test</p>
      </div>

      {/* Quiz Selection */}
      <div className="mb-8">
        <h2 className="text-lg font-semibold text-white mb-3">Quizzes</h2>
        <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-3">
          {quizLanguages.map((lang) => {
            const isSelected = selectedLangs.has(lang.slug);
            const isLoadingThis = loadingLangs.has(lang.slug);
            return (
              <button
                key={lang.slug}
                onClick={() => toggleLang(lang.slug)}
                className={`text-left p-4 rounded-lg border-2 transition-colors ${
                  isSelected
                    ? 'bg-blue-600/20 border-blue-500'
                    : 'bg-gray-800/50 border-gray-700 hover:border-gray-500'
                }`}
              >
                <div className="flex items-center gap-2">
                  <span className="text-2xl">{lang.icon}</span>
                  <div>
                    <span className={`font-semibold ${isSelected ? 'text-white' : 'text-gray-300'}`}>
                      {lang.name}
                    </span>
                    {isLoadingThis && <span className="text-xs text-blue-400 ml-2">loading...</span>}
                  </div>
                </div>
                <p className="text-xs text-gray-500 mt-1">
                  {lang.categories.length} categories · {lang.totalQuestions.toLocaleString()} questions
                </p>
              </button>
            );
          })}
        </div>
      </div>

      {/* Categories per selected language */}
      {[...selectedLangs].map((slug) => {
        const lang = quizLanguages.find((l) => l.slug === slug);
        if (!lang) return null;
        const langKeys = lang.categories.map((c) => `${slug}:${c.name}`);
        const selectedCount = langKeys.filter((k) => selectedCategories.has(k)).length;
        const allSelected = selectedCount === lang.categories.length;

        return (
          <div key={slug} className="mb-6">
            <div className="flex items-center justify-between mb-2">
              <h3 className="text-md font-semibold text-white">
                {lang.icon} {lang.name} — Topics
              </h3>
              <button
                onClick={() => toggleAllCategoriesForLang(slug)}
                className="text-blue-400 hover:text-blue-300 text-sm transition-colors"
              >
                {allSelected ? 'Deselect All' : 'Select All'}
              </button>
            </div>
            <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-2">
              {lang.categories.map((cat) => {
                const key = `${slug}:${cat.name}`;
                const isSelected = selectedCategories.has(key);
                return (
                  <button
                    key={key}
                    onClick={() => toggleCategory(slug, cat.name)}
                    className={`text-left p-2.5 rounded-lg border transition-colors ${
                      isSelected
                        ? 'bg-blue-600/15 border-blue-500/60 text-white'
                        : 'bg-gray-800/30 border-gray-700 text-gray-400 hover:border-gray-500'
                    }`}
                  >
                    <div className="flex items-center gap-2">
                      <div className={`w-3.5 h-3.5 rounded border flex items-center justify-center flex-shrink-0 ${
                        isSelected ? 'bg-blue-500 border-blue-500' : 'border-gray-500'
                      }`}>
                        {isSelected && <span className="text-white text-[10px]">✓</span>}
                      </div>
                      <span className="text-sm">{cat.name}</span>
                      <span className="text-xs text-gray-500 ml-auto">{cat.questionCount}</span>
                    </div>
                  </button>
                );
              })}
            </div>
          </div>
        );
      })}

      {/* Difficulty */}
      {selectedLangs.size > 0 && (
        <div className="mb-8">
          <h2 className="text-lg font-semibold text-white mb-3">Difficulty</h2>
          <div className="flex flex-wrap gap-2">
            {(['level1', 'level2', 'level3', 'level4'] as const).map((level) => {
              const isSelected = selectedLevels.has(level);
              return (
                <button
                  key={level}
                  onClick={() => toggleLevel(level)}
                  className={`px-4 py-2 rounded-lg border text-sm font-medium transition-colors ${
                    isSelected
                      ? 'bg-blue-600/20 border-blue-500 text-white'
                      : 'bg-gray-800/50 border-gray-700 text-gray-400 hover:border-gray-500'
                  }`}
                >
                  {LEVEL_LABELS[level]}
                </button>
              );
            })}
          </div>
        </div>
      )}

      {/* Question Count */}
      {selectedLangs.size > 0 && (
        <div className="mb-8">
          <h2 className="text-lg font-semibold text-white mb-3">Questions</h2>
          <div className="flex flex-wrap gap-2 mb-3">
            {COUNT_PRESETS.map((n) => (
              <button
                key={n}
                onClick={() => setQuestionCount(n)}
                className={`px-4 py-2 rounded-lg text-sm font-medium transition-colors ${
                  questionCount === n
                    ? 'bg-blue-600 text-white'
                    : 'bg-gray-700 text-gray-300 hover:bg-gray-600'
                }`}
              >
                {n}
              </button>
            ))}
            <input
              type="number"
              min={1}
              max={availableCount || 1}
              value={questionCount}
              onChange={(e) => setQuestionCount(Math.max(1, parseInt(e.target.value) || 1))}
              className="w-20 px-3 py-2 rounded-lg bg-gray-700 border border-gray-600 text-white text-sm text-center focus:outline-none focus:border-blue-500"
            />
          </div>
          <p className="text-gray-500 text-sm">
            {isLoading ? 'Loading questions...' : `${availableCount.toLocaleString()} questions available`}
            {!isLoading && availableCount > 0 && effectiveCount < questionCount && (
              <span className="text-yellow-400"> — will use all {availableCount}</span>
            )}
          </p>
        </div>
      )}

      {/* Start */}
      <button
        onClick={startQuiz}
        disabled={!canStart}
        className={`px-8 py-3 rounded-lg text-lg font-semibold transition-colors ${
          canStart
            ? 'bg-green-600 hover:bg-green-700 text-white'
            : 'bg-gray-700 text-gray-500 cursor-not-allowed'
        }`}
      >
        Start Quiz{canStart ? ` (${effectiveCount} questions)` : ''}
      </button>
    </div>
  );
}
