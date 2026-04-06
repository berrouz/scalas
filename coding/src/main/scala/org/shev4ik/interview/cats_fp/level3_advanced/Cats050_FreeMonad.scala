package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.free.Free

/**
 * Cats 050 - Free Monad
 *
 * Free[F, A] is a monad constructed from any functor F. It separates
 * the description of a computation from its interpretation.
 * Free lets you build programs as data structures and interpret them later.
 */
object Cats050_FreeMonad {

  // A simple algebra (functor) for key-value store operations
  sealed trait KVStoreA[A]
  case class Put[T](key: String, value: T) extends KVStoreA[Unit]
  case class Get[T](key: String) extends KVStoreA[Option[T]]
  case class Delete(key: String) extends KVStoreA[Unit]

  type KVStore[A] = Free[KVStoreA, A]

  // Exercise 1: liftF - lift an algebra operation into Free
  // TODO: Use Free.liftF to lift a KVStoreA operation into Free.
  def exercise1_liftF(): KVStore[Unit] = {
    // Lift Put("key", "value") into Free
    ???
  }

  // Exercise 2: Pure - create a Free that immediately returns a value
  // TODO: Use Free.pure to create a program that returns immediately.
  def exercise2_pure(): KVStore[Int] = {
    // Create a Free program that returns 42 without any operations
    ???
  }

  // Exercise 3: Suspend (liftF) - suspend an operation in Free
  // TODO: Suspend various KVStore operations using liftF.
  def exercise3_suspend(): KVStore[Option[String]] = {
    // Lift a Get operation to retrieve key "name"
    ???
  }

  // Exercise 4: FlatMap - chain Free operations sequentially
  // TODO: Use flatMap to build a multi-step program.
  def exercise4_flatMap(): KVStore[Option[String]] = {
    def put(key: String, value: String): KVStore[Unit] =
      Free.liftF[KVStoreA, Unit](Put(key, value))
    def get(key: String): KVStore[Option[String]] =
      Free.liftF[KVStoreA, Option[String]](Get[String](key))

    // Chain: put "name" -> "Alice", then get "name"
    ???
  }

  // Exercise 5: Building a program - compose a multi-step Free program
  // TODO: Build a complete program using for-comprehension.
  def exercise5_program(): KVStore[Option[String]] = {
    def put(key: String, value: String): KVStore[Unit] =
      Free.liftF[KVStoreA, Unit](Put(key, value))
    def get(key: String): KVStore[Option[String]] =
      Free.liftF[KVStoreA, Option[String]](Get[String](key))
    def delete(key: String): KVStore[Unit] =
      Free.liftF[KVStoreA, Unit](Delete(key))

    // Program: put "name" -> "Alice", put "age" -> "30", delete "age", get "name"
    ???
  }

  // Exercise 6: foldMap - interpret a Free program using a natural transformation
  // TODO: Create a natural transformation and use foldMap to run the program.
  def exercise6_foldMap(): Option[String] = {
    def put(key: String, value: String): KVStore[Unit] =
      Free.liftF[KVStoreA, Unit](Put(key, value))
    def get(key: String): KVStore[Option[String]] =
      Free.liftF[KVStoreA, Option[String]](Get[String](key))

    // Build program
    val program: KVStore[Option[String]] = for {
      _ <- put("name", "Alice")
      result <- get("name")
    } yield result

    // Create an interpreter (natural transformation) to Id using a mutable map
    val interpreter: KVStoreA ~> Id = ???

    // Run the program with foldMap
    program.foldMap(interpreter)
  }

  // Exercise 7: Interpreter - create a different interpreter (e.g., to Option)
  // TODO: Create an interpreter that maps KVStore operations to Option.
  def exercise7_interpreter(): (KVStoreA ~> Option) = {
    // Create a FunctionK that interprets KVStoreA to Option
    // Use a mutable map internally for state
    ???
  }

  // Exercise 8: Natural transformation interpreter - compose interpreters
  // TODO: Create an interpreter and run a complete program.
  def exercise8_fullInterpretation(): (Option[String], Option[String]) = {
    def put(key: String, value: String): KVStore[Unit] =
      Free.liftF[KVStoreA, Unit](Put(key, value))
    def get(key: String): KVStore[Option[String]] =
      Free.liftF[KVStoreA, Option[String]](Get[String](key))
    def delete(key: String): KVStore[Unit] =
      Free.liftF[KVStoreA, Unit](Delete(key))

    val program: KVStore[(Option[String], Option[String])] = for {
      _ <- put("a", "hello")
      _ <- put("b", "world")
      _ <- delete("b")
      a <- get("a")
      b <- get("b")
    } yield (a, b)

    // Create interpreter and run
    val interpreter: KVStoreA ~> Id = new (KVStoreA ~> Id) {
      val store = scala.collection.mutable.Map.empty[String, Any]
      def apply[A](fa: KVStoreA[A]): Id[A] = fa match {
        case Put(k, v) => store(k) = v; ()
        case Get(k) => store.get(k).map(_.asInstanceOf[A]).asInstanceOf[A]
        case Delete(k) => store.remove(k); ()
      }
    }

    // Run and return the result
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_liftF()
    println(s"Exercise 1 passed: liftF created a Free program")

    // Exercise 2
    val idInterp: KVStoreA ~> Id = new (KVStoreA ~> Id) {
      val store = scala.collection.mutable.Map.empty[String, Any]
      def apply[A](fa: KVStoreA[A]): Id[A] = fa match {
        case Put(k, v) => store(k) = v; ()
        case Get(k) => store.get(k).asInstanceOf[A]
        case Delete(k) => store.remove(k); ()
      }
    }

    val r2 = exercise2_pure().foldMap(idInterp)
    assert(r2 == 42, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: Pure => $r2")

    // Exercise 3
    val r3 = exercise3_suspend()
    println(s"Exercise 3 passed: Suspend created")

    // Exercise 4
    val r4interp: KVStoreA ~> Id = new (KVStoreA ~> Id) {
      val store = scala.collection.mutable.Map.empty[String, Any]
      def apply[A](fa: KVStoreA[A]): Id[A] = fa match {
        case Put(k, v) => store(k) = v; ()
        case Get(k) => store.get(k).asInstanceOf[A]
        case Delete(k) => store.remove(k); ()
      }
    }
    val r4 = exercise4_flatMap().foldMap(r4interp)
    assert(r4 == Some("Alice"), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: flatMap => $r4")

    // Exercise 5
    val r5interp: KVStoreA ~> Id = new (KVStoreA ~> Id) {
      val store = scala.collection.mutable.Map.empty[String, Any]
      def apply[A](fa: KVStoreA[A]): Id[A] = fa match {
        case Put(k, v) => store(k) = v; ()
        case Get(k) => store.get(k).asInstanceOf[A]
        case Delete(k) => store.remove(k); ()
      }
    }
    val r5 = exercise5_program().foldMap(r5interp)
    assert(r5 == Some("Alice"), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: program => $r5")

    // Exercise 6
    val r6 = exercise6_foldMap()
    assert(r6 == Some("Alice"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: foldMap => $r6")

    // Exercise 7
    val r7 = exercise7_interpreter()
    println(s"Exercise 7 passed: interpreter created")

    // Exercise 8
    val (r8a, r8b) = exercise8_fullInterpretation()
    assert(r8a == Some("hello") && r8b == None, s"Exercise 8 failed: a=$r8a, b=$r8b")
    println(s"Exercise 8 passed: full interpretation => a=$r8a, b=$r8b")

    println("\nAll Cats050_FreeMonad exercises passed!")
  }
}
