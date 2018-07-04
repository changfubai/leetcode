package greatAlgo;

public class LongestPalindorm {
    public String longestPalindrome(String s) {
        char T[] = conVertToSuper(s);
        int n = T.length;

        int [] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++){
            int i_mirror = 2 * C - i;

            P[i] = (R > i) ? Math.min(R - i, P[i_mirror]) : 0;

            while (T[i + 1 + P[i]] == T[i - 1 - P[i]])
                P[i]++;

            if (i + P[i] > R){
                C = i;
                R = i + P[i];
            }

        }
        int maxLen = 0;
        int currentIndex = 0;
        for (int i = 1; i < n - 1; i++){
            if (P[i] > maxLen){
                maxLen = P[i];
                currentIndex = i;
            }
        }
        return s.substring((currentIndex - 1 - maxLen) / 2, (currentIndex - 1 + maxLen) / 2);
    }
    char[] conVertToSuper(String s){
        int n = s.length();
        if (n == 0)
            return "*$".toCharArray();
        StringBuilder superStr = new StringBuilder("*");
        for (int i = 0; i < s.length(); i++){
            superStr.append("#").append(s.charAt(i));
        }
        return superStr.append("#$").toString().toCharArray();
    }
}

//方法二：不用理会奇偶关系
class Solution {
    int len = 0, maxLength = 0, init = 0;
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        len = s.length();
        if (len <= 1) return s;
        for (int i = 0; i < len; i++) {
            i = manacher(chars, i);
        }
        return s.substring(init, init + maxLength);
    }
    public int manacher(char[] chars, int k) {
        int i = k - 1, j = k;
        while (j < len - 1 && chars[j] == chars[j + 1]) j++;
        int nextCenter = j++;
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            init = i + 1;
        }
        return nextCenter;
    }
}