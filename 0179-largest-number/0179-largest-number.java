class Solution {
    public String largestNumber(int[] nums) {
        String[] strarr = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            strarr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strarr,(a,b) ->(b+a).compareTo(a+b) );
        if(strarr[0].charAt(0)=='0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s: strarr){
            sb.append(s);
        }
      
      return sb.toString();
    }
}