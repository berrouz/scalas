package org.shev4ik.interview.scala_core.level3_advanced

object Core102_FreeMonad {

  // Exercise 1: Free data type
  // TODO: Define the Free monad data type with Pure and FlatMap
  sealed trait Free[F[_], A] {
    def flatMap[B](f: A => Free[F, B]): Free[F, B] = FlatMapped(this, f)
    def map[B](f: A => B): Free[F, B] = flatMap(a => Pure(f(a)))
  }

  case class Pure[F[_], A](a: A) extends Free[F, A]
  case class Suspend[F[_], A](fa: F[A]) extends Free[F, A]
  case class FlatMapped[F[_], A, B](fa: Free[F, A], f: A => Free[F, B]) extends Free[F, B]

  // Exercise 2: liftF
  // TODO: Implement liftF that lifts F[A] into Free[F, A]
  def liftF[F[_], A](fa: F[A]): Free[F, A] = ???

  // Exercise 3: Define an algebra (KVStore operations)
  // TODO: Define ADT for KVStore operations
  sealed trait KVStoreOp[A]
  case class Get(key: String) extends KVStoreOp[Option[String]]
  case class Put(key: String, value: String) extends KVStoreOp[Unit]
  case class Delete(key: String) extends KVStoreOp[Unit]

  // TODO: Define smart constructors that lift into Free
  type KVStore[A] = Free[KVStoreOp, A]

  def get(key: String): KVStore[Option[String]] = ???
  def put(key: String, value: String): KVStore[Unit] = ???
  def delete(key: String): KVStore[Unit] = ???

  // Exercise 4: Write a Free program
  // TODO: Write a program using the smart constructors
  def updateProgram(key: String, f: String => String): KVStore[Option[String]] = ???
  // Should: get the key, if exists update with f, return the old value

  // Exercise 5: Natural transformation for interpreter
  // TODO: Define a natural transformation (interpreter)
  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // TODO: Create an interpreter from KVStoreOp to Id using a mutable map
  type Id[A] = A

  def idInterpreter: KVStoreOp ~> Id = ???

  // Exercise 6: foldMap - run the Free program
  // TODO: Implement foldMap that interprets a Free program using a natural transformation
  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  }

  implicit val idMonad: Monad[Id] = new Monad[Id] {
    def pure[A](a: A): Id[A] = a
    def flatMap[A, B](fa: Id[A])(f: A => Id[B]): Id[B] = f(fa)
  }

  def foldMap[F[_], G[_], A](free: Free[F, A])(nt: F ~> G)(implicit M: Monad[G]): G[A] = ???

  // Exercise 7: Composing Free programs
  // TODO: Write a more complex program composed from smaller ones
  def initializeStore: KVStore[Unit] = {
    // TODO: Put some initial values
    ???
  }

  def lookupAndDelete(key: String): KVStore[Option[String]] = {
    // TODO: Get a value, delete it, return the old value
    ???
  }

  def composedProgram: KVStore[Option[String]] = {
    // TODO: Initialize store, then lookup and delete "name"
    ???
  }

  // Exercise 8: Free vs tagless comparison
  // TODO: Show the same program in both Free and tagless final style
  //       Tagless version:
  trait KVStoreAlg[F[_]] {
    def get(key: String): F[Option[String]]
    def put(key: String, value: String): F[Unit]
  }

  // TODO: Write the same "update" program in tagless style
  def taglessUpdate[F[_]](key: String, f: String => String)(
    implicit kv: KVStoreAlg[F], M: Monad[F]
  ): F[Option[String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 2
    val lifted = liftF[KVStoreOp, Option[String]](Get("key"))
    assert(lifted.isInstanceOf[Suspend[KVStoreOp, _]])

    // Exercise 3
    val getOp = get("test")
    assert(getOp.isInstanceOf[Suspend[KVStoreOp, _]])

    // Exercise 4
    val prog = updateProgram("name", _.toUpperCase)
    assert(prog != null)

    // Exercise 5
    val interp = idInterpreter
    assert(interp(Put("a", "1")) == ())
    assert(interp(Get("a")) == Some("1"))
    assert(interp(Delete("a")) == ())
    assert(interp(Get("a")) == None)

    // Exercise 6
    val interp2 = idInterpreter
    val simpleProg: KVStore[Option[String]] = for {
      _ <- put("greeting", "hello")
      v <- get("greeting")
    } yield v
    val result = foldMap(simpleProg)(interp2)
    assert(result == Some("hello"))

    // Exercise 7
    val interp3 = idInterpreter
    val composed = foldMap(composedProgram)(interp3)
    assert(composed.isDefined)

    println("All Core102_FreeMonad exercises passed!")
  }
}
