package org.shev4ik.coding.other

import java.net.{HttpURLConnection, URL}
import scala.io.Source

object HttpRequester extends App {


  val url = "https://dein-rundfunkbeitrag.de/"

  1.to(1000).foreach(_ => sendGetRequest(url))

  def sendGetRequest(url: String): String = {
    val connection = new URL(url).openConnection().asInstanceOf[HttpURLConnection]
    connection.setRequestMethod("GET")
    connection.setConnectTimeout(5000)
    connection.setReadTimeout(5000) //

    try {
      val responseCode = connection.getResponseCode
      if (responseCode == HttpURLConnection.HTTP_OK) { // код 200 - успешный ответ
        val source = Source.fromInputStream(connection.getInputStream)
        val response = source.mkString
        source.close()
        response
      } else {
        s"Ошибка: $responseCode"
      }
    } finally {
      connection.disconnect()
    }
  }
}
