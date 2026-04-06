package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * Foldable pattern
 */
object Fp020_Foldable {

    // Exercise 1: foldLeft
    // TODO: Implement the functional programming concept: foldLeft.
    // TODO: Topic: Foldable pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise1_foldLeft(): String = TODO()

    // Exercise 2: foldRight
    // TODO: Implement the functional programming concept: foldRight.
    // TODO: Topic: Foldable pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise2_foldRight(): String = TODO()

    // Exercise 3: foldMap
    // TODO: Implement the functional programming concept: foldMap.
    // TODO: Topic: Foldable pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise3_foldMap(): Map<String, Int> = TODO()

    // Exercise 4: combineAll
    // TODO: Implement the functional programming concept: combineAll.
    // TODO: Topic: Foldable pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise4_combineAll(): List<Int> = TODO()

    // Exercise 5: toList
    // TODO: Implement the functional programming concept: toList.
    // TODO: Topic: Foldable pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise5_toList(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_foldLeft().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_foldRight().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_foldMap().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_combineAll().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_toList() == true) { "Exercise 5 failed" }
        println("All Fp020_Foldable exercises passed!")
    }
}
