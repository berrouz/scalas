package org.shev4ik.interview.scala_core.level1_beginner

object Core024_Enumerations {

  // Exercise 1: Enumeration class
  // TODO: Define an object Season extends Enumeration with values Spring, Summer, Autumn, Winter.
  //       Return Season.Spring.toString.
  object Season extends Enumeration {
    val Spring, Summer, Autumn, Winter = Value
  }

  def exercise1_enumeration: String = ???

  // Exercise 2: Sealed trait as enum
  // TODO: Define sealed trait Planet with case objects Mercury, Venus, Earth, Mars.
  //       Write a match that returns the planet's position from the sun (1-4).
  sealed trait Planet
  case object Mercury extends Planet
  case object Venus extends Planet
  case object Earth extends Planet
  case object Mars extends Planet

  def exercise2_sealedTraitEnum(planet: Planet): Int = ???

  // Exercise 3: Enumeration.values
  // TODO: Return all Season values as a sorted List of Strings.
  //       Use Season.values.toList.map(_.toString).sorted
  def exercise3_values: List[String] = ???

  // Exercise 4: Enumeration withName
  // TODO: Use Season.withName("Summer") to get the enum value from a string.
  //       Return it as a String (calling .toString).
  def exercise4_withName: String = ???

  // Exercise 5: Case object enum pattern
  // TODO: Using the Planet sealed trait above, create a list of all planets
  //       and return their names as strings.
  //       val allPlanets: List[Planet] = List(Mercury, Venus, Earth, Mars)
  //       Return allPlanets.map(_.toString)
  def exercise5_caseObjectEnum: List[String] = ???

  // Exercise 6: ADT enum pattern with data
  // TODO: Define a sealed trait Coin with:
  //       case object Penny extends Coin (value = 1)
  //       case object Nickel extends Coin (value = 5)
  //       case object Dime extends Coin (value = 10)
  //       case object Quarter extends Coin (value = 25)
  //       Write a function that returns the coin's value in cents.
  sealed trait Coin
  case object Penny extends Coin
  case object Nickel extends Coin
  case object Dime extends Coin
  case object Quarter extends Coin

  def exercise6_adtEnumWithData(coin: Coin): Int = ???

  // Exercise 7: Enum-style with sealed abstract class
  // TODO: Define sealed abstract class HttpStatus(val code: Int, val reason: String)
  //       case object OK extends HttpStatus(200, "OK")
  //       case object NotFound extends HttpStatus(404, "Not Found")
  //       case object InternalError extends HttpStatus(500, "Internal Server Error")
  //       Given a status code Int, return the matching HttpStatus or None.
  sealed abstract class HttpStatus(val code: Int, val reason: String)
  case object OK extends HttpStatus(200, "OK")
  case object NotFound extends HttpStatus(404, "Not Found")
  case object InternalError extends HttpStatus(500, "Internal Server Error")

  def exercise7_sealedAbstractClass(code: Int): Option[HttpStatus] = ???

  // Exercise 8: Exhaustive matching on enum
  // TODO: Given a Coin, return a description:
  //       Penny => "1 cent", Nickel => "5 cents", Dime => "10 cents", Quarter => "25 cents"
  //       The compiler should warn if a case is missing (sealed).
  def exercise8_exhaustiveMatching(coin: Coin): String = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_enumeration == "Spring", "Exercise 1 failed")

    assert(exercise2_sealedTraitEnum(Mercury) == 1, "Exercise 2 failed: Mercury")
    assert(exercise2_sealedTraitEnum(Earth) == 3, "Exercise 2 failed: Earth")

    assert(exercise3_values == List("Autumn", "Spring", "Summer", "Winter"), "Exercise 3 failed")

    assert(exercise4_withName == "Summer", "Exercise 4 failed")

    assert(exercise5_caseObjectEnum == List("Mercury", "Venus", "Earth", "Mars"), "Exercise 5 failed")

    assert(exercise6_adtEnumWithData(Penny) == 1, "Exercise 6 failed: penny")
    assert(exercise6_adtEnumWithData(Quarter) == 25, "Exercise 6 failed: quarter")

    assert(exercise7_sealedAbstractClass(200) == Some(OK), "Exercise 7 failed: 200")
    assert(exercise7_sealedAbstractClass(404) == Some(NotFound), "Exercise 7 failed: 404")
    assert(exercise7_sealedAbstractClass(999) == None, "Exercise 7 failed: unknown")

    assert(exercise8_exhaustiveMatching(Penny) == "1 cent", "Exercise 8 failed: penny")
    assert(exercise8_exhaustiveMatching(Nickel) == "5 cents", "Exercise 8 failed: nickel")

    println("All Core024_Enumerations exercises passed!")
  }
}
