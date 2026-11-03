class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        
        int r = 0, c = 0;
        visited[0] = true;
        
        while (true) {
            int nextR = r;
            int nextC = c;
            
            char dir = grid[r][c];
            if (dir == 'L') nextC--;
            else if (dir == 'R') nextC++;
            else if (dir == 'U') nextR--;
            else if (dir == 'D') nextR++;
            
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n) {
                return new int[] { r, c };
            }
            
            int nextIdx = nextR * n + nextC;
            if (visited[nextIdx]) {
                return new int[] { r, c };
            }
            
            r = nextR;
            c = nextC;
            visited[nextIdx] = true;
        }
    }
}