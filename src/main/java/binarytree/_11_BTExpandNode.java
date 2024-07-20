package binarytree;

import java.util.*;

/**
 * <p>
 *  将二叉树展开为链表
 * @author zhl
 * @since 2024-07-20 20:59
 */
@SuppressWarnings("all")
public class _11_BTExpandNode extends TreeNode {
    // 方法二
    private TreeNode pre = null;
    /**
     * 方法一：先序遍历将 BT 的所有节点值存储到 list 中，然后取出 list 中的元素，创建对应的 TreeNode 对象
     */
    private void m1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        m1(root, ans);
        for(int i=1;i<ans.size();i++) {
            root.right = new TreeNode(ans.get(i));
            root.left=null;
            root=root.right;
        }
    }
    private void m1(TreeNode root, List<Integer> ans) {
        if(root==null) {
            return;
        }
        ans.add(root.val);
        m1(root.left, ans);
        m1(root.right, ans);
    }

    /**
     * 方法二：后序遍历，自底向上，更新当前节点的右节点指向上一个节点
     *      递归
     */
    private void m2(TreeNode root) {
        if(root==null) {
            return;
        }
        // 先递归右子树，最后是右子树的最右节点是链表尾节点
        m2(root.right);
        m2(root.left);

        // 更新当前节点的右节点指向上一个节点
        root.right=pre;
        root.left=null;
        pre=root;
    }

    /**
     * 方法二：后序遍历
     *      迭代
     */
    private void m22(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode visited = new TreeNode();
        while(root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root=root.right;
            }
            root = stack.peek();
            // 后序遍历到左子节点为 null 时，如果右子节点为 null，或 右子节点已被处理过，处理当前节点
            if(root.left == null || root.left == visited) {
                stack.pop();
                root.right=visited;
                root.left=null;

                visited=root;
                root=null;
            }else {
                root=root.left;
            }
        }
    }
}
