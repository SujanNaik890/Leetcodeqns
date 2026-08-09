class Solution {
    private Map<String, Integer> dp = new HashMap<>();

    private int score(boolean alice, int idx, int M, int[] piles) {
        if (idx == piles.length) {
            return 0;
        }
        String key = alice + "," + idx + "," + M;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = alice ? 0 : Integer.MAX_VALUE;
        int total = 0;

        for (int x = 1; x <= 2 * M; ++x) {
            if (idx + x > piles.length) {
                break;
            }
            total += piles[idx + x - 1];

            if (alice) {
                res = Math.max(res, total + score(!alice, idx + x, Math.max(M, x), piles));
            } else {
                res = Math.min(res, score(!alice, idx + x, Math.max(M, x), piles));
            }
        }
        dp.put(key, res);
        return res;
    }
    public int stoneGameII(int[] piles) {
        return score(true, 0, 1, piles);
    }
}