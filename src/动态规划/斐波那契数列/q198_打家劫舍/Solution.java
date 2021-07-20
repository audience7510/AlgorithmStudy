package 动态规划.斐波那契数列.q198_打家劫舍;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：一共k间房子，偷第k间，那么不能偷k-1间，偷窃总金额为 前k-2间房最高总金额与第k间房金额之和
 *      不偷第k间，那么总金额为 前k-1间房最高总金额
 *      dp[i]=max(dp[i−2]+nums[i],dp[i−1])
 */
public class Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre+nums[i],total);
            pre = total;
            total = cur;
        }
        return total;
    }
}
