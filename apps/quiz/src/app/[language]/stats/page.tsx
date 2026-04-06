'use client';

import { useEffect, useState } from 'react';
import Link from 'next/link';
import { Question } from '@/types/question';
import { useStats } from '@/hooks/useStats';
import { loadAllQuestions } from '@/lib/questionLoader';
import { aggregateByCategory, aggregateBySubcategory, aggregateByTag } from '@/lib/statsAggregation';
import WeakTopicsList from '@/components/WeakTopicsList';
import { getLanguageMeta, isMultiLevelLanguage } from '@/data/registry';

export default function StatsPage({ params }: { params: { language: string } }) {
  const { language } = params;
  const lang = getLanguageMeta(language);
  const { stats, loaded } = useStats();
  const [questions, setQuestions] = useState<Question[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (isMultiLevelLanguage(language)) {
      setQuestions([]);
      setLoading(false);
      return;
    }
    loadAllQuestions(language).then((qs) => {
      setQuestions(qs);
      setLoading(false);
    });
  }, [language]);

  if (!lang) {
    return <div className="text-center text-gray-400 mt-20">Language not found</div>;
  }

  if (isMultiLevelLanguage(language)) {
    return (
      <div className="text-center text-gray-400 mt-20">
        <p>Please select a level to view stats.</p>
        <Link href={`/${language}`} className="text-blue-400 hover:underline mt-2 inline-block">Back to levels</Link>
      </div>
    );
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
        <h1 className="text-3xl font-bold mb-1">{lang.icon} {lang.name} — Stats</h1>
        <p className="text-gray-400">Your weakest areas based on accumulated answer history</p>
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
              href={`/${language}/smart`}
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
