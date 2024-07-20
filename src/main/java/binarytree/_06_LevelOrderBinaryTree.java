package binarytree;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.*;

/**
 * <p>
 *  二叉树的层序遍历
 * @author zhl
 * @since 2024-07-20 19:06
 */
@SuppressWarnings("all")
public class _06_LevelOrderBinaryTree extends TreeNode{

    private List<List<Integer>> m1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 先加入根节点的值
        ans.add(Arrays.asList(root.val));
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size>0) {
                TreeNode node = queue.poll();
                if(node.left!=null) {
                    list.add(node.left.val);
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    list.add(node.right.val);
                    queue.offer(node.right);
                }
                size--;
            }
            if (!list.isEmpty()) {
                ans.add(list);
            }
        }
        return ans;
    }
}
