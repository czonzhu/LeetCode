public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        //1.  先结算再push
        for(int i = 0; i <= height.length; i++){
                int cur = i == height.length ? -1 : height[i];//1. 先结算再push
                while(!stack.empty() &&  cur <= height[stack.peek()]){
                    int h = height[stack.pop()];// 2. 一定先pop 背靠大树好乘凉
                    int w = stack.empty() ? i: i - stack.peek() - 1;// 3. 没有大树取自己
                    max = Math.max(max, h * w);
                }
                stack.push(i);
            
        }
        return max;
    }
}