public class Solution{
	public int findMin(int[] nums){
		if(nums == null || nums.length == 0) return -1;
		int l = 0, r = nums.length - 1;
		while(l < r && nums[l] >= nums[r]){// for the case like {1, 3, 3}  once falling off the cliff, end. else jump dup to regular graph.
			int m = l + (r - l) / 2;
			if(nums[m] > nums[r]) l = m + 1;
			else if(nums[m] < nums[r]) r = m;
			else l++;
		}
		return nums[l];
	}
}