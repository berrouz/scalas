package org.shev4ik.interview.docker_k8s.level1_basics

/**
 * Kubernetes Deployment
 */
object Dock005_K8sDeployment {

    // Exercise 1: deployment
    // TODO: Model the deployment concept.
    // TODO: Topic: Kubernetes Deployment.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_deployment(): String = TODO()

    // Exercise 2: replicaSet
    // TODO: Model the replicaSet concept.
    // TODO: Topic: Kubernetes Deployment.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_replicaSet(): String = TODO()

    // Exercise 3: rollingUpdate
    // TODO: Model the rollingUpdate concept.
    // TODO: Topic: Kubernetes Deployment.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_rollingUpdate(): String = TODO()

    // Exercise 4: rollback
    // TODO: Model the rollback concept.
    // TODO: Topic: Kubernetes Deployment.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_rollback(): String = TODO()

    // Exercise 5: scaling
    // TODO: Model the scaling concept.
    // TODO: Topic: Kubernetes Deployment.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_scaling(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_deployment().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_replicaSet().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_rollingUpdate().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_rollback().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_scaling().isNotEmpty()) { "Exercise 5 failed" }
        println("All Dock005_K8sDeployment exercises passed!")
    }
}
