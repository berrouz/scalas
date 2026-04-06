import { StatsData, QuestionStats } from '@/types/stats';

const STORAGE_KEY = 'quiz-stats';

function getDefaultStats(): StatsData {
  return { questions: {} };
}

export function loadStats(): StatsData {
  if (typeof window === 'undefined') return getDefaultStats();
  try {
    const raw = localStorage.getItem(STORAGE_KEY);
    return raw ? JSON.parse(raw) : getDefaultStats();
  } catch {
    return getDefaultStats();
  }
}

export function saveStats(data: StatsData): void {
  if (typeof window === 'undefined') return;
  localStorage.setItem(STORAGE_KEY, JSON.stringify(data));
}

export function recordAnswer(stats: StatsData, questionId: string, isCorrect: boolean): StatsData {
  const prev: QuestionStats = stats.questions[questionId] ?? { c: 0, w: 0, t: 0 };
  return {
    ...stats,
    questions: {
      ...stats.questions,
      [questionId]: {
        c: prev.c + (isCorrect ? 1 : 0),
        w: prev.w + (isCorrect ? 0 : 1),
        t: Date.now(),
      },
    },
  };
}
