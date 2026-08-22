class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,num=n,product=1;
        while(n>0){
            sum+=n%10;
            product *=n%10;
             n=n/10;
        }
        // int dividend=sumproduct
        return (num%(sum+product)==0)?true:false;
    }
}