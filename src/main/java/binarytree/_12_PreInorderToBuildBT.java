package binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  从前序遍历和中序遍历序列构造二叉树
 * @author zhl
 * @since 2024-07-20 21:44
 */
@SuppressWarnings("all")
public class _12_PreInorderToBuildBT extends TreeNode{
    // key: 中序遍历的节点值
    // value: 中序遍历的对应的节点位置
    private Map<Integer, Integer> indexMap = new HashMap<>();

    private TreeNode m1(int[] preOrder, int[] inOrder) {
        int length = inOrder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inOrder[i], i);
        }
        return myBuildTree(preOrder, inOrder, 0, length-1, 0, length-1);
    }

    private TreeNode myBuildTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight) {
            return null;
        }
        // 取出前序遍历的第一个节点的位置 ==> 根节点
        Integer inRoot = indexMap.get(preOrder[preLeft]);
        // 创建中序遍历的根节点
        TreeNode root = new TreeNode(inOrder[inRoot]);
        // 取出剩余的左子树
        int subLeft = inRoot-inLeft;
        // 递归构造左子树，并连接到根节点的左节点
        // 前序遍历 [左子树+1，左子树+剩余的左子树]  中序遍历 [左子树，根节点位置-1]
        root.left = myBuildTree(preOrder, inOrder, preLeft+1, preLeft+subLeft, inLeft, inRoot-1);
        // 递归构造右子树，并连接到根节点的右节点
        // 前序遍历 [左子树+剩余的左子树+1，右子树]  中序遍历 [根节点位置+1，右子树]
        root.right = myBuildTree(preOrder, inOrder, preLeft+subLeft+1, preRight, inRoot+1, inRight);
        return root;
    }
}
