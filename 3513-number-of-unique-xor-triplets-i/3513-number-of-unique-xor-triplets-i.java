class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // if(nums.length<=2)return nums.length;
        // int mask=0;
        // for(int num:nums){
        //     mask|=num;
        // }
        // return mask+1;

        int n = nums.length;
        
        return 1 << (32 - Integer.numberOfLeadingZeros(n) - 3 / (n + 1));
    

    }
}