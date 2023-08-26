package org.shev4ik

object ForComprehensionFlat extends App {

  for {
    (age, name) <- either
   } yield ()


  def either: Option[(Int, String)] = {
    Some((1, "1"))
  }

}
