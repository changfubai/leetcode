package code1;

import java.util.Arrays;

/**
 *
 * 求全排列的下一种情况
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    void reverse(int[] nums, int index) {
        int i = index, j = nums.length - 1;
        while (i++ < j--) swap(nums, i - 1, j + 1);
    }
    void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
