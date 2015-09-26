public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) return nums.length;
        int prev = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[prev]){
                nums[++prev] = nums[i];
            }
        }
        return prev + 1;//pay attention to the return length
    }
}