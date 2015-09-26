public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Similar to candy: one pass from left and one pass from right. Uset a right prev to avoid the saved rst[i]
        if(nums == null || nums.length == 0) return nums;
        int[] rst = new int[nums.length];
        rst[0] = 1;
        for(int i = 1; i < nums.length; i++)
            rst[i] = rst[i - 1] * nums[i - 1];
        int prev = 1;
        for(int j = nums.length - 1; j >= 0; j--){
            rst[j] *= prev;
            prev *= nums[j];
        }
        return rst;
    }
}