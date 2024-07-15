package listnode;

import com.sun.javafx.scene.NodeEventDispatcher;

/**
 * <p>
 *  合并两个有序链表
 * @author zhl
 * @since 2024-06-26 21:09
 */
@SuppressWarnings("all")
public class _06_MergeTwoSortListNode {

    public static ListNode m1(ListNode list1, ListNode list2) {
        ListNode ans=new ListNode(-1);
        ListNode prev=ans;
        while(list1!=null && list2!=null) {
            if(list1.val > list2.val) {
                prev.next=list2;
                list2=list2.next;
            }else {
                prev.next=list1;
                list1=list1.next;
            }
            prev=prev.next;
        }
        prev.next=list1!=null?list1:list2;
        return ans.next;
    }

    static class ListNode {
        private int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
