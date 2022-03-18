package LeetCode.排序.快速排序.q912_排序数组;

/**
 * @ClassName Solution2
 * @Author audience7510
 * @Date 2022/3/18
 * @Version 1.0
 * @Description 思路：快速排序写法方式2，与 q215_数组中的第K个最大元素 写法一样
 */
public class Solution2 {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (nums==null || nums.length==0 || left>=right){
            return;
        }
        int temp = nums[left];
        int i = left;
        int j = right;
        while (i<j){
            while (i<j && nums[j]>=temp){
                j--;
            }
            while (i<j && nums[i]<=temp){
                i++;
            }
            swap(nums,i,j);
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
