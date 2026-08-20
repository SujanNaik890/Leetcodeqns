class Solution {
    public int[] resultArray(int[] nums) {
        int[] arr1=new int[nums.length];
        int[] arr2=new int[nums.length];
        int k=0,j=0;
        arr1[k]=nums[0];
        arr2[j]=nums[1];
        for(int i=2;i<nums.length;i++){
            if(arr1[k]>arr2[j])arr1[++k]=nums[i];
            else if(arr1[k]<arr2[j])arr2[++j]=nums[i];
        }
        int i=0;
        while(k<nums.length-1){
            arr1[++k]=arr2[i++];
        }
        return arr1;
    }
}