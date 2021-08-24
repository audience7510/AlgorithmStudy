package 动态规划.股票交易.q123_买卖股票的最佳时机III;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/24
 * @Version 1.0
 * @Description
 * 思路：最多两笔交易，因此一天结束之后有五种状态
 *      1、未进行过任何操作；2、只进行过一次买操作；3、进行了一次买操作和一次卖操作，即完成了一笔交易；
 *      4、在完成了一笔交易的前提下，进行了第二次买操作；5、完成了全部两笔交易
 *
 *      情况1利润为0，不进行记录，情况2、3、4、5利润分别记为b1,s1,b2,s2
 *      情况2：b1 = max(b1,-prices[i])
 *      情况3：s1 = max(s1,b1+prices[i])
 *      情况4：b2 = max(b2,s1-prices[i])
 *      情况5：s2 = max(s2,b2+prices[i])
 *
 *      最终返回的s2原因：可以进行不超过两笔交易，因此最终的答案在 0，s1，s2中，
 *      且为三者中的最大值，由于s1，s2初始值为0，那么最终s1、s2会大于0。
 *      假设只完成了一笔交易就得到了最大值s1，由于允许同一天买入并卖出，s1会转移到s2
 *      s2即为最大值
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int b1 = -prices[0];
        int s1 = 0;
        int b2 = -prices[0];
        int s2 = 0;
        for (int i = 1; i < n; i++) {
            b1 = Math.max(b1,-prices[i]);
            s1 = Math.max(s1,b1+prices[i]);
            b2 = Math.max(b2,s1-prices[i]);
            s2 = Math.max(s2,b2+prices[i]);
        }

        return s2;
    }
}
