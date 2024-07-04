package org.shev4ik.rockjvm.cats.future

object Futures extends App {

  def startThread(n: Int): Thread = new Thread(() => {
    if (n < 100) {
      val newThread = startThread(n + 1)
      newThread.start()
      newThread.join()
      println(s"hello from thread $n")
    }
  }
  )

  val t = startThread(1)
  t.start()
  t.join()
}
