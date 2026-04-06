export const dynamic = 'force-dynamic';

import type { Metadata } from 'next';
import './globals.css';
import Navbar from '@/components/Navbar';
import AuthProvider from '@/components/AuthProvider';

export const metadata: Metadata = {
  title: '10K Quiz — Java, Scala, Kotlin Interview Questions',
  description: '10,000 interview questions for Java, Scala, and Kotlin developers',
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en" className="dark">
      <body className="min-h-screen">
        <AuthProvider>
          <Navbar />
          <main className="max-w-6xl mx-auto px-4 py-8">
            {children}
          </main>
        </AuthProvider>
      </body>
    </html>
  );
}
