package LeetCode.双指针.q11_盛最多水的容器;

/**
 * @ClassName Solution
 * @Author audience7510
 * @Date 2022/1/6
 * @Description
 * 思路：二分查找，左侧和右侧高度的较小值，乘以左右间隔距离(right-left)
 *      每次遍历得到面积之后，与之前的面积取最大值
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while (left<right){
            int area = Math.min(height[left],height[right]) * (right-left);
            res = Math.max(res,area);
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return res;
    }
}
