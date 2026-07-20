class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
    ArrayList<Integer> list=new ArrayList<>();
      for(int i=0;i<nums2.length;i++){
        if(set1.contains(nums2[i])){
            list.add(nums2[i]);
            set1.remove(nums2[i]);
        }

      }  nums1=new int[list.size()];
      for(int i=0;i<list.size();i++){
         nums1[i]=list.get(i);
      }
      return nums1;
       }
}