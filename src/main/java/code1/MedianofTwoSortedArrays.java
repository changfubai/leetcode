package code1;

/**
 *
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5

 关键词： 齐头并进 特殊值优先  二分法
 *
 */
public class MedianofTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isOdd = false;
        int totalLen = nums1.length + nums2.length;
        if (totalLen == 0){
            return 0;
        }
        if (totalLen == 1){
            return nums1.length == 1 ? nums1[0] : nums2[0];
        }

        if (totalLen % 2 == 1){
            isOdd = true;
        }
        int i = 0, j = 0, n1 = 0, n2 = 0;

        for (int k = 0; k <= (totalLen + 1) / 2; k++){

            if (i == nums1.length){
                n2 = nums2[j++];
            }else if (j == nums2.length){
                n2 = nums1[i++];
            }else {
                if (nums1[i] < nums2[j]){
                    n2 = nums1[i++];
                } else {
                    n2 = nums2[j++];
                }
            }
            if (k == (totalLen + 1) / 2 - 1){
                n1 = n2;
            }
        }

        return isOdd ? n1 : (n1 + n2) / 2.0;
    }
}
