public class Solution {
    public int reverse(int x) {
        long rst = 0;// prevent overflow
        while(x != 0 ){
            rst = rst * 10 + x % 10;
            if(rst > Integer.MAX_VALUE || rst < Integer.MIN_VALUE) return 0;// pay attention to minvalue
            x /= 10;
        }
        return (int)rst ;
    }
}