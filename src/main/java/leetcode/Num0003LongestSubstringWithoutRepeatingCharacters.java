package leetcode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 Given a string, find the length of the longest substring without repeating characters.

 Example 1:

 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Num0003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        /*
        求解不重复最长子串，这个题可以联想到Num0001TwoSum的解法，就是找边界上的数相等的区间。只不过多了一步记录区间长度的过程
        因此，解法也相对类似。

        解法一(solution1)：
        暴力求解 O(n*n*n)
        左边界从第一个数开始，右边界从第二个数开始寻找，直到找到子串重复的情况，记录下长度，左边界右移继续循环查找，直到右边界到最大长度。

        解法二(solution2)：
        滑动窗口 O(2*n)
        既然是求解不重复的边界问题，那么就可以让边界移动起来，右边届往右延生，直到遇到重复的元素，然后左边界右移。

        解法三(solution3):
        解法二存在重复查找问题，即区间如果存在重复的字符，那么该区间可以直接跳过检查，直接从重复的位置开始查找

        解法四(solution4):
        兼顾效率和空间的做法
        优化：1、使用数组而不是charAt；2、用游标表示左边界

        解法五(solution5)
        优化点：利用ASCII 码，最大长度减少空间利用
        */

        String test = "abcabcbb";

        Assert.assertEquals(3, new Solution1().lengthOfLongestSubstring(test));
        // Time Limit Exceeded

        Assert.assertEquals(3, new Solution2().lengthOfLongestSubstring(test));
        // 7 ms	41.4 MB

        Assert.assertEquals(3, new Solution3().lengthOfLongestSubstring(test));
        // 6 ms	41.5 MB

        Assert.assertEquals(3, new Solution4().lengthOfLongestSubstring(test));
        // 1 ms	39.6 MB

        Assert.assertEquals(3, new Solution5().lengthOfLongestSubstring(test));
        // 3 ms	39.2 MB
        System.out.println("success!");
    }

    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    if (uniqueStr(s, i, j)) {
                        ans = Math.max(ans, j - i);
                    }
                }
            }
            return ans;
        }

        private boolean uniqueStr(String s, int start, int end) {
            HashSet<Character> unique = new HashSet<>();
            for (int i = start; i < end; i++) {
                if (unique.contains(s.charAt(i))) {
                    return false;
                }
                unique.add(s.charAt(i));
            }
            return true;
        }
    }

    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0, left = 0, right = 0;
            HashSet<Character> characters = new HashSet<>();
            while (left < s.length() && right < s.length()) {
                if (characters.contains(s.charAt(right))) {
                    characters.remove(s.charAt(left++));
                } else {
                    characters.add(s.charAt(right++));
                    ans = Math.max(ans, right - left);
                }
            }
            return ans;
        }
    }

    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            Map<Character, Integer> characterIndex = new HashMap<>();

            for (int i = 0, index = 0; i < s.length(); i++) {
                if (characterIndex.containsKey(s.charAt(i))) {
                    index = Math.max(characterIndex.get(s.charAt(i)), index);
                }
                // 默认+1 解决单字符串的问题
                ans = Math.max(ans, i - index + 1);
                characterIndex.put(s.charAt(i), i + 1);
            }
            return ans;
        }
    }

    static class Solution4 {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0, left = 0;
            if (s.length() == 0) {
                return ans;
            }
            char[] chars = s.toCharArray();
            for (int right = 1; right < chars.length; right++) {
                for (int i = left; i < right; i++) {
                    if (chars[i] == chars[right]) {
                        left = i + 1;
                        break;
                    }
                }
                ans = Math.max(right - left, ans);
            }
            return ans + 1;
        }
    }

    static class Solution5 {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            int[] index = new int[128];
            for (int right = 0, left = 0; right < s.length(); right++) {
                left = Math.max(left, index[s.charAt(right)]);
                ans = Math.max(ans, right - left + 1);
                index[s.charAt(right)] = right + 1;
            }
            return ans;
        }

    }
}
