package listnode;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 21:34
 */
@SuppressWarnings("all")
public class _07_TwoListNodeSum {

    public static ListNode m1(ListNode l1, ListNode l2) {
        int sum=0;
        ListNode prev=new ListNode(-1);
        ListNode curr=prev;
        // 进位数
        int carry=0;
        while(l1 != null || l2!=null) {
            int x=l1==null ? 0 : l1.val;
            int y=l2==null ? 0 : l2.val;
            sum=x+y+carry;
            // 求进位数
            carry=sum/10;
            sum=sum%10;

            curr.next=new ListNode(sum);
            curr=curr.next;

            if (l1!=null) {
                l1=l1.next;
            }
            if (l2!=null) {
                l2=l2.next;
            }
        }
        if(carry==1) {
            curr.next=new ListNode(carry);
        }
        return prev.next;
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
