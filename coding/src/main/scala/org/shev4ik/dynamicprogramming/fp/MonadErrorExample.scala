package org.shev4ik.dynamicprogramming.fp

import cats.MonadError

import scala.language.higherKinds

object MonadErrorExample extends App {
  def toJson[F[_]](str: String)(implicit M: MonadError[F, Throwable]): F[Json] =
    if (true) M.pure(Json())
    else M.raiseError(ParseException("Could not parse JSON String"))
}



case class ParseException(str: String) extends Throwable
case class Json()