class Solution {
    public int maxSubarraySumCircular(int[] nums) {
     int totalSum = 0;
        int maxSum = nums[0];
        int currMax = 0;
        int minSum = nums[0];
        int currMin = 0;
        for (int num : nums) {
            currMax += num;
            maxSum = Math.max(maxSum, currMax);
            if (currMax < 0)
                currMax = 0;
            currMin += num;
            minSum = Math.min(minSum, currMin);
            if (currMin > 0)
                currMin = 0;

            totalSum += num;
        }

        if (maxSum < 0)
            return maxSum;
 return Math.max(maxSum, totalSum - minSum);  }
}