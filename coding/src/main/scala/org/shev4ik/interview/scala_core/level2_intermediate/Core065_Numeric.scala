package org.shev4ik.interview.scala_core.level2_intermediate

object Core065_Numeric {

  // Exercise 1: Numeric type class
  // TODO: Use the standard Numeric type class to implement a generic sum
  //       that works with Int, Long, Double, etc.
  def genericSum[A: Numeric](list: List[A]): A = ???

  // Exercise 2: Integral
  // TODO: Use the Integral type class (subtype of Numeric) for integer operations
  //       Implement generic modulo and division
  def genericMod[A: Integral](a: A, b: A): A = ???
  def genericDiv[A: Integral](a: A, b: A): A = ???

  // Exercise 3: Fractional
  // TODO: Use the Fractional type class for division operations
  //       Implement a generic average function
  def genericAverage[A: Fractional](list: List[A]): A = ???

  // Exercise 4: Sum generic
  // TODO: Implement a generic method to sum a variable number of arguments
  //       using Numeric
  def sumAll[A: Numeric](values: A*): A = ???

  // Exercise 5: Product generic
  // TODO: Implement a generic product (multiply all elements)
  def genericProduct[A: Numeric](list: List[A]): A = ???

  // Exercise 6: Numeric.Implicits
  // TODO: Use Numeric.Implicits to get operator syntax (+, *, -, etc.)
  //       Implement a generic dot product of two lists
  def dotProduct[A: Numeric](xs: List[A], ys: List[A]): A = ???

  // Exercise 7: Custom Numeric
  // TODO: Create a simple Numeric instance for a custom type
  //       case class Modular(value: Int) - arithmetic modulo 7
  case class Modular(value: Int) {
    override def toString: String = s"Mod7($value)"
  }
  // Note: Full Numeric implementation requires many methods.
  // Implement the key ones and use null/??? for rarely-used ones.
  implicit val modularNumeric: Numeric[Modular] = ???

  // Exercise 8: Numeric operations
  // TODO: Use Numeric methods directly (not via Implicits):
  //       plus, minus, times, negate, fromInt, toInt, toDouble
  //       Create a generic method that computes: a * 2 + b - fromInt(1)
  def compute[A: Numeric](a: A, b: A): A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(genericSum(List(1, 2, 3, 4, 5)) == 15, "sum of ints")
    assert(genericSum(List(1.0, 2.0, 3.0)) == 6.0, "sum of doubles")
    assert(genericSum(List(1L, 2L, 3L)) == 6L, "sum of longs")

    // Exercise 2 assertions
    assert(genericMod(10, 3) == 1, "10 mod 3")
    assert(genericDiv(10, 3) == 3, "10 div 3")

    // Exercise 3 assertions
    assert(genericAverage(List(1.0, 2.0, 3.0)) == 2.0, "average of 1,2,3")
    assert(genericAverage(List(10.0, 20.0)) == 15.0, "average of 10,20")

    // Exercise 4 assertions
    assert(sumAll(1, 2, 3, 4, 5) == 15, "sumAll varargs")
    assert(sumAll(1.5, 2.5) == 4.0, "sumAll doubles")

    // Exercise 5 assertions
    assert(genericProduct(List(1, 2, 3, 4)) == 24, "product of 1-4")
    assert(genericProduct(List(2.0, 3.0, 4.0)) == 24.0, "product of doubles")

    // Exercise 6 assertions
    assert(dotProduct(List(1, 2, 3), List(4, 5, 6)) == 32, "dot product: 1*4+2*5+3*6=32")
    assert(dotProduct(List(1.0, 0.0), List(0.0, 1.0)) == 0.0, "orthogonal dot product")

    // Exercise 7 assertions
    val m1 = Modular(5)
    val m2 = Modular(4)
    val mNum = implicitly[Numeric[Modular]]
    assert(mNum.plus(m1, m2) == Modular(2), "5 + 4 mod 7 = 2")
    assert(mNum.times(m1, m2) == Modular(6), "5 * 4 mod 7 = 6")

    // Exercise 8 assertions
    assert(compute(3, 4) == 9, "3*2+4-1=9")
    assert(compute(1.0, 2.0) == 3.0, "1.0*2+2.0-1.0=3.0")

    println("All Core065_Numeric exercises passed!")
  }
}
