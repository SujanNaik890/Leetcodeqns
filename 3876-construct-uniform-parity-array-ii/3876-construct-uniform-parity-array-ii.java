class Solution {
    public boolean uniformArray(int[] nums1) {
        int odd=Integer.MAX_VALUE;
        int even=Integer.MAX_VALUE;
        for(int x: nums1){
            if(x % 2==0)even=Math.min(even,x);
            else odd=Math.min(odd,x);
        }
        if(odd==Integer.MAX_VALUE)return true;
         return even >odd; 
    }
}