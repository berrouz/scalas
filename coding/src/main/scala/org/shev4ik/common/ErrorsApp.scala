package org.shev4ik.common

import scala.concurrent.{ExecutionContext, Future}

object ErrorsApp extends App {

  def generic() = ???

  def generic(i: Int) = ???

  def allowedOverride(a: Int, b: String) = ???

  def allowedOverride(a: Int, b: Int) = ???

  def zoo(any: Any) = any match {
    case "sammy"   => ???
    case s: String => ???
  }

  def voo[A <: Any](a: A): Unit = println(a)

  def moo[T](f: => T)(implicit execution: ExecutionContext): Future[T] = Future { f }

  def print(a: => Any) = a != null && a != null

  print(println("hello"))
}
