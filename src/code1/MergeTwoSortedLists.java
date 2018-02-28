package code1;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode res = null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            mergedList = l1;
            l1 = l1.next;
        } else {
            mergedList = l2;
            l2 = l2.next;
        }
        res = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                mergedList.next = l1;
                l1 = l1.next;
            } else {
                mergedList.next = l2;
                l2 = l2.next;
            }
            mergedList = mergedList.next;
        }
        if (l1 == null) mergedList.next = l2;
        if (l2 == null) mergedList.next = l1;
        return res;
    }
}
