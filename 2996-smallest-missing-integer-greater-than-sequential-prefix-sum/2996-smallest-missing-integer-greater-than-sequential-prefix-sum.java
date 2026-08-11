class Solution {
    public int missingInteger(int[] nums) {
        boolean[] arr = new boolean[53];
        for(int x:nums){
            arr[x]=true;
        }
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1)sum+=nums[i];
            else break;
        }
        if(sum>52)return sum;
        for(int i=sum;i<=52;i++){
            if(!arr[i])return i;
        }
        return 0;
    }
}