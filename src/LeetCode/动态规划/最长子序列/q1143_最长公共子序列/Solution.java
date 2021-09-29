package LeetCode.动态规划.最长子序列.q1143_最长公共子序列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/27
 * @Version 1.0
 * @Description
 * 思路：创建二维数组保存最长公共子序列的长度
 *      当字符相等时，状态转移方程：dp[i][j] = dp[i-1][j-1]+1
 *      当字符串不相等时：dp[i][j] = max(dp[i-1][j],dp[i][j-1])
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //二维数组长度为两个字符串的长度+1,并存储最大值
        int[][] arr = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n ; j++) {
                //如果字符相等
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    //将长度+1
                    arr[i][j] = arr[i-1][j-1]+1;
                }else {
                    //不相等，取二者最大的一个
                    arr[i][j] = Math.max(arr[i][j-1],arr[i-1][j]);
                }
            }
        }

        return arr[m][n];
    }
}
