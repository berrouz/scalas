'use client';

import { useState, useEffect, useCallback } from 'react';
import { StatsData } from '@/types/stats';
import { loadStats, saveStats } from '@/lib/stats';

export function useStats() {
  const [stats, setStats] = useState<StatsData>({ questions: {} });
  const [loaded, setLoaded] = useState(false);

  useEffect(() => {
    setStats(loadStats());
    setLoaded(true);
  }, []);

  const updateStats = useCallback((updater: (prev: StatsData) => StatsData) => {
    setStats((prev) => {
      const next = updater(prev);
      saveStats(next);
      return next;
    });
  }, []);

  return { stats, loaded, updateStats };
}
