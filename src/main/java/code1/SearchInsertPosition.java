package code1;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        for (int num : nums) {
            if (target <= num) break;
            res++;
        }
        return res;
    }
}
