package LeetCode.贪心思想.q121_买卖股票的最佳时机;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格
 *      定义最小min和最大max两个变量，遍历比较当前元素是否最小值，是则赋值给最小值
 *      如果不小于最小值，那么比较max和当前元素减去最小值的大小，并赋值给max
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length ==0){
            return 0;
        }
        //最小价格
        int min = prices[0];
        //最大价格
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            //遍历出来比最小价格小
            if (min > prices[i]){
                //赋值给最小价格
                min = prices[i];
            }else {
                //遍历出来比最小价格大，当前价格减去最小价格，并与max比较
                max = Math.max(max,prices[i]-min);
            }
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        //最小价格
        int min = prices[0];
        //最大价格
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            //价格最小赋值
            min = Math.min(min,prices[i]);
            //相减最大赋值
            max = Math.max(max,prices[i]-min);
        }
        return max;
    }
}
