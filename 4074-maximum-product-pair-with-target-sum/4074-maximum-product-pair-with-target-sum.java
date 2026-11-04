class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int max=Integer.MIN_VALUE;
        int first=-1,last=-1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    if(nums[i]>nums[j]){
                        int product=nums[i]*nums[j];
                        if(max<product){
                            max=product;
                            first=i;
                            last=j;
                        }
                    }
                }
            }
        }
        return new int[]{first,last};
    }
}