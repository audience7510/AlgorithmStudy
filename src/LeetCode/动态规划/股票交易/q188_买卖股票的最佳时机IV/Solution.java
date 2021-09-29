package LeetCode.动态规划.股票交易.q188_买卖股票的最佳时机IV;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/24
 * @Version 1.0
 * @Description 难度-hard
 * 思路：对于数组prices来说
 *      情况1：用buy[i][j]表示第i天进行j笔交易的，并且持有一只股票的收益，
 *      情况2：用sell[i][j]表示第i天进行j笔交易的，并且不持有股票的收益
 *
 *      对于情况1，如果是当天买入的，那么i-1天没有股票，对应状态为sell[i-1][j]，
 *      并且需要扣除当天买入的价格prices[i]；如果不是当天买入，那么i-1天持有股票，
 *      对应状态为buy[i-1][j]
 *      状态转移方程为：buy[i][j] = max(buy[i-1][j],sell[i-1][j]-prices[i])
 *
 *      对于情况2，如果是当天卖出的，那么i-1天持有股票，对应状态为buy[i-1][j-1]，
 *      再加上当天卖股票的收益。
 *      此处说明：i-1天是前一天，j-1是上一笔交易，因为是当天卖出的，所以加上当天的那一笔交易，
 *      才是j笔交易； 如果不是当天卖出的，那么第i-1天不持有股票，对应状态为sell[i-1][j]，
 *      此处说明：i-1是前一天，因为当天没有交易，是i-1天卖出的股票，那么i-1天的交易就是第j笔交易'
 *      状态转移方程：sell[i][j] = max(sell[i-1][j],buy[i-1][j-1]+prices[i])
 *
 *      状态转移方程优化：buy[i][j]和sell[i][j]都是从buy[i-1][...]和sell[i-1][...]
 *      转移而来，因此可以用一维数组来进行状态转移
 *      buy[j] = max(buy[j],sell[j]-prices[i])
 *      sell[j] = max(sell[j],buy[j-1]+prices[i])
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int n = prices.length;
        //n天只能进行n/2笔交易
        k = Math.min(k,n/2);
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; i++) {
            buy[i] = sell[i] = Integer.MIN_VALUE/2;
        }
        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0],sell[0]-prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j],sell[j]-prices[i]);
                sell[j] = Math.max(sell[j],buy[j-1]+prices[i]);
            }
        }
        return Arrays.stream(sell).max().getAsInt();
    }
}
