// Method 1 :- Using HashMap (similar to subarrays sum equal to k)

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length; 
        Map<Integer, Integer> map = new HashMap<>();  // no of odd numbers, freq
        map.put(0, 1);  // 0 odd numbers present 1 time

        int result = 0;
        int oddCount = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] % 2 != 0) {
                oddCount ++;
            }

            if(map.containsKey(oddCount - k)) {
                result += map.get(oddCount -k);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}



// Method 2 :- Using sliding window

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        int prevCount = 0;
        int oddCount = 0;
        int result = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            if (nums[j] % 2 != 0) {
                oddCount ++;
                prevCount = 0;
            }

            while (oddCount == k) {
                prevCount ++;

                if (nums[i] % 2 == 1) {
                    oddCount --;
                }
                i ++;
            }

            result += prevCount;
            j ++;
        }

        return result;
    }
}
