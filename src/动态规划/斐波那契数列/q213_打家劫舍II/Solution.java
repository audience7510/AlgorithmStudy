package 动态规划.斐波那契数列.q213_打家劫舍II;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/21
 * @Version 1.0
 * @Description
 * 思路：数组长度length，偷第一间，那么偷的房屋索引下标是[0,length-2]，
 *      length-1为最后一间，因为是环形，不能与第一间相邻
 *      不偷第一间下标为[1,length-1]
 *      状态转移方程：dp[i]=max(dp[i−2]+nums[i],dp[i−1])
 *      根据两种下标，和状态转移方程求出最大值
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums == null||nums.length == 0){
            return 0;
        }
        if (nums.length ==1){
            return nums[0];
        }else if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        //偷第一间
        int first = robRange(nums,0,nums.length-2);
        int second = robRange(nums,1,nums.length-1);
        return Math.max(first,second);
    }

    public int robRange(int[] nums, int start, int end) {
        //与q198类似
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);
        //索引开始位置+2，等于end是因为索引可以访问到nums.length-1或nums.length-2
        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(first+nums[i],second);
            first = temp;
        }

        return second;
    }
}
