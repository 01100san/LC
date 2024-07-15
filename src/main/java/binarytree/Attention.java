package binarytree;

import java.util.*;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-07-15 20:15
 */
@SuppressWarnings("all")
public class Attention extends TreeNode{
    /**
     * 基于迭代的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preOrderByIteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                ans.add(root.val);
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }

    /**
     * 基于迭代的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inOrderByIteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root=root.right;
        }
        return ans;
    }

    /**
     * 基于迭代的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postOrderByIteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root=root.left;
            }
            root = stack.peek();
            // 后序遍历到左子节点为 null 时，如果右子节点为 null，或 右子节点已被处理过，处理当前节点
            if(root.right==null || root.right==lastVisited) {
                ans.add(root.val);
                stack.pop();
                lastVisited=root;
                root=null;
            }else{
                root=root.right;
            }
        }
        return ans;
    }

    /**
     * 基于队列 实现层序遍历
     * @param root
     */
    public List<Integer> levelOrder(TreeNode root) {
        if(root==null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left!=null) {
                queue.offer(node.left);
            }
            if(node.right!=null) {
                queue.offer(node.right);
            }
        }
        return ans;
    }

    /**
     * 迭代计算一个树的最大高度 (bfs)
     *  基于层序遍历
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
     *  树的高度=节点数+1
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
