package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Result Type
 */
object Core063_ResultType {

    // Exercise 1: runCatchingSuccess
    // TODO: Use runCatching { 42 }.getOrDefault(-1). Return result.
    fun exercise1_runCatchingSuccess(): Int = TODO()

    // Exercise 2: runCatchingFailure
    // TODO: Use runCatching { error("fail") as Int }.getOrDefault(-1). Return result.
    fun exercise2_runCatchingFailure(): Int = TODO()

    // Exercise 3: resultFold
    // TODO: Use runCatching { 42 }.fold({ "ok:$it" }, { "err" }). Return result.
    fun exercise3_resultFold(): String = TODO()

    // Exercise 4: resultMap
    // TODO: Use runCatching { "42" }.map { it.toInt() }.getOrDefault(0). Return result.
    fun exercise4_resultMap(): Int = TODO()

    // Exercise 5: resultRecover
    // TODO: Use runCatching { error("x") as Int }.recover { 99 }.getOrThrow(). Return result.
    fun exercise5_resultRecover(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_runCatchingSuccess() == 42) { "Exercise 1 failed" }
        assert(exercise2_runCatchingFailure() == -1) { "Exercise 2 failed" }
        assert(exercise3_resultFold() == "ok:42") { "Exercise 3 failed" }
        assert(exercise4_resultMap() == 42) { "Exercise 4 failed" }
        assert(exercise5_resultRecover() == 99) { "Exercise 5 failed" }
        println("All Core063_ResultType exercises passed!")
    }
}
