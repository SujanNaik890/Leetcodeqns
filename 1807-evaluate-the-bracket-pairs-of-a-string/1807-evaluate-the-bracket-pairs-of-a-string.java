class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
    Map<String,String> map=new HashMap<>();
    for(List<String> str:knowledge){
        map.put(str.get(0),str.get(1));
    }
    StringBuilder ans=new StringBuilder();
    StringBuilder key=new StringBuilder();
    boolean inside =false;

    for(char c:s.toCharArray()){
        if(c=='('){
            inside=true;
        }else if(c==')'){
            inside=false;
            ans.append(map.getOrDefault(key.toString(),"?"));
            key.setLength(0);
        }else if(inside){
            key.append(c);
        }else ans.append(c);
    }
    return ans.toString();
    }
}