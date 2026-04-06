package org.shev4ik.interview.system_design.level2_patterns

object SysDes007_CQRS {

  // ---- Domain types ----

  sealed trait Command
  case class CreateProduct(productId: String, name: String, price: Double) extends Command
  case class UpdatePrice(productId: String, newPrice: Double) extends Command
  case class DeleteProduct(productId: String) extends Command

  sealed trait Event
  case class ProductCreated(productId: String, name: String, price: Double, timestamp: Long) extends Event
  case class PriceUpdated(productId: String, oldPrice: Double, newPrice: Double, timestamp: Long) extends Event
  case class ProductDeleted(productId: String, timestamp: Long) extends Event

  // Write model: full state used for validation
  case class ProductWriteModel(productId: String, name: String, price: Double, deleted: Boolean = false)
  // Read model: optimized for queries
  case class ProductReadModel(productId: String, name: String, price: Double)
  // Price history read model
  case class PriceHistoryEntry(productId: String, price: Double, timestamp: Long)

  // ---- Exercise 1 ----
  // TODO: Implement the command model (write side).
  // Maintain a Map[String, ProductWriteModel] as the write store.
  // `applyCommand(store, command, timestamp)`:
  //   - CreateProduct: fail if product already exists (and not deleted), else create
  //   - UpdatePrice: fail if product doesn't exist or is deleted
  //   - DeleteProduct: fail if product doesn't exist or is deleted
  // Return Either[String, (Map[String, ProductWriteModel], Event)]
  def applyCommand(
    store: Map[String, ProductWriteModel],
    command: Command,
    timestamp: Long
  ): Either[String, (Map[String, ProductWriteModel], Event)] = ???

  // ---- Exercise 2 ----
  // TODO: Implement the query model (read side).
  // Maintain a Map[String, ProductReadModel] as the read store.
  // Queries:
  // - `getProduct(store, productId)`: Option[ProductReadModel]
  // - `getAllProducts(store)`: List[ProductReadModel]
  // - `getProductsByPriceRange(store, minPrice, maxPrice)`: List[ProductReadModel]
  def getProduct(store: Map[String, ProductReadModel], productId: String): Option[ProductReadModel] = ???

  def getAllProducts(store: Map[String, ProductReadModel]): List[ProductReadModel] = ???

  def getProductsByPriceRange(
    store: Map[String, ProductReadModel],
    minPrice: Double,
    maxPrice: Double
  ): List[ProductReadModel] = ???

  // ---- Exercise 3 ----
  // TODO: Implement a command handler that validates and produces events.
  // Combine validation logic with event generation.
  // Given the full command pipeline: validate command against write model,
  // produce event, return the event or error.
  // This is essentially `applyCommand` but returns only the Event.
  def handleCommand(
    writeStore: Map[String, ProductWriteModel],
    command: Command,
    timestamp: Long
  ): Either[String, Event] = ???

  // ---- Exercise 4 ----
  // TODO: Implement an event publisher / event bus.
  // - `publish(event)`: add event to the bus
  // - `subscribe(handler)`: register a handler (Event => Unit)
  // For testability: handlers return Option[String], collect all results.
  // - `processAll`: apply all pending events to all handlers, clear pending events
  // Return (updatedBus, results: List[String])
  trait EventBus {
    def publish(event: Event): EventBus
    def subscribe(handler: Event => Option[String]): EventBus
    def processAll: (EventBus, List[String])
    def pendingCount: Int
  }

  def createEventBus(): EventBus = ???

  // ---- Exercise 5 ----
  // TODO: Implement a read model updater.
  // Given an event, update the read store (Map[String, ProductReadModel]).
  // - ProductCreated => add to read store
  // - PriceUpdated => update price in read store
  // - ProductDeleted => remove from read store
  def updateReadModel(
    readStore: Map[String, ProductReadModel],
    event: Event
  ): Map[String, ProductReadModel] = ???

  // ---- Exercise 6 ----
  // TODO: Simulate eventual consistency.
  // Given a write store processing commands synchronously and a read store
  // that is updated with a "lag" (processes events in batches), simulate:
  // 1. Process N commands, collecting events
  // 2. Apply only the first `batchSize` events to the read model
  // 3. Return (writeStore, readStore, pendingEvents) to show inconsistency
  def simulateEventualConsistency(
    commands: List[(Command, Long)],
    batchSize: Int
  ): (Map[String, ProductWriteModel], Map[String, ProductReadModel], List[Event]) = ???

  // ---- Exercise 7 ----
  // TODO: Implement synchronous vs asynchronous CQRS.
  // Synchronous: process command, immediately update both write and read models.
  // Return (writeStore, readStore).
  // Asynchronous: process command, update write model, queue event for later read update.
  // Return (writeStore, readStore, pendingEvents).
  def syncCQRS(
    writeStore: Map[String, ProductWriteModel],
    readStore: Map[String, ProductReadModel],
    command: Command,
    timestamp: Long
  ): Either[String, (Map[String, ProductWriteModel], Map[String, ProductReadModel])] = ???

  def asyncCQRS(
    writeStore: Map[String, ProductWriteModel],
    readStore: Map[String, ProductReadModel],
    pendingEvents: List[Event],
    command: Command,
    timestamp: Long
  ): Either[String, (Map[String, ProductWriteModel], Map[String, ProductReadModel], List[Event])] = ???

  // ---- Exercise 8 ----
  // TODO: Implement a materialized view (price history).
  // Maintain a List[PriceHistoryEntry] that records every price change.
  // `updatePriceHistory(history, event)`: append entry for PriceUpdated and ProductCreated events.
  // `queryPriceHistory(history, productId)`: return all price entries for a product, sorted by timestamp.
  def updatePriceHistory(history: List[PriceHistoryEntry], event: Event): List[PriceHistoryEntry] = ???

  def queryPriceHistory(history: List[PriceHistoryEntry], productId: String): List[PriceHistoryEntry] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Command Model
    val ws0 = Map.empty[String, ProductWriteModel]
    val r1 = applyCommand(ws0, CreateProduct("p1", "Widget", 9.99), 100)
    assert(r1.isRight)
    val (ws1, ev1) = r1.toOption.get
    assert(ws1.contains("p1"))
    val r2 = applyCommand(ws1, CreateProduct("p1", "Dup", 5.0), 200)
    assert(r2.isLeft) // already exists
    val r3 = applyCommand(ws1, UpdatePrice("p1", 12.99), 200)
    assert(r3.isRight)
    println("Exercise 1 passed: Command Model")

    // Exercise 2: Query Model
    val rs = Map("p1" -> ProductReadModel("p1", "Widget", 9.99), "p2" -> ProductReadModel("p2", "Gadget", 19.99))
    assert(getProduct(rs, "p1").isDefined)
    assert(getProduct(rs, "p3").isEmpty)
    assert(getAllProducts(rs).length == 2)
    assert(getProductsByPriceRange(rs, 10.0, 20.0).length == 1)
    println("Exercise 2 passed: Query Model")

    // Exercise 3: Command Handler
    val cmdResult = handleCommand(ws0, CreateProduct("p1", "Widget", 9.99), 100)
    assert(cmdResult.isRight)
    val failCmd = handleCommand(ws0, UpdatePrice("p99", 1.0), 100)
    assert(failCmd.isLeft)
    println("Exercise 3 passed: Command Handler")

    // Exercise 4: Event Bus
    val bus0 = createEventBus()
    var collected = List.empty[String]
    val handler: Event => Option[String] = {
      case ProductCreated(id, _, _, _) => Some(s"Created: $id")
      case _ => None
    }
    val bus1 = bus0.subscribe(handler).publish(ProductCreated("p1", "W", 9.99, 100))
    assert(bus1.pendingCount == 1)
    val (bus2, results) = bus1.processAll
    assert(results.length == 1)
    assert(bus2.pendingCount == 0)
    println("Exercise 4 passed: Event Bus")

    // Exercise 5: Read Model Updater
    val rs0 = Map.empty[String, ProductReadModel]
    val rs1 = updateReadModel(rs0, ProductCreated("p1", "Widget", 9.99, 100))
    assert(rs1.contains("p1"))
    val rs2 = updateReadModel(rs1, PriceUpdated("p1", 9.99, 12.99, 200))
    assert(rs2("p1").price == 12.99)
    val rs3 = updateReadModel(rs2, ProductDeleted("p1", 300))
    assert(!rs3.contains("p1"))
    println("Exercise 5 passed: Read Model Updater")

    // Exercise 6: Eventual Consistency
    val commands = List(
      (CreateProduct("p1", "A", 10.0), 100L),
      (CreateProduct("p2", "B", 20.0), 200L),
      (UpdatePrice("p1", 15.0), 300L)
    )
    val (finalWs, finalRs, pending) = simulateEventualConsistency(commands, batchSize = 2)
    assert(finalWs.size == 2)
    assert(finalRs.size <= 2) // read model may lag
    assert(pending.length == 1) // 1 event not yet applied to read
    println("Exercise 6 passed: Eventual Consistency")

    // Exercise 7: Sync vs Async CQRS
    val syncResult = syncCQRS(ws0, Map.empty, CreateProduct("p1", "W", 9.99), 100)
    assert(syncResult.isRight)
    val (sws, srs) = syncResult.toOption.get
    assert(sws.contains("p1") && srs.contains("p1"))

    val asyncResult = asyncCQRS(ws0, Map.empty, Nil, CreateProduct("p1", "W", 9.99), 100)
    assert(asyncResult.isRight)
    val (aws, ars, ape) = asyncResult.toOption.get
    assert(aws.contains("p1"))
    assert(!ars.contains("p1")) // not yet updated
    assert(ape.length == 1)
    println("Exercise 7 passed: Sync/Async CQRS")

    // Exercise 8: Materialized View (Price History)
    val h0 = List.empty[PriceHistoryEntry]
    val h1 = updatePriceHistory(h0, ProductCreated("p1", "Widget", 9.99, 100))
    val h2 = updatePriceHistory(h1, PriceUpdated("p1", 9.99, 12.99, 200))
    val h3 = updatePriceHistory(h2, PriceUpdated("p1", 12.99, 14.99, 300))
    val history = queryPriceHistory(h3, "p1")
    assert(history.length == 3)
    assert(history.head.timestamp == 100)
    assert(history.last.price == 14.99)
    println("Exercise 8 passed: Materialized View")

    println("All SysDes007_CQRS exercises passed!")
  }
}
