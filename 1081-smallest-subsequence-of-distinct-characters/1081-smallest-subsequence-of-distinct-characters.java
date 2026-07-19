// class Solution {
//     public String smallestSubsequence(String s) {
        //  int[] last = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     last[s.charAt(i) - 'a'] = i;
        // }
        // boolean[] visited = new boolean[26];
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //   char ch = s.charAt(i);
        //     if (visited[ch - 'a'])
        //         continue;
        //     while (!stack.isEmpty()
        //             && ch < stack.peek()
        //             && last[stack.peek() - 'a'] > i) {
        //         visited[stack.pop() - 'a'] = false;
        //     }
        //     stack.push(ch);
        //     visited[ch - 'a'] = true;
        // }
        // StringBuilder ans = new StringBuilder();
        // for (char c : stack)
        //     ans.append(c);
        // return ans.toString(); 
class Solution {
    public String smallestSubsequence(String text) { 
        StringBuilder sb = new StringBuilder(); 
        int[] count = new int[128];
        boolean[] used = new boolean[128]; 
        for (final char c : text.toCharArray()) ++count[c]; 
        for (final char c : text.toCharArray()) {
             --count[c]; if (used[c]) continue;
              while (sb.length() > 0 && last(sb) > c && count[last(sb)] > 0) { 
                used[last(sb)] = false;
                sb.setLength(sb.length() - 1);
            } 
            used[c] = true; 
            sb.append(c); 
        } return sb.toString();
     } 
     private char last(StringBuilder sb) { 
        return sb.charAt(sb.length() - 1); 
    }
}
     
             
    
