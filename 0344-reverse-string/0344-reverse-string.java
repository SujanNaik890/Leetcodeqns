class Solution {
    public void reverseString(char[] c) {
        int left=0,right=c.length-1;
        while(left<right){
            char temp=c[left];
            c[left]=c[right];
            c[right]=temp;
            left++;
            right--;
        }

    }
}