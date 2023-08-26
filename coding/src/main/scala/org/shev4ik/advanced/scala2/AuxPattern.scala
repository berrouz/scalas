package org.shev4ik.advanced.scala2

object AuxPattern extends App {
  case class Member(id: String, name: String, points: Long = 0)

  trait MemberType {
    val member: Member
  }

  case class FirstTimer(member: Member) extends MemberType

  case class FrequentShopper(member: Member) extends MemberType

  case class Patron(member: Member) extends MemberType


  abstract class AcmeCard(member: Member, levelName: String)

  case class Silver(member: Member) extends AcmeCard(member, "silver")

  case class Gold(member: Member) extends AcmeCard(member, "gold")

  case class Platinum(member: Member) extends AcmeCard(member, "platinum")

  trait Discounted[T] {
    def getDiscount: Double
  }

  object Discounted {
    // apply method called by compiler to instantiate if no instance found  def apply[T](implicit discounted: Discounted[T]) = discounted
    def createDiscounted[T](fn: () => Double) = new Discounted[T] {
      override def getDiscount: Double = fn()
    }

    //implicit instances of Discounted for each Membership Card  implicit val silverCardDiscounted: Discounted[Silver] = createDiscounted( () => 5.0)
    implicit val goldCardDiscounted: Discounted[Gold] = createDiscounted(() => 10.0)
    implicit val platinumCardDiscounted: Discounted[Platinum] = createDiscounted(() => 15.0)
    implicit val silverCardDiscounted: Discounted[Silver] = createDiscounted(() => 5.0)
  }


  trait AcmeCardPrinter[T] {
    def print(t: T): String
  }

  object AcmeCardPrinter {
    def apply[T](implicit prettyPrinter: AcmeCardPrinter[T]): AcmeCardPrinter[T] = prettyPrinter

    implicit val silverAcmeCardPrinter: AcmeCardPrinter[Silver] = new AcmeCardPrinter[Silver] {
      override def print(t: Silver): String = "AcmeCard® Silver Start™"
    }
    implicit val goldAcmeCardPrinter: AcmeCardPrinter[Gold] = new AcmeCardPrinter[Gold] {
      override def print(t: Gold): String = "AcmeCard® Gold Delight™"
    }
    implicit val platinumAcmeCardPrinter: AcmeCardPrinter[Platinum] = new AcmeCardPrinter[Platinum] {
      override def print(t: Platinum): String = "AcmeCard® Platinum Awesomeness™"
    }
  }

  trait UpgradeRequirementCheck[T] {
    def pointsToUpgrade(currentPoint: Long): Long
  }

  object UpgradeRequirementCheck {
    def apply[T](implicit upgradeEligibility: UpgradeRequirementCheck[T]) = upgradeEligibility

    def createUpgradeEligibility[T](fn: () => Long) = new UpgradeRequirementCheck[T] {
      override def pointsToUpgrade(currentPoint: Long): Long = {
        val targetPoints = fn()
        if (targetPoints > 0 && targetPoints > currentPoint)
          targetPoints - currentPoint
        else 0
      }
    }

    implicit val firstTimerUpgrade: UpgradeRequirementCheck[Silver] = createUpgradeEligibility(() => 10000L)
    implicit val frequentShopperUpgrade: UpgradeRequirementCheck[Gold] = createUpgradeEligibility(() => 100000L)
    implicit val patronDUpgrade: UpgradeRequirementCheck[Platinum] = createUpgradeEligibility(() => 0L)
  }


  trait Privilege[T] {
    type OutType

    def getMember(t: T): OutType
  }

  object Privilege {
    type Aux[T, R] = Privilege[T] {type OutType = R}

    def apply[T](implicit privilege: Privilege[T]): Aux[T, privilege.OutType] = privilege

    implicit def materializeSilverCard[R]: Aux[FirstTimer, Silver] = new Privilege[FirstTimer] {
      type OutType = Silver

      override def getMember(t: FirstTimer): OutType = Silver(t.member)
    }
    implicit def materializeGoldCard[R]: Aux[FrequentShopper, Gold] = new Privilege[FrequentShopper] {
      type OutType = Gold

      override def getMember(t: FrequentShopper): OutType = Gold(t.member)
    }

    implicit def materializePlatinumCard[R]: Aux[Patron, Platinum] = new Privilege[Patron] {
      type OutType = Platinum

      override def getMember(t: Patron): OutType = Platinum(t.member)
    }
  }

  val johnDoe = FirstTimer(Member("123456", "John Doe"))
  val johnDoeFq = FrequentShopper(Member("123456", "John Doe"))
  val janeDoe = FrequentShopper(Member("567890", "Jane Doe", 50500))

  //A sample function to get a mapper to give a AcmeCard of type R for a member of type T
  def getPrivilegeType[T, R](member: T)(implicit privilege: Privilege.Aux[T, R]) = privilege

  getPrivilegeType(janeDoe)
  getPrivilegeType(johnDoe)


  def getMembershipInformation[T <: MemberType, R](memberType: T)(implicit
                                                                  privileged: Privilege.Aux[T, R],
                                                                  printer: AcmeCardPrinter[R],
                                                                  upgradeEligibility: UpgradeRequirementCheck[R],
                                                                  discounted: Discounted[R]): String = {
    val pointsToUpgrade = upgradeEligibility.pointsToUpgrade(memberType.member.points)
    val discount = discounted.getDiscount
    val cardName = printer.print(privileged.getMember(memberType))
    val memberName = memberType.member.name
      s"Dear $memberName\n" +
      s"You are proud owner of $cardName\n" +
      s"We have applied special discount of $discount%\n" +
      s"Psst! you need $pointsToUpgrade points for next upgrade!"
  }


  import AcmeCardPrinter._
  import Privilege._
  import Discounted._
  import UpgradeRequirementCheck._

  getMembershipInformation(johnDoe)

  println(getMembershipInformation(johnDoeFq))

  println(getMembershipInformation(janeDoe))

}
