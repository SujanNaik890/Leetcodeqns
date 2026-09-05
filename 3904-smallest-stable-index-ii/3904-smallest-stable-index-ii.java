class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] suff=new int[nums.length];
        suff[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            suff[i]=Math.min(nums[i],suff[i+1]);
        }

        int pmax=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            pmax=Math.max(pmax,nums[i]);
            if(pmax-suff[i] <=k )return i;
        }
    return -1;
    }

}