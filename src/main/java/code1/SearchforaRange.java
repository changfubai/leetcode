package code1;

public class SearchforaRange {
    private int getRes(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = getRes(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        res[1] = getRes(nums, target, false) - 1;
        return res;
    }
}
