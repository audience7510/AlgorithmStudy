package LeetCode.动态规划.分割整数.q343_整数拆分;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/21
 * @Version 1.0
 * @Description
 * 思路：正整数i，当 i>=2时，可以拆分成至少两个正整数的和，j是拆分的一个正整数
 *      那么剩下的就是i-j，i-j也可以拆或者不拆。每个正整数对应最大乘积，取决于
 *      比它小的整数对应的最大乘积
 *      i-j不拆分，那么最大乘积为 j*(i-j)
 *      i-j拆分，那么最大乘积为 j*dp[i-j]
 *      n=0或者n=1时，不能拆分，所以dp[0]、dp[1]值为0，数组默认值0
 *
 */
public class Solution {
    public int integerBreak(int n) {
        //i能取到n，所以dp长度n+1
        int[] dp = new int[n+1];
        //从i=2开始遍历
        for (int i = 2; i <= n; i++) {
            int max = 0;
            //拆分出来的整数从1开始
            for (int j = 1; j < i; j++) {
                //内层max，取的是i-j是否拆分的最大值
                //外层max，取的是拆分不同的第一个正整数 的最大值
                max = Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            //存储
            dp[i] = max;
        }
        return dp[n];
    }
}
