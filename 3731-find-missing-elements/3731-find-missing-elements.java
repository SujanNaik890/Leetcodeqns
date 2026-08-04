class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList<>();
        int left=nums[0];
        for(int i=0;i<nums.length;left++,i++){
            if(left<nums[i]){
                list.add(left);
                i--;
            }
        }
        return list;
    }
}