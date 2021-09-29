package 双指针.q42_接雨水;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/15
 * @Version 1.0
 * @Description
 * 思路：双指针。下雨之后水能达到的最大高度等于下标i两边的最大高度的最小值，记为 m
 *      下标i处能接的雨水量等于下标 i 处的 m，减去height[i]。
 *
 *      左右两个指针，从左、右两端遍历。下标 i 处能接到的雨水量
 *      由leftMax和rightMax的最小值决定
 */
public class Solution {
    public int trap(int[] height) {
        //总计
        int res = 0;
        //左指针
        int left = 0;
        //右指针
        int right = height.length-1;
        //左侧最大值
        int leftMax = 0;
        //右侧最大值
        int rightMax = 0;
        while (left<right){
            //拿到左侧最大值
            leftMax = Math.max(leftMax,height[left]);
            //拿到右侧最大值
            rightMax = Math.max(rightMax,height[right]);
            //哪边高度低，哪边的最小值减去height[i]
            if (height[left]<height[right]){
                res += leftMax - height[left];
                left++;
            }else {
                res += rightMax-height[right];
                right--;
            }

        }
        return res;
    }
}
