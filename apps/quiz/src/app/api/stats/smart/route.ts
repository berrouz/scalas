import { NextRequest, NextResponse } from 'next/server';
import { getServerSession } from 'next-auth';
import { authOptions } from '@/lib/auth';
import { db } from '@/db';
import { questionStats } from '@/db/schema';
import { eq } from 'drizzle-orm';

// GET /api/stats/smart?language=scala — get question-level stats for smart practice
export async function GET(req: NextRequest) {
  const session = await getServerSession(authOptions);
  if (!session?.user) {
    return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
  }
  const userId = (session.user as any).id;
  const language = req.nextUrl.searchParams.get('language');

  if (!language) {
    return NextResponse.json({ error: 'language is required' }, { status: 400 });
  }

  // Get all stats for questions matching this language prefix
  const allStats = await db
    .select()
    .from(questionStats)
    .where(eq(questionStats.userId, userId));

  // Filter to the requested language
  const langStats = allStats.filter(s => s.questionId.startsWith(`${language}-`));

  // Convert to a map for the client
  const statsMap: Record<string, { c: number; w: number; t: number }> = {};
  for (const s of langStats) {
    statsMap[s.questionId] = {
      c: s.correct,
      w: s.wrong,
      t: s.lastSeen.getTime(),
    };
  }

  return NextResponse.json({ questions: statsMap });
}
