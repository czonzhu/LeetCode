public class Solution {
    //1. The trick is to initialize carry as 1 2. initiate a new if 100000.
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        int carry = 1, n = digits.length;
        for(int i = digits.length - 1; i >= 0; i--){
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if(carry > 0){
            digits = new int[n + 1];
            digits[0] = 1; 
        }
        return digits;
    }
}