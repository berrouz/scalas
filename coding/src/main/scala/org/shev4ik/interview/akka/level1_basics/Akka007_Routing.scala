package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 007 - Routing
 *
 * Routers distribute messages across a group of routee actors:
 *   - RoundRobin: cycles through routees in order
 *   - Random: randomly selects a routee
 *   - SmallestMailbox: sends to routee with fewest pending messages
 *   - Broadcast: sends to all routees
 *   - ScatterGatherFirstCompleted: sends to all, takes first response
 *   - ConsistentHashing: routes based on message hash key
 *   - Pool: router creates and manages its own routees
 *   - Group: router uses pre-existing actors as routees
 */
object Akka007_Routing {

  // --- Domain models ---

  case class Routee(name: String, mailboxSize: Int, processed: List[String])

  sealed trait RoutingStrategy
  case object RoundRobin extends RoutingStrategy
  case object RandomRouting extends RoutingStrategy
  case object SmallestMailbox extends RoutingStrategy
  case object Broadcast extends RoutingStrategy
  case object ScatterGather extends RoutingStrategy
  case class ConsistentHashing(hashFunction: String => Int) extends RoutingStrategy

  case class RouterConfig(
    strategy: RoutingStrategy,
    poolSize: Int,
    isPool: Boolean // true = pool (router creates routees), false = group
  )

  case class RouterState(routees: List[Routee], currentIndex: Int)

  // Exercise 1: Round Robin routing
  // TODO: Given a RouterState and a list of messages (strings),
  //   route each message to the next routee in order, cycling back to the start.
  //   Add each message to the routee's processed list.
  //   Return the updated RouterState with the final currentIndex.
  def exercise1_roundRobin(state: RouterState, messages: List[String]): RouterState = ???

  // Exercise 2: Random routing simulation
  // TODO: Given a RouterState, a list of messages, and a function Int => Int
  //   that maps message index to routee index (simulating randomness),
  //   route each message to the routee at the index returned by the function
  //   (modulo number of routees). Return updated RouterState.
  def exercise2_randomRouting(
    state: RouterState,
    messages: List[String],
    randomIndex: Int => Int
  ): RouterState = ???

  // Exercise 3: Smallest Mailbox routing
  // TODO: Given a RouterState and a message, route the message to the routee
  //   with the smallest mailboxSize. In case of tie, pick the first one.
  //   Increment that routee's mailboxSize by 1 and add message to processed.
  //   Process a list of messages this way and return the final state.
  def exercise3_smallestMailbox(state: RouterState, messages: List[String]): RouterState = ???

  // Exercise 4: Broadcast routing
  // TODO: Given a RouterState and a single message, send it to ALL routees.
  //   Each routee adds the message to its processed list.
  //   Given a list of messages, broadcast each one. Return the final state.
  def exercise4_broadcast(state: RouterState, messages: List[String]): RouterState = ???

  // Exercise 5: Scatter-Gather first completed
  // TODO: Given a RouterState and a message, simulate scatter-gather:
  //   Send message to all routees (add to processed), then select the routee
  //   with the smallest mailboxSize as the "winner" (fastest to respond).
  //   Return (winnerName, updatedRouterState).
  def exercise5_scatterGather(state: RouterState, message: String): (String, RouterState) = ???

  // Exercise 6: Consistent Hashing
  // TODO: Given a list of routees, a hash function (String => Int), and a list of messages,
  //   route each message to routee at index: abs(hashFunction(message)) % routees.size.
  //   Return the updated RouterState.
  def exercise6_consistentHashing(
    state: RouterState,
    hashFunction: String => Int,
    messages: List[String]
  ): RouterState = ???

  // Exercise 7: Pool vs Group router
  // TODO: Given a RouterConfig:
  //   If isPool=true, create poolSize new Routees named "routee-0", "routee-1", etc.
  //     with mailboxSize=0 and empty processed.
  //   If isPool=false (group), use the provided existingRoutees as-is.
  //   Return a RouterState with currentIndex=0.
  def exercise7_poolVsGroup(config: RouterConfig, existingRoutees: List[Routee]): RouterState = ???

  // Exercise 8: Resizable router
  // TODO: Given a RouterState and a threshold:
  //   If ALL routees have mailboxSize >= threshold, add a new routee named
  //     "routee-{n}" where n is the current routee count, with mailboxSize=0.
  //   If ANY routee has mailboxSize == 0 and routees.size > 1, remove it (keep at least 1).
  //   Return the updated RouterState.
  //   Note: check resize-up first, then resize-down.
  def exercise8_resizableRouter(state: RouterState, threshold: Int): RouterState = ???

  def main(args: Array[String]): Unit = {
    val routees3 = List(
      Routee("r0", 0, Nil),
      Routee("r1", 0, Nil),
      Routee("r2", 0, Nil)
    )
    val state0 = RouterState(routees3, 0)

    // Exercise 1
    val r1 = exercise1_roundRobin(state0, List("a", "b", "c", "d", "e"))
    assert(r1.routees(0).processed == List("a", "d"), s"Exercise 1 failed: r0 = ${r1.routees(0).processed}")
    assert(r1.routees(1).processed == List("b", "e"), s"Exercise 1 failed: r1 = ${r1.routees(1).processed}")
    assert(r1.routees(2).processed == List("c"), s"Exercise 1 failed: r2 = ${r1.routees(2).processed}")
    assert(r1.currentIndex == 2, s"Exercise 1 failed: currentIndex = ${r1.currentIndex}")
    println("Exercise 1 passed: round robin routing")

    // Exercise 2
    val r2 = exercise2_randomRouting(state0, List("x", "y", "z"), i => i * 7) // indices: 0,7%3=1,14%3=2
    assert(r2.routees(0).processed == List("x"), s"Exercise 2 failed: r0 = ${r2.routees(0).processed}")
    assert(r2.routees(1).processed == List("y"), s"Exercise 2 failed: r1 = ${r2.routees(1).processed}")
    assert(r2.routees(2).processed == List("z"), s"Exercise 2 failed: r2 = ${r2.routees(2).processed}")
    println("Exercise 2 passed: random routing")

    // Exercise 3
    val r3 = exercise3_smallestMailbox(state0, List("a", "b", "c", "d"))
    // All start at 0: first goes to r0(1), then r1(1), then r2(1), then r0(2)
    assert(r3.routees(0).processed == List("a", "d"), s"Exercise 3 failed: r0 = ${r3.routees(0).processed}")
    assert(r3.routees(1).processed == List("b"), s"Exercise 3 failed: r1 = ${r3.routees(1).processed}")
    assert(r3.routees(2).processed == List("c"), s"Exercise 3 failed: r2 = ${r3.routees(2).processed}")
    println("Exercise 3 passed: smallest mailbox routing")

    // Exercise 4
    val r4 = exercise4_broadcast(state0, List("msg1", "msg2"))
    assert(r4.routees(0).processed == List("msg1", "msg2"), s"Exercise 4 failed: r0 = ${r4.routees(0).processed}")
    assert(r4.routees(1).processed == List("msg1", "msg2"), s"Exercise 4 failed: r1 = ${r4.routees(1).processed}")
    println("Exercise 4 passed: broadcast routing")

    // Exercise 5
    val stateWithSizes = RouterState(List(
      Routee("r0", 5, Nil),
      Routee("r1", 2, Nil),
      Routee("r2", 8, Nil)
    ), 0)
    val (winner5, r5) = exercise5_scatterGather(stateWithSizes, "query")
    assert(winner5 == "r1", s"Exercise 5 failed: winner = $winner5")
    assert(r5.routees.forall(_.processed == List("query")), "Exercise 5 failed: all should have message")
    println(s"Exercise 5 passed: winner = $winner5")

    // Exercise 6
    val r6 = exercise6_consistentHashing(state0, s => s.hashCode, List("alice", "bob", "alice", "charlie"))
    // Same key ("alice") should always go to the same routee
    val aliceIdx = math.abs("alice".hashCode) % 3
    val aliceCount = r6.routees(aliceIdx).processed.count(_ == "alice")
    assert(aliceCount == 2, s"Exercise 6 failed: alice should appear twice at index $aliceIdx")
    println("Exercise 6 passed: consistent hashing")

    // Exercise 7
    val poolConfig = RouterConfig(RoundRobin, 4, isPool = true)
    val r7a = exercise7_poolVsGroup(poolConfig, Nil)
    assert(r7a.routees.size == 4, s"Exercise 7 failed: pool should have 4 routees")
    assert(r7a.routees.head.name == "routee-0", s"Exercise 7 failed: ${r7a.routees.head.name}")
    val groupConfig = RouterConfig(RoundRobin, 0, isPool = false)
    val r7b = exercise7_poolVsGroup(groupConfig, routees3)
    assert(r7b.routees.size == 3, "Exercise 7 failed: group should use existing routees")
    println("Exercise 7 passed: pool vs group")

    // Exercise 8
    val stateAllBusy = RouterState(List(
      Routee("r0", 10, Nil),
      Routee("r1", 10, Nil)
    ), 0)
    val r8a = exercise8_resizableRouter(stateAllBusy, 5)
    assert(r8a.routees.size == 3, s"Exercise 8 failed: should resize up to 3, got ${r8a.routees.size}")
    val stateWithIdle = RouterState(List(
      Routee("r0", 5, Nil),
      Routee("r1", 0, Nil)
    ), 0)
    val r8b = exercise8_resizableRouter(stateWithIdle, 10)
    assert(r8b.routees.size == 1, s"Exercise 8 failed: should resize down to 1, got ${r8b.routees.size}")
    println("Exercise 8 passed: resizable router")

    println("\nAll Akka007_Routing exercises passed!")
  }
}
