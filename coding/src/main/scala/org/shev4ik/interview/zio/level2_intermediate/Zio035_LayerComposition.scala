package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 035 - Layer Composition: combining layers horizontally and vertically.
 *
 * ++ (horizontal): combines independent layers
 * >>> (vertical): feeds one layer into another
 * provideSomeLayer: partially satisfies environment requirements
 */
object Zio035_LayerComposition {

  val stringLayer: ZLayer[Any, Nothing, Has[String]] = ZLayer.succeed("hello")
  val intLayer: ZLayer[Any, Nothing, Has[Int]] = ZLayer.succeed(42)
  val doubleLayer: ZLayer[Has[Int], Nothing, Has[Double]] = ZLayer.fromService[Int, Double](_.toDouble * 1.5)

  // Exercise 1: Combine stringLayer and intLayer horizontally with ++
  // TODO: Use ++ to produce ZLayer[Any, Nothing, Has[String] with Has[Int]]
  val exercise1: ZLayer[Any, Nothing, Has[String] with Has[Int]] = ???

  // Exercise 2: Compose intLayer and doubleLayer vertically with >>>
  // TODO: Use >>> to feed intLayer output into doubleLayer input
  val exercise2: ZLayer[Any, Nothing, Has[Double]] = ???

  // Exercise 3: Create a program that needs Has[String] with Has[Int] and provide the combined layer
  // TODO: Create a ZIO that reads both String and Int from environment, concat them
  val exercise3: ZIO[Has[String] with Has[Int], Nothing, String] = ???

  // Exercise 4: Use provideSomeLayer to partially satisfy environment
  // TODO: Given a ZIO needing Has[String] with Has[Int], provide only the intLayer
  // and return a ZIO that still needs Has[String]
  def exercise4(program: ZIO[Has[String] with Has[Int], Nothing, String]): ZIO[Has[String], Nothing, String] = ???

  // Exercise 5: Create a layer that passes through its input alongside new output (passthrough pattern)
  // TODO: Create a layer Has[Int] => Has[Int] with Has[String] that keeps Int and adds String
  val exercise5: ZLayer[Has[Int], Nothing, Has[Int] with Has[String]] = ???

  // Exercise 6: Chain three layers: Int -> Double -> String
  // TODO: intLayer >>> doubleLayer >>> ZLayer.fromService[Double, String](d => s"result:$d")
  val exercise6: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 7: Create a test layer that overrides a production layer
  // TODO: Create a "test" string layer that provides "test-value" instead of "hello"
  val exercise7: ZLayer[Any, Nothing, Has[String]] = ???

  // Exercise 8: Combine horizontal and vertical composition
  // TODO: (intLayer ++ stringLayer) >>> ZLayer.fromServices[Int, String, String]((i, s) => s"$s-$i")
  val exercise8: ZLayer[Any, Nothing, Has[String]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1s = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise1))
    val r1i = runtime.unsafeRun(ZIO.service[Int].provideLayer(exercise1))
    assert(r1s == "hello" && r1i == 42, s"Exercise 1 failed: got $r1s, $r1i")
    println(s"Exercise 1 passed: String=$r1s, Int=$r1i")

    // Exercise 2
    val r2 = runtime.unsafeRun(ZIO.service[Double].provideLayer(exercise2))
    assert(r2 == 63.0, s"Exercise 2 failed: expected 63.0, got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3.provideLayer(exercise1))
    assert(r3.nonEmpty, s"Exercise 3 failed: got empty string")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val prog = ZIO.services[String, Int].map { case (s, i) => s"$s=$i" }
    val r4 = runtime.unsafeRun(exercise4(prog).provideLayer(stringLayer))
    assert(r4.contains("42"), s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(
      ZIO.services[Int, String].map { case (i, s) => s"$i-$s" }
        .provideLayer(intLayer >>> exercise5)
    )
    assert(r5.contains("42"), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise6))
    assert(r6.startsWith("result:"), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise7))
    assert(r7 == "test-value", s"Exercise 7 failed: expected test-value, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(ZIO.service[String].provideLayer(exercise8))
    assert(r8 == "hello-42", s"Exercise 8 failed: expected hello-42, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio035_LayerComposition exercises passed!")
  }
}
