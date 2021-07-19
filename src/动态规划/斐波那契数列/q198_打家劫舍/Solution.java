package 动态规划.斐波那契数列.q198_打家劫舍;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：
 */
public class Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {

            int cur = Math.max(pre+nums[i],next);

        }

        return 0;
    }
}
