class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalOps = (long) k1 + k2;
        
        long[] count = new long[100001];
        long maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        for (long d = maxDiff; d > 0 && totalOps > 0; d--) {
            if (count[(int) d] == 0) continue;
            
            long take = Math.min(totalOps, count[(int) d]);
            count[(int) d] -= take;
            count[(int) d - 1] += take;
            totalOps -= take;
        }
        
        long finalSum = 0;
        for (int d = 0; d <= 100000; d++) {
            if (count[d] > 0) {
                finalSum += count[d] * (long) d * d;
            }
        }
        
        return finalSum;
    }
}