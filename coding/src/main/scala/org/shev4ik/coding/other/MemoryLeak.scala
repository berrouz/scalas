package org.shev4ik.coding.other

import scala.collection.mutable

object MemoryLeak extends App {
  var list: mutable.Buffer[String] = mutable.Buffer[String]()
  while (true) {
    list += 1.to(1000).mkString(",")
  }
}
