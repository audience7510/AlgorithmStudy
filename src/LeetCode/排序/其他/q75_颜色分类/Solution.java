package LeetCode.排序.其他.q75_颜色分类;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/7/14
 * @Version 1.0
 * @Description
 * 思路：对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 00 交换到数组的头部。
 * 在第二次遍历中，我们将数组中所有的 11 交换到头部的 00 之后。
 * 此时，所有的 22 都出现在数组的尾部，这样我们就完成了排序
 *
 */
public class Solution {
    public static void sortColors(int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                int temp = nums[i];
                //头元素放到i位置
                nums[i] = nums[pre];
                //i位置的元素放到头
                nums[pre] = temp;
                //交换一个元素，向后移动一位
                pre++;
            }
        }
        for (int i = pre; i < nums.length; i++) {
            if (nums[i] == 1){
                int temp = nums[i];
                //头元素放到i位置
                nums[i] = nums[pre];
                //i位置的元素放到头
                nums[pre] = temp;
                //交换一个元素，向后移动一位
                pre++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }
}
