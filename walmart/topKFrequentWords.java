// Method 2:- HashMap + Heap(PriorityQueue){nlogk}

class Solution {

    class Pair {
        String str;
        int count;

        public Pair (String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freq = new HashMap<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return b.str.compareTo(a.str);
            }
            return a.count - b.count;
        });

        for (int i=0; i<n; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: freq.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().str);
        }
        Collections.reverse(ans);

        return ans;
    }
}

// Method 1 :- HashMap + ArrayList{nlogn}
class Solution {

    class Pair {
        String str;
        int freq;

        Pair(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        Map<String, Integer> freq = new HashMap<>();
        List<Pair> temp = new ArrayList<>();

        for (int i=0; i<n; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: freq.entrySet()) {
            temp.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        // custom sorting :- nlogn
        temp.sort((a, b) -> {
            if (b.freq == a.freq) {
                return a.str.compareTo(b.str);
            }
            return b.freq - a.freq;
        });

        List<String> ans = new ArrayList<>();
        for (int i=0; i<k; i++) {
            ans.add(temp.get(i).str);
        }

        return ans;
    }
}
