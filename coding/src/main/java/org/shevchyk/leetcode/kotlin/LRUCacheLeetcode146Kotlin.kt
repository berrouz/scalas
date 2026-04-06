package org.shevchyk.leetcode.kotlin

fun main(args: Array<String>) {
    val cache = LruCache(2)

    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)

    println(cache.get(1))
    println(cache.get(2))
    println(cache.get(3))
    cache.put(4, 4)
    println(cache.get(3))
    println(cache.get(4))

}

class LruCache(var capacity: Int) {
    var head: Node = Node(0, 0)
    var tail: Node = Node(0, 0)
    var map: MutableMap<Int, Node> = mutableMapOf()

    init {
        head.next = tail;
        tail.prev = head;
    }


    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            val found = map[key]!!
            remove(found)
            add(found)
            return found.value
        } else {
            return -1
        }
    }

    private fun add(node: Node) {
        var next = head.next

        head.next = node
        node.prev = head
        node.next = next
        next?.prev = node

        map[node.key] = node
    }

    fun put(key: Int, value: Int) {
        var existing = map[key]
        if (existing == null) {
            if (map.size == capacity) {
                remove(tail.prev!!)
            }
            var newNode = Node(key, value)
            add(newNode)
        } else {
            existing.value = value
            remove(existing)
            add(existing)
        }
    }

    fun remove(node: Node) {
        var prev = node.prev
        var next = node.next

        prev?.next = next
        next?.prev = prev

        map.remove(node.key)
    }

    class Node(var key: Int, var value: Int) {
        var next: Node? = null
        var prev: Node? = null
    }
}
