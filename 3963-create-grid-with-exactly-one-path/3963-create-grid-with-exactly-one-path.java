class Solution {
    public String[] createGrid(int m, int n) {
        StringBuilder[] grid = new StringBuilder[m];
        
        for (int i = 0; i < m; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('#');
            }
            grid[i] = row;
        }
        
        for (int j = 0; j < n; j++) {
            grid[0].setCharAt(j, '.');
        }
        for (int i = 0; i < m; i++) {
            grid[i].setCharAt(n - 1, '.');
        }
        
        
        String[] result = new String[m];
        for (int i = 0; i < m; i++) {
            result[i] = grid[i].toString();
        }
        
        return result;
    }
}