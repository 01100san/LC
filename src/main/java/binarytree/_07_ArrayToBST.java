package binarytree;

import java.awt.font.NumericShaper;

/**
 * <p>
 *  有序数组转成二叉搜索树
 * @author zhl
 * @since 2024-07-20 19:30
 */
@SuppressWarnings("all")
public class _07_ArrayToBST extends TreeNode{
    private TreeNode m1(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }
    private TreeNode dfs(int[] nums, int left, int right) {
        if(left>right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node  = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid-1);
        node.right=dfs(nums, mid+1, right);
        return node;
    }
}
