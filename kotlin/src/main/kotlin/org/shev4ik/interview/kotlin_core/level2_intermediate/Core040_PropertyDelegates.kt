package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Property Delegates
 */
object Core040_PropertyDelegates {

    // Exercise 1: lazyDelegate
    // TODO: Create val heavyValue: Int by lazy { 40 + 2 }. Access it and return.
    fun exercise1_lazyDelegate(): Int = TODO()

    // Exercise 2: observableDelegate
    // TODO: Create var name by Delegates.observable("initial") that logs changes.
    // TODO: Collect old->new changes. Set to "Alice", then "Bob".
    // TODO: Return list of change descriptions.
    fun exercise2_observableDelegate(): List<String> = TODO()

    // Exercise 3: vetoableDelegate
    // TODO: Create var positiveOnly by Delegates.vetoable(1) { _, _, new -> new > 0 }.
    // TODO: Set to 5 (accepted), then to -3 (rejected). Return value.
    fun exercise3_vetoableDelegate(): Int = TODO()

    // Exercise 4: mapDelegate
    // TODO: Create class Config(map: Map<String, Any?>) { val host: String by map; val port: Int by map }.
    // TODO: Return Config(mapOf("host" to "localhost", "port" to 8080)).host.
    fun exercise4_mapDelegate(): String = TODO()

    // Exercise 5: customLazy
    // TODO: Implement a custom delegate that caches result of a lambda.
    // TODO: Create val cached by CachedDelegate { expensiveComputation() } where it returns 42.
    // TODO: Return the value.
    fun exercise5_customLazy(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_lazyDelegate() == 42) { "Exercise 1 failed" }
        assert(exercise2_observableDelegate().size == 2) { "Exercise 2 failed" }
        assert(exercise3_vetoableDelegate() == 5) { "Exercise 3 failed" }
        assert(exercise4_mapDelegate() == "localhost") { "Exercise 4 failed" }
        assert(exercise5_customLazy() == 42) { "Exercise 5 failed" }
        println("All Core040_PropertyDelegates exercises passed!")
    }
}
