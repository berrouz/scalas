package org.shev4ik.interview.scala_core.level2_intermediate

object Core035_Variance {

  // Exercise 1: Covariant +A
  // TODO: Create a covariant container CoBox[+A] that holds a value of type A
  //       Demonstrate that CoBox[Dog] can be used where CoBox[Animal] is expected
  sealed trait Animal { def name: String }
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  class CoBox[+A](val value: A)

  // TODO: Implement a method that accepts CoBox[Animal] and returns the animal's name
  def getAnimalName(box: CoBox[Animal]): String = ???

  // Exercise 2: Contravariant -A
  // TODO: Create a contravariant trait Printer[-A] with a method print(value: A): String
  //       Demonstrate that Printer[Animal] can be used where Printer[Dog] is expected
  trait Printer[-A] {
    def print(value: A): String
  }

  // TODO: Create a Printer[Animal] instance
  val animalPrinter: Printer[Animal] = ???

  // Exercise 3: Invariant
  // TODO: Create an invariant mutable container MutBox[A] with get and set methods
  //       Explain why mutable containers must be invariant (in a comment)
  class MutBox[A](private var value: A) {
    def get: A = ???
    def set(newValue: A): Unit = ???
  }

  // Exercise 4: Covariant container
  // TODO: Implement an immutable covariant linked list IList[+A]
  //       with head, tail, and prepend (note: prepend needs lower bound)
  sealed trait IList[+A] {
    def head: A
    def tail: IList[A]
    def prepend[B >: A](elem: B): IList[B] = ???
    def toList: List[A] = ???
  }
  case class ICons[+A](head: A, tail: IList[A]) extends IList[A]
  case object INil extends IList[Nothing] {
    def head: Nothing = throw new NoSuchElementException("head of empty list")
    def tail: IList[Nothing] = throw new NoSuchElementException("tail of empty list")
  }

  // Exercise 5: Function variance
  // TODO: Demonstrate that Function1[-A, +B] is contravariant in input, covariant in output
  //       Create a function Animal => String and assign it to a variable of type Dog => String
  //       Create a function String => Dog and assign it to a variable of type String => Animal
  def demonstrateFunctionVariance(): (Dog => String, String => Animal) = ???

  // Exercise 6: Variance in practice
  // TODO: Implement a covariant trait Source[+A] with a method produce: A
  //       and a contravariant trait Sink[-A] with a method consume(value: A): String
  trait Source[+A] {
    def produce: A
  }
  trait Sink[-A] {
    def consume(value: A): String
  }

  // TODO: Create a Source[Dog] and a Sink[Animal]
  val dogSource: Source[Dog] = ???
  val animalSink: Sink[Animal] = ???

  // Exercise 7: Producer/Consumer pattern
  // TODO: Implement a method `transfer` that takes a Source[A] and Sink[A]
  //       and transfers the produced value to the sink, returning the result String
  def transfer[A](source: Source[A], sink: Sink[A]): String = ???

  // Exercise 8: Variance and bounds
  // TODO: Implement a covariant container Holder[+A] with a method
  //       `combine[B >: A](other: Holder[B]): Holder[B]` that picks the first non-empty holder
  sealed trait Holder[+A] {
    def isEmpty: Boolean
    def get: A
    def combine[B >: A](other: Holder[B]): Holder[B] = ???
  }
  case class Full[+A](value: A) extends Holder[A] {
    def isEmpty: Boolean = false
    def get: A = value
  }
  case object Vacant extends Holder[Nothing] {
    def isEmpty: Boolean = true
    def get: Nothing = throw new NoSuchElementException("Vacant.get")
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val dogBox: CoBox[Dog] = new CoBox(Dog("Rex"))
    val animalBox: CoBox[Animal] = dogBox // covariance allows this
    assert(getAnimalName(dogBox) == "Rex", "CoBox[Dog] should work as CoBox[Animal]")

    // Exercise 2 assertions
    val dogPrinter: Printer[Dog] = animalPrinter // contravariance allows this
    assert(dogPrinter.print(Dog("Buddy")).contains("Buddy"), "Animal printer should work for Dog")

    // Exercise 3 assertions
    val mutBox = new MutBox[Int](10)
    assert(mutBox.get == 10, "MutBox get should return value")
    mutBox.set(20)
    assert(mutBox.get == 20, "MutBox set should update value")

    // Exercise 4 assertions
    val ilist: IList[Int] = ICons(1, ICons(2, ICons(3, INil)))
    assert(ilist.head == 1, "IList head")
    assert(ilist.prepend(0).head == 0, "IList prepend")
    assert(ilist.toList == List(1, 2, 3), "IList toList")

    // Exercise 5 assertions
    val (dogToString, stringToAnimal) = demonstrateFunctionVariance()
    assert(dogToString(Dog("Rex")).nonEmpty, "Dog => String should work")
    assert(stringToAnimal("Fido").isInstanceOf[Animal], "String => Animal should return Animal")

    // Exercise 6 assertions
    val producedDog: Dog = dogSource.produce
    assert(producedDog.isInstanceOf[Dog], "Source should produce a Dog")
    val animalSinkForDog: Sink[Dog] = animalSink // contravariance
    assert(animalSinkForDog.consume(Dog("Max")).nonEmpty, "Sink[Animal] should accept Dog")

    // Exercise 7 assertions
    assert(transfer(dogSource, animalSink).nonEmpty, "transfer should work with Source[Dog] and Sink[Animal]")

    // Exercise 8 assertions
    val full: Holder[Int] = Full(42)
    val vacant: Holder[Int] = Vacant
    assert(full.combine(vacant).get == 42, "Full combined with Vacant should give Full")
    assert(vacant.combine(full).get == 42, "Vacant combined with Full should give Full")

    println("All Core035_Variance exercises passed!")
  }
}
