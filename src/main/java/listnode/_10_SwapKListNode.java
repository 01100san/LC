package listnode;

import java.sql.Statement;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 22:17
 */
@SuppressWarnings("all")
public class _10_SwapKListNode {

    public static ListNode m1(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        // 定义两个指针，prev指向反转前的上一个节点 end 指向反转前的上一个节点
        ListNode prev=dummy;
        ListNode end=dummy;
        while(end.next!=null) {
            // 条件 反转的长度为 大于k,且 end != null
            for(int i=0;i<k && end!=null;i++) end=end.next;
            if(end==null)   break;
            // 记录反转前的后继节点
            ListNode next = end.next;
            end.next=null;
            // 开始反转节点
            ListNode start=prev.next;
            // prev 指向反转后的链表  1->2 变成2->1。 dummy->2->1
            prev.next=reverse(start);
            // 将反转后的链表和 之后将要被反转的链表拼接起来
            start.next=next;
            // 将prev替换成要反转的上一个节点
            prev=start;
            // 反转结束
            end=prev;
        }
        return dummy.next;
    }
    public static ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode curr =head;
        ListNode tmp;
        while (curr!=null) {
            tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        return prev;
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
