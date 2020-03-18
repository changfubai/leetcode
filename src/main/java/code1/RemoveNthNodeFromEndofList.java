package code1;

import java.util.ArrayList;

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.next;
        }
        int index = list.size() - n;
        if (index == 0) {
            head = head.next;
        } else {
            ListNode node = list.get(index - 1);
            node.next = node.next.next;
        }
        return head;
    }
}
