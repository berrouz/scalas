package org.shev4ik.advanced.scala2.concurrency

import scala.util.Random

object ThreadCommunication extends App {

  // producer
  // consumer

  class SimpleContainer {
    private var value: Int = 0

    def isEmpty: Boolean = value == 0

    def set(newValue: Int): Unit = value == newValue

    def get: Int = {
      val result = value
      value = 0
      result
    }
  }

  def naiveProdCons(): Unit = {
    val container = new SimpleContainer

    val consumer = new Thread(() => {
      container.synchronized {
        container.wait()
      }
      println("[consumer] I have consumed " + container.get)
    })

    val producer = new Thread(() => {
      container.synchronized {
        container.set(42)
        println("[producer] I have produced, after long work, the value " + 42)
        container.notifyAll()
      }
    })

    consumer.start()
    producer.start()
  }

  // naiveProdCons()

  def smartProducerCons(): Unit = {

    var buffer = scala.collection.mutable.Buffer[Int]()

    val consumer = new Thread(() => {
      while (true) {
        buffer.synchronized {
          if (buffer.nonEmpty) {
            buffer.remove(buffer.size - 1)
            println("[Consumer] consumes value")
          } else {
            buffer.wait()
          }
        }
        Thread.sleep(Random.nextInt(1000))
      }
    })

    val producer = new Thread(() => {
      while (true) {
        buffer.synchronized {

          if (buffer.size < 3) {
            buffer.append(Random.nextInt())
            println("[Producer] produces value")
          } else {
            buffer.notifyAll()
          }
        }
        Thread.sleep(Random.nextInt(1000))
      }
    })

    consumer.start()
    producer.start()
  }

  smartProducerCons()

}
