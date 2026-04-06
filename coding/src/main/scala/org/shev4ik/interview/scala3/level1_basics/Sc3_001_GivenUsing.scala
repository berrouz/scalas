package org.shev4ik.interview.scala3.level1_basics

/**
 * Scala 3: given/using -- The New Contextual Abstraction System
 *
 * =Overview=
 * Scala 3 fundamentally redesigns how contextual abstractions work. The overloaded `implicit`
 * keyword from Scala 2 is replaced by several distinct, purpose-specific mechanisms. This
 * separation makes code clearer about ''what'' is being done and ''why''.
 *
 * =Scala 2 implicit (overloaded, confusing)=
 * In Scala 2, `implicit` served too many purposes simultaneously:
 *  - `implicit val` -- provide a type class instance
 *  - `implicit def` -- derive an instance from other instances
 *  - `implicit class` -- add extension methods
 *  - `implicit` parameter -- request contextual dependency
 *  - `implicit` conversion -- auto-convert between types (dangerous!)
 *
 * =Scala 3 Replacement: Separate Mechanisms=
 *
 * '''1. given -- Defining Instances'''
 * {{{
 *   // Scala 2: implicit val intOrd: Ordering[Int] = ...
 *   // Scala 3:
 *   given intOrd: Ordering[Int] with
 *     def compare(x: Int, y: Int): Int = x - y
 *
 *   // Anonymous given (when the name doesn't matter):
 *   given Ordering[Int] with
 *     def compare(x: Int, y: Int): Int = x - y
 * }}}
 *
 * '''2. using -- Requesting Contextual Parameters'''
 * {{{
 *   // Scala 2: def sort[A](xs: List[A])(implicit ord: Ordering[A]): List[A]
 *   // Scala 3:
 *   def sort[A](xs: List[A])(using ord: Ordering[A]): List[A]
 * }}}
 *
 * '''3. extension -- Adding Methods to Existing Types'''
 * {{{
 *   // Scala 2: implicit class RichInt(val i: Int) extends AnyVal { def isEven = i % 2 == 0 }
 *   // Scala 3:
 *   extension (i: Int)
 *     def isEven: Boolean = i % 2 == 0
 * }}}
 *
 * '''4. summon -- Retrieving Instances (replaces implicitly)'''
 * {{{
 *   // Scala 2: val ord = implicitly[Ordering[Int]]
 *   // Scala 3:
 *   val ord = summon[Ordering[Int]]
 * }}}
 *
 * '''5. Conditional given (derived instances)'''
 * {{{
 *   // Scala 2: implicit def optionOrd[A](implicit ord: Ordering[A]): Ordering[Option[A]]
 *   // Scala 3:
 *   given [A](using ord: Ordering[A]): Ordering[Option[A]] with
 *     def compare(x: Option[A], y: Option[A]): Int = ...
 * }}}
 *
 * '''6. Context Functions (new in Scala 3)'''
 * {{{
 *   type Executable[A] = ExecutionContext ?=> A
 *   // The ?=> arrow means ExecutionContext is passed implicitly (contextually)
 * }}}
 *
 * =Why This Matters=
 *  - '''Clarity of intent''': `given` makes it obvious you are providing an instance;
 *    `using` makes it clear you are consuming one
 *  - '''No accidental implicit conversions''': Conversions require explicit `Conversion[A, B]`
 *    given instances -- no more surprise coercions
 *  - '''Better error messages''': The compiler knows what kind of contextual element is
 *    missing and can give targeted suggestions
 *  - '''Import control''': `import mypackage.given` imports only given instances,
 *    separate from regular imports
 *
 * =Real-World Impact=
 * In production Scala 3 codebases, these changes make type class patterns significantly
 * more readable. Libraries like Cats, Circe, and http4s are being migrated to use `given`/`using`,
 * and the ecosystem is converging on this cleaner abstraction.
 *
 * =Interview Tip=
 * ''"How do given/using improve over Scala 2 implicits?"''
 *
 * '''Answer:''' Scala 3 separates the overloaded `implicit` keyword into distinct mechanisms,
 * each with clear intent: `given` for defining instances, `using` for requesting contextual
 * parameters, `extension` for adding methods, and `summon` for retrieving instances. This
 * eliminates the ambiguity of Scala 2 where the same `implicit` keyword served five different
 * purposes. Additionally, implicit conversions now require an explicit `Conversion[A, B]` given
 * instance, preventing accidental type coercions that were a major source of bugs. The `given`
 * import syntax (`import foo.given`) provides fine-grained control over which instances are
 * in scope.
 *
 * Here we model these Scala 3 concepts using Scala 2.13 implicit mechanisms.
 */
object Sc3_001_GivenUsing {

  // === Setup ===

  trait Ordering[A] {
    def compare(x: A, y: A): Int
  }

  trait Show[A] {
    def show(a: A): String
  }

  trait Monoid[A] {
    def empty: A
    def combine(x: A, y: A): A
  }

  case class Config(host: String, port: Int)
  case class DbConnection(url: String)

  // Exercise 1: Basic given/using (modeled as implicit val + implicit parameter)
  // In Scala 3: given intOrdering: Ordering[Int] = new Ordering[Int] { ... }
  //             def maxOf(a: Int, b: Int)(using ord: Ordering[Int]): Int = ...
  // TODO: Define an implicit val `intOrdering` of type Ordering[Int] that compares integers naturally.
  //       Then implement `maxOf` that takes two Ints and an implicit Ordering[Int],
  //       returning the larger value using ord.compare.
  implicit val intOrdering: Ordering[Int] = ???
  def exercise1_basicGivenUsing(a: Int, b: Int)(implicit ord: Ordering[Int]): Int = ???

  // Exercise 2: given with derivation pattern (modeled as implicit def)
  // In Scala 3: given listOrdering[A](using ord: Ordering[A]): Ordering[List[A]] = ...
  // TODO: Define an implicit def `listOrdering` that, given an implicit Ordering[A],
  //       creates an Ordering[List[A]] that compares by length first, then element-by-element.
  //       Return negative if first list is "smaller", positive if "larger", 0 if equal.
  implicit def listOrdering[A](implicit ord: Ordering[A]): Ordering[List[A]] = ???
  def exercise2_derivedGiven(a: List[Int], b: List[Int])(implicit ord: Ordering[List[Int]]): Int = ???

  // Exercise 3: Multiple using clauses (modeled as multiple implicit parameter lists)
  // In Scala 3: def format[A](a: A)(using show: Show[A], config: Config): String
  // TODO: Implement `formatWithConfig` that takes a value of type A,
  //       an implicit Show[A] and an implicit Config.
  //       Return s"[${config.host}:${config.port}] ${show.show(a)}"
  def exercise3_multipleUsing[A](a: A)(implicit show: Show[A], config: Config): String = ???

  // Exercise 4: Summoning instances (Scala 3 summon vs Scala 2 implicitly)
  // In Scala 3: val ord = summon[Ordering[Int]]
  // TODO: Use `implicitly` to summon the Ordering[Int] instance and use it to sort
  //       the given list in ascending order. Return the sorted list.
  def exercise4_summon(xs: List[Int]): List[Int] = ???

  // Exercise 5: Context bound sugar
  // In Scala 3: def sorted[A: Ordering](xs: List[A]): List[A]
  // This is the same in Scala 2! Context bounds work in both versions.
  // TODO: Implement `sorted` using a context bound [A: Ordering].
  //       Use implicitly[Ordering[A]] inside to access the ordering.
  //       Sort the list using a simple insertion sort or use the Ordering to compare and sort.
  def exercise5_contextBound[A: Ordering](xs: List[A]): List[A] = ???

  // Exercise 6: given for type classes (modeled as companion implicit)
  // In Scala 3: given Show[Int] with { def show(a: Int) = s"Int($a)" }
  // TODO: Create implicit Show instances for Int and String in the companion-like pattern.
  //       Show[Int] should produce "Int(<value>)", Show[String] should produce "Str(<value>)".
  //       Then implement `showPair` that takes an A and B with implicit Show instances
  //       and returns "(<showA>, <showB>)".
  implicit val intShow: Show[Int] = ???
  implicit val stringShow: Show[String] = ???
  def exercise6_typeclassGiven[A, B](a: A, b: B)(implicit sa: Show[A], sb: Show[B]): String = ???

  // Exercise 7: Conditional given (modeled as implicit def with constraints)
  // In Scala 3: given [A](using m: Monoid[A]): Monoid[Option[A]] with { ... }
  // TODO: Define an implicit Monoid[Int] where empty = 0 and combine = +.
  //       Then define an implicit def monoidOption that, given a Monoid[A],
  //       produces a Monoid[Option[A]] where:
  //         empty = None
  //         combine(Some(a), Some(b)) = Some(m.combine(a, b))
  //         combine(Some(a), None) = Some(a)
  //         combine(None, Some(b)) = Some(b)
  //         combine(None, None) = None
  //       Return the result of combining all elements.
  implicit val intMonoid: Monoid[Int] = ???
  implicit def optionMonoid[A](implicit m: Monoid[A]): Monoid[Option[A]] = ???
  def exercise7_conditionalGiven(xs: List[Option[Int]])(implicit m: Monoid[Option[Int]]): Option[Int] = ???

  // Exercise 8: Context function pattern (Scala 3 context functions modeled with implicit functions)
  // In Scala 3: type Configured[A] = Config ?=> A (context function type)
  // In Scala 2, we model this as Config => A where Config is passed implicitly at call site.
  // TODO: Define a type alias `Configured[A]` as `Config => A`.
  //       Implement `dbUrl` as a Configured[String] that produces s"jdbc://${config.host}:${config.port}/db".
  //       Implement `runConfigured` that takes a Config and a Configured[A] and returns A.
  type Configured[A] = Config => A
  val exercise8_dbUrl: Configured[String] = ???
  def exercise8_runConfigured[A](config: Config)(f: Configured[A]): A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_basicGivenUsing(3, 7) == 7, "Exercise 1 failed")
    assert(exercise1_basicGivenUsing(10, 2) == 10, "Exercise 1 failed")

    // Exercise 2
    assert(exercise2_derivedGiven(List(1, 2), List(1, 2, 3)) < 0, "Exercise 2 failed: shorter list should be smaller")
    assert(exercise2_derivedGiven(List(1, 3), List(1, 2)) > 0, "Exercise 2 failed: element-wise comparison")
    assert(exercise2_derivedGiven(List(1, 2), List(1, 2)) == 0, "Exercise 2 failed: equal lists")

    // Exercise 3
    implicit val testConfig: Config = Config("localhost", 8080)
    assert(exercise3_multipleUsing(42) == "[localhost:8080] Int(42)", "Exercise 3 failed")
    assert(exercise3_multipleUsing("hello") == "[localhost:8080] Str(hello)", "Exercise 3 failed")

    // Exercise 4
    assert(exercise4_summon(List(3, 1, 4, 1, 5)) == List(1, 1, 3, 4, 5), "Exercise 4 failed")

    // Exercise 5
    assert(exercise5_contextBound(List(5, 3, 1, 4, 2)) == List(1, 2, 3, 4, 5), "Exercise 5 failed")

    // Exercise 6
    assert(exercise6_typeclassGiven(42, "hello") == "(Int(42), Str(hello))", "Exercise 6 failed")

    // Exercise 7
    assert(exercise7_conditionalGiven(List(Some(1), Some(2), None, Some(3))) == Some(6), "Exercise 7 failed")
    assert(exercise7_conditionalGiven(List(None, None)) == None, "Exercise 7 failed")

    // Exercise 8
    val cfg = Config("db.example.com", 5432)
    assert(exercise8_runConfigured(cfg)(exercise8_dbUrl) == "jdbc://db.example.com:5432/db", "Exercise 8 failed")

    println("All Sc3_001_GivenUsing exercises passed!")
  }
}
