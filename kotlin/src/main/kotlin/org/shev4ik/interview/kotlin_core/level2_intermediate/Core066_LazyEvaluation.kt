package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Lazy Evaluation Patterns
 */
object Core066_LazyEvaluation {

    // Exercise 1: lazyTiming
    // TODO: Create var computed = false. Create val x by lazy { computed = true; 42 }.
    // TODO: Check computed before access (should be false). Access x. Check computed (should be true).
    // TODO: Return computed after access.
    fun exercise1_lazyTiming(): Boolean = TODO()

    // Exercise 2: lazyNone
    // TODO: Create val x by lazy(LazyThreadSafetyMode.NONE) { 42 }. Return x.
    fun exercise2_lazyNone(): Int = TODO()

    // Exercise 3: sequenceVsList
    // TODO: Compare: sequence { yield(1); yield(2) }.first() vs listOf(1,2).first().
    // TODO: Both return 1. Sequence is lazy (only generates first). Return true.
    fun exercise3_sequenceVsList(): Boolean = TODO()

    // Exercise 4: generateAndTake
    // TODO: Use generateSequence(1) { it + 1 }.take(5).toList(). Return result.
    fun exercise4_generateAndTake(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_lazyTiming() == true) { "Exercise 1 failed" }
        assert(exercise2_lazyNone() == 42) { "Exercise 2 failed" }
        assert(exercise3_sequenceVsList() == true) { "Exercise 3 failed" }
        assert(exercise4_generateAndTake() == listOf(1,2,3,4,5)) { "Exercise 4 failed" }
        println("All Core066_LazyEvaluation exercises passed!")
    }
}
