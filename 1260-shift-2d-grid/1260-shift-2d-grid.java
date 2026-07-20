class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, p = m * n;;
        List<List<Integer>> list = new ArrayList<>();
        int[] arr = new int[p];
        int u = 0;
        
        k %= p;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) arr[u++] = grid[i][j];
        } 

        int v = p - k, t = 0;
        while (t < p) {
            List<Integer> l = new ArrayList<>();
            int r = t % n;
            while (r < n) {
                l.add(arr[v % p]);
                v++; r++;
            } 

            list.add(l);

            t += n;
        } 

        return list;
    }
}