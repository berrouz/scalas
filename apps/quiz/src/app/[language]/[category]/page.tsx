'use client';


import Link from 'next/link';
import { getCategoryMeta, isMultiLevelLanguage, getMultiLevelLevels, getMultiLevelCategories } from '@/data/registry';
import { useProgress } from '@/hooks/useProgress';
import { getQuizKey } from '@/lib/progress';
import { getProgressByPrefix } from '@scalas/quiz-shared';
import type { Level } from '@/types/question';
import ProgressBar from '@/components/ProgressBar';
import LevelBadge from '@/components/LevelBadge';

const levelLabels: Record<Level, { name: string; desc: string }> = {
  level1: { name: 'Level 1 \u2014 Basics', desc: 'Fundamental concepts and syntax' },
  level2: { name: 'Level 2 \u2014 Intermediate', desc: 'Applied knowledge and common patterns' },
  level3: { name: 'Level 3 \u2014 Advanced', desc: 'Deep understanding and edge cases' },
  level4: { name: 'Level 4 \u2014 Expert', desc: 'Production scenarios and internals' },
};

export default function CategoryPage({ params }: { params: { language: string; category: string } }) {
  const { language, category } = params;
  const { progress, loaded } = useProgress();

  // Multi-level languages (German, English): [category] = level slug (b1/b2/c1/c2)
  if (isMultiLevelLanguage(language)) {
    const levels = getMultiLevelLevels(language);
    const currentLevel = levels.find(l => l.slug === category);
    const categories = getMultiLevelCategories(language);

    if (!currentLevel) {
      return <div className="text-center text-gray-400 mt-20">Level not found</div>;
    }

    return (
      <div>
        <div className="mb-8">
          <h1 className="text-3xl font-bold mb-1">
            {currentLevel.icon} {currentLevel.fullName}
          </h1>
          <p className="text-gray-400">{currentLevel.totalQuestions.toLocaleString()} questions in {categories.length} categories</p>
        </div>

        <div className="flex gap-3 mb-6">
          <Link href={`/${language}/${category}/stats`}
            className="bg-gray-700 hover:bg-gray-600 text-white text-sm font-medium px-4 py-2 rounded-lg transition-colors">
            Stats
          </Link>
          <Link href={`/${language}/${category}/smart`}
            className="bg-purple-600 hover:bg-purple-700 text-white text-sm font-medium px-4 py-2 rounded-lg transition-colors">
            Smart Practice
          </Link>
        </div>

        <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {categories.filter((cat) => !cat.availableLevels || cat.availableLevels.includes(category)).map((cat) => {
            const cp = loaded ? getProgressByPrefix(progress, `${language}/${category}/${cat.slug}/`) : { correct: 0, total: 0 };
            return (
              <Link key={cat.slug} href={`/${language}/${category}/${cat.slug}`}>
                <div className="bg-gray-800/50 border border-gray-700 rounded-lg p-5 hover:border-gray-500 transition-colors cursor-pointer h-full">
                  <div className="flex items-center gap-2 mb-1">
                    <LevelBadge level={category} />
                    <h3 className="text-lg font-semibold text-white">{cat.name}</h3>
                  </div>
                  <p className="text-gray-400 text-sm mb-3">{cat.description}</p>
                  <div className="text-gray-500 text-xs mb-2">{cat.questionCount} questions · {cat.parts} parts</div>
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

  // Programming languages: show level selection
  const cat = getCategoryMeta(language, category);

  if (!cat) {
    return <div className="text-center text-gray-400 mt-20">Category not found</div>;
  }

  const levels: Level[] = ['level1', 'level2', 'level3', 'level4'];

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-1">{cat.name}</h1>
        <p className="text-gray-400">{cat.description}</p>
      </div>

      <div className="grid sm:grid-cols-2 gap-4 max-w-2xl">
        {levels.map((level) => {
          const key = getQuizKey(language, category, level);
          const score = loaded ? progress.scores[key] : undefined;
          const count = cat.levels[level];
          const colors = {
            level1: 'border-green-700 hover:border-green-500',
            level2: 'border-yellow-700 hover:border-yellow-500',
            level3: 'border-orange-700 hover:border-orange-500',
            level4: 'border-red-700 hover:border-red-500',
          };

          return (
            <Link key={level} href={`/${language}/${category}/${level}`}>
              <div className={`bg-gray-800/50 border-2 ${colors[level]} rounded-lg p-5 transition-colors cursor-pointer`}>
                <h3 className="text-lg font-semibold text-white mb-1">{levelLabels[level].name}</h3>
                <p className="text-gray-400 text-sm mb-2">{levelLabels[level].desc}</p>
                <p className="text-gray-500 text-xs">{count} questions</p>
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
