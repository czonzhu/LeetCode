public class Solution {
    
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null) return 0;
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

            for(int i = 0; i < words.length; i++){
                if(word1.equals(word2)){
                    if(words[i].equals(word1)) {
                        if(p1 != -1) min = Math.min(min, i - p1);
                        p1 = i;
                    }
                }
                else{
                    if(words[i].equals(word1)) p1 = i;
                    else if(words[i].equals(word2)) p2 = i;
                    if(p1 != -1 && p2 != -1) min = Math.min(min, Math.abs(p2 - p1));
                }
            }
        
        return min;
    }
}