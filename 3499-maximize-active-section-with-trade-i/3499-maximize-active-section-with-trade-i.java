class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int o = 0, m = 0, c = 0, l = 0;
        for (char x : s.toCharArray()) {
            if (x == '0') c++;
            else {
                if (c > 0) l = c;
                c = 0;
                o++;
            }
            m = Math.max(m, c + l);
        }
        return (m == c || m == l) ? o : o + m;
    }
}