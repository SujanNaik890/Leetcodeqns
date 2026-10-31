class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;
        int[][][] go = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = i, c = j, dir = 0; // 0: right, 1: down
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    if (dir == 0) {
                        dir = 1;
                        r += 1; // move down
                    } else {
                        dir = 0;
                        c += 1; // move right
                    }
                }
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    go[i][j][0] = r * n + c;
                } else {
                    go[i][j][0] = -1;
                }

                r = i; c = j; dir = 1;
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    if (dir == 0) {
                        dir = 1;
                        r += 1;
                    } else {
                        dir = 0;
                        c += 1;
                    }
                }
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    go[i][j][1] = r * n + c;
                } else {
                    go[i][j][1] = -1;
                }
            }
        }

        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                if (j + 1 < n) {
                    int target = go[i][j + 1][0];
                    if (target != -1) {
                        int nx = target / n;
                        int ny = target % n;
                        dp[nx][ny] = (dp[nx][ny] + dp[i][j]) % MOD;
                    }
                }

                if (i + 1 < m) {
                    int target = go[i + 1][j][1];
                    if (target != -1) {
                        int nx = target / n;
                        int ny = target % n;
                        dp[nx][ny] = (dp[nx][ny] + dp[i][j]) % MOD;
                    }
                }
            }
        }

        return (int) dp[m - 1][n - 1];
    }
}