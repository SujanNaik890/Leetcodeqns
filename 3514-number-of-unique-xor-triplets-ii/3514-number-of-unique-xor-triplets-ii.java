class Solution {
    public int uniqueXorTriplets(int[] nums) {

        final int MAXX = 2048;

        boolean[] pairXor = new boolean[MAXX];
        boolean[] tripletXor = new boolean[MAXX];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor[nums[i] ^ nums[j]] = true;
            }
        }

        for (int x = 0; x < MAXX; x++) {

            if (!pairXor[x])
                continue;

            for (int v : nums)
                tripletXor[x ^ v] = true;
        }

        int ans = 0;

        for (boolean ok : tripletXor)
            if (ok) ans++;

        return ans;
    }
}