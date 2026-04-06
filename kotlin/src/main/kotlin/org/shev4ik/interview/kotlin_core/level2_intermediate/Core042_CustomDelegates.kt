package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Custom Property Delegates
 */
object Core042_CustomDelegates {

    // Exercise 1: readOnlyDelegate
    // TODO: Implement class ConstDelegate<T>(val value: T) : ReadOnlyProperty<Any?, T>.
    // TODO: Use it: val x by ConstDelegate(42). Return x.
    fun exercise1_readOnlyDelegate(): Int = TODO()

    // Exercise 2: readWriteValidating
    // TODO: Implement a delegate that only accepts positive values (throws on negative).
    // TODO: Create var positive by PositiveOnly(). Set to 10. Return it.
    fun exercise2_readWriteValidating(): Int = TODO()

    // Exercise 3: loggingDelegate
    // TODO: Implement a delegate that counts reads. Create val tracked by Counted(42).
    // TODO: Read it 3 times. Return Pair(value, readCount).
    fun exercise3_loggingDelegate(): Pair<Int, Int> = TODO()

    // Exercise 4: cachedDelegate
    // TODO: Implement a delegate that computes value on first access and caches.
    // TODO: Create val cached by Cached { 40 + 2 }. Return value.
    fun exercise4_cachedDelegate(): Int = TODO()

    // Exercise 5: transformDelegate
    // TODO: Implement a delegate that transforms on set: uppercase.
    // TODO: Create var upper by Uppercased(). Set "hello". Return value.
    fun exercise5_transformDelegate(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_readOnlyDelegate() == 42) { "Exercise 1 failed" }
        assert(exercise2_readWriteValidating() == 10) { "Exercise 2 failed" }
        assert(exercise3_loggingDelegate() == Pair(42, 3)) { "Exercise 3 failed" }
        assert(exercise4_cachedDelegate() == 42) { "Exercise 4 failed" }
        assert(exercise5_transformDelegate() == "HELLO") { "Exercise 5 failed" }
        println("All Core042_CustomDelegates exercises passed!")
    }
}
