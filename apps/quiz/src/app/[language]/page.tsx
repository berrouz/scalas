'use client';


import Link from 'next/link';
import { getLanguageMeta, isMultiLevelLanguage, getMultiLevelLevels } from '@/data/registry';
import { useProgress } from '@/hooks/useProgress';
import { getCategoryProgress } from '@/lib/progress';
import { getProgressByPrefix } from '@scalas/quiz-shared';
import ProgressBar from '@/components/ProgressBar';

export default function LanguagePage({ params }: { params: { language: string } }) {
  const { language } = params;
  const lang = getLanguageMeta(language);
  const { progress, loaded } = useProgress();

  if (!lang) {
    return <div className="text-center text-gray-400 mt-20">Language not found</div>;
  }

  if (isMultiLevelLanguage(language)) {
    const levels = getMultiLevelLevels(language);
    return (
      <div>
        <div className="mb-8">
          <h1 className="text-3xl font-bold mb-1">
            {lang.icon} {lang.name}
          </h1>
          <p className="text-gray-400">{lang.totalQuestions.toLocaleString()} questions in {levels.length} levels</p>
        </div>

        <div className="flex gap-3 mb-6">
          {levels.map((level) => (
            <Link key={`stats-${level.slug}`} href={`/${language}/${level.slug}/stats`}
              className="bg-gray-700 hover:bg-gray-600 text-white text-sm font-medium px-4 py-2 rounded-lg transition-colors">
              {level.name} Stats
            </Link>
          ))}
        </div>

        <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-6 max-w-5xl mx-auto">
          {levels.map((level) => {
            const lp = loaded ? getProgressByPrefix(progress, `${language}/${level.slug}/`) : { correct: 0, total: 0 };
            return (
              <Link key={level.slug} href={`/${language}/${level.slug}`}>
                <div className={`bg-gradient-to-br ${level.color} rounded-xl p-6 hover:scale-105 transition-transform cursor-pointer h-full`}>
                  <div className="text-4xl mb-3">{level.icon}</div>
                  <h2 className="text-2xl font-bold text-white mb-1">{level.name}</h2>
                  <p className="text-white/90 text-sm font-medium mb-1">{level.fullName}</p>
                  <p className="text-white/70 text-sm mb-4">
                    {level.totalQuestions.toLocaleString()} questions
                  </p>
                  {loaded && lp.total > 0 && (
                    <div>
                      <ProgressBar current={lp.correct} total={level.totalQuestions} />
                      <p className="text-white/70 text-xs mt-1">
                        {lp.correct}/{lp.total} correct ({Math.round((lp.correct / lp.total) * 100)}%)
                      </p>
                    </div>
                  )}
                </div>
              </Link>
            );
          })}
        </div>
      </div>
    );
  }

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-1">
          {lang.icon} {lang.name}
        </h1>
        <p className="text-gray-400">{lang.totalQuestions} questions across {lang.categories.length} categories</p>
      </div>

      <div className="flex gap-3 mb-6">
        <Link href={`/${language}/stats`}
          className="bg-gray-700 hover:bg-gray-600 text-white text-sm font-medium px-4 py-2 rounded-lg transition-colors">
          Stats
        </Link>
        <Link href={`/${language}/smart`}
          className="bg-purple-600 hover:bg-purple-700 text-white text-sm font-medium px-4 py-2 rounded-lg transition-colors">
          Smart Practice
        </Link>
        <Link href="/custom"
          className="bg-green-600 hover:bg-green-700 text-white text-sm font-medium px-4 py-2 rounded-lg transition-colors">
          Custom Test
        </Link>
      </div>

      <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
        {lang.categories.map((cat) => {
          const cp = loaded ? getCategoryProgress(progress, language, cat.slug) : { correct: 0, total: 0 };
          return (
            <Link key={cat.slug} href={`/${language}/${cat.slug}`}>
              <div className="bg-gray-800/50 border border-gray-700 rounded-lg p-5 hover:border-gray-500 transition-colors cursor-pointer h-full">
                <h3 className="text-lg font-semibold text-white mb-1">{cat.name}</h3>
                <p className="text-gray-400 text-sm mb-3">{cat.description}</p>
                <div className="text-gray-500 text-xs mb-2">{cat.questionCount} questions</div>
                {loaded && cp.total > 0 && (
                  <div>
                    <ProgressBar current={cp.correct} total={cat.questionCount} />
                    <p className="text-gray-500 text-xs mt-1">{cp.correct}/{cp.total} correct</p>
                  </div>
                )}
              </div>
            </Link>
          );
        })}
      </div>
    </div>
  );
}
