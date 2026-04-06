package org.shev4ik.interview.scala_core.level3_advanced

object Core088_TypeProjection {

  // Exercise 1: Type projection A#B
  // TODO: Define a trait Outer with an inner type member `Inner`
  //       Use type projection to reference Inner without a specific instance
  trait Outer {
    type Inner
    def createInner: Inner
  }

  // TODO: Write a method that takes any Outer and returns its Inner via type projection
  def getInner(outer: Outer): Outer#Inner = ???

  // Exercise 2: vs path-dependent types
  // TODO: Show the difference between path-dependent (o.Inner) and type projection (Outer#Inner)
  class Family {
    class Member(val name: String)
  }

  // TODO: Write a method using path-dependent type (specific family)
  def addMember(family: Family)(name: String): family.Member = ???

  // TODO: Write a method using type projection (any family)
  def describeMember(member: Family#Member): String = ???

  // Exercise 3: Type projection use cases
  // TODO: Define a module system where modules have types
  trait Module {
    type Config
    type Result
    def process(config: Config): Result
  }

  // TODO: Write a method that works with any Module's Config and Result via projection
  def runModule[M <: Module](module: M)(config: M#Config): M#Result = ???

  // Exercise 4: Inner type access
  // TODO: Define a container with an inner type and show how to access it
  trait TypedContainer {
    type Elem
    def elements: List[Elem]
    def add(e: Elem): TypedContainer
  }

  // TODO: Create a concrete container for String
  def stringContainer(items: String*): TypedContainer { type Elem = String } = ???

  // Exercise 5: Type projection with bounds
  // TODO: Define a trait with bounded type members and use projection
  trait Bounded {
    type Upper <: AnyRef
    type Lower <: Upper
    def value: Upper
  }

  // TODO: Create an instance where Upper = String, Lower = Null
  val boundedString: Bounded { type Upper = String } = ???

  // Exercise 6: Type member projection
  // TODO: Define a type class that uses type members and project them
  trait TypeInfo[T] {
    type Category
    def category: String
  }

  object TypeInfo {
    // TODO: Implement for Int (Category = "numeric")
    implicit val intInfo: TypeInfo[Int] { type Category = String } = ???

    // TODO: Implement for String (Category = "text")
    implicit val stringInfo: TypeInfo[String] { type Category = String } = ???
  }

  def getCategory[T](implicit info: TypeInfo[T]): String = ???

  // Exercise 7: Associated types
  // TODO: Define a trait with associated types (like Rust's associated types)
  trait Collection {
    type Element
    type Iterator
    def iterator: Iterator
    def toList: List[Element]
  }

  // TODO: Implement a concrete IntList collection
  class IntList(items: List[Int]) extends Collection {
    type Element = Int
    type Iterator = scala.collection.Iterator[Int]
    def iterator: scala.collection.Iterator[Int] = ???
    def toList: List[Int] = ???
  }

  // Exercise 8: Type projection alternatives
  // TODO: Show how to achieve similar results using type parameters instead of type projection
  //       Compare trait with type member vs trait with type parameter
  trait WithMember {
    type T
    def value: T
  }

  trait WithParam[T] {
    def value: T
  }

  // TODO: Create instances of both and a method that works with WithParam
  def extractValue[T](wp: WithParam[T]): T = ???

  // TODO: Create a method that works with WithMember using projection
  def extractMemberValue(wm: WithMember): WithMember#T = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val outer = new Outer {
      type Inner = String
      def createInner: String = "inner value"
    }
    assert(getInner(outer) == "inner value")

    // Exercise 2
    val family = new Family
    val member = addMember(family)("Alice")
    assert(describeMember(member) == "Member: Alice")

    // Exercise 3
    val intModule = new Module {
      type Config = Int
      type Result = String
      def process(config: Int): String = s"Processed: $config"
    }
    assert(runModule(intModule)(42) == "Processed: 42")

    // Exercise 4
    val sc = stringContainer("hello", "world")
    assert(sc.elements == List("hello", "world"))

    // Exercise 5
    assert(boundedString.value != null)

    // Exercise 6
    assert(getCategory[Int] == "numeric")
    assert(getCategory[String] == "text")

    // Exercise 7
    val intList = new IntList(List(1, 2, 3))
    assert(intList.toList == List(1, 2, 3))
    assert(intList.iterator.toList == List(1, 2, 3))

    // Exercise 8
    val wp = new WithParam[Int] { def value: Int = 42 }
    assert(extractValue(wp) == 42)

    val wm = new WithMember { type T = Int; def value: Int = 99 }
    assert(extractMemberValue(wm) == 99)

    println("All Core088_TypeProjection exercises passed!")
  }
}
