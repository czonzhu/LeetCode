public class Solution {
    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do{
            fast = generateNext(fast);
            fast = generateNext(fast);
            slow = generateNext(slow);
        } while(fast != slow);
        return fast == 1;
    }
    public int generateNext(int num){
        int rst = 0;
        while(num != 0){
            rst += (num % 10) * (num % 10);
            num /= 10;
        }
        return rst;
    }
}