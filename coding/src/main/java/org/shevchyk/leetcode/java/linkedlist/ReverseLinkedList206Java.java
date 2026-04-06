package org.shevchyk.leetcode.java.linkedlist;

public class ReverseLinkedList206Java {
    public static void main(String[] args) {

        ListNode list = new ListNode(1, new ListNode(2, new ListNode(3, null)));

        System.out.println(list);

        System.out.println(reverse(list));
    }

    static ListNode reverse(ListNode head) {
        var current = head;
        ListNode prev = null;
        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }




    static class ListNode {
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        int val;
        ListNode next;

        @Override
        public String toString() {
            if (next == null) {
                return String.valueOf(val);
            } else {
                return val + " -> " + next;
            }
        }
    }
}
