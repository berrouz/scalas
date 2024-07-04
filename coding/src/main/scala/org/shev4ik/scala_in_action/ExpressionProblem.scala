package org.shev4ik.scala_in_action

import scala.language.higherKinds

object ExpressionProblem extends App {


  case class USPayroll[A](payees: Seq[A])(implicit processor: PayrollProcessor[USPayroll, A]) {
    def processPayroll(): Either[String, Throwable] = processor.processPayroll(payees)
  }

  case class CanadaPayroll[A](payees: Seq[A])(implicit processor: PayrollProcessor[CanadaPayroll, A]){
    def processPayroll(): Either[String, Throwable] = processor.processPayroll(payees)
  }

  case class JapanPayroll[A](payees: Seq[A])(implicit processor: PayrollProcessor[JapanPayroll, A]) {
    def processPayroll(): Either[String, Throwable] = processor.processPayroll(payees)
  }

  trait PayrollProcessor[C[_], A] {
    def processPayroll(payees: Seq[A]): Either[String, Throwable]
  }

  case class Employee(name: String, id: Long)

  case class Contractor(name: String)

  implicit object USPayrollProcessor extends PayrollProcessor[USPayroll, Employee] {
    override def processPayroll(payees: Seq[Employee]): Either[String, Throwable] = Left("us employees are processed")
  }

  implicit object CanadaPayrollProcessor extends PayrollProcessor[CanadaPayroll, Employee] {
    override def processPayroll(payees: Seq[Employee]): Either[String, Throwable] = Left("canada employees are processed")
  }

  implicit object JapanPayrollProcessorContractor extends PayrollProcessor[JapanPayroll, Contractor] {
    override def processPayroll(payees: Seq[Contractor]): Either[String, Throwable] = Left("canada contractors are processed")
  }

  val usPayroll     = USPayroll(Vector(Employee("Victor", 1))).processPayroll()

  val canadaPayroll = CanadaPayroll(Vector(Employee("Victor", 1))).processPayroll()

  val canadaPayrollC = JapanPayroll(Vector(Contractor("Victor"))).processPayroll()

}
