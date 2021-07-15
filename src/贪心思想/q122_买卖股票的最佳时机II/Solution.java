package 贪心思想.q122_买卖股票的最佳时机II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：[7, 1, 5, 6] 第二天买入，第四天卖出，收益最大（6-1），(6-1)又可以写成
 *      （（5-1）+ （6-5） = 6 - 1），当前卖出，当天再买入，
 *      所以只要判断当前比前一天大，就可以卖出，卖出的钱相加就是最大收益
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length ==0){
            return 0;
        }
        int total = 0;
        //从1开始，不然[i-1]会索引越界
        for (int i = 1; i < prices.length; i++) {
            //当前比前一天大
            if (prices[i] > prices[i-1]){
                //当天的减去昨天的，并且卖出的钱相加
                total += (prices[i] - prices[i-1]);
            }
        }
        return total;
    }
}
