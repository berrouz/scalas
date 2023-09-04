package org.shev4ik.coding.scalatypes

object ScalaManifest extends App {
  def start[A](cats: List[A])(implicit manifest: Manifest[A]): Unit = manifest.toString match {
    case "Int"              => println("List[Int]")
    case "java.lang.String" => println("List[String]")
    case _                  => println("other")
  }

  println(start(List("a", "b")))
  println(start(List(1, 2, 3)))
}
