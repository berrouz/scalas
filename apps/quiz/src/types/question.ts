import { BaseQuestion } from '@scalas/quiz-shared';

export type { ProgressData, QuizState } from '@scalas/quiz-shared';

export type Language = 'java' | 'scala' | 'kotlin' | 'flutter' | 'ddia' | 'ai-engineer' | 'kafka' | 'git' | 'docker' | 'german' | 'english' | 'behavioral' | 'algorithms' | 'postgresql' | 'kubernetes';
export type Level = 'level1' | 'level2' | 'level3' | 'level4';

export interface Question extends BaseQuestion {
  language: Language;
  level: string;
  codeSnippet?: string;
  exampleSentence?: string;
  grammarRule?: string;
}

export interface CategoryMeta {
  slug: string;
  name: string;
  description: string;
  questionCount: number;
  levels: Record<string, number>;
  parts?: number;
  availableLevels?: string[];
}

export interface GermanLevelMeta {
  slug: string;
  name: string;
  fullName: string;
  icon: string;
  color: string;
  totalQuestions: number;
}

export interface LanguageMeta {
  slug: Language;
  name: string;
  icon: string;
  color: string;
  totalQuestions: number;
  categories: CategoryMeta[];
}
