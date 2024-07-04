package org.shev4ik.rockjvm.cats.io

import cats.effect.IO

object IoCats {
  def main(args: Array[String]): Unit = {
    val io: IO[String] = IO.delay("String")
  }
}
