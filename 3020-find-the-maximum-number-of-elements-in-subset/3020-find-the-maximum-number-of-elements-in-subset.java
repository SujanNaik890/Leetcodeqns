class Solution {
    public int maximumLength(int[] nums) {
         HashMap<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }
        int ans = 1;
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }
        for (long x : freq.keySet()) {
            if (x == 1)
                continue;
            long cur = x;
            int len = 1;

            while (freq.getOrDefault(cur, 0) >= 2) {
                if (cur > 1000000000L / cur)
                    break;
                long next = cur * cur;
                if (!freq.containsKey(next))
                    break;
                len += 2;
                cur = next;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}