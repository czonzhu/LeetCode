public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m / 2; i++){
            for(int j = 0; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = tmp;
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = i; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        return;
    }
    
  
}