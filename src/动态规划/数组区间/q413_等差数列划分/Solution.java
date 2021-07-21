package 动态规划.数组区间.q413_等差数列划分;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/21
 * @Version 1.0
 * @Description
 * 思路：等差数列 当nums[i]-nums[i-1] == nums[i-1]-nums[i-2]时，为等差数列
 *      使用数组记录，索引为i时的等差数列的个数，当遍历完成之后，
 *      dp[nums.length-1]并不是总的等差数列的个数，
 *      原因是因为并不是每个索引处的值 都可以构成等差数据
 *      当有一处不能构成等差数列时，dp[i]=0
 *      那么i处索引之后的dp数组，不能叠加到之前的等差数列的个数
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //创建数组 记录在nums索引i处，等差数列的个数
        int[] dp = new int[nums.length];
        //使用sum 记录等差数列的总数
        int sum = 0;
        for (int i = 2; i < nums.length; i++) {
            //是等差数列
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                //索引为i时，等差数列的个数
                dp[i] = dp[i-1]+1;
                //记录总的等差数列个数
                sum +=dp[i];
            }
        }
        return sum;
    }
}
