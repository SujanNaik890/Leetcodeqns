class Solution {
    public boolean predictTheWinner(int[] nums) {
        if(nums.length%2==0 || nums.length==1)return true;
        int[] arr = nums.clone();
        for (int i = nums.length - 2; i >= 0; --i) {
            for (int j = i + 1; j < nums.length; ++j) {
                arr[j] = Math.max(nums[i] - arr[j], nums[j] - arr[j - 1]);
            }
        }
        return arr[nums.length - 1] >= 0;
    }
}