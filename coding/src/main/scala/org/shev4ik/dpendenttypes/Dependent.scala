package org.shev4ik.dpendenttypes

object Dependent extends App {

  trait TemplateBuilder {
    type TTT <: TemplateType
    def body(a: TTT#I): String
  }

  object IntTemplateBuilder extends TemplateBuilder {
    override type TTT = TemplateType { type I = String}
    override def body(a: String): String = a
  }

  object StringTemplateBuilder extends TemplateBuilder {
    override type TTT = TemplateType { type I = Int}
    override def body(a: Int): String = a.toString
  }

  sealed trait TemplateType {
    type I
  }

  object SmsTemplate extends TemplateType {
    type I = String
  }

  object EmailTemplate extends TemplateType {
    type I = Int
  }
/*
  def getBuilder[I](builder: TemplateType { type I = I})(t: builder.I): String = {
    builder
  }

  getBuilder(IntTemplateBuilder)(1)
  getBuilder(SmsTemplate#I)(Temp("string"))*/

  case class Temp(s: String)



  /*
  *
  * sealed trait MergeStrategy {
    type Output[_]
  }
  object MergeStrategy {
    case object Single extends MergeStrategy { type Output[A] = A }
    case object Multiple extends MergeStrategy { type Output[A] = List[A] }
    case object None extends MergeStrategy { type Output[_] = Unit }
  }


  def merge[E](files: List[E]): E = {
    files.head
  }
  def merge[E, O[_], T](files: List[E], mergeStrategy: MergeStrategy {type Output[A] = O[A]})(f: O[E] => T): T = {
    mergeStrategy match {
      case MergeStrategy.Single => f(merge(files))
      case MergeStrategy.Multiple => f(files)
      case MergeStrategy.None => f(())
    }
  }

  val list: immutable.List[Int] = List(1,2)

  merge(list, MergeStrategy.Single){ file: Int => 1}
  //merge(List(1,2), MergeStrategy.Multiple){ files => ???}*/
}
