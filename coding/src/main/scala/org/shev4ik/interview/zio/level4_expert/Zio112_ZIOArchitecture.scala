package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._

/**
 * ZIO112 - ZIO Architecture Patterns
 *
 * Learn how to structure ZIO applications with hexagonal, clean, and onion architectures.
 */
object Zio112_ZIOArchitecture extends App {

  // ============================================================
  // Exercise 1: Hexagonal architecture with ZIO
  // TODO: Define ports (traits) and adapters (implementations) for a UserService:
  //       Port: UserRepository trait (domain)
  //       Adapter: InMemoryUserRepository (infrastructure)
  //       Wire them with ZLayer. Print a usage example.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Clean architecture with ZIO
  // TODO: Define layers matching clean architecture:
  //       - Entity layer (domain models)
  //       - Use case layer (business logic as ZIO service)
  //       - Interface adapter layer (ZLayer implementations)
  //       Wire and run a use case. Print the result.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Onion architecture with ZIO
  // TODO: Build concentric layers:
  //       Core: pure domain types and validation
  //       Domain services: business logic (ZIO)
  //       Application services: orchestration (ZIO)
  //       Infrastructure: implementations (ZLayer)
  //       Print the layer composition.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Domain layer
  // TODO: Define a pure domain layer with:
  //       - Value objects (Email, Money)
  //       - Domain entities (User, Order)
  //       - Domain services as traits
  //       All as pure ZIO types. Print domain object examples.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Application layer
  // TODO: Define an application service that orchestrates domain services:
  //       CreateOrderUseCase that calls UserService, ProductService, OrderService.
  //       Define the service trait and accessor methods. Print the orchestration.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Infrastructure layer
  // TODO: Implement infrastructure adapters:
  //       - InMemoryUserRepo (Ref[Map])
  //       - InMemoryProductRepo (Ref[Map])
  //       Provide them as ZLayers. Print implementation details.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Layer wiring
  // TODO: Wire all layers together:
  //       InfraLayer >>> DomainServiceLayer >>> ApplicationServiceLayer
  //       Show the full layer composition. Run an end-to-end use case.
  //       Print the wiring and result.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Architecture testing
  // TODO: Show how the architecture enables testing:
  //       Swap infrastructure layer with test doubles.
  //       Run the same use case with production and test layers.
  //       Print results from both configurations.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
