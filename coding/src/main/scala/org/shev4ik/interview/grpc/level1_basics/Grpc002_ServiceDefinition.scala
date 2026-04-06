package org.shev4ik.interview.grpc.level1_basics

/**
 * gRPC 002 - Service Definition with Protocol Buffers
 *
 * =Overview=
 * gRPC is a high-performance, open-source RPC framework originally developed by Google.
 * It uses '''Protocol Buffers (protobuf)''' as its Interface Definition Language (IDL) and
 * serialization format, and '''HTTP/2''' as its transport protocol.
 *
 * =Protocol Buffers (.proto files)=
 * Services and messages are defined in `.proto` files using proto3 syntax:
 * {{{
 *   syntax = "proto3";
 *   package com.example.user;
 *
 *   service UserService {
 *     rpc GetUser(GetUserRequest) returns (GetUserResponse);         // Unary
 *     rpc ListUsers(ListUsersRequest) returns (stream User);         // Server streaming
 *     rpc CreateUsers(stream User) returns (CreateUsersResponse);    // Client streaming
 *     rpc Chat(stream ChatMessage) returns (stream ChatMessage);     // Bidirectional
 *   }
 *
 *   message GetUserRequest { int32 id = 1; }
 *   message GetUserResponse { User user = 1; }
 *   message User { int32 id = 1; string name = 2; string email = 3; }
 * }}}
 *
 * =Four RPC Types=
 *  - '''Unary''': Single request, single response. Like a normal function call. Most common.
 *  - '''Server streaming''': Client sends one request, server returns a stream of responses.
 *    Use case: real-time feeds, large result sets, subscriptions.
 *  - '''Client streaming''': Client sends a stream of requests, server returns one response.
 *    Use case: file upload, batch ingestion, aggregation.
 *  - '''Bidirectional streaming''': Both client and server send streams simultaneously.
 *    Use case: chat, multiplayer games, collaborative editing.
 *
 * =HTTP/2 Transport=
 * gRPC uses HTTP/2 which provides:
 *  - '''Multiplexing''': Multiple RPC calls over a single TCP connection
 *  - '''Header compression''': HPACK reduces overhead for metadata-heavy calls
 *  - '''Bidirectional streaming''': Native support for server push and client streaming
 *  - '''Flow control''': Per-stream and per-connection flow control
 *
 * =Serialization: Protobuf vs JSON=
 *  - Protobuf is a '''binary format''' -- 3-10x smaller and faster than JSON
 *  - Schema-first: `.proto` files generate type-safe client and server code
 *  - Backward/forward compatible: field numbers enable safe schema evolution
 *  - Trade-off: Not human-readable (use grpcurl or Postman for debugging)
 *
 * =Scala gRPC Libraries=
 *  - '''ScalaPB''': Protobuf compiler plugin for Scala, generates case classes from `.proto`
 *  - '''fs2-grpc''': gRPC integration with FS2 and Cats Effect (streaming with backpressure)
 *  - '''zio-grpc''': gRPC integration with ZIO (ZStream for streaming RPCs)
 *  - '''Akka gRPC''': gRPC integration with Akka Streams
 *
 * =Real-World Usage=
 * gRPC is the standard for '''internal service-to-service communication''' in microservice
 * architectures. It excels when you need: strong typing, efficient serialization, streaming,
 * and polyglot support (Java, Scala, Go, Python clients from the same `.proto`).
 * For external/public APIs, REST/JSON is still preferred due to browser support and tooling.
 *
 * =Interview Tip=
 * ''"REST vs gRPC -- when would you choose each?"''
 *
 * '''Answer:''' gRPC is better for '''internal service-to-service communication''' because it
 * offers: (1) schema-first design with code generation, (2) efficient binary serialization
 * (protobuf is 3-10x smaller/faster than JSON), (3) native streaming support (server, client,
 * and bidirectional), (4) strong typing across languages from a single `.proto` definition.
 * REST/JSON is better for '''external/public APIs''' because: (1) browsers natively support
 * HTTP/1.1 + JSON, (2) tooling is more mature (Swagger/OpenAPI, curl), (3) human-readable
 * payloads simplify debugging. Many teams use gRPC internally with a REST gateway (like
 * grpc-gateway or Envoy) for external clients.
 */
object Grpc002_ServiceDefinition {

  // --- Domain models for exercises ---

  sealed trait RpcType
  object RpcType {
    case object Unary                  extends RpcType
    case object ServerStreaming         extends RpcType
    case object ClientStreaming         extends RpcType
    case object BidirectionalStreaming  extends RpcType
  }

  case class MessageType(name: String)

  case class RpcMethod(
    name: String,
    rpcType: RpcType,
    inputType: MessageType,
    outputType: MessageType
  )

  case class ServiceDescriptor(
    name: String,
    methods: List[RpcMethod]
  )

  case class ProtoFile(
    syntax: String,         // "proto3"
    packageName: String,
    services: List[ServiceDescriptor],
    messages: List[MessageType]
  )

  // Exercise 1: Define a unary RPC method
  // TODO: Create an RpcMethod named "GetUser" that takes a "GetUserRequest"
  //   and returns a "GetUserResponse". It should be a Unary RPC.
  def exercise1_defineUnaryMethod: RpcMethod = ???

  // Exercise 2: Define a complete service descriptor
  // TODO: Create a ServiceDescriptor named "UserService" with three methods:
  //   - "GetUser": Unary, GetUserRequest -> GetUserResponse
  //   - "ListUsers": ServerStreaming, ListUsersRequest -> User
  //   - "CreateUsers": ClientStreaming, User -> CreateUsersResponse
  def exercise2_defineUserService: ServiceDescriptor = ???

  // Exercise 3: Determine RPC type from streaming flags
  // TODO: Given two booleans (clientStreaming, serverStreaming), return the RpcType:
  //   (false, false) -> Unary
  //   (false, true)  -> ServerStreaming
  //   (true, false)  -> ClientStreaming
  //   (true, true)   -> BidirectionalStreaming
  def exercise3_rpcTypeFromFlags(clientStreaming: Boolean, serverStreaming: Boolean): RpcType = ???

  // Exercise 4: Extract all unique message types from a service
  // TODO: Given a ServiceDescriptor, return a sorted List[String] of all unique
  //   message type names used as inputs or outputs across all methods.
  def exercise4_extractMessageTypes(service: ServiceDescriptor): List[String] = ???

  // Exercise 5: Build a proto file descriptor
  // TODO: Create a ProtoFile with:
  //   syntax = "proto3"
  //   packageName = "com.example.user"
  //   services = List containing the UserService from exercise 2
  //   messages = List of all unique MessageTypes extracted from that service
  //   (Hint: use exercise4 to get the names, map to MessageType)
  def exercise5_buildProtoFile(service: ServiceDescriptor): ProtoFile = ???

  // Exercise 6: Count methods by RPC type
  // TODO: Given a ServiceDescriptor, return a Map[RpcType, Int] showing
  //   how many methods exist for each RPC type. Only include types with count > 0.
  def exercise6_countByRpcType(service: ServiceDescriptor): Map[RpcType, Int] = ???

  // Exercise 7: Validate service descriptor
  // TODO: A valid service must:
  //   - Have a non-empty name
  //   - Have at least one method
  //   - All method names must be unique
  //   - All method names must be non-empty
  //   Return true if valid, false otherwise.
  def exercise7_validateService(service: ServiceDescriptor): Boolean = ???

  // Exercise 8: Generate method signature string
  // TODO: Given an RpcMethod, return a string representing the method signature.
  //   Format: "rpc MethodName(stream? InputType) returns (stream? OutputType)"
  //   For Unary: "rpc GetUser(GetUserRequest) returns (GetUserResponse)"
  //   For ServerStreaming: "rpc ListUsers(ListUsersRequest) returns (stream User)"
  //   For ClientStreaming: "rpc CreateUsers(stream User) returns (CreateUsersResponse)"
  //   For Bidirectional: "rpc Chat(stream ChatMessage) returns (stream ChatMessage)"
  //   "stream " prefix (with trailing space) is added before the type when streaming.
  def exercise8_methodSignature(method: RpcMethod): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val getUser = exercise1_defineUnaryMethod
    assert(getUser.name == "GetUser", "Exercise 1 failed: wrong name")
    assert(getUser.rpcType == RpcType.Unary, "Exercise 1 failed: wrong type")
    assert(getUser.inputType.name == "GetUserRequest", "Exercise 1 failed: wrong input")
    assert(getUser.outputType.name == "GetUserResponse", "Exercise 1 failed: wrong output")
    println("Exercise 1 passed: unary RPC method defined")

    // Exercise 2
    val userService = exercise2_defineUserService
    assert(userService.name == "UserService", "Exercise 2 failed: wrong service name")
    assert(userService.methods.length == 3, "Exercise 2 failed: wrong method count")
    assert(userService.methods.head.rpcType == RpcType.Unary, "Exercise 2 failed: first method not unary")
    assert(userService.methods(1).rpcType == RpcType.ServerStreaming, "Exercise 2 failed: second method")
    assert(userService.methods(2).rpcType == RpcType.ClientStreaming, "Exercise 2 failed: third method")
    println("Exercise 2 passed: UserService defined")

    // Exercise 3
    assert(exercise3_rpcTypeFromFlags(false, false) == RpcType.Unary, "Exercise 3 failed: unary")
    assert(exercise3_rpcTypeFromFlags(false, true) == RpcType.ServerStreaming, "Exercise 3 failed: server")
    assert(exercise3_rpcTypeFromFlags(true, false) == RpcType.ClientStreaming, "Exercise 3 failed: client")
    assert(exercise3_rpcTypeFromFlags(true, true) == RpcType.BidirectionalStreaming, "Exercise 3 failed: bidi")
    println("Exercise 3 passed: RPC type from flags")

    // Exercise 4
    val msgTypes = exercise4_extractMessageTypes(userService)
    assert(msgTypes == List("CreateUsersResponse", "GetUserRequest", "GetUserResponse", "ListUsersRequest", "User"),
      "Exercise 4 failed: " + msgTypes)
    println("Exercise 4 passed: message types extracted")

    // Exercise 5
    val proto = exercise5_buildProtoFile(userService)
    assert(proto.syntax == "proto3", "Exercise 5 failed: wrong syntax")
    assert(proto.packageName == "com.example.user", "Exercise 5 failed: wrong package")
    assert(proto.services.length == 1, "Exercise 5 failed: wrong service count")
    assert(proto.messages.length == 5, "Exercise 5 failed: wrong message count")
    println("Exercise 5 passed: proto file built")

    // Exercise 6
    val counts = exercise6_countByRpcType(userService)
    assert(counts(RpcType.Unary) == 1, "Exercise 6 failed: unary count")
    assert(counts(RpcType.ServerStreaming) == 1, "Exercise 6 failed: server streaming count")
    assert(counts(RpcType.ClientStreaming) == 1, "Exercise 6 failed: client streaming count")
    assert(!counts.contains(RpcType.BidirectionalStreaming), "Exercise 6 failed: should not contain bidi")
    println("Exercise 6 passed: method counts correct")

    // Exercise 7
    assert(exercise7_validateService(userService), "Exercise 7 failed: valid service rejected")
    assert(!exercise7_validateService(ServiceDescriptor("", List.empty)), "Exercise 7 failed: empty name")
    assert(!exercise7_validateService(ServiceDescriptor("S", List.empty)), "Exercise 7 failed: no methods")
    val dupService = ServiceDescriptor("S", List(
      RpcMethod("Do", RpcType.Unary, MessageType("A"), MessageType("B")),
      RpcMethod("Do", RpcType.Unary, MessageType("C"), MessageType("D"))
    ))
    assert(!exercise7_validateService(dupService), "Exercise 7 failed: duplicate methods")
    println("Exercise 7 passed: service validation correct")

    // Exercise 8
    assert(exercise8_methodSignature(getUser) == "rpc GetUser(GetUserRequest) returns (GetUserResponse)",
      "Exercise 8 failed: unary sig")
    val listMethod = userService.methods(1)
    assert(exercise8_methodSignature(listMethod) == "rpc ListUsers(ListUsersRequest) returns (stream User)",
      "Exercise 8 failed: server streaming sig")
    val createMethod = userService.methods(2)
    assert(exercise8_methodSignature(createMethod) == "rpc CreateUsers(stream User) returns (CreateUsersResponse)",
      "Exercise 8 failed: client streaming sig")
    println("Exercise 8 passed: method signatures generated")

    println("\nAll Grpc002_ServiceDefinition exercises passed!")
  }
}
