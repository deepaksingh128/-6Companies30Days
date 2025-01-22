class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
        }

        for (int i=1; i<=k; i++) {
            int modified = pq.poll() + 1;
            pq.add(modified);
        }

        int mod = 1_000_000_007;
        int ans = 1;

        for (int num : pq) {
            ans = (int)((long)ans * num % mod); // intermediate result can overflow , therefore (long)
        }

        return ans;
    }
}
