import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int n = nums.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        
        for (int bit = 31; bit >= 0; bit--) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    count++;
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (i < count) {
                    arr[i] |= (1 << bit);
                } else {
                    arr[i] &= ~(1 << bit);
                }
            }
        }
        
        java.util.Arrays.sort(arr);
        
        long totalSum = 0;
        long MOD = 1_000_000_007;
        
        for (int i = n - 1; i >= n - k; i--) {
            long val = arr[i];
            totalSum = (totalSum + (val * val) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}