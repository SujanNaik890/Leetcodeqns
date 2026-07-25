class Solution {
    public int maxProduct(int n) {
       int first=0,second=0;
       while(n>0){
        int r=n%10;

         if(r>=first){
            second=first;
            first=r;
         }else if(r>second  && r!=first)second =r;
        n=n/10;
       } 
       return first* second;
    }
}