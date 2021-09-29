package LeetCode.动态规划.矩阵路径.q62_不同路径;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/21
 * @Version 1.0
 * @Description
 * 思路：走到[i][j]位置，需要从左边或者上边 一步走过来
 *      那么就是从[i-1][j]或[i][j-1]走过来
 *      状态转移方程：f(i,j)=f(i-1,j)+f(i,j-1)
 *      但是如果只有一行，或者一列，那么只有一种方式
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        //m是行数，n是列数
        int[][] arr = new int[m][n];
        //第一列，一种方式
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        //第一行，一种方式
        for (int j = 0; j < n; j++) {
            arr[0][j] = 1;
        }
        //第i行j列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //到达该位置等于左边或者上边方式相加
                arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        //到达右下角的方式和
        return arr[m-1][n-1];
    }
}
