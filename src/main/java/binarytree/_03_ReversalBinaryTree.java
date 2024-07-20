package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *  翻转二叉树
 * @author zhl
 * @since 2024-07-15 20:58
 */
@SuppressWarnings("all")
public class _03_ReversalBinaryTree extends TreeNode{

    /**
     *  先交换两侧节点，前序遍历 DFS
     * @param root
     * @return
     */
    private TreeNode m1(TreeNode root) {
        if(root==null) return root;

        // 随着树高度的下降而交换, root!=null 直接交换左右子节点
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;

        // 向下递归遍历交换左右子节点
        m1(root.left);
        m1(root.right);

        return root;
    }

    /**
     * 层序遍历交换两侧节点
     */
    public TreeNode m2(TreeNode root) {
        if (root==null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // 交换
            TreeNode tmp = node.left;
            node.left=node.right;
            node.right=tmp;

            if(node.left!=null) {
                queue.offer(node.left);
            }
            if (node.right!=null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}