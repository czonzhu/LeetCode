public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null) return new int[] {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i]))
                map.put(nums[i], i + 1);
            else{
                return new int[]{map.get(target - nums[i]), i + 1};
            }
        }
        
        return new int[]{-1, -1};
    }
}