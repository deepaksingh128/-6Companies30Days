class Solution {
    public int firstUniqChar(String s) {
        int []freq = new int[26]; 

        int n = s.length();
        int i = 0;
        while (i < n) {
            int idx = s.charAt(i) - 'a';
            freq[idx] ++;
            i ++;
        }

        for (i=0; i<n; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
