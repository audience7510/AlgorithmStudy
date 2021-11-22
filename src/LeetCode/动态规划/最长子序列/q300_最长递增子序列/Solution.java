package LeetCode.动态规划.最长子序列.q300_最长递增子序列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/22
 * @Version 1.0
 * @Description
 * 思路：最长递增子序列，递增元素不需要在原数组中连续
 *      dp数组中存储的是：索引0，到索引i处，这个区间中递增的个数，这个个数会变大或变小
 *      例如：[10,9,2,4,5,3]，这个数组中，索引3和索引4处的递增个数分别为2和3，索引5处的递增个数为2，
 *      所以遍历结束，dp[nums.length]并不是 自增个数的最大值，
 *      所以用max来存储遍历中的自增个数的最大值
 *      时间复杂度O(n2)，空间复杂度O(n)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        //存储遍历个数的最大值
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            //当前索引，默认给1种方式
            dp[i] = 1;
            //0到i遍历，与之前元素比较大小
            for (int j = 0; j < i; j++) {
                //比之前大说明是递增
                if (nums[i]>nums[j]){
                    //dp[j]+1，前j个递增的，再加一个nums[i]这一个递增的
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            //取遍历中的最大个数
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
