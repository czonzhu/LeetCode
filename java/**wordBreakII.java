public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<String>();
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(wordDict.contains(s.substring(i))) break;
            if(i == 0) return rst;
        }
       
        
        for(int i = 1; i < s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                List<String> strs = wordBreak(s.substring(i, s.length()), wordDict);
                if(strs.size() != 0){
                    for(String str : strs){
                        rst.add(s.substring(0, i) + " " + str);
                    }
                }
            }
        }
        
        if(wordDict.contains(s)){
            rst.add(s);
        }
        return rst;
        
    }
}