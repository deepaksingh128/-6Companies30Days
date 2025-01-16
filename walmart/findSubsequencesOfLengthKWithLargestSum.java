// It is like finding K largest elements remembering their order

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer, Integer> pq = new PriorityQueue<>();
        int []ans = new int[k];

        for (int i=0; i<nums.length; i++) {
            pq.add(nums[i], i);
            if (pq.size() > k) {
                pq.poll();
            }
        }        

        Set<Integer> idx = new HashSet<>();
        while(pq.size() > 0){
            set.add(pq.poll()[1]);
        }

        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (idx.contains(i)) {
                ans[j] = nums[i];
                j ++;
            }
        }

        return ans;
    }
}
