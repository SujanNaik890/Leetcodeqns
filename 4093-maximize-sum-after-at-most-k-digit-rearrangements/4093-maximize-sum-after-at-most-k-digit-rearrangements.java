class Solution {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int[] maxArr = new int[n];
        int[] gain = new int[n];
        
        for (int i = 0; i < n; i++) {
            maxArr[i] = getMaxArrangement(nums[i]);
            gain[i] = maxArr[i] - nums[i];
        }
        
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        
        java.util.Arrays.sort(indices, (a, b) -> Integer.compare(gain[b], gain[a]));
        
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            if (i < k && gain[idx] > 0) {
                totalSum += maxArr[idx];
            } else {
                totalSum += nums[idx];
            }
        }
        
        return totalSum;
    }
    
    private int getMaxArrangement(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        java.util.Arrays.sort(digits);
        int res = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            res = res * 10 + (digits[i] - '0');
        }
        return res;
    }
}