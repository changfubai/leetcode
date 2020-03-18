package code1;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head != null && head.val == val) head = head.next;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            if (val == tmp.next.val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}
