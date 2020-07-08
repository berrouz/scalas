package org.shev4ik.coding.shapeless

import shapeless.ops.record.{Keys, _}
import shapeless._, record._
import shapeless.ops.hlist.ZipWithKeys

object Attempt extends App {


  import shapeless._

  case class User(name: String, city: String, age: Int)

  val genUser = LabelledGeneric[User]

  val keys = Keys[genUser.Repr].apply().toList.map(_.name)


  import shapeless.ops.hlist._
  class GetByType {
    def apply[V, Repr <: HList, KeysRepr <: HList, ValuesRepr <: HList, FieldsRepr <: HList](value: V)
                            (implicit gen: LabelledGeneric.Aux[V, Repr],
                             fields: Fields.Aux[Repr, ValuesRepr],
                            ) =
      gen.to(value).fields
  }

  val user = User("john", "Kyiv", 10)

  def getByType = new GetByType

  println(getByType.apply(user))



  object generics {
    import shapeless.{HList, ::, HNil}
    val product: String :: String :: Int :: HNil = Generic[User].to(user)
  }
}
