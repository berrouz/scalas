package org.shev4ik.interview.doobie.level3_advanced

/**
 * Doobie 011 - Skunk Basics (Skunk vs Doobie, Session, prepared statements, codecs)
 *
 * Skunk is an alternative to doobie for PostgreSQL. While doobie wraps JDBC,
 * Skunk uses the native PostgreSQL wire protocol. Key differences:
 * - Skunk: non-blocking, pure FP, PostgreSQL-only, uses Codec instead of Get/Put
 * - Doobie: JDBC-based, supports any JDBC database, uses Get/Put/Read/Write
 *
 * Here we model Skunk's core concepts: Session, Codec, Command, Query,
 * and PreparedStatement to understand the alternative approach.
 */
object Doob011_SkunkBasics {

  // Simplified Codec: bidirectional mapping (encode + decode)
  trait Codec[A] {
    def encode(a: A): List[String]
    def decode(strings: List[String]): A
    def length: Int

    def ~[B](other: Codec[B]): Codec[(A, B)] = {
      val self = this
      new Codec[(A, B)] {
        def encode(ab: (A, B)): List[String] = self.encode(ab._1) ++ other.encode(ab._2)
        def decode(strings: List[String]): (A, B) = {
          val (left, right) = strings.splitAt(self.length)
          (self.decode(left), other.decode(right))
        }
        def length: Int = self.length + other.length
      }
    }

    def imap[B](f: A => B)(g: B => A): Codec[B] = {
      val self = this
      new Codec[B] {
        def encode(b: B): List[String] = self.encode(g(b))
        def decode(strings: List[String]): B = f(self.decode(strings))
        def length: Int = self.length
      }
    }
  }

  // Built-in codecs
  val int4: Codec[Int] = new Codec[Int] {
    def encode(a: Int): List[String] = List(a.toString)
    def decode(strings: List[String]): Int = strings.head.toInt
    def length: Int = 1
  }

  val text: Codec[String] = new Codec[String] {
    def encode(a: String): List[String] = List(a)
    def decode(strings: List[String]): String = strings.head
    def length: Int = 1
  }

  val float8: Codec[Double] = new Codec[Double] {
    def encode(a: Double): List[String] = List(a.toString)
    def decode(strings: List[String]): Double = strings.head.toDouble
    def length: Int = 1
  }

  val bool: Codec[Boolean] = new Codec[Boolean] {
    def encode(a: Boolean): List[String] = List(a.toString)
    def decode(strings: List[String]): Boolean = strings.head.toBoolean
    def length: Int = 1
  }

  // Simplified Query and Command
  case class Query[I, O](sql: String, encoder: Codec[I], decoder: Codec[O]) {
    def execute(input: I, data: List[List[String]]): List[O] = data.map(decoder.decode)
  }

  case class Command[I](sql: String, encoder: Codec[I]) {
    def execute(input: I): List[String] = encoder.encode(input)
  }

  // Simplified Session
  case class Session(host: String, port: Int, database: String) {
    def prepare[I, O](query: Query[I, O]): PreparedQuery[I, O] = PreparedQuery(query)
    def prepareCommand[I](command: Command[I]): PreparedCommand[I] = PreparedCommand(command)
  }

  case class PreparedQuery[I, O](query: Query[I, O]) {
    def stream(input: I, data: List[List[String]]): List[O] = query.execute(input, data)
    def unique(input: I, data: List[List[String]]): O = {
      val results = query.execute(input, data)
      require(results.size == 1)
      results.head
    }
    def option(input: I, data: List[List[String]]): Option[O] = {
      val results = query.execute(input, data)
      results.headOption
    }
  }

  case class PreparedCommand[I](command: Command[I]) {
    def execute(input: I): List[String] = command.execute(input)
  }

  case class UserId(value: Int)
  case class User(id: Int, name: String, age: Int)

  // -------------------------------------------------------------------------
  // Exercise 1: Create a composite codec for (Int, String) using ~.
  // TODO: Combine int4 and text codecs with ~.
  // -------------------------------------------------------------------------
  def exercise1_compositeCodec: Codec[(Int, String)] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a Codec[UserId] using imap on int4.
  // TODO: Map int4 to UserId using imap.
  // -------------------------------------------------------------------------
  def exercise2_userIdCodec: Codec[UserId] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a Codec[User] from int4 ~ text ~ int4.
  // TODO: Combine three codecs and imap to User.
  // Hint: int4 ~ text ~ int4 gives Codec[((Int, String), Int)]
  // -------------------------------------------------------------------------
  def exercise3_userCodec: Codec[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create a Query that selects users by age.
  // TODO: Build a Query[Int, User] with appropriate SQL, encoder, and decoder.
  // Use int4 as input encoder and exercise3_userCodec as output decoder.
  // -------------------------------------------------------------------------
  def exercise4_usersByAgeQuery: Query[Int, User] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create a Command that inserts a user.
  // TODO: Build a Command[User] with INSERT SQL and exercise3_userCodec encoder.
  // -------------------------------------------------------------------------
  def exercise5_insertUserCommand: Command[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use a Session to prepare and execute a query.
  // TODO: Create a Session, prepare exercise4_usersByAgeQuery, and call
  // stream with the given input and sample data. Return the results.
  // -------------------------------------------------------------------------
  def exercise6_prepareAndExecute(minAge: Int, sampleData: List[List[String]]): List[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement an optional codec (like Skunk's .opt).
  // TODO: Given a Codec[A], produce a Codec[Option[A]] where
  // encode(None) returns List("NULL") repeated for length,
  // encode(Some(a)) delegates to the base codec,
  // decode checks if all values are "NULL" -> None, otherwise Some(decoded).
  // -------------------------------------------------------------------------
  def exercise7_optionalCodec[A](base: Codec[A]): Codec[Option[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Compare Doobie vs Skunk design by implementing both patterns.
  // TODO: Model a "DoobieStyle" query using a mapper function (Any => A)
  // and a "SkunkStyle" query using a Codec[A]. Execute both against sample
  // data and return true if results match.
  // -------------------------------------------------------------------------
  def exercise8_compareStyles(rawRows: List[Map[String, Any]], codecRows: List[List[String]]): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val codec1 = exercise1_compositeCodec
    assert(codec1.encode((42, "hello")) == List("42", "hello"))
    assert(codec1.decode(List("42", "hello")) == (42, "hello"))
    assert(codec1.length == 2)
    println("Exercise 1 passed: composite codec")

    // Exercise 2
    val uidCodec = exercise2_userIdCodec
    assert(uidCodec.encode(UserId(5)) == List("5"))
    assert(uidCodec.decode(List("5")) == UserId(5))
    println("Exercise 2 passed: UserId codec")

    // Exercise 3
    val userCodec = exercise3_userCodec
    assert(userCodec.encode(User(1, "Alice", 30)) == List("1", "Alice", "30"))
    assert(userCodec.decode(List("1", "Alice", "30")) == User(1, "Alice", 30))
    println("Exercise 3 passed: User codec")

    // Exercise 4
    val q = exercise4_usersByAgeQuery
    assert(q.sql.contains("SELECT"))
    assert(q.encoder.length == 1)
    println("Exercise 4 passed: users by age query")

    // Exercise 5
    val cmd = exercise5_insertUserCommand
    assert(cmd.sql.contains("INSERT"))
    assert(cmd.encoder.length == 3)
    println("Exercise 5 passed: insert user command")

    // Exercise 6
    val sampleData = List(List("1", "Alice", "30"), List("2", "Bob", "25"))
    val results = exercise6_prepareAndExecute(20, sampleData)
    assert(results == List(User(1, "Alice", 30), User(2, "Bob", 25)))
    println("Exercise 6 passed: prepare and execute")

    // Exercise 7
    val optCodec = exercise7_optionalCodec(int4)
    assert(optCodec.encode(Some(42)) == List("42"))
    assert(optCodec.encode(None) == List("NULL"))
    assert(optCodec.decode(List("42")) == Some(42))
    assert(optCodec.decode(List("NULL")) == None)
    println("Exercise 7 passed: optional codec")

    // Exercise 8
    val raw = List(Map[String, Any]("id" -> 1, "name" -> "Alice", "age" -> 30))
    val codec = List(List("1", "Alice", "30"))
    assert(exercise8_compareStyles(raw, codec))
    println("Exercise 8 passed: Doobie vs Skunk comparison")

    println("\nAll Doob011_SkunkBasics exercises passed!")
  }
}
