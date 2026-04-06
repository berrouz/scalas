package org.shev4ik.interview.scala3.level2_intermediate

/**
 * Scala 3: export clauses, open classes, and parameter untupling
 * (modeled conceptually in Scala 2.13)
 *
 * Scala 3 introduces:
 *   - `export` clauses to selectively re-export members of an object
 *   - `open` modifier for classes intended to be extended
 *   - Parameter untupling: `xs.map((a, b) => a + b)` instead of `xs.map { case (a, b) => a + b }`
 * In Scala 2.13, we model these patterns with delegation, documentation, and partial functions.
 */
object Sc3_010_ExportAndOpen {

  // Exercise 1: Export clause basics (Scala 3: export obj.{member1, member2})
  // In Scala 3, export allows re-exporting members without inheritance.
  // In Scala 2, we achieve this with explicit delegation methods.
  // TODO: Given an inner `MathUtils` object with methods `add`, `multiply`, `power`,
  //       create delegation methods that "export" add and multiply (but NOT power).
  //       This models: export MathUtils.{add, multiply}
  object MathUtils {
    def add(a: Int, b: Int): Int = a + b
    def multiply(a: Int, b: Int): Int = a * b
    def power(base: Int, exp: Int): Int = Math.pow(base, exp).toInt
  }
  def exercise1_add(a: Int, b: Int): Int = ???
  def exercise1_multiply(a: Int, b: Int): Int = ???
  // power is intentionally NOT exported

  // Exercise 2: Export with renaming (Scala 3: export obj.{member as alias})
  // In Scala 3: export mathUtils.{add as plus, multiply as times}
  // TODO: Create delegation methods with renamed exports.
  //       `plus` delegates to MathUtils.add, `times` delegates to MathUtils.multiply.
  def exercise2_plus(a: Int, b: Int): Int = ???
  def exercise2_times(a: Int, b: Int): Int = ???

  // Exercise 3: Export for composition over inheritance
  // In Scala 3, export is the idiomatic way to do composition.
  // TODO: Create a `Database` class with methods `query(sql: String): List[String]` and `execute(sql: String): Int`.
  //       Create a `Service` class that contains a Database and exports only `query`.
  //       This models: class Service(db: Database) { export db.query }
  class Database {
    private var data: Map[String, List[String]] = Map(
      "users" -> List("Alice", "Bob", "Charlie")
    )
    def query(table: String): List[String] = data.getOrElse(table, Nil)
    def execute(sql: String): Int = { /* simulated */ 1 }
  }
  class Service(db: Database) {
    def query(table: String): List[String] = ???  // TODO: delegate to db.query
    // execute is intentionally NOT exported
  }
  def exercise3_serviceQuery: List[String] = ???

  // Exercise 4: Open classes (Scala 3: open class Base)
  // In Scala 3, only `open` classes can be extended in other files.
  // Non-open classes give a warning if extended outside their file.
  // In Scala 2, all non-final classes can be extended.
  // TODO: Document the concept by implementing:
  //       - A class `OpenBase` (intended to be extended) with method `greet: String`
  //       - A `final class ClosedBase` (cannot be extended) with method `greet: String`
  //       - A class `ExtendedBase` extending `OpenBase` overriding `greet`
  //       Answer: What is the default in Scala 3 — open or closed?
  class OpenBase {
    def greet: String = "Hello from OpenBase"
  }
  final class ClosedBase {
    def greet: String = "Hello from ClosedBase"
  }
  class ExtendedBase extends OpenBase {
    override def greet: String = ???  // TODO: Return "Hello from ExtendedBase"
  }
  def exercise4_defaultAnswer: String = ???  // TODO: "Closed (non-open) — extending gives a warning unless marked open"

  // Exercise 5: Parameter untupling (Scala 3 automatic)
  // Scala 3: List((1, "a"), (2, "b")).map((n, s) => s"$n:$s")
  // Scala 2: List((1, "a"), (2, "b")).map { case (n, s) => s"$n:$s" }
  // TODO: Implement the following using Scala 2 tuple destructuring in lambdas:
  //       - `formatPairs` that takes List[(Int, String)] and returns List[String] as "n:s"
  //       - `sumPairs` that takes List[(Int, Int)] and returns the list of sums
  //       - `filterBySecond` that takes List[(String, Int)] and a predicate on Int, returns filtered list
  def exercise5_formatPairs(pairs: List[(Int, String)]): List[String] = ???
  def exercise5_sumPairs(pairs: List[(Int, Int)]): List[Int] = ???
  def exercise5_filterBySecond(pairs: List[(String, Int)])(pred: Int => Boolean): List[(String, Int)] = ???

  // Exercise 6: Export wildcard (Scala 3: export obj.*)
  // In Scala 3: export obj.* re-exports all members.
  // In Scala 2, model by creating a wrapper that delegates all methods.
  // TODO: Create a `StringUtils` object with methods: `capitalize`, `reverse`, `wordCount`.
  //       Create a `TextProcessor` class that "exports all" from StringUtils by delegating all methods.
  object StringUtils {
    def capitalize(s: String): String = if (s.isEmpty) s else s.head.toUpper + s.tail
    def reverse(s: String): String = s.reverse
    def wordCount(s: String): Int = if (s.trim.isEmpty) 0 else s.trim.split("\\s+").length
  }
  class TextProcessor {
    def capitalize(s: String): String = ???  // TODO: delegate
    def reverse(s: String): String = ???     // TODO: delegate
    def wordCount(s: String): Int = ???      // TODO: delegate
  }
  def exercise6_testProcessor: (String, String, Int) = ???

  // Exercise 7: Export with exclusion (Scala 3: export obj.{excluded as _, *})
  // In Scala 3, you can export all except certain members.
  // TODO: Create a `FullApi` object with methods: `publicMethod`, `internalMethod`, `debugMethod`.
  //       Create a `SafeApi` that exports all except `debugMethod`.
  //       Answer: What Scala 3 syntax excludes a member from export?
  object FullApi {
    def publicMethod: String = "public"
    def internalMethod: String = "internal"
    def debugMethod: String = "debug"
  }
  object SafeApi {
    def publicMethod: String = ???    // TODO: delegate
    def internalMethod: String = ???  // TODO: delegate
    // debugMethod intentionally excluded
  }
  def exercise7_exclusionSyntax: String = ???  // TODO: "export obj.{excluded as _, *}"

  // Exercise 8: Combining concepts — module pattern with export
  // TODO: Create a mini application module pattern:
  //       - `UserRepository` with `findUser(id: Int): Option[String]` and `saveUser(id: Int, name: String): Unit`
  //       - `UserService` that holds a UserRepository and exports only `findUser` (read-only access)
  //       - `AdminService` that holds a UserRepository and exports both methods
  //       Demonstrate the difference: service can only read, admin can read and write.
  class UserRepository {
    private var users: Map[Int, String] = Map(1 -> "Alice", 2 -> "Bob")
    def findUser(id: Int): Option[String] = users.get(id)
    def saveUser(id: Int, name: String): Unit = { users = users + (id -> name) }
  }
  class UserService(repo: UserRepository) {
    def findUser(id: Int): Option[String] = ???  // TODO: delegate
  }
  class AdminService(repo: UserRepository) {
    def findUser(id: Int): Option[String] = ???  // TODO: delegate
    def saveUser(id: Int, name: String): Unit = ???  // TODO: delegate
  }
  def exercise8_readOnly: Option[String] = ???
  def exercise8_adminSave: Option[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_add(3, 4) == 7, "Exercise 1 add failed")
    assert(exercise1_multiply(3, 4) == 12, "Exercise 1 multiply failed")

    // Exercise 2
    assert(exercise2_plus(3, 4) == 7, "Exercise 2 plus failed")
    assert(exercise2_times(3, 4) == 12, "Exercise 2 times failed")

    // Exercise 3
    assert(exercise3_serviceQuery == List("Alice", "Bob", "Charlie"), "Exercise 3 failed")

    // Exercise 4
    val ext = new ExtendedBase
    assert(ext.greet == "Hello from ExtendedBase", "Exercise 4 failed")
    assert(exercise4_defaultAnswer == "Closed (non-open) — extending gives a warning unless marked open", "Exercise 4 answer failed")

    // Exercise 5
    assert(exercise5_formatPairs(List((1, "a"), (2, "b"))) == List("1:a", "2:b"), "Exercise 5 format failed")
    assert(exercise5_sumPairs(List((1, 2), (3, 4))) == List(3, 7), "Exercise 5 sum failed")
    assert(exercise5_filterBySecond(List(("a", 1), ("b", 5), ("c", 3)))(_ > 2) == List(("b", 5), ("c", 3)), "Exercise 5 filter failed")

    // Exercise 6
    val (cap, rev, wc) = exercise6_testProcessor
    assert(cap == "Hello", "Exercise 6 capitalize failed")
    assert(rev == "olleh", "Exercise 6 reverse failed")
    assert(wc == 2, "Exercise 6 wordCount failed")

    // Exercise 7
    assert(SafeApi.publicMethod == "public", "Exercise 7 public failed")
    assert(SafeApi.internalMethod == "internal", "Exercise 7 internal failed")
    assert(exercise7_exclusionSyntax == "export obj.{excluded as _, *}", "Exercise 7 syntax failed")

    // Exercise 8
    assert(exercise8_readOnly == Some("Alice"), "Exercise 8 read failed")
    assert(exercise8_adminSave == Some("Charlie"), "Exercise 8 admin failed")

    println("All Sc3_010_ExportAndOpen exercises passed!")
  }
}
