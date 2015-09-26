public class Solution{
	public int candy(int[] ratings){
		if(ratings == null || ratings.length == 0) return 0;
		int n = ratings.length;
		int[] candy = new int[n];
		Arrays.fill(candy, 1);
		for(int i = 1; i < n; i++){
			if(ratings[i] > ratings[i - 1]) candy[i] = candy[i - 1] + 1; // 保证右边高过左边 For increasing situation 
		}
		for(int i = n - 2; i >= 0; i--){
			if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) candy[i] = candy[i + 1] + 1;// 保证左边高过右边 for decreasing situation
		}
		int rst = 0;
		for(int num : candy)
			rst += num;
		return rst;
	}
}