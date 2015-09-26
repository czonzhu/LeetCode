public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        if(n == 0)  return rst;
        StringBuilder sb = new StringBuilder();
        helper(rst, sb, 0, 0, n);
        return rst;
    }
    public void helper(List<String> rst, StringBuilder sb, int l, int r, int n){
        if(r == n && l == n) rst.add(sb.toString());
        if(r > n || l > n) return;
        if(r < l){
            sb.append(")");
            helper(rst, sb, l, r + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

            sb.append("(");
            helper(rst, sb, l + 1, r, n);
            sb.deleteCharAt(sb.length() - 1);
        
        
        return;
    }
}