package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.test._
import zio.test.Assertion._
import zio.test.environment._

/**
 * ZIO072 - Test Layers
 *
 * Learn how to use layers in ZIO tests for dependency injection and mocking.
 */
object Zio072_TestLayers extends DefaultRunnableSpec {

  // ---- Service definitions for exercises ----
  trait UserRepo {
    def getUser(id: Int): Task[String]
  }
  object UserRepo {
    def getUser(id: Int): ZIO[Has[UserRepo], Throwable, String] =
      ZIO.accessM(_.get.getUser(id))
  }

  trait EmailService {
    def sendEmail(to: String, body: String): Task[Unit]
  }
  object EmailService {
    def sendEmail(to: String, body: String): ZIO[Has[EmailService], Throwable, Unit] =
      ZIO.accessM(_.get.sendEmail(to, body))
  }

  // ============================================================
  // Exercise 1: Test layers - provide a live layer for test
  // TODO: Create a ZLayer that provides a UserRepo returning "Alice" for id=1.
  //       Write a testM that uses UserRepo.getUser(1) and asserts it returns "Alice".
  //       Provide the layer using .provideCustomLayer
  // ============================================================
  val exercise1 = testM("live layer for test") {
    ???
  }

  // ============================================================
  // Exercise 2: Custom test environment
  // TODO: Create a ZLayer for EmailService that records sent emails in a Ref
  //       instead of actually sending them. Write a test that sends an email
  //       and verifies the Ref contains the recorded email.
  // ============================================================
  val exercise2 = testM("custom test env") {
    ???
  }

  // ============================================================
  // Exercise 3: Layer sharing across tests
  // TODO: Create a shared layer (val) that provides a UserRepo.
  //       Write two tests in a suite that both use the same shared layer.
  //       Use .provideCustomLayerShared on the suite.
  // ============================================================
  val exercise3 = suite("layer sharing")(
    ???
  )

  // ============================================================
  // Exercise 4: Test-specific services
  // TODO: Create two different UserRepo layers: one returns "TestUser",
  //       another returns "ProdUser". Write two tests, each using a different layer.
  // ============================================================
  val exercise4 = suite("test-specific services")(
    ???
  )

  // ============================================================
  // Exercise 5: Mock service
  // TODO: Create a mock UserRepo that:
  //       - Returns "User1" for id=1
  //       - Returns "User2" for id=2
  //       - Fails with an error for any other id
  //       Write tests verifying each case.
  // ============================================================
  val exercise5 = suite("mock service")(
    ???
  )

  // ============================================================
  // Exercise 6: Test service implementation
  // TODO: Create a TestEmailService backed by a Queue[String].
  //       Write a test that sends 3 emails and verifies the queue has 3 entries.
  // ============================================================
  val exercise6 = testM("test service impl") {
    ???
  }

  // ============================================================
  // Exercise 7: Layer test isolation
  // TODO: Create a UserRepo backed by a Ref[Map[Int, String]].
  //       Write two tests in a suite where each test mutates the Ref.
  //       Verify that mutations in one test do NOT affect the other
  //       (use .provideCustomLayer on each test, not shared).
  // ============================================================
  val exercise7 = suite("layer test isolation")(
    ???
  )

  // ============================================================
  // Exercise 8: Composed test layers
  // TODO: Create a service NotificationService that depends on both
  //       UserRepo and EmailService. Build a composed test layer providing all three.
  //       Write a test that uses NotificationService.
  // ============================================================
  val exercise8 = testM("composed test layers") {
    ???
  }

  override def spec = suite("Zio072_TestLayers")(
    exercise1,
    exercise2,
    exercise3,
    exercise4,
    exercise5,
    exercise6,
    exercise7,
    exercise8
  )
}
