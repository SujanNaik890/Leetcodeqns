class Solution {
    public boolean checkValidString(String s) {
    int count1=0;
    int count2=0;

    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch=='('){
            count1++;
            count2++;
        }
        else if(ch==')'){
            count1--;
            count2--;
        }
        else if(ch=='*'){
            count1++;
            count2--;
        }
    if(count1  <0)return false;

    if(count2 <0)count2=0;
    }
    return count2==0;
    }
}