package LeetCode.栈和队列.q739_每日温度;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Author audience
 * @Date 2021/8/13
 * @Version 1.0
 * @Description
 * 思路：维护一个存储下标(数组索引)的递减栈，从栈底到栈顶的下标对应数组中的温度依次递减。
 *      比对当前元素 与 栈顶元素的大小
 *      若当前元素 < 栈顶元素，入栈
 *      若当前元素 > 栈顶元素，栈顶元素出栈，记录二者下标的差值，即为所求的天数
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        //要返回的天数数组
        int[] days = new int[n];
        //递减栈
        Stack<Integer> stack = new Stack();
        //遍历temperatures数组
        for (int i = 0; i < n; i++) {
            //当前元素
            int t = temperatures[i];
            //当前元素大于栈顶元素，升温
            while (!stack.isEmpty() && t > temperatures[stack.peek()]){
                //取出栈顶的下标
                Integer pop = stack.pop();
                //下标相减，并赋值天数数组
                days[pop] = i - pop;
            }
            //小于则将当前元素下标入栈
            stack.push(i);
        }
        return days;
    }
}
