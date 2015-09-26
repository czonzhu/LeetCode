public class Solution {
    // StringBuilder.insert
    public String addBinary(String a, String b) {
        if((a == null || a.length() == 0) && (b == null && b.length() == 0)) return null;
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int digita = i >= 0 ? (a.charAt(i) - '0') : 0;
            int digitb = j >= 0 ? (b.charAt(j) - '0') : 0;
            int sum = digita + digitb + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if(carry > 0) sb.insert(0, carry);
        return sb.toString();
    }
}