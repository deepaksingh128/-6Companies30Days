// https://leetcode.com/problems/find-the-winner-of-the-circular-game/

class Solution {
    public int findTheWinner(int n, int k) {
        int idx = winnerIdx(n, k);

        return idx + 1;  // since 0 based indexing
    }

    public int winnerIdx(int n, int k) {
        if(n == 1) {
            return 0;     // since 1 element , idx=0
        }
        int idx = (winnerIdx(n-1, k) + k) % n;
        return idx;
    }
}
