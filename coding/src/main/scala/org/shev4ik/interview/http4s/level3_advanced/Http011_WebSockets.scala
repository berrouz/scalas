package org.shev4ik.interview.http4s.level3_advanced

/**
 * Http4s 011 - WebSockets
 *
 * WebSocket connections for bidirectional communication. Key concepts:
 *   - WebSocket upgrade from HTTP
 *   - Frame types: Text, Binary, Ping, Pong, Close
 *   - Connection lifecycle: handshake -> open -> messages -> close
 *   - Message handling and routing
 *   - Ping/pong for keep-alive
 *   - Close handshake with status codes
 */
object Http011_WebSockets {

  // --- Domain models ---

  sealed trait WebSocketFrame
  object WebSocketFrame {
    case class Text(data: String)            extends WebSocketFrame
    case class Binary(data: Array[Byte])     extends WebSocketFrame
    case object Ping                         extends WebSocketFrame
    case object Pong                         extends WebSocketFrame
    case class Close(code: Int, reason: String) extends WebSocketFrame
  }

  sealed trait ConnectionState
  object ConnectionState {
    case object Connecting extends ConnectionState
    case object Open       extends ConnectionState
    case object Closing    extends ConnectionState
    case object Closed     extends ConnectionState
  }

  case class WebSocketConnection(
    id: String,
    state: ConnectionState,
    sentFrames: List[WebSocketFrame],
    receivedFrames: List[WebSocketFrame]
  )

  case class UpgradeRequest(
    path: String,
    headers: Map[String, String]
  )

  sealed trait UpgradeResult
  object UpgradeResult {
    case class Accepted(connectionId: String, protocol: Option[String]) extends UpgradeResult
    case class Rejected(statusCode: Int, reason: String)               extends UpgradeResult
  }

  // Close codes
  object CloseCode {
    val Normal: Int         = 1000
    val GoingAway: Int      = 1001
    val ProtocolError: Int  = 1002
    val Unsupported: Int    = 1003
    val AbnormalClose: Int  = 1006
    val InvalidData: Int    = 1007
    val PolicyViolation: Int = 1008
  }

  // Exercise 1: Validate a WebSocket upgrade request
  // TODO: An upgrade request is valid if:
  //   - headers contain "Upgrade" -> "websocket" (case-insensitive value)
  //   - headers contain "Connection" -> "Upgrade" (case-insensitive value)
  //   - headers contain "Sec-WebSocket-Version" -> "13"
  //   Return true if all conditions are met.
  def exercise1_validateUpgrade(request: UpgradeRequest): Boolean = ???

  // Exercise 2: Process a WebSocket upgrade
  // TODO: Given an UpgradeRequest and a generateId function:
  //   - If valid (exercise1 logic), return UpgradeResult.Accepted(generateId(), protocol)
  //     where protocol = headers.get("Sec-WebSocket-Protocol")
  //   - If invalid, return UpgradeResult.Rejected(400, "Invalid WebSocket upgrade request")
  def exercise2_processUpgrade(
    request: UpgradeRequest,
    generateId: () => String
  ): UpgradeResult = ???

  // Exercise 3: Handle an incoming WebSocket frame
  // TODO: Given a WebSocketConnection and an incoming frame, update the connection:
  //   - Text/Binary: add to receivedFrames, state stays Open
  //   - Ping: add to receivedFrames, add Pong to sentFrames (auto-respond)
  //   - Pong: add to receivedFrames only
  //   - Close: add to receivedFrames, add a Close(same code, "") to sentFrames,
  //            set state to Closing
  //   If state is not Open, return the connection unchanged.
  def exercise3_handleFrame(
    conn: WebSocketConnection,
    frame: WebSocketFrame
  ): WebSocketConnection = ???

  // Exercise 4: Send a text message
  // TODO: Given a WebSocketConnection and a text message, add a Text frame
  //   to sentFrames. Only send if state is Open.
  //   Return the updated connection.
  def exercise4_sendText(conn: WebSocketConnection, message: String): WebSocketConnection = ???

  // Exercise 5: Implement a message router for WebSocket text frames
  // TODO: Given a Map of "command" -> handler function (String => String),
  //   parse incoming text frames as "command:payload" and route to the handler.
  //   Return the handler's response as a Text frame, or
  //   Text("unknown command: <command>") if no handler matches.
  //   If the text doesn't contain ":", treat the whole text as command with empty payload.
  def exercise5_routeMessage(
    handlers: Map[String, String => String],
    frame: WebSocketFrame.Text
  ): WebSocketFrame.Text = ???

  // Exercise 6: Initiate a graceful close
  // TODO: Given a WebSocketConnection, initiate closing:
  //   - Add Close(CloseCode.Normal, "goodbye") to sentFrames
  //   - Set state to Closing
  //   Only if current state is Open. Otherwise return unchanged.
  def exercise6_initiateClose(conn: WebSocketConnection): WebSocketConnection = ???

  // Exercise 7: Compute WebSocket connection statistics
  // TODO: Given a WebSocketConnection, return a Map with:
  //   "text_sent" -> count of Text frames in sentFrames
  //   "text_received" -> count of Text frames in receivedFrames
  //   "pings_received" -> count of Ping frames in receivedFrames
  //   "pongs_sent" -> count of Pong frames in sentFrames
  //   "total_sent" -> total sentFrames count
  //   "total_received" -> total receivedFrames count
  def exercise7_connectionStats(conn: WebSocketConnection): Map[String, Int] = ???

  // Exercise 8: Implement a broadcast to multiple connections
  // TODO: Given a list of WebSocketConnections and a text message,
  //   send the message to all connections that are in Open state.
  //   Return the list of updated connections (open ones with message sent,
  //   non-open ones unchanged).
  def exercise8_broadcast(
    connections: List[WebSocketConnection],
    message: String
  ): List[WebSocketConnection] = ???

  def main(args: Array[String]): Unit = {
    import WebSocketFrame._, ConnectionState._

    // Exercise 1
    val validHeaders = Map(
      "Upgrade" -> "websocket",
      "Connection" -> "Upgrade",
      "Sec-WebSocket-Version" -> "13"
    )
    assert(exercise1_validateUpgrade(UpgradeRequest("/ws", validHeaders)), "Exercise 1 failed: valid request")
    assert(!exercise1_validateUpgrade(UpgradeRequest("/ws", Map("Upgrade" -> "websocket"))), "Exercise 1 failed: incomplete")
    assert(exercise1_validateUpgrade(UpgradeRequest("/ws", validHeaders + ("Upgrade" -> "WebSocket"))), "Exercise 1 failed: case insensitive")
    println("Exercise 1 passed: upgrade validation works")

    // Exercise 2
    var idSeq = 0
    val genId = () => { idSeq += 1; s"ws-$idSeq" }
    val accepted = exercise2_processUpgrade(UpgradeRequest("/ws", validHeaders), genId)
    assert(accepted.isInstanceOf[UpgradeResult.Accepted], "Exercise 2 failed: should accept")
    val rejected = exercise2_processUpgrade(UpgradeRequest("/ws", Map.empty), genId)
    assert(rejected.isInstanceOf[UpgradeResult.Rejected], "Exercise 2 failed: should reject")
    println("Exercise 2 passed: upgrade processing works")

    // Exercise 3
    val conn = WebSocketConnection("ws-1", Open, Nil, Nil)
    val afterText = exercise3_handleFrame(conn, Text("hello"))
    assert(afterText.receivedFrames == List(Text("hello")), "Exercise 3 failed: text not recorded")
    val afterPing = exercise3_handleFrame(conn, Ping)
    assert(afterPing.sentFrames == List(Pong), "Exercise 3 failed: pong not sent")
    val afterClose = exercise3_handleFrame(conn, Close(1000, "bye"))
    assert(afterClose.state == Closing, "Exercise 3 failed: should be Closing")
    assert(afterClose.sentFrames.exists(_.isInstanceOf[Close]), "Exercise 3 failed: close response not sent")
    val closedConn = conn.copy(state = Closed)
    assert(exercise3_handleFrame(closedConn, Text("x")) == closedConn, "Exercise 3 failed: closed conn should not change")
    println("Exercise 3 passed: frame handling works")

    // Exercise 4
    val sent = exercise4_sendText(conn, "world")
    assert(sent.sentFrames == List(Text("world")), "Exercise 4 failed: text not sent")
    val closedSend = exercise4_sendText(conn.copy(state = Closed), "nope")
    assert(closedSend.sentFrames.isEmpty, "Exercise 4 failed: should not send on closed conn")
    println("Exercise 4 passed: send text works")

    // Exercise 5
    val handlers = Map(
      "echo" -> ((s: String) => s),
      "upper" -> ((s: String) => s.toUpperCase)
    )
    assert(exercise5_routeMessage(handlers, Text("echo:hello")).data == "hello", "Exercise 5 failed: echo")
    assert(exercise5_routeMessage(handlers, Text("upper:hello")).data == "HELLO", "Exercise 5 failed: upper")
    assert(exercise5_routeMessage(handlers, Text("bad:x")).data == "unknown command: bad", "Exercise 5 failed: unknown")
    assert(exercise5_routeMessage(handlers, Text("echo")).data == "", "Exercise 5 failed: no payload")
    println("Exercise 5 passed: message routing works")

    // Exercise 6
    val closing = exercise6_initiateClose(conn)
    assert(closing.state == Closing, "Exercise 6 failed: should be Closing")
    assert(closing.sentFrames.exists { case Close(1000, "goodbye") => true; case _ => false }, "Exercise 6 failed: close frame not sent")
    val alreadyClosed = exercise6_initiateClose(conn.copy(state = Closed))
    assert(alreadyClosed.state == Closed, "Exercise 6 failed: closed conn should stay closed")
    println("Exercise 6 passed: graceful close works")

    // Exercise 7
    val statsConn = WebSocketConnection("ws-1", Open,
      List(Text("a"), Text("b"), Pong),
      List(Text("x"), Ping, Ping, Text("y"))
    )
    val stats = exercise7_connectionStats(statsConn)
    assert(stats("text_sent") == 2, "Exercise 7 failed: text_sent")
    assert(stats("text_received") == 2, "Exercise 7 failed: text_received")
    assert(stats("pings_received") == 2, "Exercise 7 failed: pings_received")
    assert(stats("pongs_sent") == 1, "Exercise 7 failed: pongs_sent")
    assert(stats("total_sent") == 3, "Exercise 7 failed: total_sent")
    assert(stats("total_received") == 4, "Exercise 7 failed: total_received")
    println("Exercise 7 passed: connection stats work")

    // Exercise 8
    val conns = List(
      WebSocketConnection("ws-1", Open, Nil, Nil),
      WebSocketConnection("ws-2", Closed, Nil, Nil),
      WebSocketConnection("ws-3", Open, Nil, Nil)
    )
    val broadcasted = exercise8_broadcast(conns, "announcement")
    assert(broadcasted(0).sentFrames == List(Text("announcement")), "Exercise 8 failed: ws-1 should receive")
    assert(broadcasted(1).sentFrames.isEmpty, "Exercise 8 failed: ws-2 should not receive")
    assert(broadcasted(2).sentFrames == List(Text("announcement")), "Exercise 8 failed: ws-3 should receive")
    println("Exercise 8 passed: broadcast works")

    println("\nAll Http011_WebSockets exercises passed!")
  }
}
