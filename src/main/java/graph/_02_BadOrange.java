package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 腐烂的橘子
 *
 * @author zhl
 * @since 2024-07-23 20:35
 */
@SuppressWarnings("all")
public class _02_BadOrange {
    // 依次上下左右, 以 [0,0]
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private int m1(int[][] grid) {
        // 行
        int r = grid.length;
        // 列
        int c = grid[0].length;
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 将腐烂橘子加入队列
                // 计算新鲜橘子的个数
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        // 腐烂的最小分钟数，最小轮数
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                // 从队列中取出腐烂的橘子
                int[] orange = queue.poll();
                // 从4个方向感染橘子
                for (int i = 0; i < 4; i++) {
                    int x = dx[i] + orange[0];
                    int y = dy[i] + orange[1];
                    if(inArea(grid, x, y) && grid[x][y]==1) {
                        grid[x][y]=2;
                        queue.offer(new int[]{x, y});
                        count--;
                    }
                }
                size--;
            }
            round++;
        }
        // 存在不能污染的橘子
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
    private boolean inArea(int[][] grid, int r,int c) {
        return r>=0 && r<grid.length
            && c>=0 && c<grid[0].length;
    }
}
