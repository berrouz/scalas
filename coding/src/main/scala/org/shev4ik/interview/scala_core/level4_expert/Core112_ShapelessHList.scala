package org.shev4ik.interview.scala_core.level4_expert

object Core112_ShapelessHList {

  // Simplified HList implementation (Shapeless-inspired)

  // Exercise 1: HList definition
  // TODO: Define HList, HNil, and :: (HCons)
  sealed trait HList
  case object HNil extends HList {
    def ::[A](a: A): HCons[A, HNil.type] = HCons(a, this)
  }
  type HNilType = HNil.type

  case class HCons[+H, +T <: HList](head: H, tail: T) extends HList {
    def ::[A](a: A): HCons[A, HCons[H, T]] = HCons(a, this)
  }

  // Exercise 2: head/tail
  // TODO: Write type-safe head and tail methods
  def head[H, T <: HList](list: HCons[H, T]): H = ???
  def tail[H, T <: HList](list: HCons[H, T]): T = ???

  // Exercise 3: Length
  // TODO: Define a type class for HList length
  trait Length[L <: HList] {
    def value: Int
  }

  implicit val hnilLength: Length[HNilType] = ???
  implicit def hconsLength[H, T <: HList](implicit tl: Length[T]): Length[HCons[H, T]] = ???

  def length[L <: HList](list: L)(implicit l: Length[L]): Int = ???

  // Exercise 4: Map over HList
  // TODO: Define a polymorphic function and map it over HList
  trait Poly1 {
    type Case[A]
    def apply[A](a: A)(implicit c: Case[A]): Any
  }

  // Simplified: map each element to String
  trait HListMap[L <: HList] {
    def map(l: L): List[String]
  }

  implicit val hnilMap: HListMap[HNilType] = ???
  implicit def hconsMap[H, T <: HList](implicit tm: HListMap[T]): HListMap[HCons[H, T]] = ???

  def hlistToStrings[L <: HList](list: L)(implicit m: HListMap[L]): List[String] = ???

  // Exercise 5: Zip two HLists
  // TODO: Zip two HLists element-wise
  trait HListZip[L1 <: HList, L2 <: HList] {
    type Out <: HList
    def zip(l1: L1, l2: L2): Out
  }

  implicit val hnilZip: HListZip[HNilType, HNilType] = new HListZip[HNilType, HNilType] {
    type Out = HNilType
    def zip(l1: HNilType, l2: HNilType): HNilType = HNil
  }

  implicit def hconsZip[H1, T1 <: HList, H2, T2 <: HList](
    implicit tz: HListZip[T1, T2]
  ): HListZip[HCons[H1, T1], HCons[H2, T2]] = ???

  // Exercise 6: Generic representation
  // TODO: Define a Generic type class that converts case classes to HList
  trait Generic[T] {
    type Repr <: HList
    def to(t: T): Repr
    def from(r: Repr): T
  }

  // TODO: Implement Generic for a simple case class
  case class Person(name: String, age: Int)

  implicit val personGeneric: Generic[Person] = ???

  // Exercise 7: Append HLists
  // TODO: Implement HList append
  trait Append[L1 <: HList, L2 <: HList] {
    type Out <: HList
    def apply(l1: L1, l2: L2): Out
  }

  implicit def hnilAppend[L2 <: HList]: Append[HNilType, L2] = new Append[HNilType, L2] {
    type Out = L2
    def apply(l1: HNilType, l2: L2): L2 = l2
  }

  implicit def hconsAppend[H, T <: HList, L2 <: HList](
    implicit ta: Append[T, L2]
  ): Append[HCons[H, T], L2] = ???

  def append[L1 <: HList, L2 <: HList](l1: L1, l2: L2)(implicit a: Append[L1, L2]): a.Out = ???

  // Exercise 8: HList contains
  // TODO: Prove that an HList contains a specific type
  trait Contains[L <: HList, A] {
    def get(l: L): A
  }

  implicit def hconsContainsHead[A, T <: HList]: Contains[HCons[A, T], A] = ???

  implicit def hconsContainsTail[H, T <: HList, A](
    implicit ct: Contains[T, A]
  ): Contains[HCons[H, T], A] = ???

  def select[L <: HList, A](l: L)(implicit c: Contains[L, A]): A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val hlist = 42 :: "hello" :: true :: HNil
    assert(hlist.head == 42)

    // Exercise 2
    assert(head(hlist) == 42)
    assert(head(tail(hlist)) == "hello")

    // Exercise 3
    assert(length(hlist) == 3)
    assert(length(HNil) == 0)

    // Exercise 4
    assert(hlistToStrings(hlist) == List("42", "hello", "true"))

    // Exercise 6
    val person = Person("Alice", 30)
    val repr = personGeneric.to(person)
    assert(head(repr.asInstanceOf[HCons[String, HCons[Int, HNilType]]]) == "Alice")
    assert(personGeneric.from(repr) == person)

    // Exercise 7
    val l1 = 1 :: 2 :: HNil
    val l2 = "a" :: "b" :: HNil
    val appended = append(l1, l2)
    assert(head(appended.asInstanceOf[HCons[Int, HList]]) == 1)

    // Exercise 8
    val selected: String = select[HCons[Int, HCons[String, HCons[Boolean, HNilType]]], String](hlist)
    assert(selected == "hello")

    println("All Core112_ShapelessHList exercises passed!")
  }
}
