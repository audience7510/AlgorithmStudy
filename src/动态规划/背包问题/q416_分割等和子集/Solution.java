package 动态规划.背包问题.q416_分割等和子集;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/27
 * @Version 1.0
 * @Description
 * 思路：可以看成一个背包大小为 sum/2 的 0-1 背包问题
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        //先求出数组的和
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max,num);
        }
        if (sum%2 != 0){
            return false;
        }
        //nums长度，这个相当于背包问题中的物品数量
        int n = nums.length;
        //数组和的一半，这个相当于是背包总体积
        int w = sum/2;
        if (max > w){
            return false;
        }
        boolean[][] dp = new boolean[n][w+1];
        for (int i = 0; i < n; i++) {
            //第i个数，0的意思是不选取任何正整数，则被选取的正整数为0
            dp[i][0] = true;
        }
        //当i为0时，只能选取nums[0]
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 0; j <= w; j++) {
                //可以被选取
                if (j > num){
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-num];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][w];
    }
}
