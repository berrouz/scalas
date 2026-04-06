package org.shev4ik.interview.arrow.level2_intermediate

/**
 * Functor and Applicative
 */
object Arrow032_FunctorApplicative {

    // Exercise 1: map
    // TODO: Using Arrow library, implement map.
    // TODO: Topic: Functor and Applicative.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_map(): Map<String, Int> = TODO()

    // Exercise 2: ap
    // TODO: Using Arrow library, implement ap.
    // TODO: Topic: Functor and Applicative.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_ap(): String = TODO()

    // Exercise 3: mapN
    // TODO: Using Arrow library, implement mapN.
    // TODO: Topic: Functor and Applicative.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_mapN(): Map<String, Int> = TODO()

    // Exercise 4: zip
    // TODO: Using Arrow library, implement zip.
    // TODO: Topic: Functor and Applicative.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_zip(): String = TODO()

    // Exercise 5: product
    // TODO: Using Arrow library, implement product.
    // TODO: Topic: Functor and Applicative.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_product(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_map().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_ap().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_mapN().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_zip().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_product().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow032_FunctorApplicative exercises passed!")
    }
}
