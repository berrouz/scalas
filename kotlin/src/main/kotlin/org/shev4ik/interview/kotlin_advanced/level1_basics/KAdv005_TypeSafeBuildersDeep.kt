package org.shev4ik.interview.kotlin_advanced.level1_basics

/**
 * DSL deep dive
 */
object KAdv005_TypeSafeBuildersDeep {

    // Exercise 1: dslMarker
    // TODO: Implement advanced Kotlin feature: dslMarker.
    // TODO: Topic: DSL deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise1_dslMarker(): String = TODO()

    // Exercise 2: scopeControl
    // TODO: Implement advanced Kotlin feature: scopeControl.
    // TODO: Topic: DSL deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise2_scopeControl(): String = TODO()

    // Exercise 3: nestedBuilder
    // TODO: Implement advanced Kotlin feature: nestedBuilder.
    // TODO: Topic: DSL deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise3_nestedBuilder(): String = TODO()

    // Exercise 4: validation
    // TODO: Implement advanced Kotlin feature: validation.
    // TODO: Topic: DSL deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise4_validation(): Boolean = TODO()

    // Exercise 5: composition
    // TODO: Implement advanced Kotlin feature: composition.
    // TODO: Topic: DSL deep dive.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise5_composition(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_dslMarker().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_scopeControl().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_nestedBuilder().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_validation() == true) { "Exercise 4 failed" }
        exercise5_composition()
        println("All KAdv005_TypeSafeBuildersDeep exercises passed!")
    }
}
