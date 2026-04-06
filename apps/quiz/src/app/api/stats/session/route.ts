import { NextRequest, NextResponse } from 'next/server';
import { getServerSession } from 'next-auth';
import { authOptions } from '@/lib/auth';
import { db } from '@/db';
import { quizSessions } from '@/db/schema';

// POST /api/stats/session — record a completed quiz session
export async function POST(req: NextRequest) {
  const session = await getServerSession(authOptions);
  if (!session?.user) {
    return NextResponse.json({ error: 'Unauthorized' }, { status: 401 });
  }
  const userId = (session.user as any).id;
  const body = await req.json();

  await db.insert(quizSessions).values({
    userId,
    language: body.language,
    category: body.category,
    level: body.level || null,
    totalQuestions: body.totalQuestions,
    correctAnswers: body.correctAnswers,
    wrongAnswers: body.wrongAnswers,
    duration: body.duration || null,
  });

  return NextResponse.json({ ok: true });
}
