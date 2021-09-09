package 二分查找.q704_二分查找;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/9
 * @Version 1.0
 * @Description
 * 二分查找
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = (right-left)/2+left;
            int num = nums[mid];
            if (num>target){
                right--;
            }else if (num<target){
                left++;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
