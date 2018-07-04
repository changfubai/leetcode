import code1.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MainTest {

    private static long sTime = 0;
    @BeforeAll
    public static void testStart(){
        System.out.println("测试开始：");
        sTime = System.currentTimeMillis();
    }

    @AfterAll
    public static void testEnd(){
        System.out.println("测试结束，总计耗时："+ (System.currentTimeMillis() - sTime) + "ms" );
    }

    //@Test
    //public void testTwoSum(){
    //    assertEquals(true, Arrays.equals(new int[]{0,1}, new TwoSum().twoSum(new int[]{2, 7, 11, 15},9)));
    //    assertEquals(true, Arrays.equals(new int[]{1,2}, new TwoSum().twoSum(new int[]{3,2,4},6)));
    //}
    //@Test
    //public void testNotReaptingCharacters(){
    //    assertEquals(1, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
    //    assertEquals(3, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    //    assertEquals(1, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("b"));
    //    assertEquals(0, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(""));
    //    assertEquals(3, new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdy"));
    //}

    //@Test
    //public void testMedianofTwoSortedArrays(){
    //    assertEquals(0, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{},new int[]{}));
    //    assertEquals(2, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{},new int[]{1,2,3}));
    //    assertEquals(2.5, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
    //    assertEquals(4, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2,4,5,6,7}));
    //    assertEquals(4.5, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2,4,5,6,7,8}));
    //
    //}
    //@Test
    //public void testLongestPalindromicSubstring(){
    //    assertEquals("", new LongestPalindromicSubstring().longestPalindrome(""));
    //    assertEquals("a", new LongestPalindromicSubstring().longestPalindrome("abcde"));
    //    assertEquals("badab", new LongestPalindromicSubstring().longestPalindrome("babadab"));
    //    assertEquals("aaabaaa", new LongestPalindromicSubstring().longestPalindrome("aaaabaaa"));
    //    assertEquals("ccccc", new LongestPalindromicSubstring().longestPalindrome("ccccc"));
    //    assertEquals("fklkf", new LongestPalindromicSubstring().longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
    //}
    //@Test
    //public void testLongestZigZagConversion(){
    //    assertEquals("PAHNAPLSIIGYIR", new ZigZagConversion().convert("PAYPALISHIRING", 3));
    //    assertEquals("", new ZigZagConversion().convert("", 3));
    //    assertEquals("PAYPALISHIRING", new ZigZagConversion().convert("PAYPALISHIRING", 1));
    //}
    //@Test
    //public void testLongestZigZagConversion(){
    //    assertEquals(0, new ReverseInteger().reverse(Integer.MIN_VALUE));
    //    assertEquals(-1, new ReverseInteger().reverse(-100));
    //    assertEquals(123, new ReverseInteger().reverse(321));
    //    assertEquals(0, new ReverseInteger().reverse(-1147483648));
    //    assertEquals(0, new ReverseInteger().reverse(1147483648));
    //}
    //@Test
    //public void testLongestZigZagConversion(){
    //    assertEquals(0, new StringtoInteger_atoi().myAtoi("  a123"));
    //    assertEquals(123, new StringtoInteger_atoi().myAtoi("  +123"));
    //    assertEquals(-123, new StringtoInteger_atoi().myAtoi("  -123"));
    //    assertEquals(Integer.MAX_VALUE, new StringtoInteger_atoi().myAtoi("  +123333333333333333333"));
    //    assertEquals(0, new StringtoInteger_atoi().myAtoi("  123a"));
    //}
    //@Test
    //public void testLongestZigZagConversion(){
    //    assertEquals(true, new PalindromeNumber().isPalindrome(11));
    //    assertEquals(true, new PalindromeNumber().isPalindrome(12221));
    //    assertEquals(false, new PalindromeNumber().isPalindrome(-11));
    //    assertEquals(false, new PalindromeNumber().isPalindrome(1000021));
    //
    //}
    //@Test
    //public void testLongestZigZagConversion(){
    //    assertEquals(false, new RegularExpressionMatching().isMatch("aa","a"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("aa","aa"));
    //    assertEquals(false, new RegularExpressionMatching().isMatch("aaa","aa"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("aa", "a*"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("aa", ".*"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("ab", ".*"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("aab", "c*a*b"));
    //    assertEquals(false, new RegularExpressionMatching().isMatch("caabaab", "c*ab"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("caaaab", "ca*b"));
    //    assertEquals(false, new RegularExpressionMatching().isMatch("caaaab", "c*ab"));
    //    assertEquals(false, new RegularExpressionMatching().isMatch("", "..ac"));
    //    assertEquals(false, new RegularExpressionMatching().isMatch("ab", ".*c"));
    //    assertEquals(true, new RegularExpressionMatching().isMatch("aaa", "ab*a*c*a"));
    //
    //}

    //@Test
    //public void testThreeSum() {
    //    new SearchforaRange().searchRange(new int[]{2,2}, 2);
    //}
    @Test
    public void comSum() {
        new CombinationSum2().combinationSum2(new int[]{2,5,2,1,2}, 5);
    }

}
