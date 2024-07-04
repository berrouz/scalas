package org.shev4ik.rockjvm.catseffects

import java.time.LocalDate
import java.util.Date

object IoMonadApp extends App {


  case class MyIO[A](unsafeRun: () => A){
    def map[B](f: A => B): MyIO[B] = {
      MyIO(() => f(unsafeRun()))
    }

    def flatMap[B](f: A => MyIO[B]): MyIO[B] = {
      MyIO(() => f(unsafeRun()).unsafeRun())
    }
  }
  def measure[T](computation: MyIO[T]): MyIO[Long] = for {
    start <- MyIO(LocalDate.now)
    _     <- computation
    end   <- MyIO(LocalDate.now)
  } yield (end.toEpochDay - start.toEpochDay)
}
