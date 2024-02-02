package org.shev4ik.algorithms.priorityqueue

import scala.collection.mutable

object PriorityQueueMainScala extends App {

  val pq = new mutable.PriorityQueue[Long]()(Ordering.Long.reverse)
}
