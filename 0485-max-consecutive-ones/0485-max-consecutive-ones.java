class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxlen=0,len=0;
        if(nums.length==1)return nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                len++;
                maxlen=Math.max(maxlen,len);
            }
            else{
                len=0;
            }
        }
        return maxlen;
    }
}