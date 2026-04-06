import { NextRequest, NextResponse } from 'next/server';
import { getServerSession } from 'next-auth';
import { authOptions } from '@/lib/auth';
import { db } from '@/db';
import { questionStats, quizSessions } from '@/db/schema';
import { eq, and, sql } from 'drizzle-orm';

// GET /api/stats — get all question stats for current user
export async function GET() {
  const session = await getServerSession(authOptions);
  if (!session?.user) {
    return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
  }
  const userId = (session.user as any).id;

  const stats = await db.select().from(questionStats).where(eq(questionStats.userId, userId));
  const recentSessions = await db
    .select()
    .from(quizSessions)
    .where(eq(quizSessions.userId, userId))
    .orderBy(sql`${quizSessions.completedAt} DESC`)
    .limit(50);

  return NextResponse.json({ stats, sessions: recentSessions });
}
