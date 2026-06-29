class Solution {
    public int numOfStrings(String[] patterns, String word) {
      int count=0;
    //   if(patterns.length()>=1 && patterns.length()<=100)
      for(String s:patterns){
        if(word.contains(s))count++;
      }  
      return count;
    }
}