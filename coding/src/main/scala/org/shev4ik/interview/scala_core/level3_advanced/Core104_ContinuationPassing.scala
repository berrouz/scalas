package org.shev4ik.interview.scala_core.level3_advanced

object Core104_ContinuationPassing {

  // Exercise 1: CPS basics
  // TODO: Convert a direct-style function to CPS (Continuation-Passing Style)
  //       Direct: def add(a: Int, b: Int): Int = a + b
  //       CPS: the result is passed to a continuation function instead of returned
  def addCPS[R](a: Int, b: Int)(k: Int => R): R = ???

  // Exercise 2: Continuation
  // TODO: Convert multiplication to CPS
  def mulCPS[R](a: Int, b: Int)(k: Int => R): R = ???

  // TODO: Chain CPS operations: compute (a + b) * c
  def addThenMulCPS[R](a: Int, b: Int, c: Int)(k: Int => R): R = ???

  // Exercise 3: CPS transform for fibonacci
  // TODO: Write fibonacci in CPS style
  def fibCPS[R](n: Int)(k: Int => R): R = ???

  // Exercise 4: CPS transform for factorial
  // TODO: Write factorial in CPS style
  def factCPS[R](n: Int)(k: Long => R): R = ???

  // Exercise 5: CPS for stack safety
  // TODO: Show how CPS can be used for stack safety with trampolining
  sealed trait Trampoline[A]
  case class Done[A](a: A) extends Trampoline[A]
  case class More[A](f: () => Trampoline[A]) extends Trampoline[A]

  def runTrampoline[A](t: Trampoline[A]): A = {
    var current = t
    while (true) {
      current match {
        case Done(a) => return a
        case More(f) => current = f()
      }
    }
    throw new RuntimeException("unreachable")
  }

  // TODO: Implement stack-safe factorial using Trampoline
  def factTrampoline(n: Int, acc: Long = 1): Trampoline[Long] = ???

  // Exercise 6: CPS vs direct style
  // TODO: Show both direct and CPS style for list sum
  def sumDirect(list: List[Int]): Int = ???

  def sumCPS[R](list: List[Int])(k: Int => R): R = ???

  // Exercise 7: CPS monad
  // TODO: Define a simple Cont monad
  case class Cont[R, A](run: (A => R) => R) {
    def map[B](f: A => B): Cont[R, B] = ???
    def flatMap[B](f: A => Cont[R, B]): Cont[R, B] = ???
  }

  object Cont {
    def pure[R, A](a: A): Cont[R, A] = ???
  }

  // Exercise 8: Delimited continuations concept
  // TODO: Simulate reset/shift pattern (delimited continuations)
  //       reset delimits the continuation, shift captures it
  def withContinuation[A](f: (A => A) => A): A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(addCPS(3, 4)(identity) == 7)
    assert(addCPS(3, 4)(_.toString) == "7")

    // Exercise 2
    assert(mulCPS(3, 4)(identity) == 12)
    assert(addThenMulCPS(2, 3, 4)(identity) == 20) // (2+3)*4

    // Exercise 3
    assert(fibCPS(0)(identity) == 0)
    assert(fibCPS(1)(identity) == 1)
    assert(fibCPS(10)(identity) == 55)

    // Exercise 4
    assert(factCPS(5)(identity) == 120L)
    assert(factCPS(0)(identity) == 1L)

    // Exercise 5
    assert(runTrampoline(factTrampoline(5)) == 120L)
    assert(runTrampoline(factTrampoline(10)) == 3628800L)

    // Exercise 6
    assert(sumDirect(List(1, 2, 3, 4)) == 10)
    assert(sumCPS(List(1, 2, 3, 4))(identity) == 10)

    // Exercise 7
    val result = Cont.pure[Int, Int](3)
      .flatMap(a => Cont.pure[Int, Int](a + 1))
      .flatMap(b => Cont.pure[Int, Int](b * 2))
      .run(identity)
    assert(result == 8) // (3+1)*2

    // Exercise 8
    val r = withContinuation[Int](k => k(k(1)))
    assert(r == 1) // identity applied twice

    println("All Core104_ContinuationPassing exercises passed!")
  }
}
