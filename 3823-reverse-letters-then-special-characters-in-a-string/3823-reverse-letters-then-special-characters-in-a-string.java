class Solution {
    public String reverseByType(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                stack1.push(ch);
            }
            else{
                stack2.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(stack1.pop());
            }
            else sb.append(stack2.pop());
        }
        return sb.toString();
    }
}