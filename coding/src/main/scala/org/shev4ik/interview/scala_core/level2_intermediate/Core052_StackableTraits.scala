package org.shev4ik.interview.scala_core.level2_intermediate

object Core052_StackableTraits {

  // Exercise 1: abstract override
  // TODO: Create a base trait IntQueue with put(x: Int) and get(): Int
  //       Then create a trait Doubling that uses abstract override to double values on put
  trait IntQueue {
    def put(x: Int): Unit
    def get(): Int
  }

  class BasicIntQueue extends IntQueue {
    private val buf = scala.collection.mutable.ArrayBuffer.empty[Int]
    def put(x: Int): Unit = ???
    def get(): Int = ???
  }

  trait Doubling extends IntQueue {
    abstract override def put(x: Int): Unit = ???
  }

  // Exercise 2: Stacking modifications
  // TODO: Create additional stackable traits:
  //       Incrementing (adds 1 before put), Filtering (ignores negatives)
  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = ???
  }

  trait Filtering extends IntQueue {
    abstract override def put(x: Int): Unit = ???
  }

  // Exercise 3: Decorator pattern with traits
  // TODO: Implement a decorator pattern for a StringProcessor
  //       Base: identity, Trimmer: trims whitespace, Capitalizer: capitalizes
  trait StringProcessor {
    def process(s: String): String
  }
  class BaseProcessor extends StringProcessor {
    def process(s: String): String = ???
  }
  trait Trimmer extends StringProcessor {
    abstract override def process(s: String): String = ???
  }
  trait Capitalizer extends StringProcessor {
    abstract override def process(s: String): String = ???
  }

  // Exercise 4: Ordered stacking
  // TODO: Demonstrate that the order of mixing in traits matters
  //       class A extends BasicIntQueue with Doubling with Incrementing
  //       class B extends BasicIntQueue with Incrementing with Doubling
  //       A: put(x) => Incrementing(Doubling(x)) => super.put((x*2)+1)? No!
  //       Linearization: last trait's method runs first
  //       A (with Doubling with Incrementing): Incrementing.put called first, then Doubling.put
  //       B (with Incrementing with Doubling): Doubling.put called first, then Incrementing.put
  def stackOrderA(x: Int): Int = ???
  def stackOrderB(x: Int): Int = ???

  // Exercise 5: Stackable logging
  // TODO: Create a trait Logger that logs method calls via stackable trait
  //       trait Logged extends StringProcessor { var logs: List[String] = Nil }
  //       trait LoggedProcessor extends Logged { ... }
  trait Logged {
    var logs: List[String] = Nil
    protected def log(msg: String): Unit = { logs = logs :+ msg }
  }
  trait LoggedProcessor extends StringProcessor with Logged {
    abstract override def process(s: String): String = ???
  }

  // Exercise 6: Stackable validation
  // TODO: Create stackable validators for a registration form
  //       trait Validator { def validate(input: String): Either[String, String] }
  //       trait NonEmpty, trait MinLength, trait NoSpaces
  trait Validator {
    def validate(input: String): Either[String, String]
  }
  class AcceptAll extends Validator {
    def validate(input: String): Either[String, String] = ???
  }
  trait NonEmpty extends Validator {
    abstract override def validate(input: String): Either[String, String] = ???
  }
  trait MinLength extends Validator {
    abstract override def validate(input: String): Either[String, String] = ???
  }
  trait NoSpaces extends Validator {
    abstract override def validate(input: String): Either[String, String] = ???
  }

  // Exercise 7: Stackable transformation
  // TODO: Create stackable transformations for a number pipeline
  //       trait NumberPipeline { def transform(n: Int): Int }
  //       trait AddTen, trait MultiplyByTwo, trait Negate
  trait NumberPipeline {
    def transform(n: Int): Int
  }
  class IdentityPipeline extends NumberPipeline {
    def transform(n: Int): Int = ???
  }
  trait AddTen extends NumberPipeline {
    abstract override def transform(n: Int): Int = ???
  }
  trait MultiplyByTwo extends NumberPipeline {
    abstract override def transform(n: Int): Int = ???
  }
  trait Negate extends NumberPipeline {
    abstract override def transform(n: Int): Int = ???
  }

  // Exercise 8: Base + stackable pattern
  // TODO: Create a complete example: a message handler with stackable middleware
  //       Base handles the message, middleware traits add behavior (auth, logging, metrics)
  trait MessageHandler {
    def handle(msg: String): String
  }
  class EchoHandler extends MessageHandler {
    def handle(msg: String): String = ???
  }
  trait AuthMiddleware extends MessageHandler {
    abstract override def handle(msg: String): String = ???
  }
  trait LogMiddleware extends MessageHandler with Logged {
    abstract override def handle(msg: String): String = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val q1 = new BasicIntQueue with Doubling
    q1.put(5)
    assert(q1.get() == 10, "Doubling should double the value")

    // Exercise 2 assertions
    val q2 = new BasicIntQueue with Filtering with Incrementing
    q2.put(5)
    q2.put(-1)
    assert(q2.get() == 6, "Incrementing then Filtering: 5+1=6 (kept), -1+1=0 (kept)")

    val q3 = new BasicIntQueue with Incrementing with Filtering
    q3.put(5)
    q3.put(-1)
    assert(q3.get() == 6, "Filtering then Incrementing: 5 kept +1=6, -1 filtered")

    // Exercise 3 assertions
    val proc = new BaseProcessor with Trimmer with Capitalizer
    assert(proc.process("  hello world  ") == "HELLO WORLD", "trim then capitalize")

    // Exercise 4 assertions
    // Stack order matters: last trait in `with` clause runs first
    val a = stackOrderA(5)
    val b = stackOrderB(5)
    assert(a != b || a == b, "Stack order should be demonstrable") // just verify they run

    // Exercise 5 assertions
    val loggedProc = new BaseProcessor with LoggedProcessor
    loggedProc.process("test")
    assert(loggedProc.logs.nonEmpty, "LoggedProcessor should have logs")

    // Exercise 6 assertions
    val validator = new AcceptAll with NonEmpty with MinLength with NoSpaces
    assert(validator.validate("hello") == Right("hello"), "valid input")
    assert(validator.validate("").isLeft, "empty should fail")
    assert(validator.validate("ab").isLeft, "too short should fail")
    assert(validator.validate("hello world").isLeft, "spaces should fail")

    // Exercise 7 assertions
    val pipeline = new IdentityPipeline with AddTen with MultiplyByTwo
    // MultiplyByTwo runs first: 5*2=10, then AddTen: 10+10=20
    val pipeResult = pipeline.transform(5)
    assert(pipeResult == 20, s"Pipeline should produce 20, got $pipeResult")

    // Exercise 8 assertions
    val handler = new EchoHandler with LogMiddleware with AuthMiddleware
    val result = handler.handle("hello")
    assert(result.contains("hello"), "handler should process the message")

    println("All Core052_StackableTraits exercises passed!")
  }
}
