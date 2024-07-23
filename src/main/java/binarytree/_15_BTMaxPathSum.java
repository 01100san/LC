package binarytree;

/**
 * <p>
 *  二叉树中的最大路径和
 * @author zhl
 * @since 2024-07-22 21:15
 */
@SuppressWarnings("all")
public class _15_BTMaxPathSum extends TreeNode{
    private int maxSum = Integer.MIN_VALUE;

    private int m1(TreeNode root) {
        calculate(root);
        return maxSum;
    }

    /**
     * 后序遍历
     */
    private int calculate(TreeNode node) {
        if (node==null) {
            return 0;
        }
        int left = calculate(node.left);
        int right = calculate(node.right);
        // 返回当前子树的最大路径长度
        int innerSum = node.val + left + right;
        maxSum = Math.max(innerSum, maxSum);

        // 计算当前节点对父节点的路径和
        int outSum = Math.max(node.val + left, node.val + right);
        return outSum > 0 ? outSum : 0;
    }
}
