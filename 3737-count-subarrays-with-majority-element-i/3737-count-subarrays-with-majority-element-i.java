class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
    int[] k=new int[1000];
        int count=0;
        for(int i=0;i<nums.length;i++){
            int targetcount=0;
            for(int j=i;j<nums.length;j++){
                int length=j-i+1;
                k[j]=nums[j];
                if(nums[j]==target)targetcount++;
                if(targetcount>length/2)count++;
            }
        }return count;
    }
}