package org.shev4ik.interview.scala_core.level3_advanced

object Core106_TypedActors {

  // Exercise 1: Typed message protocol
  // TODO: Define a typed message protocol using sealed traits
  sealed trait Command
  case class Greet(name: String) extends Command
  case class Add(a: Int, b: Int, replyTo: Int => Unit) extends Command
  case object Stop extends Command

  // TODO: Define a typed actor that only accepts Command messages
  class TypedActor[T](handler: T => Unit) {
    def tell(msg: T): Unit = ???
  }

  // Exercise 2: Typed actor state
  // TODO: Define a stateful typed actor using a var and typed messages
  sealed trait CounterMsg
  case object Increment extends CounterMsg
  case object Decrement extends CounterMsg
  case class GetCount(replyTo: Int => Unit) extends CounterMsg

  class CounterActor {
    private var count = 0
    def receive(msg: CounterMsg): Unit = ???
    def currentCount: Int = ???
  }

  // Exercise 3: Typed behavior
  // TODO: Define a Behavior type that represents how an actor processes messages
  trait Behavior[T] {
    def onMessage(msg: T): Behavior[T]
  }

  // TODO: Create a counter behavior
  def counterBehavior(count: Int): Behavior[CounterMsg] = ???

  // Exercise 4: Typed tell pattern
  // TODO: Implement a typed ActorRef that enforces message types
  class ActorRef[T](private val behavior: Behavior[T]) {
    private var currentBehavior: Behavior[T] = behavior
    def tell(msg: T): Unit = ???
  }

  object ActorRef {
    def apply[T](behavior: Behavior[T]): ActorRef[T] = ???
  }

  // Exercise 5: Typed ask pattern
  // TODO: Implement a simple synchronous ask pattern using a callback
  sealed trait CalcMsg
  case class Calculate(a: Int, b: Int, replyTo: Int => Unit) extends CalcMsg

  class Calculator {
    def receive(msg: CalcMsg): Unit = ???
  }

  // TODO: Implement ask helper
  def ask(calculator: Calculator, a: Int, b: Int): Int = ???

  // Exercise 6: Typed supervision
  // TODO: Define a supervision strategy as a typed handler
  sealed trait SupervisorAction
  case object Resume extends SupervisorAction
  case object Restart extends SupervisorAction
  case object StopActor extends SupervisorAction

  trait SupervisionStrategy {
    def handle(error: Throwable): SupervisorAction
  }

  // TODO: Implement a default supervision strategy
  val defaultStrategy: SupervisionStrategy = ???

  // Exercise 7: Typed router
  // TODO: Implement a simple typed router that distributes messages
  class TypedRouter[T](workers: List[T => Unit]) {
    private var index = 0
    def route(msg: T): Unit = ???
  }

  // Exercise 8: Typed FSM (Finite State Machine)
  // TODO: Define a typed FSM for a traffic light
  sealed trait TrafficState
  case object GreenLight extends TrafficState
  case object YellowLight extends TrafficState
  case object RedLight extends TrafficState

  sealed trait TrafficEvent
  case object Timer extends TrafficEvent

  class TrafficFSM(private var state: TrafficState = RedLight) {
    def currentState: TrafficState = ???
    def handleEvent(event: TrafficEvent): TrafficState = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    var received = ""
    val actor = new TypedActor[Command](msg => msg match {
      case Greet(name) => received = s"Hello, $name"
      case _ =>
    })
    actor.tell(Greet("World"))
    assert(received == "Hello, World")

    // Exercise 2
    val counter = new CounterActor
    counter.receive(Increment)
    counter.receive(Increment)
    counter.receive(Increment)
    counter.receive(Decrement)
    assert(counter.currentCount == 2)

    // Exercise 3
    var behavior = counterBehavior(0)
    behavior = behavior.onMessage(Increment)
    behavior = behavior.onMessage(Increment)
    var capturedCount = 0
    behavior.onMessage(GetCount(c => capturedCount = c))
    assert(capturedCount == 2)

    // Exercise 4
    val ref = ActorRef(counterBehavior(0))
    ref.tell(Increment)
    ref.tell(Increment)
    ref.tell(Increment)

    // Exercise 5
    val calc = new Calculator
    assert(ask(calc, 3, 4) == 7)

    // Exercise 6
    assert(defaultStrategy.handle(new RuntimeException("test")) == Resume)
    assert(defaultStrategy.handle(new OutOfMemoryError("test")) == StopActor)

    // Exercise 7
    var results = List.empty[Int]
    val router = new TypedRouter[Int](List(
      i => results = results :+ (i * 1),
      i => results = results :+ (i * 2),
      i => results = results :+ (i * 3)
    ))
    router.route(10)
    router.route(10)
    router.route(10)
    assert(results.length == 3)

    // Exercise 8
    val fsm = new TrafficFSM()
    assert(fsm.currentState == RedLight)
    assert(fsm.handleEvent(Timer) == GreenLight)
    assert(fsm.handleEvent(Timer) == YellowLight)
    assert(fsm.handleEvent(Timer) == RedLight)

    println("All Core106_TypedActors exercises passed!")
  }
}
