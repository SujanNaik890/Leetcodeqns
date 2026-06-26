import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        if (m == 0) {
            return n - 1;
        }
         Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));
        restrictions[0][1] = Math.min(restrictions[0][1], restrictions[0][0] - 1);
        for (int i = 1; i < m; i++) {
            int maxAllowedFromLeft = restrictions[i - 1][1] + (restrictions[i][0] - restrictions[i - 1][0]);
            if (restrictions[i][1] > maxAllowedFromLeft) {
                restrictions[i][1] = maxAllowedFromLeft;
            }
        }
         for (int i = m - 2; i >= 0; i--) {
            int maxAllowedFromRight = restrictions[i + 1][1] + (restrictions[i + 1][0] - restrictions[i][0]);
            if (restrictions[i][1] > maxAllowedFromRight) {
                restrictions[i][1] = maxAllowedFromRight;
            }
        }

        int maxTallestBuilding = 0;

         maxTallestBuilding = Math.max(maxTallestBuilding, (0 + restrictions[0][1] + restrictions[0][0] - 1) / 2);

        for (int i = 1; i < m; i++) {
            int posA = restrictions[i - 1][0];
            int hA = restrictions[i - 1][1];
            int posB = restrictions[i][0];
            int hB = restrictions[i][1];

            int currentPeak = (hA + hB + (posB - posA)) / 2;
            if (currentPeak > maxTallestBuilding) {
                maxTallestBuilding = currentPeak;
            }
        }
         int lastPos = restrictions[m - 1][0];
        int lastH = restrictions[m - 1][1];
        int finalEndPeak = lastH + (n - lastPos);
        if (finalEndPeak > maxTallestBuilding) {
            maxTallestBuilding = finalEndPeak;
        }

        return maxTallestBuilding;
    }
}