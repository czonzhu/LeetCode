public class Solution{
	public String getPermutation(int n, int k){
		List<Integer> nums = new ArrayList<Integer>();
		k--;
		StringBuilder sb = new StringBuilder();
		int fact = 1;
		for(int i = 1; i <= n; i++)
			nums.add(i);
	    for(int i = 2; i <= n; i++)
			fact *= i;
		for(int i = n; i > 0; i--){
			fact /= i;
			sb.append(nums.remove(k / fact));
			k %= fact;
		}
		return sb.toString();
	}
}