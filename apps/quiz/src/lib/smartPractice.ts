import { Question } from '@/types/question';
import { StatsData } from '@/types/stats';

export function selectSmartQuestions(questions: Question[], stats: StatsData, count = 20): Question[] {
  const now = Date.now();
  const DAY_MS = 86400000;

  const scored = questions.map((q) => {
    const s = stats.questions[q.id];
    let priority: number;
    if (!s || (s.c === 0 && s.w === 0)) {
      priority = 0.8;
    } else {
      const total = s.c + s.w;
      priority = s.w / total;
      const daysSince = (now - s.t) / DAY_MS;
      priority += 0.1 * Math.min(daysSince / 30, 1);
    }
    return { q, priority };
  });

  scored.sort((a, b) => b.priority - a.priority);
  const selected = scored.slice(0, count).map((s) => s.q);

  // Shuffle the selected questions
  for (let i = selected.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [selected[i], selected[j]] = [selected[j], selected[i]];
  }

  return selected;
}
