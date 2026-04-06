package org.shev4ik.interview.scala3.level3_advanced

/**
 * Scala 3: Dependent Function Types
 * (modeled with path-dependent types in Scala 2.13)
 *
 * In Scala 3, dependent function types allow the return type to depend on the argument:
 *   val f: (x: Entry) => x.Value
 * In Scala 2.13, we model this using path-dependent types and type members.
 */
object Sc3_013_DependentFunctions {

  // Exercise 1: Basic path-dependent type (foundation for dependent functions)
  // TODO: Create a trait `Container` with a type member `Elem` and a method `get: Elem`.
  //       Create two implementations:
  //       - `IntContainer` with Elem = Int, get returns 42
  //       - `StringContainer` with Elem = String, get returns "hello"
  //       Implement `extract(c: Container): c.Elem` — a method with path-dependent return type.
  trait Container {
    type Elem
    def get: Elem
  }
  def exercise1_intContainer: Container { type Elem = Int } = ???
  def exercise1_stringContainer: Container { type Elem = String } = ???
  def exercise1_extract(c: Container): c.Elem = ???

  // Exercise 2: Dependent method types (Scala 2 already supports these)
  // TODO: Create a trait `Key` with a type member `Value`.
  //       Create concrete keys: `IntKey` (Value = Int), `StringKey` (Value = String), `BoolKey` (Value = Boolean).
  //       Create a `Store` that holds values and supports:
  //       - `put(key: Key)(value: key.Value): Store` — stores a value
  //       - `get(key: Key): Option[key.Value]` — retrieves a value
  //       The return type depends on which key is used!
  trait Key {
    type Value
  }
  // TODO: Define IntKey, StringKey, BoolKey objects extending Key
  trait Store {
    def put(key: Key)(value: key.Value): Store
    def get(key: Key): Option[key.Value]
  }
  def exercise2_emptyStore: Store = ???

  // Exercise 3: Dependent function type (Scala 3: (x: Foo) => x.Bar)
  // In Scala 3, functions can have dependent types. In Scala 2, use a trait.
  // TODO: Model a dependent function as a trait:
  //       trait DepFn[A] { type Result; def apply(a: A): Result }
  //       Create a `TypeExtractor` DepFn on Container that extracts the element.
  //       Implement `applyDepFn[A](fn: DepFn[A], a: A): fn.Result`.
  trait DepFn[A] {
    type Result
    def apply(a: A): Result
  }
  def exercise3_containerExtractor: DepFn[Container] = ???
  def exercise3_applyDepFn[A](fn: DepFn[A], a: A): fn.Result = ???

  // Exercise 4: Type-safe heterogeneous list (HList foundation)
  // Dependent types enable type-safe heterogeneous collections.
  // TODO: Implement a minimal HList:
  //       sealed trait HList
  //       case class HCons[H, T <: HList](head: H, tail: T) extends HList
  //       case object HNil extends HList with type HNil = HNil.type
  //       Implement `hlistHead` that returns the head with its precise type.
  //       Implement `hlistLength` that returns the length.
  sealed trait HList
  case class HCons[H, T <: HList](head: H, tail: T) extends HList
  sealed trait HNil extends HList
  case object HNilObj extends HNil
  def exercise4_create: HCons[Int, HCons[String, HNil]] = ???
  def exercise4_head[H, T <: HList](hlist: HCons[H, T]): H = ???
  def exercise4_length(hlist: HList): Int = ???

  // Exercise 5: Aux pattern (Scala 2 workaround for dependent types)
  // The Aux pattern extracts type members into type parameters.
  // TODO: Create a type class `Last[L <: HList]` with type member `Out` that finds the last element type.
  //       Use the Aux pattern: `type Aux[L <: HList, O] = Last[L] { type Out = O }`
  //       Implement instances for:
  //       - HCons[H, HNil] => Out = H (single element)
  //       - HCons[H, T] where T has a Last => delegates to Last[T]
  //       Answer: Why is the Aux pattern needed in Scala 2?
  trait Last[L <: HList] {
    type Out
    def apply(l: L): Out
  }
  object Last {
    type Aux[L <: HList, O] = Last[L] { type Out = O }
  }
  implicit def singleLast[H]: Last.Aux[HCons[H, HNil], H] = ???
  implicit def recursiveLast[H, T <: HList](implicit tLast: Last[T]): Last.Aux[HCons[H, T], tLast.Out] = ???
  def exercise5_last[L <: HList](l: L)(implicit ev: Last[L]): ev.Out = ???
  def exercise5_auxPatternAnswer: String = ???
  // TODO: "The Aux pattern lifts type members to type parameters so they can be used in implicit resolution"

  // Exercise 6: Dependent types for safe builders
  // TODO: Create a type-safe builder using phantom types and dependent types:
  //       sealed trait BuilderState
  //       trait Empty extends BuilderState
  //       trait HasName extends BuilderState
  //       trait Complete extends BuilderState
  //       case class Builder[S <: BuilderState](name: Option[String], age: Option[Int])
  //       - `setName` transitions Empty -> HasName
  //       - `setAge` transitions HasName -> Complete
  //       - `build` only works on Complete
  sealed trait BuilderState
  trait Empty extends BuilderState
  trait HasName extends BuilderState
  trait Complete extends BuilderState
  case class Builder[S <: BuilderState] private (name: Option[String], age: Option[Int]) {
    def setName(n: String)(implicit ev: S =:= Empty): Builder[HasName] = ???
    def setAge(a: Int)(implicit ev: S =:= HasName): Builder[Complete] = ???
    def build(implicit ev: S =:= Complete): (String, Int) = ???
  }
  object Builder {
    def empty: Builder[Empty] = Builder[Empty](None, None)
  }
  def exercise6_buildPerson: (String, Int) = ???

  // Exercise 7: Dependent types for type-safe indexing
  // TODO: Implement a type-level natural number system for safe indexing.
  //       trait Nat; class Zero extends Nat; class Succ[N <: Nat] extends Nat
  //       trait NthElem[L <: HList, N <: Nat] { type Out; def apply(l: L): Out }
  //       Implement: get 0th element, get nth element by recursing.
  sealed trait Nat
  class Zero extends Nat
  class Succ[N <: Nat] extends Nat
  trait NthElem[L <: HList, N <: Nat] {
    type Out
    def apply(l: L): Out
  }
  implicit def nthZero[H, T <: HList]: NthElem[HCons[H, T], Zero] { type Out = H } = ???
  implicit def nthSucc[H, T <: HList, N <: Nat](implicit ev: NthElem[T, N]): NthElem[HCons[H, T], Succ[N]] { type Out = ev.Out } = ???
  def exercise7_nth[L <: HList, N <: Nat](l: L)(implicit ev: NthElem[L, N]): ev.Out = ???

  // Exercise 8: Summary — Scala 3 vs Scala 2 dependent types
  // TODO: Answer questions about dependent function types.
  def exercise8_q1: String = ???  // What syntax does Scala 3 use for dependent function types?
  // "val f: (x: Entry) => x.Value — the return type depends on the parameter"
  def exercise8_q2: String = ???  // What Scala 2 feature enables similar patterns?
  // "Path-dependent types (def method(x: Foo): x.Bar) and the Aux pattern"
  def exercise8_q3: String = ???  // What is the main advantage of Scala 3 dependent functions over Scala 2?
  // "Dependent functions are first-class values in Scala 3, not just methods"
  def exercise8_q4: String = ???  // Name a practical use case for dependent function types.
  // "Type-safe heterogeneous collections, database column access, and builder patterns"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val ic = exercise1_intContainer
    val sc = exercise1_stringContainer
    val intVal: Int = exercise1_extract(ic)
    assert(intVal == 42, "Exercise 1 int failed")
    val strVal: String = exercise1_extract(sc)
    assert(strVal == "hello", "Exercise 1 string failed")

    // Exercise 2
    // (Uncomment after defining Key objects)
    // val store = exercise2_emptyStore.put(IntKey)(42).put(StringKey)("hello")
    // assert(store.get(IntKey) == Some(42), "Exercise 2 int failed")
    // assert(store.get(StringKey) == Some("hello"), "Exercise 2 string failed")
    // assert(store.get(BoolKey) == None, "Exercise 2 missing failed")
    println("Exercise 2: Define Key objects and uncomment assertions")

    // Exercise 3
    val extractor = exercise3_containerExtractor
    println("Exercise 3: Dependent function pattern demonstrated")

    // Exercise 4
    val hlist = exercise4_create
    assert(exercise4_head(hlist) == 42, "Exercise 4 head failed (should be first element)")
    assert(exercise4_length(hlist) == 2, "Exercise 4 length failed")

    // Exercise 5
    val singleList = HCons(42, HNilObj: HNil)
    assert(exercise5_last(singleList) == 42, "Exercise 5 single failed")
    val twoList = HCons("first", HCons(99, HNilObj: HNil))
    assert(exercise5_last(twoList) == 99, "Exercise 5 two elements failed")
    assert(exercise5_auxPatternAnswer ==
      "The Aux pattern lifts type members to type parameters so they can be used in implicit resolution",
      "Exercise 5 answer failed")

    // Exercise 6
    val person = exercise6_buildPerson
    assert(person == ("Alice", 30), "Exercise 6 failed")

    // Exercise 7
    val testList = HCons(10, HCons("hello", HCons(true, HNilObj: HNil)))
    val first: Int = exercise7_nth[HCons[Int, HCons[String, HCons[Boolean, HNil]]], Zero](testList)
    assert(first == 10, "Exercise 7 first failed")

    // Exercise 8
    assert(exercise8_q1 == "val f: (x: Entry) => x.Value — the return type depends on the parameter", "Exercise 8 Q1 failed")
    assert(exercise8_q2 == "Path-dependent types (def method(x: Foo): x.Bar) and the Aux pattern", "Exercise 8 Q2 failed")
    assert(exercise8_q3 == "Dependent functions are first-class values in Scala 3, not just methods", "Exercise 8 Q3 failed")
    assert(exercise8_q4 == "Type-safe heterogeneous collections, database column access, and builder patterns", "Exercise 8 Q4 failed")

    println("All Sc3_013_DependentFunctions exercises passed!")
  }
}
