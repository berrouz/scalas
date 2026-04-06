package org.shev4ik.interview.scala_core.level2_intermediate

object Core033_Generics {

  // Exercise 1: Generic class
  // TODO: Create a generic class Box[A] that holds a single value of type A
  //       with a method `get: A` and `map[B](f: A => B): Box[B]`
  class Box[A] private(/* ??? */) {
    def get: A = ???
    def map[B](f: A => B): Box[B] = ???
  }
  object Box {
    def apply[A](value: A): Box[A] = ???
  }

  // Exercise 2: Generic method
  // TODO: Implement a generic method `firstAndLast` that takes a List[A]
  //       and returns an Option[(A, A)] with the first and last elements
  def firstAndLast[A](list: List[A]): Option[(A, A)] = ???

  // Exercise 3: Generic trait
  // TODO: Define a generic trait Printable[A] with a method `format(value: A): String`
  //       Then create instances for Int and String
  trait Printable[A] {
    def format(value: A): String = ???
  }
  object Printable {
    val intPrintable: Printable[Int] = ???
    val stringPrintable: Printable[String] = ???
  }

  // Exercise 4: Type parameter bounds
  // TODO: Implement `maxElement` that takes a List[A] where A <: Comparable[A]
  //       and returns the maximum element
  def maxElement[A <: Comparable[A]](list: List[A]): A = ???

  // Exercise 5: Multiple type parameters
  // TODO: Implement a generic method `transform` that takes a value of type A,
  //       a function A => B, and a function B => C, returning a C
  def transform[A, B, C](value: A, f: A => B, g: B => C): C = ???

  // Exercise 6: Generic container
  // TODO: Create a generic trait Container[A] with methods:
  //       add(elem: A): Container[A], getAll: List[A], size: Int
  //       Implement it as ListContainer[A]
  trait Container[A] {
    def add(elem: A): Container[A]
    def getAll: List[A]
    def size: Int
  }
  class ListContainer[A] private(/* ??? */) extends Container[A] {
    def add(elem: A): Container[A] = ???
    def getAll: List[A] = ???
    def size: Int = ???
  }
  object ListContainer {
    def empty[A]: ListContainer[A] = ???
  }

  // Exercise 7: Generic pair
  // TODO: Create a generic class Pair[A, B] with methods:
  //       swap: Pair[B, A], map[C, D](f: A => C, g: B => D): Pair[C, D]
  case class Pair[A, B](first: A, second: B) {
    def swap: Pair[B, A] = ???
    def map[C, D](f: A => C, g: B => D): Pair[C, D] = ???
  }

  // Exercise 8: Generic stack
  // TODO: Implement an immutable generic Stack[A] using a List internally
  //       with push(elem: A): Stack[A], pop: (A, Stack[A]), peek: A, isEmpty: Boolean
  class Stack[A] private(elements: List[A]) {
    def push(elem: A): Stack[A] = ???
    def pop: (A, Stack[A]) = ???
    def peek: A = ???
    def isEmpty: Boolean = ???
  }
  object Stack {
    def empty[A]: Stack[A] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val box = Box(42)
    assert(box.get == 42, "Box should hold value 42")
    assert(box.map(_ * 2).get == 84, "Box.map should transform the value")
    assert(Box("hello").map(_.length).get == 5, "Box.map should work with String to Int")

    // Exercise 2 assertions
    assert(firstAndLast(List(1, 2, 3, 4, 5)) == Some((1, 5)), "firstAndLast of non-empty list")
    assert(firstAndLast(List("a")) == Some(("a", "a")), "firstAndLast of single element")
    assert(firstAndLast(List.empty[Int]) == None, "firstAndLast of empty list")

    // Exercise 3 assertions
    assert(Printable.intPrintable.format(42) == "42", "Int printable should format 42")
    assert(Printable.stringPrintable.format("hello") == "hello", "String printable")

    // Exercise 4 assertions
    assert(maxElement(List("banana", "apple", "cherry")) == "cherry", "max of strings")

    // Exercise 5 assertions
    assert(transform(5, (x: Int) => x.toString, (s: String) => s.length) == 1, "transform chain")
    assert(transform("hello", (s: String) => s.length, (n: Int) => n * 2) == 10, "transform chain 2")

    // Exercise 6 assertions
    val container = ListContainer.empty[Int].add(1).add(2).add(3)
    assert(container.size == 3, "Container should have 3 elements")
    assert(container.getAll.toSet == Set(1, 2, 3), "Container should contain 1, 2, 3")

    // Exercise 7 assertions
    val pair = Pair(1, "hello")
    assert(pair.swap == Pair("hello", 1), "swap should reverse the pair")
    assert(pair.map(_ * 2, _.length) == Pair(2, 5), "map should transform both sides")

    // Exercise 8 assertions
    val stack = Stack.empty[Int].push(1).push(2).push(3)
    assert(stack.peek == 3, "peek should return top element")
    val (top, rest) = stack.pop
    assert(top == 3, "pop should return top element")
    assert(rest.peek == 2, "after pop, peek should return next element")
    assert(Stack.empty[Int].isEmpty, "empty stack should be empty")

    println("All Core033_Generics exercises passed!")
  }
}
