public class Solution {
    // Take it as permutation at first
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(n <= 0 || k > n) return rst;
        List<Integer> path = new ArrayList<Integer>();
        helper(rst, path, n, k, 1);
        return rst;
        
    }
    public void helper(List<List<Integer>> rst, List<Integer> path, int n, int k, int pos){
        if(path.size() == k){
            rst.add(new ArrayList<Integer> (path));
            return;
        }
        for(int i = pos; i <= n; i++){
            path.add(i);
            helper(rst, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
        return;
    }
}