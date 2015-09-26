public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        int i = 0, sign = 1;
        long rst = 0;
        // Dealing Blank
        while(i < chars.length && chars[i] == ' ')
                i++;
        //Dealing Sign
        if(chars[i] == '+' || chars[i] == '-'){
            if(chars[i] == '-')
                sign = -1;
            i++;
        }
        //Dealing Value
        while(i < chars.length){
            int digit = chars[i++] - '0';
            if(digit < 0 || digit > 9) break;
            rst = rst * 10 + digit;
            if(sign == -1 && -rst < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(sign == 1 && rst > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        return sign == 1 ? (int)rst : (int)-rst;
    }
}