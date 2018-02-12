package code1;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int abs = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int tmpAbs = Math.abs(sum - target);
                if (tmpAbs == 0) {
                    return target;
                }
                if (tmpAbs < abs) {
                    abs = tmpAbs;
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
