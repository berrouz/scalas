package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 030 - Cause: the full story of how an effect failed.
 *
 * Cause[E] represents the full cause of failure, including:
 * - Fail(e): typed error
 * - Die(t): defect (untyped throwable)
 * - Interrupt(fiberId): interruption
 * - Both/Then: composed failures
 */
object Zio030_Cause {

  // Exercise 1: Create a Cause.fail with a typed error
  // TODO: Cause.fail("error") — creates a Cause with a typed failure
  val exercise1: Cause[String] = ???

  // Exercise 2: Create a Cause.die with a defect
  // TODO: Cause.die(new RuntimeException("defect"))
  val exercise2: Cause[Nothing] = ???

  // Exercise 3: Extract failures from a Cause
  // TODO: Cause.fail("error").failures — returns List("error")
  val exercise3: List[String] = ???

  // Exercise 4: Extract defects from a Cause
  // TODO: Cause.die(new RuntimeException("defect")).defects
  // Returns List[Throwable]
  val exercise4: List[Throwable] = ???

  // Exercise 5: Combine causes with Then (sequential)
  // TODO: Cause.fail("first") ++ Cause.fail("second")
  // ++ creates a Then cause (sequential composition)
  val exercise5: Cause[String] = ???

  // Exercise 6: Combine causes with Both (parallel)
  // TODO: Cause.Both(Cause.fail("left"), Cause.fail("right"))
  val exercise6: Cause[String] = ???

  // Exercise 7: Use squash to convert a Cause to a single Throwable
  // TODO: Cause.fail(new RuntimeException("error")).squash — returns Throwable
  val exercise7: Throwable = ???

  // Exercise 8: Use prettyPrint to get a human-readable representation
  // TODO: Cause.fail("error").prettyPrint — returns a formatted string
  val exercise8: String = ???

  // Exercise 9: Use stripFailures to remove typed failures, keeping only defects
  // TODO: (Cause.fail("error") ++ Cause.die(new RuntimeException("defect"))).stripFailures
  val exercise9: Cause[Nothing] = ???

  // Exercise 10: Extract an interrupt cause from a fiber
  // TODO: Create an interrupted cause: Cause.interrupt(Fiber.Id.None)
  val exercise10: Cause[Nothing] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1
    assert(r1.failures == List("error"), s"Exercise 1 failed: got ${r1.failures}")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = exercise2
    assert(r2.defects.nonEmpty, "Exercise 2 failed: expected defects")
    println(s"Exercise 2 passed: defects=${r2.defects.map(_.getMessage)}")

    // Exercise 3
    assert(exercise3 == List("error"), s"Exercise 3 failed: expected List(error), got $exercise3")
    println(s"Exercise 3 passed: $exercise3")

    // Exercise 4
    assert(exercise4.nonEmpty, s"Exercise 4 failed: expected non-empty defects")
    assert(exercise4.head.getMessage == "defect", s"Exercise 4 failed: expected 'defect' message")
    println(s"Exercise 4 passed: ${exercise4.map(_.getMessage)}")

    // Exercise 5
    assert(exercise5.failures.toSet == Set("first", "second"), s"Exercise 5 failed: got ${exercise5.failures}")
    println(s"Exercise 5 passed: ${exercise5.failures}")

    // Exercise 6
    assert(exercise6.failures.toSet == Set("left", "right"), s"Exercise 6 failed: got ${exercise6.failures}")
    println(s"Exercise 6 passed: ${exercise6.failures}")

    // Exercise 7
    assert(exercise7.getMessage == "error", s"Exercise 7 failed: got ${exercise7.getMessage}")
    println(s"Exercise 7 passed: ${exercise7.getMessage}")

    // Exercise 8
    assert(exercise8.nonEmpty, "Exercise 8 failed: expected non-empty pretty print")
    println(s"Exercise 8 passed: prettyPrint length=${exercise8.length}")

    // Exercise 9
    assert(exercise9.defects.nonEmpty, "Exercise 9 failed: expected defects after stripFailures")
    println(s"Exercise 9 passed: stripped to defects only")

    // Exercise 10
    assert(exercise10.interrupted, "Exercise 10 failed: expected interrupted cause")
    println(s"Exercise 10 passed: interrupted cause created")

    println("All Zio030_Cause exercises passed!")
  }
}
