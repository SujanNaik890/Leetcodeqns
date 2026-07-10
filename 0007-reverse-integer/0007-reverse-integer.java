class Solution {
    public int reverse(int x) {
      int n,sum=0;
      int k=x;
      if(x<0)x=-(x);
       while(x>0){
        n=x%10;
         if (sum >Integer.MAX_VALUE/10 || sum < Integer.MIN_VALUE/10 )return 0;
        sum=sum*10+n;
        x/=10;
       } 
       if(k<0) return -sum;
       return sum;
    }
}