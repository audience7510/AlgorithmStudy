package LeetCode.二分查找.q34_查找第一和最后一个位置;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/16
 * @Version 1.0
 * @Description
 * 思路：遍历查找索引位置和target，时间复杂度O(n)
 *      二分查找，时间复杂度O(logn)
 *      使用二分法，先找出target最左位置，由于是有序数组，找出target+1的最左位置last，
 *      然后last-1就是target最右位置
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //找target最左位置
        int left = findLeft(nums, target);
        //找target+1最左位置
        int right = findLeft(nums, target+1)-1;
        //没找到返回
        if (left == nums.length || nums[left] !=target){
            return new int[]{-1,-1};
        }
        return new int[]{left,right};
    }

    public int findLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r){
            int mid = l + (r-l)/2;
            if (nums[mid] >= target){
                r = mid;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
