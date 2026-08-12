class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int j=0,ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[i])>k){
               map.put(nums[j],map.get(nums[j])-1);
               j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}