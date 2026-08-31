class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        int[] sarr=new int[256];
        int[] tarr=new int[256];

        for(int i=0;i<s.length();i++){
            int c1=s.charAt(i);
            int c2=t.charAt(i);

            if(sarr[c1]!=tarr[c2]){
                return false;
            }

            sarr[c1]=i+1;
            tarr[c2]=i+1;        
        }
        return true;
    }
}