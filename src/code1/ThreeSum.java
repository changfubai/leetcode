package code1;

import java.util.*;

/**
 *
 *Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i]<=0;i++) {
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    List<Integer> list = new LinkedList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) left++;
                    right--;
                    while (nums[right] == nums[right + 1] && left < right) right--;
                } else if (nums[left] + nums[right] > sum) {
                    right--;
                } else {
                    left++;
                }
            }
            while (i<nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return lists;
    }
}
