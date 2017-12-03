package code1;
/**
 * 这个题是非常简单的队列方面的问题，但很久没有动脑，解题过程出现了很大的思维错误。
 * 作为警示，以后的题需要先思考，列出数据结构和解法思路，然后写出测试用例后再写代码。
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 ->
 *
 * 关键词： 齐头并进
 */

public class AddTwoNumbers {
    static AddTwoNumbers numbers;
    public static AddTwoNumbers getInstance(){
        if (numbers == null)
            numbers = new AddTwoNumbers();
        return numbers;
    }
    public void show(ListNode node){
        new ListNode().show(node);
    }

    public ListNode add(int a[]){
        return new ListNode().addNums(a);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            l3.next = new ListNode(carry % 10);
            carry /= 10;
            l3 = l3.next;
        }
        if (carry == 1) {
            l3.next = new ListNode(carry);
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int x) {
        val = x;
    }
    void show(ListNode node){
        StringBuilder s1 = new StringBuilder(val);
        ListNode tmp = node.next;
        while (tmp != null){
            s1.append("->" + tmp.val );
        }
        System.out.println(s1);
    }
    public ListNode addNums(int a[]){
        ListNode tmp = new ListNode(a[0]);
        this.next = tmp;
        for (int i = 1; i < a.length; i++){
            tmp.next = new ListNode(a[i]);
            tmp = tmp.next;
        }
        return this.next;
    }
}
