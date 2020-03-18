package code1;

/**
 * longestCommonPrefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0) {
            return prefix;
        } else if (strs.length == 1) {
            return strs[0];
        }
        while (strs[0].length() > prefix.length()) {
            prefix = strs[0].substring(0, prefix.length() + 1);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }
}
