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
    public void show(ListNodes node){
        new ListNodes().show(node);
    }

    public ListNodes add(int a[]){
        return new ListNodes().addNums(a);
    }
    public ListNodes addTwoNumbers(ListNodes l1, ListNodes l2) {
        ListNodes l3 = new ListNodes(0);
        ListNodes head = l3;
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
            l3.next = new ListNodes(carry % 10);
            carry /= 10;
            l3 = l3.next;
        }
        if (carry == 1) {
            l3.next = new ListNodes(carry);
        }
        return head.next;
    }
}

class ListNodes {
    int val;
    ListNodes next;

    ListNodes(){}

    ListNodes(int x) {
        val = x;
    }
    void show(ListNodes node){
        StringBuilder s1 = new StringBuilder(val);
        ListNodes tmp = node.next;
        while (tmp != null){
            s1.append("->" + tmp.val );
        }
        System.out.println(s1);
    }
    public ListNodes addNums(int a[]){
        ListNodes tmp = new ListNodes(a[0]);
        this.next = tmp;
        for (int i = 1; i < a.length; i++){
            tmp.next = new ListNodes(a[i]);
            tmp = tmp.next;
        }
        return this.next;
    }
}
