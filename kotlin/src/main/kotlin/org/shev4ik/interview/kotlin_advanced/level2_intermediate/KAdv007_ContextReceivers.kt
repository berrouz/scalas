package org.shev4ik.interview.kotlin_advanced.level2_intermediate

/**
 * Context receivers
 */
object KAdv007_ContextReceivers {

    // Exercise 1: contextFun
    // TODO: Implement advanced Kotlin feature: contextFun.
    // TODO: Topic: Context receivers.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise1_contextFun(): String = TODO()

    // Exercise 2: multipleContexts
    // TODO: Implement advanced Kotlin feature: multipleContexts.
    // TODO: Topic: Context receivers.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise2_multipleContexts(): String = TODO()

    // Exercise 3: scopedContext
    // TODO: Implement advanced Kotlin feature: scopedContext.
    // TODO: Topic: Context receivers.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise3_scopedContext(): String = TODO()

    // Exercise 4: diContext
    // TODO: Implement advanced Kotlin feature: diContext.
    // TODO: Topic: Context receivers.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise4_diContext(): String = TODO()

    // Exercise 5: testContext
    // TODO: Implement advanced Kotlin feature: testContext.
    // TODO: Topic: Context receivers.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise5_testContext(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_contextFun().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_multipleContexts().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_scopedContext().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_diContext().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_testContext() == true) { "Exercise 5 failed" }
        println("All KAdv007_ContextReceivers exercises passed!")
    }
}
