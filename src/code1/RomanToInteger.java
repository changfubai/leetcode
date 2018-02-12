package code1;

/**
 *
 * Given a roman numeral, convert it to an integer.
 *
 *Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        String[] RomanDict = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
                , "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
                , "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
                , "M", "MM", "MMM"};
        int[] IntegerDict = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9
                , 10, 20, 30, 40, 50, 60, 70, 80, 90
                , 100, 200, 300, 400, 500, 600, 700, 800, 900
                , 1000, 2000, 3000};
        int res = 0;
        int len = RomanDict.length - 1;
        while (s.length() > 0) {

            for (; len >= 0; len--) {
                if (s.startsWith(RomanDict[len])) {
                    res = res + IntegerDict[len];
                    s = s.substring(RomanDict[len].length(), s.length());
                    break;
                }
            }
        }
        return res;
    }
}
