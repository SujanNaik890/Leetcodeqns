class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int blocks = n / 8;
        return (blocks * (blocks + 1) * 4)
                + (n % 8) * (blocks + 1);
        

        // int pushCnt = 0;

        // for(int i = 0; i < n; i++){
        //     pushCnt += i / 8 + 1;
        // }

        // return pushCnt;
    }
}