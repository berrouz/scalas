'use client';

import { useEffect, useState, useMemo } from 'react';
import { useSession } from 'next-auth/react';
import Link from 'next/link';
import {
  BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer,
  PieChart, Pie, Cell, Legend,
  AreaChart, Area, CartesianGrid,
  RadarChart, Radar, PolarGrid, PolarAngleAxis, PolarRadiusAxis,
} from 'recharts';
import { fetchStats, DbQuestionStat, DbQuizSession } from '@/lib/statsApi';
import { languages } from '@/data/registry';

const COLORS = ['#3b82f6', '#10b981', '#f59e0b', '#ef4444', '#8b5cf6', '#ec4899', '#06b6d4', '#f97316'];

interface DashboardData {
  stats: DbQuestionStat[];
  sessions: DbQuizSession[];
}

function parseCategory(questionId: string): { language: string; category: string } {
  // e.g. "scala-collections-l1-001" -> { language: "scala", category: "collections" }
  // e.g. "german-b1-artikel-p1-001" -> { language: "german", category: "artikel" }
  const parts = questionId.split('-');
  return { language: parts[0], category: parts[1] };
}

function OverviewCards({ data }: { data: DashboardData }) {
  const totalAnswered = data.stats.reduce((s, q) => s + q.correct + q.wrong, 0);
  const totalCorrect = data.stats.reduce((s, q) => s + q.correct, 0);
  const totalWrong = data.stats.reduce((s, q) => s + q.wrong, 0);
  const accuracy = totalAnswered > 0 ? Math.round((totalCorrect / totalAnswered) * 100) : 0;
  const uniqueQuestions = data.stats.length;
  const sessionsCount = data.sessions.length;

  const cards = [
    { label: 'Total Answers', value: totalAnswered.toLocaleString(), color: 'text-blue-400' },
    { label: 'Unique Questions', value: uniqueQuestions.toLocaleString(), color: 'text-cyan-400' },
    { label: 'Accuracy', value: `${accuracy}%`, color: accuracy >= 70 ? 'text-green-400' : accuracy >= 50 ? 'text-yellow-400' : 'text-red-400' },
    { label: 'Quiz Sessions', value: sessionsCount.toString(), color: 'text-purple-400' },
    { label: 'Correct', value: totalCorrect.toLocaleString(), color: 'text-green-400' },
    { label: 'Wrong', value: totalWrong.toLocaleString(), color: 'text-red-400' },
  ];

  return (
    <div className="grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-6 gap-4 mb-8">
      {cards.map((c) => (
        <div key={c.label} className="bg-gray-800/50 border border-gray-700 rounded-xl p-4 text-center">
          <div className={`text-2xl font-bold ${c.color}`}>{c.value}</div>
          <div className="text-gray-400 text-xs mt-1">{c.label}</div>
        </div>
      ))}
    </div>
  );
}

function AccuracyByLanguage({ data }: { data: DashboardData }) {
  const byLang = useMemo(() => {
    const map = new Map<string, { correct: number; wrong: number }>();
    for (const s of data.stats) {
      const { language } = parseCategory(s.questionId);
      const prev = map.get(language) ?? { correct: 0, wrong: 0 };
      prev.correct += s.correct;
      prev.wrong += s.wrong;
      map.set(language, prev);
    }
    return Array.from(map.entries())
      .map(([name, v]) => ({
        name: languages.find(l => l.slug === name)?.name ?? name,
        accuracy: Math.round((v.correct / (v.correct + v.wrong)) * 100),
        correct: v.correct,
        wrong: v.wrong,
        total: v.correct + v.wrong,
      }))
      .sort((a, b) => b.total - a.total);
  }, [data.stats]);

  if (byLang.length === 0) return null;

  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6 mb-8">
      <h2 className="text-xl font-bold mb-4">Accuracy by Language</h2>
      <ResponsiveContainer width="100%" height={300}>
        <BarChart data={byLang} layout="vertical" margin={{ left: 60 }}>
          <XAxis type="number" domain={[0, 100]} tickFormatter={(v) => `${v}%`} stroke="#6b7280" />
          <YAxis type="category" dataKey="name" stroke="#6b7280" width={100} />
          <Tooltip
            contentStyle={{ backgroundColor: '#1f2937', border: '1px solid #374151', borderRadius: '8px' }}
            labelStyle={{ color: '#fff' }}
            formatter={(value: any, name: any) => [`${value}%`, name]}
          />
          <Bar dataKey="accuracy" name="Accuracy" radius={[0, 6, 6, 0]}>
            {byLang.map((_, i) => (
              <Cell key={i} fill={COLORS[i % COLORS.length]} />
            ))}
          </Bar>
        </BarChart>
      </ResponsiveContainer>
    </div>
  );
}

function WeakCategories({ data }: { data: DashboardData }) {
  const weak = useMemo(() => {
    const map = new Map<string, { correct: number; wrong: number; lang: string }>();
    for (const s of data.stats) {
      const { language, category } = parseCategory(s.questionId);
      const key = `${language}/${category}`;
      const prev = map.get(key) ?? { correct: 0, wrong: 0, lang: language };
      prev.correct += s.correct;
      prev.wrong += s.wrong;
      map.set(key, prev);
    }
    return Array.from(map.entries())
      .map(([key, v]) => {
        const total = v.correct + v.wrong;
        const langMeta = languages.find(l => l.slug === v.lang);
        const catMeta = langMeta?.categories.find(c => c.slug === key.split('/')[1]);
        return {
          name: catMeta?.name ?? key.split('/')[1],
          language: langMeta?.name ?? v.lang,
          errorRate: Math.round((v.wrong / total) * 100),
          correct: v.correct,
          wrong: v.wrong,
          total,
        };
      })
      .filter(v => v.total >= 5) // minimum 5 answers to be meaningful
      .sort((a, b) => b.errorRate - a.errorRate)
      .slice(0, 10);
  }, [data.stats]);

  if (weak.length === 0) return null;

  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6 mb-8">
      <h2 className="text-xl font-bold mb-1">Weakest Categories</h2>
      <p className="text-gray-400 text-sm mb-4">Sorted by error rate (min 5 answers)</p>
      <ResponsiveContainer width="100%" height={Math.max(300, weak.length * 40)}>
        <BarChart data={weak} layout="vertical" margin={{ left: 20 }}>
          <XAxis type="number" domain={[0, 100]} tickFormatter={(v) => `${v}%`} stroke="#6b7280" />
          <YAxis type="category" dataKey="name" stroke="#6b7280" width={160} tick={{ fontSize: 12 }} />
          <Tooltip
            contentStyle={{ backgroundColor: '#1f2937', border: '1px solid #374151', borderRadius: '8px' }}
            labelStyle={{ color: '#fff' }}
            formatter={(value: any) => [`${value}%`, 'Error rate']}
          />
          <Bar dataKey="errorRate" name="Error Rate" fill="#ef4444" radius={[0, 6, 6, 0]}>
            {weak.map((entry, i) => (
              <Cell key={i} fill={entry.errorRate > 50 ? '#ef4444' : entry.errorRate > 30 ? '#f59e0b' : '#10b981'} />
            ))}
          </Bar>
        </BarChart>
      </ResponsiveContainer>
    </div>
  );
}

function CorrectVsWrongPie({ data }: { data: DashboardData }) {
  const totalCorrect = data.stats.reduce((s, q) => s + q.correct, 0);
  const totalWrong = data.stats.reduce((s, q) => s + q.wrong, 0);

  if (totalCorrect + totalWrong === 0) return null;

  const pieData = [
    { name: 'Correct', value: totalCorrect },
    { name: 'Wrong', value: totalWrong },
  ];

  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6">
      <h2 className="text-xl font-bold mb-4">Overall Distribution</h2>
      <ResponsiveContainer width="100%" height={250}>
        <PieChart>
          <Pie data={pieData} cx="50%" cy="50%" innerRadius={60} outerRadius={90} paddingAngle={3} dataKey="value">
            <Cell fill="#10b981" />
            <Cell fill="#ef4444" />
          </Pie>
          <Tooltip
            contentStyle={{ backgroundColor: '#1f2937', border: '1px solid #374151', borderRadius: '8px' }}
            formatter={(value: any) => [value.toLocaleString(), '']}
          />
          <Legend />
        </PieChart>
      </ResponsiveContainer>
    </div>
  );
}

function SessionHistory({ data }: { data: DashboardData }) {
  const chartData = useMemo(() => {
    // Group sessions by date
    const map = new Map<string, { date: string; correct: number; wrong: number; sessions: number }>();
    for (const s of data.sessions) {
      const date = new Date(s.completedAt).toLocaleDateString('en-US', { month: 'short', day: 'numeric' });
      const prev = map.get(date) ?? { date, correct: 0, wrong: 0, sessions: 0 };
      prev.correct += s.correctAnswers;
      prev.wrong += s.wrongAnswers;
      prev.sessions++;
      map.set(date, prev);
    }
    return Array.from(map.values()).reverse();
  }, [data.sessions]);

  if (chartData.length === 0) return null;

  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6">
      <h2 className="text-xl font-bold mb-4">Activity Over Time</h2>
      <ResponsiveContainer width="100%" height={250}>
        <AreaChart data={chartData}>
          <CartesianGrid strokeDasharray="3 3" stroke="#374151" />
          <XAxis dataKey="date" stroke="#6b7280" tick={{ fontSize: 11 }} />
          <YAxis stroke="#6b7280" />
          <Tooltip
            contentStyle={{ backgroundColor: '#1f2937', border: '1px solid #374151', borderRadius: '8px' }}
            labelStyle={{ color: '#fff' }}
          />
          <Area type="monotone" dataKey="correct" name="Correct" stroke="#10b981" fill="#10b98133" stackId="1" />
          <Area type="monotone" dataKey="wrong" name="Wrong" stroke="#ef4444" fill="#ef444433" stackId="1" />
        </AreaChart>
      </ResponsiveContainer>
    </div>
  );
}

function LanguageRadar({ data }: { data: DashboardData }) {
  const radarData = useMemo(() => {
    const map = new Map<string, { correct: number; total: number }>();
    for (const s of data.stats) {
      const { language } = parseCategory(s.questionId);
      const prev = map.get(language) ?? { correct: 0, total: 0 };
      prev.correct += s.correct;
      prev.total += s.correct + s.wrong;
      map.set(language, prev);
    }
    return Array.from(map.entries())
      .map(([lang, v]) => ({
        subject: languages.find(l => l.slug === lang)?.name ?? lang,
        accuracy: v.total > 0 ? Math.round((v.correct / v.total) * 100) : 0,
        volume: v.total,
      }))
      .filter(d => d.volume > 0);
  }, [data.stats]);

  if (radarData.length < 3) return null;

  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6">
      <h2 className="text-xl font-bold mb-4">Skills Radar</h2>
      <ResponsiveContainer width="100%" height={300}>
        <RadarChart data={radarData}>
          <PolarGrid stroke="#374151" />
          <PolarAngleAxis dataKey="subject" stroke="#9ca3af" tick={{ fontSize: 12 }} />
          <PolarRadiusAxis domain={[0, 100]} tick={{ fontSize: 10 }} stroke="#6b7280" />
          <Radar name="Accuracy" dataKey="accuracy" stroke="#3b82f6" fill="#3b82f680" />
        </RadarChart>
      </ResponsiveContainer>
    </div>
  );
}

function RecentSessions({ sessions }: { sessions: DbQuizSession[] }) {
  if (sessions.length === 0) return null;

  return (
    <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6 mb-8">
      <h2 className="text-xl font-bold mb-4">Recent Sessions</h2>
      <div className="space-y-2 max-h-96 overflow-y-auto">
        {sessions.slice(0, 20).map((s) => {
          const accuracy = Math.round((s.correctAnswers / s.totalQuestions) * 100);
          const langMeta = languages.find(l => l.slug === s.language);
          return (
            <div key={s.id} className="flex items-center justify-between py-2 border-b border-gray-700/50 last:border-0">
              <div className="flex items-center gap-3">
                <span className="text-lg">{langMeta?.icon ?? '📝'}</span>
                <div>
                  <span className="text-white text-sm font-medium">{s.category}</span>
                  {s.level && <span className="text-gray-500 text-xs ml-2">{s.level}</span>}
                </div>
              </div>
              <div className="flex items-center gap-4">
                <span className={`text-sm font-mono ${accuracy >= 70 ? 'text-green-400' : accuracy >= 50 ? 'text-yellow-400' : 'text-red-400'}`}>
                  {accuracy}%
                </span>
                <span className="text-gray-500 text-xs">
                  {s.correctAnswers}/{s.totalQuestions}
                </span>
                <span className="text-gray-600 text-xs">
                  {new Date(s.completedAt).toLocaleDateString()}
                </span>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default function DashboardPage() {
  const { data: session, status } = useSession();
  const [data, setData] = useState<DashboardData | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (status === 'authenticated') {
      fetchStats().then((d) => {
        setData(d);
        setLoading(false);
      });
    } else if (status === 'unauthenticated') {
      setLoading(false);
    }
  }, [status]);

  if (status === 'loading' || loading) {
    return <div className="text-center text-gray-400 mt-20">Loading dashboard...</div>;
  }

  if (!session) {
    return (
      <div className="text-center mt-20">
        <h1 className="text-3xl font-bold mb-4">Dashboard</h1>
        <p className="text-gray-400 mb-6">Sign in with Google to track your progress and see detailed statistics.</p>
        <Link href="/api/auth/signin" className="bg-blue-600 hover:bg-blue-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors">
          Sign in to continue
        </Link>
      </div>
    );
  }

  if (!data || (data.stats.length === 0 && data.sessions.length === 0)) {
    return (
      <div className="text-center mt-20">
        <h1 className="text-3xl font-bold mb-4">Dashboard</h1>
        <p className="text-gray-400 mb-2">No stats yet!</p>
        <p className="text-gray-500 text-sm mb-6">Start answering quiz questions — your stats will appear here.</p>
        <Link href="/" className="bg-blue-600 hover:bg-blue-700 text-white font-semibold px-6 py-3 rounded-lg transition-colors">
          Start a Quiz
        </Link>
      </div>
    );
  }

  return (
    <div>
      <div className="mb-8">
        <h1 className="text-3xl font-bold mb-1">Dashboard</h1>
        <p className="text-gray-400">Your quiz performance overview</p>
      </div>

      <OverviewCards data={data} />
      <AccuracyByLanguage data={data} />
      <WeakCategories data={data} />

      <div className="grid lg:grid-cols-2 gap-8 mb-8">
        <SessionHistory data={data} />
        <CorrectVsWrongPie data={data} />
      </div>

      <div className="grid lg:grid-cols-2 gap-8 mb-8">
        <LanguageRadar data={data} />
        <div className="bg-gray-800/50 border border-gray-700 rounded-xl p-6">
          <h2 className="text-xl font-bold mb-4">Quick Actions</h2>
          <div className="space-y-3">
            {languages.filter(l => l.slug !== 'german').map((lang) => (
              <Link key={lang.slug} href={`/${lang.slug}/smart`} className="flex items-center gap-3 p-3 bg-gray-700/30 hover:bg-gray-700/50 rounded-lg transition-colors">
                <span className="text-2xl">{lang.icon}</span>
                <div>
                  <span className="text-white text-sm font-medium">Smart Practice — {lang.name}</span>
                  <p className="text-gray-500 text-xs">Focus on your weak areas</p>
                </div>
              </Link>
            ))}
          </div>
        </div>
      </div>

      <RecentSessions sessions={data.sessions} />
    </div>
  );
}
