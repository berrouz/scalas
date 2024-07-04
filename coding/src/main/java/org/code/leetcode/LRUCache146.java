package org.code.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        System.out.println(cache.map.size());
        System.out.println(cache.map.values());
    }

    static class LRUCache {
        final Node head;
        final Node tail;
        final int capacity;
        final Map<Integer, Node> map;

        static class Node {
            private Node next;
            private Node prev;
            private int key;
            private int value;
        }

        public LRUCache(int capacity){
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.head = new Node();
            this.tail = new Node();
            this.head.next = tail;
            this.tail.prev = head;
        }


        public int get(int key){
            Node node = map.get(key);
            if (node == null){
                return -1;
            } else {
                delete(node);
                add(node);
                return node.value;
            }
        }

        public void put(int key, int value){
            Node node = map.get(key);
            if (node == null){
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                if (capacity == map.size()){
                    map.remove(tail.prev.key);
                    delete(tail.prev);
                }
                add(newNode);
                map.put(key, newNode);
            } else {
                node.value = value;
                delete(node);
                add(node);
            }
        }

        private void delete(Node node){
            Node next = node.next;
            Node prev = node.prev;

            prev.next = next;
            next.prev = prev;
        }

        private void add(Node node){
            node.prev = this.tail;
            this.tail.next = node;
        }
    }
}
