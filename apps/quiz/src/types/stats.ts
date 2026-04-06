export interface QuestionStats {
  c: number;    // correct count
  w: number;    // wrong count
  t: number;    // lastSeen timestamp
}

export interface StatsData {
  questions: Record<string, QuestionStats>;  // questionId -> stats
}
