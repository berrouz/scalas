package org.code.leetcode;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, 2);

        assertEquals(result, asList("(())", "()()"));
    }

    private static void backtrack(List<String> results, String current, int open, int closed, int n) {
        if (current.length() / 2 == n) {
            results.add(current);
            return;
        }

        if (open < n) {
            backtrack(results, current + "(", open + 1, closed, n);
        }
        if (closed < open) {
            backtrack(results, current + ")", open, closed + 1, n);
        }

    }
}
