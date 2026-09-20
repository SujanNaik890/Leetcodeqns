class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            int alphabet=26-(s.charAt(i)-'a');
            sum+=alphabet*(i+1);
        }
        return sum;
    }
}