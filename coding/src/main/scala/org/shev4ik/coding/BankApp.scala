package org.shev4ik.coding

object BankApp extends App {
  def calculator(p: BigDecimal, years: Int): BigDecimal = {
    def calc(year: Int, result: BigDecimal): BigDecimal = {
      if (year == 0){
        result
      } else {
        calc(year-1, result*p)
      }
    }
    calc(years, p)
  }

  println(calculator(BigDecimal.valueOf(1.2d), 16))
}
