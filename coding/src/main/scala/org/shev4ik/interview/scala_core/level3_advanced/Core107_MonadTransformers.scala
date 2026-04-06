package org.shev4ik.interview.scala_core.level3_advanced

object Core107_MonadTransformers {

  // Simple Monad trait
  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  implicit val optionMonad: Monad[Option] = new Monad[Option] {
    def pure[A](a: A): Option[A] = Some(a)
    def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
  }

  type Id[A] = A
  implicit val idMonad: Monad[Id] = new Monad[Id] {
    def pure[A](a: A): Id[A] = a
    def flatMap[A, B](fa: Id[A])(f: A => Id[B]): Id[B] = f(fa)
  }

  // Exercise 1: OptionT by hand
  // TODO: Implement OptionT monad transformer - wraps F[Option[A]]
  case class OptionT[F[_], A](value: F[Option[A]])(implicit M: Monad[F]) {
    def map[B](f: A => B): OptionT[F, B] = ???
    def flatMap[B](f: A => OptionT[F, B]): OptionT[F, B] = ???
    def getOrElse(default: => A): F[A] = ???
  }

  object OptionT {
    def pure[F[_], A](a: A)(implicit M: Monad[F]): OptionT[F, A] = ???
    def none[F[_], A](implicit M: Monad[F]): OptionT[F, A] = ???
    def fromOption[F[_], A](opt: Option[A])(implicit M: Monad[F]): OptionT[F, A] = ???
  }

  // Exercise 2: EitherT by hand
  // TODO: Implement EitherT monad transformer - wraps F[Either[E, A]]
  case class EitherT[F[_], E, A](value: F[Either[E, A]])(implicit M: Monad[F]) {
    def map[B](f: A => B): EitherT[F, E, B] = ???
    def flatMap[B](f: A => EitherT[F, E, B]): EitherT[F, E, B] = ???
    def fold[B](fe: E => B, fa: A => B): F[B] = ???
  }

  object EitherT {
    def right[F[_], E, A](a: A)(implicit M: Monad[F]): EitherT[F, E, A] = ???
    def left[F[_], E, A](e: E)(implicit M: Monad[F]): EitherT[F, E, A] = ???
  }

  // Exercise 3: ReaderT by hand
  // TODO: Implement ReaderT (also known as Kleisli) - wraps R => F[A]
  case class ReaderT[F[_], R, A](run: R => F[A])(implicit M: Monad[F]) {
    def map[B](f: A => B): ReaderT[F, R, B] = ???
    def flatMap[B](f: A => ReaderT[F, R, B]): ReaderT[F, R, B] = ???
  }

  object ReaderT {
    def pure[F[_], R, A](a: A)(implicit M: Monad[F]): ReaderT[F, R, A] = ???
    def ask[F[_], R](implicit M: Monad[F]): ReaderT[F, R, R] = ???
  }

  // Exercise 4: StateT by hand
  // TODO: Implement StateT monad transformer - wraps S => F[(S, A)]
  case class StateT[F[_], S, A](run: S => F[(S, A)])(implicit M: Monad[F]) {
    def map[B](f: A => B): StateT[F, S, B] = ???
    def flatMap[B](f: A => StateT[F, S, B]): StateT[F, S, B] = ???
  }

  object StateT {
    def pure[F[_], S, A](a: A)(implicit M: Monad[F]): StateT[F, S, A] = ???
    def get[F[_], S](implicit M: Monad[F]): StateT[F, S, S] = ???
    def set[F[_], S](s: S)(implicit M: Monad[F]): StateT[F, S, Unit] = ???
    def modify[F[_], S](f: S => S)(implicit M: Monad[F]): StateT[F, S, Unit] = ???
  }

  // Exercise 5: Transformer stacking
  // TODO: Show how to stack OptionT on top of Either (OptionT[Either[String, *], A])
  type EitherStr[A] = Either[String, A]

  implicit val eitherStrMonad: Monad[EitherStr] = new Monad[EitherStr] {
    def pure[A](a: A): EitherStr[A] = Right(a)
    def flatMap[A, B](fa: EitherStr[A])(f: A => EitherStr[B]): EitherStr[B] = fa.flatMap(f)
  }

  def stackedProgram: OptionT[EitherStr, Int] = ???

  // Exercise 6: Lift operations
  // TODO: Implement lift to bring a value from the outer monad into the transformer
  def liftOption[F[_]: Monad, A](fa: F[A]): OptionT[F, A] = ???
  def liftEither[F[_]: Monad, E, A](fa: F[A]): EitherT[F, E, A] = ???

  // Exercise 7: Transformer composition
  // TODO: Write a practical program using OptionT to avoid nested Option handling
  case class AppUser(name: String, email: Option[String])
  case class AppConfig(admin: Option[AppUser])

  // TODO: Get admin email using OptionT (avoid nested flatMap/map on Option)
  def getAdminEmail(config: AppConfig): Option[String] = ???

  // Exercise 8: Transformer limitations
  // TODO: Show the "n^2 problem" - each transformer needs a Monad instance for F
  //       Write a note and simple example showing stacking limitations
  def transformerLimitation(): String = {
    // The problem: stacking n transformers requires n lift operations
    // and n unwrap operations. The performance overhead grows with stack depth.
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val opt1 = OptionT.pure[Id, Int](42)
    assert(opt1.value == Some(42))
    val opt2 = opt1.map(_ + 1)
    assert(opt2.value == Some(43))
    val opt3 = opt1.flatMap(x => OptionT.pure[Id, Int](x * 2))
    assert(opt3.value == Some(84))
    val optNone = OptionT.none[Id, Int]
    assert(optNone.getOrElse(0) == 0)

    // Exercise 2
    val eit1 = EitherT.right[Id, String, Int](42)
    assert(eit1.value == Right(42))
    val eit2 = eit1.map(_ + 1)
    assert(eit2.value == Right(43))
    val eit3 = EitherT.left[Id, String, Int]("error")
    assert(eit3.value == Left("error"))

    // Exercise 3
    val reader = ReaderT.ask[Id, String]
    assert(reader.run("hello") == "hello")
    val mapped = reader.map(_.length)
    assert(mapped.run("hello") == 5)

    // Exercise 4
    val state = StateT.get[Id, Int]
    assert(state.run(42) == (42, 42))
    val modified = StateT.modify[Id, Int](_ + 1)
    assert(modified.run(42) == (43, ()))

    // Exercise 5
    val stacked = stackedProgram
    assert(stacked.value == Right(Some(42)) || stacked.value.isRight)

    // Exercise 6
    val lifted = liftOption[Id, Int](42)
    assert(lifted.value == Some(42))

    // Exercise 7
    val config1 = AppConfig(Some(AppUser("admin", Some("admin@test.com"))))
    assert(getAdminEmail(config1) == Some("admin@test.com"))
    val config2 = AppConfig(Some(AppUser("admin", None)))
    assert(getAdminEmail(config2) == None)
    val config3 = AppConfig(None)
    assert(getAdminEmail(config3) == None)

    // Exercise 8
    val limitation = transformerLimitation()
    assert(limitation.nonEmpty)

    println("All Core107_MonadTransformers exercises passed!")
  }
}
