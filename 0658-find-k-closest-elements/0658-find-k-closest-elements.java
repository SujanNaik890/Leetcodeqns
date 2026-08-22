class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < k; i++)
            li.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            if (Math.abs(arr[i - k] - x) > Math.abs(arr[i] - x)) {
                li.remove(Integer.valueOf(arr[i - k]));
                li.add(arr[i]);
            }
        }

        return li;
    }
}