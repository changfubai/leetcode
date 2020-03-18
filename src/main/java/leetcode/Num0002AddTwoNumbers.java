package leetcode;

import leetcode.common.ListNode;

/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class Num0002AddTwoNumbers {
    public static void main(String[] args) {
        /*
        计算两个链表表示的数字之和，只需要模拟加法运算过程即可。
        两个链表的节点同步推进，相加后保留进位，下次加上进位。当遇到某一方为空时结束
        这个题没有别的思路，需要特别注意边界条件：
            1、头结点为空的情况
            2、最后遇到空节点时，需要将另一链表接在最后并加上进位

         思考： 这个题的解法也可以作为大数想加或相乘的解法。
        */
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode root = new ListNode(carry);
            ListNode tmp = root;
            while (l1 != null && l2 != null) {
                tmp.next = new ListNode((l1.val + l2.val) % 10 + carry);
                carry = root.val = (l1.val + l2.val) / 10;
                tmp = tmp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 == null && l2 == null && carry != 0) {
                    tmp.next = new ListNode(carry);
            }
            return root.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
