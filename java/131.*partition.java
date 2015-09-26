public class Solution {
    public List<List<String>> partition(String s) {
        // 增量构造法
        List<List<String>> rst = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return rst;
        List<String> path = new ArrayList<String>();
        helper(rst, path, s, 0);
        return rst;
        
    }
    
    public void helper(List<List<String>> rst, List<String> path, String s, int pos){
        if(pos == s.length()){
            rst.add(new ArrayList(path));
        }
        for(int i = pos; i < s.length(); i++){
            String cur = s.substring(pos, i + 1);
            if(!isPalindrome(cur)) continue;
            path.add(cur);
            helper(rst, path, s, i + 1);
            path.remove(path.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}