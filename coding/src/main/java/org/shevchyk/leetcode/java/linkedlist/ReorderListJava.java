package org.shevchyk.leetcode.java.linkedlist;

public class ReorderListJava {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));

        System.out.println(reorderList(head));
        System.out.println(head);
    }
    public static ListNode reorderList(ListNode head) {
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

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
