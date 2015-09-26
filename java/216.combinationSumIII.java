public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(rst, path, k, n, 1);
        return rst;
    }
    
    public void helper(List<List<Integer>> rst, List<Integer> path, int k, int n, int pos){
        if(k == 0 && n == 0) rst.add(new ArrayList<Integer>(path));
        if(n < 0 || k < 0) return;
        for(int i = pos; i <= 9; i++){
            path.add(i);
            helper(rst, path, k - 1, n - i, i + 1);
            path.remove(path.size() - 1);
        }
        return;
    }
}