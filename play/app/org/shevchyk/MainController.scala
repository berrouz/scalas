package org.shevchyk

import akka.util.ByteString
import play.api.http.{ContentTypes, Writeable}
import play.api.libs.json.{JsObject, JsValue, Json, OFormat, OWrites, Writes}
import play.api.mvc.{Action, AnyContent, Codec, InjectedController}

import java.nio.charset.{Charset, StandardCharsets}
import javax.inject.Inject

class MainController @Inject()() extends InjectedController {

  def index: Action[AnyContent] =
    Action {
      Ok(HealthView("health"))
    }


  private val json2bytes: JsValue => ByteString = { json =>
    Codec.utf_8.encode(json.toString)
  }


  implicit def writableJson[A: Writes]: Writeable[A] = {
    val transform = (any: A) => json2bytes((JsonRich(any)).asJson)
    Writeable[A](transform, Some(ContentTypes.JSON))
  }
}
case class HealthView(value: String)

object HealthView {
  implicit val format: OFormat[HealthView] = Json.format[HealthView]
}


case class JsonRich[T](val value: T) extends AnyVal {

  def asJson(implicit writes: Writes[T]): JsValue =
    writes.writes(value)

  def asJsObject(implicit writes: OWrites[T]): JsObject =
    writes.writes(value)

  def asJsonString(implicit writes: Writes[T]): String =
    Json.stringify(writes.writes(value))

  def asJsonBytes(charset: Charset = StandardCharsets.UTF_8)(implicit writes: Writes[T]): Array[Byte] =
    Json.stringify(writes.writes(value)).getBytes(charset)

  def asPrettyJson(implicit writes: Writes[T]): String =
    Json.prettyPrint(writes.writes(value))

}