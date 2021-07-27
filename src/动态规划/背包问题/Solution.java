package 动态规划.背包问题;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/27
 * @Version 1.0
 * @Description
 * 背包问题思路：有一个容量为 N 的背包，要用这个背包装下物品的价值最大，这些物品有两个属性：体积 w 和价值 v。
 *             定义一个二维数组 dp 存储最大价值，其中dp[i][j]表示当前i件物品，体积不超过j情况下，最大的价值
 *             假设第i件物品，体积w，价值v，是否添加到背包中有两种情况
 *             1、没有添加进去，那么第i件价值就是前i-1件的价值，dp[i][j] = dp[i-1][j]
 *             2、添加了，那么第i件价值就是前i-1的价值，加上当前i的价值，dp[i][j] = dp[i-1][j-w]+v
 *             由于可添加或者不添加，那么状态转移方程为：
 *             dp[i][j] = max(dp[i-1][j],dp[i-1][j-w]+v)
 *
 *             空间优化：前i件物品的状态仅与前i-1件物品的状态有关，dp可以定义为一维数组
 *             dp[j]既可以表示dp[i][j]也可以表示dp[i-1][j]
 *             dp[j] = max(dp[j],dp[j-w]+v)
 *             因为 dp[j-w] 表示 dp[i-1][j-w]，因此不能先求 dp[i][j-w]，
 *             防止将 dp[i-1][j-w] 覆盖。也就是说要先计算 dp[i][j] 再计算 dp[i][j-w]，
 *             在程序实现时需要按倒序来循环求解
 */
public class Solution {
    /**
     * @Date 2021/7/27
     * @Param W 为背包总体积
     *        N 为物品数量
     *        weights 数组存储 N 个物品的重量
     *        values 数组存储 N 个物品的价值
     * @return
     * @Description
     * dp[i][j] = max(dp[i-1][j],dp[i-1][j-w]+v)
     */
    public int knapsack1(int W, int N, int[] weights, int[] values) {
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i-1];
            int v = values[i-1];
            for (int j = 1; j <= W; j++) {
                if (j >= w){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    /**
     * @Date 2021/7/27
     * @Param W 为背包总体积
     *        N 为物品数量
     *        weights 数组存储 N 个物品的重量
     *        values 数组存储 N 个物品的价值
     * @return
     * @Description
     * dp[j] = max(dp[j],dp[j-w]+v)
     */
    public int knapsack2(int W, int N, int[] weights, int[] values) {
        int[] dp = new int[W+1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i-1];
            int v = values[i-1];
            //倒序遍历
            for (int j = W; j >= 1; j--) {
                if (j >= w){
                    dp[j] = Math.max(dp[j],dp[j-w]+v);
                }
            }
        }
        return dp[W];
    }
}
