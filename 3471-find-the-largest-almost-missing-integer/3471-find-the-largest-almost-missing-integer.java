/*class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, int[]> map = new HashMap<>();
        int largestInt = -1;

        int[] subarray;

        for (int i = 0; i <= nums.length - k; i++) {
            subarray = Arrays.copyOfRange(nums, i, k + i);

            map.put(i, subarray);
        }

        Map<Integer, Integer> frqTable = getFrequency(nums, map);
        if (frqTable.size() == 1 && k < 2)
            return largestInt;

        int minFrq = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : frqTable.entrySet()) {
        
            minFrq = Math.min(entry.getValue(), minFrq);
        }

        ArrayList<Integer> smallestFreq = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> entry : frqTable.entrySet()) {
            if (entry.getValue() == 1) {
                smallestFreq.add(entry.getKey());
            }
        }

        for (int n : smallestFreq) {
            largestInt = Math.max(largestInt, n);
        }

        return largestInt;
    }

    public Map<Integer, Integer> getFrequency(int[] nums, Map<Integer, int[]> map) {
        Map<Integer, Integer> freqTable = new HashMap<>();
        
        
        
        if(map.size() == 1) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            
            int[] subarray = map.get(0);
            for (int number : subarray) {
                uniqueNumbers.add(number);
            }
            for (int number : uniqueNumbers) {
                freqTable.merge(number, 1, Integer::sum);
            }
            return freqTable;
            
        }
        
       for (int[] subarray : map.values()){
        for (int number : subarray) {
            freqTable.merge(number, 1, Integer::sum);
        }}
    

    return freqTable;

}}*/
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] freq = new int[51];

        for (int x : nums) {
            freq[x]++;
        }

        if (k == 1) {
            for (int x = 50; x >= 0; x--) {
                if (freq[x] == 1) {
                    return x;
                }
            }

            return -1;
        }

        if (k == n) {
            int answer = 0;

            for (int x : nums) {
                answer = Math.max(answer, x);
            }

            return answer;
        }

        int answer = -1;

        if (freq[nums[0]] == 1) {
            answer = Math.max(answer, nums[0]);
        }

        if (freq[nums[n - 1]] == 1) {
            answer = Math.max(answer, nums[n - 1]);
        }

        return answer;
    }
}