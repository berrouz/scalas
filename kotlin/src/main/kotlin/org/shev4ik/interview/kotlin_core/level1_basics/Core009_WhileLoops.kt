package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * While and Do-While Loops
 */
object Core009_WhileLoops {

    // Exercise 1: whileBasic
    // TODO: Sum numbers 1..10 using while loop. Return sum.
    fun exercise1_whileBasic(): Int = TODO()

    // Exercise 2: doWhile
    // TODO: Use do-while to find first power of 2 >= 100. Return it.
    fun exercise2_doWhile(): Int = TODO()

    // Exercise 3: breakLoop
    // TODO: Sum numbers 1,2,3,... but break when sum exceeds 20. Return last sum <= 20.
    fun exercise3_breakLoop(): Int = TODO()

    // Exercise 4: continueLoop
    // TODO: Sum numbers 1..10 but skip multiples of 3 using continue. Return sum.
    fun exercise4_continueLoop(): Int = TODO()

    // Exercise 5: labeledBreak
    // TODO: Use labeled break (outer@) to break out of nested loops.
    // TODO: Count iterations of inner loop before breaking when i==2 && j==2.
    fun exercise5_labeledBreak(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_whileBasic() == 55) { "Ex1 failed" }
        assert(exercise2_doWhile() == 128) { "Ex2 failed" }
        assert(exercise3_breakLoop() == 15) { "Ex3 failed" }
        assert(exercise4_continueLoop() == 37) { "Ex4 failed" }
        assert(exercise5_labeledBreak() == 5) { "Ex5 failed" }
        println("All Core009_WhileLoops exercises passed!")
    }
}
