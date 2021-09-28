package 双指针.q31_下一个排列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/24
 * @Version 1.0
 * @Description
 */
public class Solution {
    //TODO
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0 && nums[i]>nums[i+1]){
            i--;
        }
        if (i>=0){
            int j = nums.length-1;
            while (j>=0 && nums[i]>=nums[j]){
                j--;
            }

        }
    }
}
