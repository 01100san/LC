package binarytree;

/**
 * <p>
 *  定义二叉树的节点
 * @author zhl
 * @since 2024-07-15 20:01
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
