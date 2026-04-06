'use client';

import { useProgress as useProgressBase } from '@scalas/quiz-shared';
import { loadProgress, saveProgress } from '@/lib/progress';

export function useProgress() {
  return useProgressBase(loadProgress, saveProgress);
}
