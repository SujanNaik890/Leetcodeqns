class Solution {
    public int dominantIndex(int[] nums) {
        int max=Integer.MIN_VALUE,second=Integer.MIN_VALUE,index=0;

        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                second=max;
                max=nums[i];
                index=i;}
            else if(second <nums[i] && max!=nums[i] ){
                second=nums[i];
            }
        }
        if(max>=(second*2))return index;
        return -1;
    }
}