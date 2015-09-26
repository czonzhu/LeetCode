public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int divisor = 1;
        while(x / divisor >= 10){
            divisor *= 10;
        }
        while(x != 0){
            int l = x / divisor;
            int r = x % 10;
            if(l != r) return false;
            x = x % divisor;
            x /= 10;
            divisor /= 100;
        }
        return true;
    }
}