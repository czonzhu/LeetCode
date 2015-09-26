public class Solution{
	public List<String> summaryRanges(int[] nums){
		List<String> list = new ArrayList<String>();
		if(nums.length == 0) return list;
		for(int i = 0; i < nums.length; i++){
			int start = nums[i];
			while(i < nums.length - 1 && nums[i + 1] == nums[i] + 1)
				i++;
			if(nums[i] == start) list.add(start + "");
			else list.add(start + "->" + nums[i]);
		}
		return list;
	}
}