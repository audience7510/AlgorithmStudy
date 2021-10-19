package LeetCode.二分查找.q540_有序数组中的单一元素;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：二分查找，相邻两个数相等，可以看做偶数和奇数相等，mid只取偶数
 *      拿到偶数之后，与后一位判断是否相等，l和r都要两位来加减，保证是偶数
 *      最后循环结束，l == r，得到单个元素返回
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while (l < r){
            int mid = l + (r-l)/2;
            //与2取余数，余1是奇数
            if (mid%2 ==1){
                //得到偶数
                mid--;
            }
            //例如nums[0] == nums[1]
            if (nums[mid] == nums[mid+1]){
                //加两位保证偶数
                l = mid+2;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }
}
