package LeetCode.数组与矩阵.q33_搜索旋转排序数组;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/6
 * @Version 1.0
 * @Description
 * 思路：二分查找法
 *      1、数组中间分隔，判断那边有序
 *      2、在有序的半段里，判断目标值在不在
 */
public class Solution {
    public static int search(int[] nums, int target) {
        int n = nums.length;
//        if (n == 0){
//            return -1;
//        }
//        if (n == 1){
//            return nums[0] == target? 0:-1;
//        }
        if (n<=1){
            return nums[0] == target? 0:-1;
        }
        int l = 0;
        int r = n-1;
        while (l<=r){
            int mid = (l+r)/2;
//            int mid = l + (r-l)/2;
            if (nums[mid] == target){
                return mid;
            }
            //数组左半部分是有序[4567123] 2
            if (nums[0]<=nums[mid]){
                //target在0和mid中间
                if (nums[0]<=target && target<nums[mid]){
                    //0到mid-1找target
                    r = mid-1;
                }else {
                    //mid+1到length-1找target
                    l = mid+1;
                }
            }
            //右半部分是有序
            else {
                //target在mid和length-1之间
                if (nums[mid]<target && target<=nums[n-1]){
                    //在mid+1和length-1之间找target
                    l = mid+1;
                }else {
                    //在0和mid-1之间找target
                    r = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};
        int search = search(arr, 3);
        System.out.println(search);
    }
}

