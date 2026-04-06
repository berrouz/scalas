package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 003 - Actor State Management
 *
 * Actors manage state through different mechanisms:
 *   - Mutable var: simple but classic approach in untyped Akka
 *   - context.become: swapping the receive function (functional approach)
 *   - context.unbecome: reverting to previous behavior
 *   - FSM (Finite State Machine): formal state machine DSL
 *   - State transitions: moving between defined behaviors
 *   - Accumulator: actor that aggregates data over time
 *   - State recovery: restoring state after restart
 */
object Akka003_State {

  // --- Domain models ---

  sealed trait CounterMsg
  case class Add(n: Int) extends CounterMsg
  case class Subtract(n: Int) extends CounterMsg
  case object GetCount extends CounterMsg

  /** Models context.become — a behavior is a function from message to (result, next behavior) */
  type Behavior[M, S] = (S, M) => (S, Option[String])

  /** FSM states for a traffic light */
  sealed trait TrafficLightState
  case object Red extends TrafficLightState
  case object Yellow extends TrafficLightState
  case object Green extends TrafficLightState

  sealed trait TrafficCommand
  case object Next extends TrafficCommand
  case object GetState extends TrafficCommand

  /** Door FSM */
  sealed trait DoorState
  case object Open extends DoorState
  case object Closed extends DoorState
  case object Locked extends DoorState

  sealed trait DoorCommand
  case object OpenDoor extends DoorCommand
  case object CloseDoor extends DoorCommand
  case object LockDoor extends DoorCommand
  case object UnlockDoor extends DoorCommand

  // Exercise 1: Stateful actor using mutable var
  // TODO: Simulate a counter actor that uses a mutable var.
  //   Process a list of CounterMsg in order:
  //     Add(n) -> add n to counter
  //     Subtract(n) -> subtract n from counter
  //     GetCount -> no-op (just reading)
  //   Return the final count value.
  def exercise1_mutableState(messages: List[CounterMsg]): Int = ???

  // Exercise 2: Stateful using become (behavior swapping)
  // TODO: Implement a behavior function for a "mood actor" that alternates
  //   between "happy" and "grumpy" behaviors.
  //   When happy: Add(n) adds n to state, Subtract(n) is ignored (returns state unchanged)
  //   When grumpy: Add(n) is ignored, Subtract(n) subtracts n from state
  //   GetCount returns state, and also toggles the mood.
  //   Given an initial mood ("happy" or "grumpy"), initial value, and list of messages,
  //   return the final value.
  def exercise2_becomePattern(initialMood: String, initialValue: Int, messages: List[CounterMsg]): Int = ???

  // Exercise 3: context.become simulation
  // TODO: Implement a "switch" that can be toggled between "on" and "off" behaviors.
  //   In "on" state: Add(n) -> adds n, GetCount -> returns state
  //   In "off" state: all Add/Subtract messages are ignored, GetCount -> returns state
  //   Subtract(n) always toggles the state (on->off, off->on), regardless of current state.
  //   Given initial isOn=true and messages, return (finalValue, finalIsOn).
  def exercise3_contextBecome(messages: List[CounterMsg]): (Int, Boolean) = ???

  // Exercise 4: context.unbecome simulation (stack of behaviors)
  // TODO: Model a behavior stack. Start with base behavior that adds normally.
  //   Add(n) where n > 100 -> push a "doubling" behavior (all subsequent Add values are doubled)
  //   Subtract(n) where n > 100 -> pop behavior (unbecome), revert to previous
  //   Process messages and return the final accumulated value starting from 0.
  def exercise4_contextUnbecome(messages: List[CounterMsg]): Int = ???

  // Exercise 5: FSM traffic light
  // TODO: Implement a traffic light FSM. Starting from Red:
  //   Next transitions: Red -> Green -> Yellow -> Red -> ...
  //   Process a list of TrafficCommand and return the final TrafficLightState.
  //   GetState does not change the state.
  def exercise5_fsmTrafficLight(commands: List[TrafficCommand]): TrafficLightState = ???

  // Exercise 6: State transitions for a Door FSM
  // TODO: Implement Door state transitions:
  //   Closed + OpenDoor -> Open
  //   Open + CloseDoor -> Closed
  //   Closed + LockDoor -> Locked
  //   Locked + UnlockDoor -> Closed
  //   Invalid transitions return the same state (e.g., Open + LockDoor -> Open)
  //   Return the final DoorState after processing all commands starting from Closed.
  def exercise6_doorFSM(commands: List[DoorCommand]): DoorState = ???

  // Exercise 7: Accumulator actor
  // TODO: Implement an accumulator that collects values into a List[Int].
  //   Add(n) -> append n to the list
  //   Subtract(n) -> remove the first occurrence of n from the list
  //   GetCount -> no-op
  //   Return the final list after processing all messages, starting with an empty list.
  def exercise7_accumulator(messages: List[CounterMsg]): List[Int] = ???

  // Exercise 8: State recovery after restart
  // TODO: Simulate state recovery. Given a list of CounterMsg (the "event log"),
  //   replay all messages to reconstruct state (sum of all Add values minus Subtract values).
  //   Then apply a new list of messages on top.
  //   Return the final count.
  def exercise8_stateRecovery(eventLog: List[CounterMsg], newMessages: List[CounterMsg]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_mutableState(List(Add(10), Add(5), Subtract(3), Add(1)))
    assert(r1 == 13, s"Exercise 1 failed: expected 13, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2a = exercise2_becomePattern("happy", 0, List(Add(10), Subtract(5), GetCount, Add(3), Subtract(2)))
    // happy: Add(10)->10, Subtract(5)->ignored=10, GetCount->toggle to grumpy=10
    // grumpy: Add(3)->ignored=10, Subtract(2)->8
    assert(r2a == 8, s"Exercise 2 failed: expected 8, got $r2a")
    println(s"Exercise 2 passed: $r2a")

    // Exercise 3
    val (v3, on3) = exercise3_contextBecome(List(Add(10), Add(5), Subtract(0), Add(3), Subtract(0), Add(7)))
    // on: Add(10)->10, Add(5)->15, Subtract(0)->toggle off
    // off: Add(3)->ignored=15, Subtract(0)->toggle on
    // on: Add(7)->22
    assert(v3 == 22, s"Exercise 3 failed: expected value 22, got $v3")
    assert(on3, s"Exercise 3 failed: expected isOn=true, got $on3")
    println(s"Exercise 3 passed: ($v3, $on3)")

    // Exercise 4
    val r4 = exercise4_contextUnbecome(List(Add(5), Add(200), Add(10), Add(3), Subtract(200), Add(7)))
    // base: Add(5)->5, Add(200)->push doubling, value=5+200=205
    // doubling: Add(10)->205+20=225, Add(3)->225+6=231
    // Subtract(200)->pop/unbecome, value=231 (subtract ignored since >100 triggers pop)
    // base: Add(7)->238
    assert(r4 == 238, s"Exercise 4 failed: expected 238, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = exercise5_fsmTrafficLight(List(Next, Next, Next, GetState, Next))
    // Red->Green->Yellow->Red (GetState)->Green
    assert(r5 == Green, s"Exercise 5 failed: expected Green, got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = exercise6_doorFSM(List(OpenDoor, CloseDoor, LockDoor, OpenDoor, UnlockDoor, OpenDoor))
    // Closed->Open->Closed->Locked->(invalid)Locked->Closed->Open
    assert(r6 == Open, s"Exercise 6 failed: expected Open, got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7_accumulator(List(Add(1), Add(2), Add(3), Subtract(2), Add(4)))
    assert(r7 == List(1, 3, 4), s"Exercise 7 failed: expected List(1, 3, 4), got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val log = List(Add(10), Add(20), Subtract(5))
    val newMsgs = List(Add(3), Subtract(1))
    val r8 = exercise8_stateRecovery(log, newMsgs)
    assert(r8 == 27, s"Exercise 8 failed: expected 27, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka003_State exercises passed!")
  }
}
