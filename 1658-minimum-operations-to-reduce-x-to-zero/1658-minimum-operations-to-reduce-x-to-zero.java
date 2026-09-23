class Solution {
    public int minOperations(int[] nums, int x) {
       int sum=0;
       for(int i:nums){
        sum+=i;
       }
       int target=sum-x;
       if(target==0)return nums.length;
       if(target<0)return -1;

       int maxLen=-1,left=0,currentsum=0;
       for(int right=0;right<nums.length;right++){
            currentsum+=nums[right];
            while(left<=right && currentsum>target){
                currentsum-=nums[left];
                left++;
            }
            if(currentsum==target){
                maxLen=Math.max(maxLen,right-left+1);
            }

       }
       return maxLen==-1 ? -1 :nums.length-maxLen;
    }
}