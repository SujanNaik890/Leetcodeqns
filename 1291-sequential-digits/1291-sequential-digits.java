class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
         String s="123456789";
         for(int i=2;i<=9;i++){
            for(int j=0;i+j<=9;j++){
                int num=Integer.parseInt(s.substring(j,i+j));
                if(num>=low && num<= high){
                   list.add(num);
                }
            }
         }
         return list;
    }
}