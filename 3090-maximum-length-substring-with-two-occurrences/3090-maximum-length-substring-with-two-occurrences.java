class Solution {
    public int maximumLengthSubstring(String s) {
    HashMap<Character,Integer> map=new HashMap<>();
    int left=0,maxlen=0;

    for(int i=0;i<s.length();i++){
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        while(map.get(s.charAt(i))>2){
           map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
           left++;
        }
        maxlen=Math.max(maxlen,i-left+1);
    }
    return maxlen;
    
    }
}