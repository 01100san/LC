package listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-26 20:45
 */
@SuppressWarnings("all")
public class _04_CircleNode {

    // 方法一:快慢指针
    public static boolean m1(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null && fast.next!=null) {
            if(fast==slow) {
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }

    // 方法二：哈希表
    public static boolean m2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while(node!=null) {
            // 添加失败说明 存在环状链表
            if (!set.add(node)) {
                return true;
            }
            node=node.next;
        }
        return false;
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
