package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP015 - Optic Composition
 *
 * Optics compose: Lens + Prism = Optional, Lens + Traversal = Traversal, etc.
 * This file practices composing different optic types for practical nested updates.
 */
object AdvFP015_OpticComposition {

  case class Lens[S, A](get: S => A, set: A => S => S) {
    def modify(f: A => A)(s: S): S = set(f(get(s)))(s)
  }

  case class Prism[S, A](getOption: S => Option[A], reverseGet: A => S)

  case class Optional[S, A](getOption: S => Option[A], set: A => S => S) {
    def modify(f: A => A)(s: S): S =
      getOption(s).map(a => set(f(a))(s)).getOrElse(s)
  }

  case class Traversal[S, A](getAll: S => List[A], modifyF: (A => A) => S => S)

  // ============================================================
  // Exercise 1: Compose Lens + Prism = Optional
  // ============================================================
  // TODO: Compose a Lens and a Prism into an Optional
  def lensAndPrism[S, A, B](lens: Lens[S, A], prism: Prism[A, B]): Optional[S, B] = ???

  // ============================================================
  // Exercise 2: Compose Lens + Traversal = Traversal
  // ============================================================
  // TODO: Compose a Lens and a Traversal into a Traversal
  def lensAndTraversal[S, A, B](lens: Lens[S, A], trav: Traversal[A, B]): Traversal[S, B] = ???

  // ============================================================
  // Exercise 3: Compose Prism + Lens = Optional
  // ============================================================
  // TODO: Compose a Prism and a Lens into an Optional
  def prismAndLens[S, A, B](prism: Prism[S, A], lens: Lens[A, B]): Optional[S, B] = ???

  // ============================================================
  // Exercise 4: Implement 'each' Traversal for List
  // ============================================================
  // TODO: Traversal focusing on each element
  def each[A]: Traversal[List[A], A] = ???

  // ============================================================
  // Exercise 5: Implement 'index' Optional for List
  // ============================================================
  // TODO: Optional focusing on element at index i
  def index[A](i: Int): Optional[List[A], A] = ???

  // ============================================================
  // Exercise 6: Implement 'filterIndex' Traversal for List
  // ============================================================
  // TODO: Traversal focusing on elements at indices matching a predicate
  def filterIndex[A](pred: Int => Boolean): Traversal[List[A], A] = ???

  // ============================================================
  // Exercise 7: Practical nested update
  // Given the data model below, update the salary of all employees
  // in the Engineering department.
  // ============================================================
  case class Employee(name: String, salary: Double)
  case class Department(name: String, employees: List[Employee])
  case class Company(departments: List[Department])

  // TODO: Increase salary of all employees in a named department by a percentage
  def raiseSalary(company: Company, deptName: String, percentage: Double): Company = ???

  // ============================================================
  // Exercise 8: Optic composition table
  // Implement a function that demonstrates the result type of composing
  // different optics. Return a description string based on optic types.
  //
  // Composition rules:
  //   Lens    + Lens    = Lens
  //   Lens    + Prism   = Optional
  //   Lens    + Optional = Optional
  //   Prism   + Lens    = Optional
  //   Prism   + Prism   = Prism
  //   Traversal + anything = Traversal
  // ============================================================
  sealed trait OpticType
  case object LensType extends OpticType
  case object PrismType extends OpticType
  case object OptionalType extends OpticType
  case object TraversalType extends OpticType

  // TODO: Return the result optic type when composing two optic types
  def composeOpticType(a: OpticType, b: OpticType): OpticType = ???

  def main(args: Array[String]): Unit = {
    // Setup
    sealed trait Animal
    case class Dog(name: String) extends Animal
    case class Cat(name: String) extends Animal

    val animalName = Lens[Animal, String](
      { case Dog(n) => n; case Cat(n) => n },
      name => { case Dog(_) => Dog(name); case Cat(_) => Cat(name) }
    )

    val dogPrism = Prism[Animal, Dog](
      { case d: Dog => Some(d); case _ => None },
      identity
    )

    // Exercise 1: Lens + Prism
    case class Owner(pet: Animal)
    val ownerPet = Lens[Owner, Animal](_.pet, a => _ => Owner(a))
    val ownerDog = lensAndPrism(ownerPet, dogPrism)
    assert(ownerDog.getOption(Owner(Dog("Rex"))) == Some(Dog("Rex")))
    assert(ownerDog.getOption(Owner(Cat("Whiskers"))) == None)
    println("Exercise 1 passed: Lens + Prism = Optional")

    // Exercise 2: Lens + Traversal
    case class Kennel(dogs: List[String])
    val kennelDogs = Lens[Kennel, List[String]](_.dogs, ds => _ => Kennel(ds))
    val eachDog = Traversal[List[String], String](identity, f => _.map(f))
    val allDogsInKennel = lensAndTraversal(kennelDogs, eachDog)
    assert(allDogsInKennel.getAll(Kennel(List("Rex", "Max"))) == List("Rex", "Max"))
    println("Exercise 2 passed: Lens + Traversal = Traversal")

    // Exercise 3: Prism + Lens
    val dogName = Lens[Dog, String](_.name, n => _ => Dog(n))
    val animalDogName = prismAndLens(dogPrism, dogName)
    assert(animalDogName.getOption(Dog("Rex"): Animal) == Some("Rex"))
    assert(animalDogName.getOption(Cat("Whiskers"): Animal) == None)
    println("Exercise 3 passed: Prism + Lens = Optional")

    // Exercise 4: each
    val e = each[Int]
    assert(e.getAll(List(1, 2, 3)) == List(1, 2, 3))
    assert(e.modifyF(_ * 2)(List(1, 2, 3)) == List(2, 4, 6))
    println("Exercise 4 passed: each traversal")

    // Exercise 5: index
    val idx = index[String](1)
    assert(idx.getOption(List("a", "b", "c")) == Some("b"))
    assert(idx.getOption(List("a")) == None)
    assert(idx.set("X")(List("a", "b", "c")) == List("a", "X", "c"))
    println("Exercise 5 passed: index optional")

    // Exercise 6: filterIndex
    val fi = filterIndex[Int](_ % 2 == 0) // even indices: 0, 2, 4...
    assert(fi.getAll(List(10, 20, 30, 40, 50)) == List(10, 30, 50))
    assert(fi.modifyF(_ * 100)(List(10, 20, 30, 40, 50)) == List(1000, 20, 3000, 40, 5000))
    println("Exercise 6 passed: filterIndex traversal")

    // Exercise 7: Practical nested update
    val company = Company(List(
      Department("Engineering", List(Employee("Alice", 100000), Employee("Bob", 90000))),
      Department("Marketing", List(Employee("Carol", 80000)))
    ))
    val updated = raiseSalary(company, "Engineering", 10.0)
    val engDept = updated.departments.find(_.name == "Engineering").get
    assert(engDept.employees.map(_.salary) == List(110000.0, 99000.0))
    val mktDept = updated.departments.find(_.name == "Marketing").get
    assert(mktDept.employees.map(_.salary) == List(80000.0))
    println("Exercise 7 passed: Practical nested update")

    // Exercise 8: Optic composition table
    assert(composeOpticType(LensType, LensType) == LensType)
    assert(composeOpticType(LensType, PrismType) == OptionalType)
    assert(composeOpticType(PrismType, PrismType) == PrismType)
    assert(composeOpticType(TraversalType, LensType) == TraversalType)
    assert(composeOpticType(PrismType, LensType) == OptionalType)
    println("Exercise 8 passed: Optic composition table")

    println("\nAll exercises passed!")
  }
}
