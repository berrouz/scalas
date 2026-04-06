package org.shev4ik.interview.kotlin_core.level4_expert

/**
 * Manual DI and service locator patterns
 */
object Core114_DependencyInjection {

    // Exercise 1: constructorDI
    // TODO: Implement constructorDI.
    // TODO: Topic: Manual DI and service locator patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_constructorDI(): String = TODO()

    // Exercise 2: interfaceDI
    // TODO: Implement interfaceDI.
    // TODO: Topic: Manual DI and service locator patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_interfaceDI(): String = TODO()

    // Exercise 3: factoryDI
    // TODO: Implement factoryDI.
    // TODO: Topic: Manual DI and service locator patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_factoryDI(): String = TODO()

    // Exercise 4: scopedDI
    // TODO: Implement scopedDI.
    // TODO: Topic: Manual DI and service locator patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_scopedDI(): String = TODO()

    // Exercise 5: koinLike
    // TODO: Implement koinLike.
    // TODO: Topic: Manual DI and service locator patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_koinLike(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_constructorDI().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_interfaceDI().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_factoryDI().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_scopedDI().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_koinLike().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core114_DependencyInjection exercises passed!")
    }
}
