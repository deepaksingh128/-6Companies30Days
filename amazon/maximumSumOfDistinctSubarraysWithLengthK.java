// Method 1:- Using Set, O(n), O(n)

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        long result = 0;
        long currWindowSum = 0;

        int i = 0;
        int j = 0;

        while (j < n) {
            while (set.contains(nums[j])) {
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i ++;
            }

            currWindowSum += nums[j];
            set.add(nums[j]);

            if (j - i + 1 == k) {
                result = Math.max (result, currWindowSum);
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i ++;
            }

            j ++;
        }

        return result;
    }
}
