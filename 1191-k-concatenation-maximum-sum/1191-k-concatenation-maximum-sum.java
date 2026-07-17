class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
       long MOD = 1000000007;
        if (k == 1) {
            return (int)(kadane(arr) % MOD);
        }
        long totalSum = 0;
        for (int num : arr)
            totalSum += num;

        long maxSum = kadaneTwo(arr);

        if (totalSum > 0) {
            maxSum += (long)(k - 2) * totalSum;
        }

        return (int)(maxSum % MOD);
    }

    private long kadane(int[] arr) {
        long curr = 0, best = 0;

        for (int num : arr) {
            curr = Math.max(0, curr + num);
            best = Math.max(best, curr);
        }

        return best;
    }

    private long kadaneTwo(int[] arr) {
        long curr = 0, best = 0;
        int n = arr.length;

        for (int i = 0; i < 2 * n; i++) {
            curr = Math.max(0, curr + arr[i % n]);
            best = Math.max(best, curr);
        }

        return best;
    }
}