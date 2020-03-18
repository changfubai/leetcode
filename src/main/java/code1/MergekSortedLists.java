package code1;

import java.util.ArrayList;
import java.util.Arrays;

public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                list.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        if (list.size() == 0) return null;
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        ListNode node = null;
        ListNode nodeFinal = null;
        for (int i = 0; i < res.length; i++) {
            ListNode tmp = new ListNode(res[i]);
            if (node == null) {
                node = tmp;
                nodeFinal = node;
            } else {
                node.next = tmp;
                node = node.next;
            }
        }
        return nodeFinal;
    }
}
