class Solution {
    public int dayOfYear(String s) {
        int[] m = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int y=Integer.parseInt(s.substring(0, 4));
        boolean tell=(y%400==0||(y%4==0&&y%100!=0));
         int a=s.charAt(5)-'0';
         a=a*10+s.charAt(6)-'0';
         int b=s.charAt(8)-'0';
         b=b*10+s.charAt(9)-'0';
         if(tell&&a>2) return m[a-1]+b+1;
         return m[a-1]+b;
    }
}