package org.shev4ik.interview.scala_core.level2_intermediate

object Core064_Ordering {

  // Exercise 1: Ordering trait
  // TODO: Create an Ordering[Person] that sorts by age ascending
  case class Person(name: String, age: Int)

  val byAge: Ordering[Person] = ???

  // Exercise 2: Ordering.by
  // TODO: Use Ordering.by to create an ordering for Person by name (alphabetically)
  val byName: Ordering[Person] = ???

  // Exercise 3: Ordering.on
  // TODO: Use Ordering[Int].on[Person] to create an ordering by age
  //       (.on transforms the input type)
  val byAgeViaOn: Ordering[Person] = ???

  // Exercise 4: reverse
  // TODO: Create a reverse ordering - sort by age descending
  val byAgeDescending: Ordering[Person] = ???

  // Exercise 5: orElse
  // TODO: Combine orderings: first by age, then by name (for equal ages)
  val byAgeThenName: Ordering[Person] = ???

  // Exercise 6: sorted with Ordering
  // TODO: Sort a list of Persons using different orderings
  def sortByAge(people: List[Person]): List[Person] = ???
  def sortByName(people: List[Person]): List[Person] = ???
  def sortByAgeThenName(people: List[Person]): List[Person] = ???

  // Exercise 7: Ordered trait
  // TODO: Create a class Temperature that extends Ordered[Temperature]
  //       Implement the compare method
  case class Temperature(celsius: Double) extends Ordered[Temperature] {
    def compare(that: Temperature): Int = ???
    def toFahrenheit: Double = ???
  }

  // Exercise 8: Ordering vs Comparator
  // TODO: Demonstrate Ordering (Scala) vs Comparator (Java)
  //       Create a Java-compatible Comparator from a Scala Ordering
  //       and vice versa
  def orderingToComparator[A](ord: Ordering[A]): java.util.Comparator[A] = ???
  def comparatorToOrdering[A](comp: java.util.Comparator[A]): Ordering[A] = ???

  def main(args: Array[String]): Unit = {
    val people = List(
      Person("Charlie", 30),
      Person("Alice", 25),
      Person("Bob", 30),
      Person("Alice", 20)
    )

    // Exercise 1 assertions
    assert(people.sorted(byAge).head.age == 20, "youngest first by age")

    // Exercise 2 assertions
    assert(people.sorted(byName).head.name == "Alice", "sorted by name")

    // Exercise 3 assertions
    assert(people.sorted(byAgeViaOn).head.age == 20, "sorted by age via on")

    // Exercise 4 assertions
    assert(people.sorted(byAgeDescending).head.age == 30, "oldest first")

    // Exercise 5 assertions
    val sorted5 = people.sorted(byAgeThenName)
    assert(sorted5(0) == Person("Alice", 20), "first: Alice 20")
    assert(sorted5(1) == Person("Alice", 25), "second: Alice 25")
    assert(sorted5(2) == Person("Bob", 30), "third: Bob 30")
    assert(sorted5(3) == Person("Charlie", 30), "fourth: Charlie 30")

    // Exercise 6 assertions
    assert(sortByAge(people).head.age == 20, "sortByAge")
    assert(sortByName(people).head.name == "Alice", "sortByName")
    assert(sortByAgeThenName(people)(2).name == "Bob", "sortByAgeThenName")

    // Exercise 7 assertions
    val temps = List(Temperature(100), Temperature(0), Temperature(37))
    assert(temps.sorted.head == Temperature(0), "sorted temps should start with 0")
    assert(Temperature(0) < Temperature(100), "0 < 100")
    assert(math.abs(Temperature(100).toFahrenheit - 212.0) < 0.01, "100C = 212F")

    // Exercise 8 assertions
    val comp = orderingToComparator(byAge)
    assert(comp.compare(Person("A", 20), Person("B", 30)) < 0, "comparator from ordering")
    val ord = comparatorToOrdering(comp)
    assert(people.sorted(ord).head.age == 20, "ordering from comparator")

    println("All Core064_Ordering exercises passed!")
  }
}
