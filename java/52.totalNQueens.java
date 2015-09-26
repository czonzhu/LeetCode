public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n == 0) return 0;
        int[] col = new int[n], dio1 = new int[2 * n], dio2 = new int[2 * n];
        helper(col, dio1, dio2, n, 0);
        return count;
    }
    public void helper(int[] col, int[] dio1, int[] dio2, int n, int r){
        if(r == n) count++;
        for(int c = 0; c < n; c++){
            if(col[c] != 1 && dio1[r + c] != 1 && dio2[n + r - c] != 1){
                col[c] = 1; dio1[r + c] = 1; dio2[n + r - c] = 1;
                helper(col, dio1, dio2, n, r + 1);
                col[c] = 0; dio1[r + c] = 0; dio2[n + r - c] = 0;
            } 
        }
        return;
    }
}