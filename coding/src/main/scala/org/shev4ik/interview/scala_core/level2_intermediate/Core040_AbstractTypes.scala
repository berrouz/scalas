package org.shev4ik.interview.scala_core.level2_intermediate

object Core040_AbstractTypes {

  // Exercise 1: Abstract type member
  // TODO: Define a trait Buffer with an abstract type T and methods:
  //       `add(elem: T): Unit` and `getAll: List[T]`
  trait Buffer {
    type T
    def add(elem: T): Unit
    def getAll: List[T]
  }
  // TODO: Create a concrete IntBuffer where T = Int
  class IntBuffer extends Buffer {
    type T = Int // TODO: choose the appropriate type
    private val buf = scala.collection.mutable.ListBuffer.empty[T]
    def add(elem: T): Unit = ???
    def getAll: List[T] = ???
  }

  // Exercise 2: Type member vs type parameter
  // TODO: Create two equivalent abstractions:
  //       - trait ReaderParam[A] with method read: A (type parameter version)
  //       - trait ReaderMember with type A and method read: A (type member version)
  //       Implement both for Int
  trait ReaderParam[A] {
    def read: A
  }
  trait ReaderMember {
    type A
    def read: A
  }

  val paramReader: ReaderParam[Int] = ???
  val memberReader: ReaderMember { type A = Int } = ???

  // Exercise 3: Type refinement
  // TODO: Create a method that takes a Buffer where T is String
  //       and adds "hello" to it, returning the buffer
  def addHello(buf: Buffer { type T = String }): Buffer { type T = String } = ???

  // Exercise 4: Type member in trait
  // TODO: Define a trait Graph with abstract types Node and Edge
  //       Edge should have `from: Node` and `to: Node`
  //       Create a concrete StringGraph where Node = String
  trait Graph {
    type Node
    type Edge <: EdgeLike
    trait EdgeLike {
      def from: Node
      def to: Node
    }
  }
  class StringGraph extends Graph {
    type Node = String
    // TODO: Define Edge as a case class implementing EdgeLike
    case class Edge(from: String, to: String) extends EdgeLike
  }

  // Exercise 5: Path-dependent types intro
  // TODO: Create a class Outer with an inner class Inner(val x: Int)
  //       Demonstrate that outer1.Inner and outer2.Inner are different types
  //       Create a method that only accepts Inner from a specific Outer instance
  class Outer(val name: String) {
    class Inner(val x: Int)
    def createInner(x: Int): Inner = ???
    def acceptInner(inner: Inner): String = ???
  }

  // Exercise 6: Abstract type bounds
  // TODO: Define a trait Collection with abstract type Elem <: Comparable[Elem]
  //       Add a method `max: Option[Elem]`
  trait Collection {
    type Elem <: Comparable[Elem]
    def elements: List[Elem]
    def max: Option[Elem] = ???
  }

  class StringCollection(val elements: List[String]) extends Collection {
    type Elem = String
  }

  // Exercise 7: Type alias in trait
  // TODO: Define a trait DatabaseModule with type aliases:
  //       type Id = Long, type Row = Map[String, Any]
  //       Add methods: insert(row: Row): Id, get(id: Id): Option[Row]
  trait DatabaseModule {
    type Id = Long
    type Row = Map[String, Any]
    def insert(row: Row): Id
    def get(id: Id): Option[Row]
  }
  // TODO: Create a simple in-memory implementation
  class InMemoryDb extends DatabaseModule {
    private val store = scala.collection.mutable.Map.empty[Id, Row]
    private var nextId: Id = 1L
    def insert(row: Row): Id = ???
    def get(id: Id): Option[Row] = ???
  }

  // Exercise 8: Type projection #
  // TODO: Define a trait Container with inner type Item
  //       Use type projection Container#Item to refer to Item without a specific Container instance
  //       Create a method that works with any Container's Item
  trait ItemContainer {
    type Item
    def get: Item
  }
  class StringContainer(s: String) extends ItemContainer {
    type Item = String
    def get: String = ???
  }

  // TODO: Method using type projection - accepts any ItemContainer and returns its item as String
  def describeItem(container: ItemContainer): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val intBuf = new IntBuffer
    intBuf.add(1)
    intBuf.add(2)
    assert(intBuf.getAll == List(1, 2), "IntBuffer should store ints")

    // Exercise 2 assertions
    assert(paramReader.read == 42, "ReaderParam should read 42")
    assert(memberReader.read == 42, "ReaderMember should read 42")

    // Exercise 3 assertions
    class StringBuffer extends Buffer {
      type T = String
      private val buf = scala.collection.mutable.ListBuffer.empty[String]
      def add(elem: String): Unit = buf += elem
      def getAll: List[String] = buf.toList
    }
    val strBuf = new StringBuffer
    addHello(strBuf)
    assert(strBuf.getAll.contains("hello"), "addHello should add 'hello'")

    // Exercise 4 assertions
    val graph = new StringGraph
    val edge = graph.Edge("A", "B")
    assert(edge.from == "A" && edge.to == "B", "StringGraph edge")

    // Exercise 5 assertions
    val outer1 = new Outer("first")
    val inner1 = outer1.createInner(10)
    assert(outer1.acceptInner(inner1) == "first:10", "path-dependent type acceptance")

    // Exercise 6 assertions
    val sc = new StringCollection(List("banana", "apple", "cherry"))
    assert(sc.max == Some("cherry"), "max should return cherry")
    assert(new StringCollection(Nil).max == None, "max of empty should be None")

    // Exercise 7 assertions
    val db = new InMemoryDb
    val id1 = db.insert(Map("name" -> "Alice"))
    val id2 = db.insert(Map("name" -> "Bob"))
    assert(db.get(id1) == Some(Map("name" -> "Alice")), "get should return inserted row")
    assert(db.get(999) == None, "get of non-existent should be None")

    // Exercise 8 assertions
    val sc2 = new StringContainer("hello")
    assert(sc2.get == "hello", "StringContainer get")
    assert(describeItem(sc2).contains("hello"), "describeItem should include item")

    println("All Core040_AbstractTypes exercises passed!")
  }
}
