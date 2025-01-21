// Using HashMap 

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i=0; i<n-9; i++) {
            String str = s.substring(i, i+10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
