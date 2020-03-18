package code1;

/**
 *Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * 我采用的是一次循环，分情况处理 代码要复杂一些，使用的临时变量更多
 * 可以获取链表的长度，再for循环处理，代码会简洁的多
 *
 */
public class ReverseNodesink_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        //空节点或只有一个节点或k==1时直接返回
        if (k == 1 || head == null || head.next == null) return head;
        int k_step = 1;
        //tmpHead 操作指针 newTmpHead 反序后的新队列的操作指针
        // tmpNode tmpNode1 tmpNode2 对某一个循环链进行反序操作时3的临时变量，需要三个才能保证反序进行
        // firstNode 每次循环队列的尾节点即是下次循环时首节点的前驱结点 tmpCircle 每次循环的尾节点
        ListNode tmpHead = head, newTmpHead = head, tmpNode = null, tmpNode1, tmpNode2, firstNode = head, tmpCircle;
        while (tmpHead != null) {
            //保存循环队列中的首结点 寻找k个结点作为倒序的循环结点，不足k个时结束
            if (k_step == 1) tmpNode = tmpHead;
            tmpHead = tmpHead.next;
            if (tmpHead == null) return head;
            k_step++;
            //找到第k个时做反序处理 先连接首结点，再从循环链中第一个结点开始反序
            if (k_step == k) {
                tmpCircle = tmpHead;
                tmpHead = tmpHead.next;
                //连接每一节的头部
                if (head == newTmpHead) {
                    head = tmpCircle;
                } else {
                    newTmpHead.next = tmpCircle;
                    newTmpHead = firstNode;
                }
                //处理循环链的反序 k=2时不需要三个变量
                firstNode = tmpHead;
                tmpNode1 = tmpNode.next;
                tmpNode2 = tmpNode1.next;
                if (k == 2) {
                    tmpNode1.next = tmpNode;
                    //链接到下个循环链的首结点，避免链断裂或中途退出导致信息丢失的情况
                    tmpNode.next = firstNode;
                    k_step = 1;
                }
                //反序 三个临时变量并行挪动 每次将第二个的后继指向第一个 然后平移三个指针
                while (k_step > 1) {
                    if (k == k_step) tmpNode.next = firstNode;
                    tmpNode1.next = tmpNode;
                    tmpNode = tmpNode1;
                    tmpNode1 = tmpNode2;
                    if (tmpNode2 == null) return head;
                    tmpNode2 = tmpNode2.next;
                    k_step--;
                }
            }
        }
        return head;
    }
}
