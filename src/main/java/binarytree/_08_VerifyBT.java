package binarytree;

import javax.xml.soap.Node;
import java.time.Period;

/**
 * <p>
 *  验证二叉搜索树
 * @author zhl
 * @since 2024-07-20 20:02
 */
@SuppressWarnings("all")
public class _08_VerifyBT extends TreeNode{
    // 用于中序遍历时暂存上一个节点
    private long pre = Long.MIN_VALUE;

    private boolean m1(TreeNode root) {
        return m1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean m1(TreeNode root, long lower, long upper) {
        if(root==null) {
            return true;
        }
        if(root.val <= lower || root.val >= upper) {
            return false;
        }
        return m1(root.left, lower, root.val) && m1(root.right, root.val, upper);
    }

    /**
     * 中序遍历
     */
    private boolean m2(TreeNode root) {
        if (root==null) {
            return true;
        }

        if(!m2(root.left)) {
            return false;
        }

        if (pre > root.val) {
            return false;
        }
        pre=root.val;

        return m2(root.right);
    }

}
