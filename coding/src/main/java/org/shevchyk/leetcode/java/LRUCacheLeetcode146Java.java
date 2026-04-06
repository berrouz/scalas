package org.shevchyk.leetcode.java;

import org.scalatest.wordspec.AnyWordSpec;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLeetcode146Java extends AnyWordSpec {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


    static class LRUCache {
        private int capacity;
        private Map<Integer, Node> map;

        Node head, tail;


        // head -> tail
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.head = new Node();
            this.tail = new Node();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            var node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                delete(node);
                add(node);
                return node.value;
            }
        }

        // head -> node -> tail
        private void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // head -> elem -> tail
        private void add(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            head.next.prev = node;
            head.next = node;

            map.put(node.key, node);
        }

        public void put(int key, int value) {
            var existing = map.get(key);
            if (existing == null) {
                if (map.size() == capacity) {
                    delete(tail.prev);
                    map.remove(tail.prev.key);
                }
                var node = new Node(key, value);
                map.put(key, node);
                add(node);
            } else {
                existing.value = value;
                delete(existing);
                add(existing);
            }
        }

        static class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {}

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
