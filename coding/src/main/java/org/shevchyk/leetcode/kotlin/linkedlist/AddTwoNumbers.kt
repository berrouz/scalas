package org.shevchyk.leetcode.kotlin.linkedlist

fun main() {

    var listA = ListNode(1, ListNode(2, ListNode(3, null)))
    var listB = ListNode(4, ListNode(8, ListNode(6, null)))

    println(listA)
    println(listB)
    println(mergeTwoLists(listA, listB))

}

fun mergeTwoLists(listA: ListNode, listB: ListNode): ListNode? {

    var l1: ListNode? = listA
    var l2: ListNode? = listB
    // just to remember the head
    var dummy: ListNode? = ListNode(0, null)

    var current = dummy;
    var reminder = 0
    while (l1 != null || l2 != null) {
        var sum = 0

        if (l1 != null) {
            sum += l1.`val`
            l1 = l1.next
        }
        if(l2 != null) {
            sum += l2.`val`
            l2 = l2.next
        }

        sum += reminder
        current?.next = ListNode(sum % 10, null)
        reminder = sum / 10
        current = current?.next

        if ( reminder > 0){
            current?.next = ListNode(reminder, null)
        }

    }

    return dummy?.next;
}

class ListNode(var `val`: Int, var next: ListNode?) {

    override fun toString(): String {
        if (next == null) {
            return `val`.toString()
        } else
            return `val`.toString() + " -> " + next!!.toString()
    }
}
