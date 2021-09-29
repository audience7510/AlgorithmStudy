package LeetCode.贪心思想.q665_非递减数列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/15
 * @Version 1.0
 * @Description
 * 思路：当 i-1>i时，那么就出现了递减，为了不让它递减，就需要增大i，或者缩小i-1
 *      如果增大i，那么i可能比i+1大，就又出现了递减，所以缩小i-1，让i-1 = i
 *      特殊情况 是i-2>i，比如342，让i-1 = i，就出现了322，还是递减
 *      所以当i-2>i是，让i = i-1，就是344，就不是递减了
 */
public class Solution {
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            //如果不是递减，那么跳过本地循环
            if (nums[i]>=nums[i-1]){
                continue;
            }
            //是递减次数就加1
            count++;
            //出现了i-1>i，并且出现了i-2>i的情况，(如342)让i = i-1
            if (i-2 >=0 && nums[i-2] > nums[i]){
                nums[i] = nums[i-1];
            }else {
                //只是出现了i-1>i，(如243)，让i-1 = i
                nums[i-1] = nums[i];
            }
        }
        return count<=1;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,1};
        boolean b = checkPossibility(arr);
    }
}
