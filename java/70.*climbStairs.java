public class Solution {
    public int climbStairs(int n) {
        if(n < 1) return -1;
        if(n <= 2) return n;
        int p = 1, pp = 1, cur = 0;
        for(int i = 2; i <= n; i++){
            cur = p + pp;
            pp = p;//change pp first;
            p = cur;
            
        }
        return cur;
        
    }
}