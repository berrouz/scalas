package org.shev4ik.interview.scala_core.level4_expert

object Core123_RowPolymorphism {

  // Exercise 1: Row type concept
  // TODO: Simulate row types using a type-safe record built on Map
  class Record(private val fields: Map[String, Any]) {
    def get[T](key: String): Option[T] = ???
    def set[T](key: String, value: T): Record = ???
    def keys: Set[String] = ???
    def toMap: Map[String, Any] = ???
  }

  object Record {
    def empty: Record = ???
    def apply(fields: (String, Any)*): Record = ???
  }

  // Exercise 2: Extensible record
  // TODO: Define a typed field descriptor and build records with them
  case class Field[T](name: String)

  class TypedRecord(private val data: Map[String, Any]) {
    def get[T](field: Field[T]): Option[T] = ???
    def set[T](field: Field[T], value: T): TypedRecord = ???
    def remove(field: Field[_]): TypedRecord = ???
  }

  object TypedRecord {
    def empty: TypedRecord = ???
  }

  // Exercise 3: Row extension
  // TODO: Implement row extension - adding fields to a record
  def extend[T](record: TypedRecord, field: Field[T], value: T): TypedRecord = ???

  // Exercise 4: Row restriction
  // TODO: Implement row restriction - removing fields from a record
  def restrict(record: TypedRecord, field: Field[_]): TypedRecord = ???

  // Exercise 5: Shapeless record concept
  // TODO: Simulate Shapeless-style records using tagged types
  trait Tagged[T]
  type @@[V, T] = V with Tagged[T]

  trait FieldTag
  trait NameField extends FieldTag
  trait AgeField extends FieldTag

  // TODO: Create tagged field accessors
  case class TaggedRecord(data: Map[String, Any]) {
    def get[T, F <: FieldTag](implicit key: FieldKey[F]): Option[T] = ???
    def set[T, F <: FieldTag](value: T)(implicit key: FieldKey[F]): TaggedRecord = ???
  }

  trait FieldKey[F <: FieldTag] {
    def name: String
  }

  implicit val nameFieldKey: FieldKey[NameField] = ???
  implicit val ageFieldKey: FieldKey[AgeField] = ???

  // Exercise 6: Polymorphic record access
  // TODO: Write a function that works with any record containing a "name" field
  trait HasNameField[R] {
    def getName(r: R): String
  }

  // TODO: Implement for TypedRecord
  def greet[R](record: R)(implicit hn: HasNameField[R]): String = ???

  // Exercise 7: Row polymorphism use cases
  // TODO: Show a practical use case - functions that work with partial record types
  case class UserFields(name: String, email: String, age: Int)
  case class AdminFields(name: String, email: String, age: Int, role: String)

  // TODO: Write a function that works with anything that has name and email
  trait HasContactInfo[T] {
    def name(t: T): String
    def email(t: T): String
  }

  implicit val userContact: HasContactInfo[UserFields] = ???
  implicit val adminContact: HasContactInfo[AdminFields] = ???

  def sendEmail[T](to: T, subject: String)(implicit ci: HasContactInfo[T]): String = ???

  // Exercise 8: Row vs structural typing
  // TODO: Compare row polymorphism approach with Scala's structural types
  import scala.language.reflectiveCalls

  // Structural typing approach (uses reflection at runtime)
  def structuralGreet(obj: { def name: String }): String = ???

  // Row polymorphism approach (type class based, no reflection)
  def rowGreet[T](obj: T)(implicit hn: HasNameField[T]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r = Record("name" -> "Alice", "age" -> 30)
    assert(r.get[String]("name") == Some("Alice"))
    assert(r.get[Int]("age") == Some(30))
    assert(r.keys == Set("name", "age"))

    // Exercise 2
    val nameField = Field[String]("name")
    val ageField = Field[Int]("age")
    val tr = TypedRecord.empty.set(nameField, "Bob").set(ageField, 25)
    assert(tr.get(nameField) == Some("Bob"))
    assert(tr.get(ageField) == Some(25))

    // Exercise 3
    val emailField = Field[String]("email")
    val extended = extend(tr, emailField, "bob@test.com")
    assert(extended.get(emailField) == Some("bob@test.com"))

    // Exercise 4
    val restricted = restrict(extended, ageField)
    assert(restricted.get(ageField) == None)
    assert(restricted.get(nameField) == Some("Bob"))

    // Exercise 5
    val tagged = TaggedRecord(Map("name" -> "Charlie", "age" -> 35))
    assert(tagged.get[String, NameField] == Some("Charlie"))
    assert(tagged.get[Int, AgeField] == Some(35))

    // Exercise 7
    val user = UserFields("Diana", "diana@test.com", 28)
    val admin = AdminFields("Eve", "eve@test.com", 35, "superadmin")
    assert(sendEmail(user, "Hello").contains("diana@test.com"))
    assert(sendEmail(admin, "Hello").contains("eve@test.com"))

    // Exercise 8
    val obj = new { def name: String = "Frank" }
    assert(structuralGreet(obj) == "Hello, Frank")

    println("All Core123_RowPolymorphism exercises passed!")
  }
}
