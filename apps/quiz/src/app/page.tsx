'use client';

import Link from 'next/link';
import { languages, isMultiLevelLanguage, getMultiLevelLevels } from '@/data/registry';
import { useProgress } from '@/hooks/useProgress';
import { getLanguageProgress } from '@/lib/progress';
import ProgressBar from '@/components/ProgressBar';

export default function HomePage() {
  const { progress, loaded } = useProgress();

  return (
    <div>
      <div className="text-center mb-12">
        <h1 className="text-4xl font-bold mb-3">53,516 Quiz Questions</h1>
        <p className="text-gray-400 text-lg">Master Java, Scala, Kotlin, DDIA, AI Engineering & Deutsche Grammatik</p>
        <Link
          href="/custom"
          className="inline-block mt-4 bg-green-600 hover:bg-green-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors"
        >
          Custom Test — Mix Topics
        </Link>
      </div>

      <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6 max-w-5xl mx-auto">
        {languages.map((lang) => {
          const lp = loaded ? getLanguageProgress(progress, lang.slug) : { correct: 0, total: 0 };
          const mlLevels = isMultiLevelLanguage(lang.slug) ? getMultiLevelLevels(lang.slug) : null;
          const subtitle = mlLevels
            ? `${lang.totalQuestions.toLocaleString()} questions \u00b7 ${mlLevels.length} levels`
            : `${lang.totalQuestions} questions \u00b7 ${lang.categories.length} categories`;
          return (
            <Link key={lang.slug} href={`/${lang.slug}`}>
              <div className={`bg-gradient-to-br ${lang.color} rounded-xl p-6 hover:scale-105 transition-transform cursor-pointer h-full`}>
                <div className="text-4xl mb-3">{lang.icon}</div>
                <h2 className="text-2xl font-bold text-white mb-1">{lang.name}</h2>
                <p className="text-white/80 text-sm mb-4">{subtitle}</p>
                {loaded && lp.total > 0 && (
                  <div>
                    <ProgressBar current={lp.correct} total={lang.totalQuestions} />
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
