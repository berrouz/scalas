import magnolia1.{CaseClass, Magnolia, SealedTrait}
import org.json4s.{JArray, JObject, JString, JValue}

import scala.language.experimental.macros

object MagnoliaApp extends App {

  trait Show[T] {
    def show(t: T): String
  }

  implicit val showString: Show[String] = identity
  implicit val showInt: Show[Int] = _.toString

  case class Person(name: String, age: Int)


  implicit val showPerson: Show[Person] =
    (t: Person) => s"Person(${showString.show(t.name)}, ${showInt.show(t.age)}}"


  object ShowDerivation {
    type Typeclass[T] = Show[T]

  }


  object AvroSchemaDerivation {
    trait SchemaGenerator[A] {
      def generate: JValue
    }


    type Typeclass[T] = SchemaGenerator[T]

    def combine[T](ctx: CaseClass[SchemaGenerator, T]): SchemaGenerator[T] = new SchemaGenerator[T] {
      override def generate: JValue = {
        val fields = ctx.parameters.map { param =>
          val res = param.typeclass.generate
          JObject("name" -> JString(param.label),
            "type" -> res)
        }.toList
        JObject(
          "type" -> JString("record"),
          "name" -> JString(ctx.typeName.short),
          "namespace" -> JString(ctx.typeName.owner),
          "fields" -> JArray(fields)
        )
      }
    }

    def dispatch[T](ctx: SealedTrait[SchemaGenerator, T]): SchemaGenerator[T] = new SchemaGenerator[T] {
      override def generate: JValue = {
        val children = ctx.subtypes.map { st =>
          st.typeclass.generate
        }
        JArray(children.toList)
      }
    }

    implicit def avroSchema[T]: SchemaGenerator[T] = macro Magnolia.gen[T]
  }


  //val simpleGenerator = AvroSchemaDerivation.avroSchema[Person]

  //println(simpleGenerator.generate)

}
