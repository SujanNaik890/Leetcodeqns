import java.util.*;

class Solution {
    class HLD {
        int n, timer;
        List<List<Integer>> adj;
        int[] parent, depth, heavy, head, pos, tree;
        
        public HLD(int n, List<List<Integer>> adj, String s) {
            this.n = n;
            this.adj = adj;
            parent = new int[n];
            depth = new int[n];
            heavy = new int[n];
            head = new int[n];
            pos = new int[n];
            tree = new int[4 * n];
            Arrays.fill(heavy, -1);
            
            dfs1(0, -1, 0);
            timer = 0;
            dfs2(0, 0);
            
            for (int i = 0; i < n; i++) {
                updateTree(1, 0, n - 1, pos[i], 1 << (s.charAt(i) - 'a'));
            }
        }
        
        private int dfs1(int u, int p, int d) {
            parent[u] = p;
            depth[u] = d;
            int size = 1;
            int maxSub = 0;
            for (int v : adj.get(u)) {
                if (v != p) {
                    int sub = dfs1(v, u, d + 1);
                    size += sub;
                    if (sub > maxSub) {
                        maxSub = sub;
                        heavy[u] = v;
                    }
                }
            }
            return size;
        }
        
        private void dfs2(int u, int h) {
            head[u] = h;
            pos[u] = timer++;
            if (heavy[u] != -1) {
                dfs2(heavy[u], h);
            }
            for (int v : adj.get(u)) {
                if (v != parent[u] && v != heavy[u]) {
                    dfs2(v, v);
                }
            }
        }
        
        private void updateTree(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) {
                updateTree(2 * node, start, mid, idx, val);
            } else {
                updateTree(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node] = tree[2 * node] ^ tree[2 * node + 1];
        }
        
        private int queryTree(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return queryTree(2 * node, start, mid, l, r) ^ queryTree(2 * node + 1, mid + 1, end, l, r);
        }
        
        public void update(int u, char c, StringBuilder sb) {
            sb.setCharAt(u, c);
            updateTree(1, 0, n - 1, pos[u], 1 << (c - 'a'));
        }
        
        public boolean query(int u, int v) {
            int res = 0;
            while (head[u] != head[v]) {
                if (depth[head[u]] > depth[head[v]]) {
                    int temp = u;
                    u = v;
                    v = temp;
                }
                res ^= queryTree(1, 0, n - 1, pos[head[v]], pos[v]);
                v = parent[head[v]];
            }
            if (depth[u] > depth[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            res ^= queryTree(1, 0, n - 1, pos[u], pos[v]);
            return (res & (res - 1)) == 0;
        }
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        StringBuilder sb = new StringBuilder(s);
        HLD hld = new HLD(n, adj, s);
        List<Boolean> ans = new ArrayList<>();
        
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                hld.update(u, c, sb);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                ans.add(hld.query(u, v));
            }
        }
        
        return ans;
    }
}