package org.shev4ik.scala_in_action

import scala.language.higherKinds

object ExpressProblemApp extends App {


  case class TextReport() extends Report
  case class PdfReport() extends Report

  trait Report

  trait Generator[R]{
    def produce(report: R): String
  }

  implicit object TextReportGenerator extends Generator[TextReport]{
    override def produce(report: TextReport): String = "text report"
  }
  implicit object PdfReportGenerator extends Generator[PdfReport]{
    override def produce(report: PdfReport): String = "pdf report"
  }


  object HeaderPrinter {
    type Aux[R, H] = HeaderPrinter[R] { type HeaderType = H}

    def apply[T](implicit headerType: HeaderPrinter[T]): Aux[T, headerType.HeaderType] = headerType

    implicit def headerPrinterPdf: Aux[PdfReport, GoldHeader] = new HeaderPrinter[PdfReport]{
      override type HeaderType = GoldHeader

      override def printHeader(report: PdfReport): String = "gold "
    }

    implicit def headerPrinterText: Aux[TextReport, GoldHeader] = new HeaderPrinter[TextReport]{
      override type HeaderType = GoldHeader
      override def printHeader(report: TextReport): String = "gold "
    }
  }

  trait HeaderType

  case class GoldHeader() extends HeaderType

  trait HeaderPrinter[R] {
    type HeaderType

    def printHeader(report: R): String
  }

  def generate[R](report: R)(implicit generator: Generator[R], headerPrinter: HeaderPrinter[R]): String = {
    val header = headerPrinter.printHeader(report)
    header + generator.produce(report)
  }

  println(generate(TextReport()))
  println(generate(PdfReport()))
}
