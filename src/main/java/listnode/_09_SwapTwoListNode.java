package listnode;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 22:03
 */
@SuppressWarnings("all")
public class _09_SwapTwoListNode {

    // 迭代
    /*
        原 tmp->node1->node2
        后 tmp->node1         ->        node3->node4
                                  node2 ->
            tmp->node2->node1 -> node3->node4
            node2->node1(tmp) -> node3->node4
     */
    public static ListNode m1(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode tmp = dummy;
        while (tmp.next!=null && tmp.next.next!=null) {
            ListNode node1=tmp.next;
            ListNode node2=tmp.next.next;
            node1.next=node2.next;
            node2.next=node1;
            tmp=node1;
        }
        return dummy.next;
    }

    static class ListNode {
        private int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
