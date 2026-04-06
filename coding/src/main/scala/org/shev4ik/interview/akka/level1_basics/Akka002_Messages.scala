package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 002 - Actor Messaging Patterns
 *
 * =Overview=
 * In the Actor Model, '''messages''' are the sole mechanism for communication between actors.
 * Actors never share mutable state -- they interact exclusively by sending immutable messages
 * to each other's mailboxes. Understanding messaging patterns is fundamental to designing
 * robust Akka systems.
 *
 * =Message Requirements=
 *  - '''Immutable''': Messages must be immutable (case classes, case objects). Mutable messages
 *    break actor isolation and introduce race conditions.
 *  - '''Serializable''': For remote actors (Akka Cluster/Remoting), messages must be serializable.
 *    Prefer Protobuf or Jackson over Java serialization for performance and compatibility.
 *  - '''Self-contained''': Messages should carry all necessary data. Avoid passing mutable
 *    references or closures that capture external state.
 *
 * =tell (!) vs ask (?)=
 * {{{
 *   // Fire-and-forget (tell): actor ! message
 *   userActor ! CreateUser("Alice")    // non-blocking, no response
 *
 *   // Request-response (ask): actor ? message
 *   val future: Future[User] = (userActor ? GetUser(1)).mapTo[User]  // returns a Future
 * }}}
 *  - '''tell (!)''': Fire-and-forget. The sender does not wait for or expect a reply. This is
 *    the preferred pattern -- it is non-blocking and naturally concurrent.
 *  - '''ask (?)''': Creates a temporary actor to receive the reply, returning a `Future`.
 *    Has a timeout. Use sparingly -- it introduces coupling and resource overhead.
 *    In Akka Typed, ask is safer: `context.ask(actor, ref => Request(ref)) { ... }`
 *
 * =Message Ordering Guarantees=
 * Akka guarantees message ordering '''per sender-receiver pair''':
 *  - If actor A sends messages m1, m2, m3 to actor B, B receives them in order: m1, m2, m3
 *  - NO ordering guarantee across different sender-receiver pairs: if A sends to B and C
 *    sends to B, B may interleave messages from A and C in any order
 *  - NO guarantee of delivery (at-most-once by default). For at-least-once, use
 *    Akka Persistence or explicit acknowledgment protocols.
 *
 * =Message Protocol Design=
 * Best practice is to define message protocols as '''sealed traits''':
 * {{{
 *   sealed trait UserCommand
 *   case class CreateUser(name: String, replyTo: ActorRef[UserEvent]) extends UserCommand
 *   case class GetUser(id: Int, replyTo: ActorRef[Option[User]]) extends UserCommand
 * }}}
 * Sealed traits enable exhaustive pattern matching and make the actor's API explicit.
 *
 * =Akka Classic vs Akka Typed=
 * '''Akka Classic''' (untyped):
 *  - Actors extend `Actor`, override `receive: Receive` (which is `PartialFunction[Any, Unit]`)
 *  - Messages are `Any` -- no compile-time type safety
 *  - Easy to send wrong message types, leading to runtime `unhandled` messages
 *
 * '''Akka Typed''' (modern, recommended):
 *  - Actors are defined as `Behavior[T]` where `T` is the message type
 *  - `ActorRef[T]` only accepts messages of type `T` -- compile-time safety
 *  - Reply-to pattern uses typed `ActorRef[Response]` in the message
 *  - No `sender()` -- explicit reply channels in messages
 *
 * =Key Patterns=
 *  - '''Reply-to''': Message carries an `ActorRef` (or callback) for the response
 *  - '''Message adaptor''': Transform messages between different protocols when actors
 *    speak different "languages" (e.g., external events to internal commands)
 *  - '''PoisonPill / Shutdown''': Graceful actor termination signal
 *  - '''Stash''': Buffer messages while in a transitional state, replay later
 *
 * =Interview Tip=
 * ''"Akka Classic vs Akka Typed -- what's the difference and which should you use?"''
 *
 * '''Answer:''' Modern Akka uses '''typed actors''' (`Behavior[T]`) which provide compile-time
 * safety for message types. In Classic Akka, actors accept `Any` messages and rely on runtime
 * pattern matching -- wrong message types silently go to the dead letter queue. Typed actors
 * make the message protocol part of the type signature: `ActorRef[UserCommand]` guarantees
 * only `UserCommand` subtypes can be sent. For new projects, always use Akka Typed. Note that
 * since Akka's BSL license change (2.7+), many teams are migrating to Apache Pekko (the
 * open-source Akka fork) or to effect-based alternatives like Cats Effect / ZIO.
 */
object Akka002_Messages {

  // --- Domain models ---

  sealed trait Command
  case class CreateUser(name: String, replyTo: Either[String, User] => Unit) extends Command
  case class DeleteUser(id: Int) extends Command
  case class GetUser(id: Int, replyTo: Option[User] => Unit) extends Command
  case object Shutdown extends Command

  case class User(id: Int, name: String)

  sealed trait StatusMessage
  case object Ack extends StatusMessage
  case class Nack(reason: String) extends StatusMessage

  sealed trait ExternalEvent
  case class OrderPlaced(orderId: String, amount: Double) extends ExternalEvent
  case class OrderCancelled(orderId: String) extends ExternalEvent

  sealed trait InternalCommand
  case class ProcessOrder(orderId: String, amount: Double) extends InternalCommand
  case class CancelOrder(orderId: String) extends InternalCommand
  case class UnknownEvent(description: String) extends InternalCommand

  case class UserStore(users: Map[Int, User], nextId: Int)

  // Exercise 1: Create immutable messages
  // TODO: Given a name and an age, return a tuple of two messages:
  //   (CreateUser(name, _), DeleteUser(0))
  //   For CreateUser, use a no-op replyTo: _ => ().
  //   This demonstrates that messages are simple immutable values.
  def exercise1_immutableMessages(name: String, age: Int): (Command, Command) = ???

  // Exercise 2: Implement reply-to pattern
  // TODO: Process a CreateUser command against a UserStore.
  //   If a user with the same name already exists, call replyTo with Left("User already exists").
  //   Otherwise, create a new User with nextId, add to store, call replyTo with Right(newUser),
  //   and return the updated UserStore.
  def exercise2_replyToPattern(store: UserStore, cmd: CreateUser): UserStore = ???

  // Exercise 3: Design a complete message protocol
  // TODO: Process any Command against a UserStore and return the updated store:
  //   - CreateUser: delegate to exercise2_replyToPattern
  //   - DeleteUser(id): remove user from map, keep same nextId
  //   - GetUser(id, replyTo): call replyTo with users.get(id), return store unchanged
  //   - Shutdown: return store unchanged (in real Akka, this would stop the actor)
  def exercise3_messageProtocol(store: UserStore, cmd: Command): UserStore = ???

  // Exercise 4: Model PoisonPill concept
  // TODO: Given a list of Commands, process them in order but STOP processing
  //   (do not process further messages) when Shutdown is encountered.
  //   Return the final UserStore after processing.
  def exercise4_poisonPill(store: UserStore, commands: List[Command]): UserStore = ???

  // Exercise 5: Create status response messages
  // TODO: Given a Command, return the appropriate StatusMessage:
  //   - CreateUser with a non-empty name -> Ack
  //   - CreateUser with empty name -> Nack("Name cannot be empty")
  //   - DeleteUser with id >= 0 -> Ack
  //   - DeleteUser with id < 0 -> Nack("Invalid user id")
  //   - GetUser(_,_) -> Ack
  //   - Shutdown -> Ack
  def exercise5_statusMessages(cmd: Command): StatusMessage = ???

  // Exercise 6: Implement request-response pattern
  // TODO: Given a UserStore and a GetUser command, invoke the replyTo callback
  //   with the user if found, and return a tuple of (StatusMessage, UserStore):
  //   - User found: (Ack, store)
  //   - User not found: (Nack(s"User $id not found"), store)
  def exercise6_requestResponse(store: UserStore, cmd: GetUser): (StatusMessage, UserStore) = ???

  // Exercise 7: Fire-and-forget pattern
  // TODO: Given a UserStore and a list of DeleteUser commands,
  //   process all deletions and return the final UserStore.
  //   No responses are sent — this is fire-and-forget.
  def exercise7_fireAndForget(store: UserStore, deletes: List[DeleteUser]): UserStore = ???

  // Exercise 8: Message adaptor
  // TODO: Implement an adaptor function that converts ExternalEvent to InternalCommand:
  //   - OrderPlaced(id, amount) -> ProcessOrder(id, amount)
  //   - OrderCancelled(id) -> CancelOrder(id)
  //   Apply this adaptor to a list of ExternalEvents and return the InternalCommands.
  def exercise8_messageAdaptor(events: List[ExternalEvent]): List[InternalCommand] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (msg1a, msg1b) = exercise1_immutableMessages("Alice", 30)
    assert(msg1a.isInstanceOf[CreateUser], "Exercise 1 failed: first should be CreateUser")
    assert(msg1b == DeleteUser(0), s"Exercise 1 failed: second should be DeleteUser(0)")
    assert(msg1a.asInstanceOf[CreateUser].name == "Alice", "Exercise 1 failed: wrong name")
    println("Exercise 1 passed: immutable messages created")

    // Exercise 2
    val store0 = UserStore(Map.empty, 1)
    var reply2: Either[String, User] = Left("")
    val store1 = exercise2_replyToPattern(store0, CreateUser("Alice", r => reply2 = r))
    assert(reply2 == Right(User(1, "Alice")), s"Exercise 2 failed: reply was $reply2")
    assert(store1.users.size == 1, "Exercise 2 failed: user not added")
    var reply2b: Either[String, User] = Right(User(0, ""))
    val store1b = exercise2_replyToPattern(store1, CreateUser("Alice", r => reply2b = r))
    assert(reply2b == Left("User already exists"), s"Exercise 2 failed: duplicate not caught")
    println("Exercise 2 passed: reply-to pattern works")

    // Exercise 3
    val store3 = exercise3_messageProtocol(store1, DeleteUser(1))
    assert(store3.users.isEmpty, "Exercise 3 failed: user not deleted")
    var getReply: Option[User] = Some(User(0, ""))
    exercise3_messageProtocol(store3, GetUser(1, r => getReply = r))
    assert(getReply.isEmpty, "Exercise 3 failed: should be None for deleted user")
    println("Exercise 3 passed: message protocol works")

    // Exercise 4
    val cmds4 = List(
      CreateUser("A", _ => ()),
      CreateUser("B", _ => ()),
      Shutdown,
      CreateUser("C", _ => ())
    )
    val store4 = exercise4_poisonPill(UserStore(Map.empty, 1), cmds4)
    assert(store4.users.size == 2, s"Exercise 4 failed: expected 2 users, got ${store4.users.size}")
    println("Exercise 4 passed: PoisonPill stops processing")

    // Exercise 5
    assert(exercise5_statusMessages(CreateUser("Bob", _ => ())) == Ack, "Exercise 5 failed")
    assert(exercise5_statusMessages(CreateUser("", _ => ())) == Nack("Name cannot be empty"), "Exercise 5 failed")
    assert(exercise5_statusMessages(DeleteUser(-1)) == Nack("Invalid user id"), "Exercise 5 failed")
    assert(exercise5_statusMessages(DeleteUser(5)) == Ack, "Exercise 5 failed")
    println("Exercise 5 passed: status messages correct")

    // Exercise 6
    val store6 = UserStore(Map(1 -> User(1, "Alice")), 2)
    val (status6a, _) = exercise6_requestResponse(store6, GetUser(1, _ => ()))
    assert(status6a == Ack, "Exercise 6 failed: should Ack for existing user")
    val (status6b, _) = exercise6_requestResponse(store6, GetUser(99, _ => ()))
    assert(status6b == Nack("User 99 not found"), s"Exercise 6 failed: got $status6b")
    println("Exercise 6 passed: request-response works")

    // Exercise 7
    val store7 = UserStore(Map(1 -> User(1, "A"), 2 -> User(2, "B"), 3 -> User(3, "C")), 4)
    val result7 = exercise7_fireAndForget(store7, List(DeleteUser(1), DeleteUser(3)))
    assert(result7.users.size == 1, s"Exercise 7 failed: expected 1 user, got ${result7.users.size}")
    assert(result7.users.contains(2), "Exercise 7 failed: user 2 should remain")
    println("Exercise 7 passed: fire-and-forget deletes")

    // Exercise 8
    val events = List(
      OrderPlaced("O1", 100.0),
      OrderCancelled("O2"),
      OrderPlaced("O3", 200.0)
    )
    val cmds8 = exercise8_messageAdaptor(events)
    assert(cmds8 == List(ProcessOrder("O1", 100.0), CancelOrder("O2"), ProcessOrder("O3", 200.0)),
      s"Exercise 8 failed: got $cmds8")
    println("Exercise 8 passed: message adaptor works")

    println("\nAll Akka002_Messages exercises passed!")
  }
}
