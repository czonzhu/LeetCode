public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Extension: what if there is negative number 
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> path= new ArrayList<Integer>();
        if(candidates == null || candidates.length == 0) return rst;
        Arrays.sort(candidates); // Never forget to sort !!!!!!!!!!!!
        helper(rst, path, candidates, target, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> path, int[] candidates, int target, int pos){
        if(target == 0){
            rst.add(new ArrayList<Integer>(path));
            return;
        }
        if(target < 0) return;
        for(int i = pos; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(rst, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
        return;
    }
}