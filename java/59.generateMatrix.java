public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rst = new int[n][n];
        if(n == 0) return rst;
        int row = n, col = n, num = 1;
        int i = 0, j = -1;
        while(true){
            for(int k = 0; k < col; k++)
                rst[i][++j] = num++;
            if(--row == 0) break;
            for(int k = 0; k < row; k++)
                rst[++i][j] = num++;
            if(--col == 0) break;
            for(int k = 0; k < col; k++)
                rst[i][--j] = num++;
            if(--row == 0) break;
            for(int k = 0; k < row; k++)
                rst[--i][j] = num++;
            if(--col == 0) break;
        }
        return rst;
    }
}