package org.shev4ik.books.scala_in_action.chapter8

import scala.reflect.runtime.universe._
object CalculatorApp extends App {
  trait Calculator[C] {
    def initialize: C
    def close(s: C): Unit
    def calculate(productId: String): Double = {
      val s = initialize
      val price = calculate(s, productId)
      close(s)
      price
    }

    def calculate(s: C, productId: String): Double
   }


  trait DbConnection {
    def connect: String = "connect"
  }


  new {} with Calculator [DbConnection]{
    override def initialize: DbConnection = ???

    override def close(s: DbConnection): Unit = s.connect

    override def calculate(s: DbConnection, productId: String): Double = ???
  }



  trait Strategy {
    type T
    def make(t: T): Unit

    def print(t: T): Unit = {
      println(t)
    }
  }

  class GoldStrategy extends Strategy {
    type T = String
    override def make(t: String): Unit = print(t)
  }
  class SilverStrategy extends Strategy {
    type T = Int
    override def make(t: Int): Unit = print(t)
  }

  val gold: Strategy = new GoldStrategy()
  val silver: Strategy = new SilverStrategy()



  trait Processor {
    def find(): Int
    def process(i: Int): String

    def run: String = {
      process(find()) + "end"
    }
  }

  class PrimaryProcessor extends Processor {
    override def find(): Int = 1

    override def process(i: Int): String = i.toString
  }

  class SecondaryProcessor extends Processor {
    override def find(): Int = 2

    override def process(i: Int): String = i.toString
  }


  val primary: Processor = new PrimaryProcessor
  val secondary: Processor = new SecondaryProcessor

  primary.run

  class Box {
    type S
  }

  def getF(b: Box): b.S = ???

   val s: String = getF(new Box { type S = String})
   val i: Int = getF(new Box { type S = Int})

}
