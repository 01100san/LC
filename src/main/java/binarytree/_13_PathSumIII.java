package binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  路径总和Ⅲ
 * @author zhl
 * @since 2024-07-22 20:26
 */
@SuppressWarnings("all")
public class _13_PathSumIII extends TreeNode{
    private int m1(TreeNode root, int targetSum) {
        /**
         * key: 前缀和
         * value: 前缀和的个数
         */
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        return prefixRecurr(root, prefixMap, targetSum, 0L);
    }

    /**
     * 递归计算前缀和的个数
     */
    private int prefixRecurr(TreeNode node, Map<Long, Integer> prefixMap, int targetSum, long currSum) {
        if (node==null) {
            return 0;
        }
        // 满足前缀和的个数
        int result = 0;
        currSum += node.val;
        // 最后的路径=当前节点到根节点的路径和-目标节点的路径和
        // ==> 当前节点-targetSum = 另一个前缀和
        result += prefixMap.getOrDefault(currSum-targetSum,0);

        // 将当前前缀和加入 map
        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

        // 递归判断下一层
        result += prefixRecurr(node.left, prefixMap, targetSum, currSum);
        result += prefixRecurr(node.right, prefixMap, targetSum, currSum);

        // 路径方向必须向下，将前缀和的个数-1
        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) -1);
        return result;
    }
}
