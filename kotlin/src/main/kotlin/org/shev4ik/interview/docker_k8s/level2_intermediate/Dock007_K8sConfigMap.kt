package org.shev4ik.interview.docker_k8s.level2_intermediate

/**
 * ConfigMap and Secret
 */
object Dock007_K8sConfigMap {

    // Exercise 1: configMap
    // TODO: Model the configMap concept.
    // TODO: Topic: ConfigMap and Secret.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_configMap(): Map<String, Int> = TODO()

    // Exercise 2: secret
    // TODO: Model the secret concept.
    // TODO: Topic: ConfigMap and Secret.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_secret(): String = TODO()

    // Exercise 3: envVars
    // TODO: Model the envVars concept.
    // TODO: Topic: ConfigMap and Secret.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_envVars(): String = TODO()

    // Exercise 4: volumeMount
    // TODO: Model the volumeMount concept.
    // TODO: Topic: ConfigMap and Secret.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_volumeMount(): Int = TODO()

    // Exercise 5: rotation
    // TODO: Model the rotation concept.
    // TODO: Topic: ConfigMap and Secret.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_rotation(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_configMap().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_secret().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_envVars().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_volumeMount()
        assert(exercise5_rotation().isNotEmpty()) { "Exercise 5 failed" }
        println("All Dock007_K8sConfigMap exercises passed!")
    }
}
