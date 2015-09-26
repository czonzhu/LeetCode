public class Solution {
    public int rob(int[] num) {//123
        int n = num.length;
        if(num == null|| num.length == 0) return 0;
        int prevYes = num[0], prevNo = 0, rst = num[0];
        for(int i = 1; i < n; i++){
            rst = Math.max(prevYes, prevNo + num[i]);
            prevNo = prevYes; prevYes = rst;
        }
        return rst;
        
    }
}