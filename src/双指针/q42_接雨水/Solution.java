package 双指针.q42_接雨水;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/9/15
 * @Version 1.0
 * @Description
 * 思路：双指针
 */
public class Solution {
    //TODO
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length-1;

        int leftMax = 0;
        int rightMax = 0;
        while (left<right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

        }
        return 0;
    }
}
