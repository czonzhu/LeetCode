public class Solution{
	public void sortColors(int[] nums){
		if(nums == null || nums.length < 1) return;
		int l = 0, r = nums.length - 1, i = 0;
		while(i <= r){
			if(nums[i] == 1) i++;
			else if(nums[i] == 0)
				swap(nums, i++, l++);
			else if(nums[i] == 2)
				swap(nums, i, r--);
		}
		return;
	}
	public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}