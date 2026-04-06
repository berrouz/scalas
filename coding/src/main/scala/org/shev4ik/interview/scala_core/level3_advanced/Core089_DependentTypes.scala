package org.shev4ik.interview.scala_core.level3_advanced

object Core089_DependentTypes {

  // Exercise 1: Dependent method types
  // TODO: Define a trait Key with a type member Value, and a method `get`
  //       whose return type depends on the specific Key passed in
  trait Key {
    type Value
  }

  trait Store {
    def get(key: Key): key.Value
    def put(key: Key)(value: key.Value): Store
  }

  // TODO: Create concrete keys
  object NameKey extends Key { type Value = String }
  object AgeKey extends Key { type Value = Int }

  // TODO: Implement a simple MapStore
  class MapStore(data: Map[Key, Any]) extends Store {
    def get(key: Key): key.Value = ???
    def put(key: Key)(value: key.Value): MapStore = ???
  }

  object MapStore {
    def empty: MapStore = ???
  }

  // Exercise 2: Dependent return types
  // TODO: Define a method whose return type depends on the input
  sealed trait Format
  case object IntFormat extends Format
  case object StringFormat extends Format

  trait Parser {
    type Result
  }

  case class IntParser() extends Parser { type Result = Int }
  case class StringParser() extends Parser { type Result = String }

  // TODO: Write a parse method with dependent return type
  def parse(parser: Parser)(input: String): parser.Result = ???

  // Exercise 3: Dependent type member
  // TODO: Define a type class with a dependent type member
  trait Extractor[Source] {
    type Output
    def extract(source: Source): Output
  }

  object Extractor {
    type Aux[S, O] = Extractor[S] { type Output = O }

    // TODO: Implement for String => Int (extract length)
    implicit val stringExtractor: Extractor.Aux[String, Int] = ???

    // TODO: Implement for List[_] => Int (extract size)
    implicit def listExtractor[A]: Extractor.Aux[List[A], Int] = ???
  }

  def extract[S](source: S)(implicit ext: Extractor[S]): ext.Output = ???

  // Exercise 4: Aux pattern revisited
  // TODO: Chain two dependent type class instances together
  trait Transform[A] {
    type B
    def apply(a: A): B
  }

  object Transform {
    type Aux[A0, B0] = Transform[A0] { type B = B0 }

    implicit val intToString: Transform.Aux[Int, String] = ???
    implicit val stringToBoolean: Transform.Aux[String, Boolean] = ???
  }

  // TODO: Write a method that chains two transforms
  def chainTransform[A, B, C](a: A)(implicit
    t1: Transform.Aux[A, B],
    t2: Transform.Aux[B, C]
  ): C = ???

  // Exercise 5: Pi types simulation
  // TODO: Simulate dependent function types using method with dependent return type
  trait TypedKey[V] {
    val name: String
  }

  def key[V](n: String): TypedKey[V] = new TypedKey[V] { val name = n }

  case class TypedMap(underlying: Map[String, Any]) {
    def get[V](k: TypedKey[V]): Option[V] = ???
    def put[V](k: TypedKey[V], v: V): TypedMap = ???
  }

  // Exercise 6: Path-dependent evidence
  // TODO: Create a system where evidence is path-dependent
  class Registry {
    case class Id(value: Int)

    private var items: Map[Id, String] = Map.empty

    def register(name: String): Id = ???
    def lookup(id: Id): Option[String] = ???
  }

  // Exercise 7: Dependent function values
  // TODO: Encode a dependent function as a trait (Scala 2 workaround for dependent function types)
  trait DepFunction {
    def apply(key: Key): key.Value
  }

  // TODO: Create a DepFunction implementation
  def makeDepFunction(store: Store): DepFunction = ???

  // Exercise 8: Type-safe heterogeneous lookup
  // TODO: Create a type-safe heterogeneous map using dependent types
  //       Different keys map to different value types
  trait HMapKey {
    type V
  }

  class HMap(private val underlying: Map[HMapKey, Any]) {
    def get(k: HMapKey): Option[k.V] = ???
    def put(k: HMapKey)(v: k.V): HMap = ???
  }

  object HMap {
    def empty: HMap = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val store = MapStore.empty.put(NameKey)("Alice").put(AgeKey)(30)
    val name: String = store.get(NameKey)
    val age: Int = store.get(AgeKey)
    assert(name == "Alice")
    assert(age == 30)

    // Exercise 2
    val ip = IntParser()
    val sp = StringParser()
    assert(parse(ip)("42") == 42)
    assert(parse(sp)("hello") == "hello")

    // Exercise 3
    assert(extract("hello") == 5)
    assert(extract(List(1, 2, 3)) == 3)

    // Exercise 4
    assert(chainTransform(42) == true) // 42 -> "42" -> true (non-empty)

    // Exercise 5
    val nameKey = key[String]("name")
    val ageKey = key[Int]("age")
    val tmap = TypedMap(Map.empty).put(nameKey, "Bob").put(ageKey, 25)
    assert(tmap.get(nameKey) == Some("Bob"))
    assert(tmap.get(ageKey) == Some(25))

    // Exercise 6
    val registry = new Registry
    val id1 = registry.register("item1")
    assert(registry.lookup(id1) == Some("item1"))

    // Exercise 7
    val storeForDep = MapStore.empty.put(NameKey)("Charlie")
    val depFn = makeDepFunction(storeForDep)
    assert(depFn(NameKey) == "Charlie")

    // Exercise 8
    val k1 = new HMapKey { type V = String }
    val k2 = new HMapKey { type V = Int }
    val hm = HMap.empty.put(k1)("hello").put(k2)(42)
    assert(hm.get(k1) == Some("hello"))
    assert(hm.get(k2) == Some(42))

    println("All Core089_DependentTypes exercises passed!")
  }
}
