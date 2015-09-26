public class Solution{
	public int maximalRectangle(char[][] matrix){
		if(matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length;
		int[] left = new int[n], right = new int[n], height = new int[n];
		Arrays.fill(right, n);
		int maxA = 0;

		for(int i = 0; i < m; i++){
			int cur_left = 0, cur_right = n;
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == '1') height[j]++;
				else height[j] = 0;
			}
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
				else{
					left[j] = 0;
					cur_left = j + 1;
				}
			}

			for(int j = n - 1; j >= 0; j--){
				if(matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
				else{
					right[j] = n;
					cur_right = j;
				}
			}

			for(int j = 0; j < n; j++)
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
			
		}
		return maxA;
	}
}