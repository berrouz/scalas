package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Inline Functions
 */
object Core043_InlineFunctions {

    // Exercise 1: inlineBasic
    // TODO: Write inline fun <T> runBlock(block: () -> T): T = block().
    // TODO: Return runBlock { 42 }.
    fun exercise1_inlineBasic(): Int = TODO()

    // Exercise 2: inlineMeasure
    // TODO: Write inline fun measureTime(block: () -> Unit): Long that returns
    // TODO: System.nanoTime() difference. Return measureTime { Thread.sleep(1) } > 0.
    fun exercise2_inlineMeasure(): Boolean = TODO()

    // Exercise 3: noinlineParam
    // TODO: Write inline fun twoBlocks(inlined: () -> Int, noinline stored: () -> Int): Pair<Int, Int>.
    // TODO: Return Pair(inlined(), stored()). Call with { 1 } and { 2 }.
    fun exercise3_noinlineParam(): Pair<Int, Int> = TODO()

    // Exercise 4: nonLocalReturn
    // TODO: Write inline fun findFirst(list: List<Int>, pred: (Int) -> Boolean): Int.
    // TODO: Use non-local return from lambda. Find first even in listOf(1,3,4,5). Return it.
    fun exercise4_nonLocalReturn(): Int = TODO()

    // Exercise 5: crossinlineDemo
    // TODO: Write inline fun wrap(crossinline block: () -> String): () -> String = { "[${block()}]" }.
    // TODO: Return wrap { "hello" }().
    fun exercise5_crossinlineDemo(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_inlineBasic() == 42) { "Exercise 1 failed" }
        assert(exercise2_inlineMeasure() == true) { "Exercise 2 failed" }
        assert(exercise3_noinlineParam() == Pair(1, 2)) { "Exercise 3 failed" }
        assert(exercise4_nonLocalReturn() == 4) { "Exercise 4 failed" }
        assert(exercise5_crossinlineDemo() == "[hello]") { "Exercise 5 failed" }
        println("All Core043_InlineFunctions exercises passed!")
    }
}
