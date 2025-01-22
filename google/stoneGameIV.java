class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] cumm = new int[n][2];

        for (int i=0; i<n; i++) {
            cumm[i] = new int[]{aliceValues[i]+bobValues[i], i};
        }

        Arrays.sort(cumm, (a, b) -> b[0]-a[0]);

        int aliceSum = 0;
        int bobSum = 0;
        for (int i=0; i<n; i++) {
            if (i % 2 == 0) {
                aliceSum += aliceValues[cumm[i][1]];
            } else {
                bobSum += bobValues[cumm[i][1]];
            }
        }

        if (aliceSum > bobSum) return 1;
        if (aliceSum == bobSum) return 0;
        
        return -1;
    }
}
