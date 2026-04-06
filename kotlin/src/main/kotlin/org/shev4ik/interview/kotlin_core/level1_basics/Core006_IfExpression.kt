package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * If as Expression
 */
object Core006_IfExpression {

    // Exercise 1: ifExpression
    // TODO: Use if as expression: if (10 > 5) "greater" else "lesser". Return result.
    fun exercise1_ifExpression(): String = TODO()

    // Exercise 2: ifElseChain
    // TODO: Given val score = 85, return grade: >=90 -> "A", >=80 -> "B",
    // TODO: >=70 -> "C", else -> "F".
    fun exercise2_ifElseChain(): String = TODO()

    // Exercise 3: nestedIf
    // TODO: Return the max of three numbers: 15, 27, 9 using nested if expressions.
    fun exercise3_nestedIf(): Int = TODO()

    // Exercise 4: ifWithBlock
    // TODO: Use if-else blocks where each block has multiple statements.
    // TODO: if (true) { val a=10; val b=20; a+b } else { 0 }. Return result.
    fun exercise4_ifWithBlock(): Int = TODO()

    // Exercise 5: conditionalAssignment
    // TODO: Assign val status = if (100 > 50) "high" else "low".
    // TODO: Assign val label = if (status == "high") "above" else "below".
    // TODO: Return Pair(status, label).
    fun exercise5_conditionalAssignment(): Pair<String, String> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_ifExpression() == "greater") { "Ex1 failed" }
        assert(exercise2_ifElseChain() == "B") { "Ex2 failed" }
        assert(exercise3_nestedIf() == 27) { "Ex3 failed" }
        assert(exercise4_ifWithBlock() == 30) { "Ex4 failed" }
        assert(exercise5_conditionalAssignment() == Pair("high", "above")) { "Ex5 failed" }
        println("All Core006_IfExpression exercises passed!")
    }
}
