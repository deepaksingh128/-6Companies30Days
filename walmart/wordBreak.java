
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Boolean[] memo = new Boolean[s.length()];

        return wordBreakHelper(0, s, set, memo);
    }

    private boolean wordBreakHelper(int idx, String str, Set<String> set, Boolean[] memo) {
        if (idx == str.length()) {
            return true;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int i = idx; i < str.length(); i++) {
            String substr = str.substring(idx, i + 1);

            if (set.contains(substr) && wordBreakHelper(i + 1, str, set, memo)) {
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }
}
