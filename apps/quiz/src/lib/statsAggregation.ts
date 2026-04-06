import { Question } from '@/types/question';
import { StatsData } from '@/types/stats';

export interface TopicStat {
  name: string;
  answered: number;
  correct: number;
  wrong: number;
  errorRate: number;
  total: number;
}

type KeyFn = (q: Question) => string;

function aggregate(questions: Question[], stats: StatsData, keyFn: KeyFn): TopicStat[] {
  const groups = new Map<string, { total: number; correct: number; wrong: number }>();

  for (const q of questions) {
    const key = keyFn(q);
    const group = groups.get(key) ?? { total: 0, correct: 0, wrong: 0 };
    group.total++;
    const s = stats.questions[q.id];
    if (s) {
      group.correct += s.c;
      group.wrong += s.w;
    }
    groups.set(key, group);
  }

  return Array.from(groups.entries())
    .map(([name, g]) => ({
      name,
      answered: g.correct + g.wrong,
      correct: g.correct,
      wrong: g.wrong,
      errorRate: g.correct + g.wrong > 0 ? g.wrong / (g.correct + g.wrong) : 0,
      total: g.total,
    }))
    .filter((s) => s.answered > 0)
    .sort((a, b) => b.errorRate - a.errorRate);
}

export function aggregateByCategory(questions: Question[], stats: StatsData): TopicStat[] {
  return aggregate(questions, stats, (q) => q.category);
}

export function aggregateBySubcategory(questions: Question[], stats: StatsData): TopicStat[] {
  return aggregate(questions, stats, (q) => q.subcategory);
}

export function aggregateByTag(questions: Question[], stats: StatsData): TopicStat[] {
  const result: TopicStat[] = [];
  const groups = new Map<string, { total: number; correct: number; wrong: number }>();

  for (const q of questions) {
    for (const tag of q.tags) {
      const group = groups.get(tag) ?? { total: 0, correct: 0, wrong: 0 };
      group.total++;
      const s = stats.questions[q.id];
      if (s) {
        group.correct += s.c;
        group.wrong += s.w;
      }
      groups.set(tag, group);
    }
  }

  return Array.from(groups.entries())
    .map(([name, g]) => ({
      name,
      answered: g.correct + g.wrong,
      correct: g.correct,
      wrong: g.wrong,
      errorRate: g.correct + g.wrong > 0 ? g.wrong / (g.correct + g.wrong) : 0,
      total: g.total,
    }))
    .filter((s) => s.answered > 0)
    .sort((a, b) => b.errorRate - a.errorRate);
}
