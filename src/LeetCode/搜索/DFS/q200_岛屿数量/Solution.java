package LeetCode.搜索.DFS.q200_岛屿数量;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/14
 * @Version 1.0
 * @Description
 * 思路：深度优先搜索，二维数组遍历，找到岛屿之后，递归遍历相连(上下左右)的岛屿
 *      嵌套遍历，时间复杂度O(MN)，
 *      空间复杂度O(MN)，最坏全是陆地，递归二维数组的所有值
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int row = grid.length;
        int line = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int line = grid[0].length;
        //数组越界，或者是0(水)的话直接返回
        if (i<0||j<0||i>=row||j>=line||grid[i][j] == '0'){
            return;
        }
        //找到相邻满足是1(岛屿)的条件，将其标记为0，下次不再遍历
        grid[i][j] = '0';
        //上
        dfs(grid,i-1,j);
        //下
        dfs(grid,i+1,j);
        //左
        dfs(grid,i,j-1);
        //右
        dfs(grid,i,j+1);
    }
}
