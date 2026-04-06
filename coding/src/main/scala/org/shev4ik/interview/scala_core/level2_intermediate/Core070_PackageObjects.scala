package org.shev4ik.interview.scala_core.level2_intermediate

object Core070_PackageObjects {

  // NOTE: Package objects are defined as `package object <name>` in a file,
  // typically named package.scala in the corresponding directory.
  // Since we're demonstrating the concept inside an object, we simulate
  // what would normally go in a package object.

  // Exercise 1: Package object concept
  // TODO: Simulate a package object by creating an object that holds
  //       package-wide type aliases and implicit conversions.
  //       In a real package object, these would be available to all files in the package.
  //       Create type aliases: type UserId = Long, type UserName = String
  //       Create a helper method: def createUser(id: UserId, name: UserName): (UserId, UserName)
  type UserId = Long
  type UserName = String

  def createUser(id: UserId, name: UserName): (UserId, UserName) = ???

  // Exercise 2: Implicit in package object
  // TODO: In a package object, implicits are available throughout the package.
  //       Simulate by defining implicit conversions and classes here.
  //       Create an implicit class RichUserId that adds `isValid: Boolean` to UserId (Long)
  implicit class RichUserId(val id: UserId) extends AnyVal {
    def isValid: Boolean = ???
  }

  // TODO: Create an implicit Ordering for (UserId, UserName) tuples, ordering by UserId
  implicit val userOrdering: Ordering[(UserId, UserName)] = ???

  // Exercise 3: Type alias in package & Constants in package object
  // TODO: Define type aliases and constants that would be package-wide
  //       type Result[A] = Either[String, A]
  //       val MaxRetries = 3
  //       val DefaultTimeout = 5000L
  type Result[A] = Either[String, A]
  val MaxRetries: Int = 3
  val DefaultTimeout: Long = 5000L

  def retry[A](n: Int = MaxRetries)(f: => Result[A]): Result[A] = ???

  // Exercise 4: Package-wide imports
  // TODO: Demonstrate what would be achieved with package-wide imports
  //       In a package object, you can re-export commonly used types/values
  //       so all files in the package can use them without explicit imports.
  //       Simulate by creating a "prelude" object with common utilities
  object Prelude {
    type IO[A] = Either[Throwable, A]

    def succeed[A](a: A): IO[A] = ???
    def fail[A](error: String): IO[A] = ???

    def attempt[A](f: => A): IO[A] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val user = createUser(1L, "Alice")
    assert(user == (1L, "Alice"), "createUser should return tuple")
    // Type aliases work transparently
    val id: UserId = 42L
    val name: UserName = "Bob"
    assert(id == 42L, "UserId is just Long")
    assert(name == "Bob", "UserName is just String")

    // Exercise 2 assertions
    assert(42L.isValid, "positive UserId is valid")
    assert(!(-1L).isValid, "negative UserId is not valid")
    assert(!0L.isValid, "zero UserId is not valid")

    val users = List((3L, "Charlie"), (1L, "Alice"), (2L, "Bob"))
    val sorted = users.sorted
    assert(sorted.map(_._2) == List("Alice", "Bob", "Charlie"), "users sorted by ID")

    // Exercise 3 assertions
    assert(MaxRetries == 3, "MaxRetries constant")
    assert(DefaultTimeout == 5000L, "DefaultTimeout constant")

    var attempts = 0
    val result: Result[Int] = retry() {
      attempts += 1
      if (attempts < 3) Left("not yet")
      else Right(42)
    }
    assert(result == Right(42), "retry should eventually succeed")
    assert(attempts == 3, "should have taken 3 attempts")

    val failResult: Result[Int] = retry(2) { Left("always fails") }
    assert(failResult.isLeft, "retry should fail if all attempts fail")

    // Exercise 4 assertions
    import Prelude._
    assert(succeed(42) == Right(42), "succeed wraps in Right")
    assert(fail("oops").isLeft, "fail wraps in Left")
    assert(attempt(42) == Right(42), "attempt success")
    assert(attempt(throw new RuntimeException("boom")).isLeft, "attempt failure")

    println("All Core070_PackageObjects exercises passed!")
  }
}
