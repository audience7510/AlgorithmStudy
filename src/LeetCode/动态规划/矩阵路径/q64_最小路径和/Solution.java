package LeetCode.动态规划.矩阵路径.q64_最小路径和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/21
 * @Version 1.0
 * @Description
 * 思路：
 * 状态转移方程
 *      第一行：dp[0][j]=dp[0][j−1]+grid[0][j]，路径和只能从左边的元素相加得来
 *      第一列：dp[i][0]=dp[i−1][0]+grid[i][0]，路径和只能从上边的元素相加得来
 *      中间的列和行dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]，
 *      而中间的[i][j]这个位置，取左边和上边路径相加和的最小值
 *      另外三者都加上本节点的值
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length ==0||grid[0].length == 0){
            return 0;
        }
        //行数
        int rows = grid.length;
        //列数
        int columns = grid[0].length;
        //创建数组，用于存储走到该节点的路径和
        int[][] dp = new int[rows][columns];
        //左上角第一个
        dp[0][0] = grid[0][0];
        //第1列的路径和，dp[i][0]=dp[i−1][0]+grid[i][0]
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        //第1行的路径和，dp[0][j]=dp[0][j−1]+grid[0][j]
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        //中间的路径和dp[i][j]=min(dp[i-1][j],dp[i][j-1])+grid[i][j]
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                //[i][j]位置的和，等于左边或者上边路径和的最小值 加上[i][j]位置的值
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        //最后相加完之后 返回最小值
        return dp[rows-1][columns-1];
    }
}
