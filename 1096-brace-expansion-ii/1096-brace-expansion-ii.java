
import java.util.*;

class Solution {
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        this.index = 0;
        Set<String> resultSet = parseExpr(expression);
        
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }

    private Set<String> parseExpr(String s) {
        Set<String> res = new HashSet<>(parseTerm(s));
        
        while (index < s.length() && s.charAt(index) == ',') {
            index++; // consume ','
            res.addAll(parseTerm(s));
        }
        return res;
    }

    private Set<String> parseTerm(String s) {
        Set<String> res = new HashSet<>();
        res.add("");
        while (index < s.length() && (Character.isLetter(s.charAt(index)) || s.charAt(index) == '{')) {
            Set<String> nextFactor = parseFactor(s);
            Set<String> combined = new HashSet<>();
            for (String a : res) {
                for (String b : nextFactor) {
                    combined.add(a + b);
                }
            }
            res = combined;
        }
        return res;
    }

    // Factor := Letter+ | '{' Expr '}'
    private Set<String> parseFactor(String s) {
        Set<String> res = new HashSet<>();
        
        if (s.charAt(index) == '{') {
            index++; 
            res = parseExpr(s);
            index++; 
        } else {
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && Character.isLetter(s.charAt(index))) {
                sb.append(s.charAt(index++));
            }
            res.add(sb.toString());
        }
        return res;
    }
}