public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1])         {
                swap(nums, i, nums[i] - 1);//loopcondition 1. not overflow 2. not changing constantly 3. havent to the right position.
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;// pay attention to this in which all the position is right
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}