package org.shev4ik.pattterns

object StrategyPattern extends App {

  trait Printer {
    def print: String
  }

  class PdfPrinter(data: String) extends Printer {
    def print = s"PDF-$data"
  }

  class CsvPrinter(data: String) extends Printer {
    def print = s"CSV-$data"
  }

  def getStrategy(isPdf: Boolean): Printer = {
    if (isPdf) {
      new PdfPrinter("data")
    } else {
      new CsvPrinter("data")
    }
  }

  def printReport(isPdf: Boolean): String = {
    getStrategy(isPdf).print
  }

  println(printReport(true))
}
