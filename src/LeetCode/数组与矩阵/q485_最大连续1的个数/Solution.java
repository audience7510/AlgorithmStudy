package LeetCode.数组与矩阵.q485_最大连续1的个数;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/19
 * @Version 1.0
 * @Description
 * 思路：对1出现的次数计数，并记录最大次数
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            //如果为1，计数加1
            if (num == 1){
                cur++;
            }else {
                //不为1，说明1中断了连续的状态，当前连续数和之前的取最大
                max = Math.max(max,cur);
                //计数归零
                cur = 0;
            }
        }
        //最后遍历结束再比较一次，因为可能是以1结尾
        max = Math.max(max,cur);
        return max;
    }
}
