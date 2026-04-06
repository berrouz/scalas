package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Annotations
 */
object Core060_Annotations {

    // Exercise 1: jvmStaticUsage
    // TODO: Explain: @JvmStatic in companion makes method callable as static from Java.
    // TODO: Return "static" to confirm understanding.
    fun exercise1_jvmStaticUsage(): String = TODO()

    // Exercise 2: jvmFieldUsage
    // TODO: Explain: @JvmField exposes Kotlin property as Java field (no getter/setter).
    // TODO: Return "field" to confirm.
    fun exercise2_jvmFieldUsage(): String = TODO()

    // Exercise 3: deprecatedUsage
    // TODO: Create @Deprecated("Use newFun") fun oldFun() = "old". Call it. Return result.
    fun exercise3_deprecatedUsage(): String = TODO()

    // Exercise 4: suppressWarning
    // TODO: @Suppress("UNCHECKED_CAST") can suppress cast warnings.
    // TODO: Return true to confirm understanding.
    fun exercise4_suppressWarning(): Boolean = TODO()

    // Exercise 5: customAnnotation
    // TODO: Create annotation class MyTag(val name: String). Apply @MyTag("test") to a class.
    // TODO: Return "tagged" to confirm annotation was applied.
    fun exercise5_customAnnotation(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_jvmStaticUsage() == "static") { "Exercise 1 failed" }
        assert(exercise2_jvmFieldUsage() == "field") { "Exercise 2 failed" }
        assert(exercise3_deprecatedUsage() == "old") { "Exercise 3 failed" }
        assert(exercise4_suppressWarning() == true) { "Exercise 4 failed" }
        assert(exercise5_customAnnotation() == "tagged") { "Exercise 5 failed" }
        println("All Core060_Annotations exercises passed!")
    }
}
