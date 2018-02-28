package code1;

import java.util.Stack;

/**
 *  使用 多种数据结构 可以做细致的优化，参见greatAlgo
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int maxLen = 0, len = s.length();
        Stack<Integer> seq = new Stack<>();
        boolean[] sBool = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') seq.push(i);
            if (s.charAt(i) == ')' && !seq.empty()) {
                sBool[seq.pop()] = true;
                sBool[i] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            while (i < len && sBool[i]) {
                tmp++;
                i++;
            }
            maxLen = maxLen > tmp ? maxLen : tmp;
        }
        return maxLen;
    }
}
