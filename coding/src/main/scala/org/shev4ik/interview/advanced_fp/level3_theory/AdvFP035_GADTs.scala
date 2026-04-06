package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP035 - GADTs (Generalized Algebraic Data Types)
 *
 * GADTs allow constructors to specialize the type parameter.
 * This enables type-safe DSLs where the type tracks invariants.
 * In Scala, GADTs are encoded using sealed traits with specific type params.
 */
object AdvFP035_GADTs {

  // ============================================================
  // Exercise 1: Typed expression GADT
  // Each constructor constrains the type parameter A.
  // ============================================================
  sealed trait Expr[A]
  case class IntLit(value: Int) extends Expr[Int]
  case class BoolLit(value: Boolean) extends Expr[Boolean]
  case class Add(left: Expr[Int], right: Expr[Int]) extends Expr[Int]
  case class GreaterThan(left: Expr[Int], right: Expr[Int]) extends Expr[Boolean]
  case class IfThenElse[A](cond: Expr[Boolean], ifTrue: Expr[A], ifFalse: Expr[A]) extends Expr[A]

  // TODO: Implement a type-safe evaluator for the expression GADT
  def eval[A](expr: Expr[A]): A = ???

  // ============================================================
  // Exercise 2: Type-safe printf
  // The format string type determines the function signature.
  // ============================================================
  sealed trait Format[A]
  case class FLit[A](s: String, rest: Format[A]) extends Format[A]
  case class FInt[A](rest: Format[A]) extends Format[Int => A]
  case class FStr[A](rest: Format[A]) extends Format[String => A]
  case class FEnd() extends Format[String]

  // TODO: Implement format that converts Format to a function
  def format[A](fmt: Format[A]): A = ???

  // ============================================================
  // Exercise 3: Length-indexed vectors using GADTs
  // ============================================================
  sealed trait Nat
  sealed trait Zero extends Nat
  sealed trait Succ[N <: Nat] extends Nat

  sealed trait Vec[N <: Nat, +A]
  case object VNil extends Vec[Zero, Nothing]
  case class VCons[N <: Nat, A](head: A, tail: Vec[N, A]) extends Vec[Succ[N], A]

  // TODO: Implement a type-safe head (only works on non-empty Vec)
  def vHead[N <: Nat, A](vec: Vec[Succ[N], A]): A = ???

  // TODO: Implement append
  def vAppend[N <: Nat, M <: Nat, A](xs: Vec[N, A], ys: Vec[M, A]): Vec[_, A] = ???

  // ============================================================
  // Exercise 4: Typed state machine
  // States: Idle, Active, Done. Transitions enforced by types.
  // ============================================================
  sealed trait State
  sealed trait Idle extends State
  sealed trait Active extends State
  sealed trait Done extends State

  trait Machine[S <: State] {
    def state: String
  }

  // TODO: Implement state transitions that are type-safe
  def create: Machine[Idle] = ???
  def start(m: Machine[Idle]): Machine[Active] = ???
  def stop(m: Machine[Active]): Machine[Done] = ???
  // stop(create) should NOT compile

  // ============================================================
  // Exercise 5: Phantom types for units of measure
  // ============================================================
  sealed trait Unit
  sealed trait Meters extends Unit
  sealed trait Seconds extends Unit
  sealed trait MetersPerSecond extends Unit

  case class Quantity[U <: Unit](value: Double) {
    def +(other: Quantity[U]): Quantity[U] = Quantity(value + other.value)
  }

  // TODO: Implement division that produces the correct unit type
  def divide(distance: Quantity[Meters], time: Quantity[Seconds]): Quantity[MetersPerSecond] = ???

  // TODO: This should not compile: adding meters and seconds
  // val bad = Quantity[Meters](1.0) + Quantity[Seconds](2.0)

  // ============================================================
  // Exercise 6: Typed red-black tree concept
  // Encode color at the type level to enforce invariants.
  // ============================================================
  sealed trait Color
  sealed trait Red extends Color
  sealed trait Black extends Color

  sealed trait RBTree[C <: Color, +A]
  case object RBLeaf extends RBTree[Black, Nothing]
  case class RBNode[CL <: Color, CR <: Color, A](
    left: RBTree[CL, A],
    value: A,
    right: RBTree[CR, A]
  ) extends RBTree[Black, A]  // Simplified: all nodes are black for this exercise

  // TODO: Create a simple balanced tree
  def singletonTree[A](value: A): RBTree[Black, A] = ???

  // ============================================================
  // Exercise 7: Typed DSL for database queries
  // ============================================================
  sealed trait Query[A]
  case class Select(table: String) extends Query[List[Map[String, String]]]
  case class Count(table: String) extends Query[Int]
  case class Exists(table: String, key: String) extends Query[Boolean]

  // TODO: Implement a type-safe query executor (mock)
  def executeQuery[A](query: Query[A]): A = ???

  // ============================================================
  // Exercise 8: Advanced phantom types - capability tracking
  // Track which operations a value supports at the type level.
  // ============================================================
  sealed trait CanRead
  sealed trait CanWrite
  sealed trait CanClose

  case class Handle[Caps](name: String)

  // TODO: Create a handle with all capabilities
  def openHandle(name: String): Handle[CanRead with CanWrite with CanClose] = ???

  // TODO: Read from a handle (requires CanRead)
  def read[C <: CanRead](h: Handle[C]): String = ???

  // TODO: Write to a handle (requires CanWrite)
  def write[C <: CanWrite](h: Handle[C], data: String): Unit = ???

  // TODO: Close a handle, returning one without CanRead/CanWrite
  def close[C <: CanClose](h: Handle[C]): Handle[CanClose] = ???

  def main(args: Array[String]): scala.Unit = {
    // Exercise 1: Typed expressions
    val expr1: Expr[Int] = Add(IntLit(2), IntLit(3))
    assert(eval(expr1) == 5)
    val expr2: Expr[Boolean] = GreaterThan(IntLit(5), IntLit(3))
    assert(eval(expr2) == true)
    val expr3 = IfThenElse(BoolLit(true), IntLit(1), IntLit(2))
    assert(eval(expr3) == 1)
    println("Exercise 1 passed: Typed expression GADT")

    // Exercise 2: Type-safe printf
    val fmt = FLit("Hello, ", FStr(FLit("! You are ", FInt(FLit(" years old.", FEnd())))))
    val result: String = format(fmt)("Alice")(30)
    assert(result == "Hello, Alice! You are 30 years old.")
    println("Exercise 2 passed: Type-safe printf")

    // Exercise 3: Length-indexed vectors
    val v1 = VCons(1, VCons(2, VCons(3, VNil)))
    assert(vHead(v1) == 1)
    // vHead(VNil) // Should NOT compile
    println("Exercise 3 passed: Length-indexed vectors")

    // Exercise 4: Typed state machine
    val idle = create
    val active = start(idle)
    val done = stop(active)
    assert(done.state == "Done")
    // stop(idle) // Should NOT compile
    println("Exercise 4 passed: Typed state machine")

    // Exercise 5: Phantom types for units
    val d1 = Quantity[Meters](100.0)
    val d2 = Quantity[Meters](50.0)
    val totalDist = d1 + d2
    assert(totalDist.value == 150.0)
    val speed = divide(Quantity[Meters](100.0), Quantity[Seconds](10.0))
    assert(speed.value == 10.0)
    println("Exercise 5 passed: Phantom types for units")

    // Exercise 6: Red-black tree
    val tree = singletonTree(42)
    println("Exercise 6 passed: Typed red-black tree")

    // Exercise 7: Typed DSL
    val count: Int = executeQuery(Count("users"))
    val exists: Boolean = executeQuery(Exists("users", "alice"))
    assert(count >= 0)
    println("Exercise 7 passed: Typed query DSL")

    // Exercise 8: Capability tracking
    val h = openHandle("file.txt")
    val content = read(h)
    write(h, "data")
    val closed = close(h)
    // read(closed) // Should NOT compile if we had proper subtyping constraints
    println("Exercise 8 passed: Phantom type capabilities")

    println("\nAll exercises passed!")
  }
}
