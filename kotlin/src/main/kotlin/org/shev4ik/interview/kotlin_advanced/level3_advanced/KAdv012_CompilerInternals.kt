package org.shev4ik.interview.kotlin_advanced.level3_advanced

/**
 * Compiler internals
 */
object KAdv012_CompilerInternals {

    // Exercise 1: frontend
    // TODO: Implement advanced Kotlin feature: frontend.
    // TODO: Topic: Compiler internals.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise1_frontend(): String = TODO()

    // Exercise 2: backend
    // TODO: Implement advanced Kotlin feature: backend.
    // TODO: Topic: Compiler internals.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise2_backend(): String = TODO()

    // Exercise 3: ir
    // TODO: Implement advanced Kotlin feature: ir.
    // TODO: Topic: Compiler internals.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise3_ir(): String = TODO()

    // Exercise 4: fir
    // TODO: Implement advanced Kotlin feature: fir.
    // TODO: Topic: Compiler internals.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise4_fir(): String = TODO()

    // Exercise 5: phases
    // TODO: Implement advanced Kotlin feature: phases.
    // TODO: Topic: Compiler internals.
    // TODO: Demonstrate with a practical example returning a verifiable result.
    fun exercise5_phases(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_frontend().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_backend().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_ir().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_fir().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_phases() == true) { "Exercise 5 failed" }
        println("All KAdv012_CompilerInternals exercises passed!")
    }
}
