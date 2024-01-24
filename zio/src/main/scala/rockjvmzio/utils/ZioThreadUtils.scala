package main.scala.rockjvmzio.utils

import zio.ZIO
import zio.stm.{USTM, ZSTM}

import scala.language.implicitConversions

object ZioThreadUtils {
  implicit class ThreadUtils[R,E,T](zio: ZIO[R,E,T]) {
    def debugT: ZIO[R, E, T] = {
      zio.tap(t => ZIO.succeed(println(s"[${Thread.currentThread().getName}] $t")))
    }
  }

  implicit class ThreadUtilsUSTM[R,E,T](zio: USTM[T]) {
    def debugT: USTM[T] = {
      zio.tap(t => ZSTM.succeed(println(s"[${Thread.currentThread().getName}] $t")))
    }
  }
}
