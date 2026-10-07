import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0;
        int rightRem = 0;

        // Step 1: Count minimum '(' and ')' to remove
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, leftRem, rightRem, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int openCount, int leftRem, int rightRem, StringBuilder current, Set<String> result) {
        // Base case: reached the end of the string
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && openCount == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        // Option 1: Remove the character (if it's a bracket and removals are remaining)
        if (c == '(' && leftRem > 0) {
            backtrack(s, index + 1, openCount, leftRem - 1, rightRem, current, result);
        } else if (c == ')' && rightRem > 0) {
            backtrack(s, index + 1, openCount, leftRem, rightRem - 1, current, result);
        }

        // Option 2: Keep the character
        current.append(c);
        if (c != '(' && c != ')') {
            // Regular letter
            backtrack(s, index + 1, openCount, leftRem, rightRem, current, result);
        } else if (c == '(') {
            backtrack(s, index + 1, openCount + 1, leftRem, rightRem, current, result);
        } else if (c == ')' && openCount > 0) {
            // Valid ')' placement
            backtrack(s, index + 1, openCount - 1, leftRem, rightRem, current, result);
        }

        // Backtrack
        current.setLength(len);
    }
}