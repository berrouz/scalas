package org.shev4ik.interview.testing.level3_advanced

/**
 * Test018 - Contract Testing
 *
 * Consumer-driven contracts, Pact-like patterns, interface verification,
 * and contract testing utilities.
 */
object Test018_ContractTesting {

  // ==========================================================================
  // Exercise 1: Implement a contract definition
  // ==========================================================================
  // TODO: Implement `Contract` that defines expected interactions:
  //       case class Interaction(description: String, request: Request, expectedResponse: Response)
  //       case class Request(method: String, path: String, headers: Map[String, String], body: Option[String])
  //       case class Response(status: Int, headers: Map[String, String], body: Option[String])
  //       Implement `Contract` with:
  //       - name: String, consumer: String, provider: String
  //       - addInteraction(interaction: Interaction): Contract
  //       - interactions: List[Interaction]
  //       - toJson(): String  (simple JSON-like string representation)
  case class Request(method: String, path: String, headers: Map[String, String], body: Option[String])
  case class Response(status: Int, headers: Map[String, String], body: Option[String])
  case class Interaction(description: String, request: Request, expectedResponse: Response)

  class Contract(val name: String, val consumer: String, val provider: String) {
    def addInteraction(interaction: Interaction): Contract = ???
    def interactions: List[Interaction] = ???
    def toJson(): String = ???
  }

  // ==========================================================================
  // Exercise 2: Implement a contract verifier
  // ==========================================================================
  // TODO: Implement `ContractVerifier` that verifies a provider against a contract:
  //       - verify(contract: Contract, provider: Request => Response): VerificationResult
  //       VerificationResult:
  //       - passed: Boolean
  //       - results: List[(Interaction, Boolean, Option[String])]
  //         (interaction, passed, error message if failed)
  //       Verification checks: status code matches, required headers present,
  //       body matches (if specified in contract).
  case class VerificationResult(
    passed: Boolean,
    results: List[(Interaction, Boolean, Option[String])]
  )

  def verifyContract(contract: Contract, provider: Request => Response): VerificationResult = ???

  // ==========================================================================
  // Exercise 3: Implement a consumer contract builder (Pact-style)
  // ==========================================================================
  // TODO: Implement a fluent builder for creating contracts:
  //       ConsumerContractBuilder
  //       - consumer(name: String): ConsumerContractBuilder
  //       - hasPactWith(provider: String): ConsumerContractBuilder
  //       - given_(providerState: String): ConsumerContractBuilder
  //       - uponReceiving(description: String): ConsumerContractBuilder
  //       - withRequest(method: String, path: String): ConsumerContractBuilder
  //       - withRequestHeader(key: String, value: String): ConsumerContractBuilder
  //       - withRequestBody(body: String): ConsumerContractBuilder
  //       - willRespondWith(status: Int): ConsumerContractBuilder
  //       - withResponseHeader(key: String, value: String): ConsumerContractBuilder
  //       - withResponseBody(body: String): ConsumerContractBuilder
  //       - build(): Contract
  class ConsumerContractBuilder {
    def consumer(name: String): ConsumerContractBuilder = ???
    def hasPactWith(provider: String): ConsumerContractBuilder = ???
    def given_(providerState: String): ConsumerContractBuilder = ???
    def uponReceiving(description: String): ConsumerContractBuilder = ???
    def withRequest(method: String, path: String): ConsumerContractBuilder = ???
    def withRequestHeader(key: String, value: String): ConsumerContractBuilder = ???
    def withRequestBody(body: String): ConsumerContractBuilder = ???
    def willRespondWith(status: Int): ConsumerContractBuilder = ???
    def withResponseHeader(key: String, value: String): ConsumerContractBuilder = ???
    def withResponseBody(body: String): ConsumerContractBuilder = ???
    def build(): Contract = ???
  }

  // ==========================================================================
  // Exercise 4: Implement schema/structure matching
  // ==========================================================================
  // TODO: Implement `StructureMatcher` that verifies response structure
  //       without exact value matching (like Pact matchers):
  //       - matchType(value: Any, expectedType: String): Boolean
  //         (checks "string", "number", "boolean", "array", "object")
  //       - matchRegex(value: String, pattern: String): Boolean
  //       - matchMinLength(value: String, min: Int): Boolean
  //       - matchStructure(actual: Map[String, Any], expected: Map[String, String]): MatchResult
  //         expected maps field names to type strings.
  //         MatchResult: matched (Boolean), mismatches (List[String])
  case class MatchResult(matched: Boolean, mismatches: List[String])

  object StructureMatcher {
    def matchType(value: Any, expectedType: String): Boolean = ???
    def matchRegex(value: String, pattern: String): Boolean = ???
    def matchMinLength(value: String, min: Int): Boolean = ???
    def matchStructure(actual: Map[String, Any], expected: Map[String, String]): MatchResult = ???
  }

  // ==========================================================================
  // Exercise 5: Implement a contract broker (simplified)
  // ==========================================================================
  // TODO: Implement `ContractBroker` that stores and retrieves contracts:
  //       - publish(contract: Contract): Unit
  //       - findByConsumer(consumer: String): List[Contract]
  //       - findByProvider(provider: String): List[Contract]
  //       - findByPair(consumer: String, provider: String): Option[Contract]
  //       - latestContracts(): Map[String, Contract]  (keyed by "consumer-provider")
  //       - canDeploy(service: String, verificationResults: Map[String, Boolean]): Boolean
  //         (service can deploy if all its contracts pass verification)
  class ContractBroker {
    def publish(contract: Contract): Unit = ???
    def findByConsumer(consumer: String): List[Contract] = ???
    def findByProvider(provider: String): List[Contract] = ???
    def findByPair(consumer: String, provider: String): Option[Contract] = ???
    def latestContracts(): Map[String, Contract] = ???
    def canDeploy(service: String, verificationResults: Map[String, Boolean]): Boolean = ???
  }

  // ==========================================================================
  // Exercise 6: Implement a backward compatibility checker
  // ==========================================================================
  // TODO: Implement `CompatibilityChecker` that checks if a new version of
  //       a contract is backward compatible with the old one:
  //       - checkCompatibility(old: Contract, new_ : Contract): CompatibilityResult
  //       Rules:
  //       - New contract must support all old interactions (can add new ones)
  //       - Response status codes must match for matching requests
  //       - New response can have additional headers but must include old ones
  //       - Response body must be a superset of old (new fields OK, missing fields not)
  case class CompatibilityResult(
    compatible: Boolean,
    breakingChanges: List[String],
    addedInteractions: List[String],
    removedInteractions: List[String]
  )

  def checkCompatibility(old: Contract, new_ : Contract): CompatibilityResult = ???

  // ==========================================================================
  // Exercise 7: Implement an interface contract (trait-level contract)
  // ==========================================================================
  // TODO: Implement `InterfaceContract[A]` that defines behavioral contracts:
  //       - addPrecondition(name: String, check: A => Boolean): InterfaceContract[A]
  //       - addPostcondition[B](name: String, check: (A, B) => Boolean): InterfaceContract[A]
  //       - addInvariant(name: String, check: A => Boolean): InterfaceContract[A]
  //       - verify(instance: A, operation: A => Any): ContractCheckResult
  //         (checks preconditions before, postconditions after, invariants before and after)
  //       ContractCheckResult: passed, failedChecks (List[String])
  case class ContractCheckResult(passed: Boolean, failedChecks: List[String])

  class InterfaceContract[A] {
    def addPrecondition(name: String, check: A => Boolean): InterfaceContract[A] = ???
    def addPostcondition(name: String, check: A => Boolean): InterfaceContract[A] = ???
    def addInvariant(name: String, check: A => Boolean): InterfaceContract[A] = ???
    def verify(instance: A, operation: A => Any): ContractCheckResult = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a contract test generator
  // ==========================================================================
  // TODO: Implement `ContractTestGenerator` that generates test cases from contracts:
  //       - fromContract(contract: Contract): List[GeneratedTest]
  //       GeneratedTest: name (String), execute (Request => Response) => Boolean
  //       Each interaction becomes a test that sends the request and validates
  //       the response matches the expected response.
  //       Also generate negative tests:
  //       - generateNegativeTests(contract: Contract): List[GeneratedTest]
  //         (tests with malformed requests, missing headers, wrong methods)
  case class GeneratedTest(name: String, execute: (Request => Response) => Boolean)

  def fromContract(contract: Contract): List[GeneratedTest] = ???
  def generateNegativeTests(contract: Contract): List[GeneratedTest] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val contract = new Contract("user-api", "frontend", "user-service")
      .addInteraction(Interaction(
        "get user",
        Request("GET", "/users/1", Map.empty, None),
        Response(200, Map("Content-Type" -> "application/json"), Some("""{"id":1,"name":"Alice"}"""))
      ))
    assert(contract.interactions.length == 1)
    assert(contract.toJson().nonEmpty)
    println("Exercise 1 passed: contract definition works")

    // Exercise 2
    val provider: Request => Response = req => req.path match {
      case "/users/1" => Response(200, Map("Content-Type" -> "application/json"), Some("""{"id":1,"name":"Alice"}"""))
      case _ => Response(404, Map.empty, None)
    }
    val verification = verifyContract(contract, provider)
    assert(verification.passed)
    println("Exercise 2 passed: contract verification works")

    // Exercise 3
    val builtContract = new ConsumerContractBuilder()
      .consumer("web-app")
      .hasPactWith("api")
      .uponReceiving("a request for items")
      .withRequest("GET", "/items")
      .willRespondWith(200)
      .withResponseBody("""[{"id":1}]""")
      .build()
    assert(builtContract.consumer == "web-app")
    assert(builtContract.provider == "api")
    assert(builtContract.interactions.nonEmpty)
    println("Exercise 3 passed: consumer contract builder works")

    // Exercise 4
    assert(StructureMatcher.matchType("hello", "string"))
    assert(StructureMatcher.matchType(42, "number"))
    assert(StructureMatcher.matchType(true, "boolean"))
    assert(StructureMatcher.matchRegex("abc123", "[a-z]+\\d+"))
    val structResult = StructureMatcher.matchStructure(
      Map("name" -> "Alice", "age" -> 30),
      Map("name" -> "string", "age" -> "number")
    )
    assert(structResult.matched)
    println("Exercise 4 passed: structure matching works")

    // Exercise 5
    val broker = new ContractBroker
    broker.publish(contract)
    assert(broker.findByConsumer("frontend").length == 1)
    assert(broker.findByProvider("user-service").length == 1)
    assert(broker.findByPair("frontend", "user-service").isDefined)
    assert(broker.canDeploy("user-service", Map("frontend-user-service" -> true)))
    println("Exercise 5 passed: contract broker works")

    // Exercise 6
    val newContract = new Contract("user-api", "frontend", "user-service")
      .addInteraction(Interaction(
        "get user",
        Request("GET", "/users/1", Map.empty, None),
        Response(200, Map("Content-Type" -> "application/json"), Some("""{"id":1,"name":"Alice"}"""))
      ))
      .addInteraction(Interaction(
        "list users",
        Request("GET", "/users", Map.empty, None),
        Response(200, Map.empty, Some("[]"))
      ))
    val compat = checkCompatibility(contract, newContract)
    assert(compat.compatible)
    assert(compat.addedInteractions.length == 1)
    println("Exercise 6 passed: compatibility checking works")

    // Exercise 7
    case class Account(balance: Double, active: Boolean)
    val accountContract = new InterfaceContract[Account]
      .addPrecondition("positive balance", _.balance >= 0)
      .addInvariant("is active", _.active)
    val checkResult = accountContract.verify(
      Account(100, true),
      acc => acc.copy(balance = acc.balance - 50)
    )
    assert(checkResult.passed)
    println("Exercise 7 passed: interface contracts work")

    // Exercise 8
    val tests = fromContract(contract)
    assert(tests.nonEmpty)
    assert(tests.head.execute(provider))
    val negTests = generateNegativeTests(contract)
    assert(negTests.nonEmpty)
    println("Exercise 8 passed: contract test generation works")

    println("\nAll Test018 exercises passed!")
  }
}
