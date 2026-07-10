class Solution {
    public int pivotInteger(int n) {
       double sum=Math.sqrt(n*(n+1)/2);
       if(sum-(int)sum==0)return (int)sum;
    return -1;
    }
}