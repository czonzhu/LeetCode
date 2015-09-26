public class Solution{
	public int trailingZeroes(int n){
		// One layer by one layer. first 5 factor, then second.
		int rst = 0;
		while(n > 1){
			n /= 5;
			rst += n;
		}
		return rst;
	}
}