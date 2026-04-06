package org.shev4ik.interview.scala_core.level3_advanced

object Core086_MagnetPattern {

  // Exercise 1: Magnet trait
  // TODO: Define a magnet trait for a `complete` method that can accept
  //       different types (String, Int, List[String])
  trait CompletionMagnet {
    type Result
    def apply(): Result
  }

  // Exercise 2: Implicit conversion to magnet
  // TODO: Implement implicit conversions from String, Int, and List[String] to CompletionMagnet
  object CompletionMagnet {
    implicit def fromString(s: String): CompletionMagnet = ???

    implicit def fromInt(i: Int): CompletionMagnet = ???

    implicit def fromStringList(list: List[String]): CompletionMagnet = ???
  }

  // TODO: Define the `complete` method that takes a magnet
  def complete(magnet: CompletionMagnet): magnet.Result = ???

  // Exercise 3: Overloading with magnets
  // TODO: Define a `format` magnet that handles different input types
  //       avoiding type erasure issues that regular overloading would have
  trait FormatMagnet {
    def apply(): String
  }

  object FormatMagnet {
    // These would cause erasure issues with regular overloading:
    // def format(list: List[Int]): String
    // def format(list: List[String]): String

    // TODO: Implement magnets for List[Int] and List[String]
    implicit def fromIntList(list: List[Int]): FormatMagnet = ???
    implicit def fromStringList(list: List[String]): FormatMagnet = ???
  }

  def format(magnet: FormatMagnet): String = ???

  // Exercise 4: Magnet vs overloading
  // TODO: Show the traditional overloading approach (which has limitations)
  //       and the magnet alternative
  object TraditionalOverloading {
    def process(s: String): String = s"String: $s"
    def process(i: Int): String = s"Int: $i"
    // Cannot add: def process(list: List[Int]) and def process(list: List[String])
    // due to type erasure
  }

  trait ProcessMagnet {
    def apply(): String
  }

  object ProcessMagnet {
    implicit def fromString(s: String): ProcessMagnet = ???
    implicit def fromInt(i: Int): ProcessMagnet = ???
    implicit def fromIntList(list: List[Int]): ProcessMagnet = ???
    implicit def fromStringList(list: List[String]): ProcessMagnet = ???
  }

  def process(magnet: ProcessMagnet): String = ???

  // Exercise 5: Type erasure workaround
  // TODO: Demonstrate that the magnet pattern solves the type erasure problem
  //       for methods that would otherwise have the same erasure
  trait HandleMagnet {
    def apply(): String
  }

  object HandleMagnet {
    implicit def handleOptInt(opt: Option[Int]): HandleMagnet = ???
    implicit def handleOptStr(opt: Option[String]): HandleMagnet = ???
  }

  def handle(magnet: HandleMagnet): String = ???

  // Exercise 6: Spray-style magnet (simplified)
  // TODO: Implement a route-like magnet pattern similar to Spray/Akka HTTP
  trait RouteMagnet {
    def apply(): String
  }

  object RouteMagnet {
    implicit def fromPath(path: String): RouteMagnet = ???
    implicit def fromPathAndMethod(pm: (String, String)): RouteMagnet = ???
  }

  def route(magnet: RouteMagnet): String = ???

  // Exercise 7: Magnet for API design
  // TODO: Create a `send` method using magnets that can send different message types
  trait SendMagnet {
    type Response
    def apply(): Response
  }

  object SendMagnet {
    implicit def sendString(msg: String): SendMagnet { type Response = Int } = ???
    implicit def sendBytes(bytes: Array[Byte]): SendMagnet { type Response = Boolean } = ???
  }

  def send(magnet: SendMagnet): magnet.Response = ???

  // Exercise 8: Magnet limitations
  // TODO: Show a limitation: magnets make code harder to understand.
  //       Implement a simple version and a magnet version, showing the tradeoff.

  // Simple version - clear but limited
  def simpleLog(message: String): String = s"LOG: $message"

  // Magnet version - flexible but complex
  trait LogMagnet {
    def apply(): String
  }

  object LogMagnet {
    implicit def fromString(s: String): LogMagnet = ???
    implicit def fromThrowable(t: Throwable): LogMagnet = ???
    implicit def fromTuple(t: (String, Throwable)): LogMagnet = ???
  }

  def log(magnet: LogMagnet): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1-2
    import CompletionMagnet._
    val r1: String = complete("hello").asInstanceOf[String]
    assert(r1 == "hello")

    // Exercise 3
    import FormatMagnet._
    assert(format(List(1, 2, 3)) == "[1, 2, 3]")
    assert(format(List("a", "b")) == "[a, b]")

    // Exercise 4
    import ProcessMagnet._
    assert(process("hello") == "String: hello")
    assert(process(42) == "Int: 42")
    assert(process(List(1, 2)) == "IntList: [1, 2]")
    assert(process(List("a", "b")) == "StringList: [a, b]")

    // Exercise 5
    import HandleMagnet._
    assert(handle(Some(42): Option[Int]) == "OptInt: 42")
    assert(handle(Some("hi"): Option[String]) == "OptStr: hi")
    assert(handle(None: Option[Int]) == "OptInt: None")

    // Exercise 6
    import RouteMagnet._
    assert(route("/api/users").contains("/api/users"))
    assert(route(("/api/users", "GET")).contains("GET"))

    // Exercise 7
    import SendMagnet._
    val sentLength: Int = send("hello message").asInstanceOf[Int]
    assert(sentLength == 13)

    // Exercise 8
    import LogMagnet._
    assert(log("test message") == "LOG: test message")
    assert(log(new RuntimeException("oops")).contains("oops"))

    println("All Core086_MagnetPattern exercises passed!")
  }
}
