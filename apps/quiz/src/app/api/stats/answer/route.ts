import { NextRequest, NextResponse } from 'next/server';
import { getServerSession } from 'next-auth';
import { authOptions } from '@/lib/auth';
import { db } from '@/db';
import { questionStats } from '@/db/schema';
import { eq, and, sql } from 'drizzle-orm';

// POST /api/stats/answer — record a single answer
export async function POST(req: NextRequest) {
  const session = await getServerSession(authOptions);
  if (!session?.user) {
    return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
  }
  const userId = (session.user as any).id;
  const { questionId, isCorrect } = await req.json();

  if (!questionId || typeof isCorrect !== 'boolean') {
    return NextResponse.json({ error: 'Invalid payload' }, { status: 400 });
  }

  await db
    .insert(questionStats)
    .values({
      userId,
      questionId,
      correct: isCorrect ? 1 : 0,
      wrong: isCorrect ? 0 : 1,
      lastSeen: new Date(),
    })
    .onConflictDoUpdate({
      target: [questionStats.userId, questionStats.questionId],
      set: {
        correct: isCorrect
          ? sql`${questionStats.correct} + 1`
          : questionStats.correct,
        wrong: isCorrect
          ? questionStats.wrong
          : sql`${questionStats.wrong} + 1`,
        lastSeen: new Date(),
      },
    });

  return NextResponse.json({ ok: true });
}
