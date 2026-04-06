package org.shev4ik.interview.kotlin_core.level4_expert

/**
 * Compiler plugins: allopen, noarg, serialization
 */
object Core104_CompilerPlugins {

    // Exercise 1: allopenPlugin
    // TODO: Implement allopenPlugin.
    // TODO: Topic: Compiler plugins: allopen, noarg, serialization.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_allopenPlugin(): List<Int> = TODO()

    // Exercise 2: noargPlugin
    // TODO: Implement noargPlugin.
    // TODO: Topic: Compiler plugins: allopen, noarg, serialization.
    // TODO: Return a verifiable result of type String.
    fun exercise2_noargPlugin(): String = TODO()

    // Exercise 3: serializationPlugin
    // TODO: Implement serializationPlugin.
    // TODO: Topic: Compiler plugins: allopen, noarg, serialization.
    // TODO: Return a verifiable result of type String.
    fun exercise3_serializationPlugin(): String = TODO()

    // Exercise 4: lombokKotlin
    // TODO: Implement lombokKotlin.
    // TODO: Topic: Compiler plugins: allopen, noarg, serialization.
    // TODO: Return a verifiable result of type String.
    fun exercise4_lombokKotlin(): String = TODO()

    // Exercise 5: pluginConfig
    // TODO: Implement pluginConfig.
    // TODO: Topic: Compiler plugins: allopen, noarg, serialization.
    // TODO: Return a verifiable result of type String.
    fun exercise5_pluginConfig(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_allopenPlugin().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_noargPlugin().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_serializationPlugin().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_lombokKotlin().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_pluginConfig().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core104_CompilerPlugins exercises passed!")
    }
}
