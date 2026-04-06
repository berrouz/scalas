package org.shev4ik.interview.scala_core.level1_beginner

object Core016_TraitsBasics {

  // Exercise 1: Trait definition
  // TODO: Define a trait Greeter with an abstract method greet(name: String): String.
  //       Then create a class FormalGreeter that extends Greeter and returns "Good day, $name".
  //       Return a new FormalGreeter and call greet("Alice").
  trait Greeter {
    def greet(name: String): String
  }

  def exercise1_traitDefinition: String = ???

  // Exercise 2: Extending traits
  // TODO: Define a trait HasName with a val name: String (abstract).
  //       Define a trait HasAge with a val age: Int (abstract).
  //       Create a class Person(val name: String, val age: Int) that extends both using `with`.
  //       Return (person.name, person.age) for Person("Bob", 25).
  trait HasName { val name: String }
  trait HasAge { val age: Int }

  def exercise2_extendingTraits: (String, Int) = ???

  // Exercise 3: Multiple traits with `with`
  // TODO: Define traits Swimmer (def swim: String = "swimming"),
  //       Runner (def run: String = "running"), Flyer (def fly: String = "flying").
  //       Create a class Triathlete that extends all three.
  //       Return (t.swim, t.run, t.fly).
  trait Swimmer { def swim: String = "swimming" }
  trait Runner { def run: String = "running" }
  trait Flyer { def fly: String = "flying" }

  def exercise3_multipleTraits: (String, String, String) = ???

  // Exercise 4: Abstract methods in traits
  // TODO: Define a trait Calculator with abstract methods add(a: Int, b: Int): Int
  //       and multiply(a: Int, b: Int): Int.
  //       Create a class BasicCalc that implements both.
  //       Return (calc.add(3, 4), calc.multiply(3, 4)).
  trait Calculator {
    def add(a: Int, b: Int): Int
    def multiply(a: Int, b: Int): Int
  }

  def exercise4_abstractMethods: (Int, Int) = ???

  // Exercise 5: Concrete methods in traits
  // TODO: Define a trait Logger with a concrete method log(msg: String): String = s"LOG: $msg".
  //       Create a class AppService that extends Logger.
  //       Return service.log("started").
  trait Logger {
    def log(msg: String): String = s"LOG: $msg"
  }

  def exercise5_concreteMethods: String = ???

  // Exercise 6: Fields in traits
  // TODO: Define a trait Configurable with val maxRetries: Int = 3 and val timeout: Long = 1000L.
  //       Create a class CustomConfig that extends Configurable and overrides maxRetries to 5.
  //       Return (config.maxRetries, config.timeout).
  trait Configurable {
    val maxRetries: Int = 3
    val timeout: Long = 1000L
  }

  def exercise6_fieldsInTraits: (Int, Long) = ???

  // Exercise 7: Trait vs abstract class
  // TODO: Create an abstract class Animal(val species: String) with abstract method sound: String.
  //       Create a trait Domesticated with val owner: String (abstract).
  //       Create a class Dog that extends Animal("Canine"), mixes in Domesticated,
  //       implements sound as "Woof" and owner as "John".
  //       Return (dog.species, dog.sound, dog.owner).
  abstract class Animal(val species: String) {
    def sound: String
  }
  trait Domesticated {
    val owner: String
  }

  def exercise7_traitVsAbstractClass: (String, String, String) = ???

  // Exercise 8: Trait stacking (linearization)
  // TODO: Define a base trait Transformer { def transform(s: String): String }.
  //       Define trait UpperCase extends Transformer { override def transform(s: String) = super.transform(s).toUpperCase }
  //       Define trait Trim extends Transformer { override def transform(s: String) = super.transform(s).trim }
  //       Define class BaseTransformer extends Transformer { def transform(s: String) = s }
  //       Create: new BaseTransformer with Trim with UpperCase
  //       Call transform("  hello  ") — UpperCase runs first (rightmost), then Trim.
  //       Return the result.
  trait Transformer {
    def transform(s: String): String
  }

  def exercise8_traitStacking: String = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_traitDefinition == "Good day, Alice", "Exercise 1 failed")

    assert(exercise2_extendingTraits == ("Bob", 25), "Exercise 2 failed")

    assert(exercise3_multipleTraits == ("swimming", "running", "flying"), "Exercise 3 failed")

    assert(exercise4_abstractMethods == (7, 12), "Exercise 4 failed")

    assert(exercise5_concreteMethods == "LOG: started", "Exercise 5 failed")

    assert(exercise6_fieldsInTraits == (5, 1000L), "Exercise 6 failed")

    assert(exercise7_traitVsAbstractClass == ("Canine", "Woof", "John"), "Exercise 7 failed")

    assert(exercise8_traitStacking == "  HELLO  ", "Exercise 8 failed")

    println("All Core016_TraitsBasics exercises passed!")
  }
}
