class Solution {
    public int minimumDeletions(int[] arr) {
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int mini=0,maxi=0;
        if(n<2)return n;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                maxi=i;
            }
            if(arr[i]<min){
                min=arr[i];
                mini=i;
            }
        }
       int left = Math.min(mini, maxi);
        int right = Math.max(mini, maxi);

        int bothFront = right + 1;
        int bothBack = n - left;
        int bothSides = (left + 1) + (n - right);

        return Math.min(bothFront, Math.min(bothBack, bothSides));
    }
}