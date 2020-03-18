package code1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target? Find all unique quadruplets in the array
 * which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 *
 * 将4sum转成3sum，再转成2sum解决，注意为了减少复杂度，需要增加几种过滤条件：
 * 最大值大于给定值时结束当前循环
 * 限定条件下的最大值小于给定值时跳过当前循环
 *
 * 在做此题和3sum时，能想到进行转换，但实施过程中习惯在外层循环从两边向中间进行，
 * 导致重复或者遗漏，但均从同一方向进行就不会遇到此问题，需要切记！
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (target == sum) {
                        lists.add(Arrays.asList(nums[i],nums[left],nums[right],nums[j]));
                        left++;
                        right--;
                        while (nums[left] == nums[left - 1] && left < right) left++;
                        while (nums[right] == nums[right + 1] && left < right) right--;
                    } else if (target < sum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return lists;
    }
}
