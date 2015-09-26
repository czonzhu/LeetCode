/*
    Caution: pay attention to the edge case where begin word and end word are equal.
*/
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(beginWord.equals(endWord)) return 1;
        int rst = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordDict.remove(beginWord);
        rst += 1;
        
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int k = 0; k < count; k++){
                String tmp = queue.poll();
                for(int i = 0; i < tmp.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        String newstr = replace(tmp, i, c);
                        if(newstr.equals(tmp)) continue;
                        if(newstr.equals(endWord))
                            return rst + 1;
                        if(wordDict.contains(newstr)){
                            queue.offer(newstr);
                            wordDict.remove(newstr);
                        }
                            
                    }
                }
              
            }
            rst++;
        }
        return 0;
        
        
    }
    
    public String replace(String str, int index, Character c){
        char[] cstr = str.toCharArray();
        cstr[index] = c;
        return new String(cstr);
    }
}