package org.shevchyk.leetcode.java.strings;

public class ValidPalindromeLeetcode125Java {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome(" Abba"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("1"));
    }

    public static boolean isPalindrome(String s) {
        String c = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").trim();
        for (int i = 0; i < c.length() / 2; i++) {
            if (c.charAt(i) != c.charAt(c.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
