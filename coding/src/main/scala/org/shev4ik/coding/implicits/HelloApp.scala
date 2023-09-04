package org.shev4ik.coding.implicits

object HelloApp extends App {

  def implScope(implicit h: MyClass): Unit = {
    println(h)
  }
  import WildcardImports._
  implScope
}

object WildcardImports {
  implicit val wild: String = "wild"
}

class MyClass

object MyClass {
  implicit val m: MyClass = new MyClass
}
