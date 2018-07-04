package greatAlgo;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int maxLen = 0, len = chars.length, count = 0;
        if (len < 2) return maxLen;
        int[] counters = new int[len + 1];
        counters[0] = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(') {
                counters[++count] = i;
            } else {
                if (count > 0) {
                    int tmpLen = i - counters[--count];
                    maxLen = maxLen > tmpLen ? maxLen : tmpLen;
                } else counters[0] = i;
            }
        }
        return maxLen;
    }
}
