export interface BaseQuestion {
  id: string;
  category: string;
  subcategory: string;
  question: string;
  options: [string, string, string, string];
  correctAnswer: 0 | 1 | 2 | 3;
  explanation: string;
  tags: string[];
}

export interface QuizState<Q extends BaseQuestion = BaseQuestion> {
  questions: Q[];
  currentIndex: number;
  selectedAnswer: number | null;
  showExplanation: boolean;
  score: number;
  answered: number;
  wrongIds: string[];
  mode: 'normal' | 'retry' | 'random';
}

export interface ProgressData {
  completed: Record<string, string[]>;
  scores: Record<string, { correct: number; total: number }>;
  wrong: Record<string, string[]>;
}
