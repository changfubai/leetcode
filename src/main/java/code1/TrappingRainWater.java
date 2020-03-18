package code1;

import java.util.Stack;

/**
 * Created by changfubai96@gmail.com on 2018/7/12
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int size = height.length;
        if(size < 2){
            return 0;
        }
        int left = 0, lMax = 0, right = size - 1, rMax = 0, trapped = 0;
        while(left < right){
            if(height[left] < height[right]){
                int h = height[left];
                left++;
                if(h >= lMax){
                    lMax = h;
                }else{
                    trapped += (lMax - h);
                }
            }else{
                int h = height[right];
                right--;
                if(h >= rMax){
                    rMax = h;
                }else{
                    trapped += (rMax - h);
                }
            }
        }
        return trapped;
    }
}
