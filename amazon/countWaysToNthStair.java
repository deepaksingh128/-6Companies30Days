// Using memoization , we can use standard 3D array as well

class Solution {

    Map<String, Integer> map = new HashMap<>();

    public int helper (int i, int jump, boolean canJumpBelow, int k) {
        if (i > k + 1) {
            return 0;
        }

        String key = i + "_" + jump + "_" + canJumpBelow;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ways = 0;
        if (i == k) {
            ways += 1;
        }

        if (canJumpBelow) {
            ways += helper (i - 1, jump, false, k);
        }

        ways += helper (i + (int)Math.pow(2, jump), jump + 1, true, k);

        map.put(key, ways);
        return ways;
    }


    public int waysToReachStair(int k) {
        
        return helper (1, 0, true, k);
    }
}
