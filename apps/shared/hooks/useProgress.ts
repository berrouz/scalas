'use client';

import { useState, useEffect, useCallback } from 'react';
import { ProgressData } from '../types/question';

export function useProgress(
  loadProgress: () => ProgressData,
  saveProgress: (data: ProgressData) => void,
) {
  const [progress, setProgress] = useState<ProgressData>({ completed: {}, scores: {}, wrong: {} });
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    setProgress(loadProgress());
    setLoaded(true);
  }, [loadProgress]);

  const updateProgress = useCallback((updater: (prev: ProgressData) => ProgressData) => {
    setProgress((prev) => {
      const next = updater(prev);
      saveProgress(next);
      return next;
    });
  }, [saveProgress]);

  return { progress, loaded, updateProgress };
}
