import { createProgressStore, getProgressByPrefix } from '@scalas/quiz-shared';
import { ProgressData } from '@/types/question';

export { getQuizKey } from '@scalas/quiz-shared';

const store = createProgressStore('quiz-progress');

export const { loadProgress, saveProgress, resetProgress } = store;

export function getCategoryProgress(progress: ProgressData, language: string, category: string): { correct: number; total: number } {
  return getProgressByPrefix(progress, `${language}/${category}/`);
}

export function getLanguageProgress(progress: ProgressData, language: string): { correct: number; total: number } {
  return getProgressByPrefix(progress, `${language}/`);
}
