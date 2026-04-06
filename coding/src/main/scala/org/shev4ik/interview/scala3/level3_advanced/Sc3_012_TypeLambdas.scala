package org.shev4ik.interview.scala3.level3_advanced

/**
 * Scala 3: Native Type Lambdas ([X] =>> F[X])
 * (modeled with type projections and type aliases in Scala 2.13)
 *
 * In Scala 3, type lambdas provide a clean syntax: [X] =>> Map[String, X]
 * In Scala 2.13, we use the "type lambda" trick with structural types or kind-projector plugin syntax.
 * Here we model type lambdas using Scala 2.13 compatible approaches.
 */
object Sc3_012_TypeLambdas {

  // Exercise 1: Basic type lambda concept
  // Scala 3: type StringMap = [V] =>> Map[String, V]
  // Scala 2: type StringMap[V] = Map[String, V] (simple type alias is enough here)
  // TODO: Define `type StringMap[V] = Map[String, V]`.
  //       Implement `createStringMap` that creates a StringMap[Int] from pairs.
  //       Implement `lookupStringMap` that looks up a key.
  type StringMap[V] = Map[String, V]
  def exercise1_createStringMap(pairs: List[(String, Int)]): StringMap[Int] = ???
  def exercise1_lookupStringMap(m: StringMap[Int], key: String): Option[Int] = ???

  // Exercise 2: Type lambda for Functor
  // Scala 3: given Functor[[X] =>> Map[String, X]] with { ... }
  // In Scala 2, we need the type lambda trick or a type alias.
  // TODO: Define a Functor trait and implement it for StringMap (i.e., Map[String, *]).
  //       Functor[F[_]] { def map[A, B](fa: F[A])(f: A => B): F[B] }
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }
  // Using type alias to partially apply Map
  implicit val stringMapFunctor: Functor[StringMap] = ???
  def exercise2_mapValues(m: StringMap[Int])(f: Int => String)(implicit F: Functor[StringMap]): StringMap[String] = ???

  // Exercise 3: Type lambda for Either (fixing the left type)
  // Scala 3: type EitherString = [A] =>> Either[String, A]
  // TODO: Define `type EitherString[A] = Either[String, A]`.
  //       Implement a Functor[EitherString] that maps over the Right value.
  //       Implement `transformRight` that applies a function to the Right value.
  type EitherString[A] = Either[String, A]
  implicit val eitherStringFunctor: Functor[EitherString] = ???
  def exercise3_transformRight[A, B](e: EitherString[A])(f: A => B)(implicit F: Functor[EitherString]): EitherString[B] = ???

  // Exercise 4: Type lambda trick in Scala 2
  // The classic Scala 2 type lambda: ({ type L[A] = Map[K, A] })#L
  // TODO: Implement a method `pairFunctor` that creates a Functor for (A, ?) — pairs with fixed first element.
  //       `type Paired[A] = (Int, A)` — pair with Int as first element.
  //       Implement Functor[Paired] that maps over the second element.
  //       Answer: What is the Scala 2 type lambda syntax?
  type Paired[A] = (Int, A)
  implicit val pairedFunctor: Functor[Paired] = ???
  def exercise4_mapSecond[A, B](pair: Paired[A])(f: A => B)(implicit F: Functor[Paired]): Paired[B] = ???
  def exercise4_typeLambdaSyntax: String = ???
  // TODO: "({type L[A] = F[Fixed, A]})#L or use kind-projector plugin: F[Fixed, *]"

  // Exercise 5: Higher-kinded type lambda
  // Scala 3: [F[_]] =>> F[Int] (a type lambda that takes a type constructor)
  // TODO: Define a type alias `ApplyToInt[F[_]] = F[Int]`.
  //       Show that ApplyToInt[List] = List[Int], ApplyToInt[Option] = Option[Int].
  //       Implement `wrapInContainer[F[_]](value: Int)(implicit factory: ContainerFactory[F]): F[Int]`.
  type ApplyToInt[F[_]] = F[Int]
  trait ContainerFactory[F[_]] {
    def wrap(value: Int): F[Int]
  }
  implicit val listFactory: ContainerFactory[List] = ???
  implicit val optionFactory: ContainerFactory[Option] = ???
  def exercise5_wrapInContainer[F[_]](value: Int)(implicit factory: ContainerFactory[F]): ApplyToInt[F] = ???

  // Exercise 6: Compose type constructors using type lambdas
  // Scala 3: type Compose[F[_], G[_]] = [A] =>> F[G[A]]
  // TODO: Define `type Compose[F[_], G[_], A] = F[G[A]]` (Scala 2 needs the extra param).
  //       Define `type ListOption[A] = Compose[List, Option, A]` (= List[Option[A]]).
  //       Implement a Functor for ListOption that maps inside both layers.
  type Compose[F[_], G[_], A] = F[G[A]]
  type ListOption[A] = Compose[List, Option, A]
  implicit val listOptionFunctor: Functor[ListOption] = ???
  def exercise6_deepMap[A, B](xs: ListOption[A])(f: A => B)(implicit F: Functor[ListOption]): ListOption[B] = ???

  // Exercise 7: Contravariant type lambda
  // Scala 3: type StringPredicate = [A] =>> A => Boolean (not a type lambda, but shows the pattern)
  // TODO: Define a Contravariant functor trait and implement for predicates (A => Boolean).
  //       Contravariant[F[_]] { def contramap[A, B](fa: F[A])(f: B => A): F[B] }
  //       type Predicate[A] = A => Boolean
  //       Implement Contravariant[Predicate].
  trait Contravariant[F[_]] {
    def contramap[A, B](fa: F[A])(f: B => A): F[B]
  }
  type Predicate[A] = A => Boolean
  implicit val predicateContravariant: Contravariant[Predicate] = ???
  def exercise7_adaptPredicate[A, B](pred: Predicate[A])(f: B => A)(implicit C: Contravariant[Predicate]): Predicate[B] = ???

  // Exercise 8: Summary — type lambda comparison
  // TODO: Return the Scala 2 equivalent for each Scala 3 type lambda syntax.
  def exercise8_equivalents: Map[String, String] = ???
  // Expected:
  // "[X] =>> Map[String, X]" -> "type StringMap[X] = Map[String, X]"
  // "[X] =>> Either[E, X]" -> "type EitherE[X] = Either[E, X]"
  // "[X] =>> (Int, X)" -> "type Paired[X] = (Int, X)"
  // "[F[_]] =>> F[Int]" -> "type ApplyToInt[F[_]] = F[Int]"
  // "[X] =>> F[G[X]]" -> "type Compose[F[_], G[_], X] = F[G[X]]"
  // "[X] =>> X => Boolean" -> "type Predicate[X] = X => Boolean"
  // "kind-projector Map[String, *]" -> "({type L[A] = Map[String, A]})#L"
  // "polymorphic function [A] => List[A] => Option[A]" -> "trait ~>[F[_], G[_]] { def apply[A](fa: F[A]): G[A] }"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val sm = exercise1_createStringMap(List("a" -> 1, "b" -> 2))
    assert(sm == Map("a" -> 1, "b" -> 2), "Exercise 1 create failed")
    assert(exercise1_lookupStringMap(sm, "a") == Some(1), "Exercise 1 lookup failed")
    assert(exercise1_lookupStringMap(sm, "c") == None, "Exercise 1 lookup missing failed")

    // Exercise 2
    val mapped = exercise2_mapValues(Map("x" -> 1, "y" -> 2))(_.toString)
    assert(mapped == Map("x" -> "1", "y" -> "2"), "Exercise 2 failed")

    // Exercise 3
    assert(exercise3_transformRight(Right(42): EitherString[Int])(_.toString) == Right("42"), "Exercise 3 Right failed")
    assert(exercise3_transformRight(Left("err"): EitherString[Int])(_.toString) == Left("err"), "Exercise 3 Left failed")

    // Exercise 4
    assert(exercise4_mapSecond((1, "hello"))(_.length) == (1, 5), "Exercise 4 failed")
    assert(exercise4_typeLambdaSyntax ==
      "({type L[A] = F[Fixed, A]})#L or use kind-projector plugin: F[Fixed, *]",
      "Exercise 4 syntax failed")

    // Exercise 5
    val listWrapped: ApplyToInt[List] = exercise5_wrapInContainer[List](42)
    assert(listWrapped == List(42), "Exercise 5 list failed")
    val optWrapped: ApplyToInt[Option] = exercise5_wrapInContainer[Option](42)
    assert(optWrapped == Some(42), "Exercise 5 option failed")

    // Exercise 6
    val deepMapped = exercise6_deepMap(List(Some(1), None, Some(2)))(_.toString)
    assert(deepMapped == List(Some("1"), None, Some("2")), "Exercise 6 failed")

    // Exercise 7
    val isPositive: Predicate[Int] = _ > 0
    val isPositiveLength: Predicate[String] = exercise7_adaptPredicate(isPositive)((_: String).length)
    assert(isPositiveLength("hello") == true, "Exercise 7 non-empty failed")
    assert(isPositiveLength("") == false, "Exercise 7 empty failed")

    // Exercise 8
    val eq = exercise8_equivalents
    assert(eq.size == 8, "Exercise 8 should have 8 entries")
    assert(eq("[X] =>> Map[String, X]") == "type StringMap[X] = Map[String, X]", "Exercise 8 failed")

    println("All Sc3_012_TypeLambdas exercises passed!")
  }
}
