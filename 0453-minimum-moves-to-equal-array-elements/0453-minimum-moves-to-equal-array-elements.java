class Solution {
    public int minMoves(int[] nums) {
      int min=Integer.MAX_VALUE;
      int sum=0;
      for(int i:nums){if(i < min)min=i;
        sum+=i;
      }

      return sum-(min * nums.length);
    }
}