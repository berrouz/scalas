package org.shev4ik.coding

import io.circe.generic.extras.Configuration
import io.circe.generic.extras.decoding.ConfiguredDecoder
import io.circe.generic.extras.encoding.ConfiguredAsObjectEncoder
import io.circe.generic.extras.semiauto.{deriveConfiguredDecoder, deriveConfiguredEncoder}
import io.circe.{Decoder, Encoder}

object CirceMain extends App {
  case class Person(age: Int, name: String)

  object Person extends HasJsonCodecFor[Person]

}

trait HasJsonCodecFor[A] {
  implicit val config: Configuration = Configuration.default.withSnakeCaseMemberNames
  implicit def decoder(implicit d: shapeless.Lazy[ConfiguredDecoder[A]]): Decoder[A] =
    deriveConfiguredDecoder
  implicit def encoder(implicit d: shapeless.Lazy[ConfiguredAsObjectEncoder[A]]): Encoder[A] =
    deriveConfiguredEncoder

}
