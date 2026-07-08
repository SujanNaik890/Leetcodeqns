class Solution {
    static final int MOD = 1000000007;

    static class Node {
        long val;
        int cnt;
        Node(long val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] prefCnt = new int[n + 1];
        int[] prefSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefCnt[i + 1] = prefCnt[i];
            prefSum[i + 1] = prefSum[i];
            if (s.charAt(i) != '0') {
                prefCnt[i + 1]++;
                prefSum[i + 1] += s.charAt(i) - '0';
            }
        }

        int maxCnt = prefCnt[n];
        long[] pow10 = new long[maxCnt + 1];
        pow10[0] = 1;
        for (int i = 1; i <= maxCnt; i++) {
            pow10[i] = pow10[i - 1] * 10 % MOD;
        }

        Node[] seg = new Node[4 * n];
        build(1, 0, n - 1, s, seg, pow10);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            Node res = query(1, 0, n - 1, l, r, seg, pow10);
            long sum = prefSum[r + 1] - prefSum[l];
            ans[i] = (int) (res.val * sum % MOD);
        }

        return ans;
    }

    private void build(int idx, int l, int r, String s, Node[] seg, long[] pow10) {
        if (l == r) {
            int d = s.charAt(l) - '0';
            if (d == 0) seg[idx] = new Node(0, 0);
            else seg[idx] = new Node(d, 1);
            return;
        }

        int mid = (l + r) / 2;
        build(idx * 2, l, mid, s, seg, pow10);
        build(idx * 2 + 1, mid + 1, r, s, seg, pow10);
        seg[idx] = merge(seg[idx * 2], seg[idx * 2 + 1], pow10);
    }

    private Node query(int idx, int l, int r, int ql, int qr, Node[] seg, long[] pow10) {
        if (ql <= l && r <= qr) return seg[idx];

        int mid = (l + r) / 2;

        if (qr <= mid) return query(idx * 2, l, mid, ql, qr, seg, pow10);
        if (ql > mid) return query(idx * 2 + 1, mid + 1, r, ql, qr, seg, pow10);

        Node left = query(idx * 2, l, mid, ql, qr, seg, pow10);
        Node right = query(idx * 2 + 1, mid + 1, r, ql, qr, seg, pow10);

        return merge(left, right, pow10);
    }

    private Node merge(Node a, Node b, long[] pow10) {
        return new Node((a.val * pow10[b.cnt] + b.val) % MOD, a.cnt + b.cnt);
    }
}