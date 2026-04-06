package org.shev4ik.interview.scala_core.level3_advanced

object Core083_TypeSafeBuilder {

  // Phantom types for tracking builder state
  sealed trait Unset
  sealed trait Set

  // Exercise 1: Builder with phantom types
  // TODO: Define a HttpRequestBuilder with phantom type parameters tracking
  //       which required fields have been set: URL, Method
  case class HttpRequestBuilder[HasUrl, HasMethod] private (
    url: Option[String],
    method: Option[String],
    headers: Map[String, String],
    body: Option[String]
  )

  object HttpRequestBuilder {
    // TODO: Create initial builder with all fields Unset
    def apply(): HttpRequestBuilder[Unset, Unset] = ???
  }

  // Exercise 2: Step-by-step builder
  // TODO: Implement `withUrl` that transitions HasUrl from Unset to Set
  implicit class UrlStep[HasMethod](val builder: HttpRequestBuilder[Unset, HasMethod]) extends AnyVal {
    def withUrl(url: String): HttpRequestBuilder[Set, HasMethod] = ???
  }

  // TODO: Implement `withMethod` that transitions HasMethod from Unset to Set
  implicit class MethodStep[HasUrl](val builder: HttpRequestBuilder[HasUrl, Unset]) extends AnyVal {
    def withMethod(method: String): HttpRequestBuilder[HasUrl, Set] = ???
  }

  // Exercise 3: Mandatory fields at type level
  // TODO: Implement `build` that only works when BOTH URL and Method are Set
  implicit class BuildStep(val builder: HttpRequestBuilder[Set, Set]) extends AnyVal {
    def build: HttpRequest = ???
  }

  case class HttpRequest(url: String, method: String, headers: Map[String, String], body: Option[String])

  // Exercise 4: Optional fields
  // TODO: Implement `withHeader` and `withBody` that work regardless of builder state
  implicit class OptionalFields[HasUrl, HasMethod](val builder: HttpRequestBuilder[HasUrl, HasMethod]) extends AnyVal {
    def withHeader(key: String, value: String): HttpRequestBuilder[HasUrl, HasMethod] = ???
    def withBody(body: String): HttpRequestBuilder[HasUrl, HasMethod] = ???
  }

  // Exercise 5: Builder validation at compile time
  // TODO: Create a type-safe pizza builder where Size is mandatory before building
  sealed trait HasSize
  sealed trait NoSize

  case class PizzaBuilder[S] private (
    size: Option[String],
    toppings: List[String],
    crust: Option[String]
  )

  object PizzaBuilder {
    def apply(): PizzaBuilder[NoSize] = ???
  }

  implicit class PizzaSizeStep(val b: PizzaBuilder[NoSize]) extends AnyVal {
    def withSize(size: String): PizzaBuilder[HasSize] = ???
  }

  implicit class PizzaOptionals[S](val b: PizzaBuilder[S]) extends AnyVal {
    def withTopping(topping: String): PizzaBuilder[S] = ???
    def withCrust(crust: String): PizzaBuilder[S] = ???
  }

  case class Pizza(size: String, toppings: List[String], crust: Option[String])

  implicit class PizzaBuildStep(val b: PizzaBuilder[HasSize]) extends AnyVal {
    def build: Pizza = ???
  }

  // Exercise 6: Fluent API
  // TODO: Create a type-safe email builder: From and To are required
  sealed trait HasFrom
  sealed trait NoFrom
  sealed trait HasTo
  sealed trait NoTo

  case class EmailBuilder[F, T] private (
    from: Option[String],
    to: Option[String],
    subject: Option[String],
    body: Option[String]
  )

  object EmailBuilder {
    def apply(): EmailBuilder[NoFrom, NoTo] = ???
  }

  implicit class EmailFromStep[T](val b: EmailBuilder[NoFrom, T]) extends AnyVal {
    def from(addr: String): EmailBuilder[HasFrom, T] = ???
  }

  implicit class EmailToStep[F](val b: EmailBuilder[F, NoTo]) extends AnyVal {
    def to(addr: String): EmailBuilder[F, HasTo] = ???
  }

  implicit class EmailOptionalStep[F, T](val b: EmailBuilder[F, T]) extends AnyVal {
    def subject(s: String): EmailBuilder[F, T] = ???
    def bodyText(s: String): EmailBuilder[F, T] = ???
  }

  case class Email(from: String, to: String, subject: Option[String], body: Option[String])

  implicit class EmailBuildStep(val b: EmailBuilder[HasFrom, HasTo]) extends AnyVal {
    def build: Email = ???
  }

  // Exercise 7: Type-safe config builder
  // TODO: Create a config builder where host and port are required
  case class ServerConfig(host: String, port: Int, maxConnections: Int, timeout: Int)

  // TODO: Implement with phantom types (simplified: just show the final build method)
  def buildConfig(host: String, port: Int, maxConn: Int = 100, timeout: Int = 30): ServerConfig = ???

  // Exercise 8: HList-based builder concept
  // TODO: Demonstrate the concept of accumulating fields in a type-level list
  //       Use a simple chain of nested tuples to simulate
  trait FieldChain[Fields] {
    def fields: Fields
  }

  case class EmptyChain() extends FieldChain[Unit] {
    def fields: Unit = ()
    def add[V](value: V): FilledChain[V, Unit] = ???
  }

  case class FilledChain[H, T](head: H, tail: T) extends FieldChain[(H, T)] {
    def fields: (H, T) = (head, tail)
    def add[V](value: V): FilledChain[V, (H, T)] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1-3
    val request = HttpRequestBuilder()
      .withUrl("https://example.com")
      .withMethod("GET")
      .build
    assert(request.url == "https://example.com")
    assert(request.method == "GET")

    // Exercise 4
    val request2 = HttpRequestBuilder()
      .withUrl("https://example.com")
      .withHeader("Auth", "Bearer token")
      .withMethod("POST")
      .withBody("""{"key":"value"}""")
      .build
    assert(request2.headers == Map("Auth" -> "Bearer token"))
    assert(request2.body.contains("""{"key":"value"}"""))

    // Exercise 5
    val pizza = PizzaBuilder()
      .withSize("Large")
      .withTopping("Cheese")
      .withTopping("Pepperoni")
      .withCrust("Thin")
      .build
    assert(pizza.size == "Large")
    assert(pizza.toppings == List("Cheese", "Pepperoni"))

    // Exercise 6
    val email = EmailBuilder()
      .from("alice@test.com")
      .to("bob@test.com")
      .subject("Hello")
      .build
    assert(email.from == "alice@test.com")
    assert(email.to == "bob@test.com")

    // Exercise 7
    val config = buildConfig("localhost", 8080)
    assert(config.host == "localhost")
    assert(config.port == 8080)

    // Exercise 8
    val chain = EmptyChain().add("hello").add(42)
    assert(chain.head == 42)
    assert(chain.tail == ("hello", ()))

    println("All Core083_TypeSafeBuilder exercises passed!")
  }
}
