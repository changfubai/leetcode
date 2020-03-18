package code1;

/**
 *
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"

 超时！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！

 关键词：睦邻友好 布尔矩阵
 *
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome2(String s) {
        int max = 1;
        int lenMax = 1;
        String palindrome;
        if (s == null || "".equals(s)){
            return "";
        }
        palindrome = s.substring(0,1);

        for (int i = 0; i < s.length(); i++){
            if (i + max >= s.length()){
                break;
            }
            int j = 1;
            while (true){
                boolean isOdd = false;
                int len = j + lenMax;
                if (len + i > s.length()){
                    break;
                }else if (len % 2 == 1){
                    isOdd = true;
                }
                if (isOdd){
                    if (s.substring(i, i + len / 2).equals(new StringBuffer(s.substring(i + len / 2 + 1, i + len)).reverse().toString())){
                        max = len;
                        palindrome = s.substring(i, len + i);
                    }
                }else {
                    if (s.substring(i, i + len / 2).equals(new StringBuffer(s.substring(i + len / 2, i + len)).reverse().toString())){
                        max = len;
                        palindrome = s.substring(i, len + i);
                    }
                }
                j++;
            }
            lenMax = max;

        }

        return palindrome;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean isPal[][] = new boolean[s.length()][s.length()];
        String maxStr = "";
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    maxStr = maxStr.length() > s.substring(i, j + 1).length() ? maxStr : s.substring(i, j + 1);
                }
            }
        }//end for j
        return maxStr;
    }
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
