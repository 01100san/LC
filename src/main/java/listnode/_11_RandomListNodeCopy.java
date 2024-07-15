
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-27 9:15
 */
@SuppressWarnings("all")
public class _11_RandomListNodeCopy {

    // 方法二：将新节点链在原节点后，新节点的random是原节点random.next即新节点的random
    public static ListNode m2(ListNode head) {
        ListNode p = new ListNode(-1);
        while(p!=null) {
            ListNode newNode = new ListNode(p.val);
            newNode.next=p.next;
            p.next=newNode;
            p=p.next;
        }
        p=head;
        // 拼接新节点的随机链表
        while (p!=null) {
            p.next.random=p.random.next;
            p=p.next.next;
        }
        // 拼接next, 拆分新旧节点
        p=head;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (p!=null) {
            curr.next=p.next;
            curr=curr.next;
            // 断开原节点的next为
            p.next=curr.next;
            p=p.next;
        }

        return dummy.next;
    }



    // 方法一：使用哈希表存储原节点和新节点
    public static ListNode m1(ListNode head) {
        if (head==null) {
            return head;
        }

        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode p = head;
        while (p!=null) {
            ListNode tmpNode = new ListNode(p.val);
            map.put(p, tmpNode);
            p=p.next;
        }
        p=head;
        while(p!=null) {
            ListNode node = map.get(p);
            if(p.next!=null) {
                node.next=p.next;
            }
            if(p.random!=null) {
                node.random=p.random;
            }
            p=p.next;
        }
        
        return map.get(head);
        
    }
    
    
    
    static class ListNode {
        private int val;
        ListNode next;
        ListNode random;
        
        public ListNode(int val) {
            this.val = val;
            this.next=null;
            this.random=null;
        }
    }
}
