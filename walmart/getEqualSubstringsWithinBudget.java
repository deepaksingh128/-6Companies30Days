// t.c.=> O(nlogn), s.c. => O(n)
// prefix sum, binary search, sliding window

class Solution {

    // helper
    public int calculateMinCost(int[] preSum, int windowLen) {
        int cost = Integer.MAX_VALUE;
        int i = 0;
        int j = windowLen - 1;
        while (j < preSum.length - 1) {
            cost = Math.min(cost, preSum[j+1] - preSum[i]);
            i ++;
            j ++;
        } 

        return cost;
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int maxLen = 0;
        int[] cost = new int[n];
        int[] preSum = new int[n+1];

        for (int i=0; i<n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
            preSum[i+1] = preSum[i] + cost[i];
        }

        // binary search :- on length
        int i = 1;
        int j = n;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            int currCost = calculateMinCost (preSum, mid);
            if (currCost <= maxCost) {
                maxLen = mid;
                i = mid + 1;
            } else {
                j = mid -1;
            }
        }

        return maxLen;
    }
}
