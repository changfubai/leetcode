package code1;

/**
 *
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int num1 = -1, num2 = -1;
        for (int i = 0; i < nums.length; i++){
            num1 = i;
            for (int j = nums.length - 1; j > i; j--){
                if (nums[j] + nums[i] == target ){
                    num2 = j;
                    break;
                }
            }
            if (num2 != -1){
                break;
            }
        }
        return new int[]{num1,num2};
    }
}
