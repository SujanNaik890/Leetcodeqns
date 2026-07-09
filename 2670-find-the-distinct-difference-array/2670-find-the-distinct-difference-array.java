class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] prefix=new int[nums.length];
        int[] suffix=new int[nums.length];
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            prefix[i]=set.size();
        }
        set.clear();
        for(int i=nums.length-1;i>=0;i--){
            suffix[i]=set.size();
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            prefix[i]-=suffix[i];
        }
        return prefix;
    }
}