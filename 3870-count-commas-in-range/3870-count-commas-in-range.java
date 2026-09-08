class Solution {
    public int countCommas(int n) {
        int res=0;
        int coma=n-999;
        if(coma > 0)res+=coma;
        return res;
       }
}