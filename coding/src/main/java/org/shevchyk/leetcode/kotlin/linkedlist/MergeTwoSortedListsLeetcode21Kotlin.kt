package org.shevchyk.leetcode.kotlin.linkedlist

fun main(args: Array<String>){
    val nodeA = Node(1, Node(2, Node(3, Node(4))))
    val nodeB = Node(5, Node(6, Node(7)))

    println(listOf(nodeB, nodeA))

    println(mergeTwoLists(nodeA, nodeB))

}

fun mergeTwoLists(l1: Node?, l2: Node?): Node? {
    var list1: Node? = l1
    var list2: Node? = l2
    var dummy = Node(0)

    var curr: Node? = dummy

    while (list1 != null && list2 != null) {
        if (list1.`val` < list2.`val`) {
            curr?.next = list1 // which node will be next depending on the comparison
            list1 = list1.next // if we take we should go to the next node
            curr = curr?.next // step to the next node
        } else {
            curr?.next = list2
            list2 = list2.next
            curr = curr?.next
        }
    }

    if (list1 == null) {
        curr?.next = list2
    } else {
        curr?.next = list1
    }
    return dummy.next
}

class Node(var `val`: Int, var next: Node? = null){
    override fun toString(): String {
        if (next == null){
            return `val`.toString()
        } else {
            return `val`.toString() + " -> "  + next.toString()
        }
    }
}
