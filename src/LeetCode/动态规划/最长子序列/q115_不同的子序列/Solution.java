package LeetCode.动态规划.最长子序列.q115_不同的子序列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/10/13
 * @Version 1.0
 * @Description
 * 思路：动态规划，思路来源：https://leetcode-cn.com/problems/distinct-subsequences/solution/bu-tong-de-zi-xu-lie-by-leetcode-solutio-urw3/
 *      从后向前遍历，状态转移方程：
 *          1、s[i] = t[i]时， dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
 *          2、s[i] != t[i]时，dp[i][j] = dp[i+1][j]
 *
 */
public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m<n){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            //当t[n]时，子序列t为空字符串，空字符串是任何字符串的子序列
            dp[i][n] = 1;
        }
        for (int i = m-1; i >=0 ; i--) {
            char sChar = s.charAt(i);
            for (int j = n-1; j >=0 ; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar){
                    dp[i][j] = dp[i+1][j+1]+dp[i+1][j];
                }else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * @Date 2021/10/13
     * @Param [s, t]
     * @return
     * @Description 从前向后遍历
     * 状态转移方程：
     *  1、dp[i][j] = dp[i-1][j-1]+dp[i][j-1]
     *  2、dp[i][j] = dp[i][j-1]
     */
    public int numDistinct2(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length()+1; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < t.length()+1; i++) {
            char tChar = t.charAt(i-1);
            for (int j = 1; j < s.length()+1; j++) {
                char sChar = s.charAt(j-1);
                if (tChar == sChar){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

}
