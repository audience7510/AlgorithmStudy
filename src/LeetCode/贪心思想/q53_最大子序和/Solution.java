package LeetCode.贪心思想.q53_最大子序和;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：两个变量，sum为相加的和，max为最大的和
 *      首先：遍历数组，如果sum大于0，说明正数已经出现，sum已经被赋值了，
 *      sum与max取最大，并赋值给max，那么max与sum相等
 *      出现之后加上遍历出来的元素，
 *      遍历出来的元素无论正负，与sum相加，Math.max取的最大值，i为正，max变大
 *      i为负，max不变
 *      其次：若sum一直小于等于0，那么i赋值给sum，max与sum取最大值，
 *      就相当于是取数组中的最大值
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //记录相加的和
        int sum = 0;
        //记录最大值
        int max = nums[0];
        for (int i : nums) {
            //如果sum大于0，说明相加能够增大和
            if (sum>0){
                sum = sum+i;
            }else {
                //如果不大于0，则赋值当前元素
                sum = i;
            }
            //取两者大的
            max = Math.max(max,sum);
        }
        return max;
    }
}
