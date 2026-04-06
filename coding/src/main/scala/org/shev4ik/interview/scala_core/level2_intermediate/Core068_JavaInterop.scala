package org.shev4ik.interview.scala_core.level2_intermediate

import scala.jdk.CollectionConverters._

object Core068_JavaInterop {

  // Exercise 1: java.util.List to Scala
  // TODO: Convert a java.util.List to a Scala List using CollectionConverters
  def javaListToScala(jlist: java.util.List[String]): List[String] = ???

  // Exercise 2: Scala to Java collections
  // TODO: Convert a Scala List to a java.util.List
  def scalaListToJava(list: List[String]): java.util.List[String] = ???

  // TODO: Convert a Scala Map to a java.util.Map
  def scalaMapToJava(map: Map[String, Int]): java.util.Map[String, Int] = ???

  // Exercise 3: Option to Optional
  // TODO: Convert between Scala Option and Java Optional
  //       Use scala.jdk.OptionConverters (Scala 2.13+)
  def optionToOptional(opt: Option[String]): java.util.Optional[String] = ???
  def optionalToOption(opt: java.util.Optional[String]): Option[String] = ???

  // Exercise 4: CompletableFuture to Future
  // TODO: Convert a Java CompletableFuture to a Scala Future
  //       Use scala.jdk.FutureConverters (Scala 2.13+)
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global

  def completableFutureToScala(cf: java.util.concurrent.CompletableFuture[String]): Future[String] = ???

  // Exercise 5: SAM types
  // TODO: Demonstrate SAM (Single Abstract Method) conversion
  //       Scala can automatically convert a lambda to a Java functional interface
  //       Create a java.util.Comparator using a Scala lambda
  def createComparator(): java.util.Comparator[String] = ???

  // Exercise 6: @FunctionalInterface
  // TODO: Create a Scala method that accepts a Java functional interface
  //       and demonstrate using it with a Scala lambda
  def applyFunction(value: Int, f: java.util.function.Function[Integer, String]): String = ???
  def applyPredicate(value: Int, p: java.util.function.Predicate[Integer]): Boolean = ???

  // Exercise 7: java.util.stream
  // TODO: Convert between Java streams and Scala collections
  //       Use stream operations and collect back to Scala
  def processWithJavaStream(list: List[Int]): List[Int] = ???

  // Exercise 8: JavaConverters vs CollectionConverters
  // TODO: In Scala 2.13, scala.jdk.CollectionConverters replaces
  //       the deprecated scala.collection.JavaConverters
  //       Demonstrate the 2.13 way to convert collections
  //       Convert various Java collection types to Scala
  def convertJavaSet(jset: java.util.Set[Int]): Set[Int] = ???
  def convertJavaMap(jmap: java.util.Map[String, Int]): Map[String, Int] = ???
  def convertJavaIterator(jiter: java.util.Iterator[String]): Iterator[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val jlist = new java.util.ArrayList[String]()
    jlist.add("hello")
    jlist.add("world")
    assert(javaListToScala(jlist) == List("hello", "world"), "Java List to Scala")

    // Exercise 2 assertions
    val sList = scalaListToJava(List("a", "b", "c"))
    assert(sList.size() == 3, "Scala List to Java size")
    assert(sList.get(0) == "a", "Scala List to Java element")
    val sMap = scalaMapToJava(Map("x" -> 1, "y" -> 2))
    assert(sMap.get("x") == 1, "Scala Map to Java")

    // Exercise 3 assertions
    assert(optionToOptional(Some("hello")).isPresent, "Some to Optional present")
    assert(!optionToOptional(None).isPresent, "None to Optional empty")
    assert(optionalToOption(java.util.Optional.of("hi")) == Some("hi"), "Optional to Option")
    assert(optionalToOption(java.util.Optional.empty[String]()) == None, "Empty Optional to None")

    // Exercise 4 assertions
    import scala.concurrent.Await
    import scala.concurrent.duration._
    val cf = java.util.concurrent.CompletableFuture.completedFuture("done")
    val scalaFuture = completableFutureToScala(cf)
    assert(Await.result(scalaFuture, 5.seconds) == "done", "CompletableFuture to Future")

    // Exercise 5 assertions
    val comp = createComparator()
    assert(comp.compare("apple", "banana") < 0, "Comparator apple < banana")
    assert(comp.compare("banana", "apple") > 0, "Comparator banana > apple")

    // Exercise 6 assertions
    val result6 = applyFunction(42, (i: Integer) => s"Value: $i")
    assert(result6 == "Value: 42", "applyFunction")
    assert(applyPredicate(5, (i: Integer) => i > 3), "applyPredicate true")
    assert(!applyPredicate(1, (i: Integer) => i > 3), "applyPredicate false")

    // Exercise 7 assertions
    val processed = processWithJavaStream(List(1, 2, 3, 4, 5))
    assert(processed == List(4, 8), "process with Java stream: filter even, multiply by 2")

    // Exercise 8 assertions
    val jset = new java.util.HashSet[Int]()
    jset.add(1); jset.add(2); jset.add(3)
    assert(convertJavaSet(jset) == Set(1, 2, 3), "Java Set to Scala")

    val jmap = new java.util.HashMap[String, Int]()
    jmap.put("a", 1); jmap.put("b", 2)
    assert(convertJavaMap(jmap) == Map("a" -> 1, "b" -> 2), "Java Map to Scala")

    println("All Core068_JavaInterop exercises passed!")
  }
}
