class Solution {
    private int gcd(int a, int b) { 
         int m=Math.max(a,b);
         int t=Math.min(a,b);
         while(t>0){
             int r=m%t;
             m=t;
             t=r;
        }
        return m;
     }

    public long gcdSum(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
    
            nums[i] = gcd(nums[i], mx);
        }

        Arrays.sort(nums);

        long res = 0;    
        int i = 0;  
        int j = nums.length - 1;
        while ( i < j)
      {      res += gcd(nums[i], nums[j]);
       i++; j--;
    }
        return res;
    }
}