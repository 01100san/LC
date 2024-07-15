package listnode;

import java.util.*;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-27 19:11
 */
@SuppressWarnings("all")
public class _14_LRUCache {

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    // key=> node.key    value=>  node
    Map<Integer, Node> cache = new HashMap<>();

    public _14_LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node!=null) {
            // node 存在移至链表头, 先移除之前的位置, 再添加到链表头
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void addToHead(Node node) {
        head.next.prev=node;
        node.next=head.next;
        head.next=node;
        node.prev=head;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node==null) {
            Node newNode=new Node(key,value);
            cache.put(key, newNode);
            // 说明之前不存在, 是直接添加
            addToHead(node);
            size++;
            if(size > capacity) {
                Node tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            // 说明存在节点，修改node.val
            node.value=value;
            moveToHead(node);
        }
    }

    private Node removeTail() {
        Node node=tail.prev;
        removeNode(node);
        return node;
    }


    class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
