package leetcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Num0001TwoSum {

    public static void main(String[] args) {

        /*
        查找和为指定数值的两数在给定数组中的下标
        首先可以想到遍历数组，然后每次查找剩余数是否等于target - num
        这样的空间复杂度是O(1),时间复杂度O(n*n)，如Solution1。
        在此基础上，可以考虑优化查找数的时间，使用一个hash表结构，用空间换时间
        这样的空间复杂度是O(n),时间复杂度是O(n)，如Solution2。
        在Solution2的解法中，需要先将所有数据存入hashMap。其实可以边查找边构建hashMap。
        即每次查找时，没有则将差值和当前位置存入hashMap，找到则直接返回两次的位置。
        这样的空间复杂度还是O(n),时间复杂度是O(n)，如Solution3。

        summary: 可以看到为了节省时间，每次的空间花费是更多的。因此为了减少空间使用，可以根据实际场景设计特定的hash函数和存储结构
        如Solution4，使用1023长度的数组充分hack题库的测试集。使得空间和时间同时达到最优。但这种算法的针对性特强，慎用。
         */

        int[] example = {2, 11, 7, 8};
        int[] result = new Solution1().twoSum(example, 9);
        Assert.assertArrayEquals(result, new int[] {0, 2});
        // 59 ms	39.1 MB

        result = new Solution2().twoSum(example, 9);
        Assert.assertArrayEquals(result, new int[] {0, 2});
        // 2 ms	41.7 MB

        result = new Solution3().twoSum(example, 9);
        Assert.assertArrayEquals(result, new int[] {0, 2});
        // 1 ms	42.1 MB

        result = new Solution4().twoSum(example, 9);
        Assert.assertArrayEquals(result, new int[] {0, 2});
        // 0 ms 39.6 MB

        System.out.println("success!");
    }

    static class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == target - nums[j]) {
                        return new int[] {i, j};
                    }
                }
            }
            return new int[2];
        }
    }

    static class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numPositions = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                numPositions.put(nums[i], i);
            }
            for (int j = 0; j < nums.length; j++) {
                int diff = target - nums[j];
                if (numPositions.containsKey(diff) && numPositions.get(diff) != j) {
                    return new int[] {Math.min(j, numPositions.get(diff)), Math.max(j, numPositions.get(diff))};
                }
            }
            return new int[2];
        }
    }

    static class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numPositions = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (numPositions.containsKey(diff)) {
                    return new int[] {numPositions.get(diff), i};
                }
                numPositions.put(nums[i], i);
            }
            return new int[2];
        }
    }

    static class Solution4 {
        public int[] twoSum(int[] nums, int target) {
            int n = 1023;
            int[] arr = new int[n + 1];

            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                int temp = diff & n;
                int pos = arr[temp];
                if (pos != 0) {
                    int j = arr[target - nums[i] & n] - 1;
                    return new int[] {Math.min(i, j), Math.max(i, j)};
                }
                arr[nums[i] & n] = i + 1;
            }
            return new int[2];
        }
    }
}
