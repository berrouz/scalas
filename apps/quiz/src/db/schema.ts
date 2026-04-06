import { pgTable, text, integer, timestamp, primaryKey, serial, uniqueIndex } from 'drizzle-orm/pg-core';

// NextAuth tables
export const users = pgTable('users', {
  id: text('id').primaryKey(),
  name: text('name'),
  email: text('email').unique(),
  emailVerified: timestamp('email_verified'),
  image: text('image'),
});

export const accounts = pgTable('accounts', {
  id: text('id').primaryKey(),
  userId: text('user_id').notNull().references(() => users.id, { onDelete: 'cascade' }),
  type: text('type').notNull(),
  provider: text('provider').notNull(),
  providerAccountId: text('provider_account_id').notNull(),
  refresh_token: text('refresh_token'),
  access_token: text('access_token'),
  expires_at: integer('expires_at'),
  token_type: text('token_type'),
  scope: text('scope'),
  id_token: text('id_token'),
  session_state: text('session_state'),
});

export const sessions = pgTable('sessions', {
  sessionToken: text('session_token').primaryKey(),
  userId: text('user_id').notNull().references(() => users.id, { onDelete: 'cascade' }),
  expires: timestamp('expires').notNull(),
});

export const verificationTokens = pgTable('verification_tokens', {
  identifier: text('identifier').notNull(),
  token: text('token').notNull(),
  expires: timestamp('expires').notNull(),
}, (t) => ({
  pk: primaryKey({ columns: [t.identifier, t.token] }),
}));

// Quiz stats — one row per user+question
export const questionStats = pgTable('question_stats', {
  userId: text('user_id').notNull().references(() => users.id, { onDelete: 'cascade' }),
  questionId: text('question_id').notNull(),
  correct: integer('correct').notNull().default(0),
  wrong: integer('wrong').notNull().default(0),
  lastSeen: timestamp('last_seen').notNull().defaultNow(),
}, (t) => ({
  pk: primaryKey({ columns: [t.userId, t.questionId] }),
}));

// Quiz session log — one row per completed quiz session
export const quizSessions = pgTable('quiz_sessions', {
  id: serial('id').primaryKey(),
  userId: text('user_id').notNull().references(() => users.id, { onDelete: 'cascade' }),
  language: text('language').notNull(),
  category: text('category').notNull(),
  level: text('level'),
  totalQuestions: integer('total_questions').notNull(),
  correctAnswers: integer('correct_answers').notNull(),
  wrongAnswers: integer('wrong_answers').notNull(),
  duration: integer('duration'), // seconds
  completedAt: timestamp('completed_at').notNull().defaultNow(),
});
