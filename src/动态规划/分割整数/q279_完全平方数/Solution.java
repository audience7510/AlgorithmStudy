package 动态规划.分割整数.q279_完全平方数;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/22
 * @Version 1.0
 * @Description
 * 思路：i从1开始枚举，等于n结束，j从1开始，j平方等于i结束
 */
public class Solution {
    public int numSquares(int n) {
        //保存个数
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min,arr[i - j*j]);
            }
            arr[i] = min+1;
        }
        return arr[n];
    }
}
