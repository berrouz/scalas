package org.shev4ik.rockjvm.threads

object JVMThreadCommunication extends App {

  ProdConsV2.start()
  class SimpleContainer {
    private var value: Int = 0

    def isEmpty: Boolean = value == 0

    def set(newValue: Int): Unit = value = newValue

    def get: Int = {
      val result = value
      value = 0
      result
    }
  }

  object ProdConsV1 {
    def start(): Unit = {
      val container = new SimpleContainer

      val consumer = new Thread(() => {
        println("[consumer] waiting ...")

        while(container.isEmpty) {
          println(s"[consumer] waiting for a value...")
        }
        println(s"[consumer] I have consumed a value: ${container.get}")
      })

      val producer = new Thread(() => {
        println("[producer] computing ...")

        Thread.sleep(500)

        val value = 42

        println(s"[producer] I am producing, after LONG work, the value $value")

        container.set(value)
      })

      consumer.start()
      producer.start()
    }
  }

  object ProdConsV2 {
    def start(): Unit = {
      val container = new SimpleContainer

      val consumer = new Thread(() => {
        println("[consumer] waiting ...")

        // todo
        container.synchronized {
          container.wait()
        }
        println(s"[consumer] I have consumed a value: ${container.get}")
      })

      val producer = new Thread(() => {
        println("[producer] computing ...")

        Thread.sleep(500)

        val value = 42

        container.synchronized {
          println(s"[producer] I am producing, after LONG work, the value $value")
          container.set(value)
          container.notify()
        }
      })

      consumer.start()
      producer.start()
    }
  }
}
