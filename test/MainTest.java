import code1.AddTwoNumbers;
import code1.LongestSubstringWithoutRepeatingCharacters;
import code1.MedianofTwoSortedArrays;
import code1.TwoSum;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testMedianofTwoSortedArrays(){
        assertEquals(0, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{},new int[]{}));
        assertEquals(2, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{},new int[]{1,2,3}));
        assertEquals(2.5, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
        assertEquals(4, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2,4,5,6,7}));
        assertEquals(4.5, new MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,3},new int[]{2,4,5,6,7,8}));

    }



}
