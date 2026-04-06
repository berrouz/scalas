package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP029 - Profunctor Optics
 *
 * Optics can be encoded as profunctor transformers:
 * type Optic P S T A B = P[A, B] => P[S, T]
 * A Lens is an optic for all Strong profunctors.
 * A Prism is an optic for all Choice profunctors.
 * An Iso is an optic for all Profunctors.
 */
object AdvFP029_ProfunctorOptics {

  trait Profunctor[P[_, _]] {
    def dimap[A, B, C, D](pab: P[A, B])(f: C => A)(g: B => D): P[C, D]
  }

  trait Strong[P[_, _]] extends Profunctor[P] {
    def first[A, B, C](pab: P[A, B]): P[(A, C), (B, C)]
  }

  trait Choice[P[_, _]] extends Profunctor[P] {
    def left[A, B, C](pab: P[A, B]): P[Either[A, C], Either[B, C]]
  }

  implicit val fnProfunctor: Profunctor[Function1] = new Profunctor[Function1] {
    def dimap[A, B, C, D](pab: A => B)(f: C => A)(g: B => D): C => D = c => g(pab(f(c)))
  }

  implicit val fnStrong: Strong[Function1] = new Strong[Function1] {
    def dimap[A, B, C, D](pab: A => B)(f: C => A)(g: B => D): C => D = c => g(pab(f(c)))
    def first[A, B, C](pab: A => B): ((A, C)) => (B, C) = { case (a, c) => (pab(a), c) }
  }

  implicit val fnChoice: Choice[Function1] = new Choice[Function1] {
    def dimap[A, B, C, D](pab: A => B)(f: C => A)(g: B => D): C => D = c => g(pab(f(c)))
    def left[A, B, C](pab: A => B): Either[A, C] => Either[B, C] = {
      case Left(a) => Left(pab(a))
      case Right(c) => Right(c)
    }
  }

  // ============================================================
  // Exercise 1: Define profunctor optics types
  // ============================================================
  // An Iso works for any Profunctor
  type PIso[S, T, A, B] = Profunctor[Function1] => (A => B) => (S => T)
  // Simplified: we use concrete types

  // TODO: Implement a profunctor Iso
  def pIso[S, A](get: S => A, reverseGet: A => S): (A => A) => (S => S) = ???

  // ============================================================
  // Exercise 2: Implement a profunctor Lens
  // Lens as profunctor transformer: P[A, B] => P[S, T]
  // Uses Strong (first) to work with the product structure.
  // ============================================================
  // TODO: Implement profunctor Lens (modify version)
  def pLens[S, A](get: S => A, set: A => S => S): (A => A) => (S => S) = ???

  // ============================================================
  // Exercise 3: Implement a profunctor Prism
  // Prism as profunctor transformer: P[A, B] => P[S, T]
  // Uses Choice (left) to work with the sum structure.
  // ============================================================
  // TODO: Implement profunctor Prism (modify version)
  def pPrism[S, A](getOption: S => Option[A], reverseGet: A => S): (A => A) => (S => S) = ???

  // ============================================================
  // Exercise 4: Compose profunctor optics
  // Optic composition is just function composition!
  // compose: Optic[S, A] => Optic[A, B] => Optic[S, B]
  // ============================================================
  type Optic[S, A] = (A => A) => (S => S)

  // TODO: Compose two optics
  def composeOptic[S, A, B](outer: Optic[S, A], inner: Optic[A, B]): Optic[S, B] = ???

  // ============================================================
  // Exercise 5: Implement Van Laarhoven Lens
  // VL Lens: forall F[_]: Functor. (A => F[B]) => S => F[T]
  // Simplified to monomorphic: (A => F[A]) => S => F[S]
  // ============================================================
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // TODO: Implement Van Laarhoven lens for a case class field
  case class Person(name: String, age: Int)

  def vlLensAge[F[_]: Functor](modify: Int => F[Int])(person: Person): F[Person] = ???

  // ============================================================
  // Exercise 6: Show that VL Lens gives get and set
  // Use Identity functor for set/modify, Const functor for get.
  // ============================================================
  case class Identity[A](value: A)
  case class Const[R, A](getConst: R)

  implicit val identityFunctor: Functor[Identity] = new Functor[Identity] {
    def map[A, B](fa: Identity[A])(f: A => B): Identity[B] = Identity(f(fa.value))
  }

  implicit def constFunctor[R]: Functor[({type L[A] = Const[R, A]})#L] =
    new Functor[({type L[A] = Const[R, A]})#L] {
      def map[A, B](fa: Const[R, A])(f: A => B): Const[R, B] = Const(fa.getConst)
    }

  // TODO: Extract 'get' from VL lens using Const functor
  def vlGet(person: Person): Int = ???

  // TODO: Extract 'set' from VL lens using Identity functor
  def vlSet(person: Person, newAge: Int): Person = ???

  // ============================================================
  // Exercise 7: Implement existential optics (getter as example)
  // A Getter[S, A] = S => A, which is the simplest optic.
  // Show how it relates to Forget profunctor.
  // ============================================================
  case class Forget[R, A, B](run: A => R)

  // TODO: Implement a Getter using Forget
  def getter[S, A](get: S => A): Forget[A, S, Any] = ???

  // TODO: Use the getter to extract a value
  def useGetter[S, A](g: Forget[A, S, Any], s: S): A = ???

  // ============================================================
  // Exercise 8: Demonstrate optic composition via profunctor
  // Compose a lens (name) and a prism (parse as int) into an optional.
  // ============================================================
  case class Config(value: String)

  // TODO: Lens for Config.value
  val configValue: Optic[Config, String] = ???

  // TODO: Prism for String -> Int (parse)
  val stringInt: Optic[String, Int] = ???

  // TODO: Compose them and use on Config
  def modifyConfigInt(config: Config, f: Int => Int): Config = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Profunctor Iso
    val iso = pIso[String, List[Char]](_.toList, _.mkString)
    val reversed = iso(_.reverse)("hello")
    assert(reversed == "olleh")
    println("Exercise 1 passed: Profunctor Iso")

    // Exercise 2: Profunctor Lens
    val ageLens = pLens[Person, Int](_.age, a => p => p.copy(age = a))
    val person = Person("Alice", 30)
    val older = ageLens(_ + 1)(person)
    assert(older.age == 31)
    println("Exercise 2 passed: Profunctor Lens")

    // Exercise 3: Profunctor Prism
    sealed trait Shape
    case class Circle(r: Double) extends Shape
    case class Rect(w: Double, h: Double) extends Shape
    val circlePrism = pPrism[Shape, Circle](
      { case c: Circle => Some(c); case _ => None },
      identity
    )
    val doubled = circlePrism(c => c.copy(r = c.r * 2))(Circle(5.0): Shape)
    assert(doubled == Circle(10.0))
    val unchanged = circlePrism(c => c.copy(r = c.r * 2))(Rect(1, 2): Shape)
    assert(unchanged == Rect(1, 2))
    println("Exercise 3 passed: Profunctor Prism")

    // Exercise 4: Compose optics
    case class Company(ceo: Person)
    val ceoLens: Optic[Company, Person] = pLens[Company, Person](_.ceo, p => _ => Company(p))
    val ceoAge = composeOptic(ceoLens, ageLens)
    val company = Company(Person("Bob", 50))
    assert(ceoAge(_ + 1)(company).ceo.age == 51)
    println("Exercise 4 passed: Optic composition")

    // Exercise 5: Van Laarhoven Lens
    val result5 = vlLensAge[Identity](a => Identity(a + 1))(person)
    assert(result5.value.age == 31)
    println("Exercise 5 passed: Van Laarhoven Lens")

    // Exercise 6: VL get and set
    assert(vlGet(person) == 30)
    assert(vlSet(person, 25).age == 25)
    println("Exercise 6 passed: VL get and set")

    // Exercise 7: Getter via Forget
    val nameGetter = getter[Person, String](_.name)
    assert(useGetter(nameGetter, person) == "Alice")
    println("Exercise 7 passed: Getter via Forget")

    // Exercise 8: Compose lens and prism
    val config = Config("42")
    val modified = modifyConfigInt(config, _ + 1)
    assert(modified.value == "43")
    val nonNumeric = Config("abc")
    val unchanged2 = modifyConfigInt(nonNumeric, _ + 1)
    assert(unchanged2.value == "abc")
    println("Exercise 8 passed: Lens + Prism composition")

    println("\nAll exercises passed!")
  }
}
