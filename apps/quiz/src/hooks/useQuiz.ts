'use client';

import { useCallback } from 'react';
import { useSession } from 'next-auth/react';
import { useQuiz as useQuizBase, shuffle } from '@scalas/quiz-shared';
import { Question } from '@/types/question';
import { useProgress } from './useProgress';
import { useStats } from './useStats';
import { getQuizKey } from '@/lib/progress';
import { recordAnswer } from '@/lib/stats';
import { recordAnswerApi } from '@/lib/statsApi';

function shuffleGermanOptions(questions: Question[]): Question[] {
  return questions.map((q) => {
    const indices = shuffle([0, 1, 2, 3]);
    return {
      ...q,
      options: indices.map((i) => q.options[i]) as [string, string, string, string],
      correctAnswer: indices.indexOf(q.correctAnswer) as 0 | 1 | 2 | 3,
    };
  });
}

export function useQuiz(
  allQuestions: Question[],
  ...keySegments: string[]
) {
  const { data: session } = useSession();
  const { progress, loaded, updateProgress } = useProgress();
  const { stats, updateStats } = useStats();
  const quizKey = getQuizKey(...keySegments);
  const isMultiLevel = keySegments[0] === 'german' || keySegments[0] === 'english';

  const quiz = useQuizBase<Question>({
    allQuestions,
    quizKey,
    progress,
    loaded,
    updateProgress,
    transformQuestions: isMultiLevel ? shuffleGermanOptions : undefined,
  });

  const selectAnswerWithStats = useCallback((index: number) => {
    const q = quiz.state.questions[quiz.state.currentIndex];
    if (q && quiz.state.selectedAnswer === null) {
      const isCorrect = index === q.correctAnswer;
      updateStats((prev) => recordAnswer(prev, q.id, isCorrect));
      if (session?.user) {
        recordAnswerApi(q.id, isCorrect);
      }
    }
    quiz.selectAnswer(index);
  }, [quiz.state.questions, quiz.state.currentIndex, quiz.state.selectedAnswer, quiz.selectAnswer, updateStats, session]);

  return {
    ...quiz,
    selectAnswer: selectAnswerWithStats,
    stats,
  };
}
