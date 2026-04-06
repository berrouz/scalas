package org.shev4ik.interview.scala_core.level2_intermediate

object Core051_TraitLinearization {

  // Exercise 1: Linearization algorithm
  // TODO: Given traits A, B extends A, C extends A, D extends B with C
  //       What is the linearization of D?
  //       Return the linearization as a List of trait names
  //       Algorithm: D + lin(C) + lin(B) + lin(A), removing duplicates from right
  trait A1 { def name: String = "A" }
  trait B1 extends A1 { override def name: String = "B" }
  trait C1 extends A1 { override def name: String = "C" }
  class D1 extends B1 with C1

  // TODO: Return the linearization order of D1 as a list
  def linearizationOfD1: List[String] = ???

  // Exercise 2: super calls
  // TODO: Create a chain of traits that each call super
  //       trait Base { def process(s: String): String = s }
  //       trait AddBrackets extends Base { override def process(s: String) = "[" + super.process(s) + "]" }
  //       trait AddParens extends Base { override def process(s: String) = "(" + super.process(s) + ")" }
  //       class Processor extends AddBrackets with AddParens
  //       What does Processor.process("x") return?
  trait Base {
    def process(s: String): String = s
  }
  trait AddBrackets extends Base {
    override def process(s: String): String = "[" + super.process(s) + "]"
  }
  trait AddParens extends Base {
    override def process(s: String): String = "(" + super.process(s) + ")"
  }

  def processorResult: String = ???

  // Exercise 3: Diamond problem
  // TODO: Demonstrate the diamond problem and how Scala resolves it
  //       trait Animal { def sound: String }
  //       trait Dog extends Animal { override def sound = "woof" }
  //       trait Robot extends Animal { override def sound = "beep" }
  //       class RoboDog extends Dog with Robot
  //       What does RoboDog.sound return?
  trait Animal { def sound: String = "..." }
  trait Dog extends Animal { override def sound: String = "woof" }
  trait Robot extends Animal { override def sound: String = "beep" }

  def roboDogSound: String = ???

  // Exercise 4: Linearization with abstract override
  // TODO: Create stackable traits using abstract override
  //       The key is that abstract override requires a concrete implementation in the chain
  trait Transformer {
    def transform(s: String): String
  }
  trait UpperCaseTransformer extends Transformer {
    abstract override def transform(s: String): String = super.transform(s.toUpperCase)
  }
  trait TrimTransformer extends Transformer {
    abstract override def transform(s: String): String = super.transform(s.trim)
  }
  class BaseTransformer extends Transformer {
    def transform(s: String): String = s
  }

  // TODO: Create an instance with both transformers and predict the result
  def transformResult: String = ???

  // Exercise 5: C3 linearization
  // TODO: Given a more complex hierarchy, compute the linearization
  //       trait X; trait Y extends X; trait Z extends X
  //       trait W extends Y with Z
  //       Return linearization of W
  def linearizationOfW: List[String] = ???

  // Exercise 6: Predicting method resolution
  // TODO: Given:
  //       trait P { def m: Int = 1 }
  //       trait Q extends P { override def m: Int = 2 }
  //       trait R extends P { override def m: Int = 3 }
  //       class S extends Q with R
  //       What does S.m return? (Last trait wins in linearization)
  trait P { def m: Int = 1 }
  trait Q extends P { override def m: Int = 2 }
  trait R extends P { override def m: Int = 3 }

  def methodResolutionResult: Int = ???

  // Exercise 7: Trait stacking order
  // TODO: Create traits that append to a log to visualize stacking order
  //       trait Logger { def log: List[String] = Nil }
  //       trait LogA extends Logger { override def log = "A" :: super.log }
  //       trait LogB extends Logger { override def log = "B" :: super.log }
  //       trait LogC extends Logger { override def log = "C" :: super.log }
  //       class MyLogger extends LogA with LogB with LogC
  //       What is MyLogger.log?
  trait Logger {
    def log: List[String] = Nil
  }
  trait LogA extends Logger { override def log: List[String] = "A" :: super.log }
  trait LogB extends Logger { override def log: List[String] = "B" :: super.log }
  trait LogC extends Logger { override def log: List[String] = "C" :: super.log }

  def stackingOrder: List[String] = ???

  // Exercise 8: Debugging linearization
  // TODO: Create a method that returns the runtime class hierarchy of an object
  //       Use getClass and related reflection to list the linearized types
  def getLinearization(obj: AnyRef): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val d = new D1
    assert(d.name == "C", "D1.name should be C (last in linearization)")
    assert(linearizationOfD1 == List("D1", "C1", "B1", "A1"), "linearization of D1")

    // Exercise 2 assertions
    val processor = new AddBrackets with AddParens
    // Linearization: AddParens -> AddBrackets -> Base
    // AddParens.process calls super (AddBrackets), which calls super (Base)
    assert(processorResult == "([x])", "processor should apply parens then brackets")

    // Exercise 3 assertions
    val roboDog = new Dog with Robot
    assert(roboDogSound == "beep", "RoboDog.sound should be beep (Robot is last)")

    // Exercise 4 assertions
    assert(transformResult.nonEmpty, "transformResult should produce a result")

    // Exercise 5 assertions
    assert(linearizationOfW == List("W", "Z", "Y", "X"), "linearization of W")

    // Exercise 6 assertions
    val s = new Q with R
    assert(methodResolutionResult == 3, "S.m should be 3 (R is last in linearization)")

    // Exercise 7 assertions
    // Linearization: MyLogger -> LogC -> LogB -> LogA -> Logger
    // LogC.log: "C" :: LogB.log: "B" :: LogA.log: "A" :: Nil
    assert(stackingOrder == List("C", "B", "A"), "stacking order should be C, B, A")

    // Exercise 8 assertions
    val lineage = getLinearization(new D1)
    assert(lineage.nonEmpty, "getLinearization should return non-empty list")
    assert(lineage.contains("D1"), "lineage should contain D1")

    println("All Core051_TraitLinearization exercises passed!")
  }
}
