import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        int[][] intervals = new int[n][4];
        for (int i = 0; i < n; i++) {
            List<Integer> row = intervalsList.get(i);
            intervals[i][0] = row.get(0);
            intervals[i][1] = row.get(1);
            intervals[i][2] = row.get(2);
            intervals[i][3] = i;
        }

        // Sort by right endpoint; tie-break by left endpoint, then original index
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[3], b[3]);
        });

        long[][] dpWeight = new long[5][n + 1];
        int[][][] dpIndices = new int[5][n + 1][];

        for (int k = 0; k <= 4; k++) {
            for (int i = 0; i <= n; i++) {
                dpIndices[k][i] = new int[0];
            }
        }

        for (int i = 0; i < n; i++) {
            int l = intervals[i][0];
            int w = intervals[i][2];
            int id = intervals[i][3];

            // Binary search: find rightmost interval mid where intervals[mid][1] < l
            int low = 0, high = i - 1, pred = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (intervals[mid][1] < l) {
                    pred = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip
                long bestW = dpWeight[k][i];
                int[] bestIdx = dpIndices[k][i];

                // Option 2: Take
                long takeW = dpWeight[k - 1][pred + 1] + w;
                int[] prevIdx = dpIndices[k - 1][pred + 1];

                int[] takeIdx = new int[prevIdx.length + 1];
                int pos = 0;
                while (pos < prevIdx.length && prevIdx[pos] < id) {
                    takeIdx[pos] = prevIdx[pos];
                    pos++;
                }
                takeIdx[pos] = id;
                for (int j = pos; j < prevIdx.length; j++) {
                    takeIdx[j + 1] = prevIdx[j];
                }

                if (isBetter(takeW, takeIdx, bestW, bestIdx)) {
                    bestW = takeW;
                    bestIdx = takeIdx;
                }

                dpWeight[k][i + 1] = bestW;
                dpIndices[k][i + 1] = bestIdx;
            }
        }

        long maxW = -1;
        int[] ans = new int[0];
        for (int k = 1; k <= 4; k++) {
            if (isBetter(dpWeight[k][n], dpIndices[k][n], maxW, ans)) {
                maxW = dpWeight[k][n];
                ans = dpIndices[k][n];
            }
        }

        return ans;
    }

    private boolean isBetter(long w1, int[] idx1, long w2, int[] idx2) {
        if (w1 != w2) {
            return w1 > w2;
        }
        if (idx1.length == 0) return false;
        if (idx2.length == 0) return true;
        int len = Math.min(idx1.length, idx2.length);
        for (int i = 0; i < len; i++) {
            if (idx1[i] != idx2[i]) {
                return idx1[i] < idx2[i];
            }
        }
        return idx1.length < idx2.length;
    }
}