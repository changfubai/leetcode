package code1;

/**
 *
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 关键词： 找找看
 *
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.equals("") || numRows < 1){
            return "";
        }
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int size = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++){
            for (int j = i; j < s.length(); j += size){
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1){
                    int tmp =  j + size - 2 * i;
                    if (tmp < s.length()){
                        sb.append(s.charAt(tmp));
                    }
                }
            }
        }
        return sb.toString();
    }
}
