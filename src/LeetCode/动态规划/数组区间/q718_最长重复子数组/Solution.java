package LeetCode.动态规划.数组区间.q718_最长重复子数组;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/12
 * @Version 1.0
 * @Description
 * 思路：动态规划，数组从后向前遍历，如果nums1[i] == nums2[j]
 *      状态转移方程dp[i][j] = dp[i+1][j+1]+1，相等的元素再加1
 *      不相等dp[i][j] = 0
 */
public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [][] dp = new int[n+1][m+1];
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j]? dp[i+1][j+1]+1:0;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
