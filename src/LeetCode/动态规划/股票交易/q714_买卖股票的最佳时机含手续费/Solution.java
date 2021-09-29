package LeetCode.动态规划.股票交易.q714_买卖股票的最佳时机含手续费;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/28
 * @Version 1.0
 * @Description
 * 思路：情况1：dp[i][0]表示第i天交易完成后，手里没有股票的最大利润，
 *      情况2：dp[i][1]表示第i天交易完成后，手里有一支股票的最大利润，
 *
 *      对于情况1，手里没有股票，那么可能前一天没有，则利润为dp[i-1][0]；
 *      而前一天可能有股票，则需要情况2前一天的利润，加上今天股票卖出的价格，减去手续费
 *      则利润为dp[i-1][1]+price[i]-fee
 *      状态转移方程为：dp[i][0] = max(dp[i-1][0],dp[i-1][1]+price[i]-fee)
 *
 *      对于情况2，手里有股票，那么前一天可能持有了，就是情况2的前一天，则利润为dp[i-1][1]；
 *      而前一天可能没持有股票，则需要情况1的前一天利润，减去股票买入的价格
 *      则利润为dp[i-1][0]-price[i]
 *      状态转移方程为：dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price[i])
 *
 *      优化：空间O(n)到O(1)，方法maxProfit2。dp[i][0]和dp[i][1]只会从dp[i-1][0]和dp[i-1][1]
 *      转移而来，因此不必使用二维数组存储所有的收益，定义两个变量即可
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        //n为天数，2为两种情况
        int [][] dp = new int[n][2];
        //第一天没买股票，收益是0
        dp[0][0] = 0;
        //第一天买了股票，收益是负股票价格
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            //情况1
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            //情况2
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        //最后一天，不再持有股票
        return dp[n-1][0];
    }

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        //第一天没买股票，收益是0
        int dp0 = 0;
        //第一天买了股票，收益是负股票价格
        int dp1 = -prices[0];
        for (int i = 0; i < n; i++) {
            dp0 = Math.max(dp0,dp1+prices[i]-fee);
            dp1 = Math.max(dp1,dp0-prices[i]);
        }
        return dp0;
    }
}
