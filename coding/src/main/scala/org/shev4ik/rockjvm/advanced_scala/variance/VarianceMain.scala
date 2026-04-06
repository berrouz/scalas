package org.shev4ik.rockjvm.advanced_scala.variance

import org.shev4ik.coding.scalatypes.abstracttypes.AbstractTypeMembersMain.Vehicle

class VarianceMain extends App {

  trait Animal
  class Dog extends Animal
  class Cat extends Animal
  class Crocodile extends Animal

  // variance - type substitution of generics


  class Cage[T]

  // covariant

  class CCage[+T]
  val cCage: CCage[Animal] = new CCage[Dog]

  // invariant

  class ICage[T]

  val iCage: ICage[Cat] = new ICage[Cat]

  // contravariant

  class XCage[-T]

  val xCage: XCage[Cat] = new XCage[Animal]


  // val catCage: XCage[Cat] = new XCage[Animal](new Crocodile)


  trait CoCage[+T] {
    def addSome[S >: T ](animal: S): CoCage[T]
  }

  class InVariantParking[T](vehicles: List[T]){
    def park(vehicle: T): InVariantParking[T] = ???
    def impound(vehicles: List[T]): InVariantParking[T] = ???
    def checkVehicles(conditions: String): List[T] = ???
  }

  class CParking[+T](vehicles: List[T]){
    def park[S >: T](vehicle: S): InVariantParking[S] = ???
    def impound[S >: T](vehicles: List[S]): InVariantParking[S] = ???
    def checkVehicles(conditions: String): List[T] = ???
  }

  class XParking[-T](vehicles: List[T]){
    def park[S <: T](vehicle: S): InVariantParking[S] = ???
    def impound[S <: T](vehicles: List[S]): InVariantParking[S] = ???
    def checkVehicles[S <: T](conditions: String): List[S] = ???
  }

  // Rule of thumb

  /*
  * use covariant = collection of things
  * use contravariance - group of actions
  * */
}
