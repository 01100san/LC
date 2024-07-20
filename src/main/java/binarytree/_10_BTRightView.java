package binarytree;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import jdk.nashorn.internal.ir.ReturnNode;

import javax.xml.soap.Node;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 *  二叉树的右视图
 * @author zhl
 * @since 2024-07-20 20:43
 */
@SuppressWarnings("all")
public class _10_BTRightView extends TreeNode{
    /**
     * 方法一：dfs
     * 优先遍历右子树，当首次遍历到某个深度时，就加入当前节点的值
     */
    private List<Integer> m1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        m1(root, 0, ans);
        return ans;
    }
    private void m1(TreeNode root, int depth, List<Integer> ans) {
        if (root==null) {
            return;
        }
        if (depth==ans.size()) {
            ans.add(root.val);
        }
        m1(root.right, depth + 1, ans);
        m1(root.left, depth+1, ans);
    }

    /**
     * 方法二：bfs
     * 层序遍历添加队列中的最后一个元素
     */
    private List<Integer> m2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = new TreeNode();
            while (size>0) {
                node = queue.poll();
                if (node.left!=null) {
                    queue.offer(node.left);
                }
                if (node.right!=null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans.add(node.val);
        }
        return ans;
    }
}
