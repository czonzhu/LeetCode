public class Solution {
    // Tow pointer similar to 3 sum.
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix[0] == null) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while(row < m && col >= 0){
            if(target == matrix[row][col]) return true;
            if(target < matrix[row][col]) col--;
            else if(target > matrix[row][col]) row++;
        }
        return false;
    }
}