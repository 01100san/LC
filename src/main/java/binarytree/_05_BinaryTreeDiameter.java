package binarytree;

import sun.reflect.generics.tree.Tree;

/**
 * <p>
 *  计算二叉树直径
 * @author zhl
 * @since 2024-07-15 22:17
 */
@SuppressWarnings("all")
public class _05_BinaryTreeDiameter {

    private int ans = 0;

    /**
     *  二叉树的直径 = max(根节点的左子树+右子树的高度, 二叉树的直径)
     * 注意二叉树的直径不一定经过二叉树的根节点
     */
    public int m1(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left+right, ans);
        return Math.max(left, right) + 1;
    }
}
