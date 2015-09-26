public class Solution{
	// 1. find the one that is not increasing 2. change a number larger with it. 3. reverse the element behind
	public void nextPermutation(int[] nums){//687432
		if(nums == null || nums.length == 0)return;
		int len = nums.length;
		for(int i = len - 2; i >= 0; i--){
			if(nums[i] < nums[i + 1]){// not <= 
				for(int j = len - 1; j >= i; j--){
					if(nums[j] > nums[i]){// not >=
						swap(nums, i, j);
						reverse(nums, i + 1, len - 1);
						return;
					}
				}
			}
		}
		reverse(nums, 0, len - 1);// if no dec find, reverse the whole array.
		return;
	}

	public void swap(int[] nums, int l, int r){
		int tmp = nums[r];
		nums[r] = nums[l];
		nums[l] = tmp;
		return;
	}

	public void reverse(int[] nums, int l, int r){
		while(l < r){
			swap(nums, l, r);
			l++;
			r--;
		}
		return;
	}
}