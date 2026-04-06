package org.shev4ik.interview.scala_core.level3_advanced

object Core073_PhantomTypes {

  // Phantom type markers - these types are never instantiated
  sealed trait Locked
  sealed trait Unlocked
  sealed trait Open
  sealed trait Closed

  // Exercise 1: Phantom type parameter
  // TODO: Define a Door class with a phantom type parameter S representing state
  //       The door should hold a label: String
  //       The phantom type S is never used in the class body - it exists only at type level
  class Door[S] private (val label: String) {
    override def toString: String = s"Door($label)"
  }

  object Door {
    // TODO: Create a factory method that produces a Door in Locked state
    def locked(label: String): Door[Locked] = ???
  }

  // Exercise 2: State machine with phantoms
  // TODO: Implement `unlock` that takes a Door[Locked] and returns Door[Unlocked]
  def unlock(door: Door[Locked]): Door[Unlocked] = ???

  // TODO: Implement `lock` that takes a Door[Unlocked] and returns Door[Locked]
  def lock(door: Door[Unlocked]): Door[Locked] = ???

  // Exercise 3: Locked/unlocked door operations
  // TODO: Implement `open` that only works on Door[Unlocked] => Door[Open]
  def open(door: Door[Unlocked]): Door[Open] = ???

  // TODO: Implement `close` that only works on Door[Open] => Door[Closed]
  def close(door: Door[Open]): Door[Closed] = ???

  // Exercise 4: Builder with phantoms
  sealed trait HasName
  sealed trait HasAge
  sealed trait Empty

  // TODO: Define a PersonBuilder with phantom type parameter tracking which fields are set
  //       It should have name: Option[String] and age: Option[Int]
  class PersonBuilder[HasN, HasA] private (val name: Option[String], val age: Option[Int])

  object PersonBuilder {
    def apply(): PersonBuilder[Empty, Empty] = ???
  }

  // TODO: Implement `withName` that transitions HasN from Empty to HasName
  def withName(builder: PersonBuilder[Empty, _], name: String): PersonBuilder[HasName, Empty] = ???

  // Exercise 5: Type-safe state transitions
  // TODO: Define a Workflow with states: Draft -> Review -> Approved -> Published
  sealed trait Draft
  sealed trait Review
  sealed trait Approved
  sealed trait Published

  case class Document[S](title: String, content: String)

  // TODO: Implement submit: Draft -> Review
  def submit(doc: Document[Draft]): Document[Review] = ???

  // TODO: Implement approve: Review -> Approved
  def approve(doc: Document[Review]): Document[Approved] = ???

  // TODO: Implement publish: Approved -> Published
  def publish(doc: Document[Approved]): Document[Published] = ???

  // Exercise 6: Phantom evidence
  // TODO: Define an implicit evidence type that proves two phantom types are "compatible"
  //       For example, Unlocked is compatible with Open (you can open an unlocked door)
  @annotation.implicitNotFound("State ${A} is not compatible with ${B}")
  trait Compatible[A, B]

  object Compatible {
    implicit val unlockedOpen: Compatible[Unlocked, Open] = new Compatible[Unlocked, Open] {}
    implicit val openClosed: Compatible[Open, Closed] = new Compatible[Open, Closed] {}
  }

  // TODO: Define a method `transition` that only works when Compatible evidence exists
  def transition[A, B](door: Door[A])(implicit ev: Compatible[A, B]): Door[B] = ???

  // Exercise 7: Compile-time checks
  // TODO: Define a Permission system where certain operations require certain permissions
  sealed trait ReadPerm
  sealed trait WritePerm
  sealed trait AdminPerm

  case class Token[P](user: String)

  // TODO: Implement readData that requires ReadPerm
  def readData(token: Token[ReadPerm]): String = ???

  // TODO: Implement writeData that requires WritePerm
  def writeData(token: Token[WritePerm], data: String): String = ???

  // Exercise 8: Phantom type erasure
  // TODO: Demonstrate that phantom types are erased at runtime by implementing
  //       a method `sameAtRuntime` that shows two Door[X] and Door[Y] have the same runtime class
  def sameAtRuntime[A, B](doorA: Door[A], doorB: Door[B]): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val lockedDoor = Door.locked("front")
    assert(lockedDoor.label == "front")

    // Exercise 2
    val unlockedDoor = unlock(lockedDoor)
    assert(unlockedDoor.label == "front")
    val relockedDoor = lock(unlockedDoor)
    assert(relockedDoor.label == "front")

    // Exercise 3
    val openDoor = open(unlock(Door.locked("back")))
    assert(openDoor.label == "back")
    val closedDoor = close(openDoor)
    assert(closedDoor.label == "back")

    // Exercise 4
    val builder = PersonBuilder()
    val withN = withName(builder, "Alice")
    assert(withN.name.contains("Alice"))

    // Exercise 5
    val draft = Document[Draft]("Title", "Content")
    val reviewed = submit(draft)
    val approved = approve(reviewed)
    val published = publish(approved)
    assert(published.title == "Title")

    // Exercise 6
    val d = unlock(Door.locked("test"))
    val opened: Door[Open] = transition[Unlocked, Open](d)
    assert(opened.label == "test")

    // Exercise 7
    val readToken = Token[ReadPerm]("alice")
    assert(readData(readToken) == "data")
    val writeToken = Token[WritePerm]("bob")
    assert(writeData(writeToken, "new") == "written: new")

    // Exercise 8
    assert(sameAtRuntime(Door.locked("a"), unlock(Door.locked("b"))))

    println("All Core073_PhantomTypes exercises passed!")
  }
}
