public class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int maxIndex = 0, sum = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i] > height[maxIndex])
            maxIndex = i;
        }
        int max1 = 0;
        for(int i = 0; i < maxIndex; i++){
            if(height[i] > height[max1])
                max1 = i;
            else sum += height[max1] - height[i];
        }
        max1 = height.length - 1;
        for(int i = height.length - 1; i > maxIndex; i--){
            if(height[i] > height[max1]) max1 = i;
            else sum += height[max1] - height[i];
        }
        return sum;
        
    }
}