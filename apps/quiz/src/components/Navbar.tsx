'use client';

import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { isMultiLevelLanguage, getMultiLevelLevels, getMultiLevelCategoryMeta } from '@/data/registry';
import UserMenu from './UserMenu';

function getMultiLevelBreadcrumbLabel(language: string, parts: string[], index: number): string | null {
  if (index === 0) return language === 'german' ? 'Deutsche Grammatik' : 'Business English';
  if (index === 1) {
    const levels = getMultiLevelLevels(language);
    const level = levels.find(l => l.slug === parts[1]);
    return level?.name ?? parts[1].toUpperCase();
  }
  if (index === 2) {
    const cat = getMultiLevelCategoryMeta(language, parts[2]);
    return cat?.name ?? parts[2];
  }
  if (index === 3) {
    return parts[3].replace('part', 'Part ');
  }
  return null;
}

export default function Navbar() {
  const pathname = usePathname();
  const parts = pathname.split('/').filter(Boolean);
  const isMultiLevel = parts.length > 0 && isMultiLevelLanguage(parts[0]);

  return (
    <nav className="bg-gray-900 border-b border-gray-800 sticky top-0 z-50">
      <div className="max-w-6xl mx-auto px-4 h-14 flex items-center justify-between">
        <Link href="/" className="text-xl font-bold text-white hover:text-blue-400 transition-colors">
          Quiz
        </Link>
        <div className="flex items-center gap-2 text-sm text-gray-400">
          <Link href="/dashboard" className="hover:text-white transition-colors">Dashboard</Link>
          <span className="text-gray-600">|</span>
          {parts.length > 0 && (
            <>
              <Link href="/" className="hover:text-white transition-colors">Home</Link>
              {parts.map((part, i) => {
                const label = isMultiLevel
                  ? getMultiLevelBreadcrumbLabel(parts[0], parts, i)
                  : decodeURIComponent(part);
                return (
                  <span key={i} className="flex items-center gap-2">
                    <span>/</span>
                    <Link
                      href={'/' + parts.slice(0, i + 1).join('/')}
                      className="hover:text-white transition-colors capitalize"
                    >
                      {label}
                    </Link>
                  </span>
                );
              })}
            </>
          )}
        </div>
        <UserMenu />
      </div>
    </nav>
  );
}
