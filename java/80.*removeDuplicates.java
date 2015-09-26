public class Solution {
    public int removeDuplicates(int[] nums) {
        // 1. judge the number before index 2. initialize position is different.
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= 2) return nums.length;
        int index = 1;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[index - 1])
                nums[++index] = nums[i];
        }
        return index + 1;
    }
}