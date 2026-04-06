package org.shevchyk.leetcode.java.linkedlist;

public class MergeTwoSortedListsLeetcode21Java {

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode listNodeB = new ListNode(4, new ListNode(5, new ListNode(6, null)));

        System.out.println(listNodeA);
        System.out.println(listNodeB);
        System.out.println(mergeTwoLists(listNodeA, listNodeB));

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(0, null);

        ListNode head = curr;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }

        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x, ListNode next) {
            this.val = x;
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
