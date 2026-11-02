class Solution {
    public int maxProfit(int[] nums) {
        int max=0;
        int buy=nums[0];
        for(int i=1;i<nums.length;i++){
           if(buy>nums[i])buy=nums[i];
           int profit=nums[i]-buy;
           if(max < profit)max=profit;
        }
    return max;
    }
}