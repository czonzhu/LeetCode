public class WordDistance {
    private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])) map.put(words[i], new ArrayList<Integer>(Arrays.asList(i)));
            else{
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int p1 = 0, p2 = 0; p1 < l1.size() && p2 < l2.size();){
            if(l1.get(p1) == l2.get(p2)) return 0;
            min = Math.min(min, Math.abs(l1.get(p1) - l2.get(p2)));
            if(l1.get(p1) < l2.get(p2)) p1++;
            else p2++;
           
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");