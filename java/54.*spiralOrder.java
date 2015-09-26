public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // A very classy problem, neat and clean
        List<Integer> rst = new ArrayList<Integer>();
        if(matrix == null||matrix.length == 0 || matrix[0].length == 0) return rst;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = -1;
        while(true){
            for(int k = 0; k < n; k++)
                rst.add(matrix[i][++j]);
            if(--m == 0) break;
            for(int k = 0; k < m; k++)
                rst.add(matrix[++i][j]);
            if(--n == 0) break;
            for(int k = 0; k < n; k++)
                rst.add(matrix[i][--j]);
            if(--m == 0) break;
            for(int k = 0; k < m; k++)
                rst.add(matrix[--i][j]);
            if(--n == 0) break;
        }
        return rst;
    }
}