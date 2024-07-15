package listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 20:55
 */
@SuppressWarnings("all")
public class _05_CircleNode2 {

    // 方法一：快慢指针
    /*
        这里有个规律，让快指针比慢指针快两倍，则当 fast == slow时（存在环的位置），
        让 slow 继续next，再次开闭 ptr=head，同时移动，当 ptr==slow 时，就是入环点的位置
     */
    public static ListNode m1(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;

            // 存在环的位置，slow 在环内
            if(fast==slow) {
                ListNode ptr = head;
                while(ptr!=slow) {
                    ptr=ptr.next;
                    slow=slow.next;
                }
                // ptr==slow        入环点
                return ptr;
            }
        }
        return null;
    }

    // 方法二：哈希表
    public static ListNode m2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while(node!=null) {
            // 添加失败说明 存在环状链表
            if (!set.add(node)) {
                return node;
            }
            node=node.next;
        }
        return null;
    }


    static class ListNode {
        private int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next=null;
        }
    }
}
