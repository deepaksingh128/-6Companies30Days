// https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/

class Solution {
    int[][] rects;
    Random r = new Random();
    int totalPointsTillThisRectangle = 0;
    List<Integer> preSum = new ArrayList<>();

    public Solution(int[][] rects) {
        this.rects = rects;
        for(int[] rect: rects) {
            totalPointsTillThisRectangle += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            preSum.add(totalPointsTillThisRectangle);
        }
    }
    
    public int[] pick() {
       int target = r.nextInt(totalPointsTillThisRectangle);

       int lo=0, hi=rects.length-1;
       while(lo < hi){
        int mid = lo + (hi - lo) /2;

        if(target >= preSum.get(mid)) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
       }

       int[] rect = rects[lo]; // in this rectangle , we will find rendom point
       int x1 = rect[0];
       int y1 = rect[1];
       int x2 = rect[2];
       int y2 = rect[3];

       int x = r.nextInt(x2 - x1 + 1);
       int y = r.nextInt(y2 - y1 + 1);

       return new int[]{x1 + x, y1 + y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
