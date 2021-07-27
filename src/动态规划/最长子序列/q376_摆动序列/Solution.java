package 动态规划.最长子序列.q376_摆动序列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/23
 * @Version 1.0
 * @Description
 * 思路：定义计数器，相邻两个值做比较，值是增大还是减小，并进行记录
 *      「峰」到「谷」的下降趋势，down值才会增加
 *      「谷」到「峰」的上升趋势，up值才会增加
 *      遇到上升，用下降值加1，得到上升值，因为题目中说可以删除某些值，
 *      所以遇到一直上升的，用下降值加1是不变的
 *      反之遇到下降，用上升至加1，得到下降值
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null|| nums.length == 0){
            return 0;
        }
        int up = 1;
        int down = 1;
        //nums = [1,17,5,10,13,15,10,5,16,8]
        //这里10和13比较的时候，下降值加1是不变的
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                up = down+1;
            }else if (nums[i]<nums[i-1]){
                down = up+1;
            }
        }

        return Math.max(up,down);
    }
}
