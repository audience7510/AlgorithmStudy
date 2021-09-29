package LeetCode.数组与矩阵.q283_移动零;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/18
 * @Version 1.0
 * @Description
 * 思路：LeetCode.双指针，右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移
 *      例如数组[1,2,0,0,1]，左指针的左侧都是非0，右指针的左侧至左指针，都是0
 *      每次交换，都是将左指针的零与右指针的非零数交
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        //右指针小于length
        while (right<nums.length){
            //如果右指针不为0，当左右指针相等时，交换(其实相当于没交换)
            //左右指针都相加
            //如果右指针为0，左指针不变，右指针加1
            //直到遇到右指针不为0，左右交换，左右指针都向后加1
            if (nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
