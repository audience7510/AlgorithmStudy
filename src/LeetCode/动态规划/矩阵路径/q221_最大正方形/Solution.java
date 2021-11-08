package LeetCode.动态规划.矩阵路径.q221_最大正方形;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/11/4
 * @Version 1.0
 * @Description
 * 思路：动态规划，状态转移方程：dp[i][j] = min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
 *      dp[i][j]表示以(i,j)为右下角，且只包含1的正方形边长最大值
 *      如果是(0,0)，那么dp[i][j] = 0，不能由1组成正方形
 *      如果该位置是1，那么由左边、上边、左上角三个相邻元素的最小值决定，并加上当前的1
 *      1、工资问题
 *      2、反馈情况，努力干之后的感受，
 *      3、表明态度
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return max;
        }
        int row = matrix.length;
        int line = matrix[0].length;
        int[][] dp = new int[row][line];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < line; j++) {

            }
        }

        return max;
    }
}
