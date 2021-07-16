package 二分查找.q153_寻找旋转排序数组中的最小值;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            int mid = l + (r-l)/2;
            if (nums[mid]<nums[r]){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return nums[l];
    }
}
