class Solution {
    public boolean checkIfExist(int[] arr) {
    //     for(int i=0;i<arr.length;i++)
    //     {   
    //          for(int j=0;j<arr.length;j++){
    //             if(i!=j && arr[j]== 2*arr[i]){
    //                 return true;
    //             }
    //         }
    // }
    //         return false;
    Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int lo = 0, hi = arr.length - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] == target && mid != i) 
                    return true;
                if (arr[mid] < target) 
                    lo = mid + 1;
                else 
                    hi = mid - 1;
            }
        }

        return false;
    }
}