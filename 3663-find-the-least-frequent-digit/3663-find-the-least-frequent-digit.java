class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] num=new int[10];
        while(n>0){
            int r=n%10;
            num[r]+=1;
            n/=10;
        }
        int minindex=Integer.MAX_VALUE;
        int min=10;
        for(int i=10-1;i>=0;i--){
        if(minindex>=num[i] && num[i]!=0)
            if(min>i){
                min=i;
                minindex=num[i];
            }
        }
        return min;
    }
}