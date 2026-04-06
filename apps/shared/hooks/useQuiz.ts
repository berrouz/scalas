'use client';

import { useState, useCallback, useEffect } from 'react';
import { BaseQuestion, QuizState, ProgressData } from '../types/question';
import { shuffle, pickRandom } from '../lib/shuffle';

export interface UseQuizOptions<Q extends BaseQuestion> {
  allQuestions: Q[];
  quizKey: string;
  progress: ProgressData;
  loaded: boolean;
  updateProgress: (updater: (prev: ProgressData) => ProgressData) => void;
  transformQuestions?: (questions: Q[]) => Q[];
}

export function useQuiz<Q extends BaseQuestion>({
  allQuestions,
  quizKey,
  progress,
  loaded,
  updateProgress,
  transformQuestions,
}: UseQuizOptions<Q>) {
  const transform = transformQuestions ?? ((q: Q[]) => q);

  const [state, setState] = useState<QuizState<Q>>({
    questions: [],
    currentIndex: 0,
    selectedAnswer: null,
    showExplanation: false,
    score: 0,
    answered: 0,
    wrongIds: [],
    mode: 'normal',
  });

  useEffect(() => {
    if (allQuestions.length > 0) {
      setState((s) => ({ ...s, questions: transform(shuffle(allQuestions)) }));
    }
  }, [allQuestions]);

  const currentQuestion = state.questions[state.currentIndex] ?? null;
  const isFinished = state.currentIndex >= state.questions.length && state.questions.length > 0;
  const total = state.questions.length;

  const selectAnswer = useCallback((index: number) => {
    setState((s) => {
      if (s.selectedAnswer !== null) return s;
      const q = s.questions[s.currentIndex];
      if (!q) return s;
      const isCorrect = index === q.correctAnswer;
      return {
        ...s,
        selectedAnswer: index,
        showExplanation: true,
        score: isCorrect ? s.score + 1 : s.score,
        answered: s.answered + 1,
        wrongIds: isCorrect ? s.wrongIds : [...s.wrongIds, q.id],
      };
    });
  }, []);

  const nextQuestion = useCallback(() => {
    setState((s) => {
      const nextIndex = s.currentIndex + 1;
      if (nextIndex >= s.questions.length) {
        updateProgress((prev) => ({
          ...prev,
          scores: { ...prev.scores, [quizKey]: { correct: s.score, total: s.answered } },
          completed: { ...prev.completed, [quizKey]: s.questions.map((q) => q.id) },
          wrong: { ...prev.wrong, [quizKey]: s.wrongIds },
        }));
      }
      return {
        ...s,
        currentIndex: nextIndex,
        selectedAnswer: null,
        showExplanation: false,
      };
    });
  }, [quizKey, updateProgress]);

  const retryWrong = useCallback(() => {
    const wrongQuestions = allQuestions.filter((q) =>
      (progress.wrong[quizKey] ?? []).includes(q.id),
    );
    if (wrongQuestions.length === 0) return;
    setState({
      questions: transform(shuffle(wrongQuestions)),
      currentIndex: 0,
      selectedAnswer: null,
      showExplanation: false,
      score: 0,
      answered: 0,
      wrongIds: [],
      mode: 'retry',
    });
  }, [allQuestions, progress, quizKey, transform]);

  const randomTwenty = useCallback(() => {
    setState({
      questions: transform(pickRandom(allQuestions, 20)),
      currentIndex: 0,
      selectedAnswer: null,
      showExplanation: false,
      score: 0,
      answered: 0,
      wrongIds: [],
      mode: 'random',
    });
  }, [allQuestions, transform]);

  const restart = useCallback(() => {
    setState({
      questions: transform(shuffle(allQuestions)),
      currentIndex: 0,
      selectedAnswer: null,
      showExplanation: false,
      score: 0,
      answered: 0,
      wrongIds: [],
      mode: 'normal',
    });
  }, [allQuestions, transform]);

  useEffect(() => {
    const handler = (e: KeyboardEvent) => {
      if (e.target instanceof HTMLInputElement || e.target instanceof HTMLTextAreaElement) return;
      if (['1', '2', '3', '4'].includes(e.key) && state.selectedAnswer === null) {
        selectAnswer(parseInt(e.key) - 1);
      }
      if (e.key === 'Enter' && state.showExplanation) {
        nextQuestion();
      }
    };
    window.addEventListener('keydown', handler);
    return () => window.removeEventListener('keydown', handler);
  }, [state.selectedAnswer, state.showExplanation, selectAnswer, nextQuestion]);

  return {
    state,
    currentQuestion,
    isFinished,
    total,
    loaded,
    progress,
    selectAnswer,
    nextQuestion,
    retryWrong,
    randomTwenty,
    restart,
  };
}
