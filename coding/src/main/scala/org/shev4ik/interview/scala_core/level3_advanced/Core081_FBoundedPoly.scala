package org.shev4ik.interview.scala_core.level3_advanced

object Core081_FBoundedPoly {

  // Exercise 1: F-bounded type
  // TODO: Define a trait Pet[T <: Pet[T]] with method `name: String` and
  //       `befriend(other: T): String`. The F-bound ensures befriend takes same type.
  trait Pet[T <: Pet[T]] { self: T =>
    def name: String
    def befriend(other: T): String
  }

  // TODO: Implement Dog extending Pet[Dog]
  case class Dog(name: String) extends Pet[Dog] {
    def befriend(other: Dog): String = ???
  }

  // TODO: Implement Cat extending Pet[Cat]
  case class Cat(name: String) extends Pet[Cat] {
    def befriend(other: Cat): String = ???
  }

  // Exercise 2: Comparable pattern
  // TODO: Define a trait MyComparable[T <: MyComparable[T]] with compareTo method
  //       Then implement it for Score
  trait MyComparable[T <: MyComparable[T]] { self: T =>
    def compareTo(other: T): Int
  }

  case class Score(value: Int) extends MyComparable[Score] {
    def compareTo(other: Score): Int = ???
  }

  // Exercise 3: Recursive type bound
  // TODO: Define a trait Builder[T <: Builder[T]] with method `set(key: String, value: String): T`
  //       The F-bound ensures `set` returns the concrete builder type for chaining.
  trait Builder[T <: Builder[T]] { self: T =>
    def set(key: String, value: String): T
    def build: Map[String, String]
  }

  // TODO: Implement PersonBuilder extending Builder[PersonBuilder]
  case class PersonBuilder(fields: Map[String, String] = Map.empty) extends Builder[PersonBuilder] {
    def set(key: String, value: String): PersonBuilder = ???
    def build: Map[String, String] = ???
  }

  // Exercise 4: Fluent interface with F-bound
  // TODO: Define a fluent query builder using F-bound polymorphism
  trait Query[T <: Query[T]] { self: T =>
    def where(condition: String): T
    def orderBy(field: String): T
    def toSQL: String
  }

  case class SelectQuery(table: String, conditions: List[String] = Nil, ordering: Option[String] = None)
    extends Query[SelectQuery] {
    def where(condition: String): SelectQuery = ???
    def orderBy(field: String): SelectQuery = ???
    def toSQL: String = ???
  }

  // Exercise 5: F-bound vs typeclass
  // TODO: Show the typeclass alternative to F-bounded polymorphism
  //       Define a typeclass Combinable[T] instead of using F-bound
  trait Combinable[T] {
    def combine(a: T, b: T): T
  }

  // TODO: Implement Combinable for Int and String
  implicit val combinableInt: Combinable[Int] = ???
  implicit val combinableString: Combinable[String] = ???

  def combineAll[T](list: List[T])(implicit c: Combinable[T]): Option[T] = ???

  // Exercise 6: F-bound limitations
  // TODO: Show a limitation of F-bound: you can't easily put different Pet types in a list
  //       Implement a method that works with existential Pet[_]
  def petNames(pets: List[Pet[_]]): List[String] = ???

  // Exercise 7: Simulating F-bound with typeclass
  // TODO: Define a typeclass-based alternative to the Pet F-bound example
  trait PetOps[T] {
    def name(t: T): String
    def befriend(a: T, b: T): String
  }

  case class Fish(name: String)

  // TODO: Implement PetOps for Fish
  implicit val fishOps: PetOps[Fish] = ???

  def makeFriends[T](a: T, b: T)(implicit ops: PetOps[T]): String = ???

  // Exercise 8: F-bound in collections
  // TODO: Write a method that finds the maximum element in a list
  //       using F-bounded MyComparable
  def maxElement[T <: MyComparable[T]](list: List[T]): Option[T] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(Dog("Rex").befriend(Dog("Buddy")).contains("Rex"))
    assert(Cat("Whiskers").befriend(Cat("Mittens")).contains("Whiskers"))

    // Exercise 2
    assert(Score(10).compareTo(Score(5)) > 0)
    assert(Score(3).compareTo(Score(7)) < 0)
    assert(Score(5).compareTo(Score(5)) == 0)

    // Exercise 3
    val built = PersonBuilder().set("name", "Alice").set("age", "30").build
    assert(built == Map("name" -> "Alice", "age" -> "30"))

    // Exercise 4
    val sql = SelectQuery("users").where("age > 18").where("active = true").orderBy("name").toSQL
    assert(sql.contains("users"))
    assert(sql.contains("age > 18"))

    // Exercise 5
    assert(combineAll(List(1, 2, 3, 4)) == Some(10))
    assert(combineAll(List("a", "b", "c")) == Some("abc"))
    assert(combineAll(List.empty[Int]) == None)

    // Exercise 6
    val pets: List[Pet[_]] = List(Dog("Rex"), Cat("Whiskers"))
    assert(petNames(pets) == List("Rex", "Whiskers"))

    // Exercise 7
    assert(makeFriends(Fish("Nemo"), Fish("Dory")).contains("Nemo"))

    // Exercise 8
    assert(maxElement(List(Score(3), Score(7), Score(1))) == Some(Score(7)))
    assert(maxElement(List.empty[Score]) == None)

    println("All Core081_FBoundedPoly exercises passed!")
  }
}
