bool isPalindrome(int x) {
    if(x<0)return false;
    int y=x;
  long long sum=0;
  while(y>0){

    int a=y%10;
    sum=sum*10+a;
    y=y/10;
    }

if(sum==x)return true;
else return false;
}