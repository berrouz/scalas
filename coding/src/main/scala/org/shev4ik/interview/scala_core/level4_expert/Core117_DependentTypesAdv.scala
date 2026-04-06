package org.shev4ik.interview.scala_core.level4_expert

object Core117_DependentTypesAdv {

  // Exercise 1: Pi types simulation
  // TODO: Simulate Pi types (dependent function types) in Scala 2
  //       A Pi type is a function where the return type depends on the argument value
  trait TypedKey {
    type Value
  }

  val nameKey: TypedKey { type Value = String } = new TypedKey { type Value = String }
  val ageKey: TypedKey { type Value = Int } = new TypedKey { type Value = Int }

  // TODO: Implement a dependent function that returns different types based on key
  trait DependentLookup {
    def apply(key: TypedKey): key.Value
  }

  // TODO: Create a DependentLookup instance
  def createLookup(data: Map[TypedKey, Any]): DependentLookup = ???

  // Exercise 2: Sigma types simulation
  // TODO: Simulate Sigma types (dependent pair types)
  //       A Sigma type is a pair where the type of the second component depends on the first
  trait Sigma {
    type First
    val first: First
    type Second
    val second: Second
  }

  // TODO: Create a Sigma value
  def mkSigma[A, B](a: A, b: B): Sigma { type First = A; type Second = B } = ???

  // Exercise 3: Dependent pair
  // TODO: Define a dependent pair where the second type depends on the first value
  trait DepPair {
    val key: TypedKey
    val value: key.Value
  }

  // TODO: Create a DepPair
  def mkDepPair(k: TypedKey)(v: k.Value): DepPair = ???

  // Exercise 4: Type-level lookup
  // TODO: Implement a type-safe heterogeneous map with type-level lookup
  class TypedMap private (private val data: Map[TypedKey, Any]) {
    def get(k: TypedKey): Option[k.Value] = ???
    def put(k: TypedKey)(v: k.Value): TypedMap = ???
  }

  object TypedMap {
    def empty: TypedMap = ???
  }

  // Exercise 5: Type-safe printf concept
  // TODO: Simulate type-safe printf using dependent types
  //       Format string determines the argument types at compile time
  sealed trait Format
  case object FInt extends Format
  case object FStr extends Format
  case object FLit extends Format

  // TODO: Implement a simple type-safe formatter
  def formatInt(n: Int): String = ???
  def formatStr(s: String): String = ???
  def format(template: String, args: Any*): String = ???

  // Exercise 6: Length-indexed vector
  // TODO: Define a vector whose length is tracked at the type level
  sealed trait Nat
  class Z extends Nat
  class S[N <: Nat] extends Nat

  type _0 = Z
  type _1 = S[_0]
  type _2 = S[_1]
  type _3 = S[_2]

  sealed trait Vec[N <: Nat, +A]
  case object VNil extends Vec[_0, Nothing]
  case class VCons[N <: Nat, A](head: A, tail: Vec[N, A]) extends Vec[S[N], A]

  // TODO: Implement head (only works on non-empty Vec)
  def vHead[N <: Nat, A](vec: Vec[S[N], A]): A = ???

  // TODO: Implement append
  def vCons[N <: Nat, A](a: A, vec: Vec[N, A]): Vec[S[N], A] = ???

  // Exercise 7: Type-safe matrix concept
  // TODO: Define matrix dimensions at type level (simplified)
  case class Matrix[R <: Nat, C <: Nat](rows: Int, cols: Int, data: Vector[Vector[Double]])

  // TODO: Matrix multiplication type signature (rows and cols must match)
  def matMul[R <: Nat, K <: Nat, C <: Nat](
    a: Matrix[R, K], b: Matrix[K, C]
  ): Matrix[R, C] = ???

  // Exercise 8: Dependent elimination
  // TODO: Show how dependent types enable safe elimination (pattern matching)
  sealed trait Expr[T]
  case class IntExpr(n: Int) extends Expr[Int]
  case class StrExpr(s: String) extends Expr[String]
  case class BoolExpr(b: Boolean) extends Expr[Boolean]

  // TODO: Type-safe eval using dependent types (return type matches Expr type param)
  def eval[T](expr: Expr[T]): T = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val lookup = createLookup(Map(nameKey -> "Alice", ageKey -> 30))
    val n: String = lookup(nameKey)
    val a: Int = lookup(ageKey)
    assert(n == "Alice")
    assert(a == 30)

    // Exercise 2
    val sigma = mkSigma("hello", 42)
    assert(sigma.first == "hello")
    assert(sigma.second == 42)

    // Exercise 3
    val pair = mkDepPair(nameKey)("Bob")
    assert(pair.value == "Bob")

    // Exercise 4
    val tmap = TypedMap.empty.put(nameKey)("Charlie").put(ageKey)(25)
    assert(tmap.get(nameKey) == Some("Charlie"))
    assert(tmap.get(ageKey) == Some(25))

    // Exercise 5
    assert(formatInt(42) == "42")
    assert(formatStr("hello") == "hello")
    assert(format("Hello %s, you are %s", "Alice", "30") == "Hello Alice, you are 30")

    // Exercise 6
    val v1 = VCons(1, VCons(2, VCons(3, VNil)))
    assert(vHead(v1) == 1)
    val v2 = vCons(0, v1)
    assert(vHead(v2) == 0)

    // Exercise 7
    val m1 = Matrix[_2, _3](2, 3, Vector(Vector(1.0, 2.0, 3.0), Vector(4.0, 5.0, 6.0)))
    val m2 = Matrix[_3, _1](3, 1, Vector(Vector(1.0), Vector(2.0), Vector(3.0)))
    val result = matMul(m1, m2)
    assert(result.rows == 2 && result.cols == 1)

    // Exercise 8
    assert(eval(IntExpr(42)) == 42)
    assert(eval(StrExpr("hello")) == "hello")
    assert(eval(BoolExpr(true)) == true)

    println("All Core117_DependentTypesAdv exercises passed!")
  }
}
