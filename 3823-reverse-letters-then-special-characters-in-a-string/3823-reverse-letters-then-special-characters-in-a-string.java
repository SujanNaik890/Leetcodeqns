class Solution {
    public String reverseByType(String s) {
        char []arr=s.toCharArray();
        int l=0;
        int r=arr.length-1;
        while(l<r){
        while(l<r && !Character.isLetter(arr[l])){
            l++;
        }
        while(l<r && !Character.isLetter(arr[r])){
            r--;
        }
        char t=arr[l];
        arr[l]=arr[r];
        arr[r]=t;
        l++;
        r--;
        }
        l=0;
        r=arr.length-1;
        while(l<r){
        while(l<r && Character.isLetter(arr[l])){
            l++;
        }
        while(l<r && Character.isLetter(arr[r])){
            r--;
        }
        char t=arr[l];
        arr[l]=arr[r];
        arr[r]=t;
        l++;
        r--;
        }
        return new String(arr);
    }
}