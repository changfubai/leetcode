package code1;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else if (head.next.next == null) {
            head.next.next = head;
            head = head.next;
            head.next.next = null;
            return head;
        }
        ListNode tmpHead;
        ListNode tmpHead1;
        ListNode tmp;
        tmpHead = head;
        tmpHead1 = head;
        while (tmpHead != null && tmpHead.next != null) {
            tmp = tmpHead.next;
            tmpHead.next = tmp.next;
            tmp.next = tmpHead;
            tmpHead = tmpHead.next;
            if (tmpHead1 == head) {
                head = tmp;
            } else {
                tmpHead1.next = tmp;
                tmpHead1 = tmp.next;
            }
        }
        return head;
    }
}
