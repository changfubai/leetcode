package code1;

/**
 * Created by changfubai96@gmail.com on 2018/7/12
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 1;
        }
        int[] arr = new int[length];
        for (int num : nums) {
            if (num > 0 && num <= length) {
                arr[num - 1] = num;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
