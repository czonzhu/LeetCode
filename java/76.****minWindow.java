public class Solution{
    public String minWindow(String s, String t){
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        int[] found = new int[256];
        int[] dict = new int[256];
        for(char c : t.toCharArray()) dict[c]++;
        // Sliding Window: 1. when do right slide 2. when do left slide 3. what to record.
        int l = 0, r = 0, effAdd = 0, start = 0, width = Integer.MAX_VALUE;
        while(r < s.length()){
            found[s.charAt(r)]++;
            if(found[s.charAt(r)] <= dict[s.charAt(r)]) effAdd++;
            if(effAdd == t.length()){// Once the effAdd equals to t.length(), we let it remain.
                while(found[s.charAt(l)] > dict[s.charAt(l)]){
                    found[s.charAt(l)]--;
                    l++;
                }
                if(r - l + 1 < width){
                    start = l;
                    width = r - l + 1;
                }
            }
            r++;
        }
        return width == Integer.MAX_VALUE ? "" : s.substring(start, start + width);
    }
}