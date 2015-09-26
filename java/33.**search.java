public class Solution{
	//[)1. 左开右闭： l = mid + 1, r = mid; 2. 逼到两边
	public int search(int[] nums, int target){
		if(nums == null || nums.length == 0) return -1;
		int l = 0, r = nums.length;
		while(l < r){// pattern here
			int mid = (l + r) / 2;
			if(nums[mid] == target) return mid;
			if(nums[mid] > nums[l]){
				if(target >= nums[l] && target < nums[mid]) r = mid;
				else l = mid + 1;
			}
			else{
				if(target <= nums[r - 1] && target > nums[mid]) l = mid + 1;// pay attention to r - 1
				else r = mid;
			}
		}
		return -1;
	}
}