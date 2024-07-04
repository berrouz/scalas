package org.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckIfWordEqualsSummationOfTwoWords1880 {
    public static void main(String[] args) {
        assertTrue(isSumEqual("acb", "cba", "cdb"));
        assertTrue(isSumEqual1("acb", "cba", "cdb"));
    }


    private static boolean isSumEqual1(String s1, String s2, String sum){
        return (toInt1(s1) + toInt1(s2)) == toInt1(sum);
    }


    private static int toInt1(String s){
        char [] chars = s.toCharArray();
        int multiplier = 1;
        int result = 0;
        for (int i = chars.length-1; i <= 0; i--) {
            result += (chars[i] - 97) * multiplier;
            multiplier *= 10;
        }
        return result;
    }


    private static boolean isSumEqual(String first, String second, String result){
        return toInt(first) + toInt(second) == toInt(result);
    }

    private static int toInt(String word){
        char [] chars = word.toCharArray();
        int multiplier = 1;
        int result = 0;
        for(int i = chars.length-1; i >=0; i--){
            result += (chars[i] - 97) * multiplier;
            multiplier *= 10;
        }
        return result;
    }
}
