import { Adapter, AdapterUser, AdapterAccount, AdapterSession, VerificationToken } from 'next-auth/adapters';
import { eq, and } from 'drizzle-orm';
import { users, accounts, sessions, verificationTokens } from '@/db/schema';
import type { db as DB } from '@/db';

type DrizzleDB = typeof DB;

export function DrizzleAdapter(db: DrizzleDB): Adapter {
  return {
    async createUser(data: any) {
      const id = crypto.randomUUID();
      await db.insert(users).values({
        id,
        name: data.name,
        email: data.email,
        emailVerified: data.emailVerified,
        image: data.image,
      });
      return { ...data, id } as AdapterUser;
    },

    async getUser(id) {
      const row = await db.select().from(users).where(eq(users.id, id)).then(r => r[0]);
      return row ? (row as AdapterUser) : null;
    },

    async getUserByEmail(email) {
      const row = await db.select().from(users).where(eq(users.email, email)).then(r => r[0]);
      return row ? (row as AdapterUser) : null;
    },

    async getUserByAccount({ provider, providerAccountId }) {
      const result = await db
        .select({ user: users })
        .from(accounts)
        .innerJoin(users, eq(accounts.userId, users.id))
        .where(and(eq(accounts.provider, provider), eq(accounts.providerAccountId, providerAccountId)))
        .then(r => r[0]);
      return result ? (result.user as AdapterUser) : null;
    },

    async updateUser(data: any) {
      if (!data.id) throw new Error('User id is required');
      await db.update(users).set({
        name: data.name,
        email: data.email,
        emailVerified: data.emailVerified,
        image: data.image,
      }).where(eq(users.id, data.id));
      const row = await db.select().from(users).where(eq(users.id, data.id)).then(r => r[0]);
      return row as AdapterUser;
    },

    async deleteUser(id) {
      await db.delete(users).where(eq(users.id, id));
    },

    async linkAccount(data: any) {
      await db.insert(accounts).values({
        id: crypto.randomUUID(),
        userId: data.userId,
        type: data.type,
        provider: data.provider,
        providerAccountId: data.providerAccountId,
        refresh_token: data.refresh_token,
        access_token: data.access_token,
        expires_at: data.expires_at,
        token_type: data.token_type,
        scope: data.scope,
        id_token: data.id_token,
        session_state: data.session_state as string | null,
      });
      return data as AdapterAccount;
    },

    async unlinkAccount({ provider, providerAccountId }: any) {
      await db.delete(accounts).where(
        and(eq(accounts.provider, provider), eq(accounts.providerAccountId, providerAccountId))
      );
    },

    async createSession(data) {
      await db.insert(sessions).values({
        sessionToken: data.sessionToken,
        userId: data.userId,
        expires: data.expires,
      });
      return data as AdapterSession;
    },

    async getSessionAndUser(sessionToken) {
      const result = await db
        .select({ session: sessions, user: users })
        .from(sessions)
        .innerJoin(users, eq(sessions.userId, users.id))
        .where(eq(sessions.sessionToken, sessionToken))
        .then(r => r[0]);
      if (!result) return null;
      return { session: result.session as AdapterSession, user: result.user as AdapterUser };
    },

    async updateSession(data) {
      await db.update(sessions).set(data).where(eq(sessions.sessionToken, data.sessionToken));
      const row = await db.select().from(sessions).where(eq(sessions.sessionToken, data.sessionToken)).then(r => r[0]);
      return row as AdapterSession;
    },

    async deleteSession(sessionToken) {
      await db.delete(sessions).where(eq(sessions.sessionToken, sessionToken));
    },

    async createVerificationToken(data) {
      await db.insert(verificationTokens).values(data);
      return data as VerificationToken;
    },

    async useVerificationToken({ identifier, token }) {
      const row = await db.select().from(verificationTokens)
        .where(and(eq(verificationTokens.identifier, identifier), eq(verificationTokens.token, token)))
        .then(r => r[0]);
      if (!row) return null;
      await db.delete(verificationTokens)
        .where(and(eq(verificationTokens.identifier, identifier), eq(verificationTokens.token, token)));
      return row as VerificationToken;
    },
  };
}
