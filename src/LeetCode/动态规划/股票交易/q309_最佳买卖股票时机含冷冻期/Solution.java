package LeetCode.动态规划.股票交易.q309_最佳买卖股票时机含冷冻期;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/29
 * @Version 1.0
 * @Description
 * 思路参考LeetCode，最重要的是明白状态转移方程
 * f[i]表示第 i 天结束之后的「累计最大收益」，根据冷冻期，分三种情况
 *      1、目前只有一只股票，最大收益为f[i][0]
 *      2、不持有股票，处于冷冻期，最大收益为f[i][1]
 *      3、不持有，不处于冷冻期，最大收益为f[i][2]
 * 对于情况1，目前持有的可能是i-1已经持有的，则对应收益为f[i-1][0]；
 * 或者是i天买入的，那么i-1天则不能持有股票，且不能处于冷冻期，则收益为f[i-1][2]，减去买入股票的的钱prices[i]。
 * 对于情况1的状态转移方程为：f[i][0] = max(f[i-1][0],f[i-1][2]-prices[i])
 * 可以理解为，情况1 和 情况3-prices[i]取最大值
 *
 * 对于情况2，处于冷冻期，那么说明当天卖出了股票，那么i-1天持有股票，对应收益为f[i-1][0]，
 * 加上卖出股票的收益prices[i]，状态转移方程为：f[i][1] = f[i-1][0]+prices[i]
 * 可以理解为：情况1 和 prices[i]求和
 *
 * 对于情况3，不持有、不处于冷冻，说明当天没有任何操作，即i-1天不持有股票。那么i-1天若为冷冻期，
 * 则最大收益为f[i-1][1]；i-1不为冷冻期，则最大收益为f[i-1][2]
 * 状态转移方程为f[i][2] = max(f[i-1][1],[i-1][2])
 * 可以理解为：情况2 和 情况3取最大值
 *
 * 将以上三种情况合并，得出状态转移方程为：max(f[i-1][0],f[i-1][1],[i-1][2])
 * 注意到最后一天(i-1)之后，手上仍然持有股票，没有意义，因此最终max(f[i-1][1],[i-1][2])
 *
 * 优化：空间优化O(n)到O(1)，方法maxProfit2，优化思路f[i][x]只与f[i-1][x]有关，
 *      与f[i-2][x]以及之前的都无关，因此不必用二维数组去存储这些值，三个变量即可
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        //n为天数，从0开始，3为三种情况
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        //第一天必须买入股票，因此收益是负股票价格
        f[0][0] = -prices[0];
        //第二天开始
        for (int i = 1; i < n; i++) {
            //按照思路分析的状态转移方程
            //情况1
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            //情况2
            f[i][1] = f[i-1][0]+prices[i];
            //情况3
            f[i][2] = Math.max(f[i-1][1],f[i-1][2]);
        }
        //综合状态转移方程取最大
        return Math.max(f[n-1][1],f[n-1][2]);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int n = prices.length;
        // f0: 手上持有股票的最大收益
        // f1: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f2: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 0; i < n; i++) {
            //情况1 和 情况3-prices[i]取最大值
            int cur0 = Math.max(f0,f2-prices[i]);
            //情况1 和 prices[i]求和
            int cur1 = f0+prices[i];
            //情况2 和 情况3取最大值
            int cur2 = Math.max(f1,f2);
            f0 = cur0;
            f1 = cur1;
            f2 = cur2;
        }
        return Math.max(f1,f2);
    }
}
