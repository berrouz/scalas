package org.shev4ik.interview.doobie.level1_basics

/**
 * Doobie 004 - Type Mapping (Get/Put type classes, custom column mappings)
 *
 * Doobie uses Get[A] and Put[A] type classes to read from and write to JDBC
 * columns. Get[A] knows how to read a column value into A; Put[A] knows how
 * to set a parameter of type A. Composite types (Read/Write) are built from
 * Get/Put instances for individual columns.
 *
 * Here we model simplified Get/Put to understand custom type mappings,
 * newtypes, and how doobie bridges Scala types to SQL types.
 */
object Doob004_TypeMapping {

  // Simplified Get: reads a raw value (Any) into type A
  trait Get[A] {
    def get(raw: Any): A
  }

  object Get {
    def apply[A](implicit ev: Get[A]): Get[A] = ev
    def instance[A](f: Any => A): Get[A] = new Get[A] { def get(raw: Any): A = f(raw) }
  }

  // Simplified Put: converts A into a raw value for SQL parameters
  trait Put[A] {
    def put(a: A): Any
  }

  object Put {
    def apply[A](implicit ev: Put[A]): Put[A] = ev
    def instance[A](f: A => Any): Put[A] = new Put[A] { def put(a: A): Any = f(a) }
  }

  // Built-in instances
  implicit val getInt: Get[Int] = Get.instance(_.asInstanceOf[Int])
  implicit val getString: Get[String] = Get.instance(_.asInstanceOf[String])
  implicit val getDouble: Get[Double] = Get.instance(_.asInstanceOf[Double])
  implicit val getBoolean: Get[Boolean] = Get.instance(_.asInstanceOf[Boolean])

  implicit val putInt: Put[Int] = Put.instance(identity)
  implicit val putString: Put[String] = Put.instance(identity)
  implicit val putDouble: Put[Double] = Put.instance(identity)
  implicit val putBoolean: Put[Boolean] = Put.instance(identity)

  // Domain types
  case class UserId(value: Int)
  case class Email(value: String)
  case class Currency(code: String, amount: Double)

  sealed trait Status
  case object Active extends Status
  case object Inactive extends Status

  // -------------------------------------------------------------------------
  // Exercise 1: Create a Get[UserId] instance by mapping from Get[Int].
  // TODO: Use Get.instance to read an Int and wrap it in UserId.
  // -------------------------------------------------------------------------
  implicit val getUserId: Get[UserId] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a Put[UserId] instance that unwraps to Int.
  // TODO: Use Put.instance to extract the Int value from UserId.
  // -------------------------------------------------------------------------
  implicit val putUserId: Put[UserId] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a Get[Email] that validates the email format.
  // TODO: Read a String, check it contains '@', wrap in Email.
  // If invalid, throw IllegalArgumentException("Invalid email: ...").
  // -------------------------------------------------------------------------
  implicit val getEmail: Get[Email] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create Get/Put instances for Status (stored as String in DB).
  // TODO: Map "active" -> Active, "inactive" -> Inactive for Get.
  // Map Active -> "active", Inactive -> "inactive" for Put.
  // Throw IllegalArgumentException for unknown status strings.
  // -------------------------------------------------------------------------
  implicit val getStatus: Get[Status] = ???
  implicit val putStatus: Put[Status] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement a generic contramap for Put.
  // TODO: Given Put[B] and a function A => B, produce Put[A].
  // -------------------------------------------------------------------------
  def exercise5_contramapPut[A, B](pb: Put[B])(f: A => B): Put[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a generic map for Get.
  // TODO: Given Get[A] and a function A => B, produce Get[B].
  // -------------------------------------------------------------------------
  def exercise6_mapGet[A, B](ga: Get[A])(f: A => B): Get[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Create a composite reader that reads multiple columns.
  // TODO: Given a Map[String, Any] (row) and column names with Get instances,
  // read two columns and return a tuple (A, B).
  // -------------------------------------------------------------------------
  def exercise7_readTwoColumns[A, B](row: Map[String, Any], col1: String, col2: String)(
    implicit ga: Get[A], gb: Get[B]
  ): (A, B) = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a column reader that handles nullable columns.
  // TODO: Given a column name and a row, return Option[A]. If the column
  // value is null or missing, return None; otherwise Some(parsed value).
  // -------------------------------------------------------------------------
  def exercise8_readNullable[A](row: Map[String, Any], column: String)(
    implicit ga: Get[A]
  ): Option[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(Get[UserId].get(42) == UserId(42))
    println("Exercise 1 passed: Get[UserId]")

    // Exercise 2
    assert(Put[UserId].put(UserId(42)) == 42)
    println("Exercise 2 passed: Put[UserId]")

    // Exercise 3
    assert(Get[Email].get("alice@example.com") == Email("alice@example.com"))
    var threw = false
    try { Get[Email].get("invalid") } catch { case _: IllegalArgumentException => threw = true }
    assert(threw)
    println("Exercise 3 passed: Get[Email] with validation")

    // Exercise 4
    assert(Get[Status].get("active") == Active)
    assert(Get[Status].get("inactive") == Inactive)
    assert(Put[Status].put(Active) == "active")
    assert(Put[Status].put(Inactive) == "inactive")
    println("Exercise 4 passed: Get/Put[Status] enum mapping")

    // Exercise 5
    val putEmail: Put[Email] = exercise5_contramapPut(putString)(_.value)
    assert(putEmail.put(Email("test@test.com")) == "test@test.com")
    println("Exercise 5 passed: contramap for Put")

    // Exercise 6
    val getLength: Get[Int] = exercise6_mapGet(getString)(_.length)
    assert(getLength.get("hello") == 5)
    println("Exercise 6 passed: map for Get")

    // Exercise 7
    val row = Map[String, Any]("name" -> "Alice", "age" -> 30)
    assert(exercise7_readTwoColumns[String, Int](row, "name", "age") == ("Alice", 30))
    println("Exercise 7 passed: read two columns")

    // Exercise 8
    val rowWithNull = Map[String, Any]("name" -> "Alice", "age" -> null)
    assert(exercise8_readNullable[String](rowWithNull, "name") == Some("Alice"))
    assert(exercise8_readNullable[Int](rowWithNull, "age") == None)
    assert(exercise8_readNullable[String](rowWithNull, "missing") == None)
    println("Exercise 8 passed: nullable column reader")

    println("\nAll Doob004_TypeMapping exercises passed!")
  }
}
