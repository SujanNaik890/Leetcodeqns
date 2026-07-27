class Solution {
    public int maxProduct(int[] arr) {
        int max=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            if(arr[i]>max){
                second=max;
                max=arr[i];
            }
             else if(arr[i]>second && arr[i]<=max){
                second=arr[i];
            }
        }
        max=max-1;
        second=second-1;
        return max*second;
    }
}