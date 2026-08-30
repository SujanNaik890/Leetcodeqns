class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.isEmpty()) return ans;

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");

        for (int i = 0; i < digits.length(); i++) {
            int d = digits.charAt(i) - '0';
            while (ans.peek().length() == i) {
                String prefix = ans.remove();
                for (char c : map[d].toCharArray()) {
                    ans.add(prefix + c);
                }
            }
        }
        return ans;
    }
}