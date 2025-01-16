// Two - pointer

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;

        int prev = -1;
        for (int i=0; i<nums.length; i++) {
        
            if (prev == -1 || nums[i] != nums[i-1]) {
                for (int j=i+1; j<nums.length; j++) {
                    if (nums[j] - nums[i] == k) {
                        ans ++;
                        break;
                    }
                }
            } 
            prev = i;
        }

        return ans;
    }
}
