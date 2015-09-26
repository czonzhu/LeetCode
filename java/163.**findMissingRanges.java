public class Solution{
	// 1. traverse range 2. [] & ()
	public List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> rst = new ArrayList<String>();
		int prev = lower - 1;
		for(int i = 0; i <= nums.length; i++){
			int cur = i == nums.length ? upper + 1 : nums[i];
			if(cur - prev > 1) rst.add(getRange(prev + 1, cur - 1));
			prev = cur;
		}
		return rst;
	}

	private String getRange(int from, int to){
		return (from == to) ? String.valueOf(from) : from + "->" + to;//单独时数字不能直接使用，concatanation时可以
	}
}