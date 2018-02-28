package code1;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length, local = nums[0], global = nums[0];
        for (int i = 1; i < len; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}
