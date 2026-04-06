package org.shev4ik.interview.scala_core.level3_advanced

object Core105_Trampolining {

  // Exercise 1: Trampoline type
  // TODO: Define a Trampoline ADT with Done and More
  sealed trait Trampoline[+A] {
    def map[B](f: A => B): Trampoline[B]
    def flatMap[B](f: A => Trampoline[B]): Trampoline[B]
  }

  case class Done[A](value: A) extends Trampoline[A] {
    def map[B](f: A => B): Trampoline[B] = ???
    def flatMap[B](f: A => Trampoline[B]): Trampoline[B] = ???
  }

  case class More[A](thunk: () => Trampoline[A]) extends Trampoline[A] {
    def map[B](f: A => B): Trampoline[B] = ???
    def flatMap[B](f: A => Trampoline[B]): Trampoline[B] = ???
  }

  // Exercise 2: Trampoline run
  // TODO: Implement a stack-safe run method for Trampoline
  def run[A](trampoline: Trampoline[A]): A = ???

  // Exercise 3: Stack-safe factorial using trampoline
  // TODO: Implement factorial using Trampoline for stack safety
  def factorial(n: Long, acc: Long = 1L): Trampoline[Long] = ???

  // Exercise 4: Mutual recursion with trampoline
  // TODO: Implement mutually recursive even/odd using trampoline
  //       even(0) = true, even(n) = odd(n-1)
  //       odd(0) = false, odd(n) = even(n-1)
  def even(n: Long): Trampoline[Boolean] = ???
  def odd(n: Long): Trampoline[Boolean] = ???

  // Exercise 5: TailCalls object (stdlib)
  // TODO: Use scala.util.control.TailCalls for the same purpose
  import scala.util.control.TailCalls._

  def fibTailCalls(n: Int): TailRec[Long] = ???

  // Exercise 6: tailcall/done (stdlib)
  // TODO: Use tailcall and done from TailCalls to implement stack-safe sum
  def sumTailCalls(list: List[Int], acc: Int = 0): TailRec[Int] = ???

  // Exercise 7: Stack-safe recursion - tree traversal
  // TODO: Implement stack-safe tree depth calculation using trampoline
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  def depth[A](tree: Tree[A]): Trampoline[Int] = ???

  // Exercise 8: Trampoline monad
  // TODO: Show that Trampoline is a monad by implementing for-comprehension usage
  def trampolineProgram: Trampoline[String] = {
    // TODO: Chain several trampoline operations together
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 & 2
    assert(run(Done(42)) == 42)
    assert(run(More(() => Done(42))) == 42)
    assert(run(More(() => More(() => Done(42)))) == 42)

    // Exercise 3
    assert(run(factorial(5)) == 120L)
    assert(run(factorial(10)) == 3628800L)
    // This should not stack overflow
    assert(run(factorial(10000)) != 0)

    // Exercise 4
    assert(run(even(0)) == true)
    assert(run(odd(0)) == false)
    assert(run(even(4)) == true)
    assert(run(odd(3)) == true)
    assert(run(even(100001)) == false)

    // Exercise 5
    assert(fibTailCalls(0).result == 0L)
    assert(fibTailCalls(1).result == 1L)
    assert(fibTailCalls(10).result == 55L)

    // Exercise 6
    assert(sumTailCalls(List(1, 2, 3, 4, 5)).result == 15)
    assert(sumTailCalls((1 to 10000).toList).result == 50005000)

    // Exercise 7
    val tree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    assert(run(depth(tree)) == 2)
    assert(run(depth(Leaf(1))) == 0)

    // Exercise 8
    val result = run(trampolineProgram)
    assert(result.nonEmpty)

    println("All Core105_Trampolining exercises passed!")
  }
}
