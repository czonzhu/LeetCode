public class Solution{
    //[]: l + 1 < r
	public int[] searchRange(int[] nums, int target){
		if(nums == null || nums.length == 0) return new int[]{-1, -1};
		int[] bound = new int[2];
		int l = 0, r = nums.length - 1;
		while(l + 1 < r){
			int mid = (l + r) / 2;
			if(nums[mid] >= target) r = mid;
			else l = mid;
		}
		if(nums[l] == target) bound[0] = l;// nice writing style because you can parse both left and right.
		else if(nums[r] == target) bound[0] = r;
		else return new int[]{-1, -1};

		l = 0; r = nums.length - 1;
		while(l + 1 < r){
			int mid = (l + r) / 2;
			if(nums[mid] <= target) l = mid;
			else r = mid;
		}
		if(nums[r] == target) bound[1] = r;
		else if(nums[l] == target) bound[1] = l;
		else return new int[]{-1, -1};
		return bound;
	}
}