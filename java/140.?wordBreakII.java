public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // TLE
        List<String> rst = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        helper(rst, path, s, wordDict, 0);
        return rst;
    }
    
    public void helper(List<String> rst, StringBuilder path, String s, Set<String> wordDict, int pos){
        if(pos == s.length()){
            
            rst.add(path.substring(0, path.length() - 1).toString());
            return;
        }
        for(int i = pos; i < s.length(); i++){
            String cur = s.substring(pos, i + 1);
            if(!wordDict.contains(cur)) continue;
            path.append(cur);
            path.append(" ");
            helper(rst, path, s, wordDict, i + 1);
            path.delete(path.length() - cur.length() - 1,path.length());
        }
        return;
    }
}