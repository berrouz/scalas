package org.shev4ik.interview.kotlin_core.level3_advanced

/**
 * Use-site variance and type projections
 */
object Core072_TypeProjections {

    // Exercise 1: useOutProjection
    // TODO: Implement useOutProjection.
    // TODO: Topic: Use-site variance and type projections.
    // TODO: Return a verifiable result of type String.
    fun exercise1_useOutProjection(): String = TODO()

    // Exercise 2: useInProjection
    // TODO: Implement useInProjection.
    // TODO: Topic: Use-site variance and type projections.
    // TODO: Return a verifiable result of type String.
    fun exercise2_useInProjection(): String = TODO()

    // Exercise 3: arrayCovariance
    // TODO: Implement arrayCovariance.
    // TODO: Topic: Use-site variance and type projections.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_arrayCovariance(): List<Int> = TODO()

    // Exercise 4: projectionLimits
    // TODO: Implement projectionLimits.
    // TODO: Topic: Use-site variance and type projections.
    // TODO: Return a verifiable result of type String.
    fun exercise4_projectionLimits(): String = TODO()

    // Exercise 5: starVsOut
    // TODO: Implement starVsOut.
    // TODO: Topic: Use-site variance and type projections.
    // TODO: Return a verifiable result of type String.
    fun exercise5_starVsOut(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_useOutProjection().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_useInProjection().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_arrayCovariance().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_projectionLimits().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_starVsOut().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core072_TypeProjections exercises passed!")
    }
}
