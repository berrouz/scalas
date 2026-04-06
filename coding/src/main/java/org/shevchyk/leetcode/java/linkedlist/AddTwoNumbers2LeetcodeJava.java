package org.shevchyk.leetcode.java.linkedlist;

public class AddTwoNumbers2LeetcodeJava {
    public static void main(String[] args) {

        var list1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        var list2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(addTwoNumbers(list1, list2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var list1 = l1;
        var list2 = l2;
        var dummy = new ListNode(0, null);
        var current = dummy;
        var reminder = 0;
        while (list1 != null || list2 != null) {
            var sum = 0;
            if (list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }
            sum += reminder;

            current.next = new ListNode(sum % 10, null);
            reminder = sum / 10;
            current = current.next;

        }
        return dummy.next;

    }

    static class ListNode {
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
