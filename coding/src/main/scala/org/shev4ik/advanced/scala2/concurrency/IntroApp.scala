package org.shev4ik.advanced.scala2.concurrency

object IntroApp extends App {
  @volatile var  x: Int = 0
  // JVM threads

  val threadA = new Thread(() =>
    1.to(3000).foreach(_ => {x += 1})
  )

  val threadB = new Thread(() =>
    1.to(3000).foreach(_ => {x += 1})
  )

  threadA.start()
  threadB.start()


  threadA.join()
  threadB.join()


  println(x)
}
