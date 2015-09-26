public class Solution{
	//[] search pattern
	public int searchInsert(int[] nums, int target){
		if(nums == null || nums.length == 0) return 0;
		int l = 0, r = nums.length - 1;
		while(l + 1 < r){// pattern feature
			int mid = (l + r) / 2;
			if(nums[mid] == target) return mid;//pattern feature
			if(nums[mid] < target) l = mid;
			else r = mid;
		}
		if(target <= nums[l]) return l;// pay attention that the while may haven't begun.
		else if(target > nums[r]) return r + 1;
		else return r;
	}
}