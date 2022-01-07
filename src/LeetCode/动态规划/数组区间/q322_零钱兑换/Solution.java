package LeetCode.动态规划.数组区间.q322_零钱兑换;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Author audience7510
 * @Date 2022/1/7
 * @Description
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        //把max的值填充到dp数组中
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
