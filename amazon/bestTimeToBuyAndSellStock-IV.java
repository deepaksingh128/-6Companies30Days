// Method 1 :- O(n^3)

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int [][]dp = new int[n][k+1];


        for (int t=1; t<=k; t++) {
            for (int p=1; p<n; p++) {
                int max = dp[p-1][t];

                for (int i=0; i<p; i++) {
                    max = Math.max(max, 
                        dp[i][t-1] + prices[p] - prices[i]);
                }

                dp[p][t] = max;
            }
        }

        return dp[n-1][k];
    }
}


// Method 2 :- O(n^2)

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int [][]dp = new int[n][k+1];


        for (int t=1; t<=k; t++) {

            int max = Integer.MIN_VALUE;

            for (int p=1; p<n; p++) {
                if (dp[p-1][t-1] - prices[p-1] > max) {
                    max = dp[p-1][t-1] - prices[p-1];
                }

                if(max + prices[p] > dp[p-1][t]) {
                    dp[p][t] = max + prices[p];
                } else {
                    dp[p][t] = dp[p-1][t];
                }
            }
        }

        return dp[n-1][k];
    }
}
