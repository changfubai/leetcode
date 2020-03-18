package code1;

import java.util.ArrayList;

/**
 *
 * Given an integer, convert it to a roman numeral.
 *
 *Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String[][] RomanDict = new String[][] {
                { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
                { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
                { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
                { "", "M", "MM", "MMM", "", "", "", "", "", "", "" },
        };
        return RomanDict[3][num / 1000] +
                RomanDict[2][num % 1000 / 100] +
                RomanDict[1][num % 100 / 10] +
                RomanDict[0][num % 10];
    }
}
