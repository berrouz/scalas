package org.shev4ik.interview.scala3.level2_intermediate

/**
 * Scala 3: Context Functions and Cleaner DSLs
 * (modeled with implicit parameters and builder patterns in Scala 2.13)
 *
 * In Scala 3, context function types `A ?=> B` are function types with implicit parameters.
 * They enable cleaner DSL patterns where context is threaded automatically.
 * In Scala 2.13, we model these using explicit implicit parameter passing.
 */
object Sc3_009_ContextFunctions {

  // === Setup ===
  case class ExecutionContext(name: String, timeout: Int)
  case class Transaction(id: String, var operations: List[String])
  case class HtmlBuilder(var content: List[String])

  // Exercise 1: Basic context function (Scala 3: ExecutionContext ?=> A)
  // In Scala 3: type Executable[A] = ExecutionContext ?=> A
  // In Scala 2, model as a function that takes an implicit ExecutionContext.
  // TODO: Define type `Executable[A]` as `ExecutionContext => A`.
  //       Implement `runTask` that creates an ExecutionContext and applies the function.
  //       Implement `currentContextName` as an Executable[String] returning the context name.
  type Executable[A] = ExecutionContext => A
  val exercise1_currentContextName: Executable[String] = ???
  def exercise1_runTask[A](name: String, timeout: Int)(task: Executable[A]): A = ???

  // Exercise 2: Context function for transaction DSL
  // Scala 3: type Transactional[A] = Transaction ?=> A
  // TODO: Implement a transaction DSL:
  //       - `inTransaction(id: String)(block: Transaction => A): (A, List[String])` — runs block with a transaction
  //       - `addOp(op: String)(implicit tx: Transaction): Unit` — adds an operation to the transaction (model as tx => ...)
  //       The block receives the transaction and should use `addOp`.
  def exercise2_inTransaction[A](id: String)(block: Transaction => A): (A, List[String]) = ???
  def exercise2_addOp(tx: Transaction, op: String): Unit = ???

  // Exercise 3: Nested context functions (multiple implicit contexts)
  // Scala 3: (using ctx: Ctx) ?=> (using log: Logger) ?=> A
  // TODO: Model nested contexts with a Logger and Database.
  //       Implement `withLogging[A](block: Logger => A): (A, List[String])` that captures log messages.
  //       Implement `logMessage(msg: String)(logger: Logger): Unit`.
  case class Logger(var messages: List[String])
  def exercise3_withLogging[A](block: Logger => A): (A, List[String]) = ???
  def exercise3_logMessage(logger: Logger, msg: String): Unit = ???

  // Exercise 4: HTML builder DSL (classic use case for context functions)
  // Scala 3: def html(init: HtmlBuilder ?=> Unit): String
  // TODO: Implement an HTML builder DSL:
  //       - `html(block: HtmlBuilder => Unit): String` — wraps content in <html>...</html>
  //       - `body(block: HtmlBuilder => Unit)(builder: HtmlBuilder): Unit` — wraps in <body>...</body>
  //       - `p(text: String)(builder: HtmlBuilder): Unit` — adds <p>text</p>
  //       - `h1(text: String)(builder: HtmlBuilder): Unit` — adds <h1>text</h1>
  def exercise4_html(block: HtmlBuilder => Unit): String = ???
  def exercise4_body(builder: HtmlBuilder)(block: HtmlBuilder => Unit): Unit = ???
  def exercise4_p(builder: HtmlBuilder, text: String): Unit = ???
  def exercise4_h1(builder: HtmlBuilder, text: String): Unit = ???

  // Exercise 5: Context function for configuration DSL
  // TODO: Implement a configuration builder:
  //       case class ConfigBuilder(var entries: Map[String, String])
  //       `configure(block: ConfigBuilder => Unit): Map[String, String]` — runs block and returns entries
  //       `set(key: String, value: String)(cb: ConfigBuilder): Unit` — adds an entry
  //       `setIfAbsent(key: String, value: String)(cb: ConfigBuilder): Unit` — adds only if key missing
  case class ConfigBuilder(var entries: Map[String, String])
  def exercise5_configure(block: ConfigBuilder => Unit): Map[String, String] = ???
  def exercise5_set(cb: ConfigBuilder, key: String, value: String): Unit = ???
  def exercise5_setIfAbsent(cb: ConfigBuilder, key: String, value: String): Unit = ???

  // Exercise 6: Context function for test assertions DSL
  // TODO: Implement a test DSL:
  //       case class TestContext(name: String, var results: List[(String, Boolean)])
  //       `test(name: String)(block: TestContext => Unit): List[(String, Boolean)]` — runs tests
  //       `check(label: String, condition: Boolean)(tc: TestContext): Unit` — records a check
  //       `checkEqual[A](label: String, actual: A, expected: A)(tc: TestContext): Unit` — records equality check
  case class TestContext(name: String, var results: List[(String, Boolean)])
  def exercise6_test(name: String)(block: TestContext => Unit): List[(String, Boolean)] = ???
  def exercise6_check(tc: TestContext, label: String, condition: Boolean): Unit = ???
  def exercise6_checkEqual[A](tc: TestContext, label: String, actual: A, expected: A): Unit = ???

  // Exercise 7: Composing context functions
  // Scala 3 allows composing context functions naturally.
  // TODO: Implement `pipe` that composes two context-aware functions:
  //       `pipe[Ctx, A, B](f: Ctx => A, g: (Ctx, A) => B): Ctx => B`
  //       Implement `withBoth[A](block: (Logger, Transaction) => A): A`
  //       that provides both a Logger and Transaction to a block.
  def exercise7_pipe[Ctx, A, B](f: Ctx => A, g: (Ctx, A) => B): Ctx => B = ???
  def exercise7_withBoth[A](block: (Logger, Transaction) => A): A = ???

  // Exercise 8: Real-world pattern — Repository with context
  // TODO: Model a repository that uses a context function pattern:
  //       trait Repository[A] { def save(a: A)(implicit tx: Transaction): Unit; def find(id: String)(implicit tx: Transaction): Option[A] }
  //       Implement `InMemoryRepo` for `Person(id: String, name: String)`.
  //       Implement `exercise8_runWithRepo` that creates a transaction, performs operations, and returns results.
  case class PersonEntity(id: String, name: String)
  trait Repository[A] {
    def save(a: A)(tx: Transaction): Unit
    def findById(id: String)(tx: Transaction): Option[A]
  }
  def exercise8_makePersonRepo: Repository[PersonEntity] = ???
  def exercise8_runWithRepo(repo: Repository[PersonEntity]): Option[PersonEntity] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val name = exercise1_runTask("main", 5000)(exercise1_currentContextName)
    assert(name == "main", "Exercise 1 failed")

    // Exercise 2
    val (result, ops) = exercise2_inTransaction("tx-1") { tx =>
      exercise2_addOp(tx, "INSERT user")
      exercise2_addOp(tx, "UPDATE balance")
      "done"
    }
    assert(result == "done", "Exercise 2 result failed")
    assert(ops == List("INSERT user", "UPDATE balance"), "Exercise 2 ops failed")

    // Exercise 3
    val (logResult, msgs) = exercise3_withLogging { logger =>
      exercise3_logMessage(logger, "start")
      exercise3_logMessage(logger, "end")
      42
    }
    assert(logResult == 42, "Exercise 3 result failed")
    assert(msgs == List("start", "end"), "Exercise 3 messages failed")

    // Exercise 4
    val htmlStr = exercise4_html { builder =>
      exercise4_body(builder) { b =>
        exercise4_h1(b, "Hello")
        exercise4_p(b, "World")
      }
    }
    assert(htmlStr.contains("<html>"), "Exercise 4 should contain html tag")
    assert(htmlStr.contains("<h1>Hello</h1>"), "Exercise 4 should contain h1")
    assert(htmlStr.contains("<p>World</p>"), "Exercise 4 should contain p")

    // Exercise 5
    val config = exercise5_configure { cb =>
      exercise5_set(cb, "host", "localhost")
      exercise5_set(cb, "port", "8080")
      exercise5_setIfAbsent(cb, "host", "remote.com")  // should NOT overwrite
      exercise5_setIfAbsent(cb, "debug", "false")       // should add
    }
    assert(config("host") == "localhost", "Exercise 5 host failed")
    assert(config("debug") == "false", "Exercise 5 debug failed")
    assert(config.size == 3, "Exercise 5 size failed")

    // Exercise 6
    val results = exercise6_test("math tests") { tc =>
      exercise6_check(tc, "1+1=2", 1 + 1 == 2)
      exercise6_check(tc, "2*2=5", 2 * 2 == 5)
      exercise6_checkEqual(tc, "3+3", 3 + 3, 6)
    }
    assert(results.length == 3, "Exercise 6 should have 3 results")
    assert(results(0) == ("1+1=2", true), "Exercise 6 first check failed")
    assert(results(1) == ("2*2=5", false), "Exercise 6 second check failed")
    assert(results(2) == ("3+3", true), "Exercise 6 third check failed")

    // Exercise 7
    val composed: Logger => String = exercise7_pipe[Logger, Unit, String](
      logger => exercise3_logMessage(logger, "step1"),
      (logger, _) => { exercise3_logMessage(logger, "step2"); logger.messages.mkString(",") }
    )
    val testLogger = Logger(Nil)
    val composedResult = composed(testLogger)
    assert(composedResult == "step1,step2", "Exercise 7 pipe failed")

    // Exercise 8
    val repo = exercise8_makePersonRepo
    val found = exercise8_runWithRepo(repo)
    assert(found.contains(PersonEntity("1", "Alice")), "Exercise 8 failed")

    println("All Sc3_009_ContextFunctions exercises passed!")
  }
}
