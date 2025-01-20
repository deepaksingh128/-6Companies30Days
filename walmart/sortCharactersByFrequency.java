// Method 2 :- Using Fixed size Array for frequency storing

class Solution {

class Pair {
    char ch;
    int count;

    public Pair (char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

    public String frequencySort(String s) {
        int n = s.length();
        int[] freq = new int[62];

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                freq[ch - 'a'] ++;
            } else if (Character.isUpperCase(ch)) {
                freq[ch - 'A' + 26] ++;
            } else if (Character.isDigit(ch)) {
                freq[ch - '0' + 52] ++;
            }
        }

        List<Pair> temp = new ArrayList<>();
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                char ch;
                if (i < 26) { // a-z
                    ch = (char) ('a' + i);
                } else if (i < 52) { // A-Z
                    ch = (char) ('A' + (i - 26));
                } else { // 0-9
                    ch = (char) ('0' + (i - 52));
                }
                temp.add(new Pair(ch, freq[i]));
            }
        }    

        temp.sort((a, b) -> {
            return b.count - a.count;
        });

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<temp.size(); i++) {
            int count = temp.get(i).count;
            while (count > 0) {
                sb.append(temp.get(i).ch);
                count --;
            }
        }

        return sb.toString();
    }
}

// Method 1 :- Using HashMap for frequency storing

class Solution {

class Pair {
    char ch;
    int count;

    public Pair (char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

    public String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Pair> temp = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
            temp.add(new Pair(entry.getKey(), entry.getValue()));
        }    

        temp.sort((a, b) -> {
            return b.count - a.count;
        });

        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<temp.size(); i++) {
            int count = temp.get(i).count;
            while (count > 0) {
                sb.append(temp.get(i).ch);
                count --;
            }
        }

        return sb.toString();
    }
}
