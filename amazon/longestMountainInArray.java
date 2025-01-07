// Single pass, O(1) space

class Solution {
    public int longestMountain(int[] arr) {
        int ans = 0;
        int upCount = 0;
        int downCount = 0;

        for (int i=1; i<arr.length; i++) {
            if (downCount > 0 && arr[i-1] < arr[i] || arr[i-1] == arr[i]){
                upCount = downCount = 0;
            }

            if (arr[i-1] < arr[i]) {
                upCount ++;
            }

            if(arr[i-1] > arr[i]) {
                downCount ++;
            }

            if (upCount > 0 && downCount > 0 && (upCount+downCount+1) > ans){
                ans = upCount + downCount + 1;
            }
        }

        return ans;
    }
}
