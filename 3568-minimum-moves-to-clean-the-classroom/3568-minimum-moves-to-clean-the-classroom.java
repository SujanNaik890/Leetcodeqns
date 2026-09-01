import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    startR = r;
                    startC = c;
                } else if (ch == 'L') {
                    litterIndex[r][c] = litterCount++;
                }
            }
        }
        
        // If there is no litter to collect, 0 moves are needed
        if (litterCount == 0) return 0;
        
        int targetMask = (1 << litterCount) - 1;
        
        // bestEnergy[r][c][mask] stores the maximum remaining energy seen for that state
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int[][] mat : bestEnergy) {
            for (int[] arr : mat) {
                Arrays.fill(arr, -1);
            }
        }
        
        // State: [row, col, mask, current_energy, moves]
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR, startC, 0, energy, 0});
        bestEnergy[startR][startC][0] = energy;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int e = curr[3];
            int moves = curr[4];
            
            if (mask == targetMask) {
                return moves;
            }
            
            // If out of energy, no further moves can be made
            if (e == 0) continue;
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Bounds and obstacle check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || classroom[nr].charAt(nc) == 'X') {
                    continue;
                }
                
                int nextMask = mask;
                int nextEnergy = e - 1;
                char cell = classroom[nr].charAt(nc);
                
                if (cell == 'L') {
                    nextMask |= (1 << litterIndex[nr][nc]);
                } else if (cell == 'R') {
                    nextEnergy = energy; // Full refill
                }
                
                // Prune states visited with equal or less energy
                if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                    bestEnergy[nr][nc][nextMask] = nextEnergy;
                    queue.offer(new int[]{nr, nc, nextMask, nextEnergy, moves + 1});
                }
            }
        }
        
        return -1;
    }
}