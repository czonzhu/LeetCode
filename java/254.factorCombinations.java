public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(n <= 2) return rst;
        List<Integer> path = new ArrayList<Integer>();
        helper(rst, path, n, 2);
        return rst;
    }
    
    public void helper(List<List<Integer>> rst, List<Integer> path, int n, int pos){
        if(n == 1 && path.size() > 1){
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = pos; i <= n; i++){
            if(n % i != 0) continue;
            path.add(i);
            helper(rst, path, n / i, i);
            path.remove(path.size() - 1);
        }
        return;
    }
}