public class Solution {
    public int titleToNumber(String s) {
        int rst = 0;
        for(char c : s.toCharArray()){
            rst = rst * 26 + (c - 'A') + 1;
        }
        return rst;
    }
}