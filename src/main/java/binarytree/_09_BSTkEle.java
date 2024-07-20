package binarytree;


/**
 * <p>
 *  二叉搜索树中第 k 小的元素
 * @author zhl
 * @since 2024-07-20 20:28
 */
@SuppressWarnings("all")
public class _09_BSTkEle extends TreeNode{
    private TreeNode ans;
    private int index = 0;

    private int m1(TreeNode root, int k) {
        inOrder(root, k);
        return ans==null ? -1 : ans.val;
    }

    private void inOrder(TreeNode root, int k) {
        if(root==null) {
            return;
        }
        inOrder(root.left, k);
        // 中序遍历找到了第 k 小的元素
        if(++index == k) {
            ans=root;
            return;
        }
        inOrder(root.right, k);
    }
}
