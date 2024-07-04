package org.shev4ik.advanced.scala2.macros
import scala.language.experimental.macros

object MacrosAppUsage extends App {

  MacrosApp.printType(42)
  MacrosApp.printType("HelloWorld")
}
