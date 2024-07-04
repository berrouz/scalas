package org.shev4ik.algorithms.leetcode;

public class AnagramTaskMain {
    public static void main(String[] args) {
        System.out.println(compare("monaco", "ocanom"));
    }

    public static Boolean compare(String s1, String s2) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            reversed.append(s1.charAt(i));
        }
        return reversed.toString().equals(s2);
    }
}
