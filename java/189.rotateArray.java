public class Solution{
	public void rotate(int[] nums, int k){
		// related to reverse words in string.
		if(nums == null || nums.length < 2) return;
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		return;
	}
	public void reverse(int[] nums, int start, int end){
		while(start < end){
			int tmp = nums[end];
			nums[end] = nums[start];
			nums[start] = tmp;
			start++;
			end--;
		}
		return;
	}
}

/*
	public class Solution{
	public void reverseWords(char[] s){
		// This traverse method of over 1 place can be found in maxGap
		if(s == null || s.length == 0) return;
		reverse(s, 0, s.length - 1);
		for(int i = 0, prev = 0; i <= s.length; i++){
			if(i == s.length || s[i] == ' '){
				reverse(s, prev, i - 1);
				prev = i + 1;
			}
		}
	}

	public void reverse(char[] s, int start, int end){
		while(start < end){
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
		return;
	}
}
*/