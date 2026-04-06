package org.shev4ik.interview.doobie.level2_intermediate

/**
 * Doobie 009 - Composite Types (Read/Write derivation, HList mapping, nested objects)
 *
 * In doobie, Read[A] and Write[A] type classes handle reading/writing composite
 * types (multiple columns) to/from Scala types. They can be derived automatically
 * for case classes, tuples, and HList-like structures. Nested objects require
 * custom Read/Write instances.
 *
 * Here we model simplified Read/Write to understand how doobie maps multiple
 * columns to complex Scala types.
 */
object Doob009_CompositeTypes {

  type Row = Map[String, Any]

  // Simplified Read: reads a composite type from a row
  trait Read[A] {
    def read(row: Row, columns: List[String]): A
    def length: Int
  }

  object Read {
    def apply[A](implicit ev: Read[A]): Read[A] = ev

    def instance[A](len: Int)(f: (Row, List[String]) => A): Read[A] = new Read[A] {
      def read(row: Row, columns: List[String]): A = f(row, columns)
      def length: Int = len
    }
  }

  // Simplified Write: converts a composite type to a list of values
  trait Write[A] {
    def write(a: A): List[Any]
    def length: Int
  }

  object Write {
    def apply[A](implicit ev: Write[A]): Write[A] = ev

    def instance[A](len: Int)(f: A => List[Any]): Write[A] = new Write[A] {
      def write(a: A): List[Any] = f(a)
      def length: Int = len
    }
  }

  // Primitive instances
  implicit val readInt: Read[Int] = Read.instance(1)((row, cols) => row(cols.head).asInstanceOf[Int])
  implicit val readString: Read[String] = Read.instance(1)((row, cols) => row(cols.head).asInstanceOf[String])
  implicit val readDouble: Read[Double] = Read.instance(1)((row, cols) => row(cols.head).asInstanceOf[Double])
  implicit val readBoolean: Read[Boolean] = Read.instance(1)((row, cols) => row(cols.head).asInstanceOf[Boolean])

  implicit val writeInt: Write[Int] = Write.instance(1)(a => List(a))
  implicit val writeString: Write[String] = Write.instance(1)(a => List(a))
  implicit val writeDouble: Write[Double] = Write.instance(1)(a => List(a))
  implicit val writeBoolean: Write[Boolean] = Write.instance(1)(a => List(a))

  // Domain types
  case class User(id: Int, name: String, age: Int)
  case class Address(street: String, city: String, zip: String)
  case class UserWithAddress(user: User, address: Address)
  case class Order(id: Int, userId: Int, amount: Double, shipped: Boolean)

  // Sample data
  val userRow: Row = Map("id" -> 1, "name" -> "Alice", "age" -> 30)
  val addressRow: Row = Map("street" -> "123 Main St", "city" -> "Springfield", "zip" -> "62704")
  val combinedRow: Row = Map(
    "id" -> 1, "name" -> "Alice", "age" -> 30,
    "street" -> "123 Main St", "city" -> "Springfield", "zip" -> "62704"
  )
  val orderRow: Row = Map("id" -> 1, "user_id" -> 2, "amount" -> 99.99, "shipped" -> true)

  // -------------------------------------------------------------------------
  // Exercise 1: Create a Read[User] that reads id, name, age columns.
  // TODO: Use Read.instance to build a reader for User from 3 columns.
  // -------------------------------------------------------------------------
  implicit val readUser: Read[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a Write[User] that converts User to a list of values.
  // TODO: Use Write.instance to serialize User fields to List[Any].
  // -------------------------------------------------------------------------
  implicit val writeUser: Write[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a Read[(Int, String)] tuple reader.
  // TODO: Read two columns and return them as a tuple.
  // -------------------------------------------------------------------------
  implicit val readIntString: Read[(Int, String)] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create a Read[Address] for the address fields.
  // TODO: Read street, city, zip columns into Address.
  // -------------------------------------------------------------------------
  implicit val readAddress: Read[Address] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create a Read[UserWithAddress] that composes Read[User] and Read[Address].
  // TODO: Read the first 3 columns as User, next 3 as Address, combine.
  // The columns list will have all 6 column names.
  // -------------------------------------------------------------------------
  implicit val readUserWithAddress: Read[UserWithAddress] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a generic function that reads a list of rows.
  // TODO: Given a list of Rows and column names, read each row using Read[A].
  // -------------------------------------------------------------------------
  def exercise6_readRows[A](rows: List[Row], columns: List[String])(implicit ra: Read[A]): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement Write composition for nested types.
  // TODO: Create Write[UserWithAddress] that combines Write[User] and Write[Address].
  // -------------------------------------------------------------------------
  implicit val writeAddress: Write[Address] = Write.instance(3)(a => List(a.street, a.city, a.zip))
  implicit val writeUserWithAddress: Write[UserWithAddress] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a Read[Option[A]] that handles missing/null values.
  // TODO: If any of the required columns are missing or null in the row,
  // return None. Otherwise return Some(A).
  // -------------------------------------------------------------------------
  def exercise8_readOptional[A](row: Row, columns: List[String])(implicit ra: Read[A]): Option[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val user = Read[User].read(userRow, List("id", "name", "age"))
    assert(user == User(1, "Alice", 30))
    println("Exercise 1 passed: Read[User]")

    // Exercise 2
    val written = Write[User].write(User(1, "Alice", 30))
    assert(written == List(1, "Alice", 30))
    println("Exercise 2 passed: Write[User]")

    // Exercise 3
    val tuple = Read[(Int, String)].read(userRow, List("id", "name"))
    assert(tuple == (1, "Alice"))
    println("Exercise 3 passed: Read[(Int, String)]")

    // Exercise 4
    val addr = Read[Address].read(addressRow, List("street", "city", "zip"))
    assert(addr == Address("123 Main St", "Springfield", "62704"))
    println("Exercise 4 passed: Read[Address]")

    // Exercise 5
    val uwa = Read[UserWithAddress].read(combinedRow, List("id", "name", "age", "street", "city", "zip"))
    assert(uwa == UserWithAddress(User(1, "Alice", 30), Address("123 Main St", "Springfield", "62704")))
    println("Exercise 5 passed: Read[UserWithAddress] composed")

    // Exercise 6
    val rows = List(
      Map[String, Any]("id" -> 1, "name" -> "Alice", "age" -> 30),
      Map[String, Any]("id" -> 2, "name" -> "Bob", "age" -> 25)
    )
    val users = exercise6_readRows[User](rows, List("id", "name", "age"))
    assert(users == List(User(1, "Alice", 30), User(2, "Bob", 25)))
    println("Exercise 6 passed: read list of rows")

    // Exercise 7
    val writtenUWA = Write[UserWithAddress].write(
      UserWithAddress(User(1, "Alice", 30), Address("123 Main St", "Springfield", "62704"))
    )
    assert(writtenUWA == List(1, "Alice", 30, "123 Main St", "Springfield", "62704"))
    println("Exercise 7 passed: Write[UserWithAddress] composed")

    // Exercise 8
    val goodRow: Row = Map("id" -> 1, "name" -> "Alice", "age" -> 30)
    val nullRow: Row = Map("id" -> 1, "name" -> null, "age" -> 30)
    val missingRow: Row = Map("id" -> 1)
    assert(exercise8_readOptional[User](goodRow, List("id", "name", "age")) == Some(User(1, "Alice", 30)))
    assert(exercise8_readOptional[User](nullRow, List("id", "name", "age")) == None)
    assert(exercise8_readOptional[User](missingRow, List("id", "name", "age")) == None)
    println("Exercise 8 passed: Read optional composite")

    println("\nAll Doob009_CompositeTypes exercises passed!")
  }
}
