package listnode;

import java.io.ObjectInputStream;
import java.util.concurrent.*;

/**
 * <p>
 *  相交链表
 * @author zhl
 * @since 2024-06-26 19:55
 */
public class _01_XNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (headA!=null || headB!=null) {
            if(headA==null) {
                headA=nodeB;
            }
            if(headB==null){
                headB=nodeA;
            }
            if(headB.val==headA.val && headA==headB) {
                return headA;
            }

            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }


    class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

