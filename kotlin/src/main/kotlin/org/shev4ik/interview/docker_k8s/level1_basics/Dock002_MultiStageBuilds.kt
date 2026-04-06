package org.shev4ik.interview.docker_k8s.level1_basics

/**
 * Multi-stage builds
 */
object Dock002_MultiStageBuilds {

    // Exercise 1: builderStage
    // TODO: Model the builderStage concept.
    // TODO: Topic: Multi-stage builds.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_builderStage(): String = TODO()

    // Exercise 2: runtimeStage
    // TODO: Model the runtimeStage concept.
    // TODO: Topic: Multi-stage builds.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_runtimeStage(): String = TODO()

    // Exercise 3: layerCaching
    // TODO: Model the layerCaching concept.
    // TODO: Topic: Multi-stage builds.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_layerCaching(): String = TODO()

    // Exercise 4: imageSize
    // TODO: Model the imageSize concept.
    // TODO: Topic: Multi-stage builds.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_imageSize(): Int = TODO()

    // Exercise 5: optimization
    // TODO: Model the optimization concept.
    // TODO: Topic: Multi-stage builds.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_optimization(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_builderStage().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_runtimeStage().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_layerCaching().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_imageSize()
        assert(exercise5_optimization().isNotEmpty()) { "Exercise 5 failed" }
        println("All Dock002_MultiStageBuilds exercises passed!")
    }
}
