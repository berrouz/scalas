package org.shev4ik.interview.scala_core.level3_advanced

object Core101_TaglessFinal {

  // Exercise 1: Tagless final DSL - define an algebra
  // TODO: Define a Console algebra trait parameterized by F[_]
  trait Console[F[_]] {
    def putLine(s: String): F[Unit]
    def getLine: F[String]
  }

  // Exercise 2: Algebra trait - KV store
  // TODO: Define a key-value store algebra
  trait KVStore[F[_]] {
    def get(key: String): F[Option[String]]
    def put(key: String, value: String): F[Unit]
    def delete(key: String): F[Unit]
  }

  // Exercise 3: Interpreter using Id monad
  // TODO: Create a simple Id type and implement Console for Id
  type Id[A] = A

  // We need a simple Monad for Id
  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  implicit val idMonad: Monad[Id] = new Monad[Id] {
    def pure[A](a: A): Id[A] = a
    def flatMap[A, B](fa: Id[A])(f: A => Id[B]): Id[B] = f(fa)
  }

  // TODO: Implement KVStore for Id (using a mutable map)
  def kvStoreId: KVStore[Id] = ???

  // Exercise 4: Test interpreter
  // TODO: Create a test/mock interpreter that logs operations
  case class TestState(log: List[String], store: Map[String, String])

  type State[A] = TestState => (TestState, A)

  implicit val stateMonad: Monad[State] = new Monad[State] {
    def pure[A](a: A): State[A] = s => (s, a)
    def flatMap[A, B](fa: State[A])(f: A => State[B]): State[B] = s => {
      val (s1, a) = fa(s)
      f(a)(s1)
    }
  }

  // TODO: Implement KVStore for State (test interpreter)
  val kvStoreState: KVStore[State] = ???

  // Exercise 5: Multiple interpreters
  // TODO: Write a program using the KVStore algebra that works with any interpreter
  def program[F[_]](implicit kv: KVStore[F], M: Monad[F]): F[Option[String]] = ???
  // The program should: put("name", "Alice"), get("name")

  // Exercise 6: Composing algebras
  // TODO: Define a program that uses multiple algebras
  trait Logger[F[_]] {
    def info(msg: String): F[Unit]
    def error(msg: String): F[Unit]
  }

  // TODO: Implement Logger for Id
  val loggerIdImpl: Logger[Id] = ???

  // TODO: Write a program that uses both KVStore and Logger
  def programWithLogging[F[_]](key: String, value: String)(
    implicit kv: KVStore[F], log: Logger[F], M: Monad[F]
  ): F[Unit] = ???

  // Exercise 7: Natural transformation
  // TODO: Define a natural transformation type and create one from Id to Option
  trait NatTrans[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  val idToOption: NatTrans[Id, Option] = ???

  // Exercise 8: Higher-order tagless
  // TODO: Define a higher-order algebra that takes programs as parameters
  trait Retry[F[_]] {
    def retry[A](times: Int)(fa: F[A])(implicit M: Monad[F]): F[A]
  }

  // TODO: Implement Retry for Id (just runs once since Id can't fail)
  val retryId: Retry[Id] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 3
    val kv = kvStoreId
    kv.put("key1", "value1")
    assert(kv.get("key1") == Some("value1"))
    kv.delete("key1")
    assert(kv.get("key1") == None)

    // Exercise 4
    val initialState = TestState(Nil, Map.empty)
    val putOp: State[Unit] = kvStoreState.put("name", "Bob")
    val (state1, _) = putOp(initialState)
    assert(state1.store("name") == "Bob")
    assert(state1.log.nonEmpty)

    // Exercise 5
    implicit val kvId: KVStore[Id] = kvStoreId
    val result: Option[String] = program[Id]
    assert(result == Some("Alice"))

    // Exercise 6
    implicit val logId: Logger[Id] = loggerIdImpl
    programWithLogging[Id]("test", "value")
    assert(kvId.get("test") == Some("value"))

    // Exercise 7
    assert(idToOption(42) == Some(42))
    assert(idToOption("hello") == Some("hello"))

    // Exercise 8
    val retried: Int = retryId.retry(3)(42: Id[Int])
    assert(retried == 42)

    println("All Core101_TaglessFinal exercises passed!")
  }
}
