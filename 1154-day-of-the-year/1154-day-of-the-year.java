class Solution {
    public int dayOfYear(String date) {
        int feb=0;
        int ans=0;
        if(Integer.parseInt(date.substring(0,4))%4==0){
            feb=29;
        }
        else{
            feb=28;
        }
        int[] year = {31,feb,31,30,31,30,31,31,30,31,30,31};
        int m= Integer.parseInt(date.substring(5,7));
        for(int i=0;i<m-1;i++){
            ans=ans+year[i];
        }
        if(Integer.parseInt(date.substring(0,4))==1900){
            return ans+ Integer.parseInt(date.substring(8)) -1;
        }
        return ans+ Integer.parseInt(date.substring(8));
    }
}