public class Solution {
    // Fill height than use the maximal rectangle algorithm
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] height = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0) height[i][j] = matrix[i][j] - '0' ;
                else height[i][j] = matrix[i][j] == '0' ? 0 : (height[i - 1][j] + 1); 
            }
        }
        
        for(int i = 0; i < m; i++){
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j <= n; j++){
                int cur = j == n ? -1 : height[i][j];
                while(!stack.empty() && cur <= height[i][stack.peek()]){// pay attention to this
                    int h = height[i][stack.pop()];
                    int w = stack.empty() ? j : j - 1 - stack.peek();
                    max = Math.max(max, h * w);
                }
                stack.push(j);
            }
        }
        return max;
    }
}