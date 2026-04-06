package org.shev4ik.rockjvm.advanced_scala.structural_teams

object StructuralTypes extends App {

  type JavaCloseable = java.io.Closeable

  class HipsterCloseable {
    def close(): Unit = println("year")
  }

  type UnifiedCloseable = {
    def close(): Unit
  }

  // type refinements
}
