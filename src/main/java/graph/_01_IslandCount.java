package graph;

/**
 * <p>
 *  岛屿数量
 * @author zhl
 * @since 2024-07-23 20:16
 */
@SuppressWarnings("all")
public class _01_IslandCount {
    private int m1(char[][] grid) {
        int ans = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return;
        }
        if (grid[r][c]!='1') {
            return;
        }
        // 将访问过的网格置为'2'
        grid[r][c]='2';
        // 访问上下左右四个边界
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

    /**
     * 计算岛屿是否正常，边界判断
     * @param grid  二维网格
     * @param r 行
     * @param c 列
     * @return
     */
    private boolean inArea(char[][] grid, int r, int c) {
        return r>=0 && r < grid.length
            && c >= 0 && c<grid[0].length;
    }
}
