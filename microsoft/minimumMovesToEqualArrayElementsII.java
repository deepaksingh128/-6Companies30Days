// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

// Method 2 :- Sorting , without median, two pointer
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length -1;
        int cost = 0;
        while(left <= right) {
            cost += nums[right] - nums[left];
            left ++;
            right --;
        }

        return cost;    
    }
}
