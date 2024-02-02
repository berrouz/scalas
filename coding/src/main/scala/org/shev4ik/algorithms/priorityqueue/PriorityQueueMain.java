package org.shev4ik.algorithms.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer("b");
        queue.offer("c");
        queue.offer("a");
        queue.offer("f");
        queue.offer("d");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
