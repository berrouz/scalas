package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Class Delegation with by
 */
object Core048_DelegationPattern {

    // Exercise 1: interfaceDelegation
    // TODO: Create interface Printer { fun print(): String }. Create class ConsolePrinter : Printer { return "console" }.
    // TODO: Create class DelegatingPrinter(p: Printer) : Printer by p.
    // TODO: Return DelegatingPrinter(ConsolePrinter()).print().
    fun exercise1_interfaceDelegation(): String = TODO()

    // Exercise 2: overrideDelegation
    // TODO: Create DelegatingPrinter(p: Printer) : Printer by p but override print() to return "overridden".
    // TODO: Return result.
    fun exercise2_overrideDelegation(): String = TODO()

    // Exercise 3: multipleDelegation
    // TODO: Create interfaces A { fun a(): String } and B { fun b(): String }.
    // TODO: Create class C(a: A, b: B) : A by a, B by b.
    // TODO: Return Pair(c.a(), c.b()).
    fun exercise3_multipleDelegation(): Pair<String, String> = TODO()

    // Exercise 4: decoratorPattern
    // TODO: Create LoggingPrinter(p: Printer) : Printer by p that wraps: "LOG: " + p.print().
    // TODO: Return result wrapping ConsolePrinter.
    fun exercise4_decoratorPattern(): String = TODO()

    // Exercise 5: composedBehavior
    // TODO: Create interface Counter { fun count(): Int }. SimpleCounter returns 1.
    // TODO: Create DoubleCounter(c: Counter) : Counter by c overriding count() = c.count() * 2.
    // TODO: Return DoubleCounter(SimpleCounter()).count().
    fun exercise5_composedBehavior(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_interfaceDelegation() == "console") { "Exercise 1 failed" }
        assert(exercise2_overrideDelegation() == "overridden") { "Exercise 2 failed" }
        assert(exercise3_multipleDelegation() == Pair("A", "B")) { "Exercise 3 failed" }
        assert(exercise4_decoratorPattern() == "LOG: console") { "Exercise 4 failed" }
        assert(exercise5_composedBehavior() == 2) { "Exercise 5 failed" }
        println("All Core048_DelegationPattern exercises passed!")
    }
}
