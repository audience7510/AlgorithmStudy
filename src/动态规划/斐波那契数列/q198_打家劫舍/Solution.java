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
    /**
     * 方式1，数组存储偷的金额
     */
    public int rob(int[] nums) {
        //没有房间可偷，所以偷的金额是0
        if (nums ==null || nums.length ==0){
            return 0;
        }
        //只有一个房间，只能偷第一间
        if (nums.length == 1){
            return nums[0];
        }
        //用数组存储，每次偷钱的和（空间可以优化，只存储i-1和i-2的值）
        int[] dp = new int[nums.length];
        //一间房子 偷的最大值
        dp[0] = nums[0];
        //两间房子 偷的最大值
        dp[1] =Math.max(nums[0], nums[1]);
        //从第三件房子开始
        for (int i = 2; i < nums.length; i++) {
            //dp[i]=max(dp[i−2]+nums[i],dp[i−1])
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        //房子偷到最后的和，为最大值
        return dp[nums.length-1];
    }

    /**
     * 方式2，只存储i-1和i-2
     */
    public int rob2(int[] nums) {
        //没有房间可偷，所以偷的金额是0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //只有一个房间，只能偷第一间
        if (nums.length == 1) {
            return nums[0];
        }
        //只偷一间最大值
        int first = nums[0];
        //两间最大值,即i=1，最大值
        int second = Math.max(nums[0], nums[1]);
        //for循环从2开始
        for (int i = 2; i < nums.length; i++) {
            //暂存一下i-1位置的值
            int temp = second;
            //当前i的最大值，(i-2+nums[i])与(i-1)二者去较大，赋值给second
            //那么second对于下次遍历来说，就是(i-1)的最大值
            second = Math.max(first+nums[i],second);
            //temp是i-1的值，赋值给first，就是赋值给i-2，相当于i-2的位置后移动了一位
            first = temp;
        }
        return second;
    }
    /**
     * 方式3，来源CS-Notes
     */
    public int rob3(int[] nums) {
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
