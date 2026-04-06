package org.shev4ik.interview.scala_core.level2_intermediate

object Core056_PathDependentTypes {

  // Exercise 1: Path-dependent type
  // TODO: Create a class Database with an inner class Row(val data: Map[String, String])
  //       The type db.Row is path-dependent on the specific db instance
  class Database(val name: String) {
    class Row(val data: Map[String, String]) {
      override def toString: String = s"$name.Row($data)"
    }
    def createRow(data: Map[String, String]): Row = ???
    // This method only accepts Rows from THIS database
    def processRow(row: Row): String = ???
  }

  // Exercise 2: Inner class types
  // TODO: Create a class Graph with inner class Node
  //       Show that graph1.Node and graph2.Node are different types
  class Graph(val label: String) {
    class Node(val id: Int) {
      def describe: String = s"$label:Node($id)"
    }
    def addNode(id: Int): Node = ???
    def connect(from: Node, to: Node): String = ???
  }

  // Exercise 3: Type projections
  // TODO: Use type projection (Outer#Inner) to refer to Inner type
  //       without specifying a particular Outer instance
  //       Create a method that accepts any Graph's Node
  def describeAnyNode(node: Graph#Node): String = ???

  // Exercise 4: this.type
  // TODO: Create a fluent builder using this.type for method chaining
  //       that works correctly with inheritance
  class Builder {
    private var _name: String = ""
    private var _value: Int = 0

    def setName(n: String): this.type = ???
    def setValue(v: Int): this.type = ???
    def build: String = ???
  }

  class AdvancedBuilder extends Builder {
    private var _extra: String = ""
    def setExtra(e: String): this.type = ???
    override def build: String = ???
  }

  // Exercise 5: Singleton types
  // TODO: Demonstrate singleton types - the type of a specific value
  //       Create a method that returns its argument unchanged but with a refined type
  def singleton(s: String): s.type = ???

  // TODO: Use singleton type for a type-safe builder state machine concept
  sealed trait State
  object Empty extends State
  object Ready extends State

  // Exercise 6: Dependent method types
  // TODO: Create a trait where the return type of a method depends on the argument
  trait KeyValueStore {
    type Key
    type Value
    def get(key: Key): Option[Value]
  }

  class StringIntStore extends KeyValueStore {
    type Key = String
    type Value = Int
    private val data = scala.collection.mutable.Map.empty[String, Int]
    def put(key: String, value: Int): Unit = ???
    def get(key: String): Option[Int] = ???
  }

  // Exercise 7: Cake pattern with path-dependent types
  // TODO: Create a module system where types depend on the specific module instance
  trait StorageModule {
    type Record
    def create(data: String): Record
    def read(record: Record): String
  }

  class InMemoryStorage extends StorageModule {
    case class Record(id: Int, data: String)
    private var nextId = 0
    def create(data: String): Record = ???
    def read(record: Record): String = ???
  }

  // Exercise 8: Type safety with PDT
  // TODO: Use path-dependent types to ensure type safety
  //       A Currency class with inner Amount - amounts from different currencies
  //       cannot be mixed
  class Currency(val code: String) {
    class Amount(val value: Double) {
      def +(other: Amount): Amount = ???
      override def toString: String = s"$code $value"
    }
    def amount(value: Double): Amount = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val db1 = new Database("users")
    val row1 = db1.createRow(Map("name" -> "Alice"))
    assert(db1.processRow(row1).contains("Alice"), "processRow should work with own row")
    // db2.processRow(row1) would NOT compile - type safety!

    // Exercise 2 assertions
    val g1 = new Graph("G1")
    val n1 = g1.addNode(1)
    val n2 = g1.addNode(2)
    assert(g1.connect(n1, n2).nonEmpty, "connect should work with same-graph nodes")

    // Exercise 3 assertions
    val g2 = new Graph("G2")
    val n3 = g2.addNode(3)
    assert(describeAnyNode(n1).contains("G1"), "describeAnyNode should work with any graph's node")
    assert(describeAnyNode(n3).contains("G2"), "describeAnyNode should work with G2's node")

    // Exercise 4 assertions
    val result = new AdvancedBuilder()
      .setName("test")
      .setValue(42)
      .setExtra("bonus")
      .build
    assert(result.contains("test"), "builder should include name")
    assert(result.contains("42"), "builder should include value")
    assert(result.contains("bonus"), "builder should include extra")

    // Exercise 5 assertions
    val s: String = singleton("hello")
    assert(s == "hello", "singleton should return the same value")

    // Exercise 6 assertions
    val store = new StringIntStore
    store.put("age", 30)
    assert(store.get("age") == Some(30), "store get should return value")
    assert(store.get("missing") == None, "store get missing should return None")

    // Exercise 7 assertions
    val storage = new InMemoryStorage
    val rec = storage.create("test data")
    assert(storage.read(rec) == "test data", "storage should round-trip data")

    // Exercise 8 assertions
    val usd = new Currency("USD")
    val eur = new Currency("EUR")
    val a1 = usd.amount(100.0)
    val a2 = usd.amount(50.0)
    assert((a1 + a2).value == 150.0, "USD amounts should add")
    // val a3 = eur.amount(50.0)
    // a1 + a3 would NOT compile - different currencies!

    println("All Core056_PathDependentTypes exercises passed!")
  }
}
