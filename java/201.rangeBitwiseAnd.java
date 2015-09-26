public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int r = Integer.MAX_VALUE;
        while((m & r) != (n & r)) r <<= 1;
        return m & r;
    }
}