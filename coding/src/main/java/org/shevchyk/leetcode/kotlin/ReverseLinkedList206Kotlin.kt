package org.shevchyk.leetcode.kotlin

object ReverseLinkedList206Kotlin {

    @JvmStatic
    fun main(args: Array<String>){

        var node: LinkedNode = LinkedNode(1, LinkedNode(2, LinkedNode(3)))
        println(node)

        println(reverse(node))
    }

    fun reverse(head: LinkedNode?): LinkedNode? {
        var current = head
        var prev: LinkedNode? = null
        while (current != null){
            var next = current.next
            current?.next = prev

            prev = current
            current = next

        }
        return prev
    }

    class LinkedNode(var `val`: Int, var next: LinkedNode? = null){
        override fun toString(): String {
            if (next != null){
                return `val`.toString() + " -> " + next.toString()
            } else {
                return `val`.toString()
            }
        }
    }
}