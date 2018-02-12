package code1;

/**
 *
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

 关键词： 分而治之  特殊关怀
 *
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x - 1 == Integer.MAX_VALUE || x == 0){
            return 0;
        }
        if (x < 0){
            isNegative = true;
            x = -x;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x)).reverse();
        if (Double.valueOf(sb.toString()) > Double.valueOf(Integer.MAX_VALUE) && isNegative == false){
            return 0;
        }
        if (Double.valueOf(sb.toString()) > -1 * Double.valueOf(Integer.MIN_VALUE) && isNegative == true){
            return 0;
        }
        x = Integer.valueOf(sb.toString());
        return isNegative ? -x : x;
    }
}
