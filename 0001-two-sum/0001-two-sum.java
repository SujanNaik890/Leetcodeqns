class Solution {
    public int[] twoSum(int[] nums, int t) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            for(int j=0;j+i<n;j++){
                if((nums[i+j]+nums[j])==t){
                    return new int[]{j,j+i};
                }
            }
        }
        return new int[]{};
    }
}