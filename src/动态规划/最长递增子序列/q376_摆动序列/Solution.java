package 动态规划.最长递增子序列.q376_摆动序列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/23
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null|| nums.length == 0){
            return 0;
        }
        int up = 1;
        int down = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                up = down+1;
            }else if (nums[i]<nums[i-1]){
                down = up+1;
            }
        }

        return Math.max(up,down);
    }
}
