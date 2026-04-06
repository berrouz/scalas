package org.shev4ik.interview.docker_k8s.level2_intermediate

/**
 * Kubernetes Service
 */
object Dock006_K8sService {

    // Exercise 1: clusterIP
    // TODO: Model the clusterIP concept.
    // TODO: Topic: Kubernetes Service.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_clusterIP(): String = TODO()

    // Exercise 2: nodePort
    // TODO: Model the nodePort concept.
    // TODO: Topic: Kubernetes Service.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_nodePort(): String = TODO()

    // Exercise 3: loadBalancer
    // TODO: Model the loadBalancer concept.
    // TODO: Topic: Kubernetes Service.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_loadBalancer(): String = TODO()

    // Exercise 4: ingress
    // TODO: Model the ingress concept.
    // TODO: Topic: Kubernetes Service.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_ingress(): String = TODO()

    // Exercise 5: externalName
    // TODO: Model the externalName concept.
    // TODO: Topic: Kubernetes Service.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_externalName(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_clusterIP().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_nodePort().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_loadBalancer().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_ingress().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_externalName().isNotEmpty()) { "Exercise 5 failed" }
        println("All Dock006_K8sService exercises passed!")
    }
}
