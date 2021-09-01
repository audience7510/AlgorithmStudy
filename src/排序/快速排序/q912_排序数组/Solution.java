package 排序.快速排序.q912_排序数组;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/1
 * @Version 1.0
 * @Description
 * 思路：快速排序，先拿到一个基准数，交换比基准数大或者小的元素，并返回分割点所在位置
 *      之后再递归调用left到分割点，分割点到right进行排序
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left<right){
            //cut分割数组，将
            int point = cut(nums,left,right);
            quickSort(nums,left,point-1);
            quickSort(nums,point+1,right);
        }
    }

    //
    private int cut(int[] nums, int left, int right) {
        //拿到一个基准数，这里用数组的第一个元素
        int first = nums[left];
        while (left<right){
            //从右向左，比基准数大，right--，否则将其交换到左边来
            while (left<right && nums[right] >= first){
                right --;
            }
            //交换
            swap(nums,left,right);
            //从左向右，比基准数小，left++，否则交换到右边来
            while (left<right && nums[left]<=first){
                left++;
            }
            //交换
            swap(nums,left,right);
        }
        //最后返回分割点所在的位置
        return left;
    }

    //左右两个位置交换
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
