package 栈和队列.q503_下一个更大元素II;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/16
 * @Version 1.0
 * @Description
 * 思路：1、暴力匹配时间复杂度O(n^2)
 *      2、单调栈+循环数组，循环数组考虑数组长度取模实现
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        //为数组赋默认值-1，因为如果没有更大的值就取-1 所以默认直接用-1填满数组
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        //遍历数组长度的两倍，取模得到下标，相当于循环
        for (int i = 0; i < n * 2 - 1; i++) {
            //若栈顶比遍历的当前值小
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i%n]){
                //1、栈顶元素出栈 2、res数组赋值 3、赋的值就是下一个更大元素
                //4、下一个更大元素就是下标取模的元素
                res[stack.pop()] = nums[i%n];
            }
            //比栈顶值小，入栈
            stack.push(nums[i%n]);
        }
        return res;
    }
}
