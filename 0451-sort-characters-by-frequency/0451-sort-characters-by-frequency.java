class Solution {
    public String frequencySort(String s) {
        int[] freq=new int[128];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        StringBuilder sb=new StringBuilder();
        while(sb.length()<s.length()){
            int max=0;
            for(int i=0;i<128;i++){
                if(freq[i]>freq[max])max=i;
            }

            for (int i = 0; i < freq[max]; i++) {
                sb.append((char) max);
            }

            freq[max] = 0;
        }
        return sb.toString();
    }
}