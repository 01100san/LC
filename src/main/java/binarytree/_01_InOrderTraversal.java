package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *  中序遍历
 * @author zhl
 * @since 2024-07-15 20:00
 */
@SuppressWarnings("all")
public class _01_InOrderTraversal extends TreeNode{

    private List<Integer> ans = new ArrayList<>();

    /**
     * 迭代
     *  使用 栈模拟 中序遍历的递归
     *  {@link Attention#inOrderByIteration(TreeNode root)}
     */
    public List<Integer> m2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(root !=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root.left);
                root=root.left;
            }
            // 取出当前节点
            root = stack.pop();
            result.add(root.val);
            root=root.right;
        }
        return result;
    }

    /**
     * 中序遍历 递归实现 dfs
     */
    public void m1(TreeNode root) {
        if(root == null) {
            return;
        }
        m1(root.left);
        ans.add(root.val);
        m1(root.right);
    }
}
