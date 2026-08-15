class Solution {
    public int longestSubsequence(int[] nums) {
        int longseq=0;
        boolean nonzero=false;
        for(int x:nums){
            nonzero|=x>0;
            longseq^=x;
        }//HAPPY INDEPENDANCE DAY
        if(!nonzero)return 0;
        return longseq==0? nums.length-1:nums.length;
    }
}