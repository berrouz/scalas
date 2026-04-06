package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala Case Classes=
 *
 * ==Theory: What the Compiler Generates for a Case Class==
 *
 * When you write `case class Person(name: String, age: Int)`, the Scala compiler
 * automatically generates the following:
 *
 *  1. '''`apply` method''' in the companion object -- so you can write `Person("Alice", 30)`
 *     instead of `new Person("Alice", 30)`.
 *  2. '''`unapply` method''' in the companion object -- enables pattern matching:
 *     `case Person(name, age) => ...`.
 *  3. '''`equals` and `hashCode`''' -- structural equality based on ALL constructor parameters.
 *     Two case class instances with the same field values are `==` to each other.
 *  4. '''`toString`''' -- returns `"Person(Alice,30)"` instead of a cryptic hash.
 *  5. '''`copy` method''' -- creates a new instance with some fields changed:
 *     `person.copy(age = 31)`.
 *  6. '''`Serializable`''' -- case classes extend `Serializable` by default.
 *  7. '''`Product` trait''' -- gives `productArity`, `productElement`, `productIterator`,
 *     enabling generic access to fields.
 *  8. '''All constructor parameters become `val` fields''' (public and immutable by default).
 *
 * ==Theory: Case Class vs Regular Class==
 *
 * {{{
 * class RegularPerson(val name: String, val age: Int)
 * case class CasePerson(name: String, age: Int)
 *
 * new RegularPerson("A", 1) == new RegularPerson("A", 1)  // false (reference equality)
 * CasePerson("A", 1) == CasePerson("A", 1)                // true (structural equality)
 * }}}
 *
 * Regular classes use JVM's default `equals` (reference equality) unless you override it.
 * Case classes get value-based equality for free.
 *
 * ==Theory: Case Class Inheritance Restrictions==
 *
 * You should NOT extend a case class from another case class. This is because:
 *  - The auto-generated `equals`/`hashCode` would not account for the subclass fields correctly.
 *  - `copy` returns the parent type, losing subclass fields.
 *  - The Liskov Substitution Principle is violated since equality becomes asymmetric.
 *
 * In Scala 3, extending case class from case class is explicitly forbidden by the compiler.
 * In Scala 2, the compiler emits a deprecation warning. Instead, use a sealed trait with
 * separate case classes as leaves.
 *
 * ==Theory: Case Objects==
 *
 * `case object` is similar to `case class` but for singleton values (no constructor parameters).
 * It gets `toString`, `Serializable`, and `hashCode`, but not `copy`, `apply`, or `unapply`
 * (since there's nothing to construct or deconstruct).
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "Why shouldn't you extend a case class from another case class?"'''
 *    Answer: Because the auto-generated `equals`, `hashCode`, and `copy` methods do not
 *    compose correctly across inheritance. `equals` in the parent ignores subclass fields,
 *    making equality asymmetric and violating the contract of `equals`. Scala 3 prohibits
 *    this entirely. The correct pattern is to use a sealed trait with separate case class leaves.
 *
 *  - '''Follow-up: "What does a case class generate under the hood?"'''
 *    Answer: `apply`, `unapply`, `equals`, `hashCode`, `toString`, `copy`, and extends
 *    `Serializable` and `Product`. All constructor parameters become public `val` fields.
 *
 *  - '''Follow-up: "When would you use a regular class instead of a case class?"'''
 *    Answer: When you need mutable state, reference equality, or are modeling entities
 *    with identity (e.g., database rows with IDs where equality is based on ID, not all fields).
 *    Also for classes with complex inheritance hierarchies.
 *
 * ==Approach Hints==
 *
 *  - `copy` takes named parameters that override specific fields: `person.copy(age = 31)`.
 *  - `Person.unapply(person)` returns `Option[(String, Int)]` -- this is what powers pattern matching.
 *  - For Exercise 8, note that `new RegularPerson(...) == new RegularPerson(...)` is `false`
 *    because regular classes use reference equality by default.
 */
object Core014_CaseClasses {

  case class Person(name: String, age: Int)

  // Exercise 1: Case class creation
  // TODO: Create a Person("Alice", 30) and return it.
  def exercise1_creation: Person = ???

  // Exercise 2: copy
  // TODO: Given Person("Alice", 30), use copy to create a new person with age 31.
  //       Return the new person.
  def exercise2_copy: Person = ???

  // Exercise 3: equals and hashCode (auto-generated)
  // TODO: Create two Person("Bob", 25) instances. Check if they are equal using ==.
  //       Also check if their hashCodes are the same. Return (areEqual, sameHash).
  def exercise3_equalsHashCode: (Boolean, Boolean) = ???

  // Exercise 4: toString (auto-generated)
  // TODO: Return the toString of Person("Charlie", 35). It should be "Person(Charlie,35)".
  def exercise4_toString: String = ???

  // Exercise 5: Pattern matching with case classes
  // TODO: Given a Person, pattern match to return:
  //       Person(name, age) if age >= 18 => s"$name is an adult"
  //       Person(name, age) => s"$name is a minor"
  def exercise5_patternMatch(p: Person): String = ???

  // Exercise 6: unapply (extractor)
  // TODO: Use Person.unapply to destructure a person.
  //       val Person(name, age) = Person("Diana", 28)
  //       Return (name, age).
  def exercise6_unapply: (String, Int) = ???

  // Exercise 7: Companion object apply
  // TODO: Case classes automatically get an apply method in the companion object.
  //       Create a Person using Person.apply("Eve", 22) (same as Person("Eve", 22)).
  //       Return it.
  def exercise7_companionApply: Person = ???

  // Exercise 8: Case class vs regular class
  // TODO: Define a regular class RegularPerson(val name: String, val age: Int) inside this method.
  //       Create two instances with same args and check if they are equal (==).
  //       Also create two case class Persons with same args and check equality.
  //       Return (regularEqual, caseClassEqual) — should be (false, true).
  def exercise8_caseVsRegular: (Boolean, Boolean) = {
    class RegularPerson(val name: String, val age: Int)
    ???
  }

  def main(args: Array[String]): Unit = {
    assert(exercise1_creation == Person("Alice", 30), "Exercise 1 failed")

    assert(exercise2_copy == Person("Alice", 31), "Exercise 2 failed")

    val (eq, hash) = exercise3_equalsHashCode
    assert(eq, "Exercise 3 failed: equals")
    assert(hash, "Exercise 3 failed: hashCode")

    assert(exercise4_toString == "Person(Charlie,35)", "Exercise 4 failed")

    assert(exercise5_patternMatch(Person("Alice", 30)) == "Alice is an adult", "Exercise 5 failed: adult")
    assert(exercise5_patternMatch(Person("Bob", 10)) == "Bob is a minor", "Exercise 5 failed: minor")

    val (name, age) = exercise6_unapply
    assert(name == "Diana", "Exercise 6 failed: name")
    assert(age == 28, "Exercise 6 failed: age")

    assert(exercise7_companionApply == Person("Eve", 22), "Exercise 7 failed")

    val (regEq, caseEq) = exercise8_caseVsRegular
    assert(!regEq, "Exercise 8 failed: regular should not be equal")
    assert(caseEq, "Exercise 8 failed: case class should be equal")

    println("All Core014_CaseClasses exercises passed!")
  }
}
