package org.shev4ik.rozetka
import sttp.client3.HttpURLConnectionBackend
import sttp.client3.quick._

import java.time.{LocalDateTime, ZoneOffset}
import scala.util.Random

object RozetkaRater extends App {
  val backend = HttpURLConnectionBackend()


  val dateEnd = LocalDateTime.now.plusHours(5)
  while(LocalDateTime.now.toEpochSecond(ZoneOffset.UTC) < dateEnd.toEpochSecond(ZoneOffset.UTC)){
    basicRequest
      .get(uri"https://rozetka.com.ua/361734021/p361734021/")
      .send(backend)
    Thread.sleep(20000 + Random.nextInt(2000))
  }
  println("success")
}
