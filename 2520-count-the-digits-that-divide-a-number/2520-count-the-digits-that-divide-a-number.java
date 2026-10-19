class Solution {
    public int countDigits(int num) {
        int count=0;
        int n=num;
        while(n>0){
            int remainder=n%10;
            if(num % remainder==0)count++;
            n/=10;
        }
        return count;
    }
}