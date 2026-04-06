export async function recordAnswerApi(questionId: string, isCorrect: boolean): Promise<void> {
  try {
    await fetch('/api/stats/answer', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ questionId, isCorrect }),
    });
  } catch {
    // silently fail — localStorage is the fallback
  }
}

export async function recordSessionApi(data: {
  language: string;
  category: string;
  level?: string;
  totalQuestions: number;
  correctAnswers: number;
  wrongAnswers: number;
  duration?: number;
}): Promise<void> {
  try {
    await fetch('/api/stats/session', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    });
  } catch {
    // silently fail
  }
}

export interface DbQuestionStat {
  questionId: string;
  correct: number;
  wrong: number;
  lastSeen: string;
}

export interface DbQuizSession {
  id: number;
  language: string;
  category: string;
  level: string | null;
  totalQuestions: number;
  correctAnswers: number;
  wrongAnswers: number;
  duration: number | null;
  completedAt: string;
}

export async function fetchStats(): Promise<{ stats: DbQuestionStat[]; sessions: DbQuizSession[] } | null> {
  try {
    const res = await fetch('/api/stats');
    if (!res.ok) return null;
    return res.json();
  } catch {
    return null;
  }
}
