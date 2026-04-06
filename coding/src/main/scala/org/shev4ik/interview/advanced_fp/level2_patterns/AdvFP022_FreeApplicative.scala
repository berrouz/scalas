package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP022 - Free Applicative
 *
 * FreeApplicative turns any type constructor into an Applicative.
 * Unlike Free Monad, FreeApplicative allows static analysis of the
 * program structure since effects don't depend on previous results.
 */
object AdvFP022_FreeApplicative {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Applicative[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = ap(pure(f))(fa)
  }

  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // ============================================================
  // Exercise 1: Define FreeApplicative
  // FreeAp[F, A] = Pure(A) | Ap(F[X], FreeAp[F, X => A]) for some X
  // ============================================================
  sealed trait FreeAp[F[_], A]

  // TODO: Implement Pure and Ap cases
  case class PureAp[F[_], A](a: A) extends FreeAp[F, A]

  // Ap needs an existential type - we use a trait
  trait ApCase[F[_], A] extends FreeAp[F, A] {
    type Pivot
    val fp: F[Pivot]
    val fn: FreeAp[F, Pivot => A]
  }

  // ============================================================
  // Exercise 2: Implement lift for FreeApplicative
  // Lift F[A] into FreeAp[F, A]
  // ============================================================
  // TODO: Implement lift
  def lift[F[_], A](fa: F[A]): FreeAp[F, A] = ???

  // ============================================================
  // Exercise 3: Implement map for FreeApplicative
  // ============================================================
  // TODO: Implement map
  def mapFreeAp[F[_], A, B](fa: FreeAp[F, A])(f: A => B): FreeAp[F, B] = ???

  // ============================================================
  // Exercise 4: Implement ap for FreeApplicative
  // ============================================================
  // TODO: Implement ap
  def apFreeAp[F[_], A, B](ff: FreeAp[F, A => B])(fa: FreeAp[F, A]): FreeAp[F, B] = ???

  // ============================================================
  // Exercise 5: Implement foldMap for FreeApplicative
  // Interpret FreeAp[F, A] into G[A] given F ~> G and Applicative[G]
  // ============================================================
  // TODO: Implement foldMap
  def foldMap[F[_], G[_], A](fa: FreeAp[F, A])(nt: F ~> G)(implicit G: Applicative[G]): G[A] = ???

  // ============================================================
  // Exercise 6: Implement static analysis via analyze
  // analyze extracts all F values from a FreeAp using a monoid.
  // analyze: FreeAp[F, A] => (F ~> Const[M, *]) => M
  // ============================================================
  case class Const[M, A](getConst: M)

  trait Monoid[M] {
    def empty: M
    def combine(a: M, b: M): M
  }

  // TODO: Implement analyze - collect all effects without running them
  def analyze[F[_], M, A](fa: FreeAp[F, A])(f: F ~> ({type L[X] = Const[M, X]})#L)(implicit M: Monoid[M]): M = ???

  // ============================================================
  // Exercise 7: Define a validation DSL and demonstrate static analysis
  // Operations: Required(field), MinLength(field, min), MaxLength(field, max)
  // Static analysis: collect all field names that will be validated.
  // ============================================================
  sealed trait ValidationOp[A]
  case class Required(field: String) extends ValidationOp[Boolean]
  case class MinLength(field: String, min: Int) extends ValidationOp[Boolean]
  case class MaxLength(field: String, max: Int) extends ValidationOp[Boolean]

  type Validation[A] = FreeAp[ValidationOp, A]

  // TODO: Create a validation program that checks name (required, min 2) and email (required)
  def validationProgram: Validation[(Boolean, Boolean, Boolean)] = ???

  // TODO: Extract all field names from the validation program
  def extractFields(prog: Validation[_]): Set[String] = ???

  // ============================================================
  // Exercise 8: Show Free vs FreeAp difference
  // Free Monad: effects can depend on previous results (sequential)
  // FreeAp: effects are independent (can be parallelized)
  // Implement a function that counts the number of effects in a FreeAp.
  // ============================================================
  // TODO: Count the number of effects (Ap nodes) in a FreeAp
  def countEffects[F[_], A](fa: FreeAp[F, A]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1-2: FreeAp basics
    val lifted: FreeAp[ValidationOp, Boolean] = lift(Required("name"))
    println("Exercise 1-2 passed: FreeAp defined and lift works")

    // Exercise 3: map
    val mapped = mapFreeAp(lifted)(b => if (b) "valid" else "invalid")
    println("Exercise 3 passed: FreeAp map")

    // Exercise 4: ap
    val fn: FreeAp[ValidationOp, Boolean => String] =
      PureAp[ValidationOp, Boolean => String](b => if (b) "ok" else "fail")
    val applied = apFreeAp(fn)(lifted)
    println("Exercise 4 passed: FreeAp ap")

    // Exercise 5: foldMap
    type Id[A] = A
    implicit val idApplicative: Applicative[Id] = new Applicative[Id] {
      def pure[A](a: A): A = a
      def ap[A, B](ff: A => B)(fa: A): B = ff(fa)
    }
    val interp = new (ValidationOp ~> Id) {
      def apply[A](fa: ValidationOp[A]): A = fa match {
        case Required(_) => true.asInstanceOf[A]
        case MinLength(_, _) => true.asInstanceOf[A]
        case MaxLength(_, _) => true.asInstanceOf[A]
      }
    }
    val result = foldMap(lift[ValidationOp, Boolean](Required("x")))(interp)
    assert(result == true)
    println("Exercise 5 passed: foldMap works")

    // Exercise 6: analyze
    implicit val setMonoid: Monoid[Set[String]] = new Monoid[Set[String]] {
      def empty = Set.empty
      def combine(a: Set[String], b: Set[String]) = a ++ b
    }
    val fieldExtractor = new (ValidationOp ~> ({type L[X] = Const[Set[String], X]})#L) {
      def apply[A](fa: ValidationOp[A]): Const[Set[String], A] = fa match {
        case Required(f) => Const(Set(f))
        case MinLength(f, _) => Const(Set(f))
        case MaxLength(f, _) => Const(Set(f))
      }
    }
    val fields = analyze(lift[ValidationOp, Boolean](Required("name")))(fieldExtractor)
    assert(fields == Set("name"))
    println("Exercise 6 passed: analyze works")

    // Exercise 7: Validation program and field extraction
    val vp = validationProgram
    val allFields = extractFields(vp)
    assert(allFields.contains("name"))
    assert(allFields.contains("email"))
    println("Exercise 7 passed: Validation DSL with static analysis")

    // Exercise 8: Count effects
    assert(countEffects(PureAp[ValidationOp, Int](42)) == 0)
    assert(countEffects(lift[ValidationOp, Boolean](Required("x"))) == 1)
    val prog = validationProgram
    assert(countEffects(prog) == 3)
    println("Exercise 8 passed: Count effects")

    println("\nAll exercises passed!")
  }
}
