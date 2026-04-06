package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 017 - Persistence Patterns
 *
 * Advanced persistence patterns in Akka:
 *   - Event Sourcing: derive state from a sequence of events
 *   - CQRS Read Side: separate read model projection from write model
 *   - Tagging: tag events for querying/grouping
 *   - Event Envelope: metadata wrapper around events
 *   - Persistent FSM: state machine backed by event persistence
 *   - At-Least-Once Delivery: guaranteed message delivery with dedup
 *   - Saga: coordinate distributed transactions across actors
 *   - Persistent Query: query the event journal
 */
object Akka017_PersistencePattern {

  // --- Domain models ---

  sealed trait OrderCommand
  case class CreateOrder(orderId: String, items: List[String], total: Double) extends OrderCommand
  case class ConfirmOrder(orderId: String) extends OrderCommand
  case class CancelOrder(orderId: String) extends OrderCommand
  case class ShipOrder(orderId: String) extends OrderCommand

  sealed trait OrderEvent
  case class OrderCreated(orderId: String, items: List[String], total: Double) extends OrderEvent
  case class OrderConfirmed(orderId: String) extends OrderEvent
  case class OrderCancelled(orderId: String) extends OrderEvent
  case class OrderShipped(orderId: String) extends OrderEvent

  sealed trait OrderStatus
  case object Pending extends OrderStatus
  case object Confirmed extends OrderStatus
  case object Shipped extends OrderStatus
  case object Cancelled extends OrderStatus

  case class Order(orderId: String, items: List[String], total: Double, status: OrderStatus)

  case class EventEnvelope(
    sequenceNr: Long,
    persistenceId: String,
    event: OrderEvent,
    tags: Set[String],
    timestamp: Long
  )

  case class ReadModel(
    ordersByStatus: Map[OrderStatus, List[String]],
    totalRevenue: Double,
    orderCount: Int
  )

  case class DeliveryAttempt(deliveryId: Long, message: String, confirmed: Boolean)

  sealed trait SagaStep
  case class SagaExecute(stepName: String, action: String) extends SagaStep
  case class SagaCompensate(stepName: String, action: String) extends SagaStep

  // Exercise 1: Event Sourcing — apply events to build state
  // TODO: Given a list of OrderEvents, build a Map[String, Order] (orderId -> Order).
  //   - OrderCreated: add new Order with status=Pending
  //   - OrderConfirmed: set status=Confirmed (if order exists)
  //   - OrderCancelled: set status=Cancelled (if order exists)
  //   - OrderShipped: set status=Shipped (if order exists and Confirmed)
  //   Return the final order map.
  def exercise1_eventSourcing(events: List[OrderEvent]): Map[String, Order] = ???

  // Exercise 2: CQRS Read Side projection
  // TODO: Given a list of OrderEvents, build a ReadModel:
  //   - ordersByStatus: group order IDs by their final status
  //   - totalRevenue: sum of totals for Confirmed or Shipped orders
  //   - orderCount: total number of unique orders
  //   Process events in order, maintaining running state.
  def exercise2_cqrsReadSide(events: List[OrderEvent]): ReadModel = ???

  // Exercise 3: Event tagging
  // TODO: Given an OrderEvent and a sequenceNr, create an EventEnvelope with tags:
  //   - All events: tag "order"
  //   - OrderCreated: also tag "created"
  //   - OrderConfirmed: also tag "confirmed"
  //   - OrderCancelled: also tag "cancelled"
  //   - OrderShipped: also tag "shipped"
  //   Use persistenceId = "orders" and timestamp = sequenceNr * 1000.
  def exercise3_tagEvent(event: OrderEvent, sequenceNr: Long): EventEnvelope = ???

  // Exercise 4: Event Envelope — query by tag
  // TODO: Given a list of EventEnvelopes and a tag string,
  //   return all envelopes that contain the given tag, ordered by sequenceNr.
  def exercise4_queryByTag(envelopes: List[EventEnvelope], tag: String): List[EventEnvelope] = ???

  // Exercise 5: Persistent FSM — order state machine
  // TODO: Given a current OrderStatus and an OrderCommand, determine:
  //   - Valid transition: return (Some(newEvent), newStatus)
  //   - Invalid transition: return (None, currentStatus)
  //   Valid transitions:
  //     Pending + ConfirmOrder -> Confirmed
  //     Pending + CancelOrder -> Cancelled
  //     Confirmed + ShipOrder -> Shipped
  //     Confirmed + CancelOrder -> Cancelled
  //   All other transitions are invalid. CreateOrder is only valid when no order exists (use Pending).
  def exercise5_persistentFSM(
    currentStatus: OrderStatus,
    cmd: OrderCommand
  ): (Option[OrderEvent], OrderStatus) = ???

  // Exercise 6: At-Least-Once Delivery
  // TODO: Simulate at-least-once delivery with deduplication.
  //   Given a list of DeliveryAttempts (some confirmed, some not),
  //   return the list of unique messages that need redelivery (not confirmed)
  //   and the list of confirmed deliveryIds.
  //   Messages with the same deliveryId should be deduplicated.
  def exercise6_atLeastOnceDelivery(
    attempts: List[DeliveryAttempt]
  ): (List[String], List[Long]) = ???

  // Exercise 7: Saga pattern — coordinate multi-step transaction
  // TODO: Given a list of SagaSteps (Execute steps followed by potential Compensate steps),
  //   simulate a saga execution:
  //   Process Execute steps in order. If any step's action contains "FAIL",
  //   stop executing and generate Compensate steps for all previously executed steps
  //   (in reverse order). Return (executedSteps, compensationSteps).
  //   If no failure, compensationSteps is empty.
  def exercise7_saga(steps: List[SagaExecute]): (List[String], List[String]) = ???

  // Exercise 8: Persistent Query — event journal query
  // TODO: Given a list of EventEnvelopes, implement query operations:
  //   1. eventsByPersistenceId: filter by persistenceId, return events in seqNr order
  //   2. currentEventsByTag: filter by tag, return events in seqNr order
  //   Combine both: given persistenceId and tag, return matching events.
  //   Return the list of OrderEvents.
  def exercise8_persistentQuery(
    envelopes: List[EventEnvelope],
    persistenceId: String,
    tag: String
  ): List[OrderEvent] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val events1 = List(
      OrderCreated("O1", List("A", "B"), 100.0),
      OrderCreated("O2", List("C"), 50.0),
      OrderConfirmed("O1"),
      OrderCancelled("O2"),
      OrderShipped("O1")
    )
    val orders = exercise1_eventSourcing(events1)
    assert(orders("O1").status == Shipped, s"Exercise 1 failed: O1 = ${orders("O1").status}")
    assert(orders("O2").status == Cancelled, s"Exercise 1 failed: O2 = ${orders("O2").status}")
    println("Exercise 1 passed: event sourcing builds state")

    // Exercise 2
    val readModel = exercise2_cqrsReadSide(events1)
    assert(readModel.totalRevenue == 100.0, s"Exercise 2 failed: revenue = ${readModel.totalRevenue}")
    assert(readModel.orderCount == 2, s"Exercise 2 failed: count = ${readModel.orderCount}")
    println(s"Exercise 2 passed: revenue=${readModel.totalRevenue}, orders=${readModel.orderCount}")

    // Exercise 3
    val env3 = exercise3_tagEvent(OrderCreated("O1", List("A"), 50.0), 1L)
    assert(env3.tags == Set("order", "created"), s"Exercise 3 failed: tags = ${env3.tags}")
    assert(env3.timestamp == 1000L, s"Exercise 3 failed: timestamp = ${env3.timestamp}")
    println(s"Exercise 3 passed: tags = ${env3.tags}")

    // Exercise 4
    val envelopes4 = List(
      EventEnvelope(1, "orders", OrderCreated("O1", Nil, 10), Set("order", "created"), 1000),
      EventEnvelope(2, "orders", OrderConfirmed("O1"), Set("order", "confirmed"), 2000),
      EventEnvelope(3, "orders", OrderCreated("O2", Nil, 20), Set("order", "created"), 3000)
    )
    val r4 = exercise4_queryByTag(envelopes4, "created")
    assert(r4.size == 2, s"Exercise 4 failed: expected 2, got ${r4.size}")
    assert(r4.head.sequenceNr == 1, "Exercise 4 failed: should be ordered by seqNr")
    println(s"Exercise 4 passed: ${r4.size} events with tag 'created'")

    // Exercise 5
    val (evt5a, st5a) = exercise5_persistentFSM(Pending, ConfirmOrder("O1"))
    assert(st5a == Confirmed, s"Exercise 5 failed: $st5a")
    assert(evt5a.contains(OrderConfirmed("O1")), s"Exercise 5 failed: $evt5a")
    val (evt5b, st5b) = exercise5_persistentFSM(Pending, ShipOrder("O1"))
    assert(st5b == Pending, "Exercise 5 failed: invalid transition should keep state")
    assert(evt5b.isEmpty, "Exercise 5 failed: invalid transition should produce no event")
    println("Exercise 5 passed: FSM transitions")

    // Exercise 6
    val attempts = List(
      DeliveryAttempt(1, "msg-A", confirmed = true),
      DeliveryAttempt(2, "msg-B", confirmed = false),
      DeliveryAttempt(2, "msg-B", confirmed = false), // duplicate
      DeliveryAttempt(3, "msg-C", confirmed = true)
    )
    val (redelivery, confirmed6) = exercise6_atLeastOnceDelivery(attempts)
    assert(redelivery == List("msg-B"), s"Exercise 6 failed: redelivery = $redelivery")
    assert(confirmed6.sorted == List(1L, 3L), s"Exercise 6 failed: confirmed = $confirmed6")
    println(s"Exercise 6 passed: redelivery=$redelivery, confirmed=$confirmed6")

    // Exercise 7
    val sagaSteps = List(
      SagaExecute("reserve-stock", "reserve 5 items"),
      SagaExecute("charge-payment", "charge $100"),
      SagaExecute("send-email", "FAIL: email service down"),
      SagaExecute("update-analytics", "increment counter")
    )
    val (executed, compensated) = exercise7_saga(sagaSteps)
    assert(executed == List("reserve-stock", "charge-payment"), s"Exercise 7 failed: $executed")
    assert(compensated == List("charge-payment", "reserve-stock"), s"Exercise 7 failed: $compensated")
    println(s"Exercise 7 passed: executed=$executed, compensated=$compensated")

    // Exercise 8
    val envelopes8 = List(
      EventEnvelope(1, "orders-1", OrderCreated("O1", Nil, 10), Set("order", "created"), 1000),
      EventEnvelope(2, "orders-2", OrderCreated("O2", Nil, 20), Set("order", "created"), 2000),
      EventEnvelope(3, "orders-1", OrderConfirmed("O1"), Set("order", "confirmed"), 3000)
    )
    val r8 = exercise8_persistentQuery(envelopes8, "orders-1", "order")
    assert(r8.size == 2, s"Exercise 8 failed: expected 2, got ${r8.size}")
    println(s"Exercise 8 passed: ${r8.size} events queried")

    println("\nAll Akka017_PersistencePattern exercises passed!")
  }
}
