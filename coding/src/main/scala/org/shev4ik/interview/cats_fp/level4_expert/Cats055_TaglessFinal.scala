package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 055 - Tagless Final
 *
 * Tagless Final is a pattern where algebras are defined as traits parameterized
 * by an effect type F[_]. Programs are written against the abstract algebra,
 * and different interpreters provide different implementations.
 */
object Cats055_TaglessFinal {

  // Exercise 1: Tagless final algebra - define an algebra parameterized by F[_]
  // TODO: Define a key-value store algebra using tagless final style.
  trait KVStore[F[_]] {
    def put(key: String, value: String): F[Unit]
    def get(key: String): F[Option[String]]
    def delete(key: String): F[Unit]
  }

  // Implement the KVStore algebra for Id (simple in-memory implementation)
  def exercise1_algebra(): KVStore[Id] = {
    ???
  }

  // Exercise 2: F[_] constraint - write programs with Monad constraint
  // TODO: Write a program generic in F[_] with a Monad constraint.
  def exercise2_program[F[_]: Monad](store: KVStore[F]): F[Option[String]] = {
    // Put "name" -> "Alice", then get "name"
    ???
  }

  // Exercise 3: Interpreter in Id - create an Id interpreter for testing
  // TODO: Implement the algebra using Id for simple synchronous testing.
  def exercise3_idInterpreter(): KVStore[Id] = {
    val storage = scala.collection.mutable.Map.empty[String, String]
    ???
  }

  // Exercise 4: Interpreter in State - create a pure State interpreter
  // TODO: Implement using State monad for purely functional testing.
  type KVState[A] = State[Map[String, String], A]

  def exercise4_stateInterpreter(): KVStore[KVState] = {
    ???
  }

  // Exercise 5: Multiple interpreters - demonstrate swapping interpreters
  // TODO: Run the same program with different interpreters.
  def exercise5_multipleInterpreters(): (Option[String], Option[String]) = {
    // Run exercise2_program with Id interpreter
    val idResult: Option[String] = ???

    // Run exercise2_program with State interpreter
    val stateResult: Option[String] = ???

    (idResult, stateResult)
  }

  // Exercise 6: Composing algebras - combine multiple tagless algebras
  // TODO: Define a second algebra and compose programs using both.
  trait Logger[F[_]] {
    def info(msg: String): F[Unit]
    def error(msg: String): F[Unit]
  }

  def exercise6_composedProgram[F[_]: Monad](
    store: KVStore[F],
    logger: Logger[F]
  ): F[Option[String]] = {
    // Log "starting", put "key" -> "value", log "done", get "key"
    ???
  }

  // Exercise 7: Higher-order algebra - algebra with higher-kinded operations
  // TODO: Define an algebra with operations that take F[_] parameters.
  trait Transaction[F[_]] {
    def transact[A](fa: F[A]): F[A]  // run in transaction
    def rollback[A](fa: F[A]): F[A]  // rollback on error
  }

  def exercise7_higherOrder[F[_]: Monad](
    store: KVStore[F],
    tx: Transaction[F]
  ): F[Option[String]] = {
    // Run store operations inside a transaction
    ???
  }

  // Exercise 8: Middleware pattern - wrap an algebra with cross-cutting concerns
  // TODO: Create a middleware that adds logging around every store operation.
  def exercise8_middleware[F[_]: Monad](
    underlying: KVStore[F],
    logger: Logger[F]
  ): KVStore[F] = {
    // Wrap each KVStore operation with logging before and after
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_algebra()
    r1.put("test", "value")
    val r1v = r1.get("test")
    assert(r1v == Some("value"), s"Exercise 1 failed: $r1v")
    println(s"Exercise 1 passed: algebra => $r1v")

    // Exercise 2
    val idStore = exercise3_idInterpreter()
    val r2 = exercise2_program[Id](idStore)
    assert(r2 == Some("Alice"), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: program => $r2")

    // Exercise 3
    val r3 = exercise3_idInterpreter()
    r3.put("x", "y")
    assert(r3.get("x") == Some("y"), s"Exercise 3 failed")
    println(s"Exercise 3 passed: Id interpreter works")

    // Exercise 4
    val stateStore = exercise4_stateInterpreter()
    val stateProgram = exercise2_program[KVState](stateStore)
    val (r4state, r4result) = stateProgram.run(Map.empty).value
    assert(r4result == Some("Alice"), s"Exercise 4 failed: $r4result")
    assert(r4state.contains("name"), s"Exercise 4 state failed: $r4state")
    println(s"Exercise 4 passed: State interpreter => result=$r4result, state=$r4state")

    // Exercise 5
    val (r5a, r5b) = exercise5_multipleInterpreters()
    assert(r5a == Some("Alice"), s"Exercise 5 failed: id=$r5a")
    assert(r5b == Some("Alice"), s"Exercise 5 failed: state=$r5b")
    println(s"Exercise 5 passed: multiple interpreters => id=$r5a, state=$r5b")

    // Exercise 6
    val store6 = exercise3_idInterpreter()
    var logs6: List[String] = Nil
    val logger6: Logger[Id] = new Logger[Id] {
      def info(msg: String): Id[Unit] = { logs6 = logs6 :+ s"[INFO] $msg" }
      def error(msg: String): Id[Unit] = { logs6 = logs6 :+ s"[ERROR] $msg" }
    }
    val r6 = exercise6_composedProgram[Id](store6, logger6)
    assert(r6 == Some("value"), s"Exercise 6 failed: $r6")
    assert(logs6.nonEmpty, s"Exercise 6 failed: no logs")
    println(s"Exercise 6 passed: composed => $r6, logs=$logs6")

    // Exercise 7
    val store7 = exercise3_idInterpreter()
    val tx7: Transaction[Id] = new Transaction[Id] {
      def transact[A](fa: Id[A]): Id[A] = fa
      def rollback[A](fa: Id[A]): Id[A] = fa
    }
    val r7 = exercise7_higherOrder[Id](store7, tx7)
    println(s"Exercise 7 passed: higher-order => $r7")

    // Exercise 8
    val store8 = exercise3_idInterpreter()
    var logs8: List[String] = Nil
    val logger8: Logger[Id] = new Logger[Id] {
      def info(msg: String): Id[Unit] = { logs8 = logs8 :+ msg }
      def error(msg: String): Id[Unit] = { logs8 = logs8 :+ msg }
    }
    val middleware = exercise8_middleware[Id](store8, logger8)
    middleware.put("k", "v")
    val r8 = middleware.get("k")
    assert(r8 == Some("v"), s"Exercise 8 failed: $r8")
    assert(logs8.nonEmpty, s"Exercise 8 failed: no logs from middleware")
    println(s"Exercise 8 passed: middleware => $r8, logs=$logs8")

    println("\nAll Cats055_TaglessFinal exercises passed!")
  }
}
