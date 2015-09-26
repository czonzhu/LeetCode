public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 10) {
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int h = 0;
        for (int i = 0; i < 9; i++) {
            h = h << 3 | s.charAt(i) & 7;
        }
        for (int i = 9; i < s.length(); i++) {
            h = (h << 3 & 0x3FFFFFFF) | (s.charAt(i) & 7);// 0x3FFFFFFF means 30 bits, Just keep rolling
            map.put(h, map.getOrDefault(h, 0) + 1);
            if (map.getOrDefault(h, 0) == 2) {
                ans.add(s.substring(i - 9, i + 1));
            }
        }
        return ans;
    }
}