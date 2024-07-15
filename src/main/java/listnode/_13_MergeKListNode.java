package listnode;

import java.security.Key;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-27 10:00
 */
@SuppressWarnings("all")
public class _13_MergeKListNode {

    // 分治合并
    public static ListNode m2(ListNode[] lists) {
        return divide(lists, 0, lists.length-1);
    }
    private static ListNode divide(ListNode[] lists, int left, int right) {
        if(left==right) {
            return lists[left];
        }
        if(left < right) {
            int mid=(left+right)/2;
            ListNode leftNode=divide(lists, left, mid);
            ListNode rightNode=divide(lists, mid, right);
            return merge(leftNode, rightNode);
        }
        return null;
    }

    // 顺序合并
    public static ListNode m1(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans=merge(ans, lists[i]);
        }
        return ans;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(left!=null && right!=null) {
            if(left.val < right.val) {
                curr.next=left;
                left=left.next;
            }else {
                curr.next=right;
                right=right.next;
            }
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
