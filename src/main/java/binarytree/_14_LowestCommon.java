package binarytree;

/**
 * <p>
 *  二叉树的最近祖先
 * @author zhl
 * @since 2024-07-22 20:53
 */
@SuppressWarnings("all")
public class _14_LowestCommon extends TreeNode{
    /**
     * 先序遍历
     */
    private TreeNode m1(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==root || q==root) {
            return root;
        }
        TreeNode left = m1(root.left, p, q);
        TreeNode right = m1(root.right, p, q);
        // p,q 在异侧
        if(left!=null && right!=null) {
            return root;
        }
        // p,q 都在左子树
        if (left!=null && right==null) {
            return left;
        }
        // p,q 都在右子树
        if (left==null && right!=null) {
            return right;
        }
        return null;
    }

}
