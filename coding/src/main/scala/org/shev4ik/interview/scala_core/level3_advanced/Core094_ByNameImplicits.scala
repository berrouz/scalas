package org.shev4ik.interview.scala_core.level3_advanced

object Core094_ByNameImplicits {

  // Exercise 1: By-name implicit parameters
  // TODO: Define a type class Show[T] with a by-name implicit parameter usage
  //       By-name parameters are evaluated lazily, only when needed
  trait Show[T] {
    def show(t: T): String
  }

  object Show {
    def apply[T](implicit s: Show[T]): Show[T] = s
    def instance[T](f: T => String): Show[T] = new Show[T] { def show(t: T): String = f(t) }
  }

  // TODO: Define Show for basic types
  implicit val showInt: Show[Int] = ???
  implicit val showString: Show[String] = ???

  // Exercise 2: Recursive implicit resolution
  // TODO: Define Show for List[T] that recursively uses Show[T]
  //       This demonstrates how implicit derivation chains work
  implicit def showList[T](implicit s: Show[T]): Show[List[T]] = ???

  // Exercise 3: Lazy implicit
  // TODO: Define a recursive data structure and use lazy val for the implicit
  //       to break circular implicit resolution
  sealed trait Tree[A]
  case class TreeLeaf[A](value: A) extends Tree[A]
  case class TreeNode[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  // TODO: Implement Show for Tree[A] using lazy implicit to handle recursion
  implicit def showTree[A](implicit s: Show[A]): Show[Tree[A]] = ???

  // Exercise 4: Divergent implicit prevention
  // TODO: Show how by-name implicits prevent divergent implicit expansion
  //       Define a type class for JSON encoding with recursive types
  trait JsonEnc[T] {
    def encode(t: T): String
  }

  implicit val jsonEncInt: JsonEnc[Int] = new JsonEnc[Int] {
    def encode(t: Int): String = t.toString
  }

  implicit val jsonEncString: JsonEnc[String] = new JsonEnc[String] {
    def encode(t: String): String = s""""$t""""
  }

  // TODO: Implement JsonEnc for Option[T]
  implicit def jsonEncOption[T](implicit enc: JsonEnc[T]): JsonEnc[Option[T]] = ???

  // Exercise 5: By-name for recursive types
  // TODO: Define a recursive type and its Show instance using by-name implicit
  case class Nested(value: Int, children: List[Nested])

  // TODO: Implement Show for Nested - the implicit for List[Nested] needs Show[Nested]
  //       which is the same instance being defined (recursion!)
  implicit lazy val showNested: Show[Nested] = ???

  // Exercise 6: Shapeless lazy concept
  // TODO: Simulate what Shapeless's Lazy does - wrap an implicit to make it lazy
  case class Lazy[T](value: T)

  object Lazy {
    implicit def mkLazy[T](implicit t: T): Lazy[T] = Lazy(t)
  }

  // TODO: Use Lazy to define a recursive type class instance
  trait Stringify[T] {
    def stringify(t: T): String
  }

  implicit val stringifyInt: Stringify[Int] = new Stringify[Int] {
    def stringify(t: Int): String = t.toString
  }

  // TODO: Implement Stringify for List using Lazy
  implicit def stringifyList[T](implicit ls: Lazy[Stringify[T]]): Stringify[List[T]] = ???

  def stringify[T](value: T)(implicit s: Stringify[T]): String = ???

  // Exercise 7: Recursive type class derivation
  // TODO: Derive a type class for a mutually recursive structure
  sealed trait Expr
  case class Num(n: Int) extends Expr
  case class Add(left: Expr, right: Expr) extends Expr

  // TODO: Implement Show for Expr (recursive)
  implicit lazy val showExpr: Show[Expr] = ???

  // Exercise 8: By-name vs strict
  // TODO: Show the difference between by-name and strict implicit parameters
  //       with a counter that tracks how many times an implicit is evaluated
  var evaluationCount = 0

  trait Counter[T] {
    def count: Int
  }

  def strictImplicit[T](implicit c: Counter[T]): Int = ???
  def lazyUsage[T](f: => Counter[T]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(Show[Int].show(42) == "42")
    assert(Show[String].show("hello") == "\"hello\"")

    // Exercise 2
    assert(Show[List[Int]].show(List(1, 2, 3)) == "[1, 2, 3]")

    // Exercise 3
    val tree: Tree[Int] = TreeNode(TreeLeaf(1), TreeNode(TreeLeaf(2), TreeLeaf(3)))
    val treeStr = Show[Tree[Int]].show(tree)
    assert(treeStr.contains("1") && treeStr.contains("2") && treeStr.contains("3"))

    // Exercise 4
    assert(jsonEncOption[Int].encode(Some(42)) == "42")
    assert(jsonEncOption[Int].encode(None) == "null")

    // Exercise 5
    val nested = Nested(1, List(Nested(2, Nil), Nested(3, List(Nested(4, Nil)))))
    val nestedStr = Show[Nested].show(nested)
    assert(nestedStr.contains("1") && nestedStr.contains("4"))

    // Exercise 6
    assert(stringify(List(1, 2, 3)) == "[1, 2, 3]")

    // Exercise 7
    val expr: Expr = Add(Num(1), Add(Num(2), Num(3)))
    val exprStr = Show[Expr].show(expr)
    assert(exprStr.contains("1") && exprStr.contains("2") && exprStr.contains("3"))

    // Exercise 8
    evaluationCount = 0
    implicit val intCounter: Counter[Int] = new Counter[Int] {
      evaluationCount += 1
      def count: Int = evaluationCount
    }
    val c = strictImplicit[Int]
    assert(c >= 1)

    println("All Core094_ByNameImplicits exercises passed!")
  }
}
