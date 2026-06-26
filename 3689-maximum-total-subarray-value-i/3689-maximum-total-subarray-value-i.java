class Solution {
    public long maxTotalValue(int[] nums, int k) {
           int minValue = Integer.MAX_VALUE;

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            minValue = Math.min(minValue, nums[i]);

            maxValue = Math.max(maxValue, nums[i]);

        }

        return (long) (maxValue - minValue) * k;
    }
}