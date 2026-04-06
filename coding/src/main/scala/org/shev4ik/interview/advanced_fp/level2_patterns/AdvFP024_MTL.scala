package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP024 - MTL (Monad Transformer Library) Style
 *
 * MTL uses typeclass constraints (MonadReader, MonadState, MonadError, MonadWriter)
 * instead of concrete monad transformer stacks. This gives flexibility in
 * choosing the concrete monad later and avoids lift boilerplate.
 */
object AdvFP024_MTL {

  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // ============================================================
  // Exercise 1: Define MonadReader
  // MonadReader provides ask (get environment) and local (modify environment).
  // ============================================================
  // TODO: Define MonadReader
  trait MonadReader[F[_], R] extends Monad[F] {
    def ask: F[R]
    def local[A](f: R => R)(fa: F[A]): F[A]
  }

  // ============================================================
  // Exercise 2: Define MonadState
  // MonadState provides get, set, and modify for mutable state.
  // ============================================================
  // TODO: Define MonadState
  trait MonadState[F[_], S] extends Monad[F] {
    def get: F[S]
    def set(s: S): F[Unit]
    def modify(f: S => S): F[Unit]
  }

  // ============================================================
  // Exercise 3: Define MonadError
  // MonadError provides raiseError and handleError.
  // ============================================================
  // TODO: Define MonadError
  trait MonadError[F[_], E] extends Monad[F] {
    def raiseError[A](e: E): F[A]
    def handleError[A](fa: F[A])(f: E => F[A]): F[A]
  }

  // ============================================================
  // Exercise 4: Define MonadWriter
  // MonadWriter provides tell (append to log) and listen (get the log).
  // ============================================================
  trait Monoid[W] {
    def empty: W
    def combine(a: W, b: W): W
  }

  // TODO: Define MonadWriter
  trait MonadWriter[F[_], W] extends Monad[F] {
    def tell(w: W): F[Unit]
    def listen[A](fa: F[A]): F[(A, W)]
  }

  // ============================================================
  // Exercise 5: Write a program using MTL constraints
  // Use MonadReader for config, MonadState for counter, MonadError for failures.
  // The program reads a threshold from config, increments counter,
  // and raises error if counter exceeds threshold.
  // ============================================================
  case class Config(threshold: Int)

  // TODO: Write a program that increments and checks against threshold
  def incrementAndCheck[F[_]](
    implicit R: MonadReader[F, Config],
    S: MonadState[F, Int],
    E: MonadError[F, String]
  ): F[Int] = ???

  // ============================================================
  // Exercise 6: Implement a concrete monad that satisfies Reader + State + Error
  // Use a simple function type: Config => Either[String, (A, Int)]
  // ============================================================
  case class AppEffect[A](run: (Config, Int) => Either[String, (A, Int)])

  // TODO: Implement Monad[AppEffect]
  implicit val appEffectMonad: Monad[AppEffect] = ???

  // TODO: Implement MonadReader[AppEffect, Config]
  implicit val appEffectReader: MonadReader[AppEffect, Config] = ???

  // TODO: Implement MonadState[AppEffect, Int]
  implicit val appEffectState: MonadState[AppEffect, Int] = ???

  // TODO: Implement MonadError[AppEffect, String]
  implicit val appEffectError: MonadError[AppEffect, String] = ???

  // ============================================================
  // Exercise 7: Combine constraints using a single type parameter
  // Write a program that uses all four MTL typeclasses.
  // ============================================================
  // TODO: Write a program that logs, reads config, updates state, and can fail
  def fullProgram[F[_]](
    implicit R: MonadReader[F, Config],
    S: MonadState[F, Int],
    E: MonadError[F, String],
    W: MonadWriter[F, List[String]]
  ): F[String] = ???

  // ============================================================
  // Exercise 8: Show MTL vs Transformers
  // Implement a ReaderT transformer and show how MTL avoids
  // explicit lifting.
  // ============================================================
  case class ReaderT[F[_], R, A](run: R => F[A])

  // TODO: Implement Monad for ReaderT when F has a Monad
  def readerTMonad[F[_]: Monad, R]: Monad[({type L[A] = ReaderT[F, R, A]})#L] = ???

  // TODO: Show how to lift F[A] into ReaderT[F, R, A]
  def liftReaderT[F[_], R, A](fa: F[A]): ReaderT[F, R, A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 5-6: MTL program with concrete monad
    val config = Config(threshold = 5)

    // Run incrementAndCheck with state = 3 (should succeed, counter becomes 4)
    val result1 = incrementAndCheck[AppEffect](appEffectReader, appEffectState, appEffectError)
      .run(config, 3)
    assert(result1 == Right((4, 4)), s"Expected Right((4, 4)) but got $result1")
    println("Exercise 5-6 passed: incrementAndCheck succeeds below threshold")

    // Run with state = 5 (should fail, counter would exceed threshold)
    val result2 = incrementAndCheck[AppEffect](appEffectReader, appEffectState, appEffectError)
      .run(config, 5)
    assert(result2.isLeft, "Should fail when counter exceeds threshold")
    println("Exercise 5-6 passed: incrementAndCheck fails above threshold")

    // Exercise 7: Full program (compile check)
    println("Exercise 7 passed: Full program with all constraints defined")

    // Exercise 8: ReaderT
    type Id[A] = A
    implicit val idMonad: Monad[Id] = new Monad[Id] {
      def pure[A](a: A): A = a
      def flatMap[A, B](fa: A)(f: A => B): B = f(fa)
    }
    val rtMonad = readerTMonad[Id, String]
    val rt = ReaderT[Id, String, Int](s => s.length)
    assert(rt.run("hello") == 5)
    val lifted = liftReaderT[Id, String, Int](42)
    assert(lifted.run("ignored") == 42)
    println("Exercise 8 passed: ReaderT monad and lift")

    println("\nAll exercises passed!")
  }
}
