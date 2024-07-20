package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *  判断二叉树是否对称
 * @author zhl
 * @since 2024-07-15 21:49
 */
@SuppressWarnings("all")
public class _04_DuiChenTree {
    /**
     * 根据队列的先进先出特性，依次添加取出队列
     */
    private boolean m2(TreeNode root) {
        if(root==null  || (root.left==null && root.right==null)) {
            return true;
        }
        // 将左右节点添加到队列中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()) {
            // 从队列中取出节点
            TreeNode leftNode=queue.poll();
            TreeNode rightNode=queue.poll();
            // 如果左右节点都为null, 跳过此次循环
            if(leftNode==null && rightNode==null) {
                continue;
            }
            if(leftNode==null || rightNode==null) {
                return false;
            }
            if(leftNode.val!=rightNode.val){
                return false;
            }
            // 将左节点的左孩子 和 右节点的右孩子加入队列
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            // 将左节点的右孩子 和 右节点的左孩子加入队列
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }

        return true;
    }

    /**
     * 递归<p>
     *  递归终止的条件是 如果左右节点都为null, 返回 true
     *  左或右节点为null, 返回 false
     *  左右节点值不相等, 返回 false
     */
    public boolean m1(TreeNode root) {
        if (root==null) {
            return true;
        }
        // 递归的遍历两侧节点
        return dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        if(left==null && right==null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val!=right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
    
}
