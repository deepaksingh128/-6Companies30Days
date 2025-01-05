// https://leetcode.com/problems/bulls-and-cows/

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();

        int[] secretFreq = new int[10];
        int[] guessFreq = new int[10];

        int noOfBulls = 0;
        int noOfCows = 0;

        // Count bulls and track unmatched characters
        for (int i = 0; i < n; i++) {
            char ch1 = secret.charAt(i);
            char ch2 = guess.charAt(i);

            if (ch1 == ch2) {
                noOfBulls++; // Bull
            } else {
                // unmatched characters
                secretFreq[ch1 - '0']++;
                guessFreq[ch2 - '0']++;
            }
        }

        // Count cows based on frequency arrays
        for (int i = 0; i < 10; i++) {
            noOfCows += Math.min(secretFreq[i], guessFreq[i]);
        }

        return noOfBulls + "A" + noOfCows + "B";
    }
}
