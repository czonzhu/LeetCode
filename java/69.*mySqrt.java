public class Solution {
    public int mySqrt(int x) {
        // 1. pattern (l < r) [) l = mid + 1   2. last.
        if(x < 0) return -1;
        if(x <= 1) return x;
        int l = 1, r = x, last = 0;
        while(l < r){
            int mid = (l + r) / 2;
            if(mid == x / mid) return mid;
            else if(mid < x / mid) {
                l = mid + 1;
                last = mid;
            }
            else r = mid;
        }
        
        return last;
    }
}