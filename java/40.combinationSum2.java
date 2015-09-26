public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return rst;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);// sort
        helper(rst, path, candidates, target, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> path, int[] candidates, int target, int pos){
        if(target == 0){
            rst.add(new ArrayList(path));
            return;
        } 
        if(target < 0) return;
        for(int i = pos; i < candidates.length; i++){
            if(i > pos && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            helper(rst, path, candidates, target - candidates[i], i + 1);// not pos + 1
            path.remove(path.size() - 1);
        }
    }
}