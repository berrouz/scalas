package org.shev4ik.interview.scala_core.level3_advanced

object Core091_InvariantDesign {

  // Exercise 1: Invariant container design
  // TODO: Define an invariant container Holder[A] (no +/- variance annotation)
  //       with get and set methods
  class Holder[A](private var value: A) {
    def get: A = ???
    def set(a: A): Unit = ???
  }

  // Exercise 2: Type role - invariant for mutability
  // TODO: Show why mutable containers MUST be invariant.
  //       Define a MutableStack[A] that is invariant.
  class MutableStack[A] {
    private var items: List[A] = Nil
    def push(a: A): Unit = ???
    def pop(): Option[A] = ???
    def peek: Option[A] = ???
    def toList: List[A] = ???
  }

  // Exercise 3: Phantom role
  // TODO: Define an invariant phantom type for type-safe ID
  //       ID[A] is invariant - ID[Dog] is NOT a subtype of ID[Animal]
  case class Id[A](value: Long)

  trait Entity[A] {
    def id: Id[A]
  }

  case class User(id: Id[User], name: String) extends Entity[User]
  case class Product(id: Id[Product], title: String) extends Entity[Product]

  // TODO: Write a type-safe lookup method
  def lookup[A <: Entity[A]](id: Id[A], items: List[A]): Option[A] = ???

  // Exercise 4: Representational role
  // TODO: Create an invariant wrapper that prevents mixing types
  case class Meters(value: Double) extends AnyVal
  case class Seconds(value: Double) extends AnyVal

  // TODO: Write type-safe operations that won't mix Meters and Seconds
  def speed(distance: Meters, time: Seconds): Double = ???

  // Exercise 5: Invariant for safety
  // TODO: Show that invariance prevents unsound operations on mutable data.
  //       Implement a type-safe invariant collection.
  class InvariantBuffer[A] {
    private val buffer = scala.collection.mutable.ListBuffer.empty[A]
    def append(a: A): Unit = ???
    def getAll: List[A] = ???
    def map[B](f: A => B): InvariantBuffer[B] = ???
  }

  // Exercise 6: Invariant collections
  // TODO: Implement an invariant Set-like collection
  class InvSet[A] private (private val items: Set[A]) {
    def contains(a: A): Boolean = ???
    def add(a: A): InvSet[A] = ???
    def remove(a: A): InvSet[A] = ???
    def toSet: Set[A] = ???
  }

  object InvSet {
    def empty[A]: InvSet[A] = ???
    def apply[A](items: A*): InvSet[A] = ???
  }

  // Exercise 7: Invariant in Java comparison
  // TODO: Show that Java arrays are covariant (unsound) while Scala arrays are invariant (safe)
  //       Write a method demonstrating Scala's Array[A] is invariant
  def processArray(arr: Array[Int]): Int = ???

  // Note: In Java, String[] is subtype of Object[] - this is unsound
  // In Scala, Array[String] is NOT subtype of Array[Any] - this is safe

  // Exercise 8: Invariant API design
  // TODO: Design a type-safe invariant API for a simple key-value store
  class TypedStore[K, V] private (private val data: Map[K, V]) {
    def get(key: K): Option[V] = ???
    def put(key: K, value: V): TypedStore[K, V] = ???
    def keys: Set[K] = ???
    def values: Iterable[V] = ???
  }

  object TypedStore {
    def empty[K, V]: TypedStore[K, V] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val holder = new Holder[Int](10)
    assert(holder.get == 10)
    holder.set(20)
    assert(holder.get == 20)

    // Exercise 2
    val stack = new MutableStack[Int]
    stack.push(1)
    stack.push(2)
    stack.push(3)
    assert(stack.pop() == Some(3))
    assert(stack.peek == Some(2))

    // Exercise 3
    val users = List(User(Id[User](1), "Alice"), User(Id[User](2), "Bob"))
    assert(lookup(Id[User](1), users).map(_.name) == Some("Alice"))
    assert(lookup(Id[User](3), users) == None)

    // Exercise 4
    assert(speed(Meters(100), Seconds(10)) == 10.0)

    // Exercise 5
    val buf = new InvariantBuffer[Int]
    buf.append(1)
    buf.append(2)
    assert(buf.getAll == List(1, 2))
    val mapped = buf.map(_.toString)
    assert(mapped.getAll == List("1", "2"))

    // Exercise 6
    val set = InvSet(1, 2, 3)
    assert(set.contains(2))
    assert(!set.contains(4))
    val set2 = set.add(4)
    assert(set2.contains(4))

    // Exercise 7
    assert(processArray(Array(1, 2, 3)) == 6)

    // Exercise 8
    val store = TypedStore.empty[String, Int].put("a", 1).put("b", 2)
    assert(store.get("a") == Some(1))
    assert(store.get("c") == None)
    assert(store.keys == Set("a", "b"))

    println("All Core091_InvariantDesign exercises passed!")
  }
}
