package listnode;

import sun.nio.cs.MS1250;

import java.awt.*;
import java.util.List;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 20:07
 */
@SuppressWarnings("all")
public class _02_ReverseNode {

    // 迭代
    public static ListNode m1(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
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
