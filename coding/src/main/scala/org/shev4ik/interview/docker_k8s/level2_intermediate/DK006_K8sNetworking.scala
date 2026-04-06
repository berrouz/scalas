package org.shev4ik.interview.docker_k8s.level2_intermediate

object DK006_K8sNetworking {

  // ---- Domain types ----

  sealed trait ServiceType
  case object ClusterIP extends ServiceType
  case class NodePort(nodePort: Int) extends ServiceType
  case class LoadBalancer(externalIp: String) extends ServiceType

  case class ServicePort(name: String, port: Int, targetPort: Int, protocol: String = "TCP")

  case class K8sService(
    name: String,
    namespace: String = "default",
    serviceType: ServiceType = ClusterIP,
    selector: Map[String, String] = Map.empty,
    ports: List[ServicePort] = Nil,
    clusterIp: String = "10.96.0.1"
  )

  sealed trait IngressPathType
  case object Exact extends IngressPathType
  case object Prefix extends IngressPathType
  case object ImplementationSpecific extends IngressPathType

  case class IngressPath(path: String, pathType: IngressPathType, serviceName: String, servicePort: Int)
  case class IngressRule(host: String, paths: List[IngressPath])
  case class IngressTLS(hosts: List[String], secretName: String)

  case class Ingress(
    name: String,
    namespace: String = "default",
    rules: List[IngressRule] = Nil,
    tls: List[IngressTLS] = Nil,
    annotations: Map[String, String] = Map.empty
  )

  case class DnsRecord(name: String, recordType: String, value: String) // A, CNAME, SRV

  // ---- Exercise 1 ----
  // TODO: Generate internal DNS names for a K8s Service.
  // K8s services get DNS entries in the form:
  // - "<service>.<namespace>.svc.cluster.local"
  // - "<service>.<namespace>.svc"
  // - "<service>.<namespace>"
  // - "<service>" (only if same namespace as the querying pod)
  // Given a service and the querying namespace, return all valid DNS names sorted shortest first.
  def serviceDnsNames(service: K8sService, queryNamespace: String): List[String] = ???

  // ---- Exercise 2 ----
  // TODO: Route an incoming request to the correct service based on Ingress rules.
  // Given a host and path, find the matching IngressRule and IngressPath.
  // - First match the host exactly.
  // - Then match paths: Exact must match exactly, Prefix must be a prefix of the request path.
  // - If multiple Prefix paths match, pick the longest prefix.
  // Return Some((serviceName, servicePort)) or None if no match.
  def routeRequest(ingress: Ingress, host: String, path: String): Option[(String, Int)] = ???

  // ---- Exercise 3 ----
  // TODO: Validate NodePort service configuration. Return list of errors.
  // Rules:
  // - NodePort port must be in range 30000-32767 (error: "NodePort <port> out of range 30000-32767")
  // - Service ports must be 1-65535 (error: "Invalid service port: <port>")
  // - Target ports must be 1-65535 (error: "Invalid target port: <port>")
  // - No duplicate port names (error: "Duplicate port name: <name>")
  def validateService(service: K8sService): List[String] = ???

  // ---- Exercise 4 ----
  // TODO: Check if TLS is properly configured for all Ingress hosts.
  // For each host in ingress rules, check if it's covered by a TLS entry.
  // A TLS entry covers a host if the host is in the TLS hosts list.
  // Return list of hosts that are NOT covered by TLS.
  def findUnsecuredHosts(ingress: Ingress): List[String] = ???

  // ---- Exercise 5 ----
  // TODO: Generate SRV DNS records for a K8s Service.
  // K8s creates SRV records in the format:
  // "_<port-name>._<protocol>.<service>.<namespace>.svc.cluster.local"
  // The value is "0 100 <port> <service>.<namespace>.svc.cluster.local"
  // Generate one SRV record per ServicePort.
  // Protocol should be lowercased.
  def generateSrvRecords(service: K8sService): List[DnsRecord] = ???

  // ---- Exercise 6 ----
  // TODO: Simulate network policy - determine if traffic is allowed between two services.
  // Traffic is allowed if:
  // - Both services are in the same namespace, OR
  // - The source service has annotation "network-policy/allow-egress-to" containing the target namespace, OR
  // - The target service has annotation "network-policy/allow-ingress-from" containing the source namespace
  // Annotations contain comma-separated namespace lists.
  // For this exercise, services don't have annotations, so we use a Map[String, Map[String, String]]
  // (serviceName -> annotations).
  def isTrafficAllowed(
    source: K8sService,
    target: K8sService,
    annotations: Map[String, Map[String, String]]
  ): Boolean = ???

  // ---- Exercise 7 ----
  // TODO: Calculate the external access URL for a service.
  // - ClusterIP: no external access => None
  // - NodePort(port): "http://<nodeIp>:<nodePort>" using first service port
  // - LoadBalancer(ip): "http://<ip>:<port>" using first service port
  // If the service has no ports, return None.
  def externalUrl(service: K8sService, nodeIp: String = "192.168.1.100"): Option[String] = ???

  // ---- Exercise 8 ----
  // TODO: Build a complete routing table from an Ingress resource.
  // For each rule and path combination, produce a routing entry:
  // (host, path, pathType, serviceName, servicePort, tlsEnabled: Boolean)
  // tlsEnabled is true if the host is covered by any TLS configuration.
  // Return the list of routing entries sorted by host then path.
  case class RoutingEntry(host: String, path: String, pathType: IngressPathType, serviceName: String, servicePort: Int, tlsEnabled: Boolean)

  def buildRoutingTable(ingress: Ingress): List[RoutingEntry] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: serviceDnsNames
    val webSvc = K8sService("web", "production", ClusterIP, Map("app" -> "web"), List(ServicePort("http", 80, 8080)))
    val dnsNames = serviceDnsNames(webSvc, "production")
    assert(dnsNames.contains("web"))
    assert(dnsNames.contains("web.production"))
    assert(dnsNames.contains("web.production.svc"))
    assert(dnsNames.contains("web.production.svc.cluster.local"))
    assert(dnsNames == dnsNames.sortBy(_.length))
    val crossNs = serviceDnsNames(webSvc, "default")
    assert(!crossNs.contains("web")) // different namespace, short name not valid
    println("Exercise 1 passed: serviceDnsNames")

    // Exercise 2: routeRequest
    val ingress = Ingress("main", rules = List(
      IngressRule("api.example.com", List(
        IngressPath("/v1/users", Exact, "users-svc", 80),
        IngressPath("/v1", Prefix, "api-svc", 80),
        IngressPath("/v2", Prefix, "api-v2-svc", 80)
      )),
      IngressRule("web.example.com", List(
        IngressPath("/", Prefix, "web-svc", 80)
      ))
    ))
    assert(routeRequest(ingress, "api.example.com", "/v1/users") == Some(("users-svc", 80)))
    assert(routeRequest(ingress, "api.example.com", "/v1/orders") == Some(("api-svc", 80)))
    assert(routeRequest(ingress, "web.example.com", "/anything") == Some(("web-svc", 80)))
    assert(routeRequest(ingress, "unknown.com", "/").isEmpty)
    println("Exercise 2 passed: routeRequest")

    // Exercise 3: validateService
    assert(validateService(K8sService("svc", serviceType = NodePort(30080), ports = List(ServicePort("http", 80, 8080)))).isEmpty)
    val badSvc = K8sService("svc", serviceType = NodePort(29000), ports = List(ServicePort("http", 0, 8080)))
    val svcErrors = validateService(badSvc)
    assert(svcErrors.exists(_.contains("out of range")))
    assert(svcErrors.exists(_.contains("Invalid service port")))
    println("Exercise 3 passed: validateService")

    // Exercise 4: findUnsecuredHosts
    val tlsIngress = Ingress("tls-test",
      rules = List(
        IngressRule("secure.example.com", List(IngressPath("/", Prefix, "svc", 80))),
        IngressRule("insecure.example.com", List(IngressPath("/", Prefix, "svc", 80)))
      ),
      tls = List(IngressTLS(List("secure.example.com"), "tls-secret"))
    )
    assert(findUnsecuredHosts(tlsIngress) == List("insecure.example.com"))
    println("Exercise 4 passed: findUnsecuredHosts")

    // Exercise 5: generateSrvRecords
    val srvSvc = K8sService("myapp", "default", ports = List(
      ServicePort("http", 80, 8080, "TCP"),
      ServicePort("grpc", 9090, 9090, "TCP")
    ))
    val srvRecords = generateSrvRecords(srvSvc)
    assert(srvRecords.length == 2)
    assert(srvRecords.head.name == "_http._tcp.myapp.default.svc.cluster.local")
    assert(srvRecords.head.recordType == "SRV")
    println("Exercise 5 passed: generateSrvRecords")

    // Exercise 6: isTrafficAllowed
    val srcSvc = K8sService("frontend", "web")
    val tgtSvc = K8sService("backend", "api")
    assert(isTrafficAllowed(srcSvc, K8sService("other", "web"), Map.empty)) // same namespace
    val annots = Map("frontend" -> Map("network-policy/allow-egress-to" -> "api,monitoring"))
    assert(isTrafficAllowed(srcSvc, tgtSvc, annots))
    assert(!isTrafficAllowed(srcSvc, tgtSvc, Map.empty))
    println("Exercise 6 passed: isTrafficAllowed")

    // Exercise 7: externalUrl
    assert(externalUrl(K8sService("svc", serviceType = ClusterIP, ports = List(ServicePort("http", 80, 8080)))).isEmpty)
    assert(externalUrl(K8sService("svc", serviceType = NodePort(30080), ports = List(ServicePort("http", 80, 8080)))).contains("http://192.168.1.100:30080"))
    assert(externalUrl(K8sService("svc", serviceType = LoadBalancer("1.2.3.4"), ports = List(ServicePort("http", 80, 8080)))).contains("http://1.2.3.4:80"))
    println("Exercise 7 passed: externalUrl")

    // Exercise 8: buildRoutingTable
    val rtIngress = Ingress("rt",
      rules = List(
        IngressRule("b.com", List(IngressPath("/api", Prefix, "api-svc", 80))),
        IngressRule("a.com", List(IngressPath("/", Prefix, "web-svc", 80)))
      ),
      tls = List(IngressTLS(List("a.com"), "tls-secret"))
    )
    val table = buildRoutingTable(rtIngress)
    assert(table.length == 2)
    assert(table.head.host == "a.com")
    assert(table.head.tlsEnabled)
    assert(!table.last.tlsEnabled)
    println("Exercise 8 passed: buildRoutingTable")

    println("All DK006_K8sNetworking exercises passed!")
  }
}
