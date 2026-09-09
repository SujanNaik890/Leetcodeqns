class Solution {
    public long countCommas(long n) {
        long ans=0;
        long cnt=1000;
        while(n>=cnt){
            ans+=n-cnt+1;
            cnt *=1000;
        }
        return ans;
    }
}