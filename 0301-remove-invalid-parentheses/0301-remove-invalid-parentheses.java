class Solution {
    int max;
    List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        dfs(s,set);
        return result;
    }
    private void dfs(String s , HashSet<String> set){
        //base
        if(set.contains(s) || s.length() < max) return;
        if(isValid(s)){
            if(s.length() > max){
                result = new ArrayList<>();
                max = s.length();
            }
            result.add(s);
        }


        //logic
        set.add(s);
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            if(!Character.isAlphabetic(c)){
                String child = s.substring(0,j) + s.substring(j+1); 
                //System.out.println(child);
                dfs(child  , set);
            }
        }

    }
    private boolean isValid(String s){
        int count = 0; 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)) continue;
            if(ch == '('){
                count++;
            } else {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}