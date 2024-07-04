package org.code.leetcode;


import org.junit.jupiter.api.Assertions;

public class ReverseString344 {
    public static void main(String[] args) {
        Assertions.assertEquals(reverse("Monaco"), "ocanoM");
        Assertions.assertEquals(reverse("Hol"), "loH");

    }

    private static String reverse(String s){
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start ++;
            end --;
        }
        return new String(chars);
    }
}
