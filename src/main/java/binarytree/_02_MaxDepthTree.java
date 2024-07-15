package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *  二叉树的最大深度<p>
 * @author zhl
 * @since 2024-07-15 20:25
 */
@SuppressWarnings("all")
public class _02_MaxDepthTree extends TreeNode{

    /**
     * 迭代计算一个树的最大高度 (bfs)
     *  基于层序遍历 <br>
     *  {@link Attention#maxDepthTreeByIteration(TreeNode root)}
     */
    public int maxDepthTreeByIteration(TreeNode root) {
        if(root==null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height=0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
                size--;
            }
            height++;
        }
        return height;
    }

    /**
     * 基于递归计算树的高度
     *  树的高度=节点数+1 <br>
     *  {@link Attention#maxDepthTreeByRecursion(TreeNode root)}
     */
    public int maxDepthTreeByRecursion(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int left = maxDepthTreeByRecursion(root.left);
        int right= maxDepthTreeByRecursion(root.right);

        return Math.max(left, right) + 1;
    }
}
