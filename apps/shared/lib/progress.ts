import { ProgressData } from '../types/question';

function getDefaultProgress(): ProgressData {
  return { completed: {}, scores: {}, wrong: {} };
}

export function createProgressStore(storageKey: string) {
  function loadProgress(): ProgressData {
    if (typeof window === 'undefined') return getDefaultProgress();
    try {
      const raw = localStorage.getItem(storageKey);
      return raw ? JSON.parse(raw) : getDefaultProgress();
    } catch {
      return getDefaultProgress();
    }
  }

  function saveProgress(data: ProgressData): void {
    if (typeof window === 'undefined') return;
    localStorage.setItem(storageKey, JSON.stringify(data));
  }

  function resetProgress(): void {
    if (typeof window === 'undefined') return;
    localStorage.removeItem(storageKey);
  }

  return { loadProgress, saveProgress, resetProgress };
}

export function getQuizKey(...segments: string[]): string {
  return segments.join('/');
}

export function getProgressByPrefix(progress: ProgressData, prefix: string): { correct: number; total: number } {
  let correct = 0;
  let total = 0;
  for (const [key, score] of Object.entries(progress.scores)) {
    if (key.startsWith(prefix)) {
      correct += score.correct;
      total += score.total;
    }
  }
  return { correct, total };
}
