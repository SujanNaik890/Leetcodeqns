class Solution {
    public int findNumbers(int[] nums) {
    // 1type but time complexity O(N2)
    //   int evencount=0;
    // for(int num:nums){
    //     int count=0;
    //     while(num>0){
    //         num/=10;
    //         count++;
    //     }if(count%2==0){
    //         evencount++;
    //     }
    // }
    //  return evencount;
    int count=0;
    for(int n:nums){
        int digit=(int)Math.log10(n)+1;
        if(digit%2==0)count++;
        // if(String.valueOf(n).length()%2==0)count++;
    }
    return count;
    }
}