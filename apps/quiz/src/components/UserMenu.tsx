'use client';

import { useSession, signIn, signOut } from 'next-auth/react';

export default function UserMenu() {
  const { data: session, status } = useSession();

  if (status === 'loading') {
    return <div className="w-8 h-8 rounded-full bg-gray-700 animate-pulse" />;
  }

  if (!session) {
    return (
      <button
        onClick={() => signIn('google')}
        className="text-sm bg-blue-600 hover:bg-blue-700 text-white px-3 py-1.5 rounded-lg transition-colors"
      >
        Sign in
      </button>
    );
  }

  return (
    <div className="flex items-center gap-2">
      {session.user?.image && (
        <img
          src={session.user.image}
          alt=""
          className="w-7 h-7 rounded-full"
          referrerPolicy="no-referrer"
        />
      )}
      <span className="text-sm text-gray-300 hidden sm:inline">
        {session.user?.name?.split(' ')[0]}
      </span>
      <button
        onClick={() => signOut()}
        className="text-xs text-gray-500 hover:text-gray-300 transition-colors"
      >
        Sign out
      </button>
    </div>
  );
}
