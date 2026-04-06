package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP011 - Lens Basics
 *
 * A Lens[S, A] focuses on a part A within a whole S.
 * It provides get: S => A and set: (S, A) => S.
 * Laws: get-set, set-get, set-set.
 */
object AdvFP011_LensBasics {

  // ============================================================
  // Exercise 1: Define the Lens type
  // A Lens[S, A] has get: S => A and set: A => S => S
  // ============================================================
  case class Lens[S, A](get: S => A, set: A => S => S) {
    def modify(f: A => A)(s: S): S = set(f(get(s)))(s)
  }

  // TODO: Create a Lens for the first element of a pair
  def first[A, B]: Lens[(A, B), A] = ???

  // ============================================================
  // Exercise 2: Create a Lens for a nested case class
  // ============================================================
  case class Address(street: String, city: String, zip: String)
  case class Person(name: String, age: Int, address: Address)

  // TODO: Lens focusing on a Person's address
  val personAddress: Lens[Person, Address] = ???

  // TODO: Lens focusing on an Address's street
  val addressStreet: Lens[Address, String] = ???

  // ============================================================
  // Exercise 3: Implement Lens composition
  // Given Lens[S, A] and Lens[A, B], produce Lens[S, B]
  // ============================================================
  // TODO: Compose two lenses
  def composeLens[S, A, B](outer: Lens[S, A], inner: Lens[A, B]): Lens[S, B] = ???

  // ============================================================
  // Exercise 4: Verify the get-set law
  // set(get(s))(s) == s  (setting what you got changes nothing)
  // ============================================================
  // TODO: Verify get-set law
  def verifyGetSet[S, A](lens: Lens[S, A], s: S): Boolean = ???

  // ============================================================
  // Exercise 5: Verify the set-get law
  // get(set(a)(s)) == a  (getting after setting gives what you set)
  // ============================================================
  // TODO: Verify set-get law
  def verifySetGet[S, A](lens: Lens[S, A], s: S, a: A): Boolean = ???

  // ============================================================
  // Exercise 6: Verify the set-set law
  // set(a2)(set(a1)(s)) == set(a2)(s)  (setting twice is same as setting once)
  // ============================================================
  // TODO: Verify set-set law
  def verifySetSet[S, A](lens: Lens[S, A], s: S, a1: A, a2: A): Boolean = ???

  // ============================================================
  // Exercise 7: Implement modify using get and set
  // modify(f)(s) = set(f(get(s)))(s)
  // Use it to increment a person's age.
  // ============================================================
  val personAge: Lens[Person, Int] = Lens[Person, Int](_.age, a => p => p.copy(age = a))

  // TODO: Use modify to create a birthday function
  def birthday(p: Person): Person = ???

  // ============================================================
  // Exercise 8: Implement a "GenLens"-style macro-free lens generator
  // Given a case class field name as a function, create a lens.
  // This is a simplified version - create lens for Person's name.
  // ============================================================
  // TODO: Implement lens for Person's name
  val personName: Lens[Person, String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: first lens
    val f = first[Int, String]
    assert(f.get((1, "a")) == 1)
    assert(f.set(2)((1, "a")) == (2, "a"))
    println("Exercise 1 passed: First lens")

    // Exercise 2: Nested lenses
    val addr = Address("123 Main", "NYC", "10001")
    val person = Person("Alice", 30, addr)
    assert(personAddress.get(person) == addr)
    assert(addressStreet.get(addr) == "123 Main")
    println("Exercise 2 passed: Nested case class lenses")

    // Exercise 3: Lens composition
    val personStreet = composeLens(personAddress, addressStreet)
    assert(personStreet.get(person) == "123 Main")
    val updated = personStreet.set("456 Oak")(person)
    assert(updated.address.street == "456 Oak")
    println("Exercise 3 passed: Lens composition")

    // Exercise 4: get-set law
    assert(verifyGetSet(personAddress, person))
    assert(verifyGetSet(addressStreet, addr))
    println("Exercise 4 passed: Get-set law")

    // Exercise 5: set-get law
    val newAddr = Address("789 Pine", "LA", "90001")
    assert(verifySetGet(personAddress, person, newAddr))
    println("Exercise 5 passed: Set-get law")

    // Exercise 6: set-set law
    val addr1 = Address("A", "B", "C")
    val addr2 = Address("X", "Y", "Z")
    assert(verifySetSet(personAddress, person, addr1, addr2))
    println("Exercise 6 passed: Set-set law")

    // Exercise 7: modify
    val older = birthday(person)
    assert(older.age == 31)
    println("Exercise 7 passed: Birthday via modify")

    // Exercise 8: Person name lens
    assert(personName.get(person) == "Alice")
    val renamed = personName.set("Bob")(person)
    assert(renamed.name == "Bob")
    println("Exercise 8 passed: Person name lens")

    println("\nAll exercises passed!")
  }
}
