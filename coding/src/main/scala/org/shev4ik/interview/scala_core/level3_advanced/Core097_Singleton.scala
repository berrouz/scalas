package org.shev4ik.interview.scala_core.level3_advanced

object Core097_Singleton {

  // Exercise 1: Singleton types
  // TODO: Demonstrate singleton types using Witness pattern.
  //       In Scala 2, we use val.type for object singletons.
  //       Literal type parameters (x: 42) require Scala 3; in Scala 2 we use ValueOf.
  def acceptOnly42(x: Int): Int = ???

  // Exercise 2: .type syntax
  // TODO: Use .type to create a singleton type for an object
  object MyToken
  def acceptToken(token: MyToken.type): String = ???

  // Exercise 3: Singleton types for type-safe API
  // TODO: Use sealed trait + case objects for type-safe HTTP methods
  sealed trait HttpMethod { def name: String }
  case object GET extends HttpMethod { val name = "GET" }
  case object POST extends HttpMethod { val name = "POST" }

  trait HttpExecutor[M <: HttpMethod] {
    def execute(url: String): String
  }

  implicit val getExecutor: HttpExecutor[GET.type] = ???
  implicit val postExecutor: HttpExecutor[POST.type] = ???

  def request[M <: HttpMethod](method: M, url: String)(implicit hm: HttpExecutor[M]): String = ???

  // Exercise 4: Singleton type evidence
  // TODO: Use singleton types as evidence in type-level programming
  trait ValueOf[T] {
    def value: T
  }

  implicit val valueOf42: ValueOf[Int] = new ValueOf[Int] { def value: Int = 42 }
  implicit val valueOfHello: ValueOf[String] = new ValueOf[String] { def value: String = "hello" }

  def valueOf[T](implicit v: ValueOf[T]): T = ???

  // Exercise 5: Singleton for type-level
  // TODO: Use singleton types for type-level natural numbers
  trait Nat
  class Zero extends Nat
  class Succ[N <: Nat] extends Nat

  type _0 = Zero
  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]

  trait ToInt[N <: Nat] {
    def value: Int
  }

  implicit val zeroToInt: ToInt[_0] = ???
  implicit def succToInt[N <: Nat](implicit prev: ToInt[N]): ToInt[Succ[N]] = ???

  def natToInt[N <: Nat](implicit ti: ToInt[N]): Int = ???

  // Exercise 6: Witness concept (Shapeless-like)
  // TODO: Define a Witness-like type that carries a singleton value at type level
  trait Witness {
    type T
    val value: T
  }

  object Witness {
    type Aux[T0] = Witness { type T = T0 }

    def apply[T0](v: T0): Witness.Aux[T0] = ???
  }

  // Exercise 7: Singleton in pattern match
  // TODO: Use singleton types in pattern matching for type-safe dispatch
  sealed trait Command
  case object Start extends Command
  case object Stop extends Command
  case object Pause extends Command

  def executeCommand(cmd: Command): String = ???

  // For singleton object matching with .type
  def isStart(cmd: Command): Boolean = ???

  // Exercise 8: Singleton type with value classes
  // TODO: Create a type-safe ID system using singleton types
  class TypedId[Entity](val id: Long) extends AnyVal {
    override def toString: String = s"Id($id)"
  }

  object TypedId {
    def apply[E](id: Long): TypedId[E] = new TypedId[E](id)
  }

  // Entities
  trait UserEntity
  trait OrderEntity

  // TODO: Write type-safe lookup
  def lookupUser(id: TypedId[UserEntity], users: Map[Long, String]): Option[String] = ???
  def lookupOrder(id: TypedId[OrderEntity], orders: Map[Long, String]): Option[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(acceptOnly42(42) == 42)

    // Exercise 2
    assert(acceptToken(MyToken) == "valid token")

    // Exercise 3
    assert(request(GET, "/api/users") == "GET /api/users")
    assert(request(POST, "/api/users") == "POST /api/users")

    // Exercise 4
    assert(valueOf[Int] == 42)
    assert(valueOf[String] == "hello")

    // Exercise 5
    assert(natToInt[_0] == 0)
    assert(natToInt[_1] == 1)
    assert(natToInt[_2] == 2)
    assert(natToInt[_3] == 3)

    // Exercise 6
    val w = Witness(42)
    assert(w.value == 42)

    // Exercise 7
    assert(executeCommand(Start) == "Starting...")
    assert(executeCommand(Stop) == "Stopping...")
    assert(executeCommand(Pause) == "Pausing...")
    assert(isStart(Start) == true)
    assert(isStart(Stop) == false)

    // Exercise 8
    val userId = TypedId[UserEntity](1L)
    val orderId = TypedId[OrderEntity](1L)
    val users = Map(1L -> "Alice", 2L -> "Bob")
    val orders = Map(1L -> "Order#1")
    assert(lookupUser(userId, users) == Some("Alice"))
    assert(lookupOrder(orderId, orders) == Some("Order#1"))
    // TypedId[UserEntity] and TypedId[OrderEntity] are different types!

    println("All Core097_Singleton exercises passed!")
  }
}
