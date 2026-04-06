package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.data._
import cats.free.Free

/**
 * Cats 062 - Inject and InjectK
 *
 * Inject[A, B] provides injection from type A into a coproduct type B.
 * InjectK[F, G] provides injection of functor F into coproduct functor G.
 * These enable composing multiple Free monad algebras into a combined DSL
 * without manually handling EitherK boilerplate.
 */
object Cats062_Inject {

  // Exercise 1: InjectK concept - define algebras that can be injected
  // TODO: Define two algebras and use InjectK to inject into a coproduct.
  sealed trait UserOp[A]
  case class CreateUser(name: String) extends UserOp[Long]
  case class GetUser(id: Long) extends UserOp[Option[String]]

  sealed trait EmailOp[A]
  case class SendEmail(to: String, subject: String) extends EmailOp[Unit]
  case class CheckInbox(user: String) extends EmailOp[List[String]]

  type AppOp[A] = EitherK[UserOp, EmailOp, A]

  // Smart constructors using InjectK
  class Users[F[_]](implicit I: InjectK[UserOp, F]) {
    def createUser(name: String): Free[F, Long] = ???
    def getUser(id: Long): Free[F, Option[String]] = ???
  }

  object Users {
    implicit def users[F[_]](implicit I: InjectK[UserOp, F]): Users[F] = new Users[F]
  }

  // Exercise 2: InjectK for second algebra - inject EmailOp
  // TODO: Create smart constructors for EmailOp using InjectK.
  class Emails[F[_]](implicit I: InjectK[EmailOp, F]) {
    def sendEmail(to: String, subject: String): Free[F, Unit] = ???
    def checkInbox(user: String): Free[F, List[String]] = ???
  }

  object Emails {
    implicit def emails[F[_]](implicit I: InjectK[EmailOp, F]): Emails[F] = new Emails[F]
  }

  // Exercise 3: Injection into coproduct - build a program using injected algebras
  // TODO: Write a program that uses both algebras via injection.
  def exercise3_injection(): Free[AppOp, Unit] = {
    val users = Users.users[AppOp]
    val emails = Emails.emails[AppOp]

    // Create a user, then send them a welcome email
    ???
  }

  // Exercise 4: Multi-DSL composition - combine programs from multiple algebras
  // TODO: Compose a complex program using both algebras.
  def exercise4_multiDsl(): Free[AppOp, List[String]] = {
    val users = Users.users[AppOp]
    val emails = Emails.emails[AppOp]

    // Create user "Alice", send welcome email, check Alice's inbox
    ???
  }

  // Exercise 5: Inject for extensible effects - add a third algebra
  // TODO: Show how to extend the coproduct with a third algebra.
  sealed trait AuditOp[A]
  case class LogAudit(action: String) extends AuditOp[Unit]
  case object GetAuditLog extends AuditOp[List[String]]

  type EmailAuditOp[A] = EitherK[EmailOp, AuditOp, A]
  type ExtendedOp[A] = EitherK[UserOp, EmailAuditOp, A]

  class Audit[F[_]](implicit I: InjectK[AuditOp, F]) {
    def logAudit(action: String): Free[F, Unit] = Free.inject[AuditOp, F](LogAudit(action))
    def getAuditLog: Free[F, List[String]] = Free.inject[AuditOp, F](GetAuditLog)
  }

  object Audit {
    implicit def audit[F[_]](implicit I: InjectK[AuditOp, F]): Audit[F] = new Audit[F]
  }

  def exercise5_extensible(): Free[ExtendedOp, Unit] = {
    implicit val usersInj: Users[ExtendedOp] = Users.users[ExtendedOp]
    val audit = Audit.audit[ExtendedOp]

    // Create user and log the audit event
    ???
  }

  // Exercise 6: Inject laws - demonstrate injection properties
  // TODO: Verify that injection preserves identity.
  def exercise6_laws(): Boolean = {
    // InjectK law: inject then project should return the original value
    // For EitherK[UserOp, EmailOp, ?]:
    //   InjectK[UserOp, AppOp].inj(userOp).run.isLeft == true
    val userOp: UserOp[Long] = CreateUser("test")
    val injected: AppOp[Long] = EitherK.leftc[UserOp, EmailOp, Long](userOp)

    // Verify the injection preserves the value
    ???
  }

  // Exercise 7: Practical injection patterns - real-world usage
  // TODO: Build a complete program with interpretation.
  def exercise7_practicalPattern(): (Long, Option[String], Unit) = {
    val users = Users.users[AppOp]
    val emails = Emails.emails[AppOp]

    val program: Free[AppOp, (Long, Option[String], Unit)] = for {
      userId <- users.createUser("Alice")
      user <- users.getUser(userId)
      _ <- emails.sendEmail("alice@example.com", "Welcome!")
    } yield (userId, user, ())

    // Create interpreters
    val userInterpreter: UserOp ~> Id = new (UserOp ~> Id) {
      val store = scala.collection.mutable.Map.empty[Long, String]
      var nextId = 1L
      def apply[A](fa: UserOp[A]): Id[A] = fa match {
        case CreateUser(name) =>
          val id = nextId; nextId += 1; store(id) = name; id
        case GetUser(id) => store.get(id)
      }
    }

    val emailInterpreter: EmailOp ~> Id = new (EmailOp ~> Id) {
      def apply[A](fa: EmailOp[A]): Id[A] = fa match {
        case SendEmail(_, _) => ()
        case CheckInbox(_) => List.empty[String]
      }
    }

    // Combine interpreters and run
    val combined: AppOp ~> Id = ???
    program.foldMap(combined)
  }

  // Exercise 8: Inject vs explicit EitherK - compare approaches
  // TODO: Show the same program with and without Inject.
  def exercise8_comparison(): (String, String) = {
    // With Inject (clean, composable)
    val withInject: Free[AppOp, Long] = {
      val users = Users.users[AppOp]
      users.createUser("Bob")
    }

    // Without Inject (manual EitherK wrapping - verbose)
    val withoutInject: Free[AppOp, Long] = {
      Free.liftF[AppOp, Long](EitherK.leftc[UserOp, EmailOp, Long](CreateUser("Bob")))
    }

    // Both produce the same program structure
    // Return descriptions of the approaches
    ???
  }

  def main(args: Array[String]): Unit = {
    // Common interpreters for testing
    val userInterp: UserOp ~> Id = new (UserOp ~> Id) {
      val store = scala.collection.mutable.Map.empty[Long, String]
      var nextId = 1L
      def apply[A](fa: UserOp[A]): Id[A] = fa match {
        case CreateUser(name) => val id = nextId; nextId += 1; store(id) = name; id
        case GetUser(id) => store.get(id)
      }
    }

    val emailInterp: EmailOp ~> Id = new (EmailOp ~> Id) {
      var sent: List[String] = Nil
      def apply[A](fa: EmailOp[A]): Id[A] = fa match {
        case SendEmail(to, subj) => sent = sent :+ s"$to:$subj"; ()
        case CheckInbox(user) => sent.filter(_.startsWith(user))
      }
    }

    val combined: AppOp ~> Id = userInterp.or(emailInterp)

    // Exercise 1 - Users smart constructors
    val r1 = Users.users[AppOp].createUser("test").foldMap(combined)
    println(s"Exercise 1 passed: InjectK Users => userId=$r1")

    // Exercise 2 - Emails smart constructors
    Emails.emails[AppOp].sendEmail("test@test.com", "hello").foldMap(combined)
    println(s"Exercise 2 passed: InjectK Emails => sent email")

    // Exercise 3
    exercise3_injection().foldMap(combined)
    println(s"Exercise 3 passed: injection => combined program executed")

    // Exercise 4
    val r4 = exercise4_multiDsl().foldMap(combined)
    println(s"Exercise 4 passed: multi-DSL => $r4")

    // Exercise 5
    val r5 = exercise5_extensible()
    println(s"Exercise 5 passed: extensible => created extended program")

    // Exercise 6
    val r6 = exercise6_laws()
    assert(r6, s"Exercise 6 failed: injection law violated")
    println(s"Exercise 6 passed: inject laws => $r6")

    // Exercise 7
    val r7 = exercise7_practicalPattern()
    assert(r7._1 > 0, s"Exercise 7 failed: userId=${r7._1}")
    println(s"Exercise 7 passed: practical => userId=${r7._1}, user=${r7._2}")

    // Exercise 8
    val (r8a, r8b) = exercise8_comparison()
    assert(r8a.nonEmpty && r8b.nonEmpty, s"Exercise 8 failed")
    println(s"Exercise 8 passed: comparison => inject=$r8a, manual=$r8b")

    println("\nAll Cats062_Inject exercises passed!")
  }
}
