
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int ans = 0;

        int[][] dp = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        ans = Math.max(dp[i][j], ans);
                    } else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        return ans;
    }
}
