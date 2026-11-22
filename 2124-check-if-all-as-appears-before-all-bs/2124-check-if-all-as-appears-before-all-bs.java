class Solution {
    public boolean checkString(String s) {
        boolean bpresent=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='b'){
                bpresent=true;
            }
            if(bpresent){
                if(ch=='a')return false;
            }
        }
        return true;
    }
}