package code1;

//Given n non-negative integers a1, a2, ..., an,
// where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with x-axis forms a container,
// such that the container contains the most water.
//
//        Note: You may not slant the container and n is at least 2.
//


public class ContainerWithMostWater {
    //time limit exceeded time(n) = n*(n - 1)/2
    //public int maxArea1(int[] height) {
    //
    //    int maxArea = 0;
    //    for (int i = 0; i < height.length; i++) {
    //        for (int j = i; j < height.length; j++) {
    //            int area = Math.min(height[i], height[j]) * Math.abs(j - i);
    //            maxArea = maxArea > area ? maxArea : area;
    //        }
    //    }
    //    return maxArea;
    //}

    //time(n) = O(n)
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
