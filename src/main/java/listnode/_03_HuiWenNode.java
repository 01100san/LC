package listnode;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 20:26
 */
@SuppressWarnings("all")
public class _03_HuiWenNode {
    
    // 快慢指针, 快指针移动一半，反转满指针后的部分
    public static boolean m1(ListNode head) {
        if (head==null || head.next==null) {
            return true;
        }

        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }
        // 此时 slow 为链表中间的节点, 反转slow后的节点
        ListNode backNode = reverseNode(slow);
        ListNode fontNode = head;
        //节点可能是奇数个，slow要比原节点少一个
        while(backNode != null) {
            if(fontNode.val!= backNode.val) {
                return false;
            }
            fontNode = fontNode.next;
            backNode=backNode.next;
        }
        return true;
    }

    private static ListNode reverseNode(ListNode node) {
        ListNode prev=null;
        ListNode curr=node;
        ListNode tmp;
        while(curr!=null){
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        return prev;
    }

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
