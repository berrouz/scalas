package org.shev4ik.rockjvm.cats.refs

import cats.effect.concurrent.Ref
import cats.effect.{ExitCode, IO, IOApp}

object AtomicRef extends IOApp {


  val atomicRef: IO[Ref[IO, Int]] = Ref[IO].of(1)

  val increasedRed: IO[Unit] = atomicRef.flatMap(ref => ref.set(29))

  override def run(args: List[String]): IO[ExitCode] = ???
}
