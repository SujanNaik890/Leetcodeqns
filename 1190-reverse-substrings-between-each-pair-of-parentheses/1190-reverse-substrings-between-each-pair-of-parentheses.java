class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb =new StringBuilder();
        Deque <Integer> stack=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch=='(')stack.push(sb.length());
            else if(ch==')'){
                int n=stack.pop();
                
                reverse(sb,n,sb.length()-1);
            }else sb.append(ch);
        }
        return sb.toString();
    }
    static void reverse (StringBuilder sb,int left,int right){
        while(left<right){
            char temp=sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,temp);
            left++;
            right--;
        }
    }
}