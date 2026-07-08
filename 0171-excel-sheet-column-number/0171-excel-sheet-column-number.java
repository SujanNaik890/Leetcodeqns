class Solution {
    public int titleToNumber(String s) {
        int col=0;
        for(int i=0;i<s.length();i++)
            col=col*26 +(s.charAt(i)-'A' +1);
        return col;
    }
}