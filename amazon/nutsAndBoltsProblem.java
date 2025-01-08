// t.c. = O(n)
class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        int[] freq = new int[256];
        
        for (char ch: nuts) {
            freq[(int)ch] ++;
        }
        
        int j = 0;
        for (int i=0; i<256; i++) {
            if (freq[i] > 0) {
                nuts[j] = (char)i;
                bolts[j] = (char)i;
                j ++;
            }
        }
    }
}
