public class Solution{
	public int longestConsecutive(int[] nums){
		int len = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();// 1. <number, longestlenth with this num>
		for(int n : nums){
			if(map.containsKey(n)) continue;
			int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
			int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
			int sum = right + left + 1;// 2. combine the left region and right region
			map.put(n, sum);

			len = Math.max(len, sum);

			map.put(n - left, sum);// 3. only the bound is useful
			map.put(n + right, sum);
		}
		return len;
	}
}