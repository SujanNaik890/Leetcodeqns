class Solution {
    public int totalNumbers(int[] digit) {
    int n=digit.length;
    Set <Integer> set=new HashSet<>();

    for(int i=0;i<n;i++){
        if(digit[i]==0)continue;
        for(int j=0;j<n;j++){
            if(j==i)continue;
            for(int k=0;k<n;k++){
                if(k==i ||k==j)continue;
                if(digit[k] %2==0){
                   set.add(digit[i] * 100+digit[j]*10+digit[k] ) ;
                }
            }
        }
    }return set.size();
    }
}