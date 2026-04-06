package org.shev4ik.interview.scala_core.level4_expert

object Core115_ShapelessDerivation {

  // Simplified Generic + derivation (Shapeless-inspired)

  // Exercise 1: Generic
  // TODO: Define a Generic type class for converting case classes to tuples
  trait Generic[T] {
    type Repr
    def to(t: T): Repr
    def from(r: Repr): T
  }

  object Generic {
    type Aux[T, R] = Generic[T] { type Repr = R }

    def apply[T](implicit g: Generic[T]): Generic[T] = g
  }

  case class Person(name: String, age: Int)
  case class Address(street: String, city: String, zip: String)

  // TODO: Implement Generic for Person
  implicit val personGeneric: Generic.Aux[Person, (String, Int)] = ???

  // TODO: Implement Generic for Address
  implicit val addressGeneric: Generic.Aux[Address, (String, String, String)] = ???

  // Exercise 2: LabelledGeneric concept
  // TODO: Define a LabelledGeneric that preserves field names
  trait LabelledGeneric[T] {
    type Repr
    def to(t: T): Repr
    def from(r: Repr): T
    def fieldNames: List[String]
  }

  // TODO: Implement LabelledGeneric for Person
  implicit val personLabelled: LabelledGeneric[Person] = ???

  // TODO: Implement LabelledGeneric for Address
  implicit val addressLabelled: LabelledGeneric[Address] = ???

  // Exercise 3: Auto derivation
  // TODO: Define a Show type class and auto-derive it using Generic
  trait Show[T] {
    def show(t: T): String
  }

  // TODO: Derive Show for any type with a LabelledGeneric
  implicit def deriveShow[T](implicit lg: LabelledGeneric[T]): Show[T] = ???

  def show[T](t: T)(implicit s: Show[T]): String = ???

  // Exercise 4: Semi-auto derivation
  // TODO: Define a pattern where users explicitly request derivation
  object Show {
    def derived[T](implicit lg: LabelledGeneric[T]): Show[T] = ???
  }

  // Exercise 5: Lazy for recursive types
  // TODO: Show how Lazy is used to break recursive implicit resolution
  case class Lazy[T](value: T)

  object Lazy {
    implicit def mkLazy[T](implicit t: T): Lazy[T] = Lazy(t)
  }

  // Exercise 6: Derive encoder
  // TODO: Derive a JSON-like encoder using Generic
  trait Encoder[T] {
    def encode(t: T): Map[String, String]
  }

  // TODO: Derive Encoder for types with LabelledGeneric
  implicit def deriveEncoder[T](implicit lg: LabelledGeneric[T]): Encoder[T] = ???

  def encode[T](t: T)(implicit e: Encoder[T]): Map[String, String] = ???

  // Exercise 7: Derive decoder
  // TODO: Derive a decoder from Map[String, String]
  trait Decoder[T] {
    def decode(m: Map[String, String]): Option[T]
  }

  // TODO: Implement Decoder for Person (simplified, not fully generic)
  implicit val personDecoder: Decoder[Person] = ???

  def decode[T](m: Map[String, String])(implicit d: Decoder[T]): Option[T] = ???

  // Exercise 8: Recursive derivation concept
  // TODO: Show how to handle nested case classes in derivation
  case class Employee(person: Person, department: String)

  // TODO: Implement Show for Employee that uses Show for Person
  implicit val employeeShow: Show[Employee] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val person = Person("Alice", 30)
    val repr = Generic[Person].to(person)
    assert(repr == ("Alice", 30))
    assert(personGeneric.from(("Bob", 25)) == Person("Bob", 25))

    // Exercise 2
    assert(personLabelled.fieldNames == List("name", "age"))

    // Exercise 3
    assert(show(Person("Alice", 30)).contains("Alice"))
    assert(show(Person("Alice", 30)).contains("30"))

    // Exercise 4
    val derivedShow = Show.derived[Person]
    assert(derivedShow.show(Person("Bob", 25)).contains("Bob"))

    // Exercise 6
    val encoded = encode(Person("Alice", 30))
    assert(encoded("name") == "Alice")
    assert(encoded("age") == "30")

    val encodedAddr = encode(Address("123 Main", "NYC", "10001"))
    assert(encodedAddr("street") == "123 Main")
    assert(encodedAddr("city") == "NYC")

    // Exercise 7
    val decoded = decode[Person](Map("name" -> "Charlie", "age" -> "35"))
    assert(decoded == Some(Person("Charlie", 35)))
    val invalid = decode[Person](Map("name" -> "Charlie"))
    assert(invalid == None)

    // Exercise 8
    val emp = Employee(Person("Diana", 28), "Engineering")
    val empStr = employeeShow.show(emp)
    assert(empStr.contains("Diana") && empStr.contains("Engineering"))

    println("All Core115_ShapelessDerivation exercises passed!")
  }
}
