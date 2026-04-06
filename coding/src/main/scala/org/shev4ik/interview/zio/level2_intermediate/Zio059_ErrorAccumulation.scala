package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 059 - Error Accumulation: collecting multiple errors instead of failing fast.
 *
 * ZIO.validate, ZIO.validatePar, ZIO.validateFirst, partition
 * accumulate errors rather than short-circuiting on the first failure.
 */
object Zio059_ErrorAccumulation {

  // Exercise 1: Use ZIO.validate to accumulate errors
  // TODO: ZIO.validate(List(1, -2, 3, -4))(n => if (n > 0) ZIO.succeed(n) else ZIO.fail(s"neg:$n"))
  val exercise1: IO[::[String], List[Int]] = ???

  // Exercise 2: Use ZIO.validatePar for parallel error accumulation
  // TODO: ZIO.validatePar(List(1, -2, 3))(n => if (n > 0) ZIO.succeed(n) else ZIO.fail(s"neg:$n"))
  val exercise2: IO[::[String], List[Int]] = ???

  // Exercise 3: Use ZIO.validateFirst to return the first success
  // TODO: ZIO.validateFirst(List(-1, -2, 3))(n => if (n > 0) ZIO.succeed(n) else ZIO.fail(s"neg:$n"))
  val exercise3: IO[::[String], Int] = ???

  // Exercise 4: Use ZIO.validateFirstPar for parallel first-success
  // TODO: ZIO.validateFirstPar(List(-1, 2, -3))(n => if (n > 0) ZIO.succeed(n) else ZIO.fail(s"neg:$n"))
  val exercise4: IO[::[String], Int] = ???

  // Exercise 5: Use ZIO.partition to separate successes and failures
  // TODO: ZIO.partition(List(1, -2, 3, -4))(n => if (n > 0) ZIO.succeed(n) else ZIO.fail(s"neg:$n"))
  val exercise5: UIO[(Iterable[String], Iterable[Int])] = ???

  // Exercise 6: Collect all successes, ignoring failures
  // TODO: ZIO.partition + map to get only the successes
  val exercise6: UIO[List[Int]] = ???

  // Exercise 7: Use ZIO.validate with a validation function
  // TODO: Validate a list of strings as non-empty, accumulate errors
  def validateNonEmpty(values: List[String]): IO[::[String], List[String]] = ???

  // Exercise 8: Use ZIO.validatePar for form validation
  // TODO: Validate name (non-empty), age (> 0), email (contains @) in parallel
  case class FormData(name: String, age: Int, email: String)
  def validateForm(name: String, age: Int, email: String): IO[::[String], FormData] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.either)
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.either)
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.either)
    assert(r3 == Right(3), s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.either)
    assert(r4 == Right(2), s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5._1.nonEmpty && r5._2.nonEmpty, s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: failures=${r5._1}, successes=${r5._2}")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == List(1, 3), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(validateNonEmpty(List("hello", "", "world")).either)
    println(s"Exercise 7 passed: $r7")

    val r8valid = runtime.unsafeRun(validateForm("John", 25, "john@example.com").either)
    assert(r8valid.isRight, s"Exercise 8 failed: valid form rejected: $r8valid")
    val r8invalid = runtime.unsafeRun(validateForm("", -1, "noemail").either)
    assert(r8invalid.isLeft, s"Exercise 8 failed: invalid form accepted")
    println(s"Exercise 8 passed: valid=$r8valid, invalid=$r8invalid")

    println("All Zio059_ErrorAccumulation exercises passed!")
  }
}
