package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Data Classes
 */
object Core022_DataClasses {

    // Exercise 1: createData
    // TODO: Create data class User(val name: String, val age: Int).
    // TODO: Return User("Alice", 30).toString().
    fun exercise1_createData(): String = TODO()

    // Exercise 2: copyData
    // TODO: Create user = User("Bob", 25). Create copy with age=26.
    // TODO: Return Pair(copy.name, copy.age).
    fun exercise2_copyData(): Pair<String, Int> = TODO()

    // Exercise 3: destructureData
    // TODO: Destructure User("Charlie", 35) into (name, age). Return Pair(name, age).
    fun exercise3_destructureData(): Pair<String, Int> = TODO()

    // Exercise 4: equalsData
    // TODO: Compare User("Alice", 30) == User("Alice", 30). Return result.
    fun exercise4_equalsData(): Boolean = TODO()

    // Exercise 5: hashCodeData
    // TODO: Check that User("Alice", 30).hashCode() == User("Alice", 30).hashCode().
    fun exercise5_hashCodeData(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createData() == "User(name=Alice, age=30)") { "Ex1 failed" }
        assert(exercise2_copyData() == Pair("Bob", 26)) { "Ex2 failed" }
        assert(exercise3_destructureData() == Pair("Charlie", 35)) { "Ex3 failed" }
        assert(exercise4_equalsData() == true) { "Ex4 failed" }
        assert(exercise5_hashCodeData() == true) { "Ex5 failed" }
        println("All Core022_DataClasses exercises passed!")
    }
}
