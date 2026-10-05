class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int innerScore = stack.pop();
                int currentScore = stack.pop();
                stack.push(currentScore + Math.max(2 * innerScore, 1));
            }
        }

        return stack.pop();
    }
}