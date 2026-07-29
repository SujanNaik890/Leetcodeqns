import java.math.BigInteger;
class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length(), freq[] = new int[26];
        for(int i = 0; i < n; i++)    ++freq[s.charAt(i) - 'a'];

        char pal[] = new char[n / 2 + (n % 2)];
        n /= 2;
        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0)    pal[n] = (char)(i + 'a');
            freq[i] /= 2;
        }

        BigInteger k1 = BigInteger.valueOf(k);
        BigInteger totalWays = fact(BigInteger.valueOf(n)).divide(duplicatePermu(freq));
        if(totalWays.compareTo(k1) < 0) return "";

        for(int i = 0; i < n; i++){
            BigInteger slotInConsideration = BigInteger.valueOf(n - i);
            for(int j = 0; j < 26; j++){
                if(freq[j] > 0){
                    BigInteger ways = totalWays.multiply(BigInteger.valueOf(freq[j]--));
                    ways = ways.divide(slotInConsideration);
                    if(ways.compareTo(k1) >= 0){
                        pal[i] = (char)(j + 'a');
                        totalWays = ways;
                        break;
                    }else{
                        k1 = k1.subtract(ways);
                        freq[j]++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch: pal)  sb.append(ch);
        for(int i = n - 1; i >= 0; i--) sb.append(pal[i]);
        return sb.toString();
    }
    private BigInteger duplicatePermu(int freq[]){
        BigInteger d = BigInteger.ONE;
        for(int i: freq)    d = d.multiply(fact(BigInteger.valueOf(i)));
        return d;
    }
    private BigInteger fact(BigInteger n){
        BigInteger one = BigInteger.ONE, res = one, zero = BigInteger.ZERO;
        while(n.compareTo(zero) > 0){
            res = res.multiply(n);
            n = n.subtract(one);
        }
        return res;
    }
}