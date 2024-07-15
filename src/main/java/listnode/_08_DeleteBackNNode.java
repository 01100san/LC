package listnode;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 21:40
 */
@SuppressWarnings("all")
public class _08_DeleteBackNNode {

    // 方法一：双指针
    /*
         first 首先对链表遍历 n, 此时first 和 second 距离n个节点
        此时让 second 和 first 同时遍历，当first 遍历到末尾时, second 恰好指向第n个节点
        但是这时 first 和 second之间差n个节点，second在要被删除的节点上，
        我们最好找到它的前一个节点，方便删除，所以之间最好是 n+1个节点，second起始在虚拟头节点上
     */
    public static ListNode m1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i=0;i<n;i++) {
            first=first.next;
        }
        while (first!=null) {
            second=second.next;
            first=first.next;
        }
        // first==null, second 在 倒数第 n 个节点前一个节点的位置
        second.next=second.next.next;

        return dummy.next;
    }

    // 方法二：遍历列表长度，找出要删除的链表位置
    public static ListNode m2(ListNode head, int n) {
        ListNode node = head;
        int length = getLength(node);
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        for(int i=0; i<length-n;i++) {
            curr=curr.next;
        }
        curr=curr.next.next;
        return dummy.next;
    }

    private static int getLength(ListNode node) {
        int length=0;
        while (node!=null) {
            length++;
            node=node.next;
        }
        return length;
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
