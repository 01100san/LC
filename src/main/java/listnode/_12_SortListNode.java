package listnode;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-27 9:49
 */
@SuppressWarnings("all")
public class _12_SortListNode {

    // 自顶向下归并排序
    public static ListNode m1(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        // 使用双指针从中间分开归并
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode tmp=slow.next;
        // 断开节点，后续归并
        slow.next=null;
        ListNode left = m1(head);
        ListNode right=m1(tmp);
        ListNode ans = merge(left, right);
        return ans;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(left!=null && right!=null){
            if(left.val < right.val) {
                curr.next=left;
                left=left.next;
            }else {
                curr.next=right;
                right=right.next;
            }
            curr=curr.next;
        }
        curr.next=left!=null ? left : right;
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
