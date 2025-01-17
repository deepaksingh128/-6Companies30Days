// t.c. => O(n), s.c. => O(1)

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int prevF = 0;
        int maxF = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            totalSum += nums[i];
            prevF += i * nums[i];
        }        

        maxF = Math.max(maxF, prevF);

        for (int i=1; i<n; i++) {
            int currF = prevF + totalSum - n * nums[n-i];
            prevF = currF;
            maxF = Math.max(maxF, currF);
        }

        return maxF;
    }
}
