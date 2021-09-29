package LeetCode.动态规划.数组区间.q303_区域和检索_数组不可变;

/**
 * @ClassName NumArray
 * @Author audience
 * @Date 2021/7/21
 * @Version 1.0
 * @Description
 * 思路：求索引i到索引j的和，可以转换成sum[j+1]-sum[i]，sun[i]为0到i-1的和
 *      因为题目中的相加，包含了索引j位置的值和i位置的值
 *      而方法NumArray的求和，是求的到i-1位置的，
 *      想要包含到j，那么j就必须加1
 */
public class NumArray {

    //创建sum，用于保存相加之和
    int[] sum;
    public NumArray(int[] nums) {
        //初始化sum，长度为nums长度加1，
        sum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            //保存相加之后的和，保存到i-1的位置
            sum[i] = sum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        //right加1才能求出到right的和
        return sum[right+1]-sum[left];
    }
}
