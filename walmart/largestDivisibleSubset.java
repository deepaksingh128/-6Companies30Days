// Bottom up

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        int[] prev_idx = new int[n];

        for (int i=0; i<n; i++) {
            dp[i] = 1;
            prev_idx[i] = -1;
        }        

        int last_idx_selected = 0;
        int maxLen = 1; 

        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev_idx[i] = j;
                    } 
                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                        last_idx_selected = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (last_idx_selected != -1) {
            result.add(nums[last_idx_selected]);
            last_idx_selected = prev_idx[last_idx_selected];
        }  

        return result;     
    }
}
