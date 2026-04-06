'use client';

import { useEffect } from 'react';
import { useRouter } from 'next/navigation';

export default function LanguageCustomRedirect({ params }: { params: { language: string } }) {
  const router = useRouter();

  useEffect(() => {
    router.replace('/custom');
  }, [router]);

  return <div className="text-center text-gray-400 mt-20">Redirecting to Custom Test...</div>;
}
