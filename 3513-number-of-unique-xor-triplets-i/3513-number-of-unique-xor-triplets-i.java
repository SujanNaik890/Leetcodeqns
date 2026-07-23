class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length<=2)return nums.length;
        int mask=0;
        for(int num:nums){
            mask|=num;
        }
        return mask+1;
    }
}