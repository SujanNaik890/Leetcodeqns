class Solution {
     public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] dist = buildDistance(grid, n);

        int low = 0;
        int high = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                high = Math.max(high, dist[i][j]);
            }
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private int[][] buildDistance(List<List<Integer>> grid, int n) {
        int[][] dist = new int[n][n];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    dist[newRow][newCol] == -1) {

                    dist[newRow][newCol] = dist[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return dist;
    }

    private boolean canReach(int[][] dist, int safeValue, int n) {
        if (dist[0][0] < safeValue) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] dirs = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            if (row == n - 1 && col == n - 1) {
                return true;
            }

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol] &&
                    dist[newRow][newCol] >= safeValue) {

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return false;
    }
}