package LeetCode.双指针.q31_下一个排列;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/24
 * @Version 1.0
 * @Description
 * 思路：题目含义是--数组[123]看做整数123，下一个比123大的数是132，321也比123大，但不是紧邻的下一个
 *      如果是[321]，即321，没有比321大的数，需要返回123最小的数
 *
 *      1、解题需要左边的「较小数」与一个右边的「较大数」交换，保证排列的值是增大的
 *      2、[较小数]尽量靠右，[较大数]尽量小，保证交换完的值增幅小。
 *      3、[较大数]右边的数需要按照升序排序，目的也是保证交换完的增幅小
 */
public class Solution {
    public static void nextPermutation(int[] nums) {
        //防止索引越界987669
        int i = nums.length-2;
        //从后向前遍历 低位到高位(类似于个位到十位)
        //循环 一直到i索引值 >= i+1索引值为false，即i索引值小于i+1索引值 跳出循环
        //这个nums[i]就是[最小数]的要交换的位置
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //[4,5,2,6,3,1]
        if (i>=0){
            int j = nums.length-1;
            //再从后向前遍历，得到[较大数]
            while (j>=0 && nums[i]>=nums[j]){
                j--;
            }
            //交换较小和较大数
            swap(nums,i,j);
        }
        //i和j交换之后，根据第一个while循环，i+1之后的是降序，要翻转成升序
        //若i<0了，即第一个while循环结束，没有nums[i]<nums[i+1]的，那么数组是最大的，直接翻转成最小的
        reverse(nums,i+1);
    }

    public static void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        nextPermutation(new int[]{4,5,2,6,3,1});
    }
}
