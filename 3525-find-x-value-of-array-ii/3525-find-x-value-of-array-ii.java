class Solution {
    static class Node {
        int prod;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }

    private Node[] tree;
    private int[] a;
    private int n;
    private int k;

    private Node merge(Node left, Node right) {
        Node res = new Node(k);
        res.prod = (int) ((1L * left.prod * right.prod) % k);

        for (int r = 0; r < k; r++) {
            res.count[r] = left.count[r];
        }
        for (int r = 0; r < k; r++) {
            int newRem = (int) ((1L * left.prod * r) % k);
            res.count[newRem] += right.count[r];
        }
        return res;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(k);
            int rem = a[l] % k;
            tree[node].prod = rem;
            tree[node].count[rem] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            int rem = val % k;
            tree[node].prod = rem;
            for (int i = 0; i < k; i++) tree[node].count[i] = 0;
            tree[node].count[rem] = 1;
            return;
        }
        int mid = (l + r) >> 1;
        if (idx <= mid) {
            update(node * 2, l, mid, idx, val);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    static class QueryState {
        int currentProd = 1;
        int matchCount = 0;
    }

    private void queryRange(int node, int l, int r, int ql, int qr, int targetX, QueryState state) {
        if (ql <= l && r <= qr) {
            for (int rem = 0; rem < k; rem++) {
                if ((1L * state.currentProd * rem) % k == targetX) {
                    state.matchCount += tree[node].count[rem];
                }
            }
            state.currentProd = (int) ((1L * state.currentProd * tree[node].prod) % k);
            return;
        }

        int mid = (l + r) >> 1;
        if (ql <= mid) {
            queryRange(node * 2, l, mid, ql, qr, targetX, state);
        }
        if (qr > mid) {
            queryRange(node * 2 + 1, mid + 1, r, ql, qr, targetX, state);
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        this.a = nums;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1);

        int qLen = queries.length;
        int[] ans = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);

            QueryState state = new QueryState();
            queryRange(1, 0, n - 1, start, n - 1, x, state);

            ans[i] = state.matchCount;
        }

        return ans;
    }
}